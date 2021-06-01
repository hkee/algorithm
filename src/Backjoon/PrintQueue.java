package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Print {
    int no;
    int priority;
    Print(int no,int p) {
        this.no = no;
        this.priority = p;
    }
    
}

public class PrintQueue {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T; t++) {
            int result = 0;
            String temp[] = br.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int m = Integer.parseInt(temp[1]);
            temp = br.readLine().split(" ");
            Queue<Print> q = new LinkedList<>();
            ArrayList<Integer> pArr = new ArrayList<Integer>();
            for(int i=0; i<n; i++) {
                q.offer(new Print(i,Integer.parseInt(temp[i])));
                pArr.add(Integer.parseInt(temp[i]));
            }
            Collections.sort(pArr);
            while(true) {
                int max = pArr.get(pArr.size()-1);
                Print p = q.poll();
                if(p.priority==max) {
                    result++;
                    pArr.remove(pArr.size()-1);
                    if(p.no==m) {
                        break;
                    }
                }else {
                    q.offer(p);
                }
            }
            System.out.println(result);
            

        }
    }
}
