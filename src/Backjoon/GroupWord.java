package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GroupWord {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int result = t;
        for(int c=0; c<t; c++) {
            String word = br.readLine();
            for(int i=0;i<word.length()-1;i++) {
                if(word.charAt(i)==word.charAt(i+1)) {
                    continue;
                }
                if(word.substring(i+2).indexOf(word.charAt(i))>=0) {
                    result --;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
