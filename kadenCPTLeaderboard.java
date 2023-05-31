import arc.*; 
import java.util.Arrays;
import java.util.*;

public class kadenCPTLeaderboard {
	
	//Initialize global variables
	public static String[][] strLeaderboard;
	public static String strPlayers;
	public static String strWins;
	
	//method to process the entire leaderboard when there is a new winner in the game
	public static void processLeaderboard(Console con, String strWinner) {
		
		readLeaderboard(con);
		updateLeaderboard(con, strWinner);
		saveToFile(con);
		printLeaderboard(con, strLeaderboard);
		
	}
	
	public static void readLeaderboard(Console con) {
		TextInputFile txtLeaderboardIN = new TextInputFile("kadenleaderboard.txt");
		int intRow;
		int intPlayerCount = 0;
		
		//Count the number of players currently in the text file.
		while (txtLeaderboardIN.eof() == false) {
			strPlayers = txtLeaderboardIN.readLine();
			strWins = txtLeaderboardIN.readLine();
			intPlayerCount += 1;
		}
		
		//Initialize the array with the player count being the number of rows there are, with two columns
		strLeaderboard = new String[intPlayerCount][2];
		txtLeaderboardIN.close();
		txtLeaderboardIN = new TextInputFile("kadenleaderboard.txt");
		
		System.out.println("TEST (readLeaderboard method): Number of players = "+intPlayerCount);
		
		//assign the leaderboard array to store the values of the existing players and wins.
		for (intRow = 0; intRow < intPlayerCount; intRow++) {
			strPlayers = txtLeaderboardIN.readLine();
			strWins = txtLeaderboardIN.readLine();
			strLeaderboard[intRow][0] = strPlayers;
			strLeaderboard[intRow][1] = strWins;
		}
		
		txtLeaderboardIN.close();
		
	}
	
	//Method to update the leaderboard
	public static void updateLeaderboard(Console con, String strLeaderboardWinner) {
		int intWins = 0;
		boolean blnIsNew = true;
		boolean blnIsEmpty = true;
		
		//need to run through each present row to check the array if there is already existing player
		for (int intRow = 0; intRow < strLeaderboard.length; intRow++) {
			
			//we check each row if there is an already existing player in the leaderboard
			//there is no need to add another row, just update the wins and everything is good
			//Use a 2D array to update the win count and print it to the text file
			if (strLeaderboard[intRow][0].equals(strLeaderboardWinner)) {
				blnIsNew = false;
				blnIsEmpty = false;
				intWins = Integer.parseInt(strLeaderboard[intRow][1]);
				intWins += 1;
				strLeaderboard[intRow][1] = String.valueOf(intWins);	
				System.out.println("TEST (updateLeaderboard method): NEW wins = "+strLeaderboard[intRow][1]);	
				break;
			
			}
		}
		
		//If is new is true, then insert a new row with the new winner entry, with a value of 1
		if (blnIsNew || blnIsEmpty) {
			strLeaderboard = insertRow(strLeaderboard, 1, new String[] {strLeaderboardWinner, "1"});
			System.out.println("TEST: What does the array look like? "+Arrays.deepToString(strLeaderboard));
		}
		
		//Once everything is updated, bubble sort the data in the array. 
		bubbleSort(con);
	}
			
	//Method for inserting an extra row if there is a new winner entry into the text file.
	public static String[][] insertRow(String[][] strOriginal, int intR, String[] strData) {
		String[][] strOutput = new String[strOriginal.length + 1][];
		for (int intValue = 0; intValue < intR; intValue++) {
			strOutput[intValue] = strOriginal[intValue];
		}
		strOutput[intR] = strData;
		for (int i = intR+1; i < strOutput.length; i++) {
			strOutput[i] = strOriginal[i-1];
		}
		return strOutput;
	}
	
	public static void bubbleSort(Console con) {
		//Use the bubblesort method to create a leaderboard, ordered on the number of wins.
		
		//BUBBLE SORT
		String strTemp;
		String strCurrentRow;
		String strNextRow;
		for (int intRounds = 0; intRounds < strLeaderboard.length -1; intRounds++){
			for(int intRow = 0; intRow < strLeaderboard.length-1; intRow++){
				//Comparing the current row and the row in front of it to see if the row ahead has more wins.
				strCurrentRow=strLeaderboard[intRow][1];
				strNextRow=strLeaderboard[intRow+1][1];
				if (Double.parseDouble(strCurrentRow) < Double.parseDouble(strNextRow)){
					
					//Comparing the wins first and switching them
					strTemp=strLeaderboard[intRow][1];
					strLeaderboard[intRow][1]=strLeaderboard[intRow+1][1];
					strLeaderboard[intRow+1][1]=strTemp;
					
					//Switching the players
					strTemp=strLeaderboard[intRow][0];
					strLeaderboard[intRow][0]=strLeaderboard[intRow+1][0];
					strLeaderboard[intRow+1][0]=strTemp;
				}
			}
		}
		
	}
	
	public static void printLeaderboard(Console con, String[][] strArray) {
		con.println("CONNECT 4 LEADERBOARD");
		con.println("________________________");
		con.println(" Player\t     | Wins\t|");
		for (int intRow = 0; intRow < strArray.length; intRow++) {
			con.println(
			" "+
			(strArray[intRow][0]+"               ").substring(0, 10)
			+"  |   "+
			(strArray[intRow][1]+"      ").substring(0, 7)
			+"|");
		}
	}
	
	public static void saveToFile(Console con) {
		TextOutputFile txtUpdate = new TextOutputFile("kadenleaderboard.txt", false);
		
		for (int intRow = 0; intRow < strLeaderboard.length; intRow++) {
			txtUpdate.println(strLeaderboard[intRow][0]);
			txtUpdate.println(strLeaderboard[intRow][1]);
		}
		
		txtUpdate.close();
		
	}
	
}
	


