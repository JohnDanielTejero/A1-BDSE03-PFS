**************************************
*************ASSIGNMENT_1*************
**************************************

/*Pseudocodes*/

//ma'am jey's pseudocode which I'll use as guide
Step 1: Print Map
	1. Declare the map 10 x 10
		=> Two dimensional array
		?  What is the data type?
		=> 1-player, 2-computer, !, x, -
		=> Character Array or String Array
		? Why character
		=> Because we re going to store the single character

	2. Print the welcome message

	3. Print the column index (0-9)
		=> Range - Repeating the same => Loop
		? Which loop? For / do while / while/ for each
		=> Continious numbers - index incremented one by one
		=> for loop for column index

	4. Print the row index (0|spaces|0)
	5. Repeat the step 4 for index 0 to 9
		=> Nested loop - Row, Col
		=> for each row
			for each column
				print rowindex| spaces |rowindex
	6. Print step 3
		=> Clue to create the step 3 as a method. So that, it can be called at
		   any part of the program


Step 2: Deploy Player ships
	1 - Player Ship => Should be represented as @
Initialize the player's ship count = 1
While (player's ship count <= 5)
	1. Prompt the user for x co-ordinate

	Steps 2 & 3 must be executed atleast once
		1. Valid Entry - Only once
		2. Invalid Entry - Repeated until the valid entry
		=> do ... while
	do - while (true)
	2. Get x co-ordinate input
	3. if x co-ordinate is between 0 and 9 goto step 4
	    else goto step 2 => Shouln't reprompt the message until the user enter the valid co-ordinate
	while (0 >= x co-ordinate <=9)

	4. Prompt the user for y co-ordinate

	do
	5. Get y co-ordinate input
	6. if y co-ordinate is between 0 and 9 goto step 7
	    else goto step 5 => Shouln't reprompt the message until the user enter the valid co-ordinate
	while (0 >= x co-ordinate <=9)

	7. If the location is free
		deploy the ship
		Increment the the player's ship count by 1
	   else
		goto step 1	=> Loop
	8. Repeat the steps from 1 to 7 for 5 ships => Loop

	9. Execute Print Map  method

Step 3: Deploy Computer Ships
	2 - Computer Ship => Don't display anything

Step 4:Battle
	Player Turn
		- - Missed target
		! - Sunk computer's ship
		x - Sunk Player's ship

	Computer Turn
		! - Sunk computer's ship
		x - Sunk Player's ship
 		 - Computer Missed

Step 5: Declare the result
	if computer ships = 0 then
		Display "Player Won the match"
	else
		Display "Computer Won the match"


//my pseudocodes based on ma'am jey's with a bit of tweaks

There are Three Phases

A.) First Phase - Menu.

    Print:
    ******************************
    **WELCOME TO BATTLESHIP GAME**
    ******************************
    //Display a static map
*******call static map method();***********

  public static void MainInt(){

    string 2d array grid = new string [10 rows][10 cols]

        for loop until it reaches grid.length{
            for loop until it reaches grid[currentrow].length{

                grid[currentrow][currentcol] = "empty space";

            }
        }

     //will give value to the inputs later on.
     grid[somerow][somecol] = "Let's play"
     //this will make sure that inside the grid a message will be
     displayed

     for loop until it reaches 12 {
        IF row is on 0,{
        print 3 spaces
     }ELSE{
        IF row is less than or equal to 10{
            print row - 1 + "| " //<== this will be the display on the side

        }ELSEIF row is equals 11{
            prints 3 spaces
            }
        }

        for loop until column reaches 9{
              if row is 0 {
                 print current column
              }else if row is 11{
                   print current column
              }else{
                   print grid[row-1][col]
              }
            }
            if row is 0 {
                print line empty space
            }else{
                if row is less than or equal to 10{
                 print line "| " and (row-1)
                }
            }
        }
    }

    Then prompts the user to type "play"

    if user typed is not play{
        loop again to type play
    }else{
        start Game
    }

//start game
B. ) Setup phase

1. Loop 5x to prompt
2. Enter X coordinate
3. Enter Y coordinate
4. Check if Coordinate = space
5. if coordinate.isnot space => go back to step 2
6. if coordinate = space => deploy ship
7. repeat 1 - 6 til 5x
8. computer generate random X
9. computer generate random Y
10. checks if coordinate = space
11. if coordinate.isnot space => go back to step 8
12. if coordinate = space => deploy ship
13. repeat 8 - 12 til 5x
14 store them inside a 2d array

C.) Battle Phase

1. display map while passing the 2d array on setup phase as parameter
2. declare while loop with a condition of a boolean "gamestatus" as its condition.
3. until gamestatus turns false, the loop will continue
4. inside the loop deploy the following condition.
5. ask for coordinates x and y.
6. checks the symbols in the specified x and y in the grid.
7. if symbol is 1 then change it to player hit
8. if symbol is 2 then change it to enemy hit
9. if symbol is space then change it to missed
10. if symbol is either player hit, enemy hit, miss hit then turn is skipped
11. generate random x and y coordinate for computer
12. repeat 7 - 10
13. store the changes to a 2d array
14. compare the 2d array to the gui.
15. make changes to the gui
16. repeat until the either player or user lose

/******LOGS*********/

/*December 22, 2021*/
1. Main Interface Created
2. Set up a map 10x10 with for loop
3. a bit of prompt added.
4. When user hit play, they will be directed to a new game


/*December 23, 2021*/

1. new Game initialized
2. inside the new game, setup phase is called
3. setup phase calls for grid contents
4. inside the grid content, the deploying of ships is called.
5. the value of grid contents is returned and deployed to map.
6. Validating if ship location is duplicated is done.
7. Battle phase is done, after 1st turn, everything gets iterated more than 1 times.
8. Identified the error, the more that symbols increases in the grid, the more it loops so if it has a collective amount
    of 3 then all will be looped 3x which is not what we want.
9. Not yet identified the cause.

/*December 24 2021*/

1.Identified the cause of error, disregarded the loop and made it to selector with if statement.
2. Hid the system logs
3. GUI updates added and implemented
4. Overall functionality is done.

/* December 25, 2021*/
1. made a simple validator.
2. every input gets filtered out unless it is a valid number.



TO DO List for December 24, 2021:
1. --Identify the error-- done
2. --Fix the error--      done
3. --Make the GUI visible-- done
4. --Make the System Interface Invisible-- done



/* FEATURES FOR THE BATTLESHIP GAME*/

**Mechanics

There are three phases: 
A.) Main Menu Phase
B.) Setup Phase
C.) Battle Phase

MAIN MENU
1. ) Preview of the battleship game is displayed
2. ) Player is prompt to type play to start
3. ) Invalid response will not direct you to the game

SETUP PHASE
1. ) Generate a 2d grid 10x10 and name as Logs for now
2. ) Generate Ships

	A. ) Player Phase
		1. ) Prompts the user for x and y coordinate.
		2. ) Checks if the given coordinates are valid: should be a whole number, and should be between 0 - 9
		3. ) If required coordinates are not met, they are directed back to prompt
		4. ) If the coordinates entered are valid, the entries are checked in the grid array if that specified slot is taken
		5. ) If taken already, they are then asked again to enter a new coordinates.
		6. ) If the specified slot is available, the slot is marked as "1".
		7. ) Prompt will be repeating 5x until all ships are placed.

	B. ) Computer Phase
		1. ) Randomly generates x and y coordinate.
		2. ) If the generated x and y coordinate is taken in the 2d array, proceeds to generate new coordinate
		3. ) If the generated coordinate is available, the slot is marked as "2"
		4. ) Repeat all until 5 ships are placed.
		
3. ) Create a copy of 2d grid and name as GUI for now. 
4. ) While copying using a for loop, there's an if statement which checks if there's 1 and 2 inside the Logs 2d array.
5. ) all 1 will be changed to "@"
6. ) all 2 will be changed to " "
7. ) Display the map with GUI as parameter

BATTLE PHASE
1. ) Make a copy of 2d logs and name it as validator for now
2. ) Stores the count of placed ships for both computers and players
3. ) Loop the following until either ships reaches the count of 0
	a. ) prompts the user to input x and y coordinates for guessing
	b. ) if the input is in invalid format, they are prompted again
	c. ) if the input is valid, checks whether it is within the range of 0 - 9
	d. ) if the input is not within the range, the user is asked to input new coordinate.
	e. ) checks the log array whether the user hits a 1 or a 2 or a blank area.
	f. ) player ship will be marked as x, computer ship will be marked as !, and blanked area will be marked as - depending on what the coordinates users have input.
	g. ) the logs which will have the changes, will be compared to validator, if the logs has x and its counterpart in validator is 1, displays a message saying your 		ship is hit and changes the validator's 1 to x(only specific coordinate), if logs has ! and its counterpart is 2, displays a message that states an enemy ship is hit 		and marks the validator's 2 to !(only specific coordinate). If logs has - and its counterpart has a blank space, displays a missed message and change the blank of  		 the said coordinate to "-". If the specified x and y of the logs matches the specified x and y of the validator, displays a message that the area is already 		     revealed.
	h. ) GUI then copies the validator, if 1 is displayed, it gets changed to "@" and 2 will be a blank space. the x ,! , and - will be retained.
	i. ) the GUI is updated and is passed to map as parameter
	j. ) Computer generates x and y coordinates.
	k. ) repeat e - j
