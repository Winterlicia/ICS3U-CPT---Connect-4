import arc.*;

public class kadenCPTMenus {
	
	public static String strAnyKey;
	
	public static void helpMenu(Console con) {
		int intCount;
		
		//Below depicts exactly what was shown in the UI Document for the Help Menu.
		
		con.clear();
		con.println("Connect Four is a two-player game where players strategically compete with each");
		con.println("other to connect 4 of their checkers in a row.");
		con.sleep(5000); 
		
		con.clear();
		con.println("When it is your turn, you have to drop a checker in one of the columns.");
		con.println("The game will ask for your input from 0 to 6, and it will drop your checker into");
		con.println("the column.");
		con.println();
		con.println("If you picked to drop your checker in Column 3, it will look like this:");
		con.println("  0 1 2 3 4 5 6");
		for (intCount = 1; intCount <= 5; intCount++) {
			con.println(" | | | | | | | |");
			con.println("-+-+-+-+-+-+-+-+-");
		}
		con.println(" | | | |O| | | |");
		con.println("-+-+-+-+-+-+-+-+-");
		con.sleep(10000); 
		con.clear();
		
		con.println("In Connect 4, your checkers stack on top of each other.");
		con.println("Knowing which place to stack your checkers is crucial to winning.");
		con.println();
		con.println("It is important to make correct placements to prevent your opponent");
		con.println("from connecting 4 in a row.");
		for (intCount = 1; intCount <= 3; intCount++) {
			con.println(" | | | | | | | |");
			con.println("-+-+-+-+-+-+-+-+-");
		}
		con.println(" | | |O|O| | | |");
		con.println("-+-+-+-+-+-+-+-+-");
		con.println(" | | |X|X| | | |");
		con.println("-+-+-+-+-+-+-+-+-");
		con.println(" | |X|O|O|O|X| |");
		con.println("-+-+-+-+-+-+-+-+-");
		con.sleep(10000);
		
		con.clear();
		con.println("You win by connecting four in a row.");
		con.println("This may be in the form of a horizontal 4, vertical 4, an ascending diagonal 4,");
		con.println("or a descending diagonal 4.");
		con.sleep(4000);
		
		//Showcasing examples of ways to win:
		con.clear();
		con.println("1) Horizontal Win");
		for (intCount = 1; intCount <= 5; intCount++) {
			con.println(" | | | | | | | |");
			con.println("-+-+-+-+-+-+-+-+-");
		}
		con.println(" | |O|O|O|O| | |");
		con.println("-+-+-+-+-+-+-+-+-");
		con.sleep(3000);
		
		con.clear();
		con.println("2) Vertical Win");
		for (intCount = 1; intCount <= 2; intCount++) {
			con.println(" | | | | | | | |");
			con.println("-+-+-+-+-+-+-+-+-");
		}
		for (intCount = 1; intCount <= 4; intCount++) {
			con.println(" | | | |O| | | |");
			con.println("-+-+-+-+-+-+-+-+-");
		}
		con.sleep(3000);
		
		con.clear();
		con.println("3) Ascending Diagonal Win");
		for (intCount = 1; intCount <= 2; intCount++) {
			con.println(" | | | | | | | |");
			con.println("-+-+-+-+-+-+-+-+-");
		}
		con.println(" | | | | | | |O|");
		con.println("-+-+-+-+-+-+-+-+-");
		con.println(" | | | | | |O| |");
		con.println("-+-+-+-+-+-+-+-+-");
		con.println(" | | | | |O| | |");
		con.println("-+-+-+-+-+-+-+-+-");
		con.println(" | | | |O| | | |");
		con.println("-+-+-+-+-+-+-+-+-");
		con.sleep(3000);
		
		con.clear();
		con.println("4) Descending Diagonal Win");
		for (intCount = 1; intCount <= 2; intCount++) {
			con.println(" | | | | | | | |");
			con.println("-+-+-+-+-+-+-+-+-");
		}
		con.println(" |O| | | | | | |");
		con.println("-+-+-+-+-+-+-+-+-");
		con.println(" | |O| | | | | |");
		con.println("-+-+-+-+-+-+-+-+-");
		con.println(" | | |O| | | | |");
		con.println("-+-+-+-+-+-+-+-+-");
		con.println(" | | | |O| | | |");
		con.println("-+-+-+-+-+-+-+-+-");
		con.sleep(3000);
		
		con.clear();
		con.println("That’s pretty much it!");
		con.println("The trick to Connect 4 is learning how to adapt to your opponent’s strategies each time");
		con.println("in order to emerge victorious, defending by blocking their paths to connect 4 in a row");
		con.println("and attacking to connect 4 in a row simultaneously.");
		con.println("Good luck!");
		con.println();
		con.println("Press any key to go back to the main menu.");
		strAnyKey = con.readLine();
		
		if (!strAnyKey.isEmpty()) {
			con.clear();
			startmenucpt.startMenu(con);
		}
		
	}
	
	public static void secretMenu(Console con) {
		//Printing the secret joke and the hint about the "strongertogether cheat code.
		//Depicts what was shown on the UI Document
		con.println("The police arrested two kids yesterday.");
		con.println("One was drinking battery acid, the other was eating fireworks.");
		con.println("They charged one – and let the other one off.");
		con.sleep(500);
		con.println("...");
		con.sleep(700);
		con.println(".....");
		con.sleep(900);
		con.println("..........");
		con.sleep(200);
		con.println("HEHEHEHEHHEHEHEHA FUNNY JOKE THE CREATOR OF THIS GAME IS SO FUNNY");
		con.sleep(500);
		con.println("anyway...");
		con.sleep(200);
		con.println("I wonder what would happen if player 2’s name was ‘strongertogether’...?");
		con.println("Press any key to go back to the main menu.");
		strAnyKey = con.readLine();
		
		if (!strAnyKey.isEmpty()) {
			con.clear();
			startmenucpt.startMenu(con);
		}
	}	
}
