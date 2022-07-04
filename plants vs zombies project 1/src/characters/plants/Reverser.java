package characters.plants;

import javafx.scene.image.ImageView;

import java.io.File;

public class Reverser extends  Plants {

    public Reverser() {
        super("reverser", 40, 0, -6000, 4000, 75, 0);
        setImageView(new ImageView(new File("/graphics/playGroundButtons/mushroom.png").toURI().toString()));

    }

}
