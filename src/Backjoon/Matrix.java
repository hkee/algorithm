package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Matrix {

	static int N;
	static int K;
	static int map[][];
	static int result[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		K=Integer.parseInt(br.readLine());
		int divisor=(N-1)*4;
		int rest=K%divisor;
		
		String temp[];
		map=new int[N][N];
		result=new int[N][N];
		for(int i=0;i<N;i++) {
			temp=br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(temp[j]);
				result[i][j]=Integer.parseInt(temp[j]);
			}
		}
		//테두리의 숫자를 list에 담기
		ArrayList<Integer> ls=new ArrayList<>();
		for(int i=0;i<N;i++) {
			ls.add(map[0][i]);
		}
		for(int i=1;i<N-1;i++) {
			ls.add(map[i][N-1]);
		}
		for(int i=N-1;i>=0;i--) {
			ls.add(map[N-1][i]);
		}
		for(int i=N-2;i>=1;i--) {
			ls.add(map[i][0]);
		}
		
		System.out.println(ls);
		//k번만큼 회전하기
		int tmp;
		for(int i=0;i<rest;i++) {
			tmp=ls.get(divisor-1);
			ls.remove(divisor-1);
			ls.add(0, tmp);
		}
		//테두리에 회전한거 담기
		for(int i=0;i<N;i++) {
			result[0][i]=ls.get(0);
			ls.remove(0);
		}
		for(int i=1;i<N-1;i++) {
			result[i][N-1]=ls.get(0);
			ls.remove(0);
		}
		for(int i=N-1;i>=0;i--) {
			result[N-1][i]=ls.get(0);
			ls.remove(0);
		}
		for(int i=N-2;i>=1;i--) {
			result[i][0]=ls.get(0);
			ls.remove(0);
		}
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println(" ");
		}
		

	}

}
