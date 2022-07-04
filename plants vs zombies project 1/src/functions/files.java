package functions;

import characters.MyCharacters;
import characters.plants.Flower;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static functions.projectStart.*;

public class files
{
    private final static String AllCharacters ="D:\\load Game\\characters\\all.txt ";
    private final static String flowers="D:\\load Game\\characters\\flowers.txt";
    private final static String extraInfo="D:\\loadGame\\extra info.txt";

    public static void read() throws IOException, ClassNotFoundException {
        FileInputStream read=new FileInputStream(AllCharacters);
        ObjectInputStream reading=new ObjectInputStream(read);

        AllMyCharacters.removeAll(AllMyCharacters);

        while (read.available() !=0)
            AllMyCharacters.add((MyCharacters) reading.readObject());

        read.close();
        reading.close();

        read=new FileInputStream(flowers);
        reading=new ObjectInputStream(read);

        while (read.available() !=0)
            AllMyCharacters.add((MyCharacters) reading.readObject());


        read.close();
        reading.close();

        read=new FileInputStream(extraInfo);
        Scanner reading2=new Scanner(read);


        gameTime=Integer.parseInt(reading2.next());
        setZombieScore(Integer.parseInt(reading2.next()));
        setPlantScore(Integer.parseInt(reading2.next()));


        reading2.close();
        read.close();
    }

    public static void write(ArrayList <Character> characters) throws IOException
    {
        FileOutputStream fout=new FileOutputStream(AllCharacters);
        ObjectOutputStream out=new ObjectOutputStream(fout);

        FileOutputStream flowerOut=new FileOutputStream(flowers);
        ObjectOutputStream flowerO=new ObjectOutputStream(flowerOut);


        for (MyCharacters character: AllMyCharacters)
        {
            if (character instanceof Flower)
                  flowerO.writeObject(character);
            else
                out.writeObject(character);

        }

        out.close();
        fout.close();
        flowerO.close();
        flowerOut.close();

        fout=new FileOutputStream(extraInfo);
        PrintWriter printWriter=new PrintWriter(fout);

        printWriter.format("%s\n%s\n%s",gameTime,getZombieScore(),getPlantScore());

        fout.close();
        out.close();

    }
}
