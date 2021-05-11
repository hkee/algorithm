package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CarNumber {

    static int d[] = {0,1,2,3,4,5,6,7,8,9};
    static int c[];
    static String type[];
    static int number[];
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        type = br.readLine().split("");
        c = new int[26];
        for(int i=0;i<26;i++) {
            c[i]=65+i;
        }
        number = new int [4];
        permute(0, type.length);
        System.out.println(count);
    }
    public static void permute(int depth,int size) {
        if(depth==size) {
            count++;
            return;
        }
        if(type[depth].equals("c")) {
            for(int i=0;i<c.length;i++) {
                if(depth>=1&&type[depth].equals(type[depth-1])&&number[depth-1]==c[i]) {
                    continue;
                }
                number[depth]=c[i];
                permute(depth+1,size);

            }
        }else {
            for(int i=0;i<d.length;i++) {
                if(depth>=1&&type[depth].equals(type[depth-1])&&number[depth-1]==d[i]) {
                    continue;
                }
                number[depth]=d[i];
                permute(depth+1,size);

            }
        }    

    }
    
}
