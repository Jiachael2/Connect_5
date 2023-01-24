package Connect5;

import java.util.Random;

public class Simple_Ai extends Board {

	private int column;
	private int row;

	public Simple_Ai() {

	}

	public void setPos() {
		Random rand = new Random();
		int n = rand.nextInt(5, 8);
		if (getBoard()[n][n] == 0) {
			column = n;
			row = n;
		} else {
			int i = rand.nextInt(5, 8);
			column = i;
			row = i;
		}
	}
	public void setPos2() {
		Random rand = new Random();
		int n = rand.nextInt(13);
		int m = rand.nextInt(13);
		if (getBoard()[n][m] == 0) {
			column = m;
			row = n;
		} else {
			int i = rand.nextInt(13);
			int j = rand.nextInt(13);
			column = i;
			row = j;
		}
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


	public boolean checkY() {
		int num = row + 1;
		if (getBoard()[num][column] == 1) {
			return false;
		}
		return true;
	}

}