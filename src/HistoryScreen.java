/* University of Central Florida
*  COP 3330 Spring 2019
*  Final project
*  Author: Harry Sauers
*/
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HistoryScreen implements Screen {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public HistoryScreen(ArrayList<ArrayList<Integer>> problems) {
		initialize(problems);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<ArrayList<Integer>> problems) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblYourHistory = new JLabel("Your History");
		lblYourHistory.setForeground(Color.BLUE);
		lblYourHistory.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblYourHistory.setBounds(138, 0, 143, 34);
		frame.getContentPane().add(lblYourHistory);
		
		JLabel lblNumber = new JLabel("Number 1:");
		lblNumber.setForeground(Color.BLUE);
		lblNumber.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblNumber.setBounds(10, 40, 93, 29);
		frame.getContentPane().add(lblNumber);
		
		JLabel lblNumber_1 = new JLabel("Number 2:");
		lblNumber_1.setForeground(Color.BLUE);
		lblNumber_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblNumber_1.setBounds(113, 40, 93, 29);
		frame.getContentPane().add(lblNumber_1);
		
		JLabel lblNumber_2 = new JLabel("Real Result:");
		lblNumber_2.setForeground(Color.BLUE);
		lblNumber_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblNumber_2.setBounds(216, 40, 100, 29);
		frame.getContentPane().add(lblNumber_2);
		
		JLabel lblYourResult = new JLabel("Your Result:");
		lblYourResult.setForeground(Color.BLUE);
		lblYourResult.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblYourResult.setBounds(325, 40, 109, 29);
		frame.getContentPane().add(lblYourResult);
		
		int[] bounds1 = {10, 80, 93, 29};
		int[] bounds2 = {113, 80, 93, 29};
		int[] bounds3 = {216, 80, 100, 29};
		int[] bounds4 = {325, 80, 109, 29};
		
		for (ArrayList<Integer> problem : problems) {
			JLabel lblStart = new JLabel(Integer.toString(problem.get(0)));
			lblStart.setForeground(Color.BLACK);
			lblStart.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			lblStart.setBounds(bounds1[0], bounds1[1], bounds1[2], bounds1[3]); //		2nd Value -> +20 from last
			frame.getContentPane().add(lblStart);
			
			JLabel lblStart_1 = new JLabel(Integer.toString(problem.get(1)));
			lblStart_1.setForeground(Color.BLACK);
			lblStart_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			lblStart_1.setBounds(bounds2[0], bounds2[1], bounds2[2], bounds2[3]);
			frame.getContentPane().add(lblStart_1);
			
			JLabel lblStart_2 = new JLabel(Integer.toString(problem.get(2)));
			lblStart_2.setForeground(Color.BLACK);
			lblStart_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			lblStart_2.setBounds(bounds3[0], bounds3[1], bounds3[2], bounds3[3]);
			frame.getContentPane().add(lblStart_2);
			
			JLabel lblStart_3 = new JLabel(Integer.toString(problem.get(3)));
			lblStart_3.setForeground(Color.BLACK);
			lblStart_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			lblStart_3.setBounds(bounds4[0], bounds4[1], bounds4[2], bounds4[3]);
			frame.getContentPane().add(lblStart_3);
			
			// move down by one Y axis
			bounds1[1]+=20;
			bounds2[1]+=20;
			bounds3[1]+=20;
			bounds4[1]+=20;
		}
		
		JButton btnNewButton = new JButton("Rank List");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// show rank list
				showRanks();
			}
		});
		btnNewButton.setBounds(232, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// exit program
				System.exit(0);
			}
		});
		btnFinish.setBounds(331, 227, 89, 23);
		frame.getContentPane().add(btnFinish);
	}
	
	public void showRanks() {
		ArithmeticHelper.showRanksList();
	}

	/**
	 * Sets visibility of Screen.
	 * @param isVisible
	 */
	public void setVisibility(Boolean isVisible) {
		this.frame.setVisible(isVisible);
	}

}
