// You may not change or erase any of the lines and comments 
// in this file. You may only add lines in the designated 
// area.

import java.util.Scanner;

public class Task6 {


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();	
        int d = scanner.nextInt();

        // ----------------- "A": write your code BELOW this line only --------
        // your code here (add lines)
        if (a>d) {
            int tmp = d;
            d = a;
            a = tmp;
        }
        if (a>c) {
            int tmp = c;
            c = a;
            a = tmp;
        }
        if (b>d) {
            int tmp = d;
            d = b;
            b = tmp;
        }
        if (b>c) {
            int tmp = c;
            c = b;
            b = tmp;
        }
        // ----------------- "B" write your code ABOVE this line only ---------

        System.out.println(a);
        System.out.println(b);

    } // end of main
} //end of class Task6

