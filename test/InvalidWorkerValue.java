import static org.junit.Assert.*;

import org.junit.Test;


public class InvalidWorkerValue {

	@Test (expected = Exception.class)
	public void testDouble() throws Exception {
		NuPack tester = new NuPack();

		String workerString = "1.0 person";

		double worker = Parser.parseWorkers(workerString);
	}
	
	@Test (expected = Exception.class)
	public void testString() throws Exception {
		NuPack tester = new NuPack();

		String workerString = "a person";

		double worker = Parser.parseWorkers(workerString);
	}
}
