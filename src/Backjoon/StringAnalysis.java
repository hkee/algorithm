package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringAnalysis {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while((input=br.readLine())!=null) {
            int upper = 0;
            int lower = 0;
            int number = 0;
            int vacuum = 0;
            input = input.replaceAll("[0-9]", "!").replaceAll("[a-z]","@").replaceAll("[A-Z]", "#").replaceAll(" ", "%");
            for(int i=0;i<input.length();i++) {
                if(input.charAt(i)=='!') {
                    number++;
                }else if(input.charAt(i)=='@') {
                    lower++;
                }else if(input.charAt(i)=='#') {
                    upper++;
                }else {
                    vacuum++;
                }
            }
            System.out.println(lower + " "+ upper+ " "+number + " "+vacuum);

        }
    }
}
