package stadium_game_screen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import foot.Player;
import foot.Player;
import foot.Team;
import game_main_menu.ClubRoom;
import game_main_menu.GameMenu;
import game_main_menu.Stadium;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Random;
/**
 * the Class named TheGameScreen sets up the playing ground 
 * for both the teams and implements the actionlistener 
 * to determine button clicks
 * @author udayd
 *
 */
public class TheGameScreen implements ActionListener {

	/**
	 * Label to display the current score of my team
	 */
	private JLabel myTeamCurrentScoreDisplay;

	/**
	 * Label to display the current score of the opponent team
	 */
	private JLabel opponentCurrentScoreDisplay;

	/**
	 * Maximum index value for team names
	 */
	public final static int maxTeamIndex = 44;

	/**
	 * Maximum index value for player names
	 */
	public final static int maxPlayerIndex = 54;

	/**
	 * Current score of my team
	 */
	public static int myCurrentScore;

	/**
	 * Current score of the opponent team
	 */
	public static int opponentCurrentScore;

	/**
	 * Counter for match history
	 */
	public static int matchHistoryCounter = 0;

	/**
	 * Total score
	 */
	public static int TotalScore = 0;

	/**
	 * Label to display the opponent team name
	 */
	public static JLabel opponentTeamName;

	/**
	 * Frame for the game
	 */
	public static JFrame gameFrame;

	/**
	 * Label to display my team name
	 */
	public static JLabel myTeamNameLabel;

	/**
	 * Button for goalkeeper vs. goalkeeper play
	 */
	public static JButton goallyVsGoallyButton;

	/**
	 * Button for left defender vs. left defender play
	 */
	public static JButton leftDefenderVsLeftDefenderButton;

	/**
	 * Button for right defender vs. right defender play
	 */
	public static JButton rightDefenderVsRightDefenderButton;

	/**
	 * Button for striker vs. striker play
	 */
	public static JButton strickerVsStrickerButton;

	/**
	 * Button to confirm all plays
	 */
	public static JButton confirmAllPlaysButton;

	/**
	 * Counter for the number of buttons clicked
	 */
	private int numberOfButtonsClicked = 0;

	/**
	 * Label for the right defender's offensive stat
	 */
	public static JLabel rightDefenderOffenceLabel;

	/**
	 * Label for the right defender's defensive stat
	 */
	public static JLabel rightDefenderDefenceLabel;

	/**
	 * Label for the right defender's stamina stat
	 */
	public static JLabel rightDefenceStaminaLabel;

	/**
	 * Label for the right defender's position
	 */
	public static JLabel rightDefenderPositionLabel;

	/**
	 * Label for the right defender's name
	 */
	public static JLabel rightDefenderNameLabel;

	/**
	 * Label for the goalkeeper's offensive stat
	 */
	public static JLabel goallyOffenceLabel;

	/**
	 * Label for the goalkeeper's defensive stat
	 */
	public static JLabel goallyDefencePlayers;

	/**
	 * Label for the goalkeeper's stamina stat
	 */
	public static JLabel goallyStaminaLabel;

	/**
	 * Label for the goalkeeper's position
	 */
	public static JLabel goalPositionLabel;

	/**
	 * Label for the goalkeeper's name
	 */
	public static JLabel nameOfGoally;

	/**
	 * Label for the left defender's offensive stat
	 */
	public static JLabel leftDefenceOffenceLabel;

	/**
	 * Label for the left defender's defensive stat
	 */
	public static JLabel LeftDefenceDefencePlayers;

	/**
	 * Label for the left defender's stamina stat
	 */
	public static JLabel leftDefenceStaminaLabel;

	/**
	 * Label for the left defender's name
	 */
	public static JLabel nameOfLeftDefender;

	/**
	 * Label for the left defender's position
	 */
	public static JLabel playerPositionLeftDefender;

	/**
	 * Label for the striker's offensive stat
	 */
	public static JLabel StrickerOffencePlayers;

	/**
	 * Label for the striker's defensive stat
	 */
	public static JLabel strickerDefenceLabel;

	/**
	 * Label for the striker's stamina stat
	 */
	public static JLabel strickerStaminaPlayers;

	/**
	 * Label for the striker's position
	 */
	public static JLabel playerPositiponStricker;

	/**
	 * Label for the striker's name
	 */
	public static JLabel nameOfStricker;

	/**
	 * Object for my team's left defender
	 */
	public static Player myLeftdefenderObject;

	/**
	 * Object for my team's rightdefender
	 */
	public static Player myRightdefenderObject;

	/**
	 * Object for my team's goalkeeper
	 */
	public static Player myGoalkeeperObject;

	/**
	 * Object for my team's striker
	 */
	public static Player myStrickerObject;

	/**
	 * Label for my team's goalkeeper name
	 */
	private static JLabel myGoallyName;

	/**
	 * Label for my team's left defender name
	 */
	private static JLabel myLeftDefenderName;

	/**
	 * Label for my team's striker name
	 */
	private static JLabel myStrickerName;

	/**
	 * Label for my team's right defender name
	 */
	private static JLabel myRightDefenderName;

	/**
	 * Object for the opponent team's striker
	 */
	private static Player opponentPlayerStricker;

	/**
	 * Object for the opponent team's right defender
	 */
	private static Player opponentPlayerRightDefender;

	/**
	 * Object for the opponent team's left defender
	 */
	private static Player opponentPlayerLeftDefender;

	/**
	 * Object for the opponent team's goalkeeper
	 */
	private static Player opponentPlayerGoalKeeper;

	/**
	 * Label for the goalkeeper's reflex stat
	 */
	public static JLabel goalKeeperReflexPlayers;

	/**
	 * Opponent team object
	 */
	public static Team opponentTeam;

	/**
	 * Array of team names
	 */
	public static String[] teamName = {"Royals","Knights","Rangers","Capitals","Blaze","Pioneers","Titans","Phoenix","Vipers","Cyclones","Renegades","Thunder","Panthers","Spartans","Barracudas","Hurricanes","Scorpions","Bombers","Sharks","Jaguars","Thunderbirds","Cougars","Lightning","Tigers","Raptors","Cheetahs","Vikings","Raiders","Gators","Dragons","Rockets","Knights","Stallions","Eagles","Wolves","Bulldogs","Ravens","Warriors","Hawks","Condors","Pumas","Suns","Rhinos","Kings","Lions","Cobra","Sabres","Storm","Comets"};

	/**
	 * Array of player names
	 */
	public static String[] playerNames = {"Sean","Oscar","Jack","Adam", "Aidan", "Andrew", "Austin", "Brandon", "Bradley", "Bryce", "Caleb", "Cameron", "Chase", "Christian", "Christopher", "Cole", "Connor", "Daniel", "David", "Derek", "Derrick", "Devin","Ryan", "Dylan", "Ethan", "Gabriel", "Gavin", "Gregory", "Isaac", "Jacob", "Jalen", "Jamal", "James", "Jason", "Jaxon", "Jayden", "Jeremiah", "John", "Jonathan", "Jordan", "Josiah", "Julian", "Justin", "Kai", "Kendrick", "Kenny", "Kevin", "Kyle", "Landon", "Luke", "Marcus", "Mason", "Matthew", "Michael", "Miles", "Nathan", "Nicholas", "Noah", "Omar","Jim","Troy","William"};

	/**
	 * Label for the opponent team's right defender's offensive stat
	 */
	public static JLabel rightDefenderOffenceLabelOppoenent;

	/**
	 * Label for the opponent team's right defender's defensive stat
	 */
	public static JLabel rightDefenderDefenceLabelOppoennt;

	/**
	 * Label for the opponent team's right defender's stamina stat
	 */
	public static JLabel rightDefenceStaminaLabelOppoennt;

	/**
	 * Label for the opponent team's right defender's position
	 */
	public static JLabel playerPositionRightDefenderOppoennt;

	/**
	 * Label for the opponent team's right defender's name
	 */
	public static JLabel rightDefenderNameLabelOppoenent;

	/**
	 * Label for the opponent team's striker's position
	 */
	public static JLabel PlayerPositionSrickerOppoenent;

	/**
	 * Label for the opponent team's striker's name
	 */
	public static JLabel nameOfStrickerOpponent;

	/**
	 * Label for the opponent team's striker's defensive stat
	 */
	public static JLabel strickerDefenceLabelOppoennt;

	/**
	 * Label for the opponent team's striker's offensive stat
	 */
	public static JLabel strickerOffencePlayersOppoennt;

	/**
	 * Label for the opponent team's left defender
	 */
	public static JLabel myLeftdefenderObjectOppoennt;

	/**
	 * Label for the opponent team's right defender's position
	 */
	public static JLabel rightDefenderPositionLabelOppoennt;

	/**
	 * Label for the opponent team's left defender's offensive stat
	 */
	public static JLabel leftDefenceOffenceLabelOpponent;

	/**
	 * Label for the opponent team's left defender's defensive stat
	 */
	public static JLabel LeftDefenceDefencePlayersOppoenent;

	/**
	 * Label for the opponent team's left defender's stamina stat
	 */
	public static JLabel leftDefenceStaminaLabelOppoenent;

	/**
	 * Label for the opponent team's left defender's name
	 */
	public static JLabel nameOfLeftDefenderOppoenent;

	/**
	 * Label for the opponent team's goalkeeper's offensive stat
	 */
	public static JLabel goallyKeeperOffencePlayersOppoent;

	/**
	 * Label for the opponent team's goalkeeper's defensive stat
	 */
	public static JLabel goalKeeperDefencePlayersOppoennt;

	/**
	 * Label for the opponent team's goalkeeper's stamina stat
	 */
	public static JLabel goalKeeperStaminaPlayersOpponent;

	/**
	 * Label for the opponent team's goalkeeper's position
	 */
	public static JLabel playerPositionnGoallyOppoennt;

	/**
	 * Label for the opponent team's goalkeeper's name
	 */
	public static JLabel nameOfGoallyOppoennt;

	/**
	 * Label for the opponent team's goalkeeper's reflex stat
	 */
	public static JLabel goalKeeperReflexPlayersOpponent;

	/**
	 * Label for the opponent team's left defender's name
	 */
	public static JLabel oppoenentLeftDefenderName;

	/**
	 * Label for the opponent team's striker's name
	 */
	public static JLabel oppoenentStrickerName;

	/**
	 * Label for the opponent team's right defender's name
	 */
	public static JLabel oppoenentRightDefenderName;

	/**
	 * Label for the opponent team's goalkeeper's name
	 */
	public static JLabel oppoenentGoallyName;

	/**
	 * Panel to display result strip for my team's goalkeeper
	 */
	public static JPanel resultStripForMyGoalKeeper;

	/**
	 * Panel to display result strip for my team's right defender
	 */
	public static JPanel resultStripForMyRightDefender;

	/**
	 * Panel to display result strip for my team's attacker
	 */
	public static JPanel resultStripForMyAttacker;

	/**
	 * Panel to display result strip for my team's left defender
	 */
	public static JPanel resultStripForMyLeftDefender;

	/**
	 * Panel to display result strip for opponent team's attacker
	 */
	public static JPanel resultStripForOppoenentAttacker;

	/**
	 * Panel to display result strip for opponent team's right defender
	 */
	public static JPanel resultStripForOpponentRightDefender;

	/**
	 * Panel to display result strip for opponent team's left defender
	 */
	public static JPanel resultStripForOpponentLeftDefender;

	/**
	 * Panel to display result strip for opponent team's goalkeeper
	 */
	public static JPanel resultStripForOppoenentGoalKeeper;

	/**
	 * List to store used team name indexes
	 */
	public static ArrayList<Integer> usedTeamNamesIndex = new ArrayList<Integer>();

	/**
	 * List to store used player name indexes
	 */
	public static ArrayList<Integer> usedPlayerNamesIndex = new ArrayList<Integer>();

	/**
	 * Label to display the result strip for my team's goalkeeper
	 */
	public static JLabel resultStripForMyGoally;

	/**
	 * Label to display the result strip for my team's right defender
	 */
	
	/**
	 * List to store used player name indexes
	 */
	public static ArrayList<Integer> usedTeamPlayerNamesIndex = new ArrayList<Integer>();

	/**
	 * List to store opponent team players
	 */
	public static ArrayList<Player> opponent_player = new ArrayList<Player>();

	/**
	 * Index for the next player name
	 */
	private static int nextPlayerName;

	/**
	 * Damage taken on winning the match
	 */
	public static int damageTakenOnWin;

	/**
	 * Damage taken on losing the match
	 */
	public static int damageTakenOnLoss;

	/**
	 * Damage given on a Draw the match
	 */
	public static int damageTakenOnDraw;

	/**
	 * Outcome screen for displaying game outcome
	 */
	public static OutcomeScreen gameOutcomeScreen;

	/**
	 * Outcome screen for displaying game outcome
	 */
	public static EndGameScreen gameEnd;

	
	/**
	 * Constructor used to set the damgeTaken values
	 */
	public TheGameScreen() {
		initialize();
		  
		// Initialize outcome screen and hide it
		gameOutcomeScreen = new OutcomeScreen();
		gameOutcomeScreen.frame.setVisible(false);
		
		// Initialize end game screen and hide it
		gameEnd = new EndGameScreen();
		gameEnd.frame.setVisible(false);
		
		// Set damage values based on game difficulty
		if(GameMenu.difficulty == 1) {
			damageTakenOnWin = 15;
			damageTakenOnLoss = 25;
			damageTakenOnDraw = 20;
		}  
		if(GameMenu.difficulty == 2) {
			damageTakenOnWin = 20;
			damageTakenOnLoss = 35; 
			damageTakenOnDraw = 25;
		}
		if(GameMenu.difficulty == 3) {
			damageTakenOnWin = 25;
			damageTakenOnLoss = 35;
			damageTakenOnDraw = 30;
		}
	}

	

	
	/**
	 *  generates random numbers
	 * @param maxValue is provided to the randomNumbeGenerator depending on which method is calling this method.
	 * @return a randomNumber Used by several methods for different purposes.
	 */
	public static int randomNumbeGenerator(int maxValue)
	{
		Random rando = new Random();
		return rando.nextInt(maxValue);
	}
		
	/**
	 * Sets the stat for a particular player
	 * @param currentValue is the stat of the player 
	 * @param maxValue is the max amount the player stat can be
	 * @return the stat value generated randomly
	 */
	public static int cappedStat(int currentValue ,int maxValue)
	{
		// Cap the current value if it exceeds the maximum value
		int maxxer = 0;
		while (currentValue >= 100 && currentValue < 20)
		{
			maxxer = randomNumbeGenerator(maxValue - 50) + 40;
		}
		return maxxer;
	}

	/**
	 * Generates a random player index that has not been used before.
	 * 
	 * @param currentIndex The current index of the player.
	 * @param maxPlayerIndex  The maximum index value for players.
	 * @return The next available player index.
	 */
	public static int usedPlayerIndex(int currentIndex ,int maxPlayerIndex)
	{
		// Generate a random player index that has not been used before
		nextPlayerName = randomNumbeGenerator(maxPlayerIndex);
		while (usedTeamPlayerNamesIndex.contains(nextPlayerName))
		{
			nextPlayerName = randomNumbeGenerator(maxPlayerIndex);
		}
		return nextPlayerName;
	}

	/**
	 * the following code updates the updates the displays of the oppoenent and the player squad 
	 * using help functions to recaculate the stats of the oppoenents and set up the stats both the teams. 
	 * it is a static function that gets called by stadium class prior to the intiation of the game. 
	 */
	public static void updated_playing_players()
	{
		// Update the playing players' attributes and display information
		
		// Update opponent players' attributes
		nextPlayerName = randomNumbeGenerator(maxPlayerIndex);
		nextPlayerName = usedPlayerIndex(nextPlayerName , maxPlayerIndex);
		opponentPlayerStricker.setName(playerNames[nextPlayerName]); 
		usedTeamPlayerNamesIndex.add(nextPlayerName);
		
		nextPlayerName = randomNumbeGenerator(maxPlayerIndex);
		nextPlayerName = usedPlayerIndex(nextPlayerName , maxPlayerIndex);
		opponentPlayerRightDefender.setName(playerNames[nextPlayerName]);
		usedTeamPlayerNamesIndex.add(nextPlayerName);
		
		nextPlayerName = randomNumbeGenerator(maxPlayerIndex);
		nextPlayerName = usedPlayerIndex(nextPlayerName , maxPlayerIndex);
		opponentPlayerLeftDefender.setName(playerNames[nextPlayerName]);
		usedTeamPlayerNamesIndex.add(nextPlayerName);
		
		nextPlayerName = randomNumbeGenerator(maxPlayerIndex);
		nextPlayerName = usedPlayerIndex(nextPlayerName , maxPlayerIndex);
		opponentPlayerGoalKeeper.setName(playerNames[nextPlayerName]);
		usedTeamPlayerNamesIndex.add(nextPlayerName);
		
		opponentTeam.setOpponentTeamName(Stadium.chosenTeam);
		opponentTeamName.setText("TEAM: "+opponentTeam.getOpponentTeamName());
		
		for(Player player: opponentTeam.opponents)
		{ 
			int currentStamian = ((Player) player).stamina();
			if (currentStamian >= 100)
			{
				currentStamian = cappedStat(currentStamian, 100);
			}
			int currentDefence = ((Player) player).defence();
			if(currentDefence >= 100)
			{
				currentDefence = cappedStat(currentDefence, 100);
			}
			int currentOffence = ((Player) player).offense();
			if(currentOffence >= 100)
			{
				currentOffence = cappedStat(currentOffence, 100);
			}
			
			((Player) player).setStamina(currentStamian + randomNumbeGenerator(GameMenu.difficultyIncreasePerWeek));
			((Player) player).setDefence(currentDefence + randomNumbeGenerator(GameMenu.difficultyIncreasePerWeek));
			((Player) player).setOffense(currentOffence + randomNumbeGenerator(GameMenu.difficultyIncreasePerWeek));
			
			if (player.getPosition() == "goal keeper")
			{
				int currentReflex = ((Player) player).goalKeeperReflex();
				((Player) player).setPlayerreflex(currentReflex + randomNumbeGenerator(GameMenu.difficultyIncreasePerWeek));
			}
		}
		
		// Update player information labels for the playing team
		for (Object player: ClubRoom.playingFour)
		{
			if(((Player) player).getPosition() == "left defender")
			{
				myLeftdefenderObject = (Player) player;
			}
			if(((Player) player).getPosition() == "right defender")
			{
				myRightdefenderObject = (Player) player;
			}
			if(((Player) player).getPosition() == "goal keeper")
			{
				myGoalkeeperObject = (Player) player;
			}
			if(((Player) player).getPosition() == "attacker")
			{
				myStrickerObject  = (Player) player;
			}
		}
		
		rightDefenderOffenceLabel.setText("Offence: " + ((Player) myRightdefenderObject).offense());
		rightDefenderDefenceLabel.setText("Defence: " +((Player) myRightdefenderObject).defence() );
		rightDefenceStaminaLabel.setText("Stamina: "+ ((Player) myRightdefenderObject).stamina());
		rightDefenderPositionLabel.setText("Position: "+ ((Player) myRightdefenderObject).getPosition());
		rightDefenderNameLabel.setText("Name: "+((Player) myRightdefenderObject).getName());
		
		StrickerOffencePlayers.setText("Offence: "+((Player) myStrickerObject).offense());
		strickerDefenceLabel.setText("Defence: "+((Player) myStrickerObject).defence());
		strickerStaminaPlayers.setText("Stamina: "+((Player) myStrickerObject).stamina());
		playerPositiponStricker.setText("Position: "+((Player) myStrickerObject).getPosition());
		nameOfStricker.setText("Name: "+((Player) myStrickerObject).getName());
		
		goallyOffenceLabel.setText("Offence: "+((Player) myGoalkeeperObject).offense());
		goallyDefencePlayers.setText("Defence: "+((Player) myGoalkeeperObject).defence());
		goallyStaminaLabel.setText("Stamina: " + ((Player) myGoalkeeperObject).stamina());
		goalPositionLabel.setText("Position: "+((Player) myGoalkeeperObject).getPosition());
		nameOfGoally.setText("Name: "+ ((Player) myGoalkeeperObject).getName());
		goalKeeperReflexPlayers.setText("reflex: "+((Player) myGoalkeeperObject).goalKeeperReflex());
		
		leftDefenceOffenceLabel.setText("Offence: "+((Player) myLeftdefenderObject).offense());
		LeftDefenceDefencePlayers.setText("Defence: "+((Player) myLeftdefenderObject).defence());
		leftDefenceStaminaLabel.setText("Stamina: "+((Player) myLeftdefenderObject).stamina());
		nameOfLeftDefender.setText("Name: "+((Player) myLeftdefenderObject).getName());
		playerPositionLeftDefender.setText("Position:"+((Player) myLeftdefenderObject).getPosition());
		
		myGoallyName.setText("Name: "+((Player) myGoalkeeperObject).getName());
		myLeftDefenderName.setText("Name: "+((Player) myLeftdefenderObject).getName());
		myStrickerName.setText("Name: "+((Player) myStrickerObject).getName());
		myRightDefenderName.setText("Name: "+((Player) myRightdefenderObject).getName());
		
		// Update opponent player information labels
		PlayerPositionSrickerOppoenent.setText("Position: "+((Player) opponentPlayerStricker).getPosition());
		nameOfStrickerOpponent.setText("Name: "+((Player) opponentPlayerStricker).getName());
		strickerDefenceLabelOppoennt.setText("Defence: "+((Player) opponentPlayerStricker).defence());
		strickerOffencePlayersOppoennt.setText("Offence: "+((Player) opponentPlayerStricker).offense());
		myLeftdefenderObjectOppoennt.setText("Stamina: "+((Player) opponentPlayerStricker).stamina());
		
		goallyKeeperOffencePlayersOppoent.setText("Offence: "+((Player) opponentPlayerGoalKeeper).offense());
		goalKeeperDefencePlayersOppoennt.setText("Defence: "+((Player) opponentPlayerGoalKeeper).defence());
		goalKeeperStaminaPlayersOpponent.setText("Stamina: "+((Player) opponentPlayerGoalKeeper).stamina());
		playerPositionnGoallyOppoennt.setText("Position: "+((Player) opponentPlayerGoalKeeper).getPosition());
		nameOfGoallyOppoennt.setText("Name: "+((Player) opponentPlayerGoalKeeper).getName());
		
		rightDefenderOffenceLabelOppoenent.setText("Offence: "+((Player) opponentPlayerRightDefender).offense());
		rightDefenderDefenceLabelOppoennt.setText("Defence: "+((Player) opponentPlayerRightDefender).defence());
		rightDefenceStaminaLabelOppoennt.setText("Stamina: "+((Player) opponentPlayerRightDefender).stamina());
		playerPositionRightDefenderOppoennt.setText("Position:"+((Player) opponentPlayerRightDefender).getPosition());
		rightDefenderNameLabelOppoenent.setText("Name: "+((Player) opponentPlayerRightDefender).getName());
		
		rightDefenderPositionLabelOppoennt.setText("Position: "+((Player) opponentPlayerLeftDefender).getPosition());
		leftDefenceOffenceLabelOpponent.setText("Offence: "+((Player) opponentPlayerLeftDefender).offense());
		LeftDefenceDefencePlayersOppoenent.setText("Defence: "+((Player) opponentPlayerLeftDefender).defence());
		leftDefenceStaminaLabelOppoenent.setText("Stamina: "+((Player) opponentPlayerLeftDefender).stamina());
		nameOfLeftDefenderOppoenent.setText("Name: "+((Player) opponentPlayerLeftDefender).getName());
		
		oppoenentStrickerName.setText("Name: "+((Player) opponentPlayerStricker).getName());
		oppoenentRightDefenderName.setText("Name: "+((Player) opponentPlayerRightDefender).getName());
		oppoenentLeftDefenderName.setText("Name: "+((Player) opponentPlayerLeftDefender).getName());
		oppoenentGoallyName.setText("Name: "+((Player) opponentPlayerGoalKeeper).getName());
		goalKeeperReflexPlayersOpponent.setText("reflex "+((Player) opponentPlayerGoalKeeper).goalKeeperReflex());
	}
	/**
	 * generators random stats for the opponent player
	 * based off the difficulty chosen by the player
	 * which is accessed through the GameMenu class
	 * @return random
	 */
	private int randomIntialStatGenerator()
	{
		Random randomStat = new Random();
		int returnStat = 0;
		if (GameMenu.difficulty == 1)
		{
			// Generates a random stat value between 25 and 34 for easy difficulty.
			returnStat = randomStat.nextInt(10) + 25;
		}
		if (GameMenu.difficulty == 2)
		{
			// Generates a random stat value between 23 and 32 for medium difficulty.
			returnStat = randomStat.nextInt(10) + 23;
		}
		if (GameMenu.difficulty == 3)
		{
			// Generates a random stat value between 18 and 27 for hard difficulty.
			returnStat = randomStat.nextInt(10) + 18;
		}
		return returnStat;
	}

	/**
	 * Initialize the opponent and player athletes for the game
	 * along with the game frame, labels, buttons used in the game.
	 */
	public void initialize() {
		
		opponentTeam = new Team();
		
		// 
		myLeftdefenderObject = new Player(0,0,0,0,"","",false,false);
		myRightdefenderObject = new Player(0,0,0,0,"","",false,false);
		myGoalkeeperObject = new Player(0,0,0,0,"","",false,false);
		myStrickerObject = new Player(0,0,0,0,"","",false,false);
		
		
		opponentPlayerStricker = new Player(0,0,0,"","attacker",false,false);
		opponentPlayerRightDefender = new Player(0,0,0,"","right defender",false,false);
		opponentPlayerLeftDefender = new Player(0,0,0,"","left defender",false,false);
		opponentPlayerGoalKeeper = new Player(0,0,0,"","goal keeper",false,false);
		

		opponentTeam.opponents.add(opponentPlayerGoalKeeper);
		opponentTeam.opponents.add(opponentPlayerLeftDefender);
		opponentTeam.opponents.add(opponentPlayerRightDefender);
		opponentTeam.opponents.add(opponentPlayerStricker);
		
		for(Team player: opponentTeam.opponents)
		{
			
			((Player) player).setStamina(randomIntialStatGenerator());
			((Player) player).setDefence(randomIntialStatGenerator());
			((Player) player).setOffense(randomIntialStatGenerator());
			if (((Player) player).getPosition() == "goal keeper")
			{
				((Player) player).setPlayerreflex(randomIntialStatGenerator());
			}
	
		}
		
		for( Object player: ClubRoom.playingFour)
		{
			if(((Player) player).getPosition() == "left defender")
			{
				myLeftdefenderObject = (Player) player;
			}
			if(((Player) player).getPosition() == "right defender")
			{
				myRightdefenderObject = (Player) player;
			}
			if(((Player) player).getPosition() == "goal keeper")
			{
				myGoalkeeperObject = (Player) player;
			}
			if(((Player) player).getPosition() == "attacker")
			{
				myStrickerObject  = (Player) player;
			}
		}
		
		gameFrame = new JFrame();
		gameFrame.setBounds(100, 100, 1046, 664);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel matchScreen = new JPanel();
		
		JPanel mySideOfField = new JPanel();
		
		JPanel myAttackerCard = new JPanel();
		myAttackerCard.setBackground(Color.LIGHT_GRAY);
		
		JPanel positonar3 = new JPanel();
		
		JPanel myGoallyCard = new JPanel();
		myGoallyCard.setBackground(Color.LIGHT_GRAY);
		
		JPanel positioner = new JPanel();
		
		JPanel positioner2 = new JPanel();
		
		JPanel positioner1 = new JPanel();
		
		JPanel myRightFefenderCard = new JPanel();
		myRightFefenderCard.setBackground(Color.LIGHT_GRAY);
		
		JPanel myLeftDefenderCard = new JPanel();
		myLeftDefenderCard.setBackground(Color.LIGHT_GRAY);
		
		JPanel positioner5 = new JPanel();
		GroupLayout glMySideOfField = new GroupLayout(mySideOfField);
		glMySideOfField.setHorizontalGroup(
			glMySideOfField.createParallelGroup(Alignment.TRAILING)
				.addGroup(glMySideOfField.createSequentialGroup()
					.addGap(20)
					.addGroup(glMySideOfField.createParallelGroup(Alignment.TRAILING)
						.addComponent(positonar3, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
						.addComponent(myGoallyCard, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
						.addComponent(positioner2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
					.addGroup(glMySideOfField.createParallelGroup(Alignment.LEADING)
						.addGroup(glMySideOfField.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(myRightFefenderCard, GroupLayout.PREFERRED_SIZE, 115, Short.MAX_VALUE))
						.addGroup(glMySideOfField.createSequentialGroup()
							.addGap(8)
							.addGroup(glMySideOfField.createParallelGroup(Alignment.LEADING)
								.addComponent(myLeftDefenderCard, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
								.addComponent(positioner, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glMySideOfField.createParallelGroup(Alignment.TRAILING)
						.addComponent(myAttackerCard, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
						.addComponent(positioner1, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
						.addComponent(positioner5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
		);
		glMySideOfField.setVerticalGroup(
			glMySideOfField.createParallelGroup(Alignment.LEADING)
				.addGroup(glMySideOfField.createSequentialGroup()
					.addGap(22)
					.addGroup(glMySideOfField.createParallelGroup(Alignment.TRAILING)
						.addComponent(myLeftDefenderCard, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
						.addComponent(positioner5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
						.addComponent(positonar3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glMySideOfField.createParallelGroup(Alignment.TRAILING)
						.addComponent(myAttackerCard, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
						.addComponent(positioner, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
						.addComponent(myGoallyCard, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glMySideOfField.createParallelGroup(Alignment.LEADING)
						.addComponent(positioner2, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
						.addComponent(positioner1, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
						.addComponent(myRightFefenderCard, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
					.addGap(26))
		);
		
		rightDefenderOffenceLabel = new JLabel("Offence: " + ((Player) myRightdefenderObject).offense());
		rightDefenderDefenceLabel = new JLabel("Defence: " +((Player) myRightdefenderObject).defence() );
		rightDefenceStaminaLabel = new JLabel("Stamina: "+ ((Player) myRightdefenderObject).stamina());
		rightDefenderPositionLabel = new JLabel("Position: "+ ((Player) myRightdefenderObject).getPosition());
		rightDefenderNameLabel = new JLabel("Name: "+((Player) myRightdefenderObject).getName());
		
		resultStripForMyRightDefender = new JPanel();
		
		GroupLayout glMyRightDefenderCard = new GroupLayout(myRightFefenderCard);
		glMyRightDefenderCard.setHorizontalGroup(
			glMyRightDefenderCard.createParallelGroup(Alignment.TRAILING)
				.addGroup(glMyRightDefenderCard.createSequentialGroup()
					.addGroup(glMyRightDefenderCard.createParallelGroup(Alignment.LEADING)
						.addComponent(rightDefenderPositionLabel, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
						.addComponent(rightDefenderOffenceLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
						.addComponent(rightDefenderDefenceLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
						.addComponent(rightDefenceStaminaLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
						.addComponent(rightDefenderNameLabel, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
						.addGroup(glMyRightDefenderCard.createSequentialGroup()
							.addContainerGap()
							.addComponent(resultStripForMyRightDefender, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		glMyRightDefenderCard.setVerticalGroup(
			glMyRightDefenderCard.createParallelGroup(Alignment.TRAILING)
				.addGroup(glMyRightDefenderCard.createSequentialGroup()
					.addContainerGap()
					.addComponent(resultStripForMyRightDefender, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(rightDefenderNameLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rightDefenderPositionLabel, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rightDefenderOffenceLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rightDefenderDefenceLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rightDefenceStaminaLabel)
					.addContainerGap())
		);
		myRightFefenderCard.setLayout(glMyRightDefenderCard);
		
		StrickerOffencePlayers = new JLabel("Offence: "+((Player) myStrickerObject).offense());
		strickerDefenceLabel = new JLabel("Defence: "+((Player) myStrickerObject).defence());
		strickerStaminaPlayers = new JLabel("Stamina: "+((Player) myStrickerObject).stamina());
		playerPositiponStricker = new JLabel("Position: "+((Player) myStrickerObject).getPosition());
		nameOfStricker = new JLabel("Name: "+((Player) myStrickerObject).getName());
		
		resultStripForMyAttacker = new JPanel();
		
		GroupLayout glMyAttackerCard = new GroupLayout(myAttackerCard);
		glMyAttackerCard.setHorizontalGroup(
			glMyAttackerCard.createParallelGroup(Alignment.LEADING)
				.addGroup(glMyAttackerCard.createSequentialGroup()
					.addGroup(glMyAttackerCard.createParallelGroup(Alignment.LEADING)
						.addComponent(StrickerOffencePlayers, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addComponent(strickerDefenceLabel, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addComponent(strickerStaminaPlayers, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addGroup(glMyAttackerCard.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(playerPositiponStricker, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(nameOfStricker, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
						.addGroup(glMyAttackerCard.createSequentialGroup()
							.addContainerGap()
							.addComponent(resultStripForMyAttacker, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		glMyAttackerCard.setVerticalGroup(
			glMyAttackerCard.createParallelGroup(Alignment.TRAILING)
				.addGroup(glMyAttackerCard.createSequentialGroup()
					.addContainerGap()
					.addComponent(resultStripForMyAttacker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addComponent(nameOfStricker)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(playerPositiponStricker)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(StrickerOffencePlayers)
					.addGap(6)
					.addComponent(strickerDefenceLabel)
					.addGap(6)
					.addComponent(strickerStaminaPlayers)
					.addContainerGap())
		);
		myAttackerCard.setLayout(glMyAttackerCard);
		
		goallyOffenceLabel = new JLabel("Offence: "+((Player) myGoalkeeperObject).offense());
		goallyDefencePlayers = new JLabel("Defence: "+((Player) myGoalkeeperObject).defence());
		goallyStaminaLabel = new JLabel("Stamina: " + ((Player) myGoalkeeperObject).stamina());
		goalPositionLabel = new JLabel("Position: "+((Player) myGoalkeeperObject).getPosition());
		nameOfGoally = new JLabel("Name: "+ ((Player) myGoalkeeperObject).getName());
		
		resultStripForMyGoalKeeper = new JPanel();
		resultStripForMyGoalKeeper.setBackground(new Color(255, 255, 255));
		
		goalKeeperReflexPlayers = new JLabel("reflex: ");
		
		GroupLayout glMyGoallyCard = new GroupLayout(myGoallyCard);
		glMyGoallyCard.setHorizontalGroup(
			glMyGoallyCard.createParallelGroup(Alignment.LEADING)
				.addGroup(glMyGoallyCard.createSequentialGroup()
					.addGroup(glMyGoallyCard.createParallelGroup(Alignment.LEADING)
						.addGroup(glMyGoallyCard.createSequentialGroup()
							.addGap(10)
							.addComponent(resultStripForMyGoalKeeper, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
						.addComponent(nameOfGoally, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(goalPositionLabel, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(goallyOffenceLabel, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(goallyDefencePlayers, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(goallyStaminaLabel, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(goalKeeperReflexPlayers, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		glMyGoallyCard.setVerticalGroup(
			glMyGoallyCard.createParallelGroup(Alignment.LEADING)
				.addGroup(glMyGoallyCard.createSequentialGroup()
					.addContainerGap()
					.addComponent(resultStripForMyGoalKeeper, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(nameOfGoally)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(goalPositionLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(goallyOffenceLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(goallyDefencePlayers)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(goallyStaminaLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(goalKeeperReflexPlayers)
					.addContainerGap())
		);
		myGoallyCard.setLayout(glMyGoallyCard);
		
		leftDefenceOffenceLabel = new JLabel("Offence: ");
		LeftDefenceDefencePlayers = new JLabel("Defence: ");
		leftDefenceStaminaLabel = new JLabel("Stamina: ");
		nameOfLeftDefender = new JLabel("Name: ");
		playerPositionLeftDefender = new JLabel("Position:");
		
		resultStripForMyLeftDefender = new JPanel();
		
		GroupLayout glMyLeftDefenderCard = new GroupLayout(myLeftDefenderCard);
		glMyLeftDefenderCard.setHorizontalGroup(
			glMyLeftDefenderCard.createParallelGroup(Alignment.LEADING)
				.addGroup(glMyLeftDefenderCard.createSequentialGroup()
					.addGroup(glMyLeftDefenderCard.createParallelGroup(Alignment.LEADING)
						.addComponent(nameOfLeftDefender, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
						.addGroup(glMyLeftDefenderCard.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(playerPositionLeftDefender, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(leftDefenceOffenceLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
							.addComponent(LeftDefenceDefencePlayers, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
							.addComponent(leftDefenceStaminaLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
						.addGroup(glMyLeftDefenderCard.createSequentialGroup()
							.addContainerGap()
							.addComponent(resultStripForMyLeftDefender, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		glMyLeftDefenderCard.setVerticalGroup(
			glMyLeftDefenderCard.createParallelGroup(Alignment.TRAILING)
				.addGroup(glMyLeftDefenderCard.createSequentialGroup()
					.addContainerGap()
					.addComponent(resultStripForMyLeftDefender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addComponent(nameOfLeftDefender)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(playerPositionLeftDefender)
					.addGap(5)
					.addComponent(leftDefenceOffenceLabel)
					.addGap(6)
					.addComponent(LeftDefenceDefencePlayers)
					.addGap(6)
					.addComponent(leftDefenceStaminaLabel)
					.addContainerGap())
		);
		myLeftDefenderCard.setLayout(glMyLeftDefenderCard);
		mySideOfField.setLayout(glMySideOfField);
		gameFrame.getContentPane().add(matchScreen, "name_2004573808479600");
		
		JScrollPane resultsLayout = new JScrollPane();
		
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(100,100));
		resultsLayout.setViewportView(panel1);
		
		myTeamNameLabel = new JLabel("TEAM: "+GameMenu.team);
		myTeamNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		myTeamNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		
		JLabel lblNewLabel14 = new JLabel("-");
		lblNewLabel14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel14.setFont(new Font("Tahoma", Font.PLAIN, 73));
		
		opponentTeamName = new JLabel("TEAM: "+GameMenu.team);
		opponentTeamName.setHorizontalAlignment(SwingConstants.CENTER);
		opponentTeamName.setFont(new Font("Tahoma", Font.PLAIN, 32));
		
		myTeamCurrentScoreDisplay = new JLabel("0");
		opponentCurrentScoreDisplay = new JLabel("0");
		
		myTeamCurrentScoreDisplay.setHorizontalAlignment(SwingConstants.LEFT);
		myTeamCurrentScoreDisplay.setFont(new Font("Tahoma", Font.PLAIN, 73));
		
		
		opponentCurrentScoreDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		opponentCurrentScoreDisplay.setFont(new Font("Tahoma", Font.PLAIN, 73));
		GroupLayout glPanel1 = new GroupLayout(panel1);
		glPanel1.setHorizontalGroup(
			glPanel1.createParallelGroup(Alignment.TRAILING)
				.addGroup(glPanel1.createSequentialGroup()
					.addGap(78)
					.addComponent(myTeamNameLabel, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
					.addGap(39)
					.addComponent(myTeamCurrentScoreDisplay, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel14, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(opponentCurrentScoreDisplay, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(opponentTeamName, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
					.addGap(49))
		);
		glPanel1.setVerticalGroup(
			glPanel1.createParallelGroup(Alignment.LEADING)
				.addGroup(glPanel1.createSequentialGroup()
					.addGap(2)
					.addGroup(glPanel1.createParallelGroup(Alignment.LEADING)
						.addGroup(glPanel1.createSequentialGroup()
							.addComponent(opponentTeamName, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
							.addGap(23))
						.addGroup(glPanel1.createParallelGroup(Alignment.BASELINE)
							.addComponent(opponentCurrentScoreDisplay, GroupLayout.PREFERRED_SIZE, 62, Short.MAX_VALUE)
							.addComponent(lblNewLabel14, GroupLayout.PREFERRED_SIZE, 62, Short.MAX_VALUE)
							.addComponent(myTeamCurrentScoreDisplay, GroupLayout.PREFERRED_SIZE, 62, Short.MAX_VALUE))
						.addComponent(myTeamNameLabel))
					.addGap(136))
		);
		panel1.setLayout(glPanel1);
		
		JScrollPane playervsplayerDisplay = new JScrollPane();
		
		JPanel oppoenentSideOfField = new JPanel();
		
		JPanel positonar31 = new JPanel();
		
		JPanel positioner21 = new JPanel();
		
		JPanel oppoenentStrikerCard = new JPanel();
		oppoenentStrikerCard.setBackground(Color.LIGHT_GRAY);
		
		PlayerPositionSrickerOppoenent = new JLabel("Position: ");
		nameOfStrickerOpponent = new JLabel("Name:");
		strickerDefenceLabelOppoennt = new JLabel("Defence: ");
		strickerOffencePlayersOppoennt = new JLabel("Offence: ");
		myLeftdefenderObjectOppoennt = new JLabel("Stamina: ");
		
		resultStripForOppoenentAttacker = new JPanel();
		GroupLayout gl_oppoenentStrikerCard = new GroupLayout(oppoenentStrikerCard);
		gl_oppoenentStrikerCard.setHorizontalGroup(
			gl_oppoenentStrikerCard.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_oppoenentStrikerCard.createSequentialGroup()
					.addGroup(gl_oppoenentStrikerCard.createParallelGroup(Alignment.TRAILING)
						.addComponent(PlayerPositionSrickerOppoenent, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
						.addComponent(nameOfStrickerOpponent, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
						.addComponent(strickerDefenceLabelOppoennt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
						.addComponent(strickerOffencePlayersOppoennt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
						.addComponent(myLeftdefenderObjectOppoennt, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
					.addGap(8))
				.addGroup(Alignment.LEADING, gl_oppoenentStrikerCard.createSequentialGroup()
					.addContainerGap()
					.addComponent(resultStripForOppoenentAttacker, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
		);
		gl_oppoenentStrikerCard.setVerticalGroup(
			gl_oppoenentStrikerCard.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_oppoenentStrikerCard.createSequentialGroup()
					.addContainerGap()
					.addComponent(resultStripForOppoenentAttacker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addComponent(nameOfStrickerOpponent)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(PlayerPositionSrickerOppoenent)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(strickerOffencePlayersOppoennt)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(strickerDefenceLabelOppoennt)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(myLeftdefenderObjectOppoennt)
			 		.addContainerGap())
		);
		oppoenentStrikerCard.setLayout(gl_oppoenentStrikerCard);
		
		JPanel oppoenntLeftDefenderCard = new JPanel();
		oppoenntLeftDefenderCard.setBackground(Color.LIGHT_GRAY);
		
		rightDefenderPositionLabelOppoennt = new JLabel("Position: ");
		leftDefenceOffenceLabelOpponent = new JLabel("Offence: ");
		LeftDefenceDefencePlayersOppoenent = new JLabel("Defence: ");
		leftDefenceStaminaLabelOppoenent = new JLabel("Stamina: ");
		nameOfLeftDefenderOppoenent = new JLabel("Name:");
		
		resultStripForOpponentLeftDefender = new JPanel();
		GroupLayout gl_oppoenntLeftDefenderCard = new GroupLayout(oppoenntLeftDefenderCard);
		gl_oppoenntLeftDefenderCard.setHorizontalGroup(
			gl_oppoenntLeftDefenderCard.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_oppoenntLeftDefenderCard.createSequentialGroup()
					.addGroup(gl_oppoenntLeftDefenderCard.createParallelGroup(Alignment.LEADING)
						.addComponent(rightDefenderPositionLabelOppoennt, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
						.addComponent(leftDefenceOffenceLabelOpponent, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
						.addComponent(LeftDefenceDefencePlayersOppoenent, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
						.addComponent(leftDefenceStaminaLabelOppoenent, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
						.addComponent(nameOfLeftDefenderOppoenent, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
						.addGroup(gl_oppoenntLeftDefenderCard.createSequentialGroup()
							.addContainerGap()
							.addComponent(resultStripForOpponentLeftDefender, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_oppoenntLeftDefenderCard.setVerticalGroup(
			gl_oppoenntLeftDefenderCard.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_oppoenntLeftDefenderCard.createSequentialGroup()
					.addContainerGap()
					.addComponent(resultStripForOpponentLeftDefender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(nameOfLeftDefenderOppoenent)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rightDefenderPositionLabelOppoennt, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(leftDefenceOffenceLabelOpponent)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(LeftDefenceDefencePlayersOppoenent)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(leftDefenceStaminaLabelOppoenent)
					.addContainerGap())
		);
		oppoenntLeftDefenderCard.setLayout(gl_oppoenntLeftDefenderCard);
		
		JPanel positioner22 = new JPanel();
		
		JPanel opponentRightDefenderCard = new JPanel();
		opponentRightDefenderCard.setBackground(Color.LIGHT_GRAY);
		rightDefenderOffenceLabelOppoenent = new JLabel("Offence: ");
		rightDefenderDefenceLabelOppoennt = new JLabel("Defence: ");
		rightDefenceStaminaLabelOppoennt = new JLabel("Stamina: ");
		playerPositionRightDefenderOppoennt = new JLabel("Position:");
		rightDefenderNameLabelOppoenent = new JLabel("Name: ");
		
		resultStripForOpponentRightDefender = new JPanel();
		
		
		
		GroupLayout glOpponentRightDefenderCard = new GroupLayout(opponentRightDefenderCard);
		glOpponentRightDefenderCard.setHorizontalGroup(
			glOpponentRightDefenderCard.createParallelGroup(Alignment.LEADING)
				.addGroup(glOpponentRightDefenderCard.createSequentialGroup()
					.addGroup(glOpponentRightDefenderCard.createParallelGroup(Alignment.LEADING)
						.addComponent(rightDefenderNameLabelOppoenent, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
						.addGroup(glOpponentRightDefenderCard.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(playerPositionRightDefenderOppoennt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(rightDefenderOffenceLabelOppoenent, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
							.addComponent(rightDefenderDefenceLabelOppoennt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
							.addComponent(rightDefenceStaminaLabelOppoennt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
						.addGroup(glOpponentRightDefenderCard.createSequentialGroup()
							.addContainerGap()
							.addComponent(resultStripForOpponentRightDefender, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		glOpponentRightDefenderCard.setVerticalGroup(
			glOpponentRightDefenderCard.createParallelGroup(Alignment.TRAILING)
				.addGroup(glOpponentRightDefenderCard.createSequentialGroup()
					.addContainerGap()
					.addComponent(resultStripForOpponentRightDefender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addComponent(rightDefenderNameLabelOppoenent)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(playerPositionRightDefenderOppoennt)
					.addGap(5)
					.addComponent(rightDefenderOffenceLabelOppoenent)
					.addGap(6)
					.addComponent(rightDefenderDefenceLabelOppoennt)
					.addGap(6)
					.addComponent(rightDefenceStaminaLabelOppoennt)
					.addContainerGap())
		);
		opponentRightDefenderCard.setLayout(glOpponentRightDefenderCard);
		
		JPanel oppoenentGoalKeeperCard = new JPanel();
		oppoenentGoalKeeperCard.setBackground(Color.LIGHT_GRAY);
		
		goallyKeeperOffencePlayersOppoent = new JLabel("Offence: ");
		goalKeeperDefencePlayersOppoennt = new JLabel("Defence: ");
		goalKeeperStaminaPlayersOpponent = new JLabel("Stamina: ");
		playerPositionnGoallyOppoennt = new JLabel("Position: ");
		nameOfGoallyOppoennt = new JLabel("Name:");
		
		resultStripForOppoenentGoalKeeper = new JPanel();
		
		goalKeeperReflexPlayersOpponent = new JLabel("reflex: ");
		

		GroupLayout glOppoenentGoalKeeperCard = new GroupLayout(oppoenentGoalKeeperCard);
		glOppoenentGoalKeeperCard.setHorizontalGroup(
			glOppoenentGoalKeeperCard.createParallelGroup(Alignment.LEADING)
				.addGroup(glOppoenentGoalKeeperCard.createSequentialGroup()
					.addGroup(glOppoenentGoalKeeperCard.createParallelGroup(Alignment.LEADING)
						.addComponent(goalKeeperDefencePlayersOppoennt, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addGroup(glOppoenentGoalKeeperCard.createSequentialGroup()
							.addContainerGap()
							.addComponent(resultStripForOppoenentGoalKeeper, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
						.addComponent(nameOfGoallyOppoennt, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(playerPositionnGoallyOppoennt, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(goallyKeeperOffencePlayersOppoent, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(goalKeeperStaminaPlayersOpponent, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(goalKeeperReflexPlayersOpponent, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		glOppoenentGoalKeeperCard.setVerticalGroup(
			glOppoenentGoalKeeperCard.createParallelGroup(Alignment.TRAILING)
				.addGroup(glOppoenentGoalKeeperCard.createSequentialGroup()
					.addContainerGap()
					.addComponent(resultStripForOppoenentGoalKeeper, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(nameOfGoallyOppoennt)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(playerPositionnGoallyOppoennt)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(goallyKeeperOffencePlayersOppoent)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(goalKeeperDefencePlayersOppoennt, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(goalKeeperStaminaPlayersOpponent)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(goalKeeperReflexPlayersOpponent)
					.addContainerGap())
		);
		oppoenentGoalKeeperCard.setLayout(glOppoenentGoalKeeperCard);
		
		JPanel positioner11 = new JPanel();
		
		JPanel positioner51 = new JPanel();
		GroupLayout glOppoenentSideOfField = new GroupLayout(oppoenentSideOfField);
		glOppoenentSideOfField.setHorizontalGroup(
			glOppoenentSideOfField.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 365, Short.MAX_VALUE)
				.addGroup(glOppoenentSideOfField.createSequentialGroup()
					.addGap(20)
					.addGroup(glOppoenentSideOfField.createParallelGroup(Alignment.TRAILING)
						.addComponent(positonar31, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
						.addComponent(oppoenentStrikerCard, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
						.addComponent(positioner21, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
					.addGroup(glOppoenentSideOfField.createParallelGroup(Alignment.LEADING)
						.addGroup(glOppoenentSideOfField.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(oppoenntLeftDefenderCard, GroupLayout.PREFERRED_SIZE, 115, Short.MAX_VALUE))
						.addGroup(glOppoenentSideOfField.createSequentialGroup()
							.addGap(8)
							.addGroup(glOppoenentSideOfField.createParallelGroup(Alignment.LEADING)
								.addComponent(positioner22, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
								.addComponent(opponentRightDefenderCard, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glOppoenentSideOfField.createParallelGroup(Alignment.TRAILING)
						.addComponent(oppoenentGoalKeeperCard, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
						.addComponent(positioner11, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
						.addComponent(positioner51, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
		);
		glOppoenentSideOfField.setVerticalGroup(
			glOppoenentSideOfField.createParallelGroup(Alignment.LEADING)
				.addGap(0, 487, Short.MAX_VALUE)
				.addGroup(glOppoenentSideOfField.createSequentialGroup()
					.addGap(22) 
					.addGroup(glOppoenentSideOfField.createParallelGroup(Alignment.LEADING)
						.addComponent(positioner51, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
						.addComponent(positonar31, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
						.addComponent(opponentRightDefenderCard, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glOppoenentSideOfField.createParallelGroup(Alignment.TRAILING)
						.addComponent(oppoenentGoalKeeperCard, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
						.addComponent(positioner22, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
						.addComponent(oppoenentStrikerCard, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glOppoenentSideOfField.createParallelGroup(Alignment.LEADING)
						.addComponent(positioner21, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
						.addComponent(positioner11, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
						.addComponent(oppoenntLeftDefenderCard, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
					.addGap(26))
		);
		oppoenentSideOfField.setLayout(glOppoenentSideOfField);
		GroupLayout glMatchScreen = new GroupLayout(matchScreen);
		glMatchScreen.setHorizontalGroup(
			glMatchScreen.createParallelGroup(Alignment.LEADING)
				.addGroup(glMatchScreen.createSequentialGroup()
					.addContainerGap()
					.addComponent(playervsplayerDisplay, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glMatchScreen.createParallelGroup(Alignment.LEADING)
						.addGroup(glMatchScreen.createSequentialGroup()
							.addComponent(mySideOfField, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(oppoenentSideOfField, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
						.addComponent(resultsLayout, GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE))
					.addContainerGap())
		);
		glMatchScreen.setVerticalGroup(
			glMatchScreen.createParallelGroup(Alignment.TRAILING)
				.addGroup(glMatchScreen.createSequentialGroup()
					.addGap(26)
					.addGroup(glMatchScreen.createParallelGroup(Alignment.TRAILING)
						.addGroup(glMatchScreen.createSequentialGroup()
							.addComponent(resultsLayout, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(glMatchScreen.createParallelGroup(Alignment.TRAILING)
								.addComponent(mySideOfField, GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
								.addComponent(oppoenentSideOfField, GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)))
						.addComponent(playervsplayerDisplay, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE))
					.addGap(28))
		);
		
		JPanel PlayerVsPlayerMatches = new JPanel();
		playervsplayerDisplay.setViewportView(PlayerVsPlayerMatches);
		
		goallyVsGoallyButton = new JButton("Play");
		goallyVsGoallyButton.addActionListener(this);
		leftDefenderVsLeftDefenderButton = new JButton("Play");
		leftDefenderVsLeftDefenderButton.addActionListener(this);
		rightDefenderVsRightDefenderButton = new JButton("Play");
		rightDefenderVsRightDefenderButton.addActionListener(this);
		strickerVsStrickerButton = new JButton("Play");
		strickerVsStrickerButton.addActionListener(this);
		JPanel myGoallyPlayer = new JPanel();
		myGoallyPlayer.setBackground(new Color(192, 192, 192));
		
		JPanel OppoenentGoallyPlayer = new JPanel();
		OppoenentGoallyPlayer.setBackground(new Color(192, 192, 192));
		
		JPanel myLeftDefenderPlayers = new JPanel();
		myLeftDefenderPlayers.setBackground(new Color(192, 192, 192));
		
		JPanel oppoenentLeftDefenderPlayers = new JPanel();
		oppoenentLeftDefenderPlayers.setBackground(new Color(192, 192, 192));
		
		JPanel myRightDefenderPlayers = new JPanel();
		myRightDefenderPlayers.setBackground(new Color(192, 192, 192));
		
		JPanel oppoenentRightDefenderPlayers = new JPanel();
		oppoenentRightDefenderPlayers.setBackground(new Color(192, 192, 192));
		
		JPanel myAttackerPlayer = new JPanel();
		myAttackerPlayer.setBackground(new Color(192, 192, 192));
		
		JPanel oppoenentAttackerPlayers = new JPanel();
		oppoenentAttackerPlayers.setBackground(new Color(192, 192, 192));
		
		JLabel leftDefenderVsLeftDefenderVsLabel = new JLabel("vs");
		leftDefenderVsLeftDefenderVsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel leftAttackerVsAttackerVsLabel = new JLabel("vs");
		leftAttackerVsAttackerVsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel rightDefenderVsRightDefenderVsLabel = new JLabel("vs");
		rightDefenderVsRightDefenderVsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel goalKeeperVsGoalKeeperVsLabel = new JLabel("vs");
		goalKeeperVsGoalKeeperVsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		confirmAllPlaysButton = new JButton("Play all");
		confirmAllPlaysButton.addActionListener(this);
		GroupLayout glPlayerVsPlayerMatches = new GroupLayout(PlayerVsPlayerMatches);
		glPlayerVsPlayerMatches.setHorizontalGroup(
			glPlayerVsPlayerMatches.createParallelGroup(Alignment.LEADING)
				.addGroup(glPlayerVsPlayerMatches.createSequentialGroup()
					.addGap(20)
					.addGroup(glPlayerVsPlayerMatches.createParallelGroup(Alignment.LEADING)
						.addGroup(glPlayerVsPlayerMatches.createSequentialGroup()
							.addGap(3)
							.addGroup(glPlayerVsPlayerMatches.createParallelGroup(Alignment.TRAILING)
								.addComponent(myRightDefenderPlayers, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
								.addComponent(myLeftDefenderPlayers, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
								.addComponent(myAttackerPlayer, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)))
						.addComponent(myGoallyPlayer, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glPlayerVsPlayerMatches.createParallelGroup(Alignment.TRAILING)
						.addComponent(strickerVsStrickerButton, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
						.addComponent(rightDefenderVsRightDefenderButton, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
						.addComponent(leftDefenderVsLeftDefenderButton, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
						.addComponent(goallyVsGoallyButton, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
						.addComponent(leftDefenderVsLeftDefenderVsLabel, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
						.addGroup(glPlayerVsPlayerMatches.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rightDefenderVsRightDefenderVsLabel, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
						.addComponent(leftAttackerVsAttackerVsLabel, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
						.addGroup(glPlayerVsPlayerMatches.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(goalKeeperVsGoalKeeperVsLabel, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
						.addGroup(glPlayerVsPlayerMatches.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(confirmAllPlaysButton, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glPlayerVsPlayerMatches.createParallelGroup(Alignment.LEADING)
						.addComponent(OppoenentGoallyPlayer, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
						.addComponent(oppoenentLeftDefenderPlayers, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
						.addComponent(oppoenentRightDefenderPlayers, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
						.addComponent(oppoenentAttackerPlayers, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
					.addGap(43))
		);
		glPlayerVsPlayerMatches.setVerticalGroup(
			glPlayerVsPlayerMatches.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, glPlayerVsPlayerMatches.createSequentialGroup()
					.addGap(65)
					.addGroup(glPlayerVsPlayerMatches.createParallelGroup(Alignment.LEADING)
						.addGroup(glPlayerVsPlayerMatches.createSequentialGroup()
							.addGap(18)
							.addGroup(glPlayerVsPlayerMatches.createParallelGroup(Alignment.TRAILING)
								.addComponent(OppoenentGoallyPlayer, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addGroup(glPlayerVsPlayerMatches.createSequentialGroup()
									.addGap(39)
									.addComponent(leftDefenderVsLeftDefenderVsLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(goallyVsGoallyButton))
								.addComponent(myGoallyPlayer, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(glPlayerVsPlayerMatches.createParallelGroup(Alignment.TRAILING)
								.addComponent(myLeftDefenderPlayers, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addGroup(glPlayerVsPlayerMatches.createSequentialGroup()
									.addGap(39)
									.addComponent(leftAttackerVsAttackerVsLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(leftDefenderVsLeftDefenderButton))
								.addComponent(oppoenentLeftDefenderPlayers, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(glPlayerVsPlayerMatches.createParallelGroup(Alignment.TRAILING)
								.addComponent(myRightDefenderPlayers, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addGroup(glPlayerVsPlayerMatches.createSequentialGroup()
									.addGap(39)
									.addComponent(rightDefenderVsRightDefenderVsLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(rightDefenderVsRightDefenderButton))
								.addComponent(oppoenentRightDefenderPlayers, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(glPlayerVsPlayerMatches.createParallelGroup(Alignment.TRAILING)
								.addComponent(myAttackerPlayer, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addGroup(glPlayerVsPlayerMatches.createSequentialGroup()
									.addGap(39)
									.addComponent(goalKeeperVsGoalKeeperVsLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(strickerVsStrickerButton))
								.addComponent(oppoenentAttackerPlayers, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
						.addGroup(glPlayerVsPlayerMatches.createSequentialGroup()
							.addComponent(confirmAllPlaysButton, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 470, GroupLayout.PREFERRED_SIZE)))
					.addGap(32))
		);
		
		oppoenentGoallyName = new JLabel("Name: ");
		oppoenentGoallyName.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout glOppoenentGoallyPlayer = new GroupLayout(OppoenentGoallyPlayer);
		glOppoenentGoallyPlayer.setHorizontalGroup(
			glOppoenentGoallyPlayer.createParallelGroup(Alignment.LEADING)
				.addComponent(oppoenentGoallyName, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
		);
		glOppoenentGoallyPlayer.setVerticalGroup(
			glOppoenentGoallyPlayer.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, glOppoenentGoallyPlayer.createSequentialGroup()
					.addGap(57)
					.addComponent(oppoenentGoallyName)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		OppoenentGoallyPlayer.setLayout(glOppoenentGoallyPlayer);
		
		myGoallyName = new JLabel("Name: "+((Player) myGoalkeeperObject).getName());
		myGoallyName.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout glMyGoallyPlayer = new GroupLayout(myGoallyPlayer);
		glMyGoallyPlayer.setHorizontalGroup(
			glMyGoallyPlayer.createParallelGroup(Alignment.LEADING)
				.addComponent(myGoallyName, GroupLayout.PREFERRED_SIZE, 68, Short.MAX_VALUE)
		);
		glMyGoallyPlayer.setVerticalGroup(
			glMyGoallyPlayer.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, glMyGoallyPlayer.createSequentialGroup()
					.addGap(56)
					.addComponent(myGoallyName)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		myGoallyPlayer.setLayout(glMyGoallyPlayer);
		
		oppoenentLeftDefenderName = new JLabel("Name: ");
		
		oppoenentLeftDefenderName.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout glOppoenentLeftDefenderPlayers = new GroupLayout(oppoenentLeftDefenderPlayers);
		glOppoenentLeftDefenderPlayers.setHorizontalGroup(
			glOppoenentLeftDefenderPlayers.createParallelGroup(Alignment.LEADING)
				.addComponent(oppoenentLeftDefenderName, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
		);
		glOppoenentLeftDefenderPlayers.setVerticalGroup(
			glOppoenentLeftDefenderPlayers.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, glOppoenentLeftDefenderPlayers.createSequentialGroup()
					.addGap(58)
					.addComponent(oppoenentLeftDefenderName)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		oppoenentLeftDefenderPlayers.setLayout(glOppoenentLeftDefenderPlayers);
		
		myLeftDefenderName = new JLabel("Name: "+((Player) myLeftdefenderObject).getName());
		myLeftDefenderName.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout glMyLeftDefenderPlayers = new GroupLayout(myLeftDefenderPlayers);
		glMyLeftDefenderPlayers.setHorizontalGroup(
			glMyLeftDefenderPlayers.createParallelGroup(Alignment.LEADING)
				.addComponent(myLeftDefenderName, GroupLayout.PREFERRED_SIZE, 65, Short.MAX_VALUE)
		);
		glMyLeftDefenderPlayers.setVerticalGroup(
			glMyLeftDefenderPlayers.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, glMyLeftDefenderPlayers.createSequentialGroup()
					.addGap(61)
					.addComponent(myLeftDefenderName)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		myLeftDefenderPlayers.setLayout(glMyLeftDefenderPlayers);
		
		oppoenentRightDefenderName = new JLabel("Name: ");
		
		
		oppoenentRightDefenderName.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout glOppoenentRightDefenderPlayers = new GroupLayout(oppoenentRightDefenderPlayers);
		glOppoenentRightDefenderPlayers.setHorizontalGroup(
			glOppoenentRightDefenderPlayers.createParallelGroup(Alignment.LEADING)
				.addComponent(oppoenentRightDefenderName, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
		);
		glOppoenentRightDefenderPlayers.setVerticalGroup(
			glOppoenentRightDefenderPlayers.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, glOppoenentRightDefenderPlayers.createSequentialGroup()
					.addGap(56)
					.addComponent(oppoenentRightDefenderName)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		oppoenentRightDefenderPlayers.setLayout(glOppoenentRightDefenderPlayers);
		
		myRightDefenderName = new JLabel("Name: "+((Player) myRightdefenderObject).getName());
		myRightDefenderName.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout glMyRightDefenderPlayers = new GroupLayout(myRightDefenderPlayers);
		glMyRightDefenderPlayers.setHorizontalGroup(
			glMyRightDefenderPlayers.createParallelGroup(Alignment.LEADING)
				.addComponent(myRightDefenderName, GroupLayout.PREFERRED_SIZE, 65, Short.MAX_VALUE)
		);
		glMyRightDefenderPlayers.setVerticalGroup(
			glMyRightDefenderPlayers.createParallelGroup(Alignment.TRAILING)
				.addGroup(glMyRightDefenderPlayers.createSequentialGroup()
					.addContainerGap(62, Short.MAX_VALUE)
					.addComponent(myRightDefenderName)
					.addGap(19))
		);
		myRightDefenderPlayers.setLayout(glMyRightDefenderPlayers);
		
		oppoenentStrickerName = new JLabel("Name: ");
		
		
		oppoenentStrickerName.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout glOppoenentAttackerPlayers = new GroupLayout(oppoenentAttackerPlayers);
		glOppoenentAttackerPlayers.setHorizontalGroup(
			glOppoenentAttackerPlayers.createParallelGroup(Alignment.LEADING)
				.addComponent(oppoenentStrickerName, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
		);
		glOppoenentAttackerPlayers.setVerticalGroup(
			glOppoenentAttackerPlayers.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, glOppoenentAttackerPlayers.createSequentialGroup()
					.addGap(57)
					.addComponent(oppoenentStrickerName)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		oppoenentAttackerPlayers.setLayout(glOppoenentAttackerPlayers);
		
		myStrickerName = new JLabel("Name: "+((Player) myStrickerObject).getName());
		myStrickerName.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout glMyAttackerPlayer = new GroupLayout(myAttackerPlayer);
		glMyAttackerPlayer.setHorizontalGroup(
			glMyAttackerPlayer.createParallelGroup(Alignment.LEADING)
				.addComponent(myStrickerName, GroupLayout.PREFERRED_SIZE, 65, Short.MAX_VALUE)
		);
		glMyAttackerPlayer.setVerticalGroup(
			glMyAttackerPlayer.createParallelGroup(Alignment.TRAILING)
				.addGroup(glMyAttackerPlayer.createSequentialGroup()
					.addContainerGap(62, Short.MAX_VALUE)
					.addComponent(myStrickerName)
					.addGap(19))
		);
		myAttackerPlayer.setLayout(glMyAttackerPlayer);
		PlayerVsPlayerMatches.setLayout(glPlayerVsPlayerMatches);
		matchScreen.setLayout(glMatchScreen);
	}

	
	/**
	 * Checks if the "Back to Menu" button should be enabled.
	 * If all four buttons have been clicked, it resets the counter,
	 * disables the "Confirm All Plays" button, and takes appropriate actions based on the game state.
	 * If it is the last week, it shows the game end screen.
	 * Otherwise, it updates the game outcome screen and shows it.
	 */
	
	public void isBackToMenuButtonOn()
	{

		if (numberOfButtonsClicked == 4)
		{	
			numberOfButtonsClicked = 0;
			confirmAllPlaysButton.setEnabled(false);
			if (GameMenu.currentWeek == GameMenu.durationConst)
			{
				GameMenu.game.gameEnd.frame.setLocationRelativeTo(null);
				GameMenu.game.gameEnd.frame.setVisible(true);
				GameMenu.game.gameEnd.update_display_label();
				
			}
			else {
			GameMenu.game.gameOutcomeScreen.gameResultCurrentPointAndTotalPointUpdate();
			GameMenu.game.gameOutcomeScreen.updatePlayingSquad();
			GameMenu.game.gameOutcomeScreen.frame.setLocationRelativeTo(null);
			GameMenu.game.gameOutcomeScreen.frame.setVisible(true);
			}
		}
		
		
	}
	/**
	 * Checks the stamina of the goalkeeper after a match.
	 * @return The count of times the goalkeeper's stamina was 0.
	 */
	public int playerStaminaCheckSfterNatch() {
	    int count = 0;
	    if (((Player) myGoalkeeperObject).stamina() == 0) {
	        count += 1;
	    }
	    if (((Player) myGoalkeeperObject).stamina() == 0) {
	        count += 1;
	    }
	    if (((Player) myGoalkeeperObject).stamina() == 0) {
	        count += 1;
	    }
	    if (((Player) myGoalkeeperObject).stamina() == 0) {
	        count += 1;
	    }
	    return count;
	}

	
	/**
	 * afterGameUpdates method resets the Game Screen labels and buttons 
	 * for the next game.
	 */
	public void afterGameUpdates() {
	    // Update team names in the stadium
	    Stadium.updateTeamNames();
	    
	    // Enable buttons for the next game
	    TheGameScreen.goallyVsGoallyButton.setEnabled(true);
	    TheGameScreen.leftDefenderVsLeftDefenderButton.setEnabled(true);
	    TheGameScreen.rightDefenderVsRightDefenderButton.setEnabled(true);
	    TheGameScreen.strickerVsStrickerButton.setEnabled(true);
	    TheGameScreen.confirmAllPlaysButton.setEnabled(true);
	    
	    // Reset result strip colors to default
	    resultStripForMyGoalKeeper.setBackground(new Color(255, 255, 255));
	    resultStripForMyRightDefender.setBackground(new Color(255, 255, 255));
	    resultStripForMyAttacker.setBackground(new Color(255, 255, 255));
	    resultStripForOppoenentAttacker.setBackground(new Color(255, 255, 255));
	    resultStripForOpponentRightDefender.setBackground(new Color(255, 255, 255));
	    resultStripForOpponentLeftDefender.setBackground(new Color(255, 255, 255));
	    resultStripForOppoenentGoalKeeper.setBackground(new Color(255, 255, 255));
	    resultStripForMyLeftDefender.setBackground(new Color(255, 255, 255));
	    
	    // Update match history and scores
	    Stadium.weekList[matchHistoryCounter] = "week " + (matchHistoryCounter + 1) + " : " + " scores " + myCurrentScore + " - " + opponentCurrentScore;
	    matchHistoryCounter += 1;
	    TotalScore += myCurrentScore;
	    opponentCurrentScore = 0;
	    
	    // Update game duration and current week
	    GameMenu.duration -= 1;
	    GameMenu.currentWeek += 1;
	    GameMenu.currentWeekDisplay.setText("Current week: " + GameMenu.currentWeek);
	    GameMenu.weekRemainingDisplay.setText("Week remaining: " + GameMenu.duration);
	    
	    // Reset current scores and display
	    myCurrentScore = 0;
	    myTeamCurrentScoreDisplay.setText("0");
	    opponentCurrentScoreDisplay.setText("0");
	}
	/**
	 * actionPerformed method that is accessed through the ActionListner interface.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == goallyVsGoallyButton) {
	        // Compare goalkeeper stats
	        int myRelfex = ((Player) myGoalkeeperObject).goalKeeperReflex();
	        int oppoenentReflex = ((Player) opponentPlayerGoalKeeper).goalKeeperReflex();
	        player_vs_player(oppoenentReflex, myRelfex, resultStripForMyGoalKeeper, resultStripForOppoenentGoalKeeper, myGoalkeeperObject);
	        goallyVsGoallyButton.setEnabled(false);
	    }
	    
	    if (e.getSource() == leftDefenderVsLeftDefenderButton) {
	        // Compare left defender stats
	        int oppoenentLeftDefence = ((Player) opponentPlayerLeftDefender).defence();
	        int myLeftDefence = ((Player) myLeftdefenderObject).defence();
	        player_vs_player(oppoenentLeftDefence, myLeftDefence, resultStripForMyLeftDefender, resultStripForOpponentLeftDefender, myLeftdefenderObject);
	        leftDefenderVsLeftDefenderButton.setEnabled(false);
	    }
	    
	    if (e.getSource() == rightDefenderVsRightDefenderButton) {
	        // Compare right defender stats
	        int oppoenentRightDefence = ((Player) opponentPlayerRightDefender).defence();
	        int myrightDefence = ((Player) myRightdefenderObject).defence();
	        player_vs_player(oppoenentRightDefence, myrightDefence, resultStripForMyRightDefender, resultStripForOpponentRightDefender, myRightdefenderObject);
	        rightDefenderVsRightDefenderButton.setEnabled(false);
	    }
	    
	    if (e.getSource() == strickerVsStrickerButton) {
	        // Compare striker stats
	        int oppoenentOffense = ((Player) opponentPlayerStricker).offense();
	        int myplayerOffense = ((Player) myStrickerObject).offense();
	        player_vs_player(oppoenentOffense, myplayerOffense, resultStripForMyAttacker, resultStripForOppoenentAttacker, myStrickerObject);
	        strickerVsStrickerButton.setEnabled(false);
	    }
	    
	    if (e.getSource() == confirmAllPlaysButton) {
	        // Simulate all player comparisons
	        goallyVsGoallyButton.doClick();
	        leftDefenderVsLeftDefenderButton.doClick();
	        rightDefenderVsRightDefenderButton.doClick();
	        strickerVsStrickerButton.doClick();
	        confirmAllPlaysButton.setEnabled(false);
	    }
	}

	/**
	 * function used to compare the stats of the player athelete and the opponent.
	 * it calculates the points earned based on the stat comparison.
	 * @param opponenetStat The stat value of the opponent.
	 * @param myPlayerStat The stat value of the player.
	 * @param myPlayerResultStrip The panel representing the player's result strip.
	 * @param oppoenentPlayerStrip The panel representing the opponent's result strip.
	 * @param playerObject The object representing the player.
	 */
	public void player_vs_player(int opponenetStat, int myPlayerStat, JPanel myPlayerResultStrip, JPanel oppoenentPlayerStrip, Object playerObject) {
	    // Variables to track points
	    int myPoints = 0;
	    int opponentPoint = 0;
	    
	    // Compare player stats
	    if (myPlayerStat > opponenetStat) {
	        myPoints += 1;
	    }
	    if (myPlayerStat < opponenetStat) {
	        opponentPoint += 1;
	    }
	    
	    // Check for a draw
	    if (myPlayerStat == opponenetStat) {
	        opponentPoint += 0; 
	        myPoints += 0;
	    }
	    
	    // Handle the outcome based on points
	    if (myPoints == opponentPoint) {
	        // If it's a draw
	        ((Player) playerObject).damageTaken(damageTakenOnDraw);
	        myPlayerResultStrip.setBackground(new Color(128, 128, 128));
	        oppoenentPlayerStrip.setBackground(new Color(128, 128, 128));
	    }
	    else if (myPoints > opponentPoint) {
	        // If the player wins
	        ((Player) playerObject).damageTaken(damageTakenOnWin);
	        myCurrentScore += myPoints;
	        myTeamCurrentScoreDisplay.setText("" + myCurrentScore);
	        myPlayerResultStrip.setBackground(new Color(0, 255, 64));
	        oppoenentPlayerStrip.setBackground(new Color(255, 0, 0));
	    }
	    else if (myPoints < opponentPoint) {
	        // If the player loses
	        ((Player) playerObject).damageTaken(damageTakenOnLoss);
	        opponentCurrentScore += opponentPoint;
	        opponentCurrentScoreDisplay.setText("" + opponentCurrentScore);
	        oppoenentPlayerStrip.setBackground(new Color(0, 255, 64));
	        myPlayerResultStrip.setBackground(new Color(255, 0, 0));
	    }
	    
	    // Update button click count
	    numberOfButtonsClicked += 1;
	    isBackToMenuButtonOn();
	}



	
	

	
}
