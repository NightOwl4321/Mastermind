import java.awt.Color;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class HiddenAnswer extends JPanel {

	JButton a1 = new JButton();
	JButton a2 = new JButton();
	JButton a3 = new JButton();
	JButton a4 = new JButton();
	Checker check;

	public HiddenAnswer() {
		// put the not visible till end buttons in place and put the border
		// around the JFrame
		int x = 50;
		int y = 25;
		check = Main.getChecker();

		Border b = BorderFactory.createLineBorder(Color.darkGray);
		this.setBorder(b);
		a1.setVisible(false);
		a2.setVisible(false);
		a3.setVisible(false);
		a4.setVisible(false);

		a1.setSize(50, 30);
		a2.setSize(50, 30);
		a3.setSize(50, 30);
		a4.setSize(50, 30);

		a1.setLocation(x + 0, y);
		a2.setLocation(x + 50, y);
		a3.setLocation(x + 100, y);
		a4.setLocation(x + 150, y);

		a1.setOpaque(true);
		a2.setOpaque(true);
		a3.setOpaque(true);
		a4.setOpaque(true);

		a1.setBackground(check.getC1());
		a2.setBackground(check.getC2());
		a3.setBackground(check.getC3());
		a4.setBackground(check.getC4());

		this.add(a1);
		this.add(a2);
		this.add(a3);
		this.add(a4);

		this.setSize(301, 101);
		this.setLayout(null);
	}

	// If you win show the answer
	void win() {
		a1.setVisible(true);
		a2.setVisible(true);
		a3.setVisible(true);
		a4.setVisible(true);
	}

}
