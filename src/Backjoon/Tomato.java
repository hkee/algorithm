package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Location {
    int x;
    int y;
    int point;
    Location(int x, int y,int point) {
        this.x= x;
        this.y= y;
        this.point = point;
    }
}

public class Tomato {
    static int M,N;
    static int max = 0;
    static int map[][];
    static int dx[]={0,1,0,-1};
    static int dy[]={1,0,-1,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        M = Integer.parseInt(temp[0]);
        N = Integer.parseInt(temp[1]);
        map = new int [N][M];
        ArrayList<Integer> startX = new ArrayList<>();
        ArrayList<Integer> startY = new ArrayList<>();
        for(int i=0; i<N; i++) {
            temp = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                map[i][j]=Integer.parseInt(temp[j]);
                if(map[i][j]==1) {
                    startX.add(j);
                    startY.add(i);
                }
            }
        }
        find(startX,startY);
        System.out.println(findResult(map));
       
    }
    public static void find(ArrayList<Integer> x,ArrayList<Integer> y) {
        Queue<Location> q = new LinkedList<>();
        for(int i=0;i<x.size();i++) {
            q.offer(new Location(x.get(i), y.get(i), 0));
        }
        while(!q.isEmpty()) {
            Location l = q.poll();
            int nextX=0,nextY=0,nextP=0;
            for(int i=0;i<4;i++) {
                nextX = l.x+dx[i];
                nextY = l.y+dy[i];
                nextP = l.point+1;
                if(nextX<0 || nextY<0 || nextX>=M || nextY>=N) {
                    continue;
                }
                if(map[nextY][nextX]==0) {
                    q.offer(new Location(nextX,nextY,nextP));
                    map[nextY][nextX]=nextP;
                    if(max<nextP) {
                        max = nextP;
                    }
                }
            }
            
        }
    }
    public static int findResult(int map[][]) {
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j]==0) {
                    return -1;
                }
            }
        }
        return max;
    }
}
