import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class baloni_260883135 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // number of balloons
        Integer [] balloons = new Integer [N];

        for (int i = 0; i < N; i++) {
            int h = sc.nextInt();
            balloons[i]=h; // put all the heights into an array
        }
        int[] arrows = new int[(Collections.max(Arrays.asList(balloons))+1)]; // array of length max height

        for (Integer h : balloons) {
            if (arrows[h] == 0) { // if no arrow to pop balloon from above
                arrows[h-1]++; // so add an arrow to pop it
            } else { // there is an arrow to pop this balloon
                arrows[h]--; // pop this balloon
                arrows[h-1]++; // new position of arrow
            }
        }
        
        int sum = 0;
        for (int x : arrows) {
            sum +=x;;
        }

        System.out.println(sum);

        sc.close();
    }
}