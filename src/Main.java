import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main implements ActionListener {
	public int guesses = 0;
	public int points = 0;
	static public boolean end = false;
	JButton enter = new JButton("Enter");
	// Create the rows (lines of four buttons)
	Row Current;
	Row row1 = new Row(0, 0);
	Row row2 = new Row(0, 0);
	Row row3 = new Row(0, 0);
	Row row4 = new Row(0, 0);
	Row row5 = new Row(0, 0);
	Row row6 = new Row(0, 0);
	// Creating other classes
	static Checker check = new Checker();
	HiddenAnswer hide = new HiddenAnswer();

	static Color currentChoice = null;

	public static void main(String[] args) {
		Main m = new Main();
		m.makeButtons();
	}

	private void makeButtons() {
		// Putting the objects in their places
		JFrame frame = new JFrame();
		JFrame ansFrame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		JLabel ansLabel = new JLabel();
		JLabel ansLabel2 = new JLabel();
		ColorChooser choice = new ColorChooser();
		
		
		ansFrame.setAlwaysOnTop(true);
		ansFrame.setLocation(350, 0);
		ansFrame.setLayout(new BorderLayout());
		Font normal = new Font("Sans-Serif", Font.PLAIN, 15);
		Font header = new Font("Sans-Serif", Font.BOLD, 24);
		ansLabel.setFont(header);
		ansLabel.setText("Instructions:");
		ansLabel2.setFont(normal);
		ansLabel2.setText("<html>This is a logic game<br/><br/>"
				+ "The objective is to deduce the pattern of colors<br/><br/>"
				+ "Select a color by clicking one of the colored buttons at the bottom<br/><br/>"
				+ "Then click on one of the buttons in the row closest to the base of the page<br/><br/>"
				+ "It will turn the color you selected *There are no blanks in the solution*<br/><br/>"
				+ "*There can be more than one of each color in the solution*<br/><br/>"
				+ "Once you have each button colored, click the enter button <br/><br/>"
				+ "It will tell you from left to right, whether your guess is correct<br/><br/>"
				+ "Repeat the color selecting process in the next row up<br/><br/>"
				+ "You can solve this in five tries or less. If it takes you more than six, or if you solve it, the game is over<br/><br/>"
				+ "Thanks for playing"
				+ "</html>");
		ansFrame.add(ansLabel, BorderLayout.NORTH);
		ansFrame.add(ansLabel2, BorderLayout.CENTER);
		ansFrame.setVisible(true);
		ansFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ansFrame.setSize(300, 600);
		
		
		
		label.setText("Mastermind");

		panel.setLayout(null);
		// Add the classes
		panel.add(row1);
		panel.add(row2);
		panel.add(row3);
		panel.add(row4);
		panel.add(row5);
		panel.add(row6);
		panel.add(choice);
		panel.add(hide);
		row1.setLocation(0, 395);
		row2.setLocation(0, 345);
		row3.setLocation(0, 295);
		row4.setLocation(0, 245);
		row5.setLocation(0, 195);
		row6.setLocation(0, 145);
		choice.setLocation(0, 440);
		hide.setLocation(0, 0);
		// Enter is the enter button
		enter.setSize(50, 20);
		enter.setLocation(220, 400);
		enter.addActionListener(this);
		panel.add(enter);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(label);
		frame.add(panel);
		frame.setSize(301, 500);
		// I have no idea why this is here, but it works
		panel.validate();
		panel.repaint();
	}

	// Pass variables from class to class with givers and getters
	static Checker getChecker() {
		return check;
	}

	public static Color getCurrentChoice() {
		return currentChoice;
	}

	public static void setCurrentChoice(Color newColor) {
		currentChoice = newColor;
	}

	public static void setCurrentChoice(boolean endNow) {
		end = endNow;
	}

	public static boolean getB1() {
		return end;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Set which row is the current row by seeing how many guesses have been
		// taken
		if (arg0.getSource() == enter) {
			switch (guesses) {
			case 0:
				Current = row1;
				break;
			case 1:
				Current = row2;
				break;
			case 2:
				Current = row3;
				break;
			case 3:
				Current = row4;
				break;
			case 4:
				Current = row5;
				break;
			case 5:
				Current = row6;
				break;
			}
			guesses++;
			// Set location of enter button based on guesses (for which row you
			// are on)
			enter.setLocation(220, 400 - guesses * 50);
			// If the current row is equal to the answer
			if (check.compare(Current)) {
				// you win
				JOptionPane.showMessageDialog(null, "You win. It took you "
						+ guesses + " guesses");
				end = true;
				// show answer
				hide.win();

			} else {
				// else you lose
				if (guesses >= 6) {
					end = true;
					JOptionPane
							.showMessageDialog(
									null,
									"You suck at this game. If you use logic, it will take you at most five guesses");
					// Show answer
					hide.win();
				} else {
					JOptionPane.showMessageDialog(null, "Your answer for the first box in the row is:   "+ check.isG1() + "\n" 
				+ "Your answer for the second box in the row is:   "+ check.isG2() + "\n" + 
							"Your answer for the third box in the row is:   "+ check.isG3() + 
							"\n" + "Your answer for the fourth box in the row is:   "+ check.isG4()  );
				}
			}

		}
	}
}
