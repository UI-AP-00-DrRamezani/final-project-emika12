package characters.zombies;

import characters.Character_TYPE;
import graphics.makeCharacters.makeCharacters;

public class TrafficHatZombie extends Zombies{
    public TrafficHatZombie() {
        super("traffic zombie", 90, 15,7, 2000, Character_TYPE.ZOMBIE);

        setMake_Characters(new makeCharacters("images/3_KNIGHT/Knight_03__WALK_%s.png",9));

    }

}
