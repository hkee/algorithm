package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bridge {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t=0; t<tc; t++) {
            String temp[] = br.readLine().split(" ");
            int N = Integer.parseInt(temp[0]);
            int M = Integer.parseInt(temp[1]);
            int count [][] = new int [M+1][N+1];
            for(int i=1;i<=M;i++) {
                count[i][1]=i;
            } 
            for(int i=1;i<=N;i++) {
                count[i][i]=1;
            }

            //dp
            for(int j=2;j<=N;j++) {
                for(int k=j+1;k<=M;k++) {
                    count[k][j]=count[k-1][j-1]+count[k-1][j];
                }
            }
            System.out.println(count[M][N]);


        }
    }
}
