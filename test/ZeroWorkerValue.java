import static org.junit.Assert.*;

import org.junit.Test;


public class ZeroWorkerValue {

	@Test
	public void test() throws Exception {
		NuPack tester = new NuPack();

		String basePriceString = "$100.00";
		String workerString = "0 people";
		String materialString = "books";

		double basePrice = Parser.parseBasePrice(basePriceString);
		int workers = Parser.parseWorkers(workerString);
		String material = Parser.parseMaterial(materialString);

		assertEquals(basePrice, 100.00, 0.005);
		assertEquals(workers, 0);
		assertEquals(material, "books");

		assertEquals(MarkupCalculator.calculate(basePrice, workers, material), 105.00, 0.005);
	}

}
