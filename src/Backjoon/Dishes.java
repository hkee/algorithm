package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Dishes {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char pre = input.charAt(0);
        int result = 10;
        for(int i=1;i<input.length();i++) {
            if(pre == input.charAt(i)) {
                result+=5;
            }else {
                result+=10;
            }
            pre = input.charAt(i);
        }
        System.out.println(result);

    }
}
