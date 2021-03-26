import java.util.LinkedList;
import java.util.Scanner;

public class buttonbashing_260883135 {
    public static void main(String args[]) {
        Scanner sc = new Scanner((System.in));
        int cases = sc.nextInt(); // num test cases
        for (int i = 0; i < cases; i++) {
            int n = sc.nextInt(); // num buttons
            int t = sc.nextInt(); // cooking time
            int[] buttons = new int[n];
            for (int j=0; j<n; j++) {
                buttons[j]=sc.nextInt(); // array with button times
            }
            LinkedList<Integer> q = new LinkedList<>();

            int dist[]= new int[3601];
            for(int j=1; j<3601; j++) {
                dist[j]=Integer.MAX_VALUE; // initialize with (pseudo) infinity
            }
            // initialize beginning with 0
            dist[0]=0;
            q.add(0);

            while (!q.isEmpty()) {
                int curr = q.remove();
                for (int j=0;j<n;j++) {
                    int next = curr + buttons[j];
                    next = Math.max(0, Math.min(3600,next));
                    if (dist[next] > (dist[curr] + 1)) {
                        dist[next] = dist[curr] + 1;
                        q.add(next);
                    }
                }
            }
            for (int j=t; j <= 3600; j++) {
                if (dist[j] != Integer.MAX_VALUE){
                    System.out.println(dist[j]+" "+ (j-t));
                    break;
                }
            }
        }
        sc.close();
    }





}