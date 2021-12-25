package com.bdse.pfs.a1;

import java.util.Scanner;
import  java.util.Random;

public class Main {
    public static String space = " ";
    public static void main(String[] args) {

        //input
        Scanner startPlay = new Scanner (System.in);
        boolean game = false;

        //inside items
        MainInt();
        System.out.println();
        System.out.println("_________________");

        while (game == false){
            System.out.println("Please type \"play\":" + "\t");
            String startGame = startPlay.next();
            if(startGame.equals("play")){
                game = true;
                newGame();
            }else{
                System.out.println("enter a valid response");
            }
        }

//this is how you declare an input InnerInput[2][1] = "3"

    }

    //main menu
    public static void MainInt(){
        // battleship map
        System.out.println("******************************");
        System.out.println("**Welcome to Battleship Game**");
        System.out.println("******************************");
        System.out.println();

        String [][] InnerInput = new String [10][10];
        for (int i = 0; i< InnerInput.length; i++){
            for(int j = 0; j <InnerInput[i].length; j++){
                InnerInput[i][j] = space;
            }

        }

        InnerInput[3][3]= "T";
        InnerInput[3][4] ="Y";
        InnerInput[3][5] = "P";
        InnerInput[3][6] ="E";

        InnerInput[5][3] = "P";
        InnerInput[5][4] = "L";
        InnerInput[5][5] = "A";
        InnerInput[5][6] = "Y";

        InnerInput[7][4] ="T";
        InnerInput[7][5]="O";

        InnerInput[8][1]="C";
        InnerInput[8][2]="O";
        InnerInput[8][3]="N";
        InnerInput[8][4]="T";
        InnerInput[8][5]="I";
        InnerInput[8][6]="N";
        InnerInput[8][7]="U";
        InnerInput[8][8]="E";

        //this for loop prints the left column
        for (int row = 0; row < 12; row++){
            //if the row = 0 then no display
            if(row == 0){
                System.out.print(space + space + space);

            }else{
                //prints the 0 to 9 the left
                if (row <=10){
                    System.out.print(row - 1 + " |");
                    //if it reaches row 11 then space gets printed at the bottom
                }else if(row == 11){
                    System.out.print(space + space + space);
                }
            }

            for(int col = 0; col <10; col++){
                if (row == 0){
                    //top 1 - 9
                    System.out.print(col);
                    //bottom 1 - 9
                }else if (row == 11){
                    System.out.print(col);

                }else{

                    //adds space inside to fill the emptiness chour
                    System.out.print(InnerInput[row-1][col]);
                }


            }
            if(row == 0){
                System.out.println(space);
            }else{
                if(row <= 10){
                    System.out.println("| "+ (row - 1));
                }
            }

        }
    }

    //solely for the display of the contents
    public static void map(String [][] Seaobjects){
        //declare outside the method or function
//        String [][] InnerDisplay = new String [10][10];
//        for (int i = 0; i< InnerDisplay.length; i++){
//            for(int j = 0; j <InnerDisplay[i].length;j++){
//                InnerDisplay[i][j] = space;
//            }
//        }
        System.out.println("******************************");
        System.out.println("**Welcome to Battleship Game**");
        System.out.println("******************************");
        System.out.println();
        String [][] InnerDisplay = Seaobjects;
        //sea map
        for (int row = 0; row < 12; row++){
            //if the row = 0 then no display
            if(row == 0){
                System.out.print(space + space + space);

            }else{
                //prints the 0 to 9 the left
                if (row <=10){
                    System.out.print(row - 1 + " |");
                    //if it reaches row 11 then space gets printed at the bottom
                }else if(row == 11){
                    System.out.print(space + space + space);
                }
            }

            for(int col = 0; col <10; col++){
                if (row == 0){
                    //top 1 - 9
                    System.out.print(col);
                    //bottom 1 - 9
                }else if (row == 11){
                    System.out.print(col);

                }else{

                    //adds space inside to fill the emptiness chour
//                    System.out.println(space);
                    System.out.print(InnerDisplay[row-1][col]);
                }


            }
            if(row == 0){
                System.out.println(space);
            }else{
                if(row <= 10){
                    System.out.println("| "+ (row - 1));
                }
            }

        }
        System.out.println();
        System.out.println("_________________");

    }

    //game
    public static void newGame(){

        int boardLength = 10;
        int PlayerMaxShip = 5;
        int ComputerMaxShip = 5;
        String PlayerShipSymb ="@";
        String sea = space;

        String [][] emptyfornow = new String[boardLength][boardLength];
        for (int i = 0; i< emptyfornow.length; i++){
            for(int j = 0; j <emptyfornow[i].length;j++){
                emptyfornow[i][j] = sea;
            }
        }
        //display map
        System.out.println("\n\n\n");
        System.out.println("the sea is empty for now");
        map(emptyfornow);

        //2 phases, setup and attack
        //return setup phase later in a variable where map can be displayed.
        String [][] InnerDisplay = setupPhase(boardLength, sea, PlayerMaxShip, ComputerMaxShip,PlayerShipSymb);
        String[][] GridDisplayer = new String[boardLength][boardLength];

        for(int row = 0; row < InnerDisplay.length; row++){
            for(int col =0; col < InnerDisplay[row].length; col++){
                GridDisplayer[row][col] = InnerDisplay[row][col];
            }
        }

        for (int row = 0; row < GridDisplayer.length; row++){
            for(int col = 0; col< GridDisplayer[row].length; col++){
                if(GridDisplayer[row][col] == "1"){
                    GridDisplayer[row][col] = PlayerShipSymb;
                }else if(GridDisplayer[row][col]=="2"){
                    GridDisplayer[row][col] = sea;
                }
            }
        }
        battlePhase(boardLength, InnerDisplay, GridDisplayer, PlayerMaxShip, ComputerMaxShip);


    }


    //setup phase
    private static String [][] setupPhase(int boardLength, String sea, int playerMaxShip, int computerMaxShip, String playerShipSymb) {

        String [][] InnerDisplay = gridMap(boardLength, sea, playerMaxShip, computerMaxShip, playerShipSymb);

        return InnerDisplay;
    }
    public static String[][] gridMap(int boardLength,String sea, int playerShips, int computerShips, String Shipsdeployed){

        int gridSize = boardLength;
        int playerShipsDeployed = 0;
        int computerShipsDeployed = 0;
        String playersymbol = Shipsdeployed;
        int maxDeploy =playerShips;
        int compMaxdeploy = computerShips;

        String [][] InnerDisplay = new String [boardLength][boardLength];
        for (int i = 0; i< InnerDisplay.length; i++){
            for(int j = 0; j <InnerDisplay[i].length;j++){
                InnerDisplay[i][j] = sea;
            }
        }

        //deploy ships
        while(playerShipsDeployed < maxDeploy){

            // takes player location x and y by 0 and 1
            int [] playerlocations = playerCoordinate(playerShipsDeployed);
            int x = playerlocations[0];
            int y = playerlocations[1];

            //validates if the area has "@" symbol inside.

            //for computer validation, I'll recreate the map but not visible

            //player location is displayed as 1, computer location is displayed as 2
            if (InnerDisplay[x][y]== sea){
                InnerDisplay[x][y] = "1";
                System.out.println("Deploying Ship no. "+ (playerShipsDeployed + 1)+ "!");
                playerShipsDeployed++;
            }else{
                System.out.println("enter new coordinates");
            }
            //checks if x and y is available

        }

        while(computerShipsDeployed< compMaxdeploy){

            int[] computerlocations = compcoordinate(computerShipsDeployed);
            int x = computerlocations[0];
            int y = computerlocations[1];

            if(InnerDisplay[x][y] == sea){
                InnerDisplay[x][y]= "2";
                System.out.println("Deploying Enemy Ships");
                computerShipsDeployed++;
            }


        }
        return InnerDisplay;
    }
    private static int[] compcoordinate(int computerShipsDeployed) {
        Scanner CompCoords = new Scanner(System.in);
        Random randomcoords = new Random();
        int[]Coordinates = new int[2];
        for(int coords = 0; coords < Coordinates.length; coords++){

            //x deploying
            int randX = randomcoords.nextInt(10);
            Coordinates[0] = randX;

            //y deploying
            int randY =randomcoords.nextInt(10);
            Coordinates[1] = randY;


        }

        return Coordinates;
    }
    private static int[] playerCoordinate(int deployed) {
        Scanner playercoordinates = new Scanner(System.in);

        int[] Coordinates = new int [2];
        for (int coordx = 0; coordx<Coordinates.length; coordx++){
            System.out.println("Enter your X coordinate for your " + (deployed +1) + " ship: ");
            if (playercoordinates.hasNextInt()){
                int coordscanx = playercoordinates.nextInt();
                if((coordscanx<0 || coordscanx>9)){
                    System.out.println("enter a valid coordinate");
                }else{
                    Coordinates[0] = coordscanx;
                    //proceeds to y
                    System.out.println("Enter your Y coordinate for your " +(deployed +1)+" ship: ");

                    if(playercoordinates.hasNextInt()){
                        int coordscany = playercoordinates.nextInt();
                        if(coordscany <0 || coordscany >9){
                            System.out.println("enter a valid coordinate");
                        }else{
                            Coordinates[1] = coordscany;
                            return Coordinates;
                        }

                    }else{
                        System.out.println("enter a valid response");
                        return playerCoordinate(deployed);
                    }
                }
            }else{
                System.out.println("enter a valid response");
                return playerCoordinate(deployed);
            }

        }


        return playerCoordinate(deployed);
    }


    //battle phase
    private static void battlePhase(int length, String[][] innerDisplay, String[][] gridDisplayer, int playerDeploy, int compDeploy) {

        boolean GameProgress = true;

        int Round = 1;
        String PlayerGotHit = "x";
        String ComputerGotHit ="!";
        String Missed ="-";

        int MaxPlayerShip = playerDeploy;
        int MaxCompShip = compDeploy;
        int lengthBoard = length;

        String [][] SystemLogs = innerDisplay;
        String [][] GUIdisplay = gridDisplayer;

        String [][]SyslogCompare = new String[length][length];
        for (int row = 0; row < SyslogCompare.length; row++){
            for(int col = 0; col < SyslogCompare[row].length; col++){
                SyslogCompare[row][col] = SystemLogs[row][col];
            }
        }

        System.out.println("_____________________________");
        System.out.println("*************Turn " + Round + "**********");
        System.out.println("_____________________________");
//        map(SyslogCompare);
        System.out.println("\n\n\n");
        map(GUIdisplay);
        System.out.println("All ships Deployed!!");

        //loop game progress
        while(GameProgress == true){


            //fix the loop here

            //it displays map depending on how many symbols are present.

            //should only display once.
            System.out.println("YOUR TURN");
            int [] playerGuess = playerGuessCoords(length);
            int PguessX = playerGuess[0];
            int PguessY = playerGuess[1];
            String [][] playermapUpdate = updateMap(lengthBoard, playerGuess,SystemLogs,PlayerGotHit, ComputerGotHit, Missed);
            String [][] GUIupdate = GuiMap(playermapUpdate,GUIdisplay);
            System.out.println("\n\n\n");
            System.out.println("_____________________________");
            System.out.println("************Turn " + Round + "***********");
            System.out.println("_____________________________");
//            map(playermapUpdate);
            map(GUIupdate);


            if(playermapUpdate[PguessX][PguessY].equals(PlayerGotHit)&& SyslogCompare[PguessX][PguessY].equals("1")){
                System.out.println("oh no! You sunk your own ship. :(");
                SyslogCompare[PguessX][PguessY] = "x";
                MaxPlayerShip--;
                System.out.println("_____________________________");
                System.out.println("Your Ship: " + MaxPlayerShip +" | Enemy Ship: " + MaxCompShip);
                System.out.println("_____________________________");
                System.out.println();
            }else if(playermapUpdate[PguessX][PguessY].equals(ComputerGotHit)&& SyslogCompare[PguessX][PguessY].equals("2")){
                System.out.println("Boom! You sunk the enemy ship.");
                SyslogCompare[PguessX][PguessY] = "!";
                MaxCompShip--;
                System.out.println("_____________________________");
                System.out.println("Your Ship: " + MaxPlayerShip +" | Enemy Ship: " + MaxCompShip);
                System.out.println("_____________________________");
                System.out.println();
            }else if(playermapUpdate[PguessX][PguessY].equals(Missed)&& SyslogCompare[PguessX][PguessY].equals(space)){
                System.out.println("Sorry, you missed!");
                SyslogCompare[PguessX][PguessY] = "-";
                System.out.println("_____________________________");
                System.out.println("Your Ship: " + MaxPlayerShip +" | Enemy Ship: " + MaxCompShip);
                System.out.println("_____________________________");
                System.out.println();

            }else{
                System.out.println("This area was already revealed");
                System.out.println("_____________________________");
                System.out.println("Your Ship: " + MaxPlayerShip +" | Enemy Ship: " + MaxCompShip);
                System.out.println("_____________________________");
                System.out.println();
            }

            int [] compGuess = computerTurn(length);
            int CguessX = compGuess[0];
            int CguessY = compGuess[1];
            String [][] compmapUpdate = updateMap(lengthBoard, compGuess,SystemLogs,PlayerGotHit, ComputerGotHit, Missed);
            System.out.println("\n\n\n");
            System.out.println("_____________________________");
            System.out.println("*************Turn " + Round + "**********");
            System.out.println("_____________________________");
            Round++;
//            map(compmapUpdate);
            GUIupdate = GuiMap(compmapUpdate,GUIdisplay);
            map(GUIupdate);
            if(compmapUpdate[CguessX][CguessY].equals(PlayerGotHit)&& SyslogCompare[CguessX][CguessY].equals("1")){
                System.out.println("Your ship got hit!");
                SyslogCompare[CguessX][CguessY] = "x";
                MaxPlayerShip--;
                System.out.println("_____________________________");
                System.out.println("Your Ship: " + MaxPlayerShip +" | Enemy Ship: " + MaxCompShip);
                System.out.println("_____________________________");
                System.out.println();
            }else if(compmapUpdate[CguessX][CguessY].equals(ComputerGotHit)&& SyslogCompare[CguessX][CguessY].equals("2")){
                System.out.println("Enemy sank their own ship!");
                SyslogCompare[CguessX][CguessY] = "!";
                MaxCompShip--;
                System.out.println("_____________________________");
                System.out.println("Your Ship: " + MaxPlayerShip +" | Enemy Ship: " + MaxCompShip);
                System.out.println("_____________________________");
                System.out.println();
            }else if(compmapUpdate[CguessX][CguessY].equals(Missed)&& SyslogCompare[CguessX][CguessY].equals(space)){
                System.out.println("The enemy missed.");
                SyslogCompare[CguessX][CguessY] = "-";
                System.out.println("_____________________________");
                System.out.println("Your Ship: " + MaxPlayerShip +" | Enemy Ship: " + MaxCompShip);
                System.out.println("_____________________________");
                System.out.println();
            }else{
                System.out.println("This area was already revealed");
                System.out.println("_____________________________");
                System.out.println("Your Ship: " + MaxPlayerShip +" | Enemy Ship: " + MaxCompShip);
                System.out.println("_____________________________");
                System.out.println();
            }

            if(MaxCompShip == 0){
                System.out.println("Well done commander! You won.");
                GameProgress = false;
            }else if(MaxPlayerShip == 0){
                System.out.println("The enemy won the battle. We'll get them next time!");
                GameProgress = false;
            }
//            System.out.println(MaxPlayerShip);
        }
    }

    private static String[][] GuiMap(String[][] playermapUpdate,String[][] GUIupdate) {
        String[][] GUI = GUIupdate;

        for (int row = 0; row < playermapUpdate.length; row++){
            for(int col = 0; col < playermapUpdate[row].length; col++){
                if(playermapUpdate[row][col].equals("1")){
                    GUI[row][col] ="@";
                }else if (playermapUpdate[row][col].equals("2")){
                    GUI[row][col] =space;
                }else if(playermapUpdate[row][col].equals("!")){
                    GUI[row][col] = "!";
                }else if(playermapUpdate[row][col].equals("x")){
                    GUI[row][col] = "x";
                }else if(playermapUpdate[row][col].equals("-")){
                    GUI[row][col] = "-";
                }

            }
        }

        return GUI;
    }

    private static int[] computerTurn(int length) {
        Random computerGuess = new Random();
        int [] coordinates = new int [2];
        System.out.println("COMPUTER'S TURN");
        for (int i  =0; i< coordinates.length; i++) {
            int compGuessX = computerGuess.nextInt(10);
            if(compGuessX <0 || compGuessX > 9){
                System.out.println("do something");
            }else{
                coordinates[0] = compGuessX;
                int compGuessY = computerGuess.nextInt(10);
                if(compGuessY<0 || compGuessY>9){
                    System.out.println("do something");
                }else{
                    coordinates[1] = compGuessY;
                    return coordinates;
                }
            }




        }
        return computerTurn(length);
    }
    private static String[][]updateMap(int lengthBoard, int[] Guess, String[][] systemLogs, String playerGotHit, String computerGotHit, String missed) {

        int grid = lengthBoard;

        int GuessX = Guess[0];
        int GuessY = Guess[1];

        String playerHit = playerGotHit;
        String CompHit = computerGotHit;
        String Missed = missed;

        String[][] systemBoard = systemLogs;

        for(int row = 0; row < systemBoard.length; row++){
            for(int col = 0; col < systemBoard[row].length; col++){
                if(systemBoard[GuessX][GuessY].equals(space)){
                    systemBoard[GuessX][GuessY] = Missed;
                    return systemBoard;
                }else if (systemBoard[GuessX][GuessY].equals("1")){
                    systemBoard[GuessX][GuessY] = playerGotHit;
                    return systemBoard;
                }else if(systemBoard[GuessX][GuessY].equals("2")){
                    systemBoard[GuessX][GuessY] = computerGotHit;
                    return systemBoard;
                }else if(systemBoard[GuessX][GuessY].equals("x")|| systemBoard[GuessX][GuessY].equals("-") || systemBoard[GuessX][GuessY].equals("!")){
                    return systemBoard;
                }
            }
        }
        //placing the guessed coordinate inside the new map

        return updateMap(lengthBoard, Guess, systemLogs, playerGotHit, computerGotHit, missed);
    }
    private static int[] playerGuessCoords(int length) {
        Scanner playerGuess = new Scanner(System.in);
        int [] coordinates = new int [2];

        for (int i  =0; i< coordinates.length; i++){

            System.out.println("Enter a X coordinate");
            if(playerGuess.hasNextInt()){
                int playerGuessX = playerGuess.nextInt();
                if(playerGuessX<0 || playerGuessX>9){
                    System.out.println("please enter a valid coordinate");
                }else{
                    coordinates[0] = playerGuessX;
                    System.out.println("Enter a Y coordinate");
                    if(playerGuess.hasNextInt()){
                        int playerGuessY = playerGuess.nextInt();
                        if(playerGuessY < 0 || playerGuessY >9){
                            System.out.println("please enter a valid coordinate");
                        }else{
                            coordinates[1] = playerGuessY;
                            return coordinates;
                        }
                    }else{
                        System.out.println("enter a valid number");
                        return playerGuessCoords(length);
                    }

                }
            }else{
                System.out.println("enter a valid number");
                return playerGuessCoords(length);
            }

        }
        return playerGuessCoords(length);
    }

    /*end of code*/
}
