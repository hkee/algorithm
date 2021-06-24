package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DifferenceString {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        String a = input[0];
        String b = input[1];
        int diff = b.length()-a.length();
        String startExtra = b.substring(0, diff);
        String endExtra = b.substring(b.length()-diff,b.length());
        int min = Integer.MAX_VALUE;
        for(int i=0;i<=diff;i++) {
            int c = 0;
            String newA = startExtra.substring(0,diff-i)+a+endExtra.substring(diff-i,diff);
            for(int j=0;j<b.length();j++) {
                if(newA.charAt(j)!=b.charAt(j)) {
                    c++;
                    if(c>min) {
                        break;
                    }
                }
            }
            if(min>c) {
                min = c;
            }
        }
        System.out.println(min);


    }
}
