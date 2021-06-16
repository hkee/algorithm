package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;



public class AC {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            int dcount = p.replaceAll("R", "").length();
            String x[] = br.readLine().replaceAll("[\\[\\]]", "").split(",");
            if(n-dcount<0) {
                System.out.println("error");
                continue;
            }
            boolean isRight = true;
            Deque<String> deq = new ArrayDeque<>(Arrays.asList(x));
            for(int i=0;i<p.length();i++) {
                if(p.charAt(i)=='R') {
                    isRight = !isRight;
                }else {
                    if(isRight) {
                        deq.pollFirst();
                    }else {
                        deq.pollLast();

                    }
                }
            }
            System.out.print("[");
            if(isRight) {
                String e = deq.pollFirst();
                if(e!=null) {
                    System.out.print(e);
                }
                while(!deq.isEmpty()) {
                    System.out.print(","+deq.pollFirst());
                }
            }else {
                String e = deq.pollLast();
                if(e!=null) {
                    System.out.print(e);
                }
                while(!deq.isEmpty()) {
                    System.out.print(","+deq.pollLast());
                }
            }

            System.out.println("]");

            
        }

    }
}
