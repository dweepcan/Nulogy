import static org.junit.Assert.*;

import org.junit.Test;


public class MaterialValueCapitalValues {

	@Test
	public void input1() throws Exception {
		NuPack tester = new NuPack();
		
		String basePriceString = "$1299.99";
		String workersString = "3 people";
		String materialString = "FOOD";
		
		double basePrice = Parser.parseBasePrice(basePriceString);
		int workers = Parser.parseWorkers(workersString);
		String material = Parser.parseMaterial(materialString);
		
		assertEquals(basePrice, 1299.99, 0.005);
		assertEquals(workers, 3);
		assertEquals(material, "food");
		
		assertEquals(MarkupCalculator.calculate(basePrice, workers, material), 1591.58, 0.005);
	}
	
	@Test
	public void input2() throws Exception {
		NuPack tester = new NuPack();

		String basePriceString = "$5432.00";
		String workersString = "1 person";
		String materialString = "DRUGS";

		double basePrice = Parser.parseBasePrice(basePriceString);
		int workers = Parser.parseWorkers(workersString);
		String material = Parser.parseMaterial(materialString);

		assertEquals(basePrice, 5432.00, 0.005);
		assertEquals(workers, 1);
		assertEquals(material, "drugs");

		assertEquals(MarkupCalculator.calculate(basePrice, workers, material), 6199.81, 0.005);
	}
	
	@Test
	public void input3() throws Exception {
		NuPack tester = new NuPack();

		String basePriceString = "$12456.95";
		String workersString = "4 people";
		String materialString = "BOOKS";

		double basePrice = Parser.parseBasePrice(basePriceString);
		int workers = Parser.parseWorkers(workersString);
		String material = Parser.parseMaterial(materialString);

		assertEquals(basePrice, 12456.95, 0.005);
		assertEquals(workers, 4);
		assertEquals(material, "books");

		assertEquals(MarkupCalculator.calculate(basePrice, workers, material), 13707.63, 0.005);
	}
	
	@Test
	public void input4() throws Exception {
		NuPack tester = new NuPack();

		String basePriceString = "$2123456.68";
		String workersString = "546 people";
		String materialString = "ELECTRONICS";

		double basePrice = Parser.parseBasePrice(basePriceString);
		int workers = Parser.parseWorkers(workersString);
		String material = Parser.parseMaterial(materialString);

		assertEquals(basePrice, 2123456.68, 0.005);
		assertEquals(workers, 546);
		assertEquals(material, "electronics");

		assertEquals(MarkupCalculator.calculate(basePrice, workers, material), 16882754.68, 0.005);
	}

}
