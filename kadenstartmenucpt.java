import arc.*;
import java.awt.*;
import java.awt.image.*;

public class kadenstartmenucpt {
	
	//method to create the main/start menu.
	public static void startMenu(Console con) {
		
		char chrOptionSelect = ' ';
		
		con.println("Welcome to Connect Four!");
		con.sleep(200);
		con.println("Loading game...");
		con.sleep(100);
		painting(con);
		//closeWindow method allows us to close just the painting but not the entire program
		/*because once a painting cannot be edited on or altered, we have to open a new Console
		  for user's option selection */
		con.closeWindow(); 
		con = new Console();
		con.println("Select an option (type the key that corresponds): ");
		con.println("(p)lay, (l)eaderboards, (h)elp, (q)uit");
		System.out.println("Note to Mr. Cardona for marking: You can type 's' to access the secret menu extra feature");
		chrOptionSelect = con.readChar();	
		
		if (chrOptionSelect == 'h') {
			con.println("Going to the help menu...");
			con.sleep(500);
			con.clear();
			kadenCPTMenus.helpMenu(con); //go to the help menu in CPTMenus class
		} else if (chrOptionSelect == 'q') {
			con.println("Quitting the game...");
			con.sleep(500);
			System.exit(0); //terminate the entire system/program 
		} else if (chrOptionSelect ==  'p') {
			con.println("Get ready to play some Connect 4!");
			con.sleep(700);
			con.clear();
			kadenCPTdraft.game(con); //go to the game in CPTdraft class
		} else if (chrOptionSelect == 's') {
			con.println("Well, well, well. I see you've found a secret...");
			con.sleep(500);
			con.clear();
			kadenCPTMenus.secretMenu(con); //go to the secret menu in CPTMenus class
		} else {
			con.println("Please select a valid option: ");
			chrOptionSelect = con.readChar(); //ask for user input again
		}              
	}
	
	public static void painting(Console con) {
		int intCount = 150;
		BufferedImage imgPainting;
		imgPainting = con.loadImage("connect4test2.png");
		
		
		while(intCount < 300){
			//draw things
			con.drawImage(imgPainting, 100, 100); //original 100, 100??
			//(MAX960,MAX540)<--bottom right
			//(0,0)<--Top left
			//(variable,x,y) is the format
			
			//Draw the yellow checker and animate it			
			con.setDrawColor(Color.YELLOW);
			con.fillOval(100,400-intCount,100,100);
			
			//Draw the red checker and animate it
			con.setDrawColor(new Color(200,20,60)); //color scheme is rgb
			con.fillOval(800,100+intCount,100,100);
			//(x,y,length,width)
			con.setDrawColor(new Color(200,100,30));
			
			con.repaint();
			//Show the stuff on screen for a little while
			con.sleep(100);
			//'Erase' the screen using black rectangle
			con.setDrawColor(Color.BLACK);
			con.fillRect(0,0,960,540);
			intCount++;
		} 	
		
	}
	
	
}

