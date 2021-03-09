import java.util.Scanner;
import java.util.Arrays;

public class minimumscalar_260883135 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // number of test cases

        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt(); // dim of vectors

            Long[] v1 = new Long[n];
            Long[] v2 = new Long[n];

            // populate queues which are the vectors
            for (int i = 0; i < n; i++) {
                v1[i] = sc.nextLong();
            }
            for (int i = 0; i < n; i++) {
                v2[i] = sc.nextLong();
            }
            Arrays.sort(v1);
            Arrays.sort(v2);

            Long sum = (long) 0;
            for (int i = 0; i < n; i++) {
                sum += v1[i] * v2[n-i-1];
            }

            System.out.println("Case #" + t + ": " + sum);

        }

        sc.close();
    }
}
