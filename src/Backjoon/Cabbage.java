package Backjoon;

import java.util.Scanner;

public class Cabbage {
    static int M,N,num;
    static int dx[] = {0,1,0,-1};
    static int dy[] = {-1,0,1,0};
    static int map[][];
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t=0; t<tc; t++) {
            M = sc.nextInt();
            N = sc.nextInt();
            num = sc.nextInt();
            map = new int[N][M];
            int result=0;
            for(int i=0;i<num;i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[y][x] = 1;
            }
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(map[i][j]==1) {
                        findEarthworm(i,j);
                        result++;
                    }
                }
            }
            System.out.println(result);

        }
        sc.close();
    }
    public static void findEarthworm(int y, int x) {
        map[y][x]=0;
        int nextX;
        int nextY;
        for(int c=0;c<4;c++) {
            nextX = x+dx[c];
            nextY = y+dy[c];
            if(nextX<0||nextY<0||nextX>=M||nextY>=N) {
                continue;
            }
            if(map[nextY][nextX]==1) {
                findEarthworm(nextY, nextX);
            }
        }
    }
}
