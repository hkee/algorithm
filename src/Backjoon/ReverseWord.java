package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ReverseWord {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            String wordArr[] = br.readLine().split(" ");
            for(int j = 0;j<wordArr.length;j++) {
                StringBuffer sb = new StringBuffer(wordArr[j]);
                if(j!=0) {
                    System.out.print(" ");
                }
                System.out.print(sb.reverse().toString());
            }
            System.out.println();
        }
        
    }
}
