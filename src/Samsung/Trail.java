package Samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Trail {

	static int Test_case;
	static int N, K; //n-�Ѻ��� ����, k-���簡�ɱ���
	static int map[][];
	static int max;//������� ���츮�� ��
	static ArrayList <Integer> maxl;//������� ���츮 ��ġ
	static int maxlen;//�ִ� �Ǽ��� �� �ִ� ���� ����
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
					}//������� ���츮 ���� ��ġ����
				}
			}//map���� �ޱ�
			int location;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==max) {
						location=i*N+j;
						maxl.remove(maxl.indexOf(location));
					}//���������� ���� ����������츮�� ���츮��ġ�� �����ϰ��ִ� list���� ������
					
					for(int k=1;k<=K;k++) {//k����ŭ ��������
						
					
						map[i][j]-=k;
						
						
						for(int c=0;c<maxl.size();c++) {//���� �Ǽ����ɱ��� Ž��
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
				}//�ι�° ����
			}
			
			System.out.println("#"+t+" "+maxlen);
			/*for(int i=0;i<maxl.size();i++) {
				System.out.println(maxl.get(i));
			}*/
			
			
			
		}//test_case for��

	}//main
	static public void dfs(int loi,int loj,int length) {	
		//��
		if(loi-1>=0&&map[loi-1][loj]<map[loi][loj]) {
			dfs(loi-1,loj,length+1);
		}
		
		//������
		if(loj+1<N&&map[loi][loj+1]<map[loi][loj]) {
			dfs(loi,loj+1,length+1);
		}
		//�Ʒ���
		if(loi+1<N&&map[loi+1][loj]<map[loi][loj]) {
			dfs(loi+1,loj,length+1);
		}
		//����
		if(loj-1>=0&&map[loi][loj-1]<map[loi][loj]) {
			dfs(loi,loj-1,length+1);
		}
		
		if(maxlen<length) {
			maxlen=length;
			return;
		}
		
		
	}

}
