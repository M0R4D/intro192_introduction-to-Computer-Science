import java.util.Scanner;

public class Task5 {
	public static void main (String args[]){

        // ----------------- write your code BELOW this line only --------
        // your code here (add lines)
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        if (x>y) {
            int tmp = y;
            y = x;
            x = tmp;
        }
        if (y>z) {
            int tmp = z;
            z = y;
            y = tmp;
        }

        System.out.println(x);
        System.out.println(y);
        // ----------------- write your code ABOVE this line only ---------

	}
}
