import java.util.HashSet;
import java.util.HashMap;
//import java.util.Scanner;
import java.io.*;


public class wheresmyinternet_260883135 {
    static HashMap<Integer, HashSet<Integer>> houses;
    static boolean[] visited;

    
    public static void connection(int c) {
        // will fill the visited list with anything connected to 1 and any of its connections
        visited[c] = true;
        HashSet<Integer> connected = houses.get(c); // list of houses that house c is connected to
        for (int i : connected) {
            if (!visited[i]) {
                connection(i);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] l = reader.readLine().split(" "); // get first input line
        int n = Integer.parseInt(l[0]);
        int m = Integer.parseInt(l[1]);
        // hash map where keys are house nums 
        // values are sets containing houses it is connected to
        houses = new HashMap<Integer, HashSet<Integer>>();
        visited = new boolean[n+1];
        boolean allConnected = true;

        // initialize hash sets to store the connected houses
        for (int i = 0 ; i <= n; i++) {
            houses.put(i, new HashSet<Integer>());
        }

        for (int i = 0; i < m; i++) { // mark down connections
            l = reader.readLine().split(" ");
            int a = Integer.parseInt(l[0]); // first house
            int b = Integer.parseInt(l[1]); // second house
            houses.get(a).add(b);
            houses.get(b).add(a);
        }

        connection(1); // house 1 is connected, this function fills visible[] with true for all connected houses

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) { // check if any houses aren't visited
                allConnected = false;
                writer.append(i + "\n"); // add unconnected house to output
            }
        }
        if (allConnected) {
            System.out.println("Connected");
        }
        else {
            writer.flush();
        }
    }
}