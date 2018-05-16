package Backjoon;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Alphabet {
	static int R,C;//세로 r 가로 c
	static char map[][];
	static HashSet set;
	static int max=0;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		set=new HashSet<Character>();
		R=sc.nextInt();
		C=sc.nextInt();
		sc.nextLine();
		map=new char [R][C];
		String temp;
		for(int i=0;i<R;i++){
		temp=sc.nextLine();
		map[i]=temp.toCharArray();
		}
		
		dfs(0,0);
		System.out.println(max);

	}
	public static void dfs(int i, int j){
		set.add(map[i][j]);
	
		if(set.size()>max){
			max=set.size();
		
		}
		char ch=map[i][j];
		//위
		if(i-1>=0 && !set.contains(map[i-1][j])){
			
			dfs(i-1,j);
			
			
		}
		//오른쪽
		if(j+1<C && !set.contains(map[i][j+1])){
			dfs(i,j+1);
			
			
		}
		//아래쪽
		if(i+1<R && !set.contains(map[i+1][j])){
			dfs(i+1,j);
			
			
		}
		//왼쪽
		if(j-1>=0 && !set.contains(map[i][j-1])){
			dfs(i,j-1);
			
			
		}
		set.remove(ch);
	
	}

}