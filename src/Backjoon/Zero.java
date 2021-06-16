package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<K;i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp!=0) {
                stack.push(temp);
            }else {
                stack.pop();
            }
        }
        int result=0;
        int size = stack.size();
        for(int i=0;i<size;i++) {
            result+=stack.pop();
        }
        System.out.println(result);
    }
}
