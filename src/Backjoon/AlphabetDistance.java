package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AlphabetDistance {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            String temp[] = br.readLine().split(" ");
            String x = temp[0];
            String y = temp[1];
            int result[] = new int[x.length()];
            System.out.print("Distances: ");
            for(int i=0;i<x.length();i++) {
                if(y.charAt(i)<x.charAt(i)) {
                    result[i] = ((int)y.charAt(i))-38-((int)x.charAt(i)-64);

                }else {
                    result[i] = (int)y.charAt(i)-(int)x.charAt(i);
                }
                System.out.print(result[i]+" ");
            }
            System.out.println();

        }
    }
}
