import java.util.Scanner;

public class QuickBrownFox_260883135 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); // num test cases
        sc.nextLine(); // advance scanner to take next input

        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for (int i=0; i < num; i++) {
            boolean[] pres = new boolean[26]; // make array of bool for tracking char presence T / F
            StringBuilder letters = new StringBuilder("missing ");
            int index = 0; 
            boolean pang = true; 
            String l = sc.nextLine().toLowerCase(); // get the next line to test, make it lowercase
            //System.out.println("This is the current line: " + l + "\n\n");
            for (int j = 0; j < l.length(); j++) {
                index = (int)l.charAt(j)-'a'; // get index of char
                //System.out.print(l.charAt(j));;
                if (index >= 0 && index < 26) {
                    pres[index]=true;
                    //System.out.print(" is alphabet\n");
                }
            }
            for (int k = 0; k < 26; k++){
                if (!pres[k]) { // if char is not present
                    pang = false;
                    letters.append(alphabet[k]); // add the corresponding missing char
                }
            }
            if (pang){
                System.out.println("pangram");
            }
            else {
                System.out.println(letters);
            }
            
        }
        sc.close();
    }
}
