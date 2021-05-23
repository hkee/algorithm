package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IslandCount {

	static int w,h;
	static int dx[] = {-1,0,1,-1,1,-1,0,1};
	static int dy[] = {-1,-1,-1,0,0,1,1,1};
	static int totalCount;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		do {
			totalCount=0;
			String input[] = temp.split(" ");
			w = Integer.parseInt(input[0]);
			h = Integer.parseInt(input[1]);
			int map[][] = new int[h][w];
			//map 입력받기
			for(int i=0;i<h;i++) {
				String inputMap[] = br.readLine().split(" ");
				for(int j=0;j<w; j++) {
					map[i][j]=Integer.parseInt(inputMap[j]);
				}
			}
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(map[i][j]==1) {
						totalCount++;
						findIsland(i,j,map);
					}
				}
			}
			System.out.println(totalCount);

			temp = br.readLine();
		}while(!temp.equals("0 0"));
	}
	public static void findIsland(int y,int x,int map[][]) {
		map[y][x] = 0;
		for(int c=0;c<dx.length;c++) {
			int nextY = y+dy[c];
			int nextX = x+dx[c];
			if(nextY<0||nextX<0||nextY>=h||nextX>=w) {
				continue;
			}
			if(map[nextY][nextX]==1) {
				findIsland(nextY, nextX, map);
			}
		}
	}

}
