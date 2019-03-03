package newJavaTicTac;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.stream.Collectors;

public class TicTacToeRunner extends Application {

    GameController controller = new GameController();
    public Cell[][] cell = new Cell[3][3];
    private Label statusMsg = new Label("X must play");
    GridPane pane;

    public void runNewGame() {
        pane.getChildren().removeAll(pane.getChildren().stream()
                .filter(child -> !child.getTypeSelector().equals("Button"))
                .collect(Collectors.toList()));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cell[i][j] = new Cell(i, j, this);
                pane.add(cell[i][j], i, j);
            }
        }
        controller.startGame();
        statusMsg.setText("X must play");
    }


    @Override
    public void start (Stage primaryStage) throws Exception  {
        controller.startGame();
         pane = new GridPane();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cell[i][j] = new Cell(i, j, this);
                pane.add(cell[i][j], i, j);
            }
        }

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(statusMsg);

        Button button = new Button("New Game");
        button.setOnAction((e) -> runNewGame());

        pane.add(button, 1, 4);


        Scene scene = new Scene(borderPane, 450, 300);
        primaryStage.setTitle("TicTac");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public class Cell extends Pane {
        private int x;
        private int y;
        private TicTacToeRunner runner;

        public Cell(int x, int y, TicTacToeRunner runner) {
            setStyle("-fx-border-color: black");
            this.setPrefSize(300, 300);
            this.setOnMouseClicked(e -> handleClick());
            this.x = x;
            this.y = y;
            this.runner = runner;
        }

        private void handleClick() {
            if (runner.controller.getField(x, y) == Field.FLD_EMPTY && !controller.isGameEnded()) {
                drawX();
                if (runner.controller.isWinner(x, y, Field.FLD_CROSS)) {
                    statusMsg.setText("Player with X won!");
                    return;
                } else if (runner.controller.isAllFieldsFilled()) {
                    statusMsg.setText("Draw!");
                }
                addYToView();
            }
        }

        public void addYToView() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (runner.controller.getField(i, j) == Field.FLD_EMPTY) {
                        runner.cell[i][j].drawY();
                        runner.controller.fillField(i, j, Field.FLD_CIRCLE);
                        if (runner.controller.isWinner(i,j, Field.FLD_CIRCLE)){
                            statusMsg.setText("Player with O won!");
                            return;
                        }
                        return;
                    }
                }
            }
        }


        public void drawX() {
            Line line1 = new Line(10,10, this.getWidth() - 10, this.getHeight() - 10);
            line1.endXProperty().bind(this.widthProperty().subtract(10));
            line1.endYProperty().bind(this.heightProperty().subtract(10));

            Line line2 = new Line(10, this.getHeight() - 10, this.getWidth() - 10, 10);
            line2.endXProperty().bind(this.widthProperty().subtract(10));
            line2.startYProperty().bind(this.heightProperty().subtract(10));

            getChildren().addAll(line1, line2);
            runner.controller.fillField(x, y, Field.FLD_CROSS);
        }

        public void drawY () {
            Ellipse ellipse = new Ellipse(this.getWidth()/2, this.getHeight() / 2, this.getWidth() / 2 - 10, this.getHeight() / 2 - 10);
            ellipse.centerXProperty().bind(this.widthProperty().divide(2));
            ellipse.centerYProperty().bind(this.heightProperty().divide(2).subtract(2));
            ellipse.radiusXProperty().bind(this.widthProperty().divide(2).subtract(10));
            ellipse.radiusYProperty().bind(this.heightProperty().divide(2).subtract(10));


            getChildren().add(ellipse);

        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
