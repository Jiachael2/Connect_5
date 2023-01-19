package Connect5;

public class Board {
	private int[][] board = new int[13][13];

	public Board() {

	}

	public int[][] createBoard() {
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 13; j++) {
				board[i][j] = 0;
			}
		}
		return board;
	}

	public void printBoard() {
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 13; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void isBlack(int x, int y) {
		board[y][x] = 1;
	}

	public void isWhite(int x, int y) {
		board[y][x] = 2;
	}

	public int[][] getBoard() {
		return board;
	}

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
				if (board[i][j] == 1 && this.board[i + 1][j] == 1 && this.board[i + 2][j] == 1
						&& this.board[i + 3][j] == 1 && this.board[i + 4][j] == 1) {
					winner = 1;
				}
				if (board[i][j] == 2 && this.board[i + 1][j] == 2 && this.board[i + 2][j] == 2
						&& this.board[i + 3][j] == 2 && this.board[i + 4][j] == 2) {
					winner = 2;
				}
			}
		}

		// ascendingDiagonalCheck
		for (int i = 3; i < 13; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == 1 && board[i - 1][j + 1] == 1 && board[i - 2][j + 2] == 1 && board[i - 3][j + 3] == 1
						&& board[i - 4][j + 4] == 1)
					return 1;
			}
		}
		for (int i = 3; i < 13; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == 2 && board[i - 1][j + 1] == 2 && board[i - 2][j + 2] == 2 && board[i - 3][j + 3] == 2
						&& board[i - 4][j + 4] == 2)
					return 2;
			}
		}
		// descendingDiagonalCheck
		for (int i = 3; i < 13; i++) {
			for (int j = 3; j < 13; j++) {
				if (this.board[i][j] == 1 && this.board[i - 1][j - 1] == 1 && this.board[i - 2][j - 2] == 1
						&& this.board[i - 3][j - 3] == 1 && this.board[i - 4][j - 4] == 1)
					return 1;
			}
		}
		for (int i = 3; i < 13; i++) {
			for (int j = 3; j < 13; j++) {
				if (this.board[i][j] == 2 && this.board[i - 1][j - 1] == 2 && this.board[i - 2][j - 2] == 2
						&& this.board[i - 3][j - 3] == 2 && this.board[i - 4][j - 4] == 2)
					return 2;
			}
		}

		return winner;
	}

}
