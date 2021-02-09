import java.util.Scanner;

public class Cold_260883135 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); // num test cases
        int count = 0; // initialize counter to 0
        for (int i = 0; i < num; i ++) {
            int t = sc.nextInt();
            if (t < 0) {
                count++;
            }
        }
        System.out.println(count);
        sc.close();

    }
    
}
