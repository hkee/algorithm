package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FamilyCount {
    static int pNum;
    static int visited[];
    static int map[][];
    static int result = -1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pNum = Integer.parseInt(br.readLine());
        String temp[] = br.readLine().split(" ");
        int p1 = Integer.parseInt(temp[0]);
        int p2 = Integer.parseInt(temp[1]);
        map = new int[pNum+1][pNum+1];
        visited = new int[pNum+1];
        int m = Integer.parseInt(br.readLine());
        for(int c=0;c<m;c++) {
            temp = br.readLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            map[x][y]=1;
            map[y][x]=1;
        }
        findFamily(p1, p2, 1);
        System.out.println(result);


    }
    public static void findFamily(int start, int end,int count) {
        visited[start]=1;
        if(map[start][end]==1) {
            result = count;
            return;
        }
        for(int i=1;i<=pNum;i++) {
            if(visited[i]==0 && map[start][i]==1) {
                visited[i]=1;
                findFamily(i, end, count+1);
                
            }
        }

    }
}
