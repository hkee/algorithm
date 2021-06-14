package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class MakeCode {
    static int L;
    static int C;
    static int vc;
    static ArrayList<Character> vowels;
    static ArrayList<Character> consonants;
    static ArrayList<Character> vSelected;
    static ArrayList<Character> cSelected;
    static ArrayList<String> result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        L = Integer.parseInt(temp[0]);
        C = Integer.parseInt(temp[1]);
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
        vc = 1;
        result = new ArrayList<>();
        vSelected = new ArrayList<>();
        cSelected = new ArrayList<>(); 
        while(vc<=5 && (L-vc)>=2) {
            vCombi(0, vowels.size(), vc);
            vc++;
        }
        Collections.sort(result);
        for(String s :result) {
            System.out.println(s);
        }


    }
    public static void vCombi (int depth,int n,int m) {
        if(m==0) {
            cCombi(0, consonants.size(), L-vc);
            return;
        }
        for(int i=depth;i<n;i++) {
            vSelected.add(vowels.get(i));
            vCombi(i+1,n,m-1);
            vSelected.remove(vSelected.size()-1);
        }
    }
    public static void cCombi (int depth,int n,int m) {
        if(m==0) {
            ArrayList<Character> join = new ArrayList<>();
            join.addAll(vSelected);
            join.addAll(cSelected);
            Collections.sort(join);
            String temp = "";
            for(char c : join) {
                temp+=c;
            }
            result.add(temp);
            return;
        }
        for(int i=depth;i<n;i++) {
            cSelected.add(consonants.get(i));
            cCombi(i+1,n,m-1);
            cSelected.remove(cSelected.size()-1);
        }
    }
}
