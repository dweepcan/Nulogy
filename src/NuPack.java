import java.util.Scanner;

/**
 * Main class of the program
 *  
 * @author Dweep Shah
 */
public class NuPack {
	public static void main(String[] args) {
		// Initialize standard input
		Scanner in = new Scanner(System.in);
		
		// Ignore any blank lines entered
		String input = Parser.removeBlankLines(in, in.nextLine().trim());
		
		// Parse the given basePrice to get the double value
		double basePrice = Parser.parseBasePrice(input); 
		
		// Ignore any blank lines entered
		input = Parser.removeBlankLines(in, in.nextLine().trim());
		
		// Parse the given workers value to get the integer value
		int workers = Parser.parseWorkers(input);
		
		// Ignore any blank lines entered
		input = Parser.removeBlankLines(in, in.nextLine().trim());
		
		// Store the value entered for material
		String material = input.toLowerCase();
		
		// Calculate the total markup value given the corresponding input
		double total = MarkupCalculator.calculate(basePrice, workers, material);
		
		//Formats the output to 2 decimal places and prints the output
		System.out.println("$" + String.format("%.2f", total));
	}
}
