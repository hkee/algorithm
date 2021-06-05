package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bracket {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i< T ;i++) {
            int result = 0;
            String input = br.readLine();
            for(int j=0;j<input.length();j++) {
                if(input.charAt(j)=='(') {
                    result++;
                }else {
                    result --;
                    if(result<0) {
                        break;
                    }
                }
            }
            if(result==0) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
            
        
    }
}
