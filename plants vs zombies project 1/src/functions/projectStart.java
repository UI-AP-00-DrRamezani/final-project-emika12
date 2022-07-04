package functions;

import characters.MyCharacters;
import com.sun.javafx.iio.png.PNGDescriptor;
import graphics.background.Background;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class projectStart extends Application {

    public static ArrayList<MyCharacters> AllMyCharacters=new ArrayList<>();
    public static long gameTime=120000; //two minutes the last zombies would come up
    private static int plantScore=0;
    private static int zombieScore=0;
    private static int Suns=50;
    private static boolean timeEnded=false;
    private static boolean lost=false;

    private static boolean notifying =false;
    private static final Object lock = new Object();



    public static Stage primaryStage=new Stage();
    public static Pane root=new Pane();
    public static Pane video;
    public static Pane back=new Pane();
    @Override
    public void start(Stage stage) throws Exception {

        video =load("graphics/mainPage.fxml");


        primaryStage.setTitle("test");
        primaryStage.setScene(new Scene(new Group(video)));

        primaryStage.setFullScreen(true);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public Pane load(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader(projectStart.class.getResource("../" + path));
        loader.load();
        return loader.getRoot();
    }

    public static void main(String[] args) {
        launch(args);

       // locking();
    }



    public static void print(Object o)
    {
        System.out.println(o);
    }
    //locking up the main

    public static void mySuspend()
    {
        synchronized (lock){
            lock.notifyAll();
        }
    }
    public static void locking()
    {
        synchronized (lock)
        {
            while (! notifying ) {
                try {
                    lock.wait();
                }catch (Exception e){}
            }
            if (notifying)
                lock.notifyAll();

            notifying=false;
        }
    }



    //==============================getter setter


    public static boolean isNotifying() {
        return notifying;
    }

    public static void setNotifying(boolean notifying) {
        projectStart.notifying = notifying;
    }


    public static int getPlantScore() {
        return plantScore;
    }

    public static void setPlantScore(int plantScore) {
        projectStart.plantScore = plantScore;
    }

    public static int getZombieScore() {
        return zombieScore;
    }

    public static void setZombieScore(int zombieScore) {
        projectStart.zombieScore = zombieScore;
    }

    public static int getSuns() {
        return Suns;
    }

    public static void setSuns(int suns) {
        Suns = suns;
    }

    public static boolean isTimeEnded() {
        return timeEnded;
    }

    public static void setTimeEnded(boolean timeEnded) {
        projectStart.timeEnded = timeEnded;
    }

    public static boolean isLost() {
        return lost;
    }

    public static void setLost(boolean lost) {
        projectStart.lost = lost;
    }
}
