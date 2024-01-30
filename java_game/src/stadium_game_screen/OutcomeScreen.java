package stadium_game_screen;

import java.awt.Component;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import foot.Player;
import foot.RandomEvents;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import game_main_menu.ClubRoom;
import game_main_menu.GameMenu;
import game_main_menu.Market;
import game_main_menu.Stadium;
import game_start_and_login_page.SignUpShop;

import javax.swing.JList;
import java.util.Random;

/**
 * the outcomeScreen class is displayed
 * when the match has ended 
 * it implements the "ActionListener" and "ListSelectionListener" interfaces
 * to handle actions events caused by the button clicks ie the player vs player button
 */
public class OutcomeScreen implements ActionListener,ListSelectionListener {

	/**
	 *  Frame to display the content of the OutcomeScreen
	 * 
	 */
	public JFrame frame; 
	/**
	 *  Button to go back to the stadium
	 */
	private JButton backToStadiumButton; 
	/**
	 *  Label to display the game result
	 */
	private static JLabel gameResult; 
	
	/**
	 * Label to display the points gained
	 */
	
	public static JLabel pointsGained; 
	/**
	 *  Label to display the total number of points
	 */
	public static JLabel totalNumberOfPoints;
	/**
	 *  Scroll pane for the list of playing players
	 */
	private JScrollPane listOfPlayingPlayers; 
	
	/**
	 *  Currently selected player
	 */
	private Object selectedPlayer = new Player(0, 0, 0, "", "", false, false);
	/**
	 *  List of playing players
	 */
	private JList playerList;
	/**
	 *  Array of playing players(the playing squad)
	 */
	private Object[] playingFourList; 
	
	/**
	 *  Label to display the stamina left
	 */
	private JLabel staminaLeftStatusLabel; 
	/**
	 *  Label to display the playability status
	 */
	private JLabel playabitliyLabel; 
	/**
	 *  Label to display the money gained
	 */
	public static JLabel moneyGained; 
	/**
	 *  Total money gained through matches
	 */
	public static int totalMoneyGainedThroughMatches; 
	/** Money gained per match
	 * 
	 */
	private static int moneyGainedPerMatch; 
	/**
	 *  Random object for money gained
	 */
	private static Random moneyGainedRandomlyPerNatch = new Random(); 

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public OutcomeScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 711, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		listOfPlayingPlayers = new JScrollPane();
		listOfPlayingPlayers.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listOfPlayingPlayers.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		backToStadiumButton = new JButton("Stadium");
		backToStadiumButton.addActionListener(this);
		JPanel gameOutcomeBox = new JPanel();
		
		JPanel playabilityAndStaminaLabelBox = new JPanel(); 
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(listOfPlayingPlayers, GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(backToStadiumButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(584, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(playabilityAndStaminaLabelBox, GroupLayout.PREFERRED_SIZE, 622, GroupLayout.PREFERRED_SIZE)
							.addGap(41))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(gameOutcomeBox, GroupLayout.PREFERRED_SIZE, 688, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(backToStadiumButton)
					.addGap(10)
					.addComponent(gameOutcomeBox, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(listOfPlayingPlayers, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addComponent(playabilityAndStaminaLabelBox, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
	    
		staminaLeftStatusLabel = new JLabel("Stamina left: ");
		playabitliyLabel = new JLabel("Playability: ");
		GroupLayout gl_playabilityAndStaminaLabelBox = new GroupLayout(playabilityAndStaminaLabelBox);
		gl_playabilityAndStaminaLabelBox.setHorizontalGroup(
			gl_playabilityAndStaminaLabelBox.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_playabilityAndStaminaLabelBox.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_playabilityAndStaminaLabelBox.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_playabilityAndStaminaLabelBox.createSequentialGroup()
							.addComponent(staminaLeftStatusLabel, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addComponent(playabitliyLabel, GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)))
		);
		gl_playabilityAndStaminaLabelBox.setVerticalGroup(
			gl_playabilityAndStaminaLabelBox.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_playabilityAndStaminaLabelBox.createSequentialGroup()
					.addComponent(staminaLeftStatusLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(playabitliyLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(5))
		);
		playabilityAndStaminaLabelBox.setLayout(gl_playabilityAndStaminaLabelBox);
		
		
		gameResult = new JLabel("  Game Result : ");
		gameResult.setHorizontalAlignment(SwingConstants.LEFT);
		gameResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		pointsGained = new JLabel("Points gained : ");
		pointsGained.setHorizontalAlignment(SwingConstants.LEFT);
		pointsGained.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		totalNumberOfPoints = new JLabel("    Total points :");
		totalNumberOfPoints.setHorizontalAlignment(SwingConstants.LEFT);
		totalNumberOfPoints.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		moneyGained = new JLabel("Money gained : ");
		moneyGained.setHorizontalAlignment(SwingConstants.LEFT);
		moneyGained.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout glgameOutcomeBox = new GroupLayout(gameOutcomeBox);
		glgameOutcomeBox.setHorizontalGroup(
			glgameOutcomeBox.createParallelGroup(Alignment.TRAILING)
				.addGroup(glgameOutcomeBox.createSequentialGroup()
					.addContainerGap()
					.addGroup(glgameOutcomeBox.createParallelGroup(Alignment.LEADING)
						.addComponent(gameResult, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
						.addComponent(moneyGained, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glgameOutcomeBox.createParallelGroup(Alignment.LEADING)
						.addGroup(glgameOutcomeBox.createSequentialGroup()
							.addComponent(totalNumberOfPoints, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(glgameOutcomeBox.createSequentialGroup()
							.addComponent(pointsGained, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
							.addGap(70))))
		);
		glgameOutcomeBox.setVerticalGroup(
			glgameOutcomeBox.createParallelGroup(Alignment.TRAILING)
				.addGroup(glgameOutcomeBox.createSequentialGroup()
					.addContainerGap(17, Short.MAX_VALUE)
					.addGroup(glgameOutcomeBox.createParallelGroup(Alignment.BASELINE)
						.addComponent(gameResult)
						.addComponent(pointsGained, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(glgameOutcomeBox.createParallelGroup(Alignment.BASELINE)
						.addComponent(moneyGained, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(totalNumberOfPoints, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gameOutcomeBox.setLayout(glgameOutcomeBox);
		
		

		frame.getContentPane().setLayout(groupLayout);
	}
	/**
	 * updates the playingSquad playing the game when the function is called
	 */

	public void updatePlayingSquad() {
	    // Reset the playability and stamina labels
	    playabitliyLabel.setText("Playability: ");
	    staminaLeftStatusLabel.setText("Stamina left: ");
	    
	    // Update the player squad in the club
	    GameMenu.club.updatePlayerSquad();
	    
	    // Initialize the playingFourList and add player stamina records
	    playingFourList = new Object[4];
	    TheGameScreen.myLeftdefenderObject.playerStaminaRecord.add(TheGameScreen.myLeftdefenderObject.stamina());
	    TheGameScreen.myRightdefenderObject.playerStaminaRecord.add(TheGameScreen.myRightdefenderObject.stamina());
	    TheGameScreen.myStrickerObject.playerStaminaRecord.add(TheGameScreen.myStrickerObject.stamina());
	    TheGameScreen.myGoalkeeperObject.playerStaminaRecord.add(TheGameScreen.myGoalkeeperObject.stamina());
	    
	    // Assign players to the playingFourList
	    playingFourList[0] = TheGameScreen.myLeftdefenderObject;
	    playingFourList[1] = TheGameScreen.myRightdefenderObject;
	    playingFourList[2] = TheGameScreen.myStrickerObject;
	    playingFourList[3] = TheGameScreen.myGoalkeeperObject;
	    
	    // Create a new JList with the playingFourList and set it as the playerList
	    playerList = new JList<Object>(playingFourList);
	    
	    // Set the JList as the viewport view for the listOfPlayingPlayers JScrollPane
	    listOfPlayingPlayers.setViewportView(playerList);
	    
	    // Add the ListSelectionListener to the playerList
	    playerList.addListSelectionListener(this);
	}

	/**
	 * returns the gameResult string when the function is called.
	 * @return outcome string that holds the gameeresult
	 */
	public static String gameResultNumberToString() {
	    String outcome = "";
	    
	    // Determine the game outcome based on scores and player stamina check
	    if (TheGameScreen.myCurrentScore > TheGameScreen.opponentCurrentScore) {
	        outcome = "You won by " + (TheGameScreen.myCurrentScore - TheGameScreen.opponentCurrentScore);
	    }
	    if (((TheGameScreen) GameMenu.game).playerStaminaCheckSfterNatch() == 4) {
	        outcome = "You lost (all players got injured)";
	    }
	    if (TheGameScreen.myCurrentScore < TheGameScreen.opponentCurrentScore) {
	        outcome = "You lost by " + Math.abs(TheGameScreen.myCurrentScore - TheGameScreen.opponentCurrentScore);
	    } else if (TheGameScreen.myCurrentScore == TheGameScreen.opponentCurrentScore) {
	        outcome = "It was a draw";
	    }
	    
	    return outcome;
	}

	/**
	 * returns the money gained per match when a value is passed
	 * @param constant(which varies depending on the difficulty level of the game)
	 * @return value the money gained by the player for a given constant 
	 */
	public static int moneyGainedPerMatch(int constant) {
	    int value = 0;
	    
	    // Calculate money gained based on the game result
	    if (TheGameScreen.myCurrentScore > TheGameScreen.opponentCurrentScore) {
	        value = moneyGainedRandomlyPerNatch.nextInt(constant - 10) + 100;
	    }
	    if (TheGameScreen.myCurrentScore == TheGameScreen.opponentCurrentScore) {
	        value = moneyGainedRandomlyPerNatch.nextInt((constant - 10) - 10) + 100;
	    }
	    
	    return value;
	}

	
	/**
	 * generates and assigns the amount gained by the player to the player money acount.
	 * 
	 * @return generates  the constant for the function above and increments the total money of the player by that amount 
	 */
	
	public static int randomMoneyGained() {
	    int value = 0;
	    
	    // Check the difficulty level in the GameMenu
	    if (GameMenu.difficulty == 1) {
	        value = moneyGainedPerMatch(100);
	        GameMenu.money += value;
	    }
	    if (GameMenu.difficulty == 2) {
	        value += moneyGainedPerMatch(200);
	        GameMenu.money += value;
	    }
	    if (GameMenu.difficulty == 3) {
	        value += moneyGainedPerMatch(300);
	        GameMenu.money += value;
	    }
	    
	    // Update the total money gained through matches
	    totalMoneyGainedThroughMatches += value;
	    
	    return value;
	}

	/**
	 * displays the points gained, totalNumber of Points, money gained and the updates the money display in the current frame and 
	 * he GameMenu Label called gameMenuMoneyInAccount
	 */
	public static void gameResultCurrentPointAndTotalPointUpdate() {
	    // Update the points gained, total points, money gained, and game result display
	    
	    pointsGained.setText("Points gained: " + TheGameScreen.myCurrentScore);
	    totalNumberOfPoints.setText("Total points: " + TheGameScreen.TotalScore);
	    moneyGained.setText("Money gained: " + randomMoneyGained());
	    GameMenu.gameMenuMoneyInAccount.setText("Money in account: " + GameMenu.money);
	    
	    // Reset the moneyGainedPerMatch variable
	    moneyGainedPerMatch = 0;
	    
	    gameResult.setText("Game Result: " + gameResultNumberToString());
	}

	/**
	 * actions performed upon clicking a backToStadiumButton in the frame
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	    // Check if the event source is the backToStadiumButton
	    if(e.getSource() == backToStadiumButton) {
	    	
	        // Trigger random events related to player addition, removal, and stat increase
	        RandomEvents.triggerRandomEventOfPlayerBeingAdded();
	        RandomEvents.triggerRandomEventOfPlayerBeingRemoved();
	        RandomEvents.triggerRandomEventOfPlayerStatIncreasing();
	        
	        // Display notices in the game menu
	        GameMenu.noticeDisplayer();
	        
	        // Perform updates after the game
	        GameMenu.game.afterGameUpdates();
	        
	        // Set the bounds of the stadiumFrame to match the gameFrame
	        Stadium.stadiumFrame.setBounds(GameMenu.game.gameFrame.getBounds());
	        
	        // Hide the gameOutcomeScreen and gameFrame
	        GameMenu.game.gameOutcomeScreen.frame.setVisible(false);
	        GameMenu.game.gameFrame.setVisible(false);
	        
	        // Show the stadiumFrame
	        GameMenu.stadium.stadiumFrame.setVisible(true);
	    }
	  }
	

 
	/**
	 * valueChanged method of the ListSelectionListener interface.
	 * Handles the event when a player is selected from the playerList changes.
	 * Updates the selected player and gathers their ability and stamina information.
	 */
	
	@Override
	public void valueChanged(ListSelectionEvent e) { 
	    // Check if the event source is the playerList
	    if(e.getSource() == playerList) {
	        // Get the selected player from the playerList
	        selectedPlayer = (Object) playerList.getSelectedValue();
	        // Update the player's ability and stamina information
	        playerabiityAndStaminaInformationGatherer();
	    }
	}

	/**
	 * Generates the playability status for a player based on their stamina and 
	 * returns a string indicating the player's playability status.
	 * @param player object is passed to this helper function to determine the playabilitystatus of the player which is displayed on the screen
	 * @return playble string that is used by another function and further displays it on the screen.
	 */
	public String playabilityStatusGenerator(Object player) {
	    String playable = "";

	    // Check the player's stamina to determine their playability status
	    if(((Player) player).stamina() == 0) {
	        playable = "the player is injured";
	    }
	    if(((Player) player).stamina() > 0 && ((Player) player).stamina() < TheGameScreen.damageTakenOnLoss) {
	        playable = "the player can play the next game but will become injured after that.";
	    }
	    if(((Player) player).stamina() >= TheGameScreen.damageTakenOnLoss) {
	        playable = "the player can play the next match.";
	    }
	    if(((Player) player).stamina() >= 2 * TheGameScreen.damageTakenOnLoss) {
	        playable = "the player can play the next 2 matches.";
	    }
	    if(((Player) player).stamina() >= 3 * TheGameScreen.damageTakenOnLoss) {
	        playable = "the player can play the next 3 matches.";
	    }

	    return playable;
	}

	/**
	 * collects info about the selected player's ability and stamina.
	 * Updates the labels for that parituclar player with the gathered information.
	 */
	public void playerabiityAndStaminaInformationGatherer() {
	    // Iterate through the playingFourList to find the selected player
	    for(Object player: playingFourList) {
	        if(((Player) selectedPlayer).getName() == ((Player) player).getName()) {
	            // Update the stamina left status label
	            staminaLeftStatusLabel.setText("Stamina left: "+((Player) selectedPlayer).stamina());
	            
	            // Update the playability label using the playabilityStatusGenerator method
	            playabitliyLabel.setText("Playability: "+playabilityStatusGenerator(player));
	        }
	    }
	}
 

}
