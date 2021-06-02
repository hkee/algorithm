package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Iceberg {  
    static int iceMap[][];
    static int N,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        iceMap = new int[N][M];
        for(int i=0;i<N;i++) {
            temp = br.readLine().split(" ");
            for(int j=0;j<temp.length;j++) {
                iceMap[i][j]=Integer.parseInt(temp[j]);
            }
        }
        
    }
}
