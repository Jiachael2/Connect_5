package Connect5;

public class Player {

	private int count;

	/**
	 * Constructor
	 */
	public Player() {

	}

	/**
	 * determines if it is player one's turn, checks if it is 1 or zero
	 * 
	 * @return true or false
	 */
	public boolean PlayerTurn() {
		if (count == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * adds to player turn
	 */
	public void sub() {
		count -= 1;
	}

	/**
	 * subtracts from player turn
	 */
	public void add() {
		count += 1;
	}

}
