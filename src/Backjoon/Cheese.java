package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Cl {
    int x;
    int y;
    Cl(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
public class Cheese {
    static int N,M;
    static int map[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        map = new int[N][M];
        for(int i=0;i<N;i++) {
            temp = br.readLine().split(" ");
            for(int j=0;j<M;j++) {
                map[i][j]=Integer.parseInt(temp[j]);
            }
        }
    }
}
