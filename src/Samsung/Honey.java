package Samsung;
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Honey {
 
   static int T;// test���̽�
   static int N, M, C; // n-����ũ��,m-�����Ҽ��ִ� �����,c-�ִ���ܾ�
   static int can[][];
   static int visited[][];
   static int max,f_sum,s_sum,ssum;
   public static void main(String[] args) throws Exception {
 
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      T = Integer.parseInt(br.readLine());
      for (int i = 0; i < T; i++) {
         max=Integer.MIN_VALUE;
         String tmp[] = br.readLine().split(" ");
         N = Integer.parseInt(tmp[0]);
         M = Integer.parseInt(tmp[1]);
         C = Integer.parseInt(tmp[2]);
         can = new int[N][N];
         visited=new int[N][N];
         // ������ ���ܾ� �ޱ�
         for (int j = 0; j < N; j++) {
            tmp = br.readLine().split(" ");
            for (int k = 0; k < N; k++) {
               can[j][k] = Integer.parseInt(tmp[k]);
            }
         }
         int fi=0,fj=0;
         f_sum=0;
         int ii=1;
         while(fi<N){
            if((fj+M)<=N){
                
               for(int k=fj;k<fj+M;k++)
                  visited[fi][k]=1;
               ssum=0;
               getSum(fi,fj,C,0,1);
               f_sum=ssum;
                
               fj++;
                
            }else{
               fi++;
               fj=0;
            }
            s_sum=0;
             
            for(int row=0;row<N;row++){
               for(int col=0;col+M<=N;col++){
                  if(visited[row][col]==1){
                     continue;
                  }
                  ssum=0;
                  getSum(row,col,C,0,1);
                  if(s_sum<ssum){
                     s_sum=ssum;
                  }
               }
            }
            if((f_sum+s_sum)>max){  
               max=(f_sum+s_sum);
            }
             
         }
      System.out.print("#"+(i+1));
      System.out.println(" "+max);
 
      }
      br.close();
 
   }
 
 
   public static void getSum(int row, int col, int c,int sum,int node){
      if(ssum<sum){
          ssum=sum;
      }
      if(node<=M){
           
              //���� �ִ� ���
          if(can[row][col]<=c){
              //����
              sum+=can[row][col]*can[row][col];
              //System.out.println(sum);
              getSum(row,col+1,c-can[row][col],sum,node+1);
              sum-=can[row][col]*can[row][col];
              //�ȵ���
              getSum(row,col+1,c,sum,node+1);
          }else{
              //���� ���� ���
                  
              getSum(row,col+1,c,sum,node+1);
          }
      }
      
      }      
 
}