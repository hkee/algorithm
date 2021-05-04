package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Combination {
    static int N, M;
    static int target[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        target = new int[N];
        boolean check[] = new boolean[N];
        for(int i=0; i<N; i++) {
            target[i]=i+1;
        }
        combi(check,0,N,M);
    }
    public static void combi (boolean check[],int depth,int n,int m) {
        if(m==0) {
            for(int i=0;i<n;i++) {
                if(check[i]==true) {
                    System.out.print(target[i]+" ");
                }
            }
            System.out.println();
            return;
        }
        for(int i=depth;i<n;i++) {
            check[i]=true;
            combi(check,i+1,n,m-1);
            check[i]=false;
        }
    }
}
