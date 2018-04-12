package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Position{
	int i;
	int j;
	Position(int i,int j){
		this.i=i;
		this.j=j;
	}
	public int getI() {
		return i;
	}
	public int getJ() {
		return j;
	}

	
}


public class Maze {
		static int N,M;
		static int map[][];
		static int length[][];
		static int di[]= {-1,0,1,0};
		static int dj[]= {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String temp[];
		temp=br.readLine().split(" ");
		N=Integer.parseInt(temp[0]);
		M=Integer.parseInt(temp[1]);
		map=new int[N][M];
		length=new int[N][M];
		for(int i=0;i<N;i++) {
			temp=br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(temp[j]);
			}
		}
		
		bfs(0,0);
		System.out.println(map[N-1][M-1]);
		
		
		
	}
	static public void bfs(int i, int j) {
		Queue<Position> q=new LinkedList<Position>();
		q.offer(new Position(i,j));
		int nexti;
		int nextj;
		while(!q.isEmpty()) {
			Position p=q.poll();
			for(int c=0;i<4;i++) {
				nexti=p.i+di[c];
				nextj=p.j+dj[c];
				if(nexti<0||nextj<0||nexti>=N||nextj>=M) {
					continue;
				}
				if(map[nexti][nextj]==0) {
					continue;
				}
				q.offer(new Position(nexti,nextj));
				length[nexti][nextj]=map[p.i][p.j]+1;
				map[nexti][nextj]=0;
				
				
			}
		}
	}

}
