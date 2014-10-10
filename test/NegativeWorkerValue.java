import static org.junit.Assert.*;

import org.junit.Test;


public class NegativeWorkerValue {

	@Test (expected = Exception.class)
	public void test() throws Exception {
		NuPack tester = new NuPack();

		String workerString = "-1 person";

		double worker = Parser.parseWorkers(workerString);
	}

}
