import java.util.Scanner;

public class moscowdream_260883135 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int n = sc.nextInt();

        if (a < 1) { System.out.println("NO");}
        else if (b < 1) { System.out.println("NO");}
        else if (c < 1) { System.out.println("NO");}
        else if (n < 3) { System.out.println("NO");}
        else if ((a+b+c)<n){ System.out.println("NO");}
        else {System.out.println("YES");}
        
        sc.close();

    }


    
}
