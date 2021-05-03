package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Permutation {
    static int N,M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int target[] = new int[N];
        int answer[] = new int[M];

        for(int i=0;i<N;i++) {
            target[i] = i+1;
        }
        permute(target,answer,0,M);

    }
    public static void permute (int target[],int answer[], int depth, int M) {
        if( depth == M) {
            for(int i=0; i<M; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i= 0; i < N; i++) {
            if(target[i]!=0) {
                int temp = target[i];
                answer[depth]=temp;
                target[i]=0;
                permute(target,answer, depth+1, M);
                target[i]=temp;
            }

        }
    }

}
