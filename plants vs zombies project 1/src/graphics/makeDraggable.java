package graphics;

import functions.projectStart;
import graphics.playGroundButtons.playGround2;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class makeDraggable
{
    private static double anchorX;
    private static double anchorY;



    public static void draggable(Node node1 ,Node node2)
    {
        node1.setOnMouseDragged(mouseEvent ->{
            node2.setLayoutX(mouseEvent.getSceneX());
            node2.setLayoutY(mouseEvent.getSceneY());

            anchorX=mouseEvent.getSceneX();
            anchorY=mouseEvent.getSceneY();

        });
        node2.setLayoutY(anchorY);
        node2.setLayoutX(anchorX);
    }

    public static void clickable(Node node , Label money)
    {
        node.setOnMousePressed(mouseEvent ->{
            projectStart.root.getChildren().remove(node);

            String newMoney=Integer.toString(Integer.parseInt(money.getText())+50);
            Platform.runLater(() ->money.setText(newMoney));
        });
    }
}
