package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class GoodWord {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int result = T;
        for(int t=0;t<T;t++) {
            String input = br.readLine();
            if(input.length()%2==1) {
                result--;
                continue;
            }
            Stack<Character> st = new Stack<>();
            for(int i=0;i<input.length();i++) {
                if(st.empty()) {
                    st.push(input.charAt(i));
                }else if(st.peek()==input.charAt(i)){
                    st.pop();
                }else {
                    st.push(input.charAt(i));
                }
            }
            if(!st.empty()) {
                result--;
            }
        }
        System.out.println(result);
    }
}
