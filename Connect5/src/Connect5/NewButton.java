package Connect5;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class NewButton extends Button {
	private int row;
	private int col;

	/**
	 * Constructor
	 */
	public NewButton(int r, int c) {
		super();
		row = r;
		col = c;
	}

	/**
	 * returns x
	 * 
	 * @return
	 */
	public int getRow() {
		return row;
	}

	/**
	 * returns y
	 * 
	 * @return
	 */
	public int getCol() {
		return col;
	}

	/**
	 * button styling
	 */
	public void setStyle() {
		final String IDLE_BUTTON_STYLE = "-fx-background-color: transparent;";
		final String HOVERED_BUTTON_STYLE = "-fx-background-color: -fx-shadow-highlight-color, -fx-outer-border, -fx-inner-border, -fx-body-color;";

		setStyle(IDLE_BUTTON_STYLE);
		setOnMouseEntered(e -> setStyle(HOVERED_BUTTON_STYLE));
		setOnMouseExited(e -> setStyle(IDLE_BUTTON_STYLE));
	}

	/**
	 * prints out the position of the button in text
	 */
	@Override
	public String toString() {
		return "[" + String.valueOf(getRow()) + "," + String.valueOf(getCol()) + "]";
	}
}
