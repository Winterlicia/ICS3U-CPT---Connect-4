import arc.*;

public class kadenCPTdraft {
	
	//Initializing public static variables
	//Creating a new instance of the 2D String array, with 6 rows and 7 columns
	public static String strBoard[][] = new String[6][7];
	public static int intRow;
	public static int intCol;
	public static String strName;
	public static int intPlayerTurn;
	public static int intPlayerInput;
	
	public static void main(String[]args){
		Console con = new Console();
		
		game(con);
	}
	
	//Method for the actual game
	public static void game(Console con) {
		
		//Initializing local variables for the game
		String strPlayer1;
		String strPlayer2;
		boolean blnHasWinner;
		int intTurn;
		String strResponse;
		
		//Beginning of the game: Ask for user input
		con.println("Connect 4");
		con.println();
		con.println("Player 1, enter your name: ");
		strPlayer1 = con.readLine();
		con.println(strPlayer1 + ", you will use 'O' as your checker.");
		con.println();
		con.println("Player 2, enter your name: ");
		strPlayer2 = con.readLine();
		con.println(strPlayer2 + ", you will use 'X' as your checker.");
		
		//Keep everything inside the while true loop until it is broken out of later when the game ends
		while (true) {
			blnHasWinner = false;
			intTurn = 0;
			
			//Initializing array
			for (intRow = 0; intRow < 6; intRow++) {
				for (intCol = 0; intCol < 7; intCol++) {
					strBoard[intRow][intCol] = " ";
				}
			}
			
			printBoard(con);
			con.println();
			
			//while loop for a game where player 2 USES a cheat code
			//because a player gets to go twice, the # of turns is now only 28 and not 42.
			//only player 2 can use the cheat code
			while (strPlayer2.equals("strongertogether") && blnHasWinner != true && intTurn < 42) { 
				//Modulus is used to alternate the turns between 0 and 1 or 2. 
				intPlayerTurn = intTurn % 3;
				
				//alternates the name between player 1 and 2 according to the modulus
				strName = intPlayerTurn == 0 ? strPlayer1 : strPlayer2;
				
				//ask player for input
				con.println(strName + ", choose any column from 0 to 6");
				intPlayerInput = con.readInt();
				
				//validate the input using the method
				validate(con);
				
				//drop the checker
				dropChecker(con);
				
				if (strName.equals("strongertogether")) {
					con.println("You get another turn because of your name's cheat code.");
					con.println("Choose another column from 0 to 6:");
					intPlayerInput = con.readInt();
					
					validate(con);
					dropChecker(con);
					
					intTurn++;	
				}
				
				//print out the updated board once the checker has dropped
				printBoard(con);
				con.println();
				
				//assign blnHasWinner to the boolean method, which will be true or false 
				//depending if there is a winner
				blnHasWinner = checkWinner(con, intPlayerTurn);
				
				//increment the turn by 1 until it reaches 42 turns
				intTurn++;
			}	
			
		//while loop for a normal game where the players DO NOT use the cheat code
			while (blnHasWinner != true && intTurn < 42) {
				//Modulus is used to alternate the turns between 0 and 1.
				intPlayerTurn = intTurn % 2;
				
				//alternates the name between player 1 and 2 according to the modulus
				strName = intPlayerTurn == 0 ? strPlayer1 : strPlayer2;
				
				//ask player for input
				con.println(strName + ", choose any column from 0 to 6");
				intPlayerInput = con.readInt();
				
				//validate the input using the method
				validate(con);
				
				//drop the checker
				dropChecker(con);
				
				//print out the updated board once the checker has dropped
				printBoard(con);
				con.println();
				
				//assign blnHasWinner to the boolean method, which will be true or false 
				//depending if there is a winner
				blnHasWinner = checkWinner(con, intPlayerTurn);
				
				//increment the turn by 1 until it reaches 42 turns
				intTurn++;
			}					
			
			//If there is still no winner by the end of the 42 turns, declare a draw game
			if (blnHasWinner != true) {
				con.println("Draw game!");
			}
			
			//Ask if the players want ot play again
			con.println("Good game to both players!");
			con.println("Play again? yes/no");
			strResponse = con.readLine();
			if (strResponse.equalsIgnoreCase("no")) {
				con.println("Going back to the main menu...");
				con.sleep(500);
				con.clear();
				kadenstartmenucpt.startMenu(con);
				break;
				//have some kind of main menu method here				
			} else if (strResponse.equalsIgnoreCase("yes")) {
				con.println("Playing again!");
				con.sleep(500);
				con.clear();
			} else {
				con.println("Add a valid input, yes/no!");
				strResponse = con.readLine();
			}
		}
	}
	
	//Method to print the board
	//Printed each time as the board updates
	public static void printBoard(Console con) {		
		con.println(" 0   1   2   3   4   5   6");
		con.println();
		for (intRow = 0; intRow < 6; intRow++) {
			for (intCol = 0; intCol < 7; intCol++) {
				con.print(strBoard[intRow][intCol] + " | ");
			}
			con.println();
			con.println("--+---+---+---+---+---+---+-");
		}		
	}
	
	//Method to validate the board
	public static void validate(Console con) {
		//check the validity of the input, ensuring it's within the specified columns
		while (intPlayerInput < 0 || intPlayerInput > 6) {
			con.println("This column doesn't exist. Choose another column: ");
			intPlayerInput = con.readInt();
		}
				
		//check the column's occupancy
		while (strBoard[0][intPlayerInput] != " ") {
			con.println("This column is already filled! Choose another column: ");
			intPlayerInput = con.readInt();
		}
	}
	
	//method to drop the checker into the board
	public static void dropChecker(Console con) {
		//Using a for loop to drop the checker. It will check if the 6 rows are filled.
		//It will keep looping until it finds an empty position.
		for (intRow = 5; intRow >= 0; intRow--) {
			if (strBoard[intRow][intPlayerInput].equals(" ")) {
				strBoard[intRow][intPlayerInput] = intPlayerTurn == 0 ? "O" : "X";
				break;
			}
		}	
	}
	
	//method to check for a winner and update the leaderboard
	public static boolean checkWinner(Console con, int intCurrentPlayer) {
		String strWinner = "";
		String strCurrentPlayer;
		
		//Assign strCurrentPlayer to hold a value of O or X to check if there is a winner for both players 
		strCurrentPlayer = intCurrentPlayer == 0 ? "O" : "X";
		
		// Four ways to win in Connect 4:		
		
		System.out.println("TEST: width = "+strBoard[0].length);
		System.out.println("TEST: length = "+strBoard.length);
		
		// 1) Horizontal win by 4 //
		for (intRow = 0; intRow < strBoard.length; intRow++){ 
			for (intCol = 0; intCol < strBoard[0].length - 3; intCol++){ 
				if (strBoard[intRow][intCol].equals(strCurrentPlayer)
				&& strBoard[intRow][intCol+1].equals(strCurrentPlayer)
				&& strBoard[intRow][intCol+2].equals(strCurrentPlayer)
				&& strBoard[intRow][intCol+3].equals(strCurrentPlayer)) {
					strWinner = strName;
				}
			}
		}
		
		// 2) Vertical win by 4 //
		for (intCol = 0; intCol < strBoard[0].length; intCol++){ 	
			for (intRow = 0; intRow < strBoard.length - 3; intRow++){
				if (strBoard[intRow][intCol].equals(strCurrentPlayer)
				&& strBoard[intRow+1][intCol].equals(strCurrentPlayer)
				&& strBoard[intRow+2][intCol].equals(strCurrentPlayer)
				&& strBoard[intRow+3][intCol].equals(strCurrentPlayer)) {
					strWinner = strName;
				}
			}
		}
		
		// 3) Descending Diagonal Win by 4 //
		for (intRow = 3; intRow < strBoard.length; intRow++){
			for (intCol = 3; intCol < strBoard[0].length; intCol++){
				if (strBoard[intRow][intCol].equals(strCurrentPlayer)
				&& strBoard[intRow-1][intCol-1].equals(strCurrentPlayer)
				&& strBoard[intRow-2][intCol-2].equals(strCurrentPlayer)
				&& strBoard[intRow-3][intCol-3].equals(strCurrentPlayer)) {
					strWinner = strName;
				}
			}
		}
		
		// 4) Ascending Diagonal Win by 4 //
		for (intRow = 3; intRow < strBoard.length; intRow++){
			for (intCol = 0; intCol < strBoard[0].length - 3; intCol++){
				if (strBoard[intRow][intCol].equals(strCurrentPlayer)
				&& strBoard[intRow-1][intCol+1].equals(strCurrentPlayer)
				&& strBoard[intRow-2][intCol+2].equals(strCurrentPlayer)
				&& strBoard[intRow-3][intCol+3].equals(strCurrentPlayer)) {
					strWinner = strName;
				}
			}
		}
		
		//If there's a winner, print the name of the person who won the game, and update the leaderboard
		//Then return true, else return false and the game keeps going.
		if (!strWinner.equals("")) {
			con.println(strWinner + " has won the game!");
			con.println();
			con.println();
		
		//process the leaderboard using the CPTLeaderboard class. Print out the bubble sorted leaderboard for players to see.	
		kadenCPTLeaderboard.processLeaderboard(con, strWinner);
			
			return true;		
		} else {
			return false;
		}
	}
}
