package Backjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Intersection {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,m;
        String temp[] = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        List<String> see = new ArrayList<String>();
        List<String> hear = new ArrayList<String>();
        for(int i=0;i<n;i++) {
            see.add(br.readLine());
        }
        for(int i=0;i<m;i++) {
            hear.add(br.readLine());
        }
        Collections.sort(see);
        Collections.sort(hear);
        see.retainAll(hear);
        for(int i=0;i<see.size();i++) {
            System.out.println(see.get(i));
        }

    }
}
