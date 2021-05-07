package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Nqueen {
    static int N,result;
    static int map[][];
    static int line[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int [N][N];
        result=0;
        line = new int[N];
        find(0);
        System.out.println(result);
    }
    public static void find(int depth) {
        if(depth==N) {
            result++;
            return;
        }
        for(int i=0;i<N;i++) {
           
            if(line[i]==0 && searchNE(i,depth)==0 && searchNW(i,depth)==0){
                map[depth][i]=1;
                line[i]=1;
                find(depth+1);
                line[i]=0;
                map[depth][i]=0;
            }
            
        }
    }
    public static int searchNE(int x,int y) {
        int roop = N-1-x < y ? N-1-x : y;
        for(int i=1;i<=roop;i++) {
            if(map[y-i][x+i]==1) {
                return 1;
            }
        }
        return 0;
    }
    public static int searchNW(int x, int y) {
        int roop = x < y ? x : y;
        for(int i=1;i<=roop;i++) {
            if(map[y-i][x-i]==1) {
                return 1;
            }
        }
        return 0;
    }
}
