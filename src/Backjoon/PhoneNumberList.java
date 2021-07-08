package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;

public class PhoneNumberList {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            int N = Integer.parseInt(br.readLine());
            String numlist[] = new String[N];
            for(int n=0;n<N;n++) {
                numlist[n] = br.readLine();
            }
            Arrays.sort(numlist);
            String flag = "YES";
            for(int i=0;i<N-1;i++) {
                String p ="^";
                p=p+numlist[i]+".*$";
                if(Pattern.matches(p, numlist[i+1])) {
                    flag = "NO";
                    break;
                }
            }
            System.out.println(flag);
        } 

    }
}
