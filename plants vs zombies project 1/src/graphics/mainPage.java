package graphics;

import functions.projectStart;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static functions.projectStart.back;
import static functions.projectStart.root;


public class mainPage implements Initializable   {

    @FXML
    private MediaView mediaView=new MediaView();


    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;
    private boolean endOfVideo=false;


    @FXML
    void onKeyPressed(KeyEvent event) {
        System.out.println("check");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        file =new File("../images/IMG_8600.mp4");
        media = new Media(getClass().getResource("../images/IMG_8600.mp4").toString());

        mediaPlayer=new MediaPlayer(media);


        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();


        mediaPlayer.setOnEndOfMedia(() -> {
            //mediaView.setVisible(false);

            try {

                root = load("graphics/mainMenu.fxml");
                back = load("graphics/background/background.fxml");

                projectStart.primaryStage.setScene(new Scene(new Group(back, root)));
            }catch (Exception e){}
        });

    }
    public Pane load(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader(projectStart.class.getResource("../" + path));
        loader.load();
        return loader.getRoot();
    }

   /* @Override
    public void start(Stage primaryStage) throws Exception {

        file =new File("images/IMG_8600.MOV");
        media = new Media(file.toURI().toString());


        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
        URL url=new File("graphics/mainPage.fxml").toURI().toURL();

        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("Parola PM");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();




        mediaPlayer.setOnEndOfMedia(() -> {
            mediaView.setVisible(false);
        });
    }

    */
}
