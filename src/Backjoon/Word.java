import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Word {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		input = input.toUpperCase();
		char inputArr[] = input.toCharArray();
		Arrays.sort(inputArr);
		int originMax = -1;
		int max = 0;
		char target = '0';
		char result='0';
		ArrayList<Character> sameCount = new ArrayList();
		for(int i=0;i<inputArr.length;i++) {
			if(target!=inputArr[i]){
				if(max>originMax) {
					originMax = max;
					sameCount.clear();
					result = target;
				}else if(max==originMax) {
					sameCount.add(target);
					sameCount.add(inputArr[i]);
				}
				target=inputArr[i];
				max=0;
			}
			max++;
		}
		if(max>originMax) {
			originMax = max;
			sameCount.clear();
			result = target;
		}else if(max==originMax) {
			sameCount.add(target);
			sameCount.add(inputArr[inputArr.length-1]);
		}
		if(sameCount.size() > 0) {
			System.out.println('?');
		}else {
			System.out.println(result);
		}
	}

}
