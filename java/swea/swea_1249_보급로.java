//보급로
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class swea_1249_보급로 {
    static final int INF = Integer.MAX_VALUE;
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};
    static int[][] arr;
    static int n;
 
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = s.charAt(j) - '0';
                }
            }
            sb.append("#").append(t).append(" ").append(dijkstra()).append("\n");
        }
        System.out.print(sb);
    }
 
    public static int dijkstra() {
        int[][] dist = new int[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }
        dist[0][0] = 0;
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int y = pos[0];
            int x = pos[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }
                if (dist[ny][nx] > dist[y][x] + arr[ny][nx]) {
                    dist[ny][nx] = dist[y][x] + arr[ny][nx];
                    q.add(new int[]{ny, nx});
                }
            }
        }
        return dist[n - 1][n - 1];
    }
}