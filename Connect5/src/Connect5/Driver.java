package Connect5;

import javafx.application.Application;
import javafx.concurrent.Task;

import java.util.Random;
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
		Simple_Ai ai = new Simple_Ai();
		board.createBoard();

		Image image = new Image("file:board.png");
		ImageView mv = new ImageView(image);
		Image black = new Image("file:bPiece.png");
		Image white = new Image("file:wPiece.png");
		Font font = new Font("Comic Sans MS", 100);
		Label label = new Label(" ");
		label.setFont(font);
		label.setMaxWidth(Double.MAX_VALUE);
		label.setAlignment(Pos.CENTER);
		label.setLayoutX(100);
		label.setLayoutY(200);
		Group root = new Group();
		ai.setPos();

//		for (int i = 0; i < 13; i++) {
//			for (int j = 0; j < 13; j++) {
//				slots[i][j] = new NewButton(i, j);
//				slots[i][j].setShape(new Circle(10));
//				slots[i][j].setMinSize(40, 40);
//				slots[i][j].setMaxSize(40, 40);
//
//				ImageView black2 = new ImageView(black);
//				black2.setPreserveRatio(true);
//				black2.fitWidthProperty().bind(slots[i][j].widthProperty());
//				black2.fitHeightProperty().bind(slots[i][j].heightProperty());
//				ImageView white2 = new ImageView(white);
//				white2.setPreserveRatio(true);
//				white2.fitWidthProperty().bind(slots[i][j].widthProperty());
//				white2.fitHeightProperty().bind(slots[i][j].heightProperty());
//
//				slots[i][j].setStyle();
//				grid.add(slots[i][j], i, j);
//				board.printBoard();
//				slots[i][j].setOnAction(e -> {
//					((NewButton) e.getSource()).setGraphic(black2);
//					((NewButton) e.getSource()).setDisable(true);
//					((NewButton) e.getSource()).setOpacity(1);
//					board.isBlack(((NewButton) e.getSource()).getRow(), ((NewButton) e.getSource()).getCol());
//					board.printBoard();
//					if (board.getBoard()[ai.getY()][ai.getX() + 1] == 0) {
//						ai.addX();
//						slots[ai.getX()][ai.getY()].setGraphic(white2);
//						slots[ai.getX()][ai.getY()].setDisable(true);
//						slots[ai.getX()][ai.getY()].setOpacity(1);
//						board.isWhite(ai.getX(), ai.getY());
//						board.printBoard();
//					} else if (board.getBoard()[ai.getY() + 1][ai.getX()] == 0) {
//						ai.addY();
//						slots[ai.getX()][ai.getY()].setGraphic(white2);
//						slots[ai.getX()][ai.getY()].setDisable(true);
//						slots[ai.getX()][ai.getY()].setOpacity(1);
//						board.isWhite(ai.getX(), ai.getY());
//						board.printBoard();
//					} else if (board.getBoard()[ai.getY() + 1][ai.getX() + 1] == 0) {
//						ai.addY();
//						ai.addX();
//						slots[ai.getX()][ai.getY()].setGraphic(white2);
//						slots[ai.getX()][ai.getY()].setDisable(true);
//						slots[ai.getX()][ai.getY()].setOpacity(1);
//						board.isWhite(ai.getX(), ai.getY());
//						board.printBoard();
//					} else {
//						ai.setPos2();
//					}
//
//					if (board.winner() == 1) {
//						label.setText("Black Wins");
//						grid.setDisable(true);
//					}
//					if (board.winner() == 2) {
//						label.setLayoutX(70);
//						label.setText("White Wins");
//						grid.setDisable(true);
//					}
//				});
//			}
//		}

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
						grid.setDisable(true);
					}
					if (board.winner() == 2) {
						label.setLayoutX(70);
						label.setText("White Wins");
						grid.setDisable(true);
					}
				});
			}
		}

		root.getChildren().addAll(mv, grid, label);

		Scene scene = new Scene(root, 700, 700);
		stage.setScene(scene);
		stage.show();
		stage.setTitle("Connect 5");
	}
	
	private static void delay() {
		try {
			Thread.sleep(500);
		} catch (java.lang.InterruptedException iex){
			System.out.println(iex);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
