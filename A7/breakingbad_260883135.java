import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Scanner;

public class breakingbad_260883135 {

    static HashMap<String, HashSet<String>> map;
    static HashSet<String> walter, jesse;
    static ArrayList<String> allitems;
    static boolean possible;

    static void check(String s) {
        if (!walter.contains(s) && !jesse.contains(s)) {
            // if the item is in neither list, add it to one
            walter.add(s);
        }
        for (String st : map.get(s)) { // for each item that cant be bought with the item in consideration
            if (walter.contains(s) && !walter.contains(st) && !jesse.contains(st)) {
                // walter buys s, st isnt in either list
                jesse.add(st); // jesse buys st
                check(st); // check st
            } else if (jesse.contains(s) && !jesse.contains(st) && !walter.contains(st)) {
                // jesse buys s, st isnt in either list
                walter.add(st); // walter buys st
                check(st); // check st
            } else if ((jesse.contains(s) && jesse.contains(st)) || (walter.contains(s) && walter.contains(st))) {
                // we have an impossible pairing
                possible = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map = new HashMap<>();

        // a and b are the two grocery lists for walter and jesse
        walter = new HashSet<>();
        jesse = new HashSet<>();
        possible = true;
        allitems = new ArrayList<>(); // list with all the items
        // and add all of the items as keys to the hashmap map with an empty hashset as the value
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            map.put(s, new HashSet<>());
            allitems.add(s);
        }
        int M = sc.nextInt();
        // loop through the suspicious pairs
        for (int i = 0; i < M; i++) {
            String x = sc.next();
            String y = sc.next();
            // add each item to each others hashsets in map
            map.get(x).add(y);
            map.get(y).add(x);
        }
        for (String s : allitems) { // for each item in the list, check whether or not we have any issues
            check(s);
        }

        if (possible) { // print lists a and b on separate lines if possible to split
            for (String s : walter) {
                System.out.print(s + " ");
            }
            System.out.println();
            for (String s : jesse) {
                System.out.print(s + " ");
            }
        } else {
            System.out.println("impossible");
        }
        sc.close();
    }


}
