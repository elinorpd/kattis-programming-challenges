import java.util.Scanner;

public class Oddities_260883135 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); // num test cases
        for (int i=0; i < num; i++) {
            int t = sc.nextInt();
            if (t%2 == 0) {
                System.out.println(t + " is even");
            }
            else {
                System.out.println(t + " is odd");
            }
        }
    sc.close();
    }

}