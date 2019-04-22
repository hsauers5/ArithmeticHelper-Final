/* University of Central Florida
*  COP 3330 Spring 2019
*  Final project
*  Author: Harry Sauers
*/
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AboutScreen implements Screen {

	private JFrame frame;
	private JPanel contentPane;
	private JButton btnReturn;
	
	public void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		JLabel lblAboutHarrySauers = new JLabel("About Harry Sauers");
		lblAboutHarrySauers.setForeground(Color.BLUE);
		lblAboutHarrySauers.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 24));
		frame.getContentPane().add(lblAboutHarrySauers, BorderLayout.NORTH);
		
		JTextPane txtpnWelcomeMyName = new JTextPane();
		txtpnWelcomeMyName.setBackground(SystemColor.control);
		txtpnWelcomeMyName.setEditable(false);
		txtpnWelcomeMyName.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		txtpnWelcomeMyName.setText("Welcome! My name is Harry Sauers, and I\u2019m a student, writer, and software developer. I\u2019ve worked on several major projects in e-commerce, finance, and disruptive technologies, and interned for two years at the St. Pete Chamber of Commerce. I now intern with Raymond James Financial in InfraSec and study computer science at UCF in Orlando. I hope to graduate early and pursue an MBA in Finance. My personal interests include literature, writing, playing jazz trumpet, fishing, and kayaking around the Tampa Bay area. I write on investments, current events, technology, and market commentary for SeekingAlpha and Medium.\r\n\r\n\twww.hsauers.net  |  harry@hsauers.net");
		frame.getContentPane().add(txtpnWelcomeMyName, BorderLayout.CENTER);
		
		btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainScreen();
			}
		});
		contentPane.add(btnReturn, BorderLayout.SOUTH);
	}

	/**
	 * Create the frame.
	 */
	public AboutScreen() {
		initialize();
	}

	@Override
	public void setVisibility(Boolean isVisible) {
		this.frame.setVisible(isVisible);		
	}
	
	public void mainScreen() {
		ArithmeticHelper.switchToScreen(ArithmeticHelper.mainScreen);
	}

}
