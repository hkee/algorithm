package Samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Microbe {
	static int test_case;
	static int map[][];
	static int map2[][];
	static int arrtmp[][],dirtmp[][];
	static int direct[][];
	static int direct2[][];
	static int max[][];
	static int N,M,K;
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		test_case=Integer.parseInt(br.readLine());
		
		String tmp[];
		
		for(int t=1;t<=test_case;t++) {
			tmp=br.readLine().split(" ");
			N=Integer.parseInt(tmp[0]);
			M=Integer.parseInt(tmp[1]);
			K=Integer.parseInt(tmp[2]);
			map=new int[N][N];
			map2=new int[N][N];
			max=new int[N][N];
			direct=new int[N][N];
			direct2=new int [N][N];
			int row,col;
			int result=0;
			for(int i=0;i<K;i++) {
				tmp=br.readLine().split(" ");
				row=Integer.parseInt(tmp[0]);
				col=Integer.parseInt(tmp[1]);
	
				map[row][col]=Integer.parseInt(tmp[2]);
				direct[row][col]=Integer.parseInt(tmp[3]);

			}
			for(int m=0;m<M;m++) {
			
				move();
				arrtmp=map;
				dirtmp=direct;
				map=map2;
				direct=direct2;
				map2=arrtmp;
				direct2=dirtmp;
				for(int i=0;i<N;i++) {
					Arrays.fill(map2[i], 0);
					Arrays.fill(direct2[i], 0);
					Arrays.fill(max[i], 0);
				}
			}

			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]!=0) {
						result+=map[i][j];
					}
				}
			}

			System.out.println("#"+t+" "+result);
	
			
		}//test_case 

	}//main

	public static void move() {
		loop1 : for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
				if(map[i][j]!=0) {
					
					if(direct[i][j]==1) {//상
						if(max[i-1][j]<map[i][j]) {//여러군집이 모아지는 경우 추가되는군집이 가장큰 군집일때
							if(i-1==0) {//약품이 발라진곳일때
								direct2[i-1][j]=2;
								map2[i-1][j]+=(map[i][j]/2);
							}else {//약품이 발라진곳이 아닐때
								map2[i-1][j]+=map[i][j];
								direct2[i-1][j]=1;
							}
							max[i-1][j]=map[i][j];

						}else {//가장큰 군집이 아닐때
							if(i-1==0) {//약품이 발라진곳일때
								map2[i-1][j]+=(map[i][j]/2);
							}else {//약품이 발라진곳이 아닐때
								map2[i-1][j]+=map[i][j];
							}
							
						}
						
					}else if(direct[i][j]==2) {//하
						if(max[i+1][j]<map[i][j]) {//여러군집이 모아지는 경우 추가되는군집이 가장큰 군집일때
							if(i+1==(N-1)) {//약품이 발라진곳일때
								direct2[i+1][j]=1;
								map2[i+1][j]+=(map[i][j]/2);
							}else {//약품이 발라진곳이 아닐때
								map2[i+1][j]+=map[i][j];
								direct2[i+1][j]=2;
							}
							max[i+1][j]=map[i][j];

						}else {//가장큰 군집이 아닐때
							if(i+1==0) {//약품이 발라진곳일때
								map2[i+1][j]+=(map[i][j]/2);
							}else {//약품이 발라진곳이 아닐때
								map2[i+1][j]+=map[i][j];
							}
							
						}
					}else if(direct[i][j]==3) {//좌
						if(max[i][j-1]<map[i][j]) {//여러군집이 모아지는 경우 추가되는군집이 가장큰 군집일때
							if(j-1==0) {//약품이 발라진곳일때
								direct2[i][j-1]=4;
								map2[i][j-1]+=(map[i][j]/2);
							}else {//약품이 발라진곳이 아닐때
								map2[i][j-1]+=map[i][j];
								direct2[i][j-1]=3;
							}
							max[i][j-1]=map[i][j];

						}else {//가장큰 군집이 아닐때
							if(j-1==0) {//약품이 발라진곳일때
								map2[i][j-1]+=(map[i][j]/2);
							}else {//약품이 발라진곳이 아닐때
								map2[i][j-1]+=map[i][j];
							}
							
						}
					}else if(direct[i][j]==4) {//우
						if(max[i][j+1]<map[i][j]) {//여러군집이 모아지는 경우 추가되는군집이 가장큰 군집일때
							if(j+1==(N-1)) {//약품이 발라진곳일때
								direct2[i][j+1]=3;
								map2[i][j+1]+=(map[i][j]/2);
							}else {//약품이 발라진곳이 아닐때
								map2[i][j+1]+=map[i][j];
								direct2[i][j+1]=4;
							}
							max[i][j+1]=map[i][j];

						}else {//가장큰 군집이 아닐때
							if(j+1==(N-1)) {//약품이 발라진곳일때
								map2[i][j+1]+=(map[i][j]/2);
							}else {//약품이 발라진곳이 아닐때
								map2[i][j+1]+=map[i][j];
							}
							
						}
					}
				}
			}//안에 포문
		}//loop1
	}//move
	
}
