package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CardArrangement {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int array[] = new int[21];
        for(int i=1;i<=20;i++) {
            array[i] = i;
        }
        String temp[];
        for(int c=0;c<10;c++) {
            temp = br.readLine().split(" ");
            int startIdx = Integer.parseInt(temp[0]);
            int endIdx = Integer.parseInt(temp[1]);
            int count = (endIdx - startIdx + 1)/2;
            for(int i=0;i<count;i++) {
                int tmp = array[endIdx-i];
                array[endIdx-i] =array[startIdx+i];
                array[startIdx+i] = tmp; 
            }
        }
        for(int i=1;i<=20;i++) {
            System.out.print(array[i]+" ");
        }
    }
}
