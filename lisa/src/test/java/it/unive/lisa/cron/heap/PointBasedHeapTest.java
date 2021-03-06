package it.unive.lisa.cron.heap;

import static it.unive.lisa.LiSAFactory.getDefaultFor;

import it.unive.lisa.AnalysisSetupException;
import it.unive.lisa.AnalysisTestExecutor;
import it.unive.lisa.LiSAConfiguration;
import it.unive.lisa.analysis.AbstractState;
import it.unive.lisa.analysis.impl.heap.pointbased.FieldSensitivePointBasedHeap;
import it.unive.lisa.analysis.impl.heap.pointbased.PointBasedHeap;
import it.unive.lisa.analysis.impl.numeric.Interval;
import org.junit.Test;

public class PointBasedHeapTest extends AnalysisTestExecutor {

	@Test
	public void fieldInsensitivePointBasedHeapTest() throws AnalysisSetupException {
		LiSAConfiguration conf = new LiSAConfiguration().setDumpAnalysis(true).setInferTypes(true)
				.setAbstractState(getDefaultFor(AbstractState.class, new PointBasedHeap(), new Interval()));
		perform("heap/point-based-heap/field-insensitive", "program.imp", conf);
	}

	@Test
	public void fieldSensitivePointBasedHeapTest() throws AnalysisSetupException {
		LiSAConfiguration conf = new LiSAConfiguration().setDumpAnalysis(true).setInferTypes(true)
				.setAbstractState(
						getDefaultFor(AbstractState.class, new FieldSensitivePointBasedHeap(), new Interval()));
		perform("heap/point-based-heap/field-sensitive", "program.imp", conf);
	}
}
