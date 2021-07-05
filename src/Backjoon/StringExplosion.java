package Backjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringExplosion {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();
        char lastP = p.charAt(p.length()-1);
        char st[] = new char[s.length()];
        int stIdx = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)!=lastP) {
                st[stIdx]=s.charAt(i);
                stIdx++;
                //st.add(s.charAt(i));
            }else {
                if(stIdx<p.length()-1) {
                    st[stIdx]=s.charAt(i);
                    stIdx++;
                }else {
                    Boolean flag = true;
                    int c = 0;
                    for(int j = p.length()-2; j>=0; j--) {
                        if(p.charAt(j)!=st[stIdx-1-c]) {
                            flag = false;
                            break;
                        }
                        c++;
                    }
                    if(flag) {
                        stIdx-=p.length()-1;
                        st[stIdx]='\0';
                    }else {
                        st[stIdx]=s.charAt(i);
                        stIdx++;
                    }
                }
            }
        }
        if(st[0]=='\0') {
            System.out.println("FRULA");
        }else {
            int i=0;
            StringBuilder sb = new StringBuilder();
            while(i<stIdx) {
                sb.append(st[i]);
                i++;
            }
            System.out.println(sb.toString());
        }
    }
}
