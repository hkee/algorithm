package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MakeCode {
    static ArrayList<Character> vowels;
    static ArrayList<Character> consonants;
    static ArrayList<Character> vSelected;
    static ArrayList<Character> cSelected;
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
        vSelected = new ArrayList<>();
        cSelected = new ArrayList<>(); 
        boolean vCheck[] = new boolean[vowels.size()];
        boolean cCheck[] = new boolean[consonants.size()];
        while(vc<=5 && (L-vc)>=2) {
            
        }
        


    }
    
}
