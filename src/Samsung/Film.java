package Samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Film {
	
	static int test_case;
	static int D,W,K; //d �β�, W ���α���,k ����
	static int map[][];
	static int arr_a[],arr_b[]; //a=0,b=1
	static int min;
	static boolean ok=true;
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		test_case=Integer.parseInt(br.readLine());
		String temp[];
		
		for(int t=1;t<=test_case;t++) {
			min=Integer.MAX_VALUE;
			temp=br.readLine().split(" ");
			D=Integer.parseInt(temp[0]);
			W=Integer.parseInt(temp[1]);
			K=Integer.parseInt(temp[2]);
			map=new int[D][W];
			arr_a=new int[W];
			arr_b=new int [W];
			Arrays.fill(arr_b, 1);
			for(int i=0;i<D;i++) {
				temp=br.readLine().split(" ");
				for(int j=0;j<W;j++) {
					map[i][j]=Integer.parseInt(temp[j]);
				}
			}
			//check2();
			input_m(0,0);
			System.out.println("#"+t+" "+min);
	
			
			
		}//test case

	}//main
	
	static public void input_m(int index,int count) {
		int arr_temp[];
		//��������
		//����ε����� �β��� ���� �������
		if(index==D) {
			ok=true;
			//check�Լ� 
			check2();
			if(ok==true) {
				if(count<min) {
					min=count;
				}
			}
			return;
		}else {
		//��ǰ�����ϴ°��
			arr_temp=map[index];
			//a��ǰ ����
			map[index]=arr_a;
			input_m(index+1,count+1);
			
			//b��ǰ ����
			map[index]=arr_b;
			input_m(index+1,count+1);
			
			map[index]=arr_temp;
		//��ǰ �������� �ʴ� ���
			input_m(index+1,count);
		}
	}

	static public void check2() {
		int tc;//�������ڰ� �ݺ��Ǹ� ī��Ʈ ���� ����
		boolean go=false;//column �Ѱ��� �˻縦 ������ ��� �˻��ؾ����� ���� ����
		for(int c=0;c<W;c++) {
			tc=0;
			go=false;
			for(int d=0;d<D;d++) {
			
				if(d==0) {
					tc++;
					
				}else {
					if(map[d-1][c]==map[d][c]) {
						tc++;
					}else {
						tc=1;
					}
				}
				if(tc==K) {
					go=true;
					break;
				}
				
			}//��������
			if(go==false) {
				ok=false;
				break;
			}
			
		}
	}
	

}
