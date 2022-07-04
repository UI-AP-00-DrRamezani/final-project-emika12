package characters.zombies;

import characters.Character_TYPE;
import graphics.makeCharacters.makeCharacters;

public class BucketHatZombie extends Zombies{

    public BucketHatZombie() {
        super("bucket hat zombie", 100, 15, 7, 2000,Character_TYPE.ZOMBIE);
        setMake_Characters(new makeCharacters("images/1_KNIGHT/Knight_01__WALK_%s.png",9));
    }
}
