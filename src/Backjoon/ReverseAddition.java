package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReverseAddition {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        StringBuffer x = new StringBuffer(input[0]);
        StringBuffer y = new StringBuffer(input[1]);
        int rx = Integer.parseInt(x.reverse().toString());
        int ry = Integer.parseInt(y.reverse().toString());
        int sum = rx+ry;
        StringBuffer result = new StringBuffer(Integer.toString(sum));
        System.out.println(Integer.parseInt(result.reverse().toString()));
    }
}
