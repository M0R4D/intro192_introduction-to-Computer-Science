/*---------------------------------------
 Genuine authors: 	<Khaled Zbidat>,	I.D.:	<id number>
					<Morad Abu Alkeaan>,	I.D.:	<id number>
 Date: xx-05-2019
---------------------------------------*/

public class KQueens {
	public static void main(String[] args) {
		boolean[][] board = {{true,false},{true,false}};
		boolean isLegal = isLegalSolution(board, 2);
		System.out.println(isLegal); // prints "true"
		boolean[][] board2 = {{true,true},{true,false}};
		boolean isLegal2 = isLegalSolution(board2, 3);
		System.out.println(isLegal2); // prints "false"
		boolean[][] board3 = {{true,true},{false,false}};
		boolean isLegal3 = isLegalSolution(board3, 3);
		System.out.println(isLegal3); // prints "false"
	}

	/**
	 * Prints a given boolean board. true = "Q" and false = "*"
	 * 
	 * @param board
	 *            A boolean board. true value represents a queen placed on the
	 *            board.
	 */
	public static void printBoard(boolean[][] board) {
		// write your code here
		if(board.length == 0) {
			System.out.print("There is no solution");
		}
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j]) {
					System.out.print("Q ");
				}
				else 
					System.out.print("* ");
			}
			System.out.println();
		}
	}

	/**
	 * Checks if a queen placed on board in cell board[row][col] is threatened by
	 * more than one queen
	 * 
	 * @param board
	 *            a square boolean board
	 * @param row
	 *            the row index of the queen
	 * @param col
	 *            the column index of the queen
	 * @return true if a queen placed on board in cell board[row][col] is threatened
	 *         by more than one queen
	 */
	public static boolean isQueenThreatened(boolean[][] board, int row, int col) {
		// first try
		/* int threats = 0;
		for(int i = 0; i < board.length; i++) {
			if(board[row][i] && i != col) {
				threats++;
			}
		}
		for(int j = 0; j < board.length; j++) {
			if(board[j][col] && j != row) {
				threats++;
			}
		}
		// for(int k = 0; k < board.length; k++) {
		// 	if(board[row][i] && i != row) {
		// 		threats++;
		// 	}
		// }
		// still we should check the Diameter
		return threats >= 2;
		*/
		// How I did it?
		// at first I found the beginning of two diameter for the queen in [row][col]
		// The first diameter is on the left of board The second diameter is on the
		// right of board
		// finally I check all squares located vertically and horizontally and
		// diagonally from board[row][col]
		
		
		// successful try
		int count = 0;
		int m = -1;// To find the number of queens that threaten the queen in board[row][col]
		boolean stop1 = false;
		boolean stop2 = false;
		boolean stop3 = false;
		boolean stop4 = false;
		// this Help variables
		// I use it because if we found tow queen or more that Targeting the queen
		// in[row][col] we need to count One of them
		// and to pass to the other side to check it
		int Istartdiameter1 = row, Jstartdiameter1 = col, Istartdiameter2 = row, Jstartdiameter2 = col;// this variable																								// // For the
		// beginning of the first diameter to the end..and to check them
		while (Istartdiameter1 > 0 & Jstartdiameter1 > 0)
		// to find the beginning of the first diameter Located in one of the boxes in
		// the left section
		{
			Istartdiameter1 = Istartdiameter1 - 1;
			Jstartdiameter1 = Jstartdiameter1 - 1;
		}
		while (Istartdiameter2 > 0 & Jstartdiameter2 < board.length - 1) {
			// to find the beginning of the second diameter Located in one of the boxes in
			// the right section
			Istartdiameter2 = Istartdiameter2 - 1;
			Jstartdiameter2 = Jstartdiameter2 + 1;
		}
		for (int i = 0; i < board.length & count < 2; i = i + 1)// to Check the board
		{
			m = m + 1;
			for (int j = 0; j < board.length & count < 2; j = j + 1) {
				if (board[i][j] & !(i == row & j == col)) {// check all the square that==true

					if (i == row & j != col & !stop1)// Check horizontally if there is another queen (MAX 2 Each one has
														// a different side)
					{
						count = count + 1;
						stop1 = true;
						if (j < col) {
							// if board[i][j]==true and we found queen on the left side of queen[row][col]
							// we didnt need to continue to check the left side So we pass to right side the
							// queen
							// to check it
							j = col;// here we pass to other side when we find queen that targeting [row][col]
							stop1 = false;
						}

					}

					if (m != row & j == col & !stop2 & m < board.length)
					// Check vertically if there is another queen
					{
						count = count + 1;
						stop2 = true;
						if (m < row) {
							// if board[i][j]==true and we found queen From above of queen[row][col]
							// we didnt need to continue to check the above side So we pass to down the
							// queen
							// to check it
							m = row;// here we start to check the other other side when we find queen that targeting
									// [row][col]
							stop2 = false;
						}
					}
				}
			}
			if (Istartdiameter1 < board.length & Jstartdiameter1 < board.length) {
				if (!stop3 && board[Istartdiameter1][Jstartdiameter1] & Istartdiameter1 != row & Jstartdiameter1 != col)
				// Check the boxes on the same diameter with the queer[row][col]
				{
					count = count + 1;
					stop3 = true;
					if (Istartdiameter1 < row & Jstartdiameter1 < col) {// To move to the other side of the diameter
						Istartdiameter1 = row;
						Jstartdiameter1 = col;
						stop3 = false;
					}
				}
				Istartdiameter1 = Istartdiameter1 + 1;// to pass to another boxes on the same diameter
				Jstartdiameter1 = Jstartdiameter1 + 1;// to pass to another boxes on the same diameter
			}
			if ((Istartdiameter2 < board.length & Jstartdiameter2 >= 0)) {
				if (!stop4 && board[Istartdiameter2][Jstartdiameter2] & Istartdiameter2 != row & Jstartdiameter2 != col)//
				// Check the boxes on the same diameter with the queer[row][col]
				{
					count = count + 1;
					stop4 = true;
					if (Istartdiameter2 < row & Jstartdiameter2 < col) {// To move to the other side of the diameter
						Istartdiameter1 = row + 1;
						Jstartdiameter1 = col - 1;
						stop4 = false;
					}
				}
				Istartdiameter2++ ; // to pass to another boxes on the same diameter
				Jstartdiameter2--; // to pass to another boxes on the same diameter
			}
		}
		return count > 1;
	}

	/**
	 * Checks that there are k queens on the board, and that no queen is threatened
	 * by more than one queen
	 * 
	 * @param board
	 *            a boolean board with a solution to the KQueens problem
	 * @param k
	 *            the number of queens that should be on the board
	 * @return true iff the solution is legal
	 */
	public static boolean isLegalSolution(boolean[][] board, int k) {
		// write your code here
		int counter = 0;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j]) {
					counter++;
					if(isQueenThreatened(board, i, j)) {
						return false;
					}
				}
			}
		}
		return counter == k;
	}

	/**
	 * Adds a queen to board[row][col] only if the board obtained after adding the
	 * queen is legal
	 * 
	 * @param board
	 *            a boolean board representing a legal solution for numOfQueens
	 *            queens
	 * @param row
	 *            The row index in which an attempt is made to add a new queen.
	 * @param col
	 *            The column index in which an attempt is made to add a new queen.
	 * @param numOfQueens
	 *            number of queens placed on board
	 * @return true iff queen was added to the board
	 */
	public static boolean addQueen(boolean[][] board, int row, int col, int numOfQueens) {
		// write your code here
		boolean answer = true;
		board[row][col] = true; //the place that we want to add queen
		answer = isLegalSolution(board, numOfQueens + 1); //check if we can add queen and we get legal solution
		// if (!answer) {//if we can not add queen we need to delete the true that we add [row][col]
		// 	board[row][col] = false;
		// }
		board[row][col] = answer;
		return answer;
	}

	/**
	 * Solves the k queens problem, for a board of size nxn Placed k queens on board
	 * such that each queen is threatened by no more than one queen Calls recursive
	 * function with the same name
	 * 
	 * @param n
	 *            the size of the board
	 * @param k
	 *            number of queens to be placed on board
	 * @return a boolean array of size nxn that represents a legal solution to the
	 *         problem, an empty array otherwise
	 */
	public static boolean[][] kQueens(int n, int k) {
		boolean[][] board = new boolean[n][n]; // new board nxn.
		boolean[][] emptyBoard = new boolean[0][0]; // new empty board.
		boolean check = false;
		int row = 0;
		int col = 0;
		int numberOfQueens = 0;
		check = kQueens(board, k, row, col, numberOfQueens); // using the recursive function to check that iff we can put															// in the board k queens and be a legal board.
		if (check) return board;
		else return emptyBoard; // if don't found solution we return a empty board.
	}

	/**
	 * A recursive function that tries all possible combinations for placing queens
	 * Goes over board row by row from left to right
	 * 
	 * @param board
	 *            a partial solution for numOfQueens
	 * @param row
	 *            current row
	 * @param col
	 *            current column
	 * @param k
	 *            total number of queens to place
	 * @param numOfQueens
	 *            how many queens were placed so far on board
	 * @return true iff a legal solution was found. board will represent a solution
	 *         only if true is returned
	 */
	private static boolean kQueens(boolean[][] board, int k, int row, int col, int numOfQueens) {
		// write your code here
		boolean check = true;
		boolean checkrow = false;
		if (k == numOfQueens)
			return check;
		if (col >= board.length) { // if we get in the end of the row we start in new row.
			col = 0;
			row = row + 1;
		}
		if (row > board.length - 1)
			return checkrow;
		else if (addQueen(board, row, col, numOfQueens)) {// if we add a queen to the board.
			if (kQueens(board, k, row, col + 1, numOfQueens + 1)) // we add the queen and go to the next column in the
																	// same row.
				return check;
			else {// if we can't add the queen to the board we remove the queen.
				board[row][col] = false;
				return kQueens(board, k, row, col + 1, numOfQueens); // go to the next column in the same row.
			}
		} 
		else return kQueens(board, k, row, col + 1, numOfQueens);
	}

}
