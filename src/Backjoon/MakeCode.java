package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MakeCode {
    static ArrayList<Character> vowels;
    static ArrayList<Character> consonants;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        int L = Integer.parseInt(temp[0]);
        int C = Integer.parseInt(temp[1]);
        temp = br.readLine().split(" ");
        vowels = new ArrayList<>();
        consonants = new ArrayList<>();
        for(int i=0; i<temp.length; i++) {
            if(temp[i].matches("[aeiou]")) {
                vowels.add(temp[i].charAt(0));
            }else {
                consonants.add(temp[i].charAt(0));
            }
        }
        int vc = 1;
        ArrayList<String> result = new ArrayList<>();
        while(vc<=5 && (L-vc)>=2) {

        }
        


    }
    public static void combi (boolean check[],int depth,int n,int m) {
        if(m==0) {
            for(int i=0;i<n;i++) {
                if(check[i]==true) {
                    
                }
            }
            System.out.println();
            return;
        }
        for(int i=depth;i<n;i++) {
            check[i]=true;
            combi(check,i+1,n,m-1);
            check[i]=false;
        }
    }
}
