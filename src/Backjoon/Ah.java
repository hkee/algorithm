package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ah {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String j = br.readLine();
        String h = br.readLine();
        if(j.length()>=h.length()) {
            System.out.println("go");
        }else {
            System.out.println("no");
        }
    }
}
