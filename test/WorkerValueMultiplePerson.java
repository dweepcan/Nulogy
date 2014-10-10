import static org.junit.Assert.*;

import org.junit.Test;


public class WorkerValueMultiplePerson {

	@Test (expected = Exception.class)
	public void testSmall() throws Exception {
		NuPack tester = new NuPack();

		String workerString = "5 person";

		double worker = Parser.parseWorkers(workerString);
	}
	
	@Test (expected = Exception.class)
	public void testLarge() throws Exception {
		NuPack tester = new NuPack();

		String workerString = "100000 person";

		double worker = Parser.parseWorkers(workerString);
	}

}
