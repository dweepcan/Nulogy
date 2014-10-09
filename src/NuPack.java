import java.util.Scanner;

/**
 * Main class of the program
 *  
 * @author Dweep
 */
public class NuPack {
	public static void main(String[] args) {
		// Initialize standard input
		Scanner in = new Scanner(System.in);
		
		// Ignore any blank lines entered
		String input = Parser.removeBlankLines(in, in.nextLine().trim());
		
		// Parse the given basePrice to get the double value
		double basePrice = Parser.parseBasePrice(input); 
		System.out.println(basePrice);
		
		// Ignore any blank lines entered
		input = Parser.removeBlankLines(in, in.nextLine().trim());
		
		// Parse the given workers value to get the integer value
		int workers = Parser.parseWorkers(input);
		System.out.println(workers);
		
		// Ignore any blank lines entered
		input = Parser.removeBlankLines(in, in.nextLine().trim());
		
		// Store the value entered for material
		String material = in.nextLine().trim();
		System.out.println(material);
	}
}
