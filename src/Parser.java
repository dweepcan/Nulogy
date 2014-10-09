public class Parser {
	static double parseBasePrice(String basePriceString) {
		if(!basePriceString.startsWith("$")) {
			System.err.println("The base price entered does not begin with a $ sign.");
			System.exit(1);
		}

		String basePriceNum = basePriceString.substring(1, basePriceString.length());

		int basePriceDecimal = basePriceNum.indexOf('.');

		if(basePriceDecimal == -1 || basePriceNum.substring(basePriceDecimal+1).length() != 2) {
			System.err.println("The base price entered is not a dollar amount with 2 decimal places.");
			System.exit(1);
		}
		
		double basePrice = 0;

		try {
			basePrice = Double.parseDouble(basePriceNum);
		} catch(Exception e) {
			System.err.println("The base price entered is not a decimal number.");
			System.exit(1);
			e.printStackTrace();
		}
		
		if(basePrice < 0) {
			System.err.println("The base price entered is negative.");
			System.exit(1);
		} else if (basePrice == 0) {
			System.err.println("The base price entered is zero");
		}
		
		return basePrice;
	}
}