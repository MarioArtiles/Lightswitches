package lightSwitches;

import javax.swing.JOptionPane;
import lightSwitches.Msg;

//runs the program with user interface(joptionpane)
public class main {
	private static boolean[][] lights;
	private static String s = JOptionPane.showInputDialog("How long will your rows be (from 1 to 20)?");
	public static int row = Integer.parseInt(s);
	private static String sa =	JOptionPane.showInputDialog("How long will your columns be (from 1 to 20)?");
	public static int col = Integer.parseInt(s);
	public static void main(String[] args0) {
		if(row <= 20 && row >= 1 && col <= 20 && col >= 1) {
			randomizer();
			searchType();
		}
	}
	
	// takes user input and determines what method to execute based on the input
	public static void searchType() {
		String[] options = {"manipulate single light", "out of order", "manipulate row or col", "manipulate all", "New lightboard", "exit"};
		boolean loop = true;
		int opt = 0;
		String talk1 = "";
		String talk2 = "";
		while(loop) {
			JOptionPane.showMessageDialog(null,"", "executing command", JOptionPane.INFORMATION_MESSAGE);
			opt = Msg.opt(options, drawMap() + "on = lit " + "    off = not lit", "lights are setup");
			if (opt == 0) {
				talk1 = JOptionPane.showInputDialog("on or off");
				if(talk1.equals("on")) {
					singleLight(Integer.parseInt(JOptionPane.showInputDialog("Row Selected")),Integer.parseInt(JOptionPane.showInputDialog("Col selected")), true);
				}
				else if(talk1.equals("off")) {
					singleLight(Integer.parseInt(JOptionPane.showInputDialog("Row Selected")),Integer.parseInt(JOptionPane.showInputDialog("Col selected")), false);
				}
			}
			else if(opt == 1) {}
			else if(opt == 4) {
				randomizer();
			}
			else if(opt == 3) {
				talk1 = JOptionPane.showInputDialog("on or off");
				if(talk1.equals("on")) {
					turnAllOn();
				}
				else if(talk1.equals("off")) {
					turnAllOff();
				}
			}
			else if (opt == 2) {
				talk1 = JOptionPane.showInputDialog("row or col");
				talk2 = JOptionPane.showInputDialog("on or off");
				if(talk1.equals("row")) {
					if(talk2.equals("on")) {
						allRow(Integer.parseInt(JOptionPane.showInputDialog("What row will you light up")), true);
					}
					else if(talk2.equals("off")) {
						allRow(Integer.parseInt(JOptionPane.showInputDialog("What row will you shut off")), false);
					}
				}
				else if(talk1.equals("col")) {
					if(talk2.equals("on")) {
						allCol(Integer.parseInt(JOptionPane.showInputDialog("What column will you light up")), true);
					}
					else if(talk2.equals("off")) {
						allCol(Integer.parseInt(JOptionPane.showInputDialog("What column will you shut off")), false);
					}
				}
			}
			else{
				Msg.msg("You have exited the program.");
				loop = false;}
		}
		
	}
	
	// uses array of lights to display on lights as "ON" and off lights as "OFF"
	private static String drawMap() {
		String map = "";
		for(int r = 0; r < lights.length; r++) {
			for(int c = 0; c < lights[0].length; c++) {
				if(lights[r][c]) {
					map+= " ON";
					map+= "  ";
				}
				else if(!lights[r][c]) {
					map+= "OFF";
					map+= "  ";
				}
			}
			map += "\n";
		}
		return map;
	}
	
	// sets value of lights. a light has a 40 percent chance to be true(on)
	public static void randomizer() {
		 lights = new boolean[row][col];
		 for (int r = 0; r < row; r++){
			 for (int c = 0; c < col; c++){
				 double rnd = Math.random();
				 lights[r][c] = rnd < 0.4;
			 }
		 }
	}
	
	// turns a single light of the users choice on
	public static void singleLight(int r, int c, boolean v) {
		if(v) {
			lights[r][c] = true;
		}
		else if(!v) {
			lights[r][c] = false;
		}
	}
	
	// turns all lights off
	public static void turnAllOff() {
		for(int i = 0; i < lights.length; i++){
			  for(int j = 0; j < lights[0].length; j++){
			    lights[i][j] = false;
			  }
		}
	}
	
	// turns all lights on
	public static void turnAllOn() {
		for(int i = 0; i < lights.length; i++){
			  for(int j = 0; j < lights[0].length; j++){
			    lights[i][j] = true;
			  }
		}
	}
	
	// manipulates(on or off) all lights in a row
	public static void allRow(int r, boolean c) {
		if(c) {
			for(int i = 0; i < lights.length; i++) {
				lights[r][i] = true;
			}
		}
		else if(!c) {
			for(int i = 0; i < lights.length; i++) {
				lights[r][i] = false;
			}
		}
	}

	// manipulates(on or off) all lights in a column
	public static void allCol(int c, boolean e) {
		if(e) {
			for(int i = 0; i < lights[0].length; i++) {
				lights[i][c] = true;
			}
		}
		else if(!e) {
			for(int i = 0; i < lights[0].length; i++) {
				lights[i][c] = false;
			}
		}
	}
	
	// manipulates(on or off) all lights in an area chosen by user
	public void grid(int r1, int r2, int c1, int c2, boolean h) {
		if(h) {
			for(int i = r1; i < lights[r2].length; i++) {
			}
		}
	}
}
