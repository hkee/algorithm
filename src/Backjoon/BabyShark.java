package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class fish {
    int x;
    int y;
    int no;
    fish(int x,int y,int no) {
        this.x = x;
        this.y = y;
        this.no = no;
    }
}

public class BabyShark {
    static int N;
    static int map[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int sx,sy;
        for(int i=0;i<N;i++) {
            String temp[] = br.readLine().split(" ");
            for(int j=0;j<N;j++) {
                if(temp[j].equals("9")) {
                    sx=j;
                    sy=i;
                }
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        ArrayList<fish> edibleFish = new ArrayList<>();

        int sSize = 1;
        int level = 0;

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                edibleFish.add(new fish(j,i,i*4+j));
            }
        }
    }
}
