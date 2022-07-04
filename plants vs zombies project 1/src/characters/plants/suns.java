package characters.plants;

import graphics.playGroundButtons.playGround2;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import javax.swing.text.html.ImageView;

public class suns {
    private Rectangle theSun;

    public suns(Rectangle r) {
        this.theSun = r;
        theSun.setFill(loadImage("../../resources/images/solarSun.png"));

    }

    public ImagePattern loadImage(String path) {
        return new ImagePattern(
                new Image(suns.class.getResourceAsStream(path))
        );
    }


    public Rectangle getTheSun() {
        return theSun;
    }

    public void setTheSun(Rectangle theSun) {
        this.theSun = theSun;
    }
}
