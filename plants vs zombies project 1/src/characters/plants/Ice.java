package characters.plants;

import javafx.scene.image.ImageView;

import java.io.File;

public class Ice extends Plants{

    public Ice() {
        super("pro walker", 150, 15, 3, 4000, 150, 1500);
        setImageView(new ImageView(new File("/graphics/playGroundButtons/ice.png").toURI().toString()));
    }
}
