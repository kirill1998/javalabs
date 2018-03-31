package flower;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;

public  class Main extends Application {

    private Human human;
    private Flower flower;
    private Bud bud;
    private Button plain;
    private Button pour;
    private Button smell;
    private Label human_label;
    private Label flower_label;
    private Label bud_label;
  //  private Label doctor_label;

    @Override
    public void start(Stage primaryStage) {
        human = new Human("Alex");
        plain = new Button("plain");
        pour = new Button("pour");
        smell = new Button("smell");
        human_label = new Label("human");
        flower_label = new Label("flower");
        bud_label = new Label("bud");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(50, 50, 50, 50));

        pour.setDisable(true);
        smell.setDisable(true);

        plain.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               flower = human.plain(10);

                if(pour.isDisable()) {
                    JOptionPane.showMessageDialog(null, "You plained flower.Height of flower is" + flower.getHeight());
                }   
                pour.setDisable(false);
            }
        });

        pour.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                bud= human.pour(flower, "aroma");
                JOptionPane.showMessageDialog(null, "The bud grew");
                smell.setDisable(false);
                pour.setDisable(true);
                plain.setDisable(true);
            }
        });

        smell.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                human.smell(bud);
                JOptionPane.showMessageDialog(null,  " The smell is: "+ human.smell(bud) );

            }
        });

        primaryStage.setTitle("15 variant");

        grid.add(human_label, 0, 0);
        grid.add(plain, 0, 1);
        grid.add(flower_label, 1, 0);
        grid.add(pour, 1, 1);
        grid.add(bud_label, 2, 0);
        grid.add(smell, 2, 1);
        Pane stackPane = new Pane();
        stackPane.getChildren().add(grid);
        primaryStage.setScene(new Scene(stackPane));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

