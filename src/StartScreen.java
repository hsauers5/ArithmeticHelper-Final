/* University of Central Florida
*  COP 3330 Spring 2019
*  Final project
*  Author: Harry Sauers
*/
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartScreen implements Screen {

	private JFrame frame;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public StartScreen(String operation, String name, String numProbs, String numDigits) {
		initialize(operation, name, numProbs, numDigits);
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	public void initialize(String name, String numProbs, String numDigits, String operation) {
		
		this.frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String operator = "";
		
		if (operation.equals("+")) {
			operator = "Addition";
		} else if (operation.equals("-")) {
			operator = "Subtraction";
		} else if (operation.equals("*")) {
			operator = "Multiplication";
		} else if (operation.equals("/")) {
			operator = "Division";
		}
		
		JLabel lblArithmeticHelper = new JLabel("Welcome to " + operator + " Helper");
		
		lblArithmeticHelper.setForeground(Color.BLUE);
		lblArithmeticHelper.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 24));
		lblArithmeticHelper.setBounds(10, 0, 414, 34);
		contentPane.add(lblArithmeticHelper);
		
		JLabel lblEnterNumberOf = new JLabel("Your Name: ");
		lblEnterNumberOf.setForeground(Color.BLUE);
		lblEnterNumberOf.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblEnterNumberOf.setBounds(60, 45, 136, 25);
		contentPane.add(lblEnterNumberOf);
		
		JButton btnSubmit = new JButton("Start");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				start();
			}
		});
		btnSubmit.setBounds(216, 141, 89, 23);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		contentPane.add(btnSubmit);
		
		JLabel lblNumberOfProblems = new JLabel("Number of Problems:");
		lblNumberOfProblems.setForeground(Color.BLUE);
		lblNumberOfProblems.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblNumberOfProblems.setBounds(60, 69, 136, 25);
		contentPane.add(lblNumberOfProblems);
		
		JLabel lblNumberOfDigits = new JLabel("Number of Digits:");
		lblNumberOfDigits.setForeground(Color.BLUE);
		lblNumberOfDigits.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblNumberOfDigits.setBounds(60, 104, 136, 25);
		contentPane.add(lblNumberOfDigits);
		
		JLabel lblPressStart = new JLabel("Press Start to start quiz: ");
		lblPressStart.setForeground(Color.BLUE);
		lblPressStart.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblPressStart.setBounds(60, 140, 136, 25);
		contentPane.add(lblPressStart);
		
		JLabel lblPlaceholder = new JLabel(name);
		lblPlaceholder.setForeground(Color.BLUE);
		lblPlaceholder.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblPlaceholder.setBounds(206, 45, 136, 25);
		contentPane.add(lblPlaceholder);
		
		JLabel lblPlaceholder_1 = new JLabel(numProbs);
		lblPlaceholder_1.setForeground(Color.BLUE);
		lblPlaceholder_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblPlaceholder_1.setBounds(207, 69, 136, 25);
		contentPane.add(lblPlaceholder_1);
		
		JLabel lblPlaceholder_2 = new JLabel(numDigits);
		lblPlaceholder_2.setForeground(Color.BLUE);
		lblPlaceholder_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblPlaceholder_2.setBounds(206, 104, 136, 25);
		contentPane.add(lblPlaceholder_2);
	}
	
	public void start() {
		// do stuff
		ArithmeticHelper.switchToScreen(ArithmeticHelper.mathScreen);
	}

	/**
	 * Sets visibility of Screen.
	 * @param isVisible
	 */
	public void setVisibility(Boolean isVisible) {
		this.frame.setVisible(isVisible);
	}
	
}
