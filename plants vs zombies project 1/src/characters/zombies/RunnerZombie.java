package characters.zombies;

import characters.Character_TYPE;
import graphics.makeCharacters.makeCharacters;

public class RunnerZombie extends Zombies{

    public RunnerZombie() {
        super("runner zombie", 80, 15, 6, 2000, Character_TYPE.ZOMBIE);

        setMake_Characters(new makeCharacters("images/2_KNIGHT/Knight_02__WALK_%s.png",9));
    }
}
