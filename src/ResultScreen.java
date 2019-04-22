/* University of Central Florida
*  COP 3330 Spring 2019
*  Final project
*  Author: Harry Sauers
*/
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JButton;

public class ResultScreen implements Screen {

	private JFrame frame;
	private JLabel totalScore;
	private JLabel pName;
	private JLabel numProbs;
	private JLabel numCorrect;
	private JLabel timeElapsed;
	private JLabel avgTime;
	private JLabel pctCorrect;
	
	
	

	/**
	 * Create the application.
	 */
	public ResultScreen(User u) {
		initialize(u);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User u) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblarithmeticHelperResult = new JLabel("***Arithmetic Helper Result***");
		lblarithmeticHelperResult.setForeground(Color.BLUE);
		lblarithmeticHelperResult.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 24));
		lblarithmeticHelperResult.setBounds(37, 0, 350, 29);
		frame.getContentPane().add(lblarithmeticHelperResult);
		
		JLabel lblPlayerName = new JLabel("Player Name: ");
		lblPlayerName.setForeground(Color.BLUE);
		lblPlayerName.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblPlayerName.setBounds(10, 35, 120, 29);
		frame.getContentPane().add(lblPlayerName);
		
		JLabel lblNumberOfProblems = new JLabel("Number of Problems: ");
		lblNumberOfProblems.setForeground(Color.BLUE);
		lblNumberOfProblems.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblNumberOfProblems.setBounds(10, 60, 174, 29);
		frame.getContentPane().add(lblNumberOfProblems);
		
		JLabel lblCorrect = new JLabel("Number Correct: ");
		lblCorrect.setForeground(Color.BLUE);
		lblCorrect.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblCorrect.setBounds(10, 86, 174, 29);
		frame.getContentPane().add(lblCorrect);
		
		JLabel lblTimeElapsed = new JLabel("Time Elapsed: ");
		lblTimeElapsed.setForeground(Color.BLUE);
		lblTimeElapsed.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblTimeElapsed.setBounds(37, 115, 174, 29);
		frame.getContentPane().add(lblTimeElapsed);
		
		JLabel lblAverageTimePer = new JLabel("Average Time per Problem: ");
		lblAverageTimePer.setForeground(Color.BLUE);
		lblAverageTimePer.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblAverageTimePer.setBounds(37, 138, 239, 29);
		frame.getContentPane().add(lblAverageTimePer);
		
		JLabel lblPercentCorrect = new JLabel("Percent Correct: ");
		lblPercentCorrect.setForeground(Color.BLACK);
		lblPercentCorrect.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblPercentCorrect.setBounds(10, 195, 141, 29);
		frame.getContentPane().add(lblPercentCorrect);
		
		JLabel scoreAchieved = new JLabel("Score Achieved: ");
		scoreAchieved.setForeground(Color.BLACK);
		scoreAchieved.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		scoreAchieved.setBounds(10, 221, 174, 29);
		frame.getContentPane().add(scoreAchieved);
		
		pName = new JLabel("Name");
		pName.setForeground(Color.BLACK);
		pName.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		pName.setBounds(304, 35, 120, 29);
		frame.getContentPane().add(pName);
		
		numProbs = new JLabel("12");
		numProbs.setForeground(Color.BLACK);
		numProbs.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		numProbs.setBounds(304, 60, 120, 29);
		frame.getContentPane().add(numProbs);
		
		numCorrect = new JLabel("XXX");
		numCorrect.setForeground(Color.BLACK);
		numCorrect.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		numCorrect.setBounds(304, 86, 120, 29);
		frame.getContentPane().add(numCorrect);
		
		timeElapsed = new JLabel("XXX");
		timeElapsed.setForeground(Color.BLACK);
		timeElapsed.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		timeElapsed.setBounds(168, 115, 256, 29);
		frame.getContentPane().add(timeElapsed);
		
		avgTime = new JLabel("XXX");
		avgTime.setForeground(Color.BLACK);
		avgTime.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		avgTime.setBounds(267, 138, 157, 29);
		frame.getContentPane().add(avgTime);
		
		pctCorrect = new JLabel("100%");
		pctCorrect.setForeground(Color.BLACK);
		pctCorrect.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		pctCorrect.setBounds(157, 195, 54, 29);
		frame.getContentPane().add(pctCorrect);
		
		totalScore = new JLabel("500");
		totalScore.setForeground(Color.BLACK);
		totalScore.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		totalScore.setBounds(157, 221, 62, 29);
		frame.getContentPane().add(totalScore);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnFinish.setBounds(236, 212, 89, 23);
		frame.getContentPane().add(btnFinish);
		
		JButton btnHistor = new JButton("History");
		btnHistor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// show personal history
				history();
			}
		});
		btnHistor.setBounds(335, 212, 89, 23);
		frame.getContentPane().add(btnHistor);
		
		populate(u);
		
		// do file io
		writeToFile(u);
	}
	
	void populate(User u) {
		int myScore = (int) (((0.0 + u.getScore()) / u.getNumProblems()) * 1000 * u.getScore()); // score is percent rounded up * 1000
		totalScore.setText(Integer.toString(myScore));
		
		u.setFinalScore(myScore);
		
		pName.setText(u.getName());
		numProbs.setText(Integer.toString(u.getNumProblems()));
		numCorrect.setText(Integer.toString(u.getScore()));
		
		String timeElapsedStr = "";
		int timeElapsedSecs = (int) u.getTimeElapsed();
		
		int secs = timeElapsedSecs;

		int hours = secs / 3600;
		secs -= hours*3600;
		
		int minutes = secs / 60;
		secs -= minutes * 60;
		
		
		timeElapsedStr += Integer.toString(hours) + " hours, " + Integer.toString(minutes) + " minutes, " + Integer.toString(secs) + " seconds ";
		
		timeElapsed.setText(timeElapsedStr);
		
		// determines average time, in minutes
		double avgMins = round((timeElapsedSecs / 60.0)/u.getNumProblems(), 2);
		avgTime.setText(Double.toString(avgMins) + " minutes");
		
		double pctScore = round((u.getScore() / Double.valueOf(u.getNumProblems())*100), 2);
		pctCorrect.setText(Double.toString(pctScore) + "%");
	}
	
	private double round(double num1, int decimals) {
		return (double) Math.round(num1 * 100) / 100;
	}
	
	public void history() {
		// switch to history screen
		ArithmeticHelper.switchToHistory();
	}
	
	public void writeToFile(User u) {		
		try {
			File scoresFile = new File(ArithmeticHelper.getPath() + "scores.txt");
			FileWriter fr = new FileWriter(scoresFile, true);
			BufferedWriter br = new BufferedWriter(fr); // appending to file
			
			String data = u.getName() + ", " + Integer.toString(u.getFinalScore()) + '\n';
			
			System.out.println(data);
			
			br.write(data);
			
			br.close();
			fr.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Sets visibility of Screen.
	 * @param isVisible
	 */
	public void setVisibility(Boolean isVisible) {
		this.frame.setVisible(isVisible);
	}

}
