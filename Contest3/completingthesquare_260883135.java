import java.util.Scanner;
import java.lang.Math;

public class completingthesquare_260883135 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();
        double d12 = dist(x1,y1,x2,y2); // dist between points 1 and 2
        double d13 = dist(x1,y1,x3,y3);
        double d23 = dist(x2,y2,x3,y3);
        double cx, cy; // center of the square
        int resultx, resulty; // location of fourth corner

        double maxdist = Math.max(Math.max(d12,d13),d23); // length of diagonal

        // to find the center of the square
        // 1. find the two points across the diagonal
        // 2. calculate the midpoint
        // to find fourth corner you add the difference between the remaining corner and the center
        // and add it to the center coordinate
        // because the remaining corner is diagonal from the fourth corner
        if (d12 == maxdist){
            // point 3 is across from fourth corner
            cx = (x1+x2)/2.0;
            cy = (y1+y2)/2.0;
            resultx = (int) (2*cx - x3);
            resulty = (int) (2*cy - y3);
            
        } else if (d13 == maxdist) {
            // point 2 is across from fourth corner
            cx = (x1+x3)/2.0;
            cy = (y1+y3)/2.0;
            resultx = (int) (2*cx - x2);
            resulty = (int) (2*cy - y2);
        } else { // d23==maxdist
            // point 1 is across from fourth corner
            cx = (x3+x2)/2.0;
            cy = (y3+y2)/2.0;
            resultx = (int) (2*cx - x1);
            resulty = (int) (2*cy - y1);
        }
        System.out.println(resultx + " " + resulty);
        sc.close();
    }

    public static double dist(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1-x2, 2)+ Math.pow(y1-y2,2));
    }

}
