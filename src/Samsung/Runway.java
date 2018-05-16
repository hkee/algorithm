package Samsung;
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Runway {
 
   static int N;
   static int map[][];
   static int visited[][];
   static int L;
   static int result=0;
   static int d=0;
   static int success;//1-true,0-fail
   static int test_case;
   public static void main(String[] args) throws Exception{
    
      BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
      test_case=Integer.parseInt(br.readLine());
      String tmp[];
      for(int t=1;t<=test_case;t++){
      result=0;
      tmp=br.readLine().split(" ");
      N=Integer.parseInt(tmp[0]);
      L=Integer.parseInt(tmp[1]);
      map=new int[N][N];
      for(int i=0;i<N;i++){
         tmp=br.readLine().split(" ");
         for(int j=0;j<N;j++){
            map[i][j]=Integer.parseInt(tmp[j]);
         }
      }
      visited=new int[N][N];
      //���� Ž��
      for(int i=0;i<N;i++){
          for(int j=0;j<N-1;j++){
              if(map[i][j]==map[i][j+1]){//������� ��������� ���̰� ������
                  if(j==N-2){//���Ž���� ������ Ž���϶�
                      result++;   
                  }
                  continue;//������ Ž���� �ƴϸ� ��� Ž���� �����϶�
              }else if(Math.abs(map[i][j]-map[i][j+1])==1){
                  //������� ��������� �������� 1�̹Ƿ� ���θ� ����� ������
                  success=0;
                  if(map[i][j]<map[i][j+1]){
                       
                      d=-1;
                      rowdfs(i,j,map[i][j+1]-1,L);
                  }else{
                      d=1;
                      rowdfs(i,j+1,map[i][j]-1,L);
                  }
                  if(success==0){
                      break;
                  }else{
                      if(j==N-2)
                          result++;
                  }
                   
                   
              }else{
                  //�������� 2�̻��̶� ���θ� ����� ���� ���� �� �� �����Ƿ� �ݺ��� ����
                  break;
              }
          }
      }
       
      visited=new int[N][N];
      //���� Ž��
      for(int j=0;j<N;j++){
          for(int i=0;i<N-1;i++){
              if(map[i][j]==map[i+1][j]){//������� ��������� ���̰� ������
                  if(i==N-2){//���Ž���� ������ Ž���϶�
                      result++;   
                  }
                  continue;//������ Ž���� �ƴϸ� ��� Ž���� �����϶�
              }else if(Math.abs(map[i][j]-map[i+1][j])==1){
                  //������� ��������� �������� 1�̹Ƿ� ���θ� ����� ������
                  success=0;
                  if(map[i][j]<map[i+1][j]){
                       
                      d=-1;
                      coldfs(i,j,map[i+1][j]-1,L);
                  }else{
                      d=1;
                      coldfs(i+1,j,map[i][j]-1,L);
                  }
                  if(success==0){
                      break;
                  }else{
                      if(i==N-2)
                          result++;
                  }
                   
                   
              }else{
                  //�������� 2�̻��̶� ���θ� ����� ���� ���� �� �� �����Ƿ� �ݺ��� ����
                  break;
              }
          }
      }
      System.out.println("#"+t+" "+result);
      }
   }
   static void rowdfs(int i, int j,int value,int c){
       //�Ϻ�����������
       if(c==0){
           success=1;
           return;
       }
       //���θ� ������������� ��������
       if((j<0||j>=N)||visited[i][j]==1){
           return;
       }else{
          if( map[i][j]==value){
              visited[i][j]=1;
              rowdfs(i,j+d,map[i][j],c-1);
          }
       }
       
   }
   static void coldfs(int i, int j,int value,int c){
       //�Ϻ�����������
       if(c==0){
           success=1;
           return;
       }
       //���θ� ������������� ��������
       if((i<0||i>=N)||visited[i][j]==1){
           return;
       }else{
          if( map[i][j]==value){
              visited[i][j]=1;
              coldfs(i+d,j,map[i][j],c-1);
          }
       }
       
   }
    
}