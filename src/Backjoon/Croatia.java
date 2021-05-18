package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Croatia {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        input=input.replaceAll("(dz=|lj|nj)","#");
        input=input.replaceAll("[czs]=", "!");
        input=input.replaceAll("[cd]-", "@");
        
        System.out.println(input.length());

    }
}
