import java.util.Scanner;

/**
 * Class used to parse the input given and check for any invalid input values.
 * 
 * @author Dweep
 */
public class Parser {
	/**
	 * The base price value entered in standard input is parsed.
	 * Error checking is done on the value entered, and if no errors 
	 * exist the corresponding double value is returned.
	 * 
	 * @param basePriceString Base Price given on standard input
	 * @return parsed base price value after converting to double
	 */
	public static double parseBasePrice(String basePriceString) {
		// Check if the base price entered starts with a $ sign
		if(!basePriceString.startsWith("$")) {
			System.err.println("The base price entered does not begin with a $ sign.");
			System.exit(1);
		}

		String basePriceNum = basePriceString.substring(1, basePriceString.length());

		int basePriceDecimal = basePriceNum.indexOf('.');

		// Check if the base price entered is a dollar amount with 2 decimals.
		if(basePriceDecimal == -1 || basePriceNum.substring(basePriceDecimal+1).length() != 2) {
			System.err.println("The base price entered is not a dollar amount with 2 decimal places.");
			System.exit(1);
		}
		
		double basePrice = 0.0;

		// Check if the base price entered is a decimal value
		try {
			basePrice = Double.parseDouble(basePriceNum);
		} catch(Exception e) {
			System.err.println("The base price entered is not a decimal number.");
			System.exit(1);
			e.printStackTrace();
		}
		
		// Check if the base price entered is negative
		if(basePrice < 0) {
			System.err.println("The base price entered is negative.");
			System.exit(1);
		} 
		// Check if the base price entered is zero
		else if (basePrice == 0) {
			System.err.println("The base price entered is zero");
		}
		
		return basePrice;
	}
	
	/**
	 * The number of workers value entered in standard input is parsed.
	 * Error checking is done on the value entered, and if no errors 
	 * exist the corresponding integer value is returned.
	 * 
	 * @param workersString number of workers given on standard input
	 * @return parsed worker value after converting to integer
	 */
	public static int parseWorkers(String workersString) {
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
		
		if(!workersAfterNum.equals("people") && !workersAfterNum.equals("person")) {
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
	
	/**
	 * Skips all of the blank lines and returns the first non
	 * empty line read from the given InputReader
	 * 
	 * @param in Input Reader used to read the input
	 * @param input the last input line read from the input reader
	 * @return the first non empty line read by the input reader
	 */
	public static String removeBlankLines(Scanner in, String input) {
		while(input.length() == 0) {
			input = in.nextLine().trim();
		}
		return input;
	}
}