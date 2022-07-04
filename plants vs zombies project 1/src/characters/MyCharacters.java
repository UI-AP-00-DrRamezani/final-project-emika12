package characters;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.awt.*;

public abstract class MyCharacters  {

    private boolean alive=true;
    private String name;
    private int health;
    private int fist_power;
    private int speed; //square per seconds
    private Character_location location;
    private long fist_timer; //time between two fists (millie seconds)
    private Character_TYPE character_type;
    private ImageView imageView;
    private Group char_group;

    public MyCharacters(String name, int health, int fist_power, int speed,
                        long fist_timer , Character_TYPE character_type) {
        this.name = name;
        this.health = health;
        this.fist_power = fist_power;
        this.speed = speed;
        this.fist_timer = fist_timer;
        this.character_type=character_type;
    }

    //==============================================getter setter================================================
    public String getName() {
        return name;
    }


    public int getHealth() {
        return health;
    }


    public int getFist_power() {
        return fist_power;
    }


    public int getSpeed() {
        return speed;
    }



    public Character_location getLocation() {
        return location;
    }

    public void setLocation(Character_location location) {
        this.location = location;
    }


    public void setFist_timer(long fist_timer) {
        this.fist_timer = fist_timer;
    }

    public Character_TYPE getCharacter_type() {
        return character_type;
    }


    public void setCharacter_type(Character_TYPE character_type) {
        this.character_type = character_type;
    }


    public void setHealth(int health) {
        this.health = this.health - health;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Group getChar_group() {
        return char_group;
    }

    public void setChar_group(Group char_group) {
        this.char_group = char_group;
    }

    public long getFist_timer() {
        return fist_timer;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}


