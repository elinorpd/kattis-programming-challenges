import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class phonelist_260883135 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine()); // num of test cases

        for (int i = 0; i < t; i++) { // loop thru test cases
            int n = Integer.parseInt(br.readLine()); // num phone numbers
            ArrayList<String> numbers = new ArrayList<>(); // list of phone numbers
            for(int j=0; j<n; j++) {
                numbers.add(br.readLine()); // get next phone number
            }
            Collections.sort(numbers); // sort the phone numbers to compare pairwise
            boolean consistent = true;

            for (int j=1; j<n; j++) {
                if (numbers.get(j).length() > numbers.get(j-1).length()) { // len phone number is greater than previous
                    String currprefix = numbers.get(j).substring(0, numbers.get(j-1).length());
                    String prev = numbers.get(j-1);
                    if (currprefix.equals(prev)) {
                        consistent=false;
                    }
                }
                else {
                    String prevprefix = numbers.get(j-1).substring(0, numbers.get(j).length());
                    String curr = numbers.get(j);
                    if (prevprefix.equals(curr)) {
                        consistent=false;
                    }
                }
            }
            if(consistent) {
                bw.write("YES\n");
            }
            else {
                bw.write("NO\n");
            }
            bw.flush();
        }
    }
}
