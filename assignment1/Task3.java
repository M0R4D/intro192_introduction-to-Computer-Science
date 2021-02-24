import java.util.Scanner;

public class Task3 {
	public static void main(String[] args) {


        // ----------------- write your code BELOW this line only --------
        // your code here (add lines)
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int x = a*d + b*c;
        int y = b*d;
        int GCD; int up = x; int down = y; // r = GCD, m = up, n = down
        // find the GCD with euclid algorithm
        while(down != 0) {
            GCD = up % down; // r = m%n
            up = down; // m = n;
            down = GCD; // n = GCD
        }
        GCD = up;
        System.out.println(x/GCD); // + "\n" + y/GCD);
        System.out.println(y/GCD);
        // ----------------- write your code ABOVE this line only ---------


	}
}
