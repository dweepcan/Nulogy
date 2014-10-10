import static org.junit.Assert.*;

import org.junit.Test;


public class InvalidBasePrice {

	@Test (expected = Exception.class)
	public void testInteger() throws Exception {
		NuPack tester = new NuPack();

		String basePriceString = "$123";

		double basePrice = Parser.parseBasePrice(basePriceString);
	}
	
	@Test (expected = Exception.class)
	public void testString() throws Exception {
		NuPack tester = new NuPack();

		String basePriceString = "$asd";

		double basePrice = Parser.parseBasePrice(basePriceString);
	}

}
