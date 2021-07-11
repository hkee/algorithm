package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BasketBall {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Character,Integer> map = new HashMap<>();
        Set<Character> result = new HashSet<>();
        for(int i=0;i<n;i++) {
            char first = br.readLine().charAt(0);
            if(!map.containsKey(first)) {
                map.put(first, 1);
            }else {
                int value = map.get(first);
                if(value<5) {
                    map.put(first, value+1);
                    if(value+1==5) {
                        result.add(first);
                    }
                }else {
                    result.add(first);
                }
            }
        }
        if(result.isEmpty()) {
            System.out.println("PREDAJA");
        }else {
            ArrayList<Character> r = new ArrayList<>(result);
            Collections.sort(r);
            System.out.println(r.toString().replaceAll("[^a-z]", ""));
        }
        

    }
}
