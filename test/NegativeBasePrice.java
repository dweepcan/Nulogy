import static org.junit.Assert.*;

import org.junit.Test;


public class NegativeBasePrice {

	@Test (expected = Exception.class)
	public void test() throws Exception {
		NuPack tester = new NuPack();

		String basePriceString = "$-1.00";

		double basePrice = Parser.parseBasePrice(basePriceString);
	}
	
}
