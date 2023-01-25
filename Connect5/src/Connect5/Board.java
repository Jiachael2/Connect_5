package Connect5;

public class Board {

	private int[][] board = new int[13][13];

	/**
	 * Constructor
	 */
	public Board() {

	}

	/**
	 * creates a board
	 * 
	 * @return a 2d array of zeros
	 */
	public int[][] createBoard() {
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 13; j++) {
				board[i][j] = 0;
			}
		}
		return board;
	}

	/**
	 * prints out the board
	 */
	public void printBoard() {
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 13; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * sets a spot within the board to represent player 1
	 * 
	 * @param x pos
	 * @param y pos
	 */
	public void isBlack(int x, int y) {
		board[y][x] = 1;
	}

	/**
	 * sets a spot within the board to represent player 2
	 * 
	 * @param x pos
	 * @param y pos
	 */
	public void isWhite(int x, int y) {
		board[y][x] = 2;
	}

	/**
	 * returns the board
	 * 
	 * @return
	 */
	public int[][] getBoard() {
		return board;
	}

	/**
	 * determines a winner
	 * 
	 * @return winner number, 1 or 2
	 */
	public int winner() {
		int winner = 0;
		// Horizontal check
		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 13; i++) {
				if (board[i][j] == 1 && this.board[i][j + 1] == 1 && this.board[i][j + 2] == 1
						&& this.board[i][j + 3] == 1 && this.board[i][j + 4] == 1) {
					winner = 1;
				}
				if (board[i][j] == 2 && this.board[i][j + 1] == 2 && this.board[i][j + 2] == 2
						&& this.board[i][j + 3] == 2 && this.board[i][j + 4] == 2) {
					winner = 2;
				}
			}
		}

		// Vertical check bottom up
		for (int j = 0; j < 13; j++) {
			for (int i = 0; i < 9; i++) {
				if (board[i][j] == 1 && board[i + 1][j] == 1 && board[i + 2][j] == 1 && board[i + 3][j] == 1
						&& board[i + 4][j] == 1) {
					winner = 1;
				}
				if (board[i][j] == 2 && board[i + 1][j] == 2 && board[i + 2][j] == 2 && board[i + 3][j] == 2
						&& board[i + 4][j] == 2) {
					winner = 2;
				}
			}
		}

		// descendingDiagonalCheck
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == 1 && board[i + 1][j + 1] == 1 && board[i + 2][j + 2] == 1 && board[i + 3][j + 3] == 1
						&& board[i + 4][j + 4] == 1) {
					return 1;
				}
				if (board[i][j] == 2 && board[i + 1][j + 1] == 2 && board[i + 2][j + 2] == 2 && board[i + 3][j + 3] == 2
						&& board[i + 4][j + 4] == 2) {
					return 2;
				}
				if (board[i][j] == 1 && board[i + 1][j - 1] == 1 && board[i + 2][j - 2] == 1 && board[i + 3][j - 3] == 1
						&& board[i + 4][j - 4] == 1) {
					return 1;
				}
				if (board[i][j] == 2 && board[i + 1][j - 1] == 2 && board[i + 2][j - 2] == 2 && board[i + 3][j - 3] == 2
						&& board[i + 4][j - 4] == 2) {
					return 2;
				}
			}
		}

		return winner;
	}

}
