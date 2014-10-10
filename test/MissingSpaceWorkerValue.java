import static org.junit.Assert.*;

import org.junit.Test;


public class MissingSpaceWorkerValue {

	@Test (expected = Exception.class)
	public void testMultiple() throws Exception {
		NuPack tester = new NuPack();

		String workerString = "5people";

		double worker = Parser.parseWorkers(workerString);
	}
	
	@Test (expected = Exception.class)
	public void testOne() throws Exception {
		NuPack tester = new NuPack();

		String workerString = "1person";

		double worker = Parser.parseWorkers(workerString);
	}
}
