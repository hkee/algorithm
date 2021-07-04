package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class K3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int count = 0;
        while(s[0].contains(s[1])) {
            count++;
            s[0] = s[0].replace(s[1], "");
        }
        System.out.println(count);
    }
}
