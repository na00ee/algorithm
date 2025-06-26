import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, n;
    static StringBuilder sb = new StringBuilder();
    static int [][] f = new int [41][2];
    static boolean[] visited = new boolean [41];
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        f[0][0] = 1;
        f[1][1] = 1;
        visited[0] = true;
        visited[1] = true;

        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            sb.append(dp(n)[0]).append(" ").append(dp(n)[1]).append("\n");
        }
        
        System.out.println(sb.toString());
    }

    static int[] dp (int n) {
        if (!visited[n]) {
            visited[n] = true;
            int [] a = dp(n-1);
            int [] b = dp(n-2);
            f[n][0] = a[0] + b[0];
            f[n][1] = a[1] + b[1];
        }
        return f[n];
    }
}
