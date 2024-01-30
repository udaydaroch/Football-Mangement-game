package game_main_menu;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;


import game_start_and_login_page.LoginPage;
import stadium_game_screen.TheGameScreen;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.util.ArrayList;
/**
 * GameMenu class is the main hub for the player that allows the player to access different parts of the page
 * as the class is responable for creating the ClubRoom,Market,Stadium, the game screen etc.
 * and it also implements the ActionListener inteface the handle button on click events. 
 
 * @author udayd
 */
public class GameMenu implements ActionListener {

	/**
	 * Collection for storing notices.
	 */
	public static ArrayList<Object> noticeCollecter = new ArrayList<Object>();

	/**
	 * Represents the main frame of the application.
	 */
	public static JFrame frame;

	/**
	 * Starting money for the player.
	 */
	private static final int starting_money = 2000;

	/**
	 * Current money available for the player.
	 */
	public static int money = starting_money;

	/**
	 * Label for displaying information.
	 */
	private JLabel label;

	/**
	 * Duration of the game.
	 */
	public static int duration;

	/**
	 * Difficulty level of the game.
	 */
	public static int difficulty;

	/**
	 * Constant value for the duration.
	 */
	public static int durationConst = duration;

	/**
	 * Name of the team.
	 */
	public static String team;

	/**
	 * Button for navigating to the club room.
	 */
	private JButton goToClub;

	/**
	 * Button for navigating to the stadium.
	 */
	private JButton goToStadium;

	/**
	 * Button for navigating to the market.
	 */
	private JButton goToMarket;

	/**
	 * Total number of notices.
	 */
	private static int totalNotices = 0;

	/**
	 * Instance of the club room.
	 */
	public static ClubRoom club;

	/**
	 * Instance of the market.
	 */
	public static Market market;

	/**
	 * Instance of the stadium.
	 */
	public static Stadium stadium;

	/**
	 * Instance of the game screen.
	 */
	public static TheGameScreen game;

	/**
	 * Instance of the Take a Bye feature.
	 */
	public static TakeaBye takingBye;

	/**
	 * Current week in the game.
	 */
	public static int currentWeek;

	/**
	 * Label for displaying the amount of money in the account.
	 */
	public static JLabel gameMenuMoneyInAccount;

	/**
	 * Label for displaying the current week.
	 */
	public static JLabel currentWeekDisplay;

	/**
	 * Label for displaying the remaining weeks.
	 */
	public static JLabel weekRemainingDisplay;

	/**
	 * Button for taking a bye.
	 */
	public static JButton takeABye;

	/**
	 * Amount of difficulty increase per week.
	 */
	public static int difficultyIncreasePerWeek;

	/**
	 * Scroll pane for displaying notices.
	 */
	public static JScrollPane scrollPane;

	/**
	 * List for displaying notices.
	 */
	private static JList noticeList;

	/**
	 * GameMenu construct used to intialize the team, duration, duratoinConst, and the difficulty.
	 * @param teamName that holds the team name.
	 * @param durationOfGame integer holds the full duration of the Game. 
	 * @param difficultyOfGame integer holds the diffciculty of the game chosen by the player.
	 */
	
	public GameMenu(String teamName, int durationOfGame, int difficultyOfGame) {
		
		
		team = teamName;
		duration = durationOfGame - 1;
		durationConst = durationOfGame;
		difficulty = difficultyOfGame;
		initialize();
		GameMenu.frame.setVisible(true);
		GameMenu.frame.setBounds(LoginPage.window.frame.getBounds());
		GameMenu.frame.setLocationRelativeTo(null);
			
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		if ( difficulty == 1)
		{
			difficultyIncreasePerWeek = (15/duration)*2;
		}
		if(difficulty == 2)
		{
			difficultyIncreasePerWeek = (30/duration)*2;
		}
		if(difficulty == 3)
		{
			difficultyIncreasePerWeek = (50/duration)*2;
		}
		
		club = new ClubRoom();
    	club.clubFrame.setVisible(false);
    	
    	market = new Market();
    	market.marketFrame.setVisible(false);
 
    	stadium = new Stadium();
    	stadium.stadiumFrame.setVisible(false);
    
    	game = new TheGameScreen();
 
    	game.gameFrame.setVisible(false);
    	stadium.updateTeamNames();
    	
    	takingBye = new TakeaBye();
    	takingBye.frame.setVisible(false);
    	
    	
		frame = new JFrame();
		GameMenu.frame.setBounds(LoginPage.window.frame.getBounds());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		goToClub = new JButton("club room");
		goToClub.addActionListener(this);
		goToStadium = new JButton("Stadium");
		goToStadium.addActionListener(this);
		goToMarket = new JButton("Market ");
		goToMarket.addActionListener(this);
		
		noticeList = new JList<Object>();
		
		weekRemainingDisplay = new JLabel("Week remaining: "+duration);
		weekRemainingDisplay.setHorizontalAlignment(SwingConstants.TRAILING);
		weekRemainingDisplay.setFont(new Font("Tahoma", Font.PLAIN, 12));
		currentWeek = 1;
		currentWeekDisplay = new JLabel("Current week: "+currentWeek);
		currentWeekDisplay.setHorizontalAlignment(SwingConstants.TRAILING);
		currentWeekDisplay.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		takeABye = new JButton("take a bye");
		takeABye.addActionListener(this);
		
		gameMenuMoneyInAccount = new JLabel("Money in account: "+money);
		gameMenuMoneyInAccount.setHorizontalAlignment(SwingConstants.RIGHT);
		gameMenuMoneyInAccount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		scrollPane = new JScrollPane();
		
		JLabel generalTeamAndShopUpdateLabel = new JLabel("Team and Market update");
		generalTeamAndShopUpdateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(172, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(gameMenuMoneyInAccount, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
								.addComponent(weekRemainingDisplay, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
								.addComponent(currentWeekDisplay, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
							.addGap(67))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(goToStadium, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
								.addComponent(goToClub, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
							.addGap(176)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(takeABye, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
								.addComponent(goToMarket, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(generalTeamAndShopUpdateLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
								.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addComponent(gameMenuMoneyInAccount, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(currentWeekDisplay)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(weekRemainingDisplay)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(59)
							.addComponent(generalTeamAndShopUpdateLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(119)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(goToClub)
								.addComponent(goToMarket))
							.addGap(66)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(goToStadium)
								.addComponent(takeABye))))
					.addContainerGap(168, Short.MAX_VALUE))
		);
		
		
		frame.getContentPane().setLayout(groupLayout);
	}

	/**
	 * Displays the notices in the notice collector.
	 */
	public static void noticeDisplayer() {
		// Create an array to hold the notices
		Object[] receiver = new Object[noticeCollecter.size()];
		
		// Create a JList using the array of notices
		noticeList = new JList<Object>(receiver);

		int i = 0;

		// Iterate through the notice collector
		for (Object string : noticeCollecter) {
			// Format each notice as "notice: <notice>"
			receiver[i] = "notice " + ": " + string;
			i += 1;
		}

		// Set the JList as the view of the scroll pane
		scrollPane.setViewportView(noticeList);
	}


	/**
	 * Handles the actionPerformed events for the buttons in the game menu.
	 * Checks the source of the ActionEvent and performs the corresponding actions.
	 * - If the source is the goToClubButton, activates the Club frame, deactivates the current frame, and updates the player squad.
	 * - If the source is the goToMarketButton, activates the Market frame, deactivates the current frame, and updates the button activation status, money display, and item/player counts.
	 * - If the source is the goToStadiumButton, activates the Stadium frame, deactivates the current frame, and updates the player squad.
	 * - If the source is the takeAByeButton, activates the takingBye frame, updates player stamina, and keeps the current frame active.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// checks if the ActionEvent is from the goToClubButton and 
		// activates the Club frame and deactivates the current frame.
		if (e.getSource() == goToClub) {
			club.clubFrame.setVisible(true);
			club.clubFrame.setBounds(GameMenu.frame.getBounds());
			club.clubFrame.setLocationRelativeTo(null);
			GameMenu.frame.setVisible(false);
			club.purchaseButtonActivation();
			club.updatePlayerSquad();
		}
		// checks if the ActionEvent is from the goToClubButton and 
				// activates the Club frame and deactivates the current frame.
		if (e.getSource() == goToMarket) {
			market.marketFrame.setVisible(true);
			market.marketFrame.setBounds(GameMenu.frame.getBounds());
			market.marketFrame.setLocationRelativeTo(null);
			GameMenu.frame.setVisible(false);
			market.buttonActivationStatus();
			market.moneyInAmountJLabel.setText("Money in Account :" + GameMenu.money);
			market.numberOfPurchasedItemRemaining();
			market.numberOfPlayersInTheSquad();
		}

		if (e.getSource() == goToStadium) {
			stadium.stadiumFrame.setVisible(true);
			stadium.stadiumFrame.setBounds(GameMenu.frame.getBounds());
			stadium.stadiumFrame.setLocationRelativeTo(null);
			club.updatePlayerSquad();
			GameMenu.frame.setVisible(false);
		}

		// checks if the ActionEvent is from the takeABye button and 
		// activates the takingBye frame whilst keeping the current frame 
		// active.
		if (e.getSource() == takeABye) {
			takingBye.frame.setVisible(true);
			takingBye.frame.setLocationRelativeTo(null);
			GameMenu.takingBye.updateAllPlayerStamina();
		}
	}

}
