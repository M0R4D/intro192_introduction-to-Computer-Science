import java.util.Scanner;

public class Task1 {
	public static void main(String[] args) {


        // ----------------- write your code BELOW this line only --------
        // your code here (add lines)
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if(a <= b && b <= c) System.out.println(a + "\n" + b + "\n" + c); 
        if(a <= c && c <= b) System.out.println(a + "\n" + c + "\n" + b); 
        if(b <= a && a <= c) System.out.println(b + "\n" + a + "\n" + c); 
        if(b <= c && c <= a) System.out.println(b + "\n" + c + "\n" + a); 
        if(c <= a && a <= b) System.out.println(c + "\n" + a + "\n" + b); 
        if(c <= b && b <= a) System.out.println(c + "\n" + b + "\n" + a); 

        // ----------------- write your code ABOVE this line only ---------

	}
}
