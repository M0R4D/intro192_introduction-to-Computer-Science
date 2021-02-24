import java.util.Scanner;

public class Task2 {
	public static void main(String[] args) {

        // ----------------- write your code BELOW this line only --------
        // your code here (add lines)
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int i = 2;
        while(n > 1) {
            if(n % i == 0) {
                System.out.println(i);
                n /= i;
            }
            else i++;
        }
        // ----------------- write your code ABOVE this line only ---------

	}
}
