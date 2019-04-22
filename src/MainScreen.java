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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MainScreen implements Screen {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField nameTxt;
	private JTextField numProbTxt;
	private JTextField numDigTxt;

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		initialize();
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initialize() {
		this.frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(160, 0, 121, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblArithmeticHelper = new JLabel("Arithmetic Helper");
		lblArithmeticHelper.setForeground(Color.BLUE);
		lblArithmeticHelper.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 24));
		lblArithmeticHelper.setBounds(101, 31, 214, 34);
		contentPane.add(lblArithmeticHelper);
		
		JLabel lblEnterYourNickname = new JLabel("Enter your Nickname:");
		lblEnterYourNickname.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblEnterYourNickname.setForeground(Color.BLUE);
		lblEnterYourNickname.setBounds(60, 64, 136, 25);
		contentPane.add(lblEnterYourNickname);
		
		JLabel lblEnterTheNumber = new JLabel("Enter the number of problems:");
		lblEnterTheNumber.setForeground(Color.BLUE);
		lblEnterTheNumber.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblEnterTheNumber.setBounds(59, 89, 152, 25);
		contentPane.add(lblEnterTheNumber);
		
		JLabel lblEnterNumberOf = new JLabel("Enter number of digits:");
		lblEnterNumberOf.setForeground(Color.BLUE);
		lblEnterNumberOf.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblEnterNumberOf.setBounds(60, 115, 136, 25);
		contentPane.add(lblEnterNumberOf);
		
		JLabel lblChooseTheType = new JLabel("Choose the operation:");
		lblChooseTheType.setForeground(Color.BLUE);
		lblChooseTheType.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblChooseTheType.setBounds(60, 141, 136, 25);
		contentPane.add(lblChooseTheType);
		
		JButton btnCancel = new JButton("Close");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(10, 227, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(180, 227, 89, 23);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit();
			}
		});
		contentPane.add(btnSubmit);
		
		JButton btnHelp = new JButton("About");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				about();
			}
		});
		btnHelp.setBounds(335, 227, 89, 23);
		contentPane.add(btnHelp);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(222, 66, 121, 20);
		contentPane.add(nameTxt);
		nameTxt.setColumns(10);
		
		numProbTxt = new JTextField();
		numProbTxt.setColumns(10);
		numProbTxt.setBounds(257, 91, 86, 20);
		contentPane.add(numProbTxt);
		
		numDigTxt = new JTextField();
		numDigTxt.setColumns(10);
		numDigTxt.setBounds(257, 117, 86, 20);
		contentPane.add(numDigTxt);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("--Select--");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--Select--", "+", "-", "*", "/", "Random"}));
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setOperator(comboBox.getSelectedItem().toString());
			}
		});
		comboBox.setBounds(222, 143, 121, 20);
		contentPane.add(comboBox);
	}

	private String operator = "";
	private void setOperator(String op) {
		// TODO Auto-generated method stub
		operator = op;
	}
	
	public void submit() {
		// TODO Auto-generated method stub
		String name = nameTxt.getText().toString();
		int numProblems = Integer.valueOf(numProbTxt.getText().toString());
		int numDigits = Integer.valueOf(numDigTxt.getText().toString());
		String op = operator;
		
		if (operator == "Random") {
			// generate random operator
			int rand = (int) (Math.random()*4) +1;
			
			switch (rand) {
				case 1:
					op = "+";
					break;
				case 2:
					op = "-";
					break;
				case 3:
					op = "*";
					break;
				case 4:
					op = "/";
					break;
			}
		}
		
		// System.out.printf("%s | %d | %d | %s\n", name, numProblems, numDigits, op);
		
		ArithmeticHelper.startMath(name, numProblems, numDigits, op);
	}
	
	public void about() {
		ArithmeticHelper.switchToScreen(ArithmeticHelper.aboutScreen);
	}

	/**
	 * Sets visibility of Screen.
	 * @param isVisible
	 */
	public void setVisibility(Boolean isVisible) {
		this.frame.setVisible(isVisible);
	}
	
}
