/* University of Central Florida
*  COP 3330 Spring 2019
*  Final project
*  Author: Harry Sauers
*/
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class MathScreen implements Screen {

	private JFrame frame;
	private JTextField textField;
	
	private int problemCounter = 1;
	private int problemTotal;
	private int numberOfDigits;
	private String operatorStr;
	
	private int answerKey;
	private int score;
	
	JLabel label;
	JLabel label_1;
	JLabel label_2;
	JLabel lblProblemXOf;

	/**
	 * Create the application.
	 */
	public MathScreen(String name, int numProblems, int numDigits, String operator) {
		initialize(name, numProblems, numDigits, operator);
	}

	private void initialize(String name, int numProblems, int numDigits, String operator) {
		// hold these for future use
		problemTotal = numProblems;
		numberOfDigits = numDigits;
		operatorStr = operator;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String opName = "";
		if (operator.equals("+")) {
			opName = "Addition";
		} else if (operator.equals("-")) {
			opName = "Subtraction";
		} else if (operator.equals("*")) {
			opName = "Multiplication";
		} else if (operator.equals("/")) {
			opName = "Division";
		}
		
		JLabel lblHelper = new JLabel("***" + opName + " Helper***");
		lblHelper.setBounds(0, 0, 434, 29);
		lblHelper.setForeground(Color.BLUE);
		lblHelper.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 24));
		frame.getContentPane().add(lblHelper);
		
		lblProblemXOf = new JLabel("Problem " + Integer.toString(problemCounter) + " of " + Integer.toString(numProblems));
		lblProblemXOf.setForeground(Color.BLUE);
		lblProblemXOf.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		lblProblemXOf.setBounds(92, 30, 218, 29);
		frame.getContentPane().add(lblProblemXOf);
		
		JLabel lblFirstNumber = new JLabel("First Number: ");
		lblFirstNumber.setForeground(SystemColor.desktop);
		lblFirstNumber.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblFirstNumber.setBounds(30, 57, 120, 29);
		frame.getContentPane().add(lblFirstNumber);
		
		JLabel lblOperator = new JLabel("Operation:");
		lblOperator.setForeground(Color.BLACK);
		lblOperator.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblOperator.setBounds(30, 84, 120, 29);
		frame.getContentPane().add(lblOperator);
		
		JLabel lblSecondNumber = new JLabel("Second Number: ");
		lblSecondNumber.setForeground(Color.BLACK);
		lblSecondNumber.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblSecondNumber.setBounds(30, 111, 137, 29);
		frame.getContentPane().add(lblSecondNumber);
		
		JLabel lblEnterResult = new JLabel("Enter Result: ");
		lblEnterResult.setForeground(Color.BLACK);
		lblEnterResult.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblEnterResult.setBounds(59, 151, 120, 29);
		frame.getContentPane().add(lblEnterResult);
		
		JLabel lblPress = new JLabel("Press Next:");
		lblPress.setForeground(Color.BLACK);
		lblPress.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblPress.setBounds(79, 184, 120, 29);
		frame.getContentPane().add(lblPress);
		
		// operand 1
		label = new JLabel("XXX.XX");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		label.setBounds(260, 57, 66, 29);
		frame.getContentPane().add(label);
		
		// operation
		label_1 = new JLabel("XXX.XX");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		label_1.setBounds(266, 84, 44, 29);
		frame.getContentPane().add(label_1);
		
		// operand 2
		label_2 = new JLabel("XXX.XX");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		label_2.setBounds(260, 111, 66, 29);
		frame.getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(198, 158, 86, 20);
		frame.getContentPane().add(textField);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				submit();
			}
		});
		btnNext.setBounds(195, 190, 89, 23);
		frame.getContentPane().add(btnNext);
		
		populate(numDigits, operator);
	}
	
	private int rand1;
	private int rand2;
	
	// populate data
	public void populate(int numDigits, String operation) {
		
		// update heading
		lblProblemXOf.setText("Problem " + Integer.toString(problemCounter) + " of " + Integer.toString(problemTotal));
		
		// generate two random numbers per numDigits
		int maxNum = (int) (Math.pow(10, numDigits));
		rand1 = (int) (Math.random()*maxNum);
		rand2 = (int) (Math.random()*maxNum);
		
		/*
		System.out.print(maxNum);
		System.out.println();
		System.out.print(rand1);
		System.out.print(" ");
		System.out.print(rand2);
		System.out.println();
		*/
		
		// put them in corresponding number fields
		label.setText(String.valueOf(rand1));
		label_2.setText(String.valueOf(rand2));

		// add operator
		label_1.setText(operation);
		
		// assign result to global result
		switch(operation) {
			case "+":
				answerKey = rand1 + rand2;
				break;
			case "-":
				answerKey = rand1 - rand2;
				break;
			case "*":
				answerKey = rand1 * rand2;
				break;
			case "/":
				// no division by zero
				if (rand2 == 0)
					rand2 = 1;
				answerKey = rand1 / rand2;
				break;				
		}
		
		// set answer box to nothing
		textField.setText("");
		
		// System.out.println(answerKey);
	}
	
	// onsubmit
	public void submit() {
		// increment problem counter
		problemCounter++;
		
		// fetch answer
		int myAnswer = Integer.valueOf(textField.getText());
		if (myAnswer == answerKey) {
			score ++;
			// System.out.println("Answer is correct!");
		} else {
		}
		
		// append to history
		ArithmeticHelper.addProblem(rand1, rand2, myAnswer, answerKey);
		
		// are there any more problems? if so, reset the screen by calling initialize() or populate()
		if (problemCounter <= problemTotal) {
			// setVisibility(false);
			// initialize();
			populate(numberOfDigits, operatorStr);
			// frame.getContentPane().revalidate();
			// frame.getContentPane().repaint();
			// setVisibility(true);
		} else {
			// go to next screen 
			next();
		}
	}
	
	// go to next screen - show result
	public void next() {
		ArithmeticHelper.showResultScreen(score, problemTotal);
	}
	
	/**
	 * Sets visibility of Screen.
	 * @param isVisible
	 */
	public void setVisibility(Boolean isVisible) {
		this.frame.setVisible(isVisible);
	}

}
