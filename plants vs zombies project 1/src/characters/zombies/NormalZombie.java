package characters.zombies;

import characters.Character_TYPE;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class NormalZombie extends Zombies{

    public NormalZombie() {
        super("normal zombie", 100, 10, 3000, 2000, Character_TYPE.ZOMBIE);
        setImageView(new ImageView(new Image(new File("/images/zombie.png").toURI().toString())));
    }

}
