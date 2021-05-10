package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Location1 {
    int x;
    int y;
    Location1(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class ComplexNumber {
    
    static int N;
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    static int map[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map= new int [N][N];
        for(int i=0; i<N; i++) {
            String temp[] = br.readLine().split("");
            for(int j=0; j<N; j++) {
                map[i][j]=Integer.parseInt(temp[j]);
            }
        }
        Queue<Location1> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j]==1) {
                    q.offer(new Location1(j, i));
                    map[i][j]=0;
                    find(q,result);
                }
            }
        }
        result.sort(null);
        System.out.println(result.size());
        for(int i=0;i<result.size();i++) {
            System.out.println(result.get(i));
        }
    }
    public static void find (Queue<Location1> q,ArrayList<Integer> result) {
        int count = 1;
        while(!q.isEmpty()) {
            Location1 l =q.poll();
            int nextX,nextY;
            for(int i=0;i<4;i++) {
                nextX = l.x+dx[i];
                nextY = l.y+dy[i];
                if(nextY<0||nextX<0||nextX>=N||nextY>=N) {
                    continue;
                }
                if(map[nextY][nextX]==1) {
                    q.offer(new Location1(nextX, nextY));
                    map[nextY][nextX]=0;
                    count++;
                }
                
            }
        }
        result.add(count);
    }

}
