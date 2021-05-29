package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
    static int dx[]={0,1,0,-1};
    static int dy[]={1,0,-1,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int visited[][] = new int[N][N];
        int sx=0,sy=0;
        for(int i=0;i<N;i++) {
            String temp[] = br.readLine().split(" ");
            for(int j=0;j<N;j++) {
                if(temp[j].equals("9")) {
                    sx=j;
                    sy=i;
                    map[i][j] = 0;
                }else {
                    map[i][j] = Integer.parseInt(temp[j]);

                }
            }
        }


        int sSize = 2;
        int level = 0;
        boolean go = true;
        int result = 0;

        while(go) {
            for(int c=0;c<N;c++) {
                Arrays.fill(visited[c],-1);
            }
            //탐색
            Queue<fish> q = new LinkedList<>();
            q.offer(new fish(sx, sy, 0));
            visited[sy][sx]=0;
            int min = Integer.MAX_VALUE;
            int ml = N*N;
            
            while(!q.isEmpty()) {    
                fish l = q.poll();
                int nextX=0,nextY=0;
                for(int i=0;i<4;i++) {
                    nextX = l.x+dx[i];
                    nextY = l.y+dy[i];
                    if(nextX<0 || nextY<0 || nextX>=N || nextY>=N) {
                        continue;
                    }
                    if(visited[nextY][nextX]==-1 && map[nextY][nextX]<=sSize) {
                        fish tempF = new fish(nextX,nextY,nextY*N+nextX);
                        visited[nextY][nextX]=visited[l.y][l.x]+1;
                        if(min<visited[nextY][nextX]) {
                            continue;
                        }
                        q.offer(tempF);
                        if(0<map[nextY][nextX] && map[nextY][nextX]<sSize) {
                            //먹을 수 있는 물고기
                            if(min>visited[nextY][nextX]) {
                                min = visited[nextY][nextX];
                                ml = tempF.no;
                            } else if(min==visited[nextY][nextX]) {
                                if(ml>tempF.no) {
                                    ml = tempF.no;
                                }
                            }
                        }
                    }
                }
                
            }
            //먹기
            if(ml!=N*N) {
                map[ml/N][ml%N] = 0;
                sy=ml/N;
                sx=ml%N;
                result+=min;
                level++;
                //level체크
                if(sSize==level) {
                    //탐색부터 다시시작
                    level=0;
                    sSize++;
                }    
            }else {
                break;
            }
            
            
            
        }
        System.out.println(result);
        
    }
}
