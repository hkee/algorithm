package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sangsu {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numArr[] = br.readLine().split(" ");
        StringBuffer num1 = new StringBuffer(numArr[0]);
        StringBuffer num2 = new StringBuffer(numArr[1]);
        if(Integer.parseInt(num1.reverse().toString())>Integer.parseInt(num2.reverse().toString())) {
            System.out.println(num1.toString());
        }else {
            System.out.println(num2.toString());
        }

    }
    

}
