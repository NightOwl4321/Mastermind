import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;

//This class is a logic class, it makes the solution and checks the answer

public class Checker {

	Color c1;
	Color c2;
	Color c3;
	Color c4;

	boolean g1;
	boolean g2;
	boolean g3;
	boolean g4;

	public int r1;
	public int r2;
	public int r3;
	public int r4;

		public Color getC1() {
		return c1;
	} public Color getC2() {
		return c2;
	} public Color getC3() {
		return c3;
	} public Color getC4() {
		return c4;
	}
	

	public boolean isG1() {
		return g1;
	}
	public boolean isG2() {
		return g2;
	}
	public boolean isG3() {
		return g3;
	}
	public boolean isG4() {
		return g4;
	}
	Checker() {
		//create random numbers
		r1 = new Random().nextInt(5);
		r2 = new Random().nextInt(5);
		r3 = new Random().nextInt(5);
		r4 = new Random().nextInt(5);

		//Map colors to the number
		if (r1 == 0) {
			c1 = Color.RED;
		} else if (r1 == 1) {
			c1 = Color.YELLOW;
		} else if (r1 == 2) {
			c1 = Color.GREEN;
		} else if (r1 == 3) {
			c1 = Color.BLUE;
		} else if (r1 == 4) {
			c1 = Color.MAGENTA;
		}

		if (r2 == 0) {
			c2 = Color.RED;
		} else if (r2 == 1) {
			c2 = Color.YELLOW;
		} else if (r2 == 2) {
			c2 = Color.GREEN;
		} else if (r2 == 3) {
			c2 = Color.BLUE;
		} else if (r2 == 4) {
			c2 = Color.MAGENTA;
		}

		if (r3 == 0) {
			c3 = Color.RED;
		} else if (r3 == 1) {
			c3 = Color.YELLOW;
		} else if (r3 == 2) {
			c3 = Color.GREEN;
		} else if (r3 == 3) {
			c3 = Color.BLUE;
		} else if (r3 == 4) {
			c3 = Color.MAGENTA;
		}

		if (r4 == 0) {
			c4 = Color.RED;
		} else if (r4 == 1) {
			c4 = Color.YELLOW;
		} else if (r4 == 2) {
			c4 = Color.GREEN;
		} else if (r4 == 3) {
			c4 = Color.BLUE;
		} else if (r4 == 4) {
			c4 = Color.MAGENTA;
		}
	}

	//This checks the answer
	boolean compare(Row row1) {
		//Sets the guess for each button to true or false based on the answer and the rows value
		//do not confuse row1 in here that is used to hold whatever row is passed in with row 1, the bottom row
		g1 = c1 == row1.giveB1() ? true : false;
		g2 = c2 == row1.giveB2() ? true : false;
		g3 = c3 == row1.giveB3() ? true : false;
		g4 = c4 == row1.giveB4() ? true : false;
		
		//If all the guesses are right, tell dumb so it can party
		if (g1 && g2 && g3 && g4) {
			return true;
		} else {
			return false;
		}

	}
}
