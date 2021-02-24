// You may not change or erase any of the lines and comments 
// in this file. You may only add lines.

import java.util.Scanner;

public class Task7 {


    public static void main(String[] args){


        // ----------------- write any code BELOW this line only --------
        // your code here (add lines)
        int a,b,c,d;
        int contradictchecker = 0;
        // boolean isContradict = false;
        for(int i = 0; i <= 1; i++) {
            for(int j = 0; j <= 1; j++) {
                for(int k = 0; k <= 1; k++) {
                    for(int l = 0; l <= 1; l++) {
                        a = i;
                        b = j;
                        c = k;
                        d = l;

        // ----------------- write any code ABOVE this line only ---------




        // -----------------  copy here the code from Task 6 that is between
        // -----------------  the comments "A" and "B"
        // code from Task 6 here
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
        // -----------------  end of copied code from Task 6




        // ----------------- write any code BELOW this line only --------
        // your code here (add lines)
                        if(a>c || a>d || b>c || b>d) {
                            contradictchecker++;
                            // if(contradictchecker == 1) {
                                System.out.println("contradict example: \na = " + i + ", b = " + j + ", c = " + k + ", d = " + l);
                            // }
                        }
                    }
                }
            }
        }
        if(contradictchecker == 0) {
            System.out.println("Verified");
        }
        // ----------------- write any code ABOVE this line only ---------

    } // end of main
} //end of class Task7

