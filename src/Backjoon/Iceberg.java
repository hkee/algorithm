package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Iceberg {  
    static int iceMap[][], original[][],visited[][];
    static int N,M;
    static int dx[]={0,1,0,-1};
    static int dy[]={-1,0,1,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        iceMap = new int[N][M];
        //입력
        for(int i=0;i<N;i++) {
            temp = br.readLine().split(" ");
            for(int j=0;j<temp.length;j++) {
                iceMap[i][j]=Integer.parseInt(temp[j]);
            }
        }
        int result = 0;
        while(true) {
            boolean meltingFlag = false;
            original = new int[N][M];
            for(int i=0;i<N;i++) {
                original[i] = iceMap[i].clone();
            }
            //녹이기
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(iceMap[i][j]>0) {
                        meltingFlag = true;
                        iceMap[i][j]-=melt(j, i);
                    }
                }
            }
            if(!meltingFlag) {
                result=0;
                break;
            }
            result++;
            //찾기
            if(find()>=2) {
                break;
            }

        }
        System.out.println(result);
        
    }
    public static int melt(int x,int y) {
        int c = 0;
        for(int i=0;i<4;i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX>=M||nextY>=N||nextX<0||nextY<0) {
                continue;
            }
            if(original[nextY][nextX]<=0) {
                c++;
            }
        }
        return c;
    }
    public static int find () {
        int c = 0;
        boolean flag = false;
        visited=new int[N][M];
        for(int i=0;i<N;i++) {
            visited[i]=iceMap[i].clone();
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(visited[i][j]>0) {
                    c++;
                    if(c>=2) {
                        flag = true;
                        break;
                    }
                    visited[i][j]=0;
                    dfs(j,i);
                }
                if(flag) {
                    break;
                }
            }
        }
        return c;
    }
    public static void dfs(int x,int y) {
        for(int i=0;i<4;i++) {
            int nextX = x+dx[i];
            int nextY = y+dy[i];
            if(nextX>=M||nextY>=N||nextX<0||nextY<0) {
                continue;
            }
            if(visited[nextY][nextX]>0) {
                visited[nextY][nextX] = 0;
                dfs(nextX,nextY);
            }


        }
    }
}
