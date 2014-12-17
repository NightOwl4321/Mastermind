import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class EasyButton implements ActionListener{
	JFrame frame = new JFrame("Easy Button");
	JPanel panel = new JPanel();
	JButton easy = new JButton("easy");
	public static void main(String[] args) {
		EasyButton e = new EasyButton();
		e.doStuff();
	}

	private void doStuff() {

		easy.setOpaque(true);
		easy.setBackground(Color.RED);
		//easy.setDefaultCapable(false);
		easy.addActionListener(this);
		panel.add(easy);
		frame.add(panel);
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Runtime.getRuntime();
		System.out.println("im clicked");
		
	}
}
