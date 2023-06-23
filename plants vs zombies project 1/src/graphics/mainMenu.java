package graphics;

import functions.projectStart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;

import static functions.projectStart.back;
import static functions.projectStart.root;

public class mainMenu {

    @FXML
    private Button loadGame;

    @FXML
    private Button newGame;

    @FXML
    void loadEntered(ActionEvent event) {

    }

    @FXML
    void newGameEntered(ActionEvent event) {

        try {

            root = load("graphics/playGroundButtons/playGround2.fxml");
            back = load("graphics/background/background.fxml");

            projectStart.primaryStage.setScene(new Scene(new Group(back, root)));
        } catch (Exception e) {
        }
    }


    public Pane load(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader(projectStart.class.getResource("../" + path));
        loader.load();
        return loader.getRoot();
    }



}
