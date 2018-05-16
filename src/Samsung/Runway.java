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
      //가로 탐색
      for(int i=0;i<N;i++){
          for(int j=0;j<N-1;j++){
              if(map[i][j]==map[i][j+1]){//현재노드와 다음노드의 높이가 같을때
                  if(j==N-2){//노드탐색중 마지막 탐색일때
                      result++;   
                  }
                  continue;//마지막 탐색이 아니면 계속 탐색을 진행하라
              }else if(Math.abs(map[i][j]-map[i][j+1])==1){
                  //현재노드와 다음노드의 높이차가 1이므로 경사로를 세울수 있을때
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
                  //높이차가 2이상이라 경사로를 세울수 없어 길이 될 수 없으므로 반복문 종료
                  break;
              }
          }
      }
       
      visited=new int[N][N];
      //세로 탐색
      for(int j=0;j<N;j++){
          for(int i=0;i<N-1;i++){
              if(map[i][j]==map[i+1][j]){//현재노드와 다음노드의 높이가 같을때
                  if(i==N-2){//노드탐색중 마지막 탐색일때
                      result++;   
                  }
                  continue;//마지막 탐색이 아니면 계속 탐색을 진행하라
              }else if(Math.abs(map[i][j]-map[i+1][j])==1){
                  //현재노드와 다음노드의 높이차가 1이므로 경사로를 세울수 있을때
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
                  //높이차가 2이상이라 경사로를 세울수 없어 길이 될 수 없으므로 반복문 종료
                  break;
              }
          }
      }
      System.out.println("#"+t+" "+result);
      }
   }
   static void rowdfs(int i, int j,int value,int c){
       //완벽한종료조건
       if(c==0){
           success=1;
           return;
       }
       //경사로를 세울수없을때의 종료조건
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
       //완벽한종료조건
       if(c==0){
           success=1;
           return;
       }
       //경사로를 세울수없을때의 종료조건
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