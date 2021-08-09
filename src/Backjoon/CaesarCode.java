package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CaesarCode {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<input.length();i++) {
            if('A'==input.charAt(i)) {
                sb.append('X');
            }else if('B'==input.charAt(i)) {
                sb.append('Y');
            }else if('C'==input.charAt(i)) {
                sb.append('Z');
            }else {
                sb.append((char)(input.charAt(i)-3));
            }
        }
        System.out.println(sb.toString());
    }
}
