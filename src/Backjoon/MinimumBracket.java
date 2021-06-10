package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MinimumBracket {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String num[] = input.split("[+-]");
        String operator[] = input.split("[0-9]+");
        int result = Integer.parseInt(num[0]);
        boolean minusFlag = false;
        for(int i=1;i<operator.length;i++) {
            if(minusFlag) {
                result -= Integer.parseInt(num[i]);
            }else {
                if(operator[i].equals("+")) {
                    result += Integer.parseInt(num[i]);
                }else {
                    result -= Integer.parseInt(num[i]);
                    minusFlag = true;
                }
            }
        }
        System.out.println(result);
    }
}
