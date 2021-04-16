import java.util.Scanner;

public class trainpassengers_260883135 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt(); // total capacity
        int n = sc.nextInt(); // number of stops >1
        int curr = 0;
        boolean possible = true;

        for (int i = 0; i < n; i++) { // for each station
            //System.out.println("current capacity="+curr);
            int l = sc.nextInt(); // number that left the train
            int e = sc.nextInt(); // number that entered the train
            int s = sc.nextInt(); // number that stayed on the train
            //System.out.println("left="+l+"\nentered="+e+"\nstayed="+s);

            if ( l > curr) {
                possible = false; // cannot have more people leave than currently on train
                break;
            }
            curr = curr+e-l; // update curr capacity
            //System.out.println("new capacity="+curr);
            if ( curr < 0 || curr > c) {
                possible = false; // cannot have negative people or exceed capacity
                break;
            }
            int room = c-curr; // num spaces left on the train
            if ( s > 0 && room > 0) {
                possible = false; // people wait even though there is room on train
                break;
            }
        }
        if (curr!=0) possible = false; // must end with no passengers

        if (possible) System.out.println("possible");
        else System.out.println("impossible");
        sc.close();
    }
    

}
