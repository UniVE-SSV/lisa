package it.unive.lisa.program.cfg.statement;

import it.unive.lisa.program.cfg.CFG;
import it.unive.lisa.program.cfg.CodeLocation;
import it.unive.lisa.program.cfg.edge.Edge;
import it.unive.lisa.util.datastructures.graph.GraphVisitor;
import java.util.Objects;

/**
 * A unary statement.
 * 
 * @author <a href="mailto:luca.negrini@unive.it">Luca Negrini</a>
 */
public abstract class UnaryStatement extends Statement {

	private final Expression expression;

	/**
	 * Builds the unary statement. The location where it happens is unknown
	 * (i.e. no source file/line/column is available).
	 * 
	 * @param cfg        the cfg that this statement belongs to
	 * @param expression the argument of this statement
	 */
	public UnaryStatement(CFG cfg, Expression expression) {
		this(cfg, null, expression);
	}

	/**
	 * Builds the unary statement, happening at the given location in the
	 * program.
	 * 
	 * @param cfg        the cfg that this statement belongs to
	 * @param location   the location where this statement is defined within the
	 *                       source file. If unknown, use {@code null}
	 * @param expression the argument of this statement
	 */
	public UnaryStatement(CFG cfg, CodeLocation location, Expression expression) {
		super(cfg, location);
		Objects.requireNonNull(expression, "The argument of a unary statement cannot be null");
		this.expression = expression;
		expression.setParentStatement(this);
	}

	/**
	 * Yields the expression that is the argument of this unary statement.
	 * 
	 * @return the argument
	 */
	public final Expression getExpression() {
		return expression;
	}

	@Override
	public final int setOffset(int offset) {
		this.offset = offset;
		return expression.setOffset(offset + 1);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((expression == null) ? 0 : expression.hashCode());
		return result;
	}

	@Override
	public boolean isEqualTo(Statement st) {
		if (this == st)
			return true;
		if (getClass() != st.getClass())
			return false;
		UnaryStatement other = (UnaryStatement) st;
		if (expression == null) {
			if (other.expression != null)
				return false;
		} else if (!expression.isEqualTo(other.expression))
			return false;
		return true;
	}

	@Override
	public final <V> boolean accept(GraphVisitor<CFG, Statement, Edge, V> visitor, V tool) {
		if (!expression.accept(visitor, tool))
			return false;
		return visitor.visit(tool, getCFG(), this);
	}
}
