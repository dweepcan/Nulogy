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
	 * @throws Exception
	 */
	public static double parseBasePrice(String basePriceString) throws Exception {
		// Check if the base price entered starts with a $ sign
		if(!basePriceString.startsWith("$")) {
			System.err.println("The base price entered does not begin with a $ sign.");
			throw new Exception();
		}
		
		// Removing the $ sign form the string of base price
		String basePriceNum = basePriceString.substring(1, basePriceString.length());
		
		// Finding the location of the decimal point in the base price value
		int basePriceDecimal = basePriceNum.indexOf('.');

		// Check if the base price entered is a dollar amount with 2 decimals.
		if(basePriceDecimal == -1 || basePriceNum.substring(basePriceDecimal+1).length() != 2) {
			System.err.println("The base price entered is not a dollar amount with 2 decimal places.");
			throw new Exception();
		}
		
		double basePrice = 0.0;

		// Check if the base price entered is a decimal value
		try {
			basePrice = Double.parseDouble(basePriceNum);
		} catch(Exception e) {
			System.err.println("The base price entered is not a decimal number.");
			e.printStackTrace();
			throw new Exception();
		}
		
		// Check if the base price entered is negative
		if(basePrice < 0) {
			System.err.println("The base price entered is negative.");
			throw new Exception();
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
	 * @throws Exception 
	 */
	public static int parseWorkers(String workersString) throws Exception {
		// Finding the location of the space in the workers value
		int workersStringSpace = workersString.indexOf(" ");
		
		// Check if the workers value entered has a space between the number and person/people. 
		if(workersStringSpace == -1) {
			System.err.println("The number of workers entered does not contain a space between the number and person/people.");
			throw new Exception();
		}
		
		// Removing the numerical value of the number of workers from the string
		String workersNum = workersString.substring(0, workersString.indexOf(" "));
		int workers = 0;
		
		// Check if the workers value entered is a whole number. 
		try {
			// Convert the worker value given to a integer.
			workers = Integer.parseInt(workersNum);
		} catch(Exception e) {
			System.err.println("The number of workers entered is not a integer.");
			e.printStackTrace();
			throw new Exception();
		}
		
		// Check if the workers value entered is negative.
		if(workers < 0) {
			System.err.println("The number of workers entered is negative.");
			throw new Exception();
		} 
		// Check if the workers value entered is zero. 
		else if (workers == 0) {
			System.err.println("The number of workers entered is zero");
		}
		
		// Removing the word part of the number of workers value given (i.e. people/person)
		String workersAfterNum = workersString.substring(workersString.indexOf(" ")).trim().toLowerCase();
		
		// Check if the workers value entered is contains a word other than people or person after the number. 
		if(!workersAfterNum.equals("people") && !workersAfterNum.equals("person")) {
			System.err.println("The number of workers entered does not have people or person after the number.");
			throw new Exception();
		} 
		// Check if the workers value entered is 1 people, which should be 1 person.
		else if(workers == 1 && workersAfterNum.equals("people")) {
			System.err.println("The number of workers entered is 1 people. Please change this to 1 person.");
			throw new Exception();
		} 
		// Check if the workers value entered is multiple person, which should be multiple people.
		else if((workers > 1 || workers == 0) && workersAfterNum.equals("person")) {
			System.err.println("The number of workers entered has person after the number, even though the number is greater than 1.\n"
					+ "Please change this to <num> people.");
			throw new Exception();
		}
		
		return workers;
	}
	
	/**
	 * The number of workers value entered in standard input is parsed.
	 * Error checking is done on the value entered, and if no errors 
	 * exist the corresponding integer value is returned.
	 * 
	 * @param workersString number of workers given on standard input
	 * @return parsed worker value after converting to integer
	 */
	
	/**
	 * The material entered in standard input is parsed.
	 * 
	 * @param material material involved in the job given on standard input
	 * @return parsed material value after changing the format
	 */
	public static String parseMaterial(String material) {
		return material.toLowerCase();
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
		// Check if the line read from input reader is blank
		while(input.length() == 0) {
			// Read the next line
			input = in.nextLine().trim();
		}
		// Return the first non-empty line
		return input;
	}
}