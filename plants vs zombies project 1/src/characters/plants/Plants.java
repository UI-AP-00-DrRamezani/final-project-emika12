package characters.plants;

import characters.Character_TYPE;
import characters.MyCharacters;

public abstract class Plants extends MyCharacters {

    private int price;
    private long timer;//when a new instance is available for buying (millie seconds)

    public Plants(String name, int health, int fist_power, int speed, long timer, int price, long fist_timer) {
        super(name, health, fist_power, speed, fist_timer , Character_TYPE.PLANT);
        this.price=price;
        this.timer=timer;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getTimer() {
        return timer;
    }

    public void setTimer(long timer) {
        this.timer = timer;
    }
}
