import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NuPack {
	public static void main(String[] args) {
		// Open up standard input
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String command;
		try {
			command = input.readLine();
			System.out.println(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
