package characters;

import characters.plants.*;
import javafx.scene.image.ImageView;

public class Buttons
{
    private ImageView imageView;
    private Plants plant;
    private boolean enable=false;


    public Buttons(ImageView imageView, Plants plant) {
        this.imageView = imageView;
        this.plant = plant;
    }


    public Plants copy()
    {
        if (plant instanceof Ice)
            return new Ice();
        else if (plant instanceof Reverser)
            return new Reverser();
        else if (plant instanceof Flower)
            return new Flower();
        else
            return new greenFighter();
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Plants getPlant() {
        return plant;
    }

    public void setPlant(Plants plant) {
        this.plant = plant;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
