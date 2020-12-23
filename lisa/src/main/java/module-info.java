module it.unive.lisa {
	requires java.base;
	
	requires transitive org.apache.logging.log4j;
	requires org.apache.commons.lang3;
	requires org.apache.commons.text;
	requires com.fasterxml.jackson.databind;
	requires gs.core;
	
	exports it.unive.lisa;
	
	exports it.unive.lisa.cfg;
	exports it.unive.lisa.cfg.type;
	exports it.unive.lisa.cfg.statement;
	exports it.unive.lisa.cfg.edge;

	exports it.unive.lisa.callgraph;

	exports it.unive.lisa.analysis;
	exports it.unive.lisa.analysis.impl.types;
	
	exports it.unive.lisa.checks;
	exports it.unive.lisa.checks.syntactic;
	exports it.unive.lisa.checks.warnings;
	
	exports it.unive.lisa.symbolic;
	exports it.unive.lisa.symbolic.heap;
	exports it.unive.lisa.symbolic.value;
	
	exports it.unive.lisa.logging;

	exports it.unive.lisa.outputs;
	exports it.unive.lisa.outputs.compare;
	
	opens it.unive.lisa.outputs to com.fasterxml.jackson.databind;
}