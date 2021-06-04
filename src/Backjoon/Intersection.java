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
        List<String> result = new ArrayList<String>();
        for(int i=0;i<n;i++) {
            see.add(br.readLine());
        }
        Collections.sort(see);
        int index;
        for(int i=0;i<m;i++) {
            String target=br.readLine();
            index = Collections.binarySearch(see, target);
            if(index>=0) {
                result.add(target);
            }
        }
        Collections.sort(result);
        
        System.out.println(result.size());
        for(int i=0;i<result.size();i++) {
            System.out.println(result.get(i));
        }

    }
}
