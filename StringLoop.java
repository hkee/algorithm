import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringLoop {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String input[]= br.readLine().split(" ");
			for(int l=0;l<input[1].length();l++) {
				for(int c=0;c<Integer.parseInt(input[0]);c++) {
					System.out.print(input[1].charAt(l));
				}
			}
			System.out.println();
		}

	}

}
