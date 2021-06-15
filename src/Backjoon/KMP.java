package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KMP {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String word [] = input.split("-");
        for(int i=0;i<word.length;i++) {
            System.out.print(word[i].charAt(0));
        }
        System.out.println();
    }
}
