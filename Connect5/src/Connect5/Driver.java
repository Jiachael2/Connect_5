package Connect5;

import javax.swing.JButton;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Driver extends Application {

	public void start(Stage stage) {
		GridPane grid = new GridPane();
		grid.setMinSize(400, 200);
		grid.setPadding(new Insets(13, 13, 13, 13));
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(13);
		grid.setHgap(13);

		NewButton[][] slots = new NewButton[13][13];
		Player player = new Player();
		Board board = new Board();
		board.createBoard();

		Image win = new Image("file:1Win.png");
		ImageView winner = new ImageView(win);
		Image wWin = new Image("file:2Win.png");
		ImageView wWinner = new ImageView(wWin);
		Image image = new Image("file:board.png");
		ImageView mv = new ImageView(image);
		Image black = new Image("file:bPiece.png");
		Image white = new Image("file:wPiece.png");
		Font font = new Font("Comic Sans MS", 100);
		Label label = new Label(" ");
		label.setFont(font);
		label.setMaxWidth(Double.MAX_VALUE);
		label.setAlignment(Pos.CENTER);

		Group b = new Group();
		Group d = new Group();
		Group root = new Group();

		Scene c = new Scene(b, 700, 700);
		Scene f = new Scene(d, 700, 700);
		b.getChildren().addAll(winner);
		d.getChildren().addAll(wWinner);
		
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 13; j++) {
				slots[i][j] = new NewButton(i, j);
				slots[i][j].setShape(new Circle(10));
				slots[i][j].setMinSize(40, 40);
				slots[i][j].setMaxSize(40, 40);

				ImageView black2 = new ImageView(black);
				black2.setPreserveRatio(true);
				black2.fitWidthProperty().bind(slots[i][j].widthProperty());
				black2.fitHeightProperty().bind(slots[i][j].heightProperty());
				ImageView white2 = new ImageView(white);
				white2.setPreserveRatio(true);
				white2.fitWidthProperty().bind(slots[i][j].widthProperty());
				white2.fitHeightProperty().bind(slots[i][j].heightProperty());

				slots[i][j].setStyle();
				grid.add(slots[i][j], i, j);
				board.printBoard();
				
				slots[i][j].setOnAction(e -> {
					if (player.PlayerTurn()) {
						((NewButton) e.getSource()).setGraphic(black2);
						((NewButton) e.getSource()).setDisable(true);
						((NewButton) e.getSource()).setOpacity(1);
						player.add();
						board.isBlack(((NewButton) e.getSource()).getRow(), ((NewButton) e.getSource()).getCol());
						board.printBoard();
					} else {
						((NewButton) e.getSource()).setGraphic(white2);
						((NewButton) e.getSource()).setDisable(true);
						((NewButton) e.getSource()).setOpacity(1);
						player.sub();
						board.isWhite(((NewButton) e.getSource()).getRow(), ((NewButton) e.getSource()).getCol());
						board.printBoard();
					}
					if (board.winner() == 1) {
						label.setText("Black Wins");
					}
					if (board.winner() == 2) {
						label.setText("White Wins");
					}
				});
			}
		}
		
		root.getChildren().addAll(mv, label, grid);

		Scene scene = new Scene(root, 700, 700);
		stage.setScene(scene);
		stage.show();
		stage.setTitle("Connect 5");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
