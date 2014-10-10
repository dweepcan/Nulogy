import static org.junit.Assert.*;

import org.junit.Test;


public class ZeroBasePrice {

	@Test
	public void test() throws Exception {
		NuPack tester = new NuPack();

		String basePriceString = "$0.00";
		String workersString = "1 person";
		String materialString = "drugs";

		double basePrice = Parser.parseBasePrice(basePriceString);
		int workers = Parser.parseWorkers(workersString);
		String material = Parser.parseMaterial(materialString);

		assertEquals(basePrice, 0.00, 0.005);
		assertEquals(workers, 1);
		assertEquals(material, "drugs");

		assertEquals(MarkupCalculator.calculate(basePrice, workers, material), 0.00, 0.005);
	}

}
