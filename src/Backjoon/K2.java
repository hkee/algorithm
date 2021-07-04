package Backjoon;

import java.util.ArrayList;

public class K2 {
    public static void main(String[] args) {
        String s = "abcxyqwertyxyabc";
        String c = new String(s);
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> a = new ArrayList<>();
        while(s.length()!=0) {
            int sl = 1;
            while(sl<=s.length()) {
                String findString = s.substring(0, sl);
                if(findString.equals(s.substring(s.length()-sl, s.length()))) {
                    if(s.length()-sl!=0) {
                        s = s.substring(sl, s.length()-sl);
                    }else {
                        s = s.replace(findString, "");

                    }
                    result.add(findString);
                    break;
                }
                sl++;
            }
        }

        for(int i=0;i<result.size();i++) {
            a.add(result.get(i));
            c=c.replaceFirst(result.get(i), "");
        }
        
        for(int i=result.size()-1;i>=0;i--) {
            if(c.contains(result.get(i))) {
                a.add(result.get(i));
            }
        }
        String[] answer = a.toArray(new String[a.size()]);
    
    }
}
