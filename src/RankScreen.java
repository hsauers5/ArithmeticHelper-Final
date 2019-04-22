/* University of Central Florida
*  COP 3330 Spring 2019
*  Final project
*  Author: Harry Sauers
*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class RankScreen implements Screen {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public RankScreen() {
		initialize();
	}
	
	public void readData() {
		/* 
		 * Format:
		 * name, score
		 * 
		 * Max 10 Entries
		 */
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> scores = new ArrayList<Integer>();
		
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader("src/scores.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				String[] tmpArray = line.split(", ");
				String tmpName = tmpArray[0];
				int tmpScore = Integer.valueOf(tmpArray[1]);
				names.add(tmpName);
				scores.add(tmpScore);
			}
			
			int lowestIndex = 0;
			for (int i = 0; i < names.size(); i++) {
				if (scores.get(i) < scores.get(lowestIndex)) {
					lowestIndex = i;
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRankListOf = new JLabel("Rank List of ArithmeticHelper");
		lblRankListOf.setForeground(Color.RED);
		lblRankListOf.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblRankListOf.setBounds(41, 0, 334, 34);
		frame.getContentPane().add(lblRankListOf);
		
		// file io
		/* 
		 * Format:
		 * name, score
		 * 
		 * Max 10 Entries
		 */
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> scores = new ArrayList<Integer>();
		
		int[] topScores = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}; // highest to lowest
		String[] topNames = {"","","","","","","","","",""};
		
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(ArithmeticHelper.getPath() + "scores.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				// System.out.println(line);
				
				String[] tmpArray = line.split(", ");
				String tmpName = tmpArray[0];
				int tmpScore = Integer.valueOf(tmpArray[1]);
				names.add(tmpName);
				scores.add(tmpScore);
			}
			
			// System.out.println(names);
			
			// sort arraylist in order
			for (int i = 0; i < scores.size(); i++) {
	            for (int j = i + 1; j < scores.size(); j++) {
	                if (scores.get(i) < scores.get(j)) {
	                    int tempScore = scores.get(i);
	                    String tempName = names.get(i);
	                    
	                    scores.set(i, scores.get(j));
	                    scores.set(j, tempScore);
	                    names.set(i, names.get(j));
	                    names.set(j, tempName);
	                }
	            }
	        }
			
			// assign to "top ten" arrays
			for (int i = 0; i < 10 && i < scores.size(); i++) {
				topScores[i] = scores.get(i);
				topNames[i] = names.get(i);
			}
			
			// System.out.println(topScores[0]);
			// System.out.println(topNames[0]);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int[] bounds1 = {152, 32, 72, 27};
		int[] bounds2 = {267, 32, 72, 27};
		int[] bounds3 = {51, 32, 72, 27};
		
		for (int i = 0; i < 10 && !topNames[i].equals(""); i++) {
			JLabel lblName = new JLabel(topNames[i]);
			lblName.setForeground(Color.DARK_GRAY);
			lblName.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
			lblName.setBounds(bounds1[0], bounds1[1], bounds1[2], bounds1[3]);
			frame.getContentPane().add(lblName);
			
			JLabel lblScore = new JLabel(Integer.toString(topScores[i]));
			lblScore.setForeground(Color.DARK_GRAY);
			lblScore.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
			lblScore.setBounds(bounds2[0], bounds2[1], bounds2[2], bounds2[3]); // lblScore_1.setBounds(267, 56, 72, 27); +20 on second row
			frame.getContentPane().add(lblScore);
			
			JLabel lblRank = new JLabel(Integer.toString(i+1) + ". ");
			lblRank.setForeground(Color.DARK_GRAY);
			lblRank.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
			lblRank.setBounds(bounds3[0], bounds3[1], bounds3[2], bounds3[3]);
			frame.getContentPane().add(lblRank);
			
			// move down by one Y axis
			bounds1[1]+=20;
			bounds2[1]+=20;
			bounds3[1]+=20;
		}

		// add main screen button
		JButton btnFinish = new JButton("MainWindow");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArithmeticHelper.restart();
			}
		});
		btnFinish.setBounds(326, 212, 130, 23);
		frame.getContentPane().add(btnFinish);
		
	}

	public void setVisibility(Boolean isVisible) {
		this.frame.setVisible(isVisible);
	}

}
