package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PlindromeNumber {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String num = br.readLine();
            if(num.equals("0")) {
                break;
            }
            String result = "yes";
            for(int i=0;i<num.length()/2;i++) {
                if(num.charAt(i)!=num.charAt(num.length()-1-i)) {
                    result = "no";
                    break;
                }
            }
            System.out.println(result);

        }
    }
}
