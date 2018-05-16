package Samsung;
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Swim {
 
    static int test_case;
    static int day;
    static int month;
    static int month3;
    static int year;
    static int plan[];//이용계획
    static int min;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        test_case=Integer.parseInt(br.readLine());
        String temp[];
        plan=new int [12];
        for(int t=1;t<=test_case;t++){
            temp=br.readLine().split(" ");
            day=Integer.parseInt(temp[0]);
            month=Integer.parseInt(temp[1]);
            month3=Integer.parseInt(temp[2]);
            year=Integer.parseInt(temp[3]);
             
            temp=br.readLine().split(" ");
            for(int i=0;i<12;i++){
                plan[i]=Integer.parseInt(temp[i]);
            }//1년 이용계획받음
            min=Integer.MAX_VALUE;
            dfs(0,0);
            System.out.println("#"+t+" "+min);
             
        }//test case
 
    }//main
    static public void dfs(int index,int cost){
        //종료조건
        if(index>=12){
            if(cost<min){
                min=cost;
            }
            return;
        }
        //1년치
        dfs(index+12,year);
         
        //1일치
        dfs(index+1,cost+day*plan[index]);
         
        //1달치
        dfs(index+1,cost+month);
        //3달치
        dfs(index+3,cost+month3);
    }
 
}