import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

//This is the template for all rows

public class Row extends JPanel implements ActionListener {
	// Make buttons
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	JButton b4 = new JButton();

	int bg1;
	int bg2;
	int bg3;
	int bg4;

	int c1;
	int c2;
	int c3;
	int c4;

	public Row(int x, int y) {
		// put the buttons in place based on the x and y of the row
		// TODO Auto-generated method stub
		b1.setSize(50, 30);
		b2.setSize(50, 30);
		b3.setSize(50, 30);
		b4.setSize(50, 30);

		b1.enable(false);
		b1.setLocation(x, y);
		b2.setLocation(x + 50, y);
		b3.setLocation(x + 100, y);
		b4.setLocation(x + 150, y);

		b1.setOpaque(true);
		b2.setOpaque(true);
		b3.setOpaque(true);
		b4.setOpaque(true);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);

		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);

		this.setSize(200, 30);
		this.setLayout(null);
	}

	// Givers so you can figure out what the color of a button is
	Color giveB1() {
		return b1.getBackground();
	}

	Color giveB2() {
		return b2.getBackground();
	}

	Color giveB3() {
		return b3.getBackground();
	}

	Color giveB4() {
		return b4.getBackground();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// If the color selectors are selected and a row button is pressed, set
		// it the selected color
		if (arg0.getSource() == b1) {
			b1.setBackground(Main.getCurrentChoice());
		} else if (arg0.getSource() == b2) {
			b2.setBackground(Main.getCurrentChoice());
		} else if (arg0.getSource() == b3) {
			b3.setBackground(Main.getCurrentChoice());
		} else if (arg0.getSource() == b4) {
			b4.setBackground(Main.getCurrentChoice());
		}
	}

}
