import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;

/* University of Central Florida
*  COP 3330 Spring 2019
*  Final project
*  Author: Harry Sauers
*/

public class ArithmeticHelper {
	
	private static ArrayList<Screen> screensList;
	public static MainScreen mainScreen;
	public static AboutScreen aboutScreen;
	public static MathScreen mathScreen;
	
	public static ArrayList<Integer> operand1 = new ArrayList<Integer>();
	public static ArrayList<Integer> operand2 = new ArrayList<Integer>();
	public static ArrayList<Integer> answers = new ArrayList<Integer>();
	public static ArrayList<Integer> solutions = new ArrayList<Integer>();
	
	private static ArrayList<User> userList;

	public static String getPath() {
		File jarDir = null;
		try {
			jarDir = new File(ArithmeticHelper.class.getProtectionDomain().getCodeSource().getLocation().toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		String path = jarDir.getPath();
		return path.substring(0, path.lastIndexOf('/')) + "/";
	}
	
	public static void main(String args[]) {


		System.out.println(getPath());

		screensList = new ArrayList<Screen>();
		userList = new ArrayList<User>();
		
		try {
			mainScreen = new MainScreen();
			screensList.add(mainScreen);
			aboutScreen = new AboutScreen();
			screensList.add(aboutScreen);
			
			switchToScreen(mainScreen);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void startMath(String name, int numProblems, int numDigits, String operator) {
		// TODO: create user class
		User u = new User(name);
		userList.add(u);
		
		// go to start screen, pass relevant info based on number of problems, digits, and operator
		StartScreen startScreen = new StartScreen(name, Integer.toString(numProblems), Integer.toString(numDigits), operator);
		screensList.add(startScreen);
		switchToScreen(startScreen);
		
		u.start();
		
		// start actually doing math - screen switches
		mathScreen = new MathScreen(name, numProblems, numDigits, operator);
		screensList.add(mathScreen);	
	}
	
	public static void showResultScreen(int score, int numProblems) {
		User latest = userList.get(userList.size() - 1);
		latest.end();
		latest.setScore(score);
		latest.setNumProblems(numProblems);
		ResultScreen resultScreen = new ResultScreen(latest);
		screensList.add(resultScreen);
		switchToScreen(resultScreen);
	}
	
	public static void switchToHistory() {
		ArrayList<ArrayList<Integer>> problems = getProblems();
		HistoryScreen historyScreen = new HistoryScreen(problems);
		screensList.add(historyScreen);
		switchToScreen(historyScreen);
	}
	
	public static void switchToScreen(Screen s) {
		hideAllScreens();
		s.setVisibility(true);
	}
	
	// saves problem data
	public static void addProblem(int num1, int num2, int myAnswer, int solution) {
		operand1.add(num1);
		operand2.add(num2);
		answers.add(myAnswer);
		solutions.add(solution);
	}
	
	// returns all problems
	public static ArrayList<ArrayList<Integer>> getProblems() {
		ArrayList<ArrayList<Integer>> problems = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < operand1.size(); i++) {
			ArrayList<Integer> problem = new ArrayList<Integer>();
			problem.add(operand1.get(i));
			problem.add(operand2.get(i));
			problem.add(solutions.get(i));
			problem.add(answers.get(i));
			problems.add(problem);
		}
		
		return problems;
	}
	
	// shows ranked list
	public static void showRanksList() {
		RankScreen rankScreen = new RankScreen();
		screensList.add(rankScreen);
		switchToScreen(rankScreen);
	}

	// restarts program
	public static void restart() {
		MainScreen newMain = new MainScreen();

		operand1 = new ArrayList<Integer>();
		operand2 = new ArrayList<Integer>();
		answers = new ArrayList<Integer>();
		solutions = new ArrayList<Integer>();

		screensList.set(0, newMain);
		switchToScreen(newMain);
	}

	/**
	 * Call this before switching screens.
	 */
	public static void hideAllScreens() {
		for (Screen screen : screensList) {
			screen.setVisibility(false);
		}
	}
}
