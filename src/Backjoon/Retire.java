package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Retire {
	static int N;
	static int T[];
	static int P[];
	static int maxprofit=Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		T=new int[N];
		P=new int[N];
		String temp[];
		for(int i=0;i<N;i++) {
			temp=br.readLine().split(" ");
			T[i]=Integer.parseInt(temp[0]);
			P[i]=Integer.parseInt(temp[1]);
		}
		dfs(0,0);
		System.out.println(maxprofit);

	}
	static public void dfs(int index,int total) {
		
		if(index>N-1) {
			if(maxprofit<total) {
				maxprofit=total;
			}
			return;
		}
		//상담하는 경우
		if((index+T[index])<=N) {
			dfs(index+T[index],total+P[index]);
		}
		//상담하지 않는 경우
		
			dfs(index+1,total);
		
	}

}
