package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

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
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        int remaining=0;
        map = new int[N][M];
        for(int i=0;i<N;i++) {
            temp = br.readLine().split(" ");
            for(int j=0;j<M;j++) {
                map[i][j]=Integer.parseInt(temp[j]);
                if(map[i][j]==1) {
                    remaining++;
                }
            }
        }
        int meltedC = 0;
        int hour=0;
        while(remaining>0) {
            hour++;
            //공기찾기
            findAir(0, 0);
            //치즈녹이기
            meltedC=melt();
            remaining-=meltedC;
            clear();
        }
        System.out.println(hour);
        System.out.println(meltedC);
        

    }
    public static void findAir(int x,int y) {
        Queue<Cl> q = new LinkedList<>();
        q.offer(new Cl(x,y));
        while(!q.isEmpty()) {
            Cl c = q.poll();
            int nextX,nextY;
            for(int i=0;i<4;i++) {
                nextX = c.x+dx[i];
                nextY = c.y+dy[i];
                if(nextX<0||nextY<0||nextY>=N||nextX>=M) {
                    continue;
                }
                if(map[nextY][nextX]==0) {
                    q.offer(new Cl(nextX,nextY));
                    map[nextY][nextX] = 2;
                }
            }
        }

    }
    public static int melt() {
        int c = 0;
        int nextX,nextY;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j]==1) {
                    for(int d=0;d<4;d++) {
                        nextX = j+dx[d];
                        nextY = i+dy[d];
                        if(nextX<0||nextY<0||nextY>=N||nextX>=M) {
                            continue;
                        }
                        if(map[nextY][nextX]==2) {
                            c++;
                            map[i][j]=0;
                            break;
                        }
                    }
                }
            }
        }
        return c;
    }
    public static void clear() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j]==2) {
                    map[i][j]=0;
                }
            }
        }
    }
}
