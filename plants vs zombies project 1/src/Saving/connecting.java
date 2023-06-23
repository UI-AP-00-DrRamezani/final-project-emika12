package Saving;

import characters.Player;
import characters.plants.Flower;
import characters.zombies.Zombies;
import functions.GameAllInformation;

import java.sql.ResultSet;

public class connecting
{

    public static void INSERT()
    {
        DELETE();
        String cmd;
        for (Player player : GameAllInformation.allPlants)
        {
            cmd=String.format("INSERT INTO players VALUES (%s , %s , %s , %s ,%s)",player.getThePlayer().getClass().getSimpleName()
            ,"player",player.getRectangle().getLayoutX(), player.getRectangle().getLayoutY(),player.getThePlayer().isAlive());
            MySQLTable m=new MySQLTable(cmd , "write");
            m.closing();

        }
        for (Zombies zombies : GameAllInformation.allZombies)
        {
            cmd=String.format("INSERT INTO players VALUES (%s , %s , %s , %s ,%s)",zombies.getClass().getSimpleName(),"zombie"
            ,zombies.getChar_group().getLayoutX(),zombies.getChar_group().getLayoutY());
            MySQLTable m=new MySQLTable(cmd , "write");
            m.closing();
        }

    }


    public static void DELETE()
    {
        String cmd="DELETE FROM players";
        MySQLTable m=new MySQLTable(cmd , "delete");
        m.closing();

        cmd="DELETE FROM extrainfo";
        m=new MySQLTable(cmd , "delete");
        m.closing();

    }


    public static void score()
    {
        int id=0;
        String cmd=String.format("INSERT TO scores VALUES (%s , %s ,%s)",id,GameAllInformation.zombiesS,GameAllInformation.plantS);
        MySQLTable m=new MySQLTable(cmd,"write");

        m.closing();

    }

    public static void SELECT()throws Exception
    {
        String cmd="SELECT* FROM players";
        MySQLTable m=new MySQLTable(cmd , "read");
        ResultSet resultSet=m.getTable();

        while (resultSet.next())
        {
            String type=resultSet.getString("type2");
            String character=resultSet.getString("type");
            if (type.equals("player"))
            {
            }
            else
            {

            }
        }



    }

}