package graphics.playGroundButtons;

import characters.Buttons;
import characters.Player;
import characters.plants.*;
import characters.zombies.BucketHatZombie;
import characters.zombies.RunnerZombie;
import characters.zombies.TrafficHatZombie;
import characters.zombies.Zombies;
import functions.GameAllInformation;
import functions.projectStart;
import graphics.makeCharacters.makeCharacters;
import graphics.makeDraggable;
import graphics.makeTable;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.security.interfaces.EdECKey;
import java.util.ArrayList;
import java.util.Random;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import static Saving.connecting.score;
import static functions.projectStart.root;
import static graphics.makeTable.Score;


public class playGround2 extends HBox {


    private ArrayList <Player> plants=new ArrayList<>();
    private ArrayList<Zombies> zombies=new ArrayList<>();
    private Plants moving_plant;
    private ImageView movingPlant;
    private int flowerAvailable=2;
    private int greenAvailable=0;
    private int iceAvailable=0;
    private int mushroomAvailable=0;


    @FXML
    private ImageView folwer= new ImageView(new File("/graphics/playGroundButtons/flower.png").toURI().toString());
    private Buttons flower_btn=new Buttons(folwer,new Flower());

    @FXML
    private ImageView greenFighter= new ImageView(new File("/graphics/playGroundButtons/fighter.png").toURI().toString());
    private Buttons green_btn=new Buttons(greenFighter,new greenFighter());


    @FXML
    private ImageView iceFlower =new ImageView(new File("/graphics/playGroundButtons/ice.png").toURI().toString());
    private Buttons ice_btn=new Buttons(iceFlower,new Ice());

    @FXML
    private ImageView mushroom =new ImageView(new File("/graphics/playGroundButtons/mushroom.png").toURI().toString());
    private Buttons mushroon_btn=new Buttons(mushroom,new Reverser());

    @FXML
    private ImageView menu=new ImageView(new File("/graphics/playGroundButtons/home.png").toURI().toString());


    @FXML
    private Label moneyLabel=new Label("50");

    @FXML
    private Label myTimer=new Label("2:00");

    @FXML
    private ImageView hourglass=new ImageView(new File("/graphics/playGroundButtons/favpng_hourglass-pointer-icon.png").toURI()
            .toString());

    @FXML
    private ImageView treasureLabel=new ImageView(new File("/graphics/playGroundButtons/favpng_treasure-piracy.png").toURI()
            .toString());




    //===============================================our variables==============================================================



    public playGround2()
    {
        plants=new ArrayList<>();
        moneyChecking();
        addingZombies();
        gameTimer();
    }

//============================================================================================================FXML ACTION PERFORMS


    @FXML
    void flowerPressed(MouseEvent event) {
        if (flowerAvailable >=2) {
            Flower f = new Flower();
            Player player = setNewPlant("../../resources/images/flower.png", 90, 90, 90, 90, f, folwer);
            newFlower(player);

            flowerAvailable = 0;
            flower();
            newMoney(flower_btn);

            folwer.setDisable(true);
        }
    }


    @FXML
    void greenPressed(MouseEvent event) {

        if (greenAvailable>=2) {

            greenFighter green = new greenFighter();
            Player player = setNewPlant("../../resources/images/fighter.png", 106, 90, 106, 90, green, greenFighter);
            newGreenAndIce(player);

            greenAvailable = 0;
            green();

            newMoney(green_btn);

            greenFighter.setDisable(true);
        }
    }


    @FXML
    void icePressed(MouseEvent event) {

        if (iceAvailable >= 2) {


            Ice ice = new Ice();
            Player player = setNewPlant("../../resources/images/ice.png", 114, 90, 114, 90, ice, iceFlower);
            newGreenAndIce(player);

            iceAvailable = 0;
            ice();

            newMoney(ice_btn);

            iceFlower.setDisable(true);
        }
    }


    @FXML
    void mushroomPressed(MouseEvent event) {

       if (mushroomAvailable>=2) {
           Reverser r = new Reverser();
           Player player = setNewPlant("../../resources/images/mushroom.png", 90, 90, 90, 90
                   , r, mushroom);


           newMoney(mushroon_btn);

           mushroomAvailable = 0;
           mushroom();

           mushroom.setDisable(true);
       }

    }



    @FXML
    void homePressed(MouseEvent event) {
        Pane root2 =new Pane();
        Stage stage=new Stage();
        try {
            root2=load("graphics/HomePage.fxml");
        }catch (Exception e){}

        stage.setScene(new Scene(new Group(root2)));
        stage.show();
    }

    @FXML
    void homePageClicked(MouseEvent event) {

        Pane root2 =new Pane();
        Stage stage=new Stage();
        try {
             root2=load("graphics/HomePage.fxml");
        }catch (Exception e){}

        stage.setScene(new Scene(new Group(root2)));
        stage.show();
    }

    public Pane load(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader(projectStart.class.getResource("../" + path));
        loader.load();
        return loader.getRoot();
    }


    @FXML
    void homeAction(ActionEvent event) {
        Pane root2 =new Pane();
        Stage stage=new Stage();
        try {
            root2=load("graphics/HomePage.fxml");
        }catch (Exception e){}

        stage.setScene(new Scene(new Group(root2)));
        stage.show();

    }


    //=============================================================================================================================


    public Player setNewPlant(String path , long X , long Y , long layoutX ,long layoutY , Plants plants1,ImageView pressedBTN)
    {

        Player new_player=new Player(plants1 , X, Y);

        new_player.getRectangle().setFill(loadImage(path));

        root.getChildren().add(new_player.getRectangle());

        makeDraggable.draggable(pressedBTN,new_player.getRectangle());


        plants.add(new_player);


        return new_player;

    }

    public static ImagePattern loadImage(String path) {
        return new ImagePattern(
                new Image(playGround2.class.getResourceAsStream(path))
        );
    }

    //==============================================================make onr thread for each player
    private void newFlower(Player player)
    {

        new Thread(() -> {
            while (player.getThePlayer().getHealth() > 0)
            {
                try {
                    Thread.sleep(8000);
                }catch (Exception e){}

                if (player.getThePlayer().getHealth() > 0) {
                    suns new_sun = new suns(new Rectangle(player.getRectangle().getLayoutX(), player.getRectangle().getLayoutY()
                            , 80, 80));
                    Platform.runLater(() -> root.getChildren().add(new_sun.getTheSun()));
                    makeDraggable.clickable(new_sun.getTheSun() ,moneyLabel);
                }
            }
        }).start();
    }

    private void newGreenAndIce(Player player)
    {
        new Thread(() -> {
            while (player.getThePlayer().getHealth() > 0)
            {
                try {
                    Thread.sleep(player.getThePlayer().getFist_timer());
                }catch (Exception e){}

                if (player.getThePlayer().getHealth() > 0) {
                    Circle ammo = new Circle(player.getRectangle().getLayoutX()+250, player.getRectangle().getLayoutY()+140
                            ,13);
                    if (player.getThePlayer() instanceof greenFighter)
                        ammo.setFill(Color.GREEN);
                    else
                        ammo.setFill(Color.BLUE);

                    Platform.runLater(() -> root.getChildren().add(ammo));

                    ammoMoving(player , ammo);
                }
            }
        }).start();
    }


    private void ammoMoving(Player player , Circle ammo )
    {
        new Thread(() -> {
            boolean kicked=false;
            while ((ammo.getLayoutX() < 1200 ))
            {
                Platform.runLater(() -> { ammo.setLayoutX(ammo.getLayoutX()+1);});
                kicked=isKicked( ammo , player);

                if (kicked)
                    break;

                try {
                    Thread.sleep(player.getThePlayer().getSpeed());
                }catch (Exception e){}

            }
            Platform.runLater(new Runnable() {
                @Override public void run() {
                    root.getChildren().remove(ammo);
                }});

         //   Platform.runLater(() -> { root.getChildren().remove(ammo);});

        }).start();
    }


    private boolean isKicked( Circle ammo , Player player)
    {
        for (Zombies walking_zombie : zombies)
        {
            if (!walking_zombie.isAlive())
                continue;

            if (walking_zombie.getChar_group().getBoundsInParent().intersects(ammo.getBoundsInParent())) {
                walking_zombie.setHealth(player.getThePlayer().getFist_power());

                if (player.getThePlayer() instanceof Ice) {
                    walking_zombie.setSpeed(walking_zombie.getSpeed() + 3);
                }

                if (walking_zombie.getHealth() <=0)
                {
                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                            root.getChildren().remove(walking_zombie.getChar_group());
                        }});
                   // Platform.runLater(() -> { root.getChildren().remove(walking_zombie.getChar_group());});
                    walking_zombie.setAlive(false);
                }
                return true;
            }
        }
        return false;
    }

    //===============================================================================================================================


    private void newMoney(Buttons btn)
    {
        Platform.runLater(() -> moneyLabel.setText(Integer.toString(Integer.parseInt(moneyLabel.getText())-btn.getPlant().getPrice())));
    }

    //managing the game ending time
    public void gameTimer()
    {
        new Thread(() -> {
            int minute = 2;
            int seconds = 0;
            int millis = 120000;

            while (millis > 0) {
                try {
                    Thread.sleep(1000);
                    millis -= 1000;
                    if (seconds == 0) {
                        seconds = 59;
                        minute--;
                    } else
                        seconds--;

                    int finalMinute = minute;
                    int finalSeconds = seconds;
                    // myTimer.setText(finalMinute + ":" + finalSeconds);
                    Platform.runLater(() -> myTimer.setText(finalMinute + ":" + finalSeconds));


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            GameAllInformation.ended = true;
            makeWinningTable(true);
        }).start();
    }


    private void moneyChecking()
    {
        new Thread(() -> {
           while (!GameAllInformation.ended)
           {
               if (Integer.parseInt(moneyLabel.getText()) >= flower_btn.getPlant().getPrice())
                   flowerAvailable++;
               if (Integer.parseInt(moneyLabel.getText()) >= ice_btn.getPlant().getPrice())
                   iceAvailable++;
               if (Integer.parseInt(moneyLabel.getText()) >= green_btn.getPlant().getPrice())
                   greenAvailable++;
               if (Integer.parseInt(moneyLabel.getText()) >= mushroon_btn.getPlant().getPrice())
                   mushroomAvailable++;

               if (flowerAvailable>=2)
                   folwer.setDisable(false);
               if (iceAvailable >=2)
                   iceFlower.setDisable(false);
               if (greenAvailable >=2)
                   greenFighter.setDisable(false);
               if (mushroomAvailable>=2)
                   mushroom.setDisable(false);

               try {
                   Thread.sleep(500);
               }catch (Exception e){}

           }

        }).start();
    }

    private void flower()
    {
        new Thread(() -> {
           try {
               Thread.sleep(flower_btn.getPlant().getTimer());
               ++flowerAvailable;
           }catch (Exception e){}

        }).start();
    }
    private void ice()
    {
        new Thread(() -> {
           try {
               Thread.sleep(ice_btn.getPlant().getTimer());
               ++iceAvailable;
           }catch (Exception e){}

        }).start();

    }
    private void green()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
             try {
                 Thread.sleep(green_btn.getPlant().getTimer());
                 ++greenAvailable;
             }catch (Exception e){}
            }
        }).start();
    }
    private void mushroom()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(mushroon_btn.getPlant().getTimer());
                    ++mushroomAvailable;
                }catch (Exception e){}
            }
        }).start();
    }


    //========================================================================ZOMBIE PART=========================================
    public void addingZombies()
    {
            //for making a new zombie and added to the frame
            new Thread(() -> {

                while (! GameAllInformation.ended) {
                    //making a random line
                    Random randLine = new Random();
                    int line = randLine.nextInt(4);


                    //making a random time to be shown up
                    Random randTime = new Random();
                    int time = randTime.nextInt(6);
                    time += 5;


                    //random zombie
                    Random random=new Random();
                    int zombie = random.nextInt(3);
                    zombie+=1;

                    //make the thread wait till the time comes for a new zombie
                    try {
                        Thread.sleep(time * 1000);
                    } catch (Exception e) {
                    }

                    //first 50 -----> each 140

                    long X_POS=600;
                    long destiny= -1200;

                    Zombies new_zombie=makeRandomZombie(zombie);
                    new_zombie.getMake_Characters().rotatingThePictures(200);


                    new_zombie.getMake_Characters().position(X_POS, 30+(line*70));
                    //new_zombie.getMake_Characters().Moving(destiny, new_zombie.getSpeed()*9);

                    Platform.runLater(() -> root.getChildren().add(new_zombie.getChar_group()));
                    zombies.add(new_zombie);

                    eachZombie(new_zombie);

                }
            }).start();
    }

    //controlling each zombie
    private void eachZombie(Zombies theZombie)
    {
        new Thread(() -> {
            boolean changed=false;
                while (theZombie.getChar_group().getTranslateX() > -650 ) {
                    if (changed)
                        break;
                    for (Player player : plants) {
                        boolean notDead = true;
                        if (! player.getThePlayer().isAlive())continue;
                        if (player.getRectangle().getBoundsInParent().intersects(theZombie.getChar_group().getBoundsInParent())) {
                            while (notDead)
                                try {
                                    //theZombie.getMake_Characters().waiting(theZombie.getFist_timer());
                                    player.getThePlayer().setHealth(theZombie.getFist_power());

                                    if (player.getThePlayer().getHealth() <= 0) {
                                        notDead = false;
                                        player.getThePlayer().setAlive(false);

                                        Platform.runLater(() -> root.getChildren().remove(player.getRectangle()));

                                    }

                                    if (player.getThePlayer() instanceof Reverser) {
                                        //reversing the zombie and putting it in the plants
                                        theZombie.getMake_Characters().rotatingThePictures(600);

                                        theZombie.setAlive(false);

                                        Player changedZombie = new Player();
                                        changedZombie.setThePlayer(theZombie);

                                        if (player.getThePlayer().getHealth()<=0)
                                        {
                                            player.getThePlayer().setAlive(false);
                                            Platform.runLater(() -> root.getChildren().remove(player.getRectangle()));
                                        }

                                        //controlling it
                                        changedZombieController(changedZombie);
                                        changed=true;
                                        break;
                                    }

                                    Thread.sleep(theZombie.getFist_timer());
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            break;
                        }
                    }
                    theZombie.getChar_group().setTranslateX(theZombie.getChar_group().getTranslateX()-1);
                    try {
                        Thread.sleep(theZombie.getSpeed());
                    } catch (Exception e) {}

                }
                //zombie won!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

            makeWinningTable(false);

        }).start();
    }


    private void makeWinningTable(boolean won)
    {
        try {
            Pane back1 = new Pane();
            ImageView view;

            if ( ! won)
                view=new ImageView(new Image("/resources/images/index.jpg"));
            else view=new ImageView(new Image("/resources/images/lost.jpg"));


            view.setFitHeight(840);
            view.setFitWidth(1600);
            back1.getChildren().add(view);

            Score();

            Pane pane=new Pane();
            pane=load("graphics/makeTable.fxml");

            projectStart.primaryStage.setScene(new Scene(new Group(back1 ,pane)));
            projectStart.primaryStage.setFullScreen(true);
            projectStart.primaryStage.sizeToScene();
            projectStart.primaryStage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void changedZombieController(Player player)
    {
        new Thread(() -> {
            while (((Zombies) player.getThePlayer()).getChar_group().getTranslateX() < 1300) {
                for (Zombies zombie : zombies) {
                    if ( !zombie.isAlive())
                        continue;
                    boolean notDead = true;
                    if (zombie.getChar_group().getBoundsInParent().intersects(((Zombies) player.getThePlayer()).getChar_group().getBoundsInParent())) {

                        while (notDead) {
                            try {
                                Thread.sleep(player.getThePlayer().getFist_timer());
                                zombie.setHealth(player.getThePlayer().getFist_power());

                                if (player.getThePlayer().getHealth() <= 0)
                                    notDead = false;
                            } catch (Exception e) {
                            }
                        }
                    }
                }

                try {
                    Thread.sleep(player.getThePlayer().getSpeed());
                } catch (Exception e) {
                }

                Platform.runLater(() -> ((Zombies) player.getThePlayer()).getChar_group().setTranslateX(
                        ((Zombies) player.getThePlayer()).getChar_group().getTranslateX() + 1));
            }
            Platform.runLater(() -> root.getChildren().remove(player));
        }).start();
    }

    //making a random zombie
    private Zombies makeRandomZombie(int zombie)
    {
        Zombies Zombie;

        if (zombie==1)
            Zombie=new BucketHatZombie();
        else if (zombie == 2)
            Zombie=new RunnerZombie();
        else
            Zombie=new TrafficHatZombie();

        return Zombie;
    }

    //====================================================

    public Plants getMoving_plant() {
        return moving_plant;
    }


    public void setMoving_plant(Plants moving_plant) {
        this.moving_plant = moving_plant;
    }

    public ImageView getMovingPlant() {
        return movingPlant;
    }

    public void setMovingPlant(ImageView movingPlant) {
        this.movingPlant = movingPlant;
    }

    public Label getMoneyLabel() {
        return moneyLabel;
    }

    public void setMoneyLabel(Label moneyLabel) {
        this.moneyLabel = moneyLabel;
    }
}


