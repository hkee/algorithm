package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinaryAndOctal {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if(input.length()%3==2) {
            input = "0"+input;
        }else if(input.length()%3==1) {
            input = "00"+input;
        }
        StringBuilder result = new StringBuilder();
        for(int i=0;i<input.length();i+=3) {
            result.append(convert(input.substring(i, i+3)));
        }
        System.out.println(result.toString());

    }
    public static String convert(String s) {
        String r;
        if(s.equals("000")) {
            r = "0";
        }else if(s.equals("001")) {
            r = "1";
        }else if(s.equals("010")) {
            r = "2";
        }else if(s.equals("011")) {
            r = "3";
        }else if (s.equals("100")) {
            r = "4";
        }else if(s.equals("101")) {
            r = "5";
        }else if(s.equals("110")) {
            r = "6";
        }else {
            r = "7";
        }
        return r;
    }
}
