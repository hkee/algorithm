package Samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Trail {

	static int Test_case;
	static int N, K; //n-한변의 길이, k-공사가능깊이
	static int map[][];
	static int max;//가장높은 봉우리의 값
	static ArrayList <Integer> maxl;//가장높은 봉우리 위치
	static int maxlen;//최대 건설할 수 있는 경사로 길이
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		Test_case=Integer.parseInt(br.readLine());
		String temp[];
		int tt;
		for(int t=1;t<=Test_case;t++) {
			maxlen=Integer.MIN_VALUE;
			maxl=new ArrayList<Integer>();
			max=Integer.MIN_VALUE;
			temp=br.readLine().split(" ");
			N=Integer.parseInt(temp[0]);
			K=Integer.parseInt(temp[1]);
			map=new int[N][N];
			for(int i=0;i<N;i++) {
				temp=br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(temp[j]);
					if(max<map[i][j]) {
						maxl.clear();
						max=map[i][j];
						maxl.add(i*N+j);
					}else if(max==map[i][j]) {
						maxl.add(i*N+j);
					}//가장높은 봉우리 값과 위치저장
				}
			}//map정보 받기
			int location;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==max) {
						location=i*N+j;
						maxl.remove(maxl.indexOf(location));
					}//공사진행할 곳이 가장높은봉우리면 봉우리위치를 저장하고있는 list에서 제거함
					
					for(int k=1;k<=K;k++) {//k값만큼 공사진행
						
					
						map[i][j]-=k;
						
						
						for(int c=0;c<maxl.size();c++) {//등산로 건설가능길이 탐색
						//dfs
							tt=maxl.get(c);
							dfs(tt/N,tt%N,1);
						}
						map[i][j]+=k;
					}
					if(map[i][j]==max) {
						location=i*N+j;
						maxl.add(location);
					}
				}//두번째 포문
			}
			
			System.out.println("#"+t+" "+maxlen);
			/*for(int i=0;i<maxl.size();i++) {
				System.out.println(maxl.get(i));
			}*/
			
			
			
		}//test_case for문

	}//main
	static public void dfs(int loi,int loj,int length) {	
		//위
		if(loi-1>=0&&map[loi-1][loj]<map[loi][loj]) {
			dfs(loi-1,loj,length+1);
		}
		
		//오른쪽
		if(loj+1<N&&map[loi][loj+1]<map[loi][loj]) {
			dfs(loi,loj+1,length+1);
		}
		//아래쪽
		if(loi+1<N&&map[loi+1][loj]<map[loi][loj]) {
			dfs(loi+1,loj,length+1);
		}
		//왼쪽
		if(loj-1>=0&&map[loi][loj-1]<map[loi][loj]) {
			dfs(loi,loj-1,length+1);
		}
		
		if(maxlen<length) {
			maxlen=length;
			return;
		}
		
		
	}

}
