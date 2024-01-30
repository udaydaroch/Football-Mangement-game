package game_main_menu;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import game_start_and_login_page.SignUpShop;

import javax.swing.SwingConstants;

import foot.Player;
import foot.RandomEvents;
import foot.Team;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JList;

/**
 * the stadium class is responsble for constructing the options 
 * for the player to chose their next match.
 * and generate warnings when the squad is not full. 
 * @author udayd
 *
 */
public class Stadium implements ActionListener{

	/**
	 * The frame for the stadium.
	 */
	public static JFrame stadiumFrame;

	/**
	 * Button to go back to the game menu.
	 */
	JButton backToGameMenu;

	/**
	 * Button to start the game.
	 */
	JButton playGameButton;

	/**
	 * The chosen team name.
	 */
	public static String chosenTeam;

	/**
	 * Label for displaying the name of team one.
	 */
	private static JLabel teamOneNameDisplayJLabel;

	/**
	 * Label for displaying the name of team two.
	 */
	private static JLabel teamTwoNameDisplayJLabel;

	/**
	 * Label for displaying the name of team three.
	 */
	private static JLabel teamThreeNameDisplayJLabel;

	/**
	 * Button for selecting team one.
	 */
	private static JButton teamOneButton;

	/**
	 * Button for selecting team two.
	 */
	private static JButton teamTwoButton;

	/**
	 * Button for selecting team three.
	 */
	private static JButton teamThreeButton;

	/**
	 * Label for displaying the chosen team.
	 */
	public static JLabel choseTeamDisplay;

	/**
	 * Array of team names.
	 */
	public static String[] teamName = {"Royals","Knights","Rangers","Capitals","Blaze","Pioneers","Titans","Phoenix","Vipers","Cyclones","Renegades","Thunder","Panthers","Spartans","Barracudas","Hurricanes","Scorpions","Bombers","Sharks","Jaguars","Thunderbirds","Cougars","Lightning","Tigers","Raptors","Cheetahs","Vikings","Raiders","Gators","Dragons","Rockets","Knights","Stallions","Eagles","Wolves","Bulldogs","Ravens","Warriors","Hawks","Condors","Pumas","Suns","Rhinos","Kings","Lions","Cobra","Sabres","Storm","Comets"};

	/**
	 * Panel for displaying all the team players.
	 */
	private JPanel jPanelForAllTheTeamPlayers;

	/**
	 * Panel for team one.
	 */
	private JPanel teamOnePanel;

	/**
	 * Panel for team three.
	 */
	private JPanel teamThreePanel;

	/**
	 * Array of week names.
	 */
	public static String[] weekList;

	/**
	 * The value of the variable.
	 */
	private int value;

	/**
	 * The final week.
	 */
	public static int finalWeek;

	/**
	 * Label for the left box to fit the playing game button.
	 */
	private JLabel leftBoxTwoToFitPlayingGameButton;

	/**
	 * Label for the right box to fit the playing game button.
	 */
	private JLabel rightBoxTwoToFitPLayingGameButton;

	/**
	 * Label for the left box to fit the playing game button.
	 */
	private JLabel leftBoxToFitPlayingGameButton;

	/**
	 * Label for the right box to fit the playing game button.
	 */
	private JLabel rightBoxToFitPLayingGameButton;

	/**
	 * Label for displaying a warning message about player unavailability.
	 */
	private JLabel playerUnvailabiltyWarningJLabel;

	/**
	 * Random object for generating a random team index.
	 */
	private static Random newTeam = new Random();

	/**
	 * The next team index generated.
	 */
	private static int nextTeamIndex;

	/**
	 * Launch the application.
	 */
	

	/**
	 * uses the Contructor to initalize the content including-
	 *previous match history.
	 *team names.
	 *team selection buttons etc. 
	 */
	public Stadium() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		

		
		
		stadiumFrame = new JFrame();
		stadiumFrame.setBounds(100, 100, 844, 445);
		stadiumFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		backToGameMenu = new JButton("< Back");
		backToGameMenu.addActionListener(this);
		
		JPanel playingOptionPanel = new JPanel();
		
		jPanelForAllTheTeamPlayers = new JPanel();
		int value = GameMenu.duration;
		finalWeek = GameMenu.duration;
		weekList = new String[value];
		int i = 0;
		for(String str: weekList)
		{
			weekList[i] = "Week "+(i+1);
			i += 1;
		}
		JList listDisplayingtheMatchHistory = new JList(weekList);
		
		JLabel jLabelForMatchhistoryTitle = new JLabel("MATCH HISTORY");
		jLabelForMatchhistoryTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		playerUnvailabiltyWarningJLabel = new JLabel("Warning: ");
		GroupLayout groupLayout = new GroupLayout(stadiumFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(playingOptionPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(backToGameMenu)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(playerUnvailabiltyWarningJLabel, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(jPanelForAllTheTeamPlayers, GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(jLabelForMatchhistoryTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(listDisplayingtheMatchHistory, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(backToGameMenu)
						.addComponent(jLabelForMatchhistoryTitle)
						.addComponent(playerUnvailabiltyWarningJLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(listDisplayingtheMatchHistory, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(jPanelForAllTheTeamPlayers, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(playingOptionPanel, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
					.addGap(1))
		);
		
		teamOnePanel = new JPanel();
		teamOnePanel.setBackground(new Color(255, 128, 192));
		
		teamThreePanel = new JPanel();
		teamThreePanel.setBackground(new Color(192, 192, 192));
		
		JPanel teamTwoPanel = new JPanel();
		teamTwoPanel.setBackground(new Color(128, 128, 192));
		GroupLayout glTeamTwoPanel = new GroupLayout(teamTwoPanel);
		glTeamTwoPanel.setHorizontalGroup(
			glTeamTwoPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 134, Short.MAX_VALUE)
				.addGap(0, 228, Short.MAX_VALUE)
		);
		glTeamTwoPanel.setVerticalGroup(
			glTeamTwoPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 165, Short.MAX_VALUE)
				.addGap(0, 165, Short.MAX_VALUE)
		);
		teamTwoPanel.setLayout(glTeamTwoPanel);
		GroupLayout glJPanelForAllTheTeamPlayers = new GroupLayout(jPanelForAllTheTeamPlayers);
		glJPanelForAllTheTeamPlayers.setHorizontalGroup(
			glJPanelForAllTheTeamPlayers.createParallelGroup(Alignment.TRAILING)
				.addGroup(glJPanelForAllTheTeamPlayers.createSequentialGroup()
					.addGap(24)
					.addComponent(teamOnePanel, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
					.addGap(31)
					.addComponent(teamTwoPanel, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
					.addGap(32)
					.addComponent(teamThreePanel, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
					.addContainerGap())
		);
		glJPanelForAllTheTeamPlayers.setVerticalGroup(
			glJPanelForAllTheTeamPlayers.createParallelGroup(Alignment.TRAILING)
				.addGroup(glJPanelForAllTheTeamPlayers.createSequentialGroup()
					.addGroup(glJPanelForAllTheTeamPlayers.createParallelGroup(Alignment.LEADING)
						.addComponent(teamThreePanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
						.addComponent(teamTwoPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
						.addComponent(teamOnePanel, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
					.addContainerGap())
		);
		GroupLayout glTeamThreePanel = new GroupLayout(teamThreePanel);
		glTeamThreePanel.setHorizontalGroup(
			glTeamThreePanel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 265, Short.MAX_VALUE)
		);
		glTeamThreePanel.setVerticalGroup(
			glTeamThreePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 165, Short.MAX_VALUE)
		);
		teamThreePanel.setLayout(glTeamThreePanel);
		GroupLayout glTeamOnePanel = new GroupLayout(teamOnePanel);
		glTeamOnePanel.setHorizontalGroup(
			glTeamOnePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 228, Short.MAX_VALUE)
		);
		glTeamOnePanel.setVerticalGroup( 
			glTeamOnePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 165, Short.MAX_VALUE)
		);
		teamOnePanel.setLayout(glTeamOnePanel);
		jPanelForAllTheTeamPlayers.setLayout(glJPanelForAllTheTeamPlayers);
		
		teamTwoNameDisplayJLabel = new JLabel("B");
		teamTwoNameDisplayJLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		teamTwoNameDisplayJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		teamOneNameDisplayJLabel = new JLabel("A ");
		teamOneNameDisplayJLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		teamOneNameDisplayJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		teamThreeNameDisplayJLabel = new JLabel("C");
		teamThreeNameDisplayJLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		teamThreeNameDisplayJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		playGameButton = new JButton("Play game");
		playGameButton.setMaximumSize(new Dimension(20,20));
		playGameButton.addActionListener(this);
		
		teamOneButton = new JButton("Choose team");
		teamOneButton.addActionListener(this);
		
		teamTwoButton = new JButton("Choose team");
		teamTwoButton.addActionListener(this);
		
		teamThreeButton = new JButton("Choose team");
		teamThreeButton.addActionListener(this);
		
		choseTeamDisplay = new JLabel("Team chosen:");
		choseTeamDisplay.setHorizontalAlignment(SwingConstants.LEFT);
		
		leftBoxTwoToFitPlayingGameButton = new JLabel("  ");
		
		rightBoxTwoToFitPLayingGameButton = new JLabel("  ");
		
		leftBoxToFitPlayingGameButton = new JLabel("  ");
		
		rightBoxToFitPLayingGameButton = new JLabel("");
		GroupLayout glPlayingOptionPanel = new GroupLayout(playingOptionPanel);
		glPlayingOptionPanel.setHorizontalGroup(
			glPlayingOptionPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(glPlayingOptionPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(glPlayingOptionPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(leftBoxToFitPlayingGameButton, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
						.addComponent(leftBoxTwoToFitPlayingGameButton, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
						.addComponent(teamOneNameDisplayJLabel, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
						.addComponent(teamOneButton, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
					.addGap(5)
					.addGroup(glPlayingOptionPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(teamTwoNameDisplayJLabel, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
						.addComponent(playGameButton, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
						.addComponent(teamTwoButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
						.addGroup(glPlayingOptionPanel.createSequentialGroup()
							.addComponent(choseTeamDisplay, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(glPlayingOptionPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(glPlayingOptionPanel.createSequentialGroup()
							.addGap(13)
							.addComponent(teamThreeNameDisplayJLabel, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(glPlayingOptionPanel.createSequentialGroup()
							.addGap(5)
							.addComponent(teamThreeButton, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
						.addGroup(glPlayingOptionPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(glPlayingOptionPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(rightBoxToFitPLayingGameButton, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
								 .addComponent(rightBoxTwoToFitPLayingGameButton, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)))))
		);
		glPlayingOptionPanel.setVerticalGroup(
			glPlayingOptionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(glPlayingOptionPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(glPlayingOptionPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(teamTwoNameDisplayJLabel)
						.addComponent(teamOneNameDisplayJLabel)
						.addComponent(teamThreeNameDisplayJLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(glPlayingOptionPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(teamOneButton)
						.addComponent(teamThreeButton)
						.addComponent(teamTwoButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(glPlayingOptionPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(playGameButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(leftBoxToFitPlayingGameButton)
						.addComponent(rightBoxToFitPLayingGameButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glPlayingOptionPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(choseTeamDisplay)
						.addComponent(leftBoxTwoToFitPlayingGameButton)
						.addComponent(rightBoxTwoToFitPLayingGameButton))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		playingOptionPanel.setLayout(glPlayingOptionPanel);
		stadiumFrame.getContentPane().setLayout(groupLayout);
	}
	
	/**
	 * Generates a random team name index from the available team names.
	 * Ensures that the generated index is not already used.
	 * @return The next team name index.
	 */
	public static int RandomTeamNamIndex() {
		nextTeamIndex = newTeam.nextInt(GameMenu.game.maxTeamIndex);
		while (GameMenu.game.usedTeamNamesIndex.contains(nextTeamIndex)) {
			nextTeamIndex = newTeam.nextInt(GameMenu.game.maxTeamIndex);
		}
		return nextTeamIndex;
	}

	/**
	 * Updates the team names displayed in the game menu.
	 * Retrieves a random team name index, sets the corresponding team name label, and adds the index to the usedTeamNamesIndex list.
	 */
	public static void updateTeamNames() {
		nextTeamIndex = RandomTeamNamIndex();
		teamOneNameDisplayJLabel.setText("" + GameMenu.game.teamName[nextTeamIndex]);
		GameMenu.game.usedTeamNamesIndex.add(nextTeamIndex);

		nextTeamIndex = RandomTeamNamIndex();
		teamTwoNameDisplayJLabel.setText("" + GameMenu.game.teamName[nextTeamIndex]);
		GameMenu.game.usedTeamNamesIndex.add(nextTeamIndex);

		nextTeamIndex = RandomTeamNamIndex();
		teamThreeNameDisplayJLabel.setText("" + GameMenu.game.teamName[nextTeamIndex]);
		GameMenu.game.usedTeamNamesIndex.add(nextTeamIndex);
	}

	/**
	 * Handles the actionPerformed events for buttons in the game menu.
	 * Checks the source of the ActionEvent and performs the corresponding actions.
	 */
	@Override 
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backToGameMenu) {
			stadiumFrame = GameMenu.stadium.stadiumFrame;
			Stadium.stadiumFrame.setVisible(false);
			GameMenu.stadium.stadiumFrame.setBounds(GameMenu.stadium.stadiumFrame.getBounds());
			GameMenu.frame.setBounds(Stadium.stadiumFrame.getBounds());
			GameMenu.currentWeekDisplay.setText("Current week: " + GameMenu.currentWeek);
			GameMenu.frame.setVisible(true);
			teamOneButton.setEnabled(true);
			teamTwoButton.setEnabled(true);
			teamThreeButton.setEnabled(true);
			choseTeamDisplay.setText("Team chosen: ");
		}

		if (e.getSource() == playGameButton) {
			
				boolean canPlay = true;
				GameMenu.club.updatePlayerSquad();

				for (Object player : GameMenu.club.playingFour) {
					if (((Player) player).stamina() == 0) {
						playerUnvailabiltyWarningJLabel.setText("Warning: Sorry one or more players have 0 stamina left and you must sort it in the club room");
						canPlay = false;
						break;
					}
				}

				if (GameMenu.club.playingFour.length < 4) {
					canPlay = false;
					playerUnvailabiltyWarningJLabel.setText("Warning: the team does not have enough players, please buy or add reserve players to the playing squad");
				}

				if (canPlay == true) {
					playerUnvailabiltyWarningJLabel.setText("Warning: ");
					Market.totalPurchaseDisplayUpdate();
					
					if (teamOneButton.isEnabled() == true && teamTwoButton.isEnabled() == true && teamThreeButton.isEnabled() == true) {
						choseTeamDisplay.setText("Team chosen: no team selected ");
					} else {
						updateMarket();
						GameMenu.game.gameFrame.setVisible(true);
						GameMenu.game.gameFrame.setBounds(Stadium.stadiumFrame.getBounds());
						GameMenu.game.gameFrame.setLocationRelativeTo(null);
						Stadium.stadiumFrame.setVisible(false);
						teamOneButton.setEnabled(true);
						teamTwoButton.setEnabled(true);
						teamThreeButton.setEnabled(true);
						choseTeamDisplay.setText("Team chosen: ");
					
				}
			}
		}
		
			if (e.getSource() == teamOneButton) {
				teamOneButton.setEnabled(false);
				teamTwoButton.setEnabled(true);
				teamThreeButton.setEnabled(true);
				chosenTeam = teamOneNameDisplayJLabel.getText();
				choseTeamDisplay.setText("Team chosen: " + chosenTeam);
			}

			if (e.getSource() == teamTwoButton) {
				teamOneButton.setEnabled(true);
				teamTwoButton.setEnabled(false);
				teamThreeButton.setEnabled(true);
				chosenTeam = teamTwoNameDisplayJLabel.getText();
				choseTeamDisplay.setText("Team chosen: " + chosenTeam);
			}

			if (e.getSource() == teamThreeButton) {
				teamOneButton.setEnabled(true);
				teamTwoButton.setEnabled(true);
				teamThreeButton.setEnabled(false);
				chosenTeam = teamThreeNameDisplayJLabel.getText();
				choseTeamDisplay.setText("Team chosen: " + chosenTeam);
			}
		}
		

			
	

	/**
	 * Updates the market by resetting the training passes and enabling purchase buttons.
	 */
	public static void updateMarket() {
		for (Team player : SignUpShop.playerList.player) {
			((Player) player).setProteinSuppliement(false);
			((Player) player).setWeeklyPassForAttacker(false);
			((Player) player).setWeeklyPassForLeftDefenders(false);
			((Player) player).setWeeklyPassForRightDefenders(false);
			((Player) player).setWeeklyPassForGoalKeepers(false);

			ClubRoom.weeklyTrainingPassDisplay.setText("weekly training pass: " + ((Player) player).hasWeeklyPassForGoalKeepers());
			ClubRoom.weeklyTrainingPassDisplay.setText("weekly training pass: " + ((Player) player).hasWeeklyPassForLeftDefender());
			ClubRoom.weeklyTrainingPassDisplay.setText("weekly training pass: " + ((Player) player).hasWeeklyPassForRightDefender());
			ClubRoom.weeklyTrainingPassDisplay.setText("weekly training pass: " + ((Player) player).hasWeeklyPassForAttacker());
		}

		Market.totalPurchaseDisplayUpdate();
		Market.buttonActivationStatus();
		Market.goalKeeperTrainingPassButton.setEnabled(true);
		Market.defenceTrainingPassButton.setEnabled(true);
		Market.attackerTrainingPassPurchaseButton.setEnabled(true);
		Market.proteinSupplimentPurcahseButton.setEnabled(true);
	}

}
