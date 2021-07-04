package Backjoon;

import java.util.Arrays;


public class K1 {
    public static void main(String[] args) throws Exception {
        Integer prices[] = {13000,88000,10000};
        int discounts[] = {30,20};
        int answer = 0;
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int pIndex = prices.length-1;
        int dIndex = discounts.length-1;
        while(dIndex>=0) {
            prices[pIndex] = prices[pIndex] * (100-discounts[dIndex])/100;
            dIndex-=1;
            pIndex-=1; 
        }
        for(int p:prices) {
            answer+=p;
        }
        System.out.println(answer);
        
    }
}
