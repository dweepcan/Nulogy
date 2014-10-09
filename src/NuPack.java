import java.util.Scanner;

public class NuPack {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		double basePrice = Parser.parseBasePrice(in.nextLine().trim()); 
		
		System.out.println(basePrice);
	}
}
