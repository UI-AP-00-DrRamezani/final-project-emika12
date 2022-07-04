package characters;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Player
{
    private ImageView view;
    //private Rectangle rectangle=new Rectangle();
    private MyCharacters thePlayer;
    private Rectangle rectangle;

    public Player(MyCharacters thePlayer ,long width , long height ) {
        this.thePlayer = thePlayer;
        this.rectangle=new Rectangle(90,90,width ,height);
    }
    public Player() {
    }



    //===================================================getter setter

    public ImageView getView() {
        return view;
    }

    public void setView(ImageView view) {
        this.view = view;
    }

    public MyCharacters getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(MyCharacters thePlayer) {
        this.thePlayer = thePlayer;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}
