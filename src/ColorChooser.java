import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

//This makes the color selector
public class ColorChooser extends JPanel implements ActionListener {
	public boolean red = false;
	public boolean yellow = false;
	public boolean green = false;
	public boolean blue = false;
	public boolean purple = false;

	JButton bR = new JButton();
	JButton bY = new JButton();
	JButton bG = new JButton();
	JButton bB = new JButton();
	JButton bP = new JButton();

	public ColorChooser() {
		// put buttons in place on the JPanel
		final int width = 40;
		final int height = 30;
		bR.setSize(width, height);
		bY.setSize(width, height);
		bG.setSize(width, height);
		bB.setSize(width, height);
		bP.setSize(width, height);

		bR.setLocation(0, 0);
		bY.setLocation(50, 0);
		bG.setLocation(100, 0);
		bB.setLocation(150, 0);
		bP.setLocation(200, 0);

		bR.setOpaque(true);
		bY.setOpaque(true);
		bG.setOpaque(true);
		bB.setOpaque(true);
		bP.setOpaque(true);

		bR.setBackground(Color.RED);
		bY.setBackground(Color.YELLOW);
		bG.setBackground(Color.GREEN);
		bB.setBackground(Color.BLUE);
		bP.setBackground(Color.MAGENTA);

		bR.addActionListener(this);
		bY.addActionListener(this);
		bG.addActionListener(this);
		bB.addActionListener(this);
		bP.addActionListener(this);

		this.add(bR);
		this.add(bY);
		this.add(bG);
		this.add(bB);
		this.add(bP);

		this.setSize(250, 30);
		this.setLayout(null);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// If a color was pressed, set a variable to the selected color
		if (arg0.getSource() == bR) {
			Main.setCurrentChoice(Color.RED);
		} else if (arg0.getSource() == bY) {
			Main.setCurrentChoice(Color.YELLOW);
		} else if (arg0.getSource() == bG) {
			Main.setCurrentChoice(Color.GREEN);
		} else if (arg0.getSource() == bB) {
			Main.setCurrentChoice(Color.BLUE);
		} else if (arg0.getSource() == bP) {
			Main.setCurrentChoice(Color.MAGENTA);
		}
	}
}
