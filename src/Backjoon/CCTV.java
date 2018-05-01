package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CCTV {

	static int N,M;
	static int map[][];
	static int visited[][];
	static int min=Integer.MAX_VALUE;
	static ArrayList<Integer>location;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String temp[];
		temp=br.readLine().split(" ");
		N=Integer.parseInt(temp[0]);
		M=Integer.parseInt(temp[1]);
		map=new int[N][M];
		visited=new int[N][M];
		location=new ArrayList<>();
		for(int i=0;i<N;i++) {
			temp=br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(temp[j]);
				visited[i][j]=Integer.parseInt(temp[j]);
				if(map[i][j]>=1&&map[i][j]<=5) {
					location.add(i*M+j);
				}
			}		
			
		}
		dfs(0);

		System.out.println(min);

	}//main ³¡
	static public void dfs(int index) {
		if(index==location.size()) {
			//min Ã£±â
			int t_min=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(visited[i][j]==0) {
						t_min++;
					}
				}
			}
			if(t_min<min) {
				min=t_min;
			}
			return;
			
		}else {
			int x=location.get(index)%M;
			int y=location.get(index)/M;
			if(map[y][x]==1) {
				//ºÏ
				searchN(x,y);
				dfs(index+1);
				backN(x,y);
				
				//µ¿
				searchE(x,y);
				dfs(index+1);
				backE(x,y);
				//³²
				searchS(x,y);
				dfs(index+1);
				backS(x,y);
				//¼­
				searchW(x,y);
				dfs(index+1);
				backW(x,y);
			}else if(map[y][x]==2) {
				//ºÏ³²
				searchN(x,y);
				searchS(x,y);
				dfs(index+1);
				backN(x,y);
				backS(x,y);
				
				//µ¿¼­
				searchE(x,y);
				searchW(x,y);
				dfs(index+1);
				backE(x,y);
				backW(x,y);
			}else if(map[y][x]==3) {
				//ºÏµ¿
				searchN(x,y);
				searchE(x,y);
				dfs(index+1);
				backN(x,y);
				backE(x,y);
				//³²µ¿
				searchS(x,y);
				searchE(x,y);
				dfs(index+1);
				backS(x,y);
				backE(x,y);
				//³²¼­
				searchS(x,y);
				searchW(x,y);
				dfs(index+1);
				backS(x,y);
				backW(x,y);
				//ºÏ¼­
				searchN(x,y);
				searchW(x,y);
				dfs(index+1);
				backN(x,y);
				backW(x,y);
				
			}else if(map[y][x]==4) {
				//ºÏ »©°í
			
				searchE(x,y);
				searchS(x,y);
				searchW(x,y);
				dfs(index+1);
				backE(x,y);
				backS(x,y);
				backW(x,y);
				//³² »©°í
				searchN(x,y);
				searchE(x,y);
				searchW(x,y);
				dfs(index+1);
				backE(x,y);
				backN(x,y);
				backW(x,y);
				//µ¿ »©°í
				searchN(x,y);
				searchS(x,y);
				searchW(x,y);
				dfs(index+1);
				backN(x,y);
				backS(x,y);
				backW(x,y);
				//¼­ »©°í
				searchN(x,y);
				searchE(x,y);
				searchS(x,y);
				dfs(index+1);
				backE(x,y);
				backS(x,y);
				backN(x,y);
			}else if(map[y][x]==5) {
				searchN(x,y);
				searchE(x,y);
				searchS(x,y);
				searchW(x,y);
				dfs(index+1);
				backE(x,y);
				backS(x,y);
				backN(x,y);
				backW(x,y);
			}
		}
	}
	
	static public void searchN(int x, int y) {
		for(int i=y-1;i>=0;i--) {
			
			if(map[i][x]==6) {
				break;
			}else {
				if(visited[i][x]>=7) {
					visited[i][x]++;
				}else {
				if(map[i][x]==0) {
				visited[i][x]=7;
				}
				}
				
			}
		}
	}
	static public void searchE(int x, int y) {
	for(int i=x+1;i<M;i++) {
			
			if(map[y][i]==6) {
				break;
			}else {
				if(visited[y][i]>=7) {
					visited[y][i]++;
				}else {
				if(map[y][i]==0)
					visited[y][i]=7;
				}
				
			}
		}
	}
	static public void searchS(int x, int y) {
		for(int i=y+1;i<N;i++) {
			
			if(map[i][x]==6) {
				break;
			}else {
				if(visited[i][x]>=7) {
					visited[i][x]++;
				}else {
					if(map[i][x]==0)
						visited[i][x]=7;
				}
				
			}
		}
	}
	static public void searchW(int x, int y) {
	for(int i=x-1;i>=0;i--) {
			
			if(map[y][i]==6) {
				break;
			}else {
				if(visited[y][i]>=7) {
					visited[y][i]++;
				}else {
					if(map[y][i]==0)
						visited[y][i]=7;
				}
				
			}
		}
	}
	static public void backN(int x, int y) {
		for(int i=y-1;i>=0;i--) {
			
			if(map[i][x]==6) {
				break;
			}else {
				if(visited[i][x]>7) {
					visited[i][x]--;
				}else {
					if(visited[i][x]==7)
						visited[i][x]=0;
				}
				
			}
		}
	}
	static public void backE(int x, int y) {
	for(int i=x+1;i<M;i++) {
			
			if(map[y][i]==6) {
				break;
			}else {
				if(visited[y][i]>7) {
					visited[y][i]--;
				}else {
					if(visited[y][i]==7)
						visited[y][i]=0;
				}
				
			}
		}
	}
	static public void backS(int x, int y) {
	for(int i=y+1;i<N;i++) {
			
			if(map[i][x]==6) {
				break;
			}else {
				if(visited[i][x]>7) {
					visited[i][x]--;
				}else {
					if(visited[i][x]==7)
						visited[i][x]=0;
				}
				
			}
		}
	}
	static public void backW(int x, int y) {
	for(int i=x-1;i>=0;i--) {
			
			if(map[y][i]==6) {
				break;
			}else {
				if(visited[y][i]>7) {
					visited[y][i]--;
				}else {
					if(visited[y][i]==7)
						visited[y][i]=0;
				}
				
			}
		}

	}

}// class³¡
