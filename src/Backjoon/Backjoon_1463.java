package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Backjoon_1463 {

	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));	
		int mem[];
		int num;
		num=Integer.parseInt(br.readLine());
		mem=new int[num+4];
		mem[1]=0;
		mem[2]=1;
		mem[3]=1;
		int min;
		if(num>4) {
		for(int i=4;i<=num;i++) {
			min=Integer.MAX_VALUE;
			if(i%3==0 && min>(mem[i/3]+1)) {
				min=1+mem[i/3];
				
			}
			if(i%2==0 && min>(mem[i/2]+1)) {
				min=1+mem[i/2];
			}
			if(min>mem[i-1]+1){
				min=mem[i-1]+1;
			}
			mem[i]=min;
		}
		}
		
		System.out.println(mem[num]);

	}

}
