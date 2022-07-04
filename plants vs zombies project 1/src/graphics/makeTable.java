package graphics;

import characters.Player;
import characters.zombies.Zombies;
import functions.GameAllInformation;
import functions.projectStart;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class makeTable extends Pane{

    boolean won;

    @FXML
    private static Label plantsScore=new Label();

    @FXML
    private Label state=new Label();

    @FXML
    private static Label zombieScore=new Label();


    public makeTable(boolean won) {
        this.won = won;

    }



    public Pane load(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource( path));
        loader.load();
        return loader.getRoot();
    }

    public static void Score()
    {
        int playerS=0;
        int zombieS=0;
        for (Player player:GameAllInformation.allPlants)
        {
            if (!player.getThePlayer().isAlive())
                zombieS++;
        }
        for (Zombies zombies : GameAllInformation.allZombies)
        {
            if (!zombies.isAlive())
                ++playerS;
        }


        int finalPlayerS = playerS;
        Platform.runLater(() -> plantsScore.setText(Integer.toString(finalPlayerS)));

        int finalZombieS = zombieS;
        Platform.runLater(() -> zombieScore.setText(Integer.toString(finalZombieS)));
    }

}
