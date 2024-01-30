package game_start_and_login_page;



import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.MenuContainer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import foot.Player;
import foot.Team;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;


/**
 * the class SignUpShop that creates the instance of the Shop that enables players to purchase reserves and playing players for their team.
 * the class also uses the ActionListener interface to control on click events ie when the the player clicks the purchase buttons.
 * @author  Jack Kuruvilla
 *
 */
public class SignUpShop implements ActionListener  {


	/**
	 * Represents the main frame of the application.
	 */
	public static JFrame frame;

	/**
	 * Button to navigate back to the home screen.
	 */
	public JButton backToHomeButton;

	/**
	 * Button for selecting player one.
	 */
	public JButton playerOneButton;

	/**
	 * Button for selecting player two.
	 */
	public JButton playerTwoButton;

	/**
	 * Button for selecting player three.
	 */
	public JButton playerThreeButton;

	/**
	 * Button for selecting player four.
	 */
	public JButton playerFourButton;

	/**
	 * Represents the list of players in a team.
	 */
	public static Team playerList;

	/**
	 * Button for selecting reserve player one.
	 */
	public JButton reservePlayerOneButton;

	/**
	 * Button for selecting reserve player three.
	 */
	public JButton reservePlayerThreeButton;

	/**
	 * Button for selecting reserve player four.
	 */
	public JButton reservePlayerFourButton;

	/**
	 * Button for selecting reserve player two.
	 */
	public JButton reservePlayerTwoButton;

	/**
	 * Represents the total list of purchasable players.
	 */
	public static ArrayList<Player> totalPurchaseablePlayers;

	/**
	 * Button to select all players.
	 */
	public JButton selectAllButton;

	/**
	 * Button to deselect all players.
	 */
	public JButton deselectAllButton;

	/**
	 * Represents the window of the sign-up shop.
	 */
	private static SignUpShop window = new SignUpShop();

	/**
	 * Represents player one object.
	 */
	public static Player playerOneObject;

	/**
	 * Represents player two object.
	 */
	public static Player playerTwoObject;

	/**
	 * Represents player three object.
	 */
	public static Player playerThreeObject;

	/**
	 * Represents player four object.
	 */
	public static Player playerFourObject;

	/**
	 * Represents reserve player one object.
	 */
	public static Player reserveplayerOneObject;

	/**
	 * Represents reserve player two object.
	 */
	public static Player reservePlayerTwoObject;

	/**
	 * Represents reserve player three object.
	 */
	public static Player reservePlayerThreeObject;

	/**
	 * Represents reserve player four object.
	 */
	public static Player reservePlayerFourObject;

	/**
	 * Label for displaying the name of the goalkeeper.
	 */
	public static JLabel goalKeeperNameLabel;

	/**
	 * Label for displaying the name of the reserve goalkeeper.
	 */
	public static JLabel reserveGoalKeeperNameLabel;

	/**
	 * Label for displaying the name of the attacker.
	 */
	public static JLabel attackerNameLabel;

	/**
	 * Label for displaying the name of the reserve attacker.
	 */
	public static JLabel reserveAttackerNameLabel;

	/**
	 * Label for displaying the name of the left defender.
	 */
	public static JLabel leftDefenderNameLabel;

	/**
	 * Label for displaying the name of the reserve left defender.
	 */
	public static JLabel reserveLeftDefenderNameLabel;

	/**
	 * Label for displaying the name of the reserve right defender.
	 */
	public static JLabel reserveRightDefenderNameLabel;

	/**
	 * Label for displaying the name of the right defender.
	 */
	public static JLabel rightDefenderNameLabel;

	/**
	 * Label for displaying the stamina of the goalkeeper.
	 */
	public static JLabel goalKeeperStaminaLabel;

	/**
	 * Label for displaying the stamina of the reserve goalkeeper.
	 */
	public static JLabel reserveGoalKeeperStaminaLabel;

	/**
	 * Label for displaying the stamina of the reserve right defender.
	 */
	public static JLabel reserveRightDefenderStaminaLabel;

	/**
	 * Label for displaying the stamina of the reserve left defender.
	 */
	public static JLabel reserveLeftDefenderStaminaLabel;

	/**
	 * Label for displaying the stamina of the attacker.
	 */
	public static JLabel attackerStaminaLabel;

	/**
	 * Label for displaying the stamina of the right defender.
	 */
	public static JLabel rightDefenderStaminaLabel;

	/**
	 * Label for displaying the stamina of the left defender.
	 */
	public static JLabel leftDefenderStaminaLabel;

	/**
	 * Label for displaying the stamina of the reserve attacker.
	 */
	public static JLabel reserveAttackerStaminaLabel;

	/**
	 * Label for displaying the offensive ability of the goalkeeper.
	 */
	public static JLabel goalKeeperOffenceLabel;

	/**
	 * Label for displaying the offensive ability of the attacker.
	 */
	public static JLabel attackerOffenceLabel;

	/**
	 * Label for displaying the offensive ability of the reserve left defender.
	 */
	public static JLabel reserveLeftDefenderOffenceLabel;

	/**
	 * Label for displaying the offensive ability of the reserve right defender.
	 */
	public static JLabel reserveRightDefenderOffenceLabel;

	/**
	 * Label for displaying the offensive ability of the reserve goalkeeper.
	 */
	public static JLabel reserveGoalKeeperOffenceLabel;

	/**
	 * Label for displaying the offensive ability of the left defender.
	 */
	public static JLabel leftDefenderOffenceLabel;

	/**
	 * Label for displaying the offensive ability of the right defender.
	 */
	public static JLabel rightDefenderOffenceLabel;

	/**
	 * Label for displaying the offensive ability of the reserve attacker.
	 */
	public static JLabel reserveAttackerOffenceLabel;

	/**
	 * Label for displaying the defensive ability of the reserve attacker.
	 */
	public static JLabel rserveAttackerDefenceLabel;

	/**
	 * Label for displaying the defensive ability of the right defender.
	 */
	public static JLabel rightDefenderDefenceLabel;

	/**
	 * Label for displaying the defensive ability of the reserve goalkeeper.
	 */
	public static JLabel reserveGoalKeeperDefneceLabel;

	/**
	 * Label for displaying the defensive ability of the left defender.
	 */
	public static JLabel leftDefenderDefenceLabel;

	/**
	 * Label for displaying the defensive ability of the goalkeeper.
	 */
	public static JLabel goalKeeperDefenceLabel;

	/**
	 * Label for displaying the defensive ability of the attacker.
	 */
	public static JLabel attackerDefenceLabel;

	/**
	 * Label for displaying the defensive ability of the reserve left defender.
	 */
	public static JLabel reserveLeftDefenderDefenceLabel;

	/**
	 * Label for displaying the defensive ability of the reserve right defender.
	 */
	public static JLabel reserveRightDefenderDefenceLabel;

	/**
	 * Label for displaying the reflex ability of the goalkeeper.
	 */
	public static JLabel goalKeeperReflexLabel;

	/**
	 * Label for displaying the reflex ability of the reserve goalkeeper.
	 */
	public static JLabel reserveGoalKeeperReflexLabel;


	
	/**
	 * Launch the application.
	 * @param args is an empty String list object.
	 */
	public static void main(String[] args) {
	
	playerList = new Team();
	
	window.frame.setVisible(true);
	window.frame.setLocationRelativeTo(null);

	}

	/**
	 * uses the Construct for the class to Create the application.
	 */
	public SignUpShop() {
		

		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @return returnStat the random stat generated by the function call depending on the deficulty chosen the player using the slider.
	 * in the LoginPage.
	 */
	public static int randomInitialStatsSenerator() {
	    Random randomStat = new Random();
	    int returnStat = 0;
	    
	    int sliderValue = LoginPage.sliderForDifficulty.getValue();
	    if (sliderValue == 1) {
	        returnStat = randomStat.nextInt(11) + 30;
	    } else if (sliderValue == 2) {
	        returnStat = randomStat.nextInt(11) + 20;
	    } else if (sliderValue == 3) {
	        returnStat = randomStat.nextInt(11) + 10;
	    }
	    
	    return returnStat;
	}
	/**
	 * intializes the frame and other contents of the application.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setResizable(true);
		frame.setBounds(300, 300,1200, 834);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		totalPurchaseablePlayers = new ArrayList<Player>();
		
		playerOneObject = new Player(100,0,0,0,"Jack","goal keeper",false,false);
		playerTwoObject = new Player(100,0,0,"Josh","left defender",false,false);
		playerThreeObject = new Player(100,0,0,"Uday","right defender",false,false);
		playerFourObject = new Player(100,0,0,"Chris","attacker",false,false);
		reserveplayerOneObject = new Player(100,0,0,0,"Will","goal keeper",true,false);
		reservePlayerTwoObject = new Player(100,0,0,"Kush","left defender",true,false);
		reservePlayerThreeObject = new Player(100,0,0,"Martin","right defender",true,false);
		reservePlayerFourObject = new Player(100,0,0,"Aakrista","attacker",true,false);
	
		backToHomeButton = new JButton("< Back ");
		backToHomeButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		backToHomeButton.addActionListener(this);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel allPlayerPurchaseButtons = new JPanel();
		
		
		allPlayerPurchaseButtons.setPreferredSize(new Dimension(100,660));
		scrollPane.setViewportView(allPlayerPurchaseButtons);
		
		playerOneButton = new JButton("Buy Player( goal keeper)");
		playerOneButton.addActionListener(this);
		playerTwoButton = new JButton("Buy Player (left defender) ");
		playerTwoButton.addActionListener(this);
		playerThreeButton = new JButton("Buy Player (right defender) ");
		playerThreeButton.addActionListener(this);
		playerFourButton = new JButton("Buy Player (attacker) ");
		playerFourButton.addActionListener(this);
		
		reservePlayerOneButton = new JButton("Buy reserve Player (goal keeper) ");
		reservePlayerOneButton.addActionListener(this);
		
		reservePlayerThreeButton = new JButton("Buy reserve Player(left defender)");
		reservePlayerThreeButton.addActionListener(this);
		
		reservePlayerFourButton = new JButton("Buy reserve Player(right defender) ");
		reservePlayerFourButton.addActionListener(this);
		
		reservePlayerTwoButton = new JButton("Buy reserve Player (attacker)");
		reservePlayerTwoButton.addActionListener(this);
		
		JLabel signUpShopWarningLabel = new JLabel(">> Note: these players can be returned back to the market later on if you want!");
		signUpShopWarningLabel.setHorizontalAlignment(SwingConstants.LEFT);
		signUpShopWarningLabel.setForeground(Color.RED);
		signUpShopWarningLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel goalKeeperPanel = new JPanel();
		
		JPanel attackerPanel = new JPanel();
		
		JPanel reserveLeftDefenderPanelPanel = new JPanel();
		
		JPanel reserveRightDefenderPanel = new JPanel();
		
		JPanel reserveGoalKeeperPanel = new JPanel();
		
		JPanel leftDefenderPanel = new JPanel();
		
		JPanel rightDefenderPanel = new JPanel();
		
		rightDefenderNameLabel = new JLabel("Name: "+playerThreeObject.getName());	
		rightDefenderStaminaLabel = new JLabel("Stamina: "+playerThreeObject.stamina());
		rightDefenderOffenceLabel = new JLabel("Offence: "+playerThreeObject.offense());
		rightDefenderDefenceLabel = new JLabel("Defence: "+playerThreeObject.defence());

		leftDefenderNameLabel = new JLabel("Name: "+playerTwoObject.getName());
		leftDefenderStaminaLabel = new JLabel("Stamina: "+playerTwoObject.stamina());	
		leftDefenderOffenceLabel = new JLabel("Offence: "+playerTwoObject.offense());
		leftDefenderDefenceLabel = new JLabel("Defence: "+playerTwoObject.defence());
		
		attackerNameLabel = new JLabel("Name: "+playerFourObject.getName());
		attackerStaminaLabel = new JLabel("Stamina:"+playerFourObject.stamina());
		attackerOffenceLabel = new JLabel("Offence: "+playerFourObject.offense());
		attackerDefenceLabel = new JLabel("Defence: "+playerFourObject.defence());
		
		goalKeeperNameLabel = new JLabel("Name: "+playerOneObject.getName());	
		goalKeeperStaminaLabel = new JLabel("Stamina:"+playerOneObject.stamina());
		goalKeeperOffenceLabel = new JLabel("Offence: "+playerOneObject.offense());
		goalKeeperDefenceLabel = new JLabel("Defence: "+playerOneObject.defence());
		goalKeeperReflexLabel = new JLabel("Reflex: "+playerOneObject.goalKeeperReflex());
		
		
		reserveAttackerNameLabel = new JLabel("Name: "+reservePlayerFourObject.getName());
		reserveAttackerStaminaLabel = new JLabel("Stamina: "+reservePlayerFourObject.stamina());
		reserveAttackerOffenceLabel = new JLabel("Offence: "+reservePlayerFourObject.offense());
		rserveAttackerDefenceLabel = new JLabel("Defence: "+reservePlayerFourObject.defence());
		
		reserveRightDefenderNameLabel = new JLabel("Name: "+reservePlayerThreeObject.getName());
		reserveRightDefenderStaminaLabel = new JLabel("Stamina: "+reservePlayerThreeObject.stamina());
		reserveRightDefenderOffenceLabel = new JLabel("Offence: "+reservePlayerThreeObject.offense());
		reserveRightDefenderDefenceLabel = new JLabel("Defence: "+reservePlayerThreeObject.defence());
		
		reserveGoalKeeperNameLabel = new JLabel("Name: "+reserveplayerOneObject.getName());
		reserveGoalKeeperStaminaLabel = new JLabel("Stamina: "+reserveplayerOneObject.stamina());	
		reserveGoalKeeperOffenceLabel = new JLabel("Offence: "+reserveplayerOneObject.offense());
		reserveGoalKeeperDefneceLabel = new JLabel("Defence: "+reserveplayerOneObject.defence());
		reserveGoalKeeperReflexLabel = new JLabel("Reflex: "+reserveplayerOneObject.goalKeeperReflex());
		
		reserveLeftDefenderNameLabel = new JLabel("Name: "+reservePlayerTwoObject.getName());	
		reserveLeftDefenderStaminaLabel = new JLabel("Stamina: "+reservePlayerTwoObject.defence());
		reserveLeftDefenderOffenceLabel = new JLabel("Offence: "+reservePlayerTwoObject.offense());
		reserveLeftDefenderDefenceLabel = new JLabel("Defence: "+reservePlayerTwoObject.defence());
		JPanel reserveAttackerPanel = new JPanel();
		GroupLayout glallPlayerPurchaseButtons = new GroupLayout(allPlayerPurchaseButtons);
		glallPlayerPurchaseButtons.setHorizontalGroup(
			glallPlayerPurchaseButtons.createParallelGroup(Alignment.LEADING)
				.addGroup(glallPlayerPurchaseButtons.createSequentialGroup()
					.addComponent(signUpShopWarningLabel, GroupLayout.PREFERRED_SIZE, 574, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(519, Short.MAX_VALUE))
				.addGroup(glallPlayerPurchaseButtons.createSequentialGroup()
					.addGap(76)
					.addGroup(glallPlayerPurchaseButtons.createParallelGroup(Alignment.LEADING)
						.addGroup(glallPlayerPurchaseButtons.createSequentialGroup()
							.addComponent(reserveLeftDefenderPanelPanel, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(glallPlayerPurchaseButtons.createSequentialGroup()
							.addGroup(glallPlayerPurchaseButtons.createParallelGroup(Alignment.TRAILING)
								.addComponent(attackerPanel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
								.addGroup(glallPlayerPurchaseButtons.createParallelGroup(Alignment.TRAILING)
									.addComponent(goalKeeperPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
									.addComponent(playerFourButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
									.addComponent(playerOneButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
									.addComponent(reservePlayerThreeButton, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 182, Short.MAX_VALUE)))
							.addGap(197)
							.addGroup(glallPlayerPurchaseButtons.createParallelGroup(Alignment.LEADING)
								.addGroup(glallPlayerPurchaseButtons.createParallelGroup(Alignment.LEADING)
									.addComponent(reservePlayerFourButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(reserveRightDefenderPanel, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
									.addComponent(reservePlayerOneButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(reserveGoalKeeperPanel, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
									.addComponent(playerTwoButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(leftDefenderPanel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
							.addGap(187)
							.addGroup(glallPlayerPurchaseButtons.createParallelGroup(Alignment.LEADING)
								.addComponent(reservePlayerTwoButton, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
								.addComponent(playerThreeButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rightDefenderPanel, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
								.addComponent(reserveAttackerPanel, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
							.addGap(89))))
		);
		glallPlayerPurchaseButtons.setVerticalGroup(
			glallPlayerPurchaseButtons.createParallelGroup(Alignment.LEADING)
				.addGroup(glallPlayerPurchaseButtons.createSequentialGroup()
					.addComponent(signUpShopWarningLabel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addGroup(glallPlayerPurchaseButtons.createParallelGroup(Alignment.LEADING)
						.addGroup(glallPlayerPurchaseButtons.createSequentialGroup()
							.addComponent(leftDefenderPanel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(playerTwoButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGroup(glallPlayerPurchaseButtons.createSequentialGroup()
							.addGroup(glallPlayerPurchaseButtons.createParallelGroup(Alignment.TRAILING)
								.addComponent(goalKeeperPanel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addComponent(rightDefenderPanel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(glallPlayerPurchaseButtons.createParallelGroup(Alignment.LEADING)
								.addGroup(glallPlayerPurchaseButtons.createSequentialGroup()
									.addGap(2)
									.addComponent(playerThreeButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
								.addComponent(playerOneButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))))
					.addGap(14)
					.addGroup(glallPlayerPurchaseButtons.createParallelGroup(Alignment.TRAILING)
						.addComponent(reserveGoalKeeperPanel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addComponent(reserveAttackerPanel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addComponent(attackerPanel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(glallPlayerPurchaseButtons.createParallelGroup(Alignment.LEADING)
						.addGroup(glallPlayerPurchaseButtons.createSequentialGroup()
							.addGroup(glallPlayerPurchaseButtons.createParallelGroup(Alignment.LEADING)
								.addComponent(playerFourButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(reservePlayerOneButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
							.addGap(28)
							.addGroup(glallPlayerPurchaseButtons.createParallelGroup(Alignment.LEADING)
								.addComponent(reserveLeftDefenderPanelPanel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addComponent(reserveRightDefenderPanel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(glallPlayerPurchaseButtons.createParallelGroup(Alignment.LEADING)
								.addComponent(reservePlayerThreeButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(reservePlayerFourButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
						.addComponent(reservePlayerTwoButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(113, Short.MAX_VALUE))
		);
		
		
		GroupLayout gl_reserveAttackerPanel = new GroupLayout(reserveAttackerPanel);
		gl_reserveAttackerPanel.setHorizontalGroup(
			gl_reserveAttackerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_reserveAttackerPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_reserveAttackerPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(reserveAttackerNameLabel, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
						.addComponent(reserveAttackerStaminaLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(reserveAttackerOffenceLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(rserveAttackerDefenceLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_reserveAttackerPanel.setVerticalGroup(
			gl_reserveAttackerPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_reserveAttackerPanel.createSequentialGroup()
					.addGap(25)
					.addComponent(reserveAttackerNameLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(reserveAttackerStaminaLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(reserveAttackerOffenceLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
					.addComponent(rserveAttackerDefenceLabel)
					.addGap(24))
		);
		reserveAttackerPanel.setLayout(gl_reserveAttackerPanel);
		
		
		GroupLayout gl_rightDefenderPanel = new GroupLayout(rightDefenderPanel);
		gl_rightDefenderPanel.setHorizontalGroup(
			gl_rightDefenderPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rightDefenderPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_rightDefenderPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(rightDefenderDefenceLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(rightDefenderNameLabel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addComponent(rightDefenderStaminaLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(rightDefenderOffenceLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		gl_rightDefenderPanel.setVerticalGroup(
			gl_rightDefenderPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_rightDefenderPanel.createSequentialGroup()
					.addContainerGap(43, Short.MAX_VALUE)
					.addComponent(rightDefenderNameLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rightDefenderStaminaLabel)
					.addGap(4)
					.addComponent(rightDefenderOffenceLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rightDefenderDefenceLabel)
					.addContainerGap())
		);
		rightDefenderPanel.setLayout(gl_rightDefenderPanel);
		
		
		GroupLayout gl_reserveRightDefenderPanel = new GroupLayout(reserveRightDefenderPanel);
		gl_reserveRightDefenderPanel.setHorizontalGroup(
			gl_reserveRightDefenderPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_reserveRightDefenderPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_reserveRightDefenderPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(reserveRightDefenderDefenceLabel, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addComponent(reserveRightDefenderNameLabel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addComponent(reserveRightDefenderStaminaLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(reserveRightDefenderOffenceLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		gl_reserveRightDefenderPanel.setVerticalGroup(
			gl_reserveRightDefenderPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_reserveRightDefenderPanel.createSequentialGroup()
					.addContainerGap(39, Short.MAX_VALUE)
					.addComponent(reserveRightDefenderNameLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(reserveRightDefenderStaminaLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(reserveRightDefenderOffenceLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(reserveRightDefenderDefenceLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		reserveRightDefenderPanel.setLayout(gl_reserveRightDefenderPanel);
		
		
		GroupLayout gl_reserveGoalKeeperPanel = new GroupLayout(reserveGoalKeeperPanel);
		gl_reserveGoalKeeperPanel.setHorizontalGroup(
			gl_reserveGoalKeeperPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_reserveGoalKeeperPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_reserveGoalKeeperPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_reserveGoalKeeperPanel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(reserveGoalKeeperDefneceLabel, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
							.addComponent(reserveGoalKeeperOffenceLabel, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
							.addGroup(Alignment.TRAILING, gl_reserveGoalKeeperPanel.createSequentialGroup()
								.addGroup(gl_reserveGoalKeeperPanel.createParallelGroup(Alignment.TRAILING)
									.addComponent(reserveGoalKeeperReflexLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
									.addComponent(reserveGoalKeeperStaminaLabel, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
								.addGap(40)))
						.addComponent(reserveGoalKeeperNameLabel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		gl_reserveGoalKeeperPanel.setVerticalGroup(
			gl_reserveGoalKeeperPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_reserveGoalKeeperPanel.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addComponent(reserveGoalKeeperNameLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(reserveGoalKeeperStaminaLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(reserveGoalKeeperReflexLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(reserveGoalKeeperOffenceLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(reserveGoalKeeperDefneceLabel)
					.addContainerGap())
		);
		reserveGoalKeeperPanel.setLayout(gl_reserveGoalKeeperPanel);
		
		
		GroupLayout gl_leftDefenderPanel = new GroupLayout(leftDefenderPanel);
		gl_leftDefenderPanel.setHorizontalGroup(
			gl_leftDefenderPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftDefenderPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_leftDefenderPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(leftDefenderNameLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addComponent(leftDefenderStaminaLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(leftDefenderOffenceLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(leftDefenderDefenceLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		gl_leftDefenderPanel.setVerticalGroup(
			gl_leftDefenderPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_leftDefenderPanel.createSequentialGroup()
					.addContainerGap(39, Short.MAX_VALUE)
					.addComponent(leftDefenderNameLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(leftDefenderStaminaLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(leftDefenderOffenceLabel)
					.addGap(8)
					.addComponent(leftDefenderDefenceLabel)
					.addContainerGap())
		);
		leftDefenderPanel.setLayout(gl_leftDefenderPanel);
		
		
		GroupLayout gl_reserveLeftDefenderPanelPanel = new GroupLayout(reserveLeftDefenderPanelPanel);
		gl_reserveLeftDefenderPanelPanel.setHorizontalGroup(
			gl_reserveLeftDefenderPanelPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_reserveLeftDefenderPanelPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_reserveLeftDefenderPanelPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(reserveLeftDefenderNameLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addComponent(reserveLeftDefenderStaminaLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(reserveLeftDefenderOffenceLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(reserveLeftDefenderDefenceLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		gl_reserveLeftDefenderPanelPanel.setVerticalGroup(
			gl_reserveLeftDefenderPanelPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_reserveLeftDefenderPanelPanel.createSequentialGroup()
					.addContainerGap(43, Short.MAX_VALUE)
					.addComponent(reserveLeftDefenderNameLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(reserveLeftDefenderStaminaLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(reserveLeftDefenderOffenceLabel)
					.addGap(4)
					.addComponent(reserveLeftDefenderDefenceLabel)
					.addContainerGap())
		);
		reserveLeftDefenderPanelPanel.setLayout(gl_reserveLeftDefenderPanelPanel);
		
		
		GroupLayout gl_attackerPanel = new GroupLayout(attackerPanel);
		gl_attackerPanel.setHorizontalGroup(
			gl_attackerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_attackerPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_attackerPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(attackerNameLabel, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
						.addComponent(attackerStaminaLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(attackerOffenceLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(attackerDefenceLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		gl_attackerPanel.setVerticalGroup(
			gl_attackerPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_attackerPanel.createSequentialGroup()
					.addGap(24)
					.addComponent(attackerNameLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(attackerStaminaLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(attackerOffenceLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
					.addComponent(attackerDefenceLabel)
					.addGap(25))
		);
		attackerPanel.setLayout(gl_attackerPanel);
		

		GroupLayout gl_goalKeeperPanel = new GroupLayout(goalKeeperPanel);
		gl_goalKeeperPanel.setHorizontalGroup(
			gl_goalKeeperPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_goalKeeperPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_goalKeeperPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_goalKeeperPanel.createSequentialGroup()
							.addGroup(gl_goalKeeperPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(goalKeeperOffenceLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
								.addComponent(goalKeeperDefenceLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
								.addComponent(goalKeeperNameLabel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(50, Short.MAX_VALUE))
						.addGroup(gl_goalKeeperPanel.createSequentialGroup()
							.addComponent(goalKeeperReflexLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(82))
						.addGroup(gl_goalKeeperPanel.createSequentialGroup()
							.addComponent(goalKeeperStaminaLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(50, Short.MAX_VALUE))))
		);
		gl_goalKeeperPanel.setVerticalGroup(
			gl_goalKeeperPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_goalKeeperPanel.createSequentialGroup()
					.addContainerGap(33, Short.MAX_VALUE)
					.addComponent(goalKeeperNameLabel)
					.addGap(3)
					.addComponent(goalKeeperStaminaLabel)
					.addGap(4)
					.addComponent(goalKeeperReflexLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(goalKeeperOffenceLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(goalKeeperDefenceLabel)
					.addGap(4))
		);
		goalKeeperPanel.setLayout(gl_goalKeeperPanel);
		allPlayerPurchaseButtons.setLayout(glallPlayerPurchaseButtons);
		
		selectAllButton = new JButton("Select all");
		selectAllButton.addActionListener(this);
		
		deselectAllButton = new JButton("de-select all");
		deselectAllButton.addActionListener(this);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1112, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(backToHomeButton, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 815, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(selectAllButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(deselectAllButton, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))))
					.addGap(33))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(backToHomeButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(selectAllButton)
							.addGap(10)
							.addComponent(deselectAllButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)))
					.addGap(76))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	/**
	 * updates an individual player stat as per the requirements of the player. 
	 * @param player Object that is retrieved by the function to set its stats.
	 */
	public static void playerStatUpdate(Player player)
	{
			
		((Player)player).setStamina(100); 
		((Player)player).setDefence(randomInitialStatsSenerator());
		((Player)player).setOffense(randomInitialStatsSenerator());
	
		if (((Player)player).getPosition() == "goal keeper")
		{
			((Player)player).setPlayerreflex(randomInitialStatsSenerator());
		}
		
	}
	/**
	 * static functions that sets the player stats using the helper function playerStatUpdate above.
	 */
	public static void player()
	{
		playerStatUpdate(playerOneObject);
		playerStatUpdate(playerTwoObject);
		playerStatUpdate(playerThreeObject);
		playerStatUpdate(playerFourObject);
		playerStatUpdate(reserveplayerOneObject);
		playerStatUpdate(reservePlayerTwoObject);
		playerStatUpdate(reservePlayerThreeObject);
		playerStatUpdate(reservePlayerFourObject);
		
	}
	
	/**
	 * static method that sets the purchasable player stats onces the player have been created and provided with stats.
	 */
	public static void setPlayerStat()
	{
		
		rightDefenderNameLabel.setText("Name: "+playerThreeObject.getName());	
		rightDefenderStaminaLabel.setText("Stamina: "+playerThreeObject.stamina());
		rightDefenderOffenceLabel.setText("Offence: "+playerThreeObject.offense());
		rightDefenderDefenceLabel.setText("Defence: "+playerThreeObject.defence());

		leftDefenderNameLabel.setText("Name: "+playerTwoObject.getName());
		leftDefenderStaminaLabel.setText("Stamina: "+playerTwoObject.stamina());	
		leftDefenderOffenceLabel.setText("Offence: "+playerTwoObject.offense());
		leftDefenderDefenceLabel.setText("Defence: "+playerTwoObject.defence());
		
		attackerNameLabel.setText("Name: "+playerFourObject.getName());
		attackerStaminaLabel.setText("Stamina:"+playerFourObject.stamina());
		attackerOffenceLabel.setText("Offence: "+playerFourObject.offense());
		attackerDefenceLabel.setText("Defence: "+playerFourObject.defence());
		
		goalKeeperNameLabel.setText("Name: "+playerOneObject.getName());	
		goalKeeperStaminaLabel.setText("Stamina:"+playerOneObject.stamina());
		goalKeeperOffenceLabel.setText("Offence: "+playerOneObject.offense());
		goalKeeperDefenceLabel.setText("Defence: "+playerOneObject.defence());
		goalKeeperReflexLabel.setText("Reflex: "+playerOneObject.goalKeeperReflex());
		
		
		reserveAttackerNameLabel.setText("Name: "+reservePlayerFourObject.getName());
		reserveAttackerStaminaLabel.setText("Stamina: "+reservePlayerFourObject.stamina());
		reserveAttackerOffenceLabel.setText("Offence: "+reservePlayerFourObject.offense());
		rserveAttackerDefenceLabel.setText("Defence: "+reservePlayerFourObject.defence());
		
		reserveRightDefenderNameLabel.setText("Name: "+reservePlayerThreeObject.getName());
		reserveRightDefenderStaminaLabel.setText("Stamina: "+reservePlayerThreeObject.stamina());
		reserveRightDefenderOffenceLabel.setText("Offence: "+reservePlayerThreeObject.offense());
		reserveRightDefenderDefenceLabel.setText("Defence: "+reservePlayerThreeObject.defence());
		
		reserveGoalKeeperNameLabel.setText("Name: "+reserveplayerOneObject.getName());
		reserveGoalKeeperStaminaLabel.setText("Stamina: "+reserveplayerOneObject.stamina());	
		reserveGoalKeeperOffenceLabel.setText("Offence: "+reserveplayerOneObject.offense());
		reserveGoalKeeperDefneceLabel.setText("Defence: "+reserveplayerOneObject.defence());
		reserveGoalKeeperReflexLabel.setText("Reflex: "+reserveplayerOneObject.goalKeeperReflex());
		
		reserveLeftDefenderNameLabel.setText("Name: "+reservePlayerTwoObject.getName());	
		reserveLeftDefenderStaminaLabel.setText("Stamina: "+reservePlayerTwoObject.stamina());
		reserveLeftDefenderOffenceLabel.setText("Offence: "+reservePlayerTwoObject.offense());
		reserveLeftDefenderDefenceLabel.setText("Defence: "+reservePlayerTwoObject.defence());
		

		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == selectAllButton)
		{

			playerOneButton.doClick();
			playerTwoButton.doClick();
			playerThreeButton.doClick();
			playerFourButton.doClick();
			reservePlayerOneButton.doClick();
			reservePlayerTwoButton.doClick();
			reservePlayerThreeButton.doClick();
			reservePlayerFourButton.doClick();
			
		}
		if(e.getSource() == deselectAllButton)
		{
			playerOneButton.setEnabled(true);
			playerOneButton.setText("Buy Player( goal keeper)");
			playerTwoButton.setEnabled(true);
			playerTwoButton.setText("Buy Player (left defender)");
			playerThreeButton.setEnabled(true);
			playerThreeButton.setText("Buy Player (right defender)");
			playerFourButton.setEnabled(true);
			playerFourButton.setText("Buy Player (attacker) ");
			reservePlayerOneButton.setEnabled(true);
			reservePlayerOneButton.setText("Buy reserve Player (goal keeper) ");
			reservePlayerTwoButton.setEnabled(true);
			reservePlayerTwoButton.setText("Buy reserve Player (attacker)");
			reservePlayerThreeButton.setEnabled(true);
			reservePlayerThreeButton.setText("Buy reserve Player(left defender)");
			reservePlayerFourButton.setEnabled(true);
			reservePlayerFourButton.setText("Buy reserve Player(right defender) ");
			if (playerList.player.size() > 0)
			{
				playerList.player = new ArrayList<Player>();

			}
				
		}
		if (e.getSource() == backToHomeButton)
		{
	
			frame = window.frame;
			SignUpShop.frame.setVisible(false);
			LoginPage.frame.setBounds(SignUpShop.frame.getBounds());
			LoginPage.frame.setVisible(true);
		}
		if(e.getSource() == playerOneButton)
		{
			playerOneButton.setEnabled(false);
			playerOneButton.setText("Sold");
			playerList.player.add(playerOneObject);
		}
		if(e.getSource() == playerTwoButton)
		{
			playerTwoButton.setEnabled(false);
			playerTwoButton.setText("Sold");

			playerList.player.add(playerTwoObject);
		}
		if(e.getSource() == playerThreeButton)
		{
			playerThreeButton.setEnabled(false);
			playerThreeButton.setText("Sold");
			playerList.player.add(playerThreeObject);
		}
		if(e.getSource() == playerFourButton)
		{	
			playerFourButton.setEnabled(false);
			playerFourButton.setText("Sold");
			playerList.player.add(playerFourObject);
		}
		if(e.getSource() == reservePlayerOneButton)
		{
			reservePlayerOneButton.setEnabled(false);
			reservePlayerOneButton.setText("Sold");
			playerList.player.add(reserveplayerOneObject);
		}
		if(e.getSource() == reservePlayerTwoButton)
		{
			reservePlayerTwoButton.setText("Sold");
			reservePlayerTwoButton.setEnabled(false);
			playerList.player.add(reservePlayerTwoObject);
		}
		if(e.getSource() == reservePlayerThreeButton)
		{
			reservePlayerThreeButton.setText("Sold");
			reservePlayerThreeButton.setEnabled(false);
			playerList.player.add(reservePlayerThreeObject);
		}
		if(e.getSource() == reservePlayerFourButton)
		{
			reservePlayerFourButton.setText("Sold");
			reservePlayerFourButton.setEnabled(false);
			playerList.player.add(reservePlayerFourObject);
		}		
	}
}
