package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FamilyCount {
    static int pNum;
    static int visited[];
    static int map[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pNum = Integer.parseInt(br.readLine());
        String temp[] = br.readLine().split(" ");
        int p1 = Integer.parseInt(temp[0]);
        int p2 = Integer.parseInt(temp[1]);
        map = new int[pNum+1][pNum+1];
        for(int c=0;c<pNum;c++) {
            temp = br.readLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            map[x][y]=1;
            map[y][x]=1;
        }


    }
    public static void findFamily(int start, int end) {
        if(map[start][end]==1) {
            
        }
    }
}
