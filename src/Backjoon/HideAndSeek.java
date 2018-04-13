package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class HideAndSeek {
	static int cost[];
	static int N,K;
	static final int last=100001;
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String temp[]=br.readLine().split(" ");
		N=Integer.parseInt(temp[0]);
		K=Integer.parseInt(temp[1]);
		cost=new int[last];
		cost[N]=1;
		bfs(N);
		
		System.out.println(cost[K]-1);
	}
	static public void bfs(int index) {
		Queue <Integer>q =new LinkedList<Integer>();
		q.offer(index);
		int point;
		int c=0;
		while(!q.isEmpty()) {
			point=q.poll();
			if(point-1>0&&(cost[point-1]>cost[point]+1||cost[point-1]==0)&&point-1<=K) {
				q.offer(index-1);
				cost[point-1]=cost[point]+1;
				
			}
			if(point+1<last&&(cost[point+1]>cost[point]+1||cost[point+1]==0)&&point+1<=K) {
				q.offer(point+1);
				cost[point+1]=cost[point]+1;
					
				
			}
			if(point*2<last&&(cost[point*2]>cost[point]+1||cost[point*2]==0)&&point*2<=K) {
				q.offer(point*2);
	
				cost[point*2]=cost[point]+1;
				
			}
			
		}
		
		
		
	}
}
