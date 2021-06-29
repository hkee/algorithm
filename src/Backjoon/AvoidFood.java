package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AvoidFood {
    static int N,M,K;
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,-1,0,1};
    static int map[][];
    static int size = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        map = new int[N][M];
        for(int i=0;i<K;i++) {
            String temp[] = br.readLine().split(" ");
            int y = Integer.parseInt(temp[0])-1;
            int x = Integer.parseInt(temp[1])-1;
            map[y][x] = 1;
        }
        int max = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j]==1) {
                    dfs(i,j);
                    if(max<size) {
                        max = size;
                    }
                    size = 0;
                }
            }
        }
        System.out.println(max);

    }
    public static void dfs(int y,int x) {
        size++;
        map[y][x]=0;
        for(int i=0;i<4;i++) {
            int nextY = y+dy[i];
            int nextX = x+dx[i];
            if(nextX<0||nextY<0||nextX>=M||nextY>=N) {
                continue;
            }
            if(map[nextY][nextX]==1) {
                dfs(nextY,nextX);
            }
        }
    }
}
