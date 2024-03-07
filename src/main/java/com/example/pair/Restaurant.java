package com.example.pair;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class Restaurant extends Application { //K & G's

    MainCore tab1 = new MainCore();
    BeveCore tab2 = new BeveCore();
    SideCore tab3 = new SideCore();
    TotalCore tab4 = new TotalCore(tab1, tab2, tab3);
    TabPane Tabs = new TabPane();

    Background tab1Bg = new Background(new BackgroundFill(new Color(.4, .9, 1, 1), null, null));
    Background tab2Bg = new Background(new BackgroundFill(new Color(1, .5, .5, 1), null, null));
    Background tab3Bg = new Background(new BackgroundFill(new Color(1, 1, .5, 1), null, null));
    Background tab4Bg = new Background(new BackgroundFill(new Color(0, 1, .2, 1), null, null));


    public void start(Stage stage) {

        Label header = new Label("K & G's Restaurant");
        header.setFont(new Font("Helvetica", 30));
        header.setTextFill(Color.WHITE);

        Tabs.setBackground(tab1Bg);

//        Adding tabs to Tabs
        Tabs.getTabs().addAll(tab1,tab2,tab3,tab4);
        Tabs.setOnMouseClicked(navClick);
//       Makes the User unable to close tabs
        tab1.setClosable(false);
        tab2.setClosable(false);
        tab3.setClosable(false);

        VBox gp = new VBox(header, Tabs);
        gp.setAlignment(Pos.TOP_CENTER);
        gp.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

        Scene scene = new Scene(gp,800,700);
        stage.setTitle("K & G's Restaurant");
        stage.setScene(scene);
        stage.show();
    }

    EventHandler<MouseEvent> navClick = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            if (tab1.isSelected()) {
                Tabs.setBackground(tab1Bg);
            }
            else if (tab2.isSelected()) {
                Tabs.setBackground(tab2Bg);
            }
            else if (tab3.isSelected()) {
                Tabs.setBackground(tab3Bg);
            }
            else if (tab4.isSelected()) {
                Tabs.setBackground(tab4Bg);
            }
        }
    };


    public static void main(String[] args) {

        launch();
    }
}