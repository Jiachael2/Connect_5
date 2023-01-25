package Connect5;

import java.util.Random;

public class Simple_Ai extends Board {

	private int column;
	private int row;

	/**
	 * Constructor
	 */
	public Simple_Ai() {

	}

	/**
	 * sets a random position for the ai piece, limited to the middle area
	 */
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

	/**
	 * sets a new random postition for the ai piece when cornered, no limits within
	 * the board
	 */
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

	/**
	 * returns y position of ai
	 * 
	 * @return
	 */
	public int getY() {
		return column;
	}

	/**
	 * returns x position of ai
	 * 
	 * @return
	 */
	public int getX() {
		return row;
	}

	/**
	 * adds one to the ai posX to place
	 */
	public void addX() {
		row += 1;
	}

	/**
	 * adds one to the ai posY to place
	 */
	public void addY() {
		column += 1;
	}

}