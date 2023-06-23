import characters.MyCharacters;
import characters.plants.suns;
import characters.zombies.BucketHatZombie;
import characters.zombies.RunnerZombie;
import characters.zombies.TrafficHatZombie;
import characters.zombies.Zombies;
import functions.projectStart;
import graphics.makeCharacters.makeCharacters;
import graphics.makeTable;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Random;

public class myTestings extends Application {

    int i=0;

    public static Pane root=new Pane();
    public static Pane video;
    @Override
    public void start(Stage primaryStage) throws Exception {
        makeTable m=new makeTable(false);
    }


    public Pane load(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader(projectStart.class.getResource("../" + path));
        loader.load();
        return loader.getRoot();
    }

}
/*
 new Thread(() -> {
            try {
                Thread.sleep(15000);
                Pane back=new Pane();
                back=load("graphics/background/background.fxml");
                primaryStage.close();
                primaryStage.setScene(new Scene(new Group(back , root)));

            }catch (Exception e){}

 */