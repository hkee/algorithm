package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Cmd {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String base[] = br.readLine().split("");
        String target[];
        for(int i=1;i<N;i++) {
            target = br.readLine().split("");
            for(int j=0;j<base.length;j++) {
                if(!base[j].equals(target[j])) {
                    base[j]="?";
                }
            }
        }
        for(int i=0;i<base.length;i++) {
            System.out.print(base[i]);
        }
    }
}
