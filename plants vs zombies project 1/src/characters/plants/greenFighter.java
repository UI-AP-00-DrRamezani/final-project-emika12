package characters.plants;

import javafx.scene.image.ImageView;

import java.io.File;

public class greenFighter extends Plants {

    public greenFighter() {
        super("walker", 100, 10, 4, 2000, 100, 2000);
        setImageView(new ImageView(new File("/graphics/playGroundButtons/fighter.png").toURI().toString()));
    }
}
