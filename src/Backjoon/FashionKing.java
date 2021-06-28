package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class FashionKing {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            int n = Integer.parseInt(br.readLine());
            int result = 1;
            HashMap<String,Integer> map = new HashMap<>();
            for(int j=0;j<n;j++) {
                String input[] = br.readLine().split(" ");
                if(map.containsKey(input[1])) {
                    int c = map.get(input[1])+1;
                    map.put(input[1], c);
                }else {
                    map.put(input[1], 1);
                }
            }
            for(String s : map.keySet()) {
                result*=map.get(s)+1;
            }
            System.out.println(result-1);


        }
    }
}
