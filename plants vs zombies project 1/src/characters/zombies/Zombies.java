package characters.zombies;

import characters.Character_TYPE;
import characters.MyCharacters;
import graphics.makeCharacters.makeCharacters;

public abstract class Zombies extends MyCharacters {



    private makeCharacters make_Characters;
    private int pic_num;

    public Zombies(String name, int health, int fist_power, int speed, long fist_timer, Character_TYPE character_type) {
        super(name, health, fist_power, speed, fist_timer, character_type);
    }

    public makeCharacters getMake_Characters() {
        return make_Characters;
    }

    public void setMake_Characters(makeCharacters make_Characters) {
        this.make_Characters = make_Characters;
        setChar_group(this.make_Characters.makeGroup());
    }

    public int getPic_num() {
        return pic_num;
    }

    public void setPic_num(int pic_num) {
        this.pic_num = pic_num;
    }
}
