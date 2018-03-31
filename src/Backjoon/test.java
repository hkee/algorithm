package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class test {
	   

	   public static void main(String[] args) throws Exception {
	        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
	            final int T = Integer.parseInt(br.readLine().trim());
	            long result1=1;
	            long result2=1;
	            long fresult1;
	            long fresult2;
	            long ff;
	            for (int i = 0; i < T; i ++) {
	                final StringTokenizer tokenizer = new StringTokenizer(br.readLine().trim());
	                int N = Integer.parseInt(tokenizer.nextToken());
	                int K = Integer.parseInt(tokenizer.nextToken());
	                int M = Integer.parseInt(tokenizer.nextToken());
	                result1=1;
	                result2=1;
	                for(int j=0;j<M;j++) {
	                	result1*=(N-j);
	                }
	                for(int j=M;j>=1;j--) {
	                	result2*=j;
	                }
	                fresult1=result1/result2;
	                result1=1;
	                result2=1;
	                for(int j=0;j<K-M;j++) {
	                	result1*=(N-j);
	                }
	                for(int j=K-M;j>=1;j--) {
	                	result2*=j;
	                }
	                fresult2=result1/result2;
	               
	                //System.out.println(fresult1);
	                //System.out.println(fresult2);
	                ff=fresult1*fresult2;
	                if(ff>1003001) {
	                	ff=ff%1003001;
	                }
	                System.out.println(ff);
	                
	            }//for
	        }
	    }
	   

}//class
