package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class StrangeMultiplication {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int A[] = new int[10];
        int B[] = new int[10];
        for(int i=0;i<input[0].length();i++) {
            A[Character.getNumericValue(input[0].charAt(i))]++;
        }
        for(int i=0;i<input[1].length();i++) {
            B[Character.getNumericValue(input[1].charAt(i))]++;
        }
        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();
        for(int i=1;i<10;i++) {
            if(A[i]!=0) {
                listA.add(i*A[i]);
            }
            if(B[i]!=0) {
                listB.add(i*B[i]);
            }
        }
        long result = 0;
        for(int i=0;i<listA.size();i++) {
            for(int j=0;j<listB.size();j++) {
                result += listA.get(i)*listB.get(j);
            }
        }
        System.out.println(result);

    }
}
