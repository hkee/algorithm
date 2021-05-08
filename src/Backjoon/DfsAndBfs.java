package Backjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DfsAndBfs {
    static boolean visited[];
    static int map[][]; 
    static int N;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        int start = sc.nextInt();
        map = new int[N+1][N+1];
        visited = new boolean[N+1];
        int v1,v2;
        for(int i=0;i<M;i++) {
            v1 = sc.nextInt();
            v2 = sc.nextInt();
            map[v1][v2] = 1;
            map[v2][v1] = 1;
        }
        dfs(start);
        System.out.println();
        Arrays.fill(visited,false);
        bfs(start);
        sc.close();


    }
    public static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for(int i=0;i<=N;i++) {
            if(!visited[i] && map[v][i]==1) {
                dfs(i);
            }
        }
    }
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start]=true;
        int popV;
        while(!q.isEmpty()) {
            popV=q.poll();
            System.out.print(popV + " ");
            for(int i = 0; i <= N ;i++) {
                if(!visited[i] && map[popV][i]==1) {
                    q.offer(i);
                    visited[i]=true;
                }
            }
        }
    }
}
