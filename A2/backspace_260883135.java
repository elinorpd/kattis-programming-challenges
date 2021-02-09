import java.util.Scanner;
import java.util.Stack;
import java.lang.StringBuilder;

public class backspace_260883135 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // use a stack and pop every time a '<' is found
        Stack<Character> s = new Stack<Character>(); // create a character stack
        String line = sc.nextLine();
        StringBuilder fin = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i=0; i < line.length(); i++) {
            if (line.charAt(i)!= '<') {
                s.push(line.charAt(i));
            }
            else {
                s.pop();
            }
        }
        while (!s.isEmpty()) {
            fin.append(s.pop()); // reconstruct the final string except its backwards
        }
        for (int i = fin.length()-1; i >= 0; i--) {
            result.append(fin.charAt(i));
        }
        System.out.println(result);
        sc.close();
    }
}