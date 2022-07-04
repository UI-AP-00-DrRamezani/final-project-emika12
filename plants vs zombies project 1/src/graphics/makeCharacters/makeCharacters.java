package graphics.makeCharacters;

import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;


public class makeCharacters  {

   //"images/1_KNIGHT/Knight_01__WALK_%s.png"
    private String path;
    private Group group = new Group();
    private int number ;
    private Timeline t=new Timeline();


   public makeCharacters(String path, int number) {
        this.path = path;
        this.number = number;
    }



    public Group makeGroup()
    {
        ArrayList<ImageView> imageViews = new ArrayList<>();

        for (int i = 0; i <= number; i++) {
            String str = String.format(path, "00" + i);
            Image image = new Image(new File(str).toURI().toString());
            imageViews.add(new ImageView(image));
        }

        //MAKING THE SIZE :

        for (ImageView view :imageViews)
        {
            view.setFitWidth(450);
            view.setFitHeight(250);
        }


        t.setCycleCount(Timeline.INDEFINITE);
        for (int i = 0; i < imageViews.size(); i++) {
            ImageView iv = imageViews.get(i);
            t.getKeyFrames().add(new KeyFrame(
                    Duration.millis(200 + i * 100),
                    (ActionEvent event) -> {
                        group.getChildren().setAll(iv);
                    }
            ));
        }

        t.play();
        return group;
    }


    public void position(long x , long y)
    {
        group.setTranslateX(x);
        group.setTranslateY(y);
        group.setLayoutX(x);
        group.setLayoutY(y);
    }

    public void Moving(long destinyLength , long time)
    {
        TranslateTransition transition=new TranslateTransition();
        transition.setNode(group);
        transition.setByX(destinyLength);
        transition.setDuration(Duration.millis(time));
        transition.setCycleCount(1);
        transition.play();
    }

    public void rotatingThePictures(long millis)
    {
        RotateTransition rotate=new RotateTransition();
        rotate.setNode(group);
        rotate.setDuration(Duration.millis(millis));

        rotate.setAxis(Rotate.Y_AXIS);
        rotate.setCycleCount(1);
        rotate.setByAngle(180);

        rotate.play();

    }


}




