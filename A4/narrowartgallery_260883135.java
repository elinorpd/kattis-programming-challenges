import java.util.Scanner;

public class narrowartgallery_260883135 {
    static final int LEFT = 0;
    static final int RIGHT = 1;
    static final int INF = 10000000;

    static int[][] roomvals; // store gallery room values [row][col]
    static Integer[][][] states; // store various states, [k=num rooms to close][r=row][c=col]

    //public static int minsub(int k, int r) {}

    public static int subgallery(int k, int r, int c) {
        // check for base cases
        if (k==0) {return 0;} // we have no more rooms to close and are done
        if (r<0) {return INF;} // negative row is not realistic so give a huge number to not pick it
        if (states[k][r][c] != null) { // if the state has already been computed
            //System.out.println("already computed");
            return states[k][r][c];
        }
        // compute min of the subproblems
        int res = Math.min(
            (subgallery(k-1,r-1,c) + roomvals[r][c]), // assume current room should be closed
            Math.min(subgallery(k,r-1,LEFT), // cur not closed, try sub left
            subgallery(k,r-1,RIGHT)) // cur not closed, try sub right
        );
        states[k][r][c] = res;
        //System.out.println(res);
        return res;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) { // getting the inputs
            int N = sc.nextInt(); // first input is number of rows
            int K = sc.nextInt(); // second input is number of rooms to close
            if ((N==0)&&(K==0)) {break;}
            roomvals = new int[N][2]; // initialize the gallery array
            states = new Integer[K + 1][N][2]; // initialize states array
            
            int tot = 0; // total value of all rooms
            // populate the room values
            for (int i = 0; i < N; i++) {
                roomvals[i][LEFT] = sc.nextInt();
                roomvals[i][RIGHT] = sc.nextInt();
                tot += roomvals[i][RIGHT] + roomvals[i][LEFT]; // sum the values
            }
            // calculate the result of the closings and subtract from total to get output
            int result = tot - Math.min(subgallery(K,N-1,LEFT), subgallery(K,N-1,RIGHT)); 
            System.out.println(result); // print result
        }
        sc.close();





    }


}