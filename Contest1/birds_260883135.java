import java.util.Scanner;
import java.util.Arrays;


public class birds_260883135 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt(); // length of wire
        int d = sc.nextInt(); // dist between birds
        int startpos = 6;
        int endpos = l-6;
        int maxbirds = ((l-12)/d) +1;
        int n = sc.nextInt(); // number of birds currently on the wire
        int[] birdarray = new int[n];

        if (l<12) { System.out.println(0);}
        else if (n == maxbirds) {System.out.println(0);}
        else if (n == 0) {System.out.println(maxbirds);}
        else {
            for (int i = 0; i < n; i++){
                birdarray[i]=sc.nextInt();
            }
            sc.close();
            Arrays.sort(birdarray);

            int tot = 0; // tot birds added
            int left = birdarray[0] - startpos;
                int right = endpos - birdarray[birdarray.length - 1];
                tot += (left / d) + (right / d);

                for (int x = 0; x < n - 1; x++) {
                    int distanceBtwn = birdarray[x + 1] - birdarray[x];
                    tot += (distanceBtwn / d) - 1;
                }
            System.out.println(tot);

        }
    }
}
