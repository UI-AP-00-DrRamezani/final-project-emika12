package characters.plants;

import javafx.scene.image.ImageView;

import java.io.File;

public class Flower extends Plants{


    private int sun=50;
    private long sunGivingTimer=10000;

    public Flower() {
        super("flower",70, 0, -6000, 500, 50,0);
        setImageView(new ImageView(new File("/graphics/playGroundButtons/flower.png").toURI().toString()));
    }



    public int getSun() {
        return sun;
    }

    public long getSunGivingTimer() {
        return sunGivingTimer;
    }


}
