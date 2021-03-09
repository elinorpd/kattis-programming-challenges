import java.util.Scanner;
import java.util.Arrays;

public class color_260883135 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt(); // number of socks
        int c = sc.nextInt(); // machine capacity
        int k = sc.nextInt(); // max color difference
        int[] socks = new int[s]; // array of socks
        for (int i = 0; i < s; i++){
            socks[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(socks); // sort socks by color

        int m = 1; // num machines
        int start_i = 0; // index of first sock in machine
        int start_c = socks[0]; // color of first sock in machine
        int curr_i = 0; // index of current sock
        int curr_c = 0; // color of current sock

        for (;curr_i < s; curr_i++) { // loop through socks
            curr_c = socks[curr_i]; // get color of current sock
            if (((curr_i-start_i+1) > c) || (curr_c-start_c > k)) { // exceeded machine capacity or color difference exceeds k
                m +=1; // need a new machine
                start_i = curr_i;
                start_c = curr_c;
            }
            
        }
        System.out.println(m); // print num machines at the end
    }

    
}
