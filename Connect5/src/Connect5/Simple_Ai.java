package Connect5;

public class Simple_Ai extends Board {

	private int column;
	private int row;
	private int turn;

	public Simple_Ai() {

	}

	public int getY() {
		return column;
	}

	public int getX() {
		return row;
	}

	public void setX(int num) {
		row = num;
	}

	public void setY(int num) {
		column = num;
	}

	public void addX() {
		row += 1;
	}

	public void addY() {
		column += 1;
	}

	public boolean first() {
		if (turn == 0) {
		return true; }
		return false;
	}

	public void add() {
		turn += 1;
	}

	public boolean checkX() {
		if (getBoard()[row][column +1] == 0) {
			return true;
		}
		return false;
	}

	public boolean checkY() {
		if (getBoard()[row + 1][column] == 0) {
			return true;
		}
		return false;
	}

}