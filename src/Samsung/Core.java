package Samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.Iterator;

public class Core {
	static int test_case;
	static int N;
	static int map[][];
	static int incore[];	
	static int max;
	static int line;
	static Iterator <Integer>it;
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		test_case=Integer.parseInt(br.readLine());
		String tmp[];
		incore= new int[13];
		for(int t=1;t<=test_case;t++) {
			N=Integer.parseInt(br.readLine());
			map=new int[N][N];
			Arrays.fill(incore, 0);
			max=Integer.MIN_VALUE;
			line=Integer.MAX_VALUE;
			int index=0;
			
			for(int i=0;i<N;i++) {
				tmp=br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(tmp[j]);
					if(i>0&&i<N-1&&j>0&&j<N-1&&map[i][j]==1) {
						incore[index]=(i*N)+j;
						index++;
					}
				}
			}
			for(int i=0;i<13;i++) {
				System.out.print(incore[i]+ " ");
			}
			
			
			dfs(0,0,0);
			//System.out.println(max);
			System.out.println("#"+t+" "+line);
			
			
			
		/*	for(int i=0;i<N;i++) {
				for (int j=0;j<N;j++) {
					System.out.print(map[i][j] +" ");
				}
				System.out.println();
			}*/
			
		}//test_case
		
	}//main
	static public void dfs(int index,int dmax,int dline) {
		int i=incore[index]/N;
		int j=incore[index]%N;
		boolean go;
		
		//위
		go=true;
		for(int c=i-1;c>=0;c--) {
			if(map[c][j]!=0) {
				go=false;
				break;
			}	
		}//전선을 연결할 수 있는지 체크
		if(go==true) {
			dmax++;
			for(int c=i-1;c>=0;c--) {
				map[c][j]=2;
				dline++;
			}//전선 연결
		
			
			if(incore[index+1]!=0) {
				dfs(index+1,dmax,dline);
			}else {
				if(max<dmax) {
					max=dmax;
					line=dline;
				
				}else if(max==dmax) {
					if(line>=dline) {
						line=dline;
					}
				}
			}
			dmax--;
			for(int c=0;c<=i-1;c++) {
				map[c][j]=0;
				dline--;
			}//전선 해제
		}
		
		
		
		//오른쪾
		go=true;
		for(int c=j+1;c<=N-1;c++) {
			if(map[i][c]!=0) {
				go=false;
				break;
			}	
		}//전선을 연결할 수 있는지 체크
		if(go==true) {
			dmax++;
			for(int c=j+1;c<=N-1;c++) {
				map[i][c]=2;
				dline++;
			}//전선 연결
		
			
			if(incore[index+1]!=0) {
				dfs(index+1,dmax,dline);
			}else {
				if(max<dmax) {
					max=dmax;
					line=dline;
				
				}else if(max==dmax) {
					if(line>=dline) {
						line=dline;
					}
				}
			}
			dmax--;
			for(int c=N-1;c>=j+1;c--) {
				map[i][c]=0;
				dline--;
			}//전선 해제
		}
		
		//아래쪽
		go=true;
		for(int c=i+1;c<=N-1;c++) {
			if(map[c][j]!=0) {
				go=false;
				break;
			}	
		}//전선을 연결할 수 있는지 체크
		if(go==true) {
			dmax++;
			for(int c=i+1;c<=N-1;c++) {
				map[c][j]=2;
				dline++;
			}//전선 연결
		
			
			if(incore[index+1]!=0) {
				dfs(index+1,dmax,dline);
			}else {
				if(max<dmax) {
					max=dmax;
					line=dline;
				
				}else if(max==dmax) {
					if(line>=dline) {
						line=dline;
					}
				}
			}
			dmax--;
			for(int c=N-1;c>=i+1;c--) {
				map[c][j]=0;
				dline--;
			}//전선 해제
		}
		//왼쪽
		go=true;
		for(int c=j-1;c>=0;c--) {
			if(map[i][c]!=0) {
				go=false;
				break;
			}	
		}//전선을 연결할 수 있는지 체크
		if(go==true) {
			dmax++;
			for(int c=j-1;c>=0;c--) {
				map[i][c]=2;
				dline++;
			}//전선 연결
		
			
			if(incore[index+1]!=0) {
				dfs(index+1,dmax,dline);
			}else {
				if(max<dmax) {
					max=dmax;
					line=dline;
				
				}else if(max==dmax) {
					if(line>=dline) {
						line=dline;
					}
				}
			}
			dmax--;
			for(int c=0;c<=j-1;c++) {
				map[i][c]=0;
				dline--;
			}//전선 해제
		}
		//연결을 안하는 경우
		if(incore[index+1]!=0) {
			dfs(index+1,dmax,dline);
		}else {
			if(max<dmax) {
				line=dline;
			
			}else if(max==dmax) {
				max=dmax;
				if(line>=dline) {
					line=dline;
				}
			}
		}
	}

}
