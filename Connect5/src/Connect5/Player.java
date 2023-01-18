package Connect5;

public class Player {

	private int count;

	public Player() {

	}

	public boolean PlayerTurn() {
		if (count == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void sub() {
		count -= 1;
	}

	public void add() {
		count += 1;
	}

}
