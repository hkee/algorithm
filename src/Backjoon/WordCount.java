package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class WordCount {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        input=input.trim();
        if(input.equals("")) {
            System.out.println(0);
        }else {
            String word[] = input.split(" ");
            System.out.println(word.length);
        }
        
    }
    
}
