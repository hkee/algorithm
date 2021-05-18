package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Dial {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int result = 0;
        for(int i=0;i<input.length();i++) {
            if("ABC".indexOf(input.charAt(i))>-1) {
                result+=3;
            }else if("DEF".indexOf(input.charAt(i))>-1) {
                result+=4;
            }else if("GHI".indexOf(input.charAt(i))>-1) {
                result+=5;
            }else if("JKL".indexOf(input.charAt(i))>-1) {
                result+=6;
            }else if("MNO".indexOf(input.charAt(i))>-1) {
                result+=7;
            }else if("PQRS".indexOf(input.charAt(i))>-1) {
                result+=8;
            }else if("TUV".indexOf(input.charAt(i))>-1) {
                result+=9;
            }else if("WXYZ".indexOf(input.charAt(i))>-1) {
                result+=10;
            }
        }
        System.out.println(result);

    }
}
