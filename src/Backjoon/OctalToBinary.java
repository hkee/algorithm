package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OctalToBinary {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split("");
        System.out.print(Integer.toBinaryString(Integer.parseInt(input[0],8)));
        for(int i=1;i<input.length;i++) {
            switch(input[i]) {
                case "0" :
                    System.out.print("000");
                    break;
                case "1" :
                    System.out.print("001");
                    break;
                case "2" :
                    System.out.print("010");
                    break;
                case "3" :
                    System.out.print("011");
                    break;
                case "4" :
                    System.out.print("100");
                    break;
                case "5" :
                    System.out.print("101");
                    break;
                case "6" :
                    System.out.print("110");
                    break;
                case "7" :
                    System.out.print("111");
                    break;

            }

        }

    }
}
