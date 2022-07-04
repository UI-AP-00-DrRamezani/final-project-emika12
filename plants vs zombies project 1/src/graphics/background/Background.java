package graphics.background;

import characters.Player;
import com.sun.glass.ui.Application;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;

public class Background extends Pane {

    @FXML
    private ImageView myBackgound=new ImageView(new Image(new File("../resources/images/photo_2022-07-02_13-08-11.jpg").toURI().toString()));




    public static void makeLocations(Player player)
    {
        long sizeOfEachRow=0;
        for (int row = 0 ;row<5 ;++row)
        {
            if ( ((sizeOfEachRow*row) <= (player.getRectangle().getLayoutY() ) ) &&
                    ((sizeOfEachRow*(row+1)) >= (player.getRectangle().getLayoutY() ) ))
            {
                player.getRectangle().setLayoutY(((sizeOfEachRow*(row+1)) + (sizeOfEachRow*row))/2);
            }
        }

        long sizeOfEachColumn=0;

    }
}
