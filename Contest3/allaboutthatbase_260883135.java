import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import java.util.Scanner;

import java.math.BigInteger;

public class allaboutthatbase_260883135 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt(); // num test cases
        for (int i = 0; i < n; i++) {
            String x = sc.next();
            String op = sc.next();
            String y = sc.next();
            sc.next();
            String z = sc.next();
            boolean none = true; // set to true if works in >=1 base

            // base 1 is special
            if (x.matches("1+") && y.matches("1+") && z.matches("1+")) {
                boolean base1 = false;
                int lenx = x.length();
                int leny = y.length();
                int lenz =z.length();
                if (op.equals("+")) {
                    if (lenx+leny==lenz) {
                        base1=true;
                        none=false;
                    }
                } else if (op.equals("*")) {
                    if (lenx*leny==lenz) {
                        base1=true;
                        none = false;
                    }
                } else if (op.equals("-")) {
                    if (lenx-leny==lenz) {
                        base1=true;
                        none = false;
                    }
                } else if (op.equals("/")) {
                    if (lenx/leny==lenz) {
                        base1=true;
                        none = false;
                    }
                }
                if (base1) bw.write("1");
            }
            

            // loop thru all bases 2-36
            for (int b = 2; b < 37; b++) { 
                boolean correct = false;
                BigInteger xx, yy, zz;
                try {
                    xx = new BigInteger(x,b);
                    yy = new BigInteger(y,b);
                    zz = new BigInteger(z,b);
                } catch (Exception e) {
                    continue; // if you cant represent the number in base b, just skip
                }
                // now test if the expression is valid
                if (op.equals("+")) {
                    if (xx.add(yy).equals(zz)) {
                        correct=true;
                        none = false;
                    }
                } else if (op.equals("*")) {
                    if (xx.multiply(yy).equals(zz)) {
                        correct=true;
                        none = false;
                    }
                } else if (op.equals("-")) {
                    if (xx.subtract(yy).equals(zz)) {
                        correct=true;
                        none = false;
                    }
                } else if (op.equals("/")) {
                    BigInteger[] result = xx.divideAndRemainder(yy);
                    if (result[0].equals(zz) && result[1].equals(new BigInteger("0"))) {
                        correct=true;
                        none = false;
                    }
                }
                if (correct) {
                    BigInteger _b = new BigInteger(Integer.toString(b),10);
                    BigInteger base36 = new BigInteger("36");
                    String base = _b.mod(base36).toString(36); // base in integer format
                    bw.write(base); // print base
                }
            
            }
        if (none) System.out.println("invalid");
        else {
            bw.write("\n");
            bw.flush();
        }
        }
        sc.close();
    }
    
}
