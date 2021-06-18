package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Palindrome {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuffer r = new StringBuffer(input);
        if(input.equals(r.reverse().toString())) {
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }
}
