package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Robot {
    static int X,Y,R,MAX;
    static String product[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] =br.readLine().split(" ");
        X=Integer.parseInt(input[0]);
        Y=Integer.parseInt(input[1]);
        R=Integer.parseInt(input[2]);
        String check [] = new String[X];
        Arrays.fill(check, "0");
        product = new String [Y][X];
        for(int i=0;i<Y;i++) {
            product[i]= br.readLine().split(" ");
        }
        MAX = 0;
        combi(check,0,X,R);
        System.out.println(MAX);

    }
    public static void combi(String check[],int depth,int x,int r) {
        if(r==0) {
            int total=0;
            for(int i=0;i<Y;i++) {
                for(int j=0;j<x;j++) {
                    if(Integer.parseInt(check[j])<Integer.parseInt(product[i][j])) {
                        break;
                    }
                    if(j==x-1) {
                        total++;
                    }
                }
            }
            if(MAX<total) {
                MAX=total;
            }
            return;
        }
        for(int i=depth;i<x;i++) {
            check[i]="1";
            combi(check,i+1,x,r-1);
            check[i]="0";
        }
    }
}
