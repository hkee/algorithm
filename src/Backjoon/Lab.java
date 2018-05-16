package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lab {

	static int N,M;//n=i,M=j
	static int map[][];
	static int visited[][];
	static int min=Integer.MAX_VALUE;
	static int area2=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String tmp[]=br.readLine().split(" ");
		N=Integer.parseInt(tmp[0]);
		M=Integer.parseInt(tmp[1]);
		map=new int[N][M];
		visited=new int[N][M];
		int zeroc=0;
		for(int i=0;i<N;i++){
			tmp=br.readLine().split(" ");
			for(int j=0;j<M;j++){
				map[i][j]=Integer.parseInt(tmp[j]);
				if(map[i][j]==0){
					zeroc++;
				}
			}
		}

		dfs(2,0);
		System.out.println(zeroc-min-3);
		
		
		
	}

	static void dfs(int c,int preNum){
		if(c<0){
			
			findmax();
			if(min>area2){
				min=area2;
			}
			return;
			
		}else{
			for(int i=preNum;i<N*M;i++){
				if(map[i/M][i%M]==0){
					map[i/M][i%M]=1;
					dfs(c-1,i+1);
					map[i/M][i%M]=0;
				}
			}
		}
	}
	static void findmax(){
		for(int i=0;i<N;i++){
		Arrays.fill(visited[i], 0);
		}
		area2=0;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++)
				if(map[i][j]==2){
					infection(i,j);
				}
			
		}
		
	}
	static void infection(int i, int j){

		if((i-1) >= 0 && map[i-1][j]==0&&visited[i-1][j]==0){
			visited[i-1][j]=1;
			area2++;
			infection(i-1,j);
		}//오른쪽
		 if((j+1)<M && map[i][j+1]==0&&visited[i][j+1]==0){
			 visited[i][j+1]=1;
			 area2++;
			 infection(i,j+1);
		}//아래쪽
		 if((i+1)<N && map[i+1][j]==0&&visited[i+1][j]==0){
			 visited[i+1][j]=1;
			 area2++;
			 infection(i+1,j);
		}//왼쪽
		 if((j-1)>=0 && map[i][j-1]==0&&visited[i][j-1]==0){
			 visited[i][j-1]=1;
			 area2++;
			 infection(i,j-1);
		}
	}

}
