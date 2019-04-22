/* University of Central Florida
*  COP 3330 Spring 2019
*  Final project
*  Author: Harry Sauers
*/
public class User {
	
	private String name;
	private int score;
	private double timeStart;
	private double timeEnd = -1;
	private int numProblems;
	private int finalScore;
	
	public User(String name) {
		this.name = name;
	}
	
	public void start() {
		this.timeStart = System.currentTimeMillis();
	}
	
	public void end() {
		this.timeEnd = System.currentTimeMillis();
	}
	
	public void setScore(int newScore) {
		this.score = newScore;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setNumProblems(int numProbs) {
		this.numProblems = numProbs;
	}
	
	public int getNumProblems() {
		return this.numProblems;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setFinalScore(int newFinalScore) {
		this.finalScore = newFinalScore;
	}
	
	public int getFinalScore() {
		return this.finalScore;
	}
	
	/**
	 * 
	 * @return total time elapsed in seconds
	 */
	public double getTimeElapsed() {
		if (timeEnd != -1)
			return (timeEnd - timeStart) / 1000;
		else
			return -1;
	}

}
