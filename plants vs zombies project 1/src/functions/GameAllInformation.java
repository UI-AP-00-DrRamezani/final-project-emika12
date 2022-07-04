package functions;

import characters.Player;
import characters.zombies.Zombies;

import java.util.ArrayList;

public class GameAllInformation {

    public static ArrayList <Zombies> allZombies=new ArrayList<>();
    public static ArrayList <Player> allPlants=new ArrayList<>();

    public static int gameTime =120000;
    public static int money =50;
    public static boolean ended=false;

    public static int plantS=0;
    public static int zombiesS=0;

}
