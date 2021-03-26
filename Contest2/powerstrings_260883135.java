import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class powerstrings_260883135 {
    public static boolean check(String s, int n) {
        for(int i = n; i < s.length(); i++) {
            // check if ith char is equal to the i-nth char (ie that it is a^n)
            if (s.charAt(i) != s.charAt(i-n)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 10; i++) {
            String s = br.readLine();
            if (s.equals(".")) { // check for end of input
                break;
            } else {
                int n = s.length();
                for (int j = 1; j <= n; j++) {
                    if(n % j == 0) { //only works if n is a multiple of i 
                        if(check(s, j)) { // if the check works, then we have a^n
                            Integer x = n/j;
                            bw.write(x.toString()+"\n");
                            break;
                        }
                    }
                }
            }
            bw.flush();
        }
        
    }
}
