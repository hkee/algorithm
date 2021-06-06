package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;

class WordC {
    String w;
    int c;
    WordC(String w, int c) {
        this.w = w;
        this.c = c;
    }
    public String getW() {
        return w;
    }
    public int getC() {
        return c;
    }
}

public class WordSort {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<N;i++) {
            set.add(br.readLine());
        }
        Iterator<String> iter = set.iterator();
        ArrayList<WordC> wordList = new ArrayList<>();
        String temp;
        while(iter.hasNext()) {
            temp = iter.next();
            wordList.add(new WordC(temp, temp.length()));
        }
        wordList.sort(Comparator.comparing(WordC::getC).thenComparing(WordC::getW));
        for(int i=0;i<wordList.size();i++) {
            System.out.println(wordList.get(i).w);
        }    

    }
}
