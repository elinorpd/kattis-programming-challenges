import java.util.Scanner;

public class telephone_260883135 {
    int start;
    int stop;
    public telephone_260883135(int a, int b) { // constructor
        start = a;
        stop = a+b;
    }
    public int intersects(telephone_260883135 other) { // returns 1 if there is overlap, 0 otherwise
        if ((this.start <= other.start) && (other.start  < this.stop)) { return 1;}
        else if ((this.start < other.stop) && (other.stop  <= this.stop)) { return 1;}
        else if ((other.start < this.start) && (other.stop  > this.stop)) { return 1;}
        else { return 0;}
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt(); // num phone calls
            int m = sc.nextInt(); //  num intervals
            if ((n==0)&&(m==0)){
                sc.close();
                break;
            }
            telephone_260883135[] intervals = new telephone_260883135[n]; 
            for (int i = 0; i < n; i++) {
                int _source = sc.nextInt(), _dest = sc.nextInt(), start = sc.nextInt(), duration = sc.nextInt();
                intervals[i] = new telephone_260883135(start, duration); // create new telephone call object
            }
            
            for (int i = 0; i < m; i++) {
                int tot = 0;
                int start = sc.nextInt(), duration = sc.nextInt();
                telephone_260883135 iv = new telephone_260883135(start, duration);
                for (int j = 0; j < intervals.length-1; j++) {
                    tot += iv.intersects(intervals[j]);
                }
                System.out.println(tot);
            }
        }
        sc.close();
    }
}