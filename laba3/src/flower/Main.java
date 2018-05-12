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
    private Rose rose;
    private Bud bud;
    private Petal petal;
    private Leaf leaf;
    private Button plain;
    private Button pour;
    private Button smell;
    private Button wither;
    private Label human_label;
    private Label rose_label;
    private Label bud_label;
    private Label petal_label;
    private Label leaf_label;
    private Button increaseHeight;


    @Override
    public void start(Stage primaryStage) {
        human = new Human("Alex");
        plain = new Button("plain");
        pour = new Button("pour");
        smell = new Button("smell");
        wither = new Button("wither");
        increaseHeight = new Button("increaseHeight");
        human_label = new Label("human");
        rose_label = new Label("rose");
        bud_label = new Label("bud");
        petal_label=new Label("petal");
        leaf_label = new Label("leaf");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(50, 50, 50, 50));

        pour.setDisable(true);
        smell.setDisable(true);
        wither.setDisable(true);
        increaseHeight.setDisable(true);

        plain.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               rose = human.plain(15);

                if(pour.isDisable()) {
                    JOptionPane.showMessageDialog(null, "You plained Rose.Height of rose is" + rose.getHeight());
                }   
                pour.setDisable(false);
            }
        });
        wither.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rose.wither(leaf);
                bud = null;
                petal = null;
                rose = null;


                System.gc();
                smell.setDisable(true);
                wither.setDisable(true);
                pour.setDisable(true);
                plain.setDisable(false);
                increaseHeight.setDisable(true);
            }
        });

        pour.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                petal=human.pour(bud, leaf, rose, "aroma", 10, "red");
                JOptionPane.showMessageDialog(null, " bud, petal and leaf grew, the  color of petal is:"+ petal.getColor());
                smell.setDisable(false);
                wither.setDisable(false);
                pour.setDisable(true);
                plain.setDisable(true);
                increaseHeight.setDisable(false);

            }
        });

        smell.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


                JOptionPane.showMessageDialog(null, "the smell of bud is:"+ human.smell( bud));


            }
        });
        increaseHeight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rose.increaseHeight();
                JOptionPane.showMessageDialog(null, "Height of rose is" + rose.getHeight());


            }
        });

        primaryStage.setTitle("15 variant");

        grid.add(human_label, 0, 0);
        grid.add(plain, 0, 1);
        grid.add(rose_label, 1, 0);
        grid.add(pour, 1, 1);
        grid.add(bud_label, 2, 0);
        grid.add(smell, 2, 1);
        grid.add(wither, 1,3);
        grid.add(petal_label, 3,0);
        grid.add(leaf_label, 4,0);
        grid.add(increaseHeight, 1,2);
        Pane stackPane = new Pane();
        stackPane.getChildren().add(grid);
        primaryStage.setScene(new Scene(stackPane));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

