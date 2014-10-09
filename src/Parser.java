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
		
		double basePrice = 0.0;

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
	
	static int parseWorkers(String workersString) {
		int workersStringSpace = workersString.indexOf(" ");

		if(workersStringSpace == -1) {
			System.err.println("The number of workers entered does not contain a space between the number and person/people.");
			System.exit(1);
		}
		
		String workersNum = workersString.substring(0, workersString.indexOf(" "));
		int workers = 0;
		
		try {
			workers = Integer.parseInt(workersNum);
		} catch(Exception e) {
			System.err.println("The number of workers entered is not a integer.");
			System.exit(1);
			e.printStackTrace();
		}
		
		if(workers < 0) {
			System.err.println("The number of workers entered is negative.");
			System.exit(1);
		} else if (workers == 0) {
			System.err.println("The number of workers entered is zero");
		}
		
		String workersAfterNum = workersString.substring(workersString.indexOf(" ")).trim().toLowerCase();
		
		if(workersAfterNum.equals("people") && workersAfterNum.equals("person")) {
			System.err.println("The number of workers entered does not have people or person after the number.");
			System.exit(1);
		} else if(workers == 1 && workersAfterNum.equals("people")) {
			System.err.println("The number of workers entered is 1 people. Please change this to 1 person.");
			System.exit(1);
		} else if((workers >=1 || workers == 0) && workersAfterNum.equals("person")) {
			System.err.println("The number of workers entered has person after the number, even though the number is greater than 1.\n"
					+ "Please change this to <num> people.");
			System.exit(1);
		}
		
		return workers;
	}
}