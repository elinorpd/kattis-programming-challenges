import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class kastenlauf_260883135 {

    public static int ManhattanDist(int ax, int ay, int bx, int by) {
        return (Math.abs(ax - bx) + Math.abs(ay - by));
    }
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine()); // num of test cases

        for (int i = 0; i < t; i++) { // loop thru test cases
            int n = Integer.parseInt(br.readLine()) + 2; // num places (+2 for his house and the destination)
            int[] x = new int[n]; // x coord list
            int[] y = new int[n]; // y coord list
            boolean[] visited = new boolean[n]; // track whether a stop has been visited
            LinkedList<Integer> q = new LinkedList<>();

            for (int j = 0; j < n; j++) { // put the coordinates of the stop
                String[] coords = br.readLine().split(" ");
                x[j] = Integer.parseInt(coords[0]);
                y[j] = Integer.parseInt(coords[1]);
            }
            q.add(0); // add his house
            while (!q.isEmpty()) {
                int curr = q.remove();
                if (!visited[curr]) { // visit the current stop
                    visited[curr] = true;
                    for (int b = 0; b < n; b++) {
                        if (curr != b) {
                            if (ManhattanDist(x[curr], y[curr], x[b], y[b]) <= 1000) {
                                q.add(b); // if reachable, add stop to the list
                            }
                        }
                    }
                }
            }
            if (visited[n-1]) { // if we visited the last stop, i.e. the destination
                bw.write("happy\n");
            } else {
                bw.write("sad\n");
            }
            bw.flush();
        }

    }
}
