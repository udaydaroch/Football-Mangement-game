package game_main_menu;

import java.awt.EventQueue;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.Adjustable;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.SinglePixelPackedSampleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import foot.Player;
import foot.Team;
import foot.Inventory;
import game_start_and_login_page.SignUpShop;

import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JList;

import foot.Items;

/**
 * Market class provides the players the ability to purchase  players or items or return  back their existing items and players. 
 * user the ActionListener and ListSelectionListener interfaces to control and handle the button click events
 * @author udayd
 *
 */
public class Market implements ActionListener,ListSelectionListener{

	/**
	 * The main market frame.
	 */
	public static JFrame marketFrame;

	/**
	 * Button to go back to the main menu.
	 */
	private JButton backToMenuButton;

	/**
	 * Label displaying the amount of money available.
	 */
	public static JLabel moneyInAmountJLabel;

	/**
	 * Text field for selling back goalkeepers.
	 */
	public static JTextField goalKeeperSaleBackTextField;

	/**
	 * Text field for selling back defenders.
	 */
	public static JTextField defenfderSaleBackTextField;

	/**
	 * Text field for selling back attackers.
	 */
	public static JTextField attackerSaleBackTextField;

	/**
	 * Text field for returning protein supplements.
	 */
	public static JTextField proteinSupplimenentReturnBackTextField;

	/**
	 * Button for purchasing goalkeeper training pass.
	 */
	static JButton goalKeeperTrainingPassButton;

	/**
	 * Button for purchasing defender training pass.
	 */
	static JButton defenceTrainingPassButton;

	/**
	 * Button for purchasing attacker training pass.
	 */
	static JButton attackerTrainingPassPurchaseButton;

	/**
	 * Button for purchasing protein supplements.
	 */
	static JButton proteinSupplimentPurcahseButton;

	/**
	 * The inventory object.
	 */
	public static Inventory inventory;

	/**
	 * The price of the training pass and protein supplements.
	 */
	public static int ItemPrice = 130;

	/**
	 * Item for weekly training pass for goalkeepers.
	 */
	public static Items weeklyTrainingPassForGoalkeeperItem = new Items("weekly training pass for goalkeepers", ItemPrice);

	/**
	 * Item for weekly training pass for defenders.
	 */
	public static Items weeklyTrainingPassForDefenceItem = new Items("weekly training pass for defenders", ItemPrice);

	/**
	 * Item for weekly training pass for attackers.
	 */
	public static Items weekyTrainingPassForAttackersItem = new Items("weekly training pass for strickers", ItemPrice);

	/**
	 * Item for protein supplements.
	 */
	public static Items proteinSupplementItem = new Items("protein_suppliments", ItemPrice);

	/**
	 * Button for returning goalkeeper training pass.
	 */
	public static JButton goalkeeperTrainingPassReturnBackButton;

	/**
	 * Button for returning defender training pass.
	 */
	public static JButton defenceTrainingPassReturnBackButton;

	/**
	 * Button for returning attacker training pass.
	 */
	public static JButton attackerTrainingPassReturnBackButton;

	/**
	 * Button for returning protein supplements.
	 */
	public static JButton proteinSuppliementSaleBackButton;

	/**
	 * Label for displaying warning when selling back goalkeeper training pass.
	 */
	private JLabel goalKeeperSoldBackTrainingWarningDisplayLabel;

	/**
	 * Label for displaying warning when selling back defender training pass.
	 */
	private JLabel defenderSoldBackTrainingWarningDisplayLabel;

	/**
	 * Label for displaying warning when selling back attacker training pass.
	 */
	private JLabel attackerSolderBackTrainingWarningDisplayLabel;

	/**
	 * Label for displaying warning when selling back protein supplements.
	 */
	private JLabel proteinSuppliementSoldbackDisplay;

	/**
	 * Button to confirm the return of defender training pass.
	 */
	public static JButton confirmDefenderPassReturnBackButton;

	/**
	 * Button to confirm the return of attacker training pass.
	 */
	public static JButton confirmAttackerPassReturnBackButton;

	/**
	 * Button to confirm the return of protein supplements.
	 */
	public static JButton proteinSuppliementReturnBackButton;

	/**
	 * Button to confirm the return of goalkeeper training pass.
	 */
	public static JButton confirmGoalKeeperPassReturnBackButton;

	/**
	 * Label for displaying the total number of defender training passes purchased per week.
	 */
	public static JLabel totalDefenderPassWeeklyPurcahseLabel;

	/**
	 * Label for displaying the maximum number of attacker training passes that can be purchased per week.
	 */
	public static JLabel MaxAttackerWeeeklyPurchaseLabel;

	/**
	 * Label for displaying the maximum number of protein supplements that can be purchased per week.
	 */
	public static JLabel maxxProteinSupplmenetWeeklyPurchaseLabel;

	/**
	 * Label for displaying the goalkeeper training pass purchased per week.
	 */
	public static JLabel goalkeeperPassWeeklyPurchaseLabel;

	/**
	 * Label for displaying a general warning for purchasing items.
	 */
	private JLabel GeneralPurchasingItemWarningLabel;

	/**
	 * Label for displaying a warning for purchasing players.
	 */
	private JLabel WarningJLabelForAllPurchasePlayer;

	/**
	 * The number of goalkeepers in the squad.
	 */
	private int numOfGoalKeeper;

	/**
	 * The number of defenders in the squad.
	 */
	private int numOfdefender;

	/**
	 * The number of attackers in the squad.
	 */
	private int numOfAttacker;

	/**
	 * The number of protein supplements in the squad.
	 */
	private int NumOfProteinSupplmenet;

	/**
	 * Label for displaying the names of all players in the squad.
	 */
	private JLabel allPlayerNameDisplayJLabel;

	/**
	 * The number of weekly passes for attackers purchased this week.
	 */
	private static int numberOfWeeklyPassesForAttackerPurchaseThisWeek = 0;

	/**
	 * The number of weekly passes for defenders purchased this week.
	 */
	private static int numberOfWeeklyPassesForDefenderPuchasedThisWeek = 0;

	/**
	 * The number of weekly passes for goalkeepers purchased this week.
	 */
	private static int numberOfWeeklyPassesForGoalKeeperPuchasedThisWeek = 0;

	/**
	 * The number of protein supplements purchased this week.
	 */
	private static int numberOfProteinSupplmenetPurchasedThisWeek = 0;

	/**
	 * Label for displaying the remaining defender training passes.
	 */
	private JLabel remainingDefenderPassLabel;

	/**
	 * Label for displaying the remaining attacker training passes.
	 */
	private JLabel remainingAttackerPassLabel;

	/**
	 * Label for displaying the remaining protein supplements.
	 */
	private JLabel remainingProteinSuppliementPassDisplay;

	/**
	 * Label for displaying the remaining goalkeeper training passes.
	 */
	private JLabel remainingGoalKeeperPassLabel;

	/**
	 * Card panel for professional left defender.
	 */
	private JPanel proLeftDefenderCard;

	/**
	 * Card panel for professional right defender.
	 */
	private JPanel proRightDefenderCard;

	/**
	 * Card panel for professional attacker.
	 */
	private JPanel proAttackerCard;

	/**
	 * Card panel for professional goalkeeper.
	 */
	private JPanel proGoalKeeeprCard;

	/**
	 * Card panel for reserve left defender.
	 */
	private JPanel reserveLeftDefenderCard;

	/**
	 * Card panel for reserve right defender.
	 */
	private JPanel reserveRightDefenderCard;

	/**
	 * Card panel for reserve attacker.
	 */
	private JPanel reserveAttackerCard;

	/**
	 * Card panel for reserve goalkeeper.
	 */
	private JPanel reserveGoalKeeperCard;

	/**
	 * Panel for displaying view stat buttons of professional players.
	 */
	private JPanel jLabelForAllViewStatButtonsOfProPlayer;

	/**
	 * Button for viewing the stats of professional left defender.
	 */
	private JButton buttonToViewStatOfProLeftDefender;

	/**
	 * Button for viewing the stats of professional right defender.
	 */
	private JButton buttonToViewStatOfProRightDefender;

	/**
	 * Button for viewing the stats of professional attacker.
	 */
	private JButton buttonToViewStatOfProAttacker;

	/**
	 * Button for viewing the stats of professional goalkeeper.
	 */
	private JButton buttonToViewSatOfProGoalKeeper;

	/**
	 * Panel for displaying view stat buttons of reserve players.
	 */
	private JPanel jLabelForAllviewstatButtonOfReservePlayers;

	/**
	 * Button for viewing the stats of reserve left defender.
	 */
	private static JButton buttonToViewStatOfReserveLeftDefender;

	/**
	 * Button for viewing the stats of reserve right defender.
	 */
	private static JButton buttonToViewStatOfReserveRightDefender;

	/**
	 * Button for viewing the stats of reserve attacker.
	 */
	private static JButton buttonToViewReserveAttacker;

	/**
	 * Button for viewing the stats of reserve goalkeeper.
	 */
	private static JButton buttonToVIewReserveGoalkeeper;

	/**
	 * Button for viewing the stats of left defender.
	 */
	private JButton buttonToViewLeftDefender;

	/**
	 * Button for viewing the stats of right defender.
	 */
	private JButton butttonToViewRightDefender;

	/**
	 * Button for viewing the stats of attacker.
	 */
	private JButton buttonToViewstatOfAttacker;

	/**
	 * Button for viewing the stats of goalkeeper.
	 */
	private JButton buttonToViewStatGoalkeeper;

	/**
	 * Button for purchasing reserve left defender.
	 */
	private static JButton buttonToPurchaseReserveLeftDefender;

	/**
	 * Button for purchasing reserve right defender.
	 */
	private static JButton buttonToPurcahseReserveRIghtDefender;

	/**
	 * Button for purchasing reserve attacker.
	 */
	private static JButton buttonToPurchaseReserveAttacker;

	/**
	 * Button for purchasing reserve goalkeeper.
	 */
	private static JButton buttonToPurchaseReserveGoalKeeper;

	/**
	 * Button for purchasing left defender.
	 */
	private JButton buttonToPurchaseLeftDefender;

	/**
	 * Button for purchasing right defender.
	 */
	private JButton buttonToPurchaseRightDefender;

	/**
	 * Button for purchasing attacker.
	 */
	private JButton buttonToPurchaseAttacker;

	/**
	 * Button for purchasing goalkeeper.
	 */
	private JButton buttonToPurchaseGoalKeeper;

	/**
	 * Button for purchasing professional left defender as a reserve player.
	 */
	private JButton purchaseProLeftDefenderAsReserveButton;

	/**
	 * Button for purchasing professional right defender as a reserve player.
	 */
	private JButton purchaseProRightDefenderAsReserveButton;

	/**
	 * Button for purchasing professional attacker as a reserve player.
	 */
	private JButton purchaseProAttackerAsReserveButton;

	/**
	 * Button for purchasing professional goalkeeper as a reserve player.
	 */
	private JButton purchaseProGoalKeeperAsReserveButton;

	/**
	 * Flag indicating whether a pro player has been purchased.
	 */
	private boolean purchased_pro_player = false;

	/**
	 * Label displaying instructions to return players.
	 */
	private JLabel jLabelInstructionToReturnPlayers;

	/**
	 * Scroll pane for displaying returnable players.
	 */
	public static JScrollPane JScrollPaneDisplayingTheReturnablePlayers;

	/**
	 * Currently selected player.
	 */
	private Object selected_player;

	/**
	 * Label for displaying the stamina of a player.
	 */
	private JLabel staminaLabel;

	/**
	 * Label for displaying the offense of a player.
	 */
	private JLabel offenseLabel;

	/**
	 * Label for displaying the defense of a player.
	 */
	private JLabel defenceLabel;

	/**
	 * Label for displaying the reflex of a player.
	 */
	private JLabel reflexLabel;

	/**
	 * Label for displaying the position of a player.
	 */
	private JLabel positionLabel;

	/**
	 * Purchase price for normal players.
	 */
	public int normalPlayerPurchasePrice = 200;

	/**
	 * Purchase price for pro players.
	 */
	public int proPlayerPurchasePrice = 800;

	/**
	 * Pro player - attacker.
	 */
	private Player proAttacker = new Player(100, 90, 90, 90, "Ronaldo", "attacker", false, true);

	/**
	 * Pro player - left defender.
	 */
	private Player proLeftDefender = new Player(100, 90, 90, 90, "Antonio", "left defender", false, true);

	/**
	 * Pro player - right defender.
	 */
	private Player proRightDefender = new Player(100, 90, 90, 90, "Marquinhos", "right defender", false, true);

	/**
	 * Pro player - goalkeeper.
	 */
	private Player proGoalKeeper = new Player(100, 90, 90, 90, "Manuel", "goal keeper", false, true);

	/**
	 * The first player in the squad.
	 */
	private Player playerOne = new Player(100, 0, 0, 0, "Jack", "goal keeper", false, true);

	/**
	 * The second player in the squad.
	 */
	private Player playerTwo = new Player(100, 0, 0, "Josh", "left defender", false, true);

	/**
	 * The third player in the squad.
	 */
	private Player playerThree = new Player(100, 0, 0, "Uday", "right defender", false, true);

	/**
	 * The fourth player in the squad.
	 */
	private Player playerFour = new Player(100, 0, 0, "Chris", "attacker", false, true);

	/**
	 * The first reserve player.
	 */
	private Player reservePlayerOne = new Player(100, 10, 30, 40, "Will", "goal keeper", true, true);

	/**
	 * The second reserve player.
	 */
	private Player reservePlayerTwo = new Player(100, 25, 80, "Kush", "left defender", true, true);

	/**
	 * The third reserve player.
	 */
	private Player reservePlayerThree = new Player(100, 10, 60, "Martin", "right defender", true, true);

	/**
	 * The fourth reserve player.
	 */
	private Player reservePlayerFour = new Player(100, 10, 60, "Aakrista", "attacker", true, true);

	/**
	 * Button for purchasing a professional goalkeeper player.
	 */
	private JButton purchaseProGoalkeeperButton;

	/**
	 * Button for purchasing a professional left defender player.
	 */
	private JButton purchaseProLeftDefenderButton;

	/**
	 * Button for purchasing a professional right defender player.
	 */
	private JButton purchaseProRIghtDefenderButton;

	/**
	 * Button for purchasing a professional attacker player.
	 */
	private JButton purchaseProAttackerButton;

	/**
	 * Button for returning a selected player.
	 */
	private static JButton selectedPLayerReturnButton;

	/**
	 * Indicates if it is the first time returning a left defender player.
	 */
	private boolean firstTimeReturnLeftDefender = true;

	/**
	 * Indicates if it is the first time returning a right defender player.
	 */
	private boolean firstTimeReturnReftDefender = true;

	/**
	 * Indicates if it is the first time returning an attacker player.
	 */
	private boolean firstTimeReturnAttacker = true;

	/**
	 * Indicates if it is the first time returning a goalkeeper player.
	 */
	private boolean firstTimeReturnGoalKeeper = true;

	/**
	 * Indicates if it is the first time returning a reserve left defender player.
	 */
	private boolean firstTimeReturnReserveLeftDefender = true;

	/**
	 * Indicates if it is the first time returning a reserve right defender player.
	 */
	private boolean firstTimeReturnReserveRightDefender = true;

	/**
	 * Indicates if it is the first time returning a reserve attacker player.
	 */
	private boolean firstTimeReturnReserveAttacker = true;

	/**
	 * Indicates if it is the first time returning a reserve goalkeeper player.
	 */
	private boolean firstTimeReturnReserveGoalkeeper = true;

	/**
	 * JList for displaying the players in the squad.
	 */
	public JList<Object> listOfPlayersInSquad;

	/**
	 * Scroll pane for the purchasable player list.
	 */
	private JScrollPane purchasablePlayingListJScrollPanel;

	/**
	 * Adjustable for scrolling up in the purchasable player list.
	 */
	private Adjustable scollUpPurchasePlayerList;

	/**
	 * Adjustable for scrolling right in the purchasable player list.
	 */
	private Adjustable scrollRightPurchaseblePlayerList;

	/**
	 * Label for displaying the current price of a goalkeeper player.
	 */
	private JLabel goaLKeeperCurrentPriceLabel;

	/**
	 * Label for displaying the current price of an attacker player.
	 */
	private JLabel CurrentAttackerPrizeLabel;

	/**
	 * Label for displaying the current price of a defender player.
	 */
	private JLabel defenderCurrentPriceLabel;

	/**
	 * Label for displaying the current price of a protein supplement.
	 */
	private JLabel proteinSuppliementCurrentPrize;

	/**
	 * Label for displaying the current price of a left defender player.
	 */
	private JLabel leftDefenderCurrentPrice;

	/**
	 * Label for displaying the current price of a right defender player.
	 */
	private JLabel rightDefenderCurrentPrice;

	/**
	 * Label for displaying the current price of an attacker player.
	 */
	private JLabel attackerCurrentPrice;

	/**
	 * Label for displaying the current price of a goalkeeper player.
	 */
	private JLabel goalKeeperCurrentPrice;

	/**
	 * Label for displaying the current price of a reserve left defender player.
	 */
	private JLabel reserveLeftDefenderCurrentPrice;

	/**
	 * Label for displaying the current price of a reserve right defender player.
	 */
	private JLabel reserveRightDefenderCurrentPrice;

	/**
	 * Label for displaying the current price of a reserve attacker player.
	 */
	private JLabel reserveAttackerCurrentPrice;

	/**
	 * Label for displaying the current price of a reserve goalkeeper player.
	 */
	private JLabel reserveGoalKeeperCurrentPrice;

	/**
	 * Label for displaying the current price of a professional attacker player.
	 */
	private JLabel proAttackerCurrentPrice;

	/**
	 * Label for displaying the current price of a professional right defender player.
	 */
	private JLabel proRightDefenderCurrentPrice;

	/**
	 * Label for displaying the current price of a professional left defender player.
	 */
	private JLabel proLeftDefenderCurrentPRice;

	/**
	 * Label for displaying the current price of a professional goalkeeper player.
	 */
	private JLabel proGoalKeeperCurrentPrice;

	/**
	 * Label for displaying a warning message for returning a selected player.
	 */
	private JLabel jLabelForReturnWarning;

	/**
	 * ArrayList of buttons for professional reserve players.
	 */
	private ArrayList<JButton> pro_reserves;

	/**
	 * Label for providing instructions to buy a professional player.
	 */
	private JLabel jLabelInstructionForBuyProPlayerOne;


	

	/**
	 * Contructor used to intialize the frame and all the interactable 
	 * features for the player.
	 */
	public Market() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		marketFrame = new JFrame();
		marketFrame.setBounds(100, 100, 1240, 881);
		marketFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		inventory = new Inventory();
				
		backToMenuButton = new JButton("< Back");
		backToMenuButton.addActionListener(this);
		
		backToMenuButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		backToMenuButton.setForeground(new Color(0, 0, 0));
		
		JScrollPane itemShop = new JScrollPane();
	
		
		
		moneyInAmountJLabel = new JLabel("Money in account: "+ GameMenu.money);
		moneyInAmountJLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		moneyInAmountJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane inventoryItems = new JScrollPane();
		purchasablePlayingListJScrollPanel = new JScrollPane();
		scollUpPurchasePlayerList = purchasablePlayingListJScrollPanel.getVerticalScrollBar();
		scrollRightPurchaseblePlayerList = purchasablePlayingListJScrollPanel.getHorizontalScrollBar();
		
		JScrollPane playerReturnSection = new JScrollPane();
		playerReturnSection.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		playerReturnSection.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		GroupLayout groupLayout = new GroupLayout(marketFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(backToMenuButton)
							.addPreferredGap(ComponentPlacement.RELATED, 640, Short.MAX_VALUE)
							.addComponent(moneyInAmountJLabel, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(purchasablePlayingListJScrollPanel, 0, 0, Short.MAX_VALUE)
								.addComponent(itemShop, GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(inventoryItems, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
								.addComponent(playerReturnSection, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(moneyInAmountJLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(backToMenuButton)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(purchasablePlayingListJScrollPanel, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
						.addComponent(playerReturnSection, GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(inventoryItems, 0, 0, Short.MAX_VALUE)
						.addComponent(itemShop, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JPanel panelContainingPlayerListAndReturnButton = new JPanel();
		playerReturnSection.setViewportView(panelContainingPlayerListAndReturnButton);
		
		JPanel returnPlayerButtonCenterBox = new JPanel();
		
		jLabelInstructionToReturnPlayers = new JLabel("Please select the player that you want to return");
		
		JScrollPaneDisplayingTheReturnablePlayers = new JScrollPane();
		JScrollPaneDisplayingTheReturnablePlayers.setEnabled(false);
		JScrollPaneDisplayingTheReturnablePlayers.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		JScrollPaneDisplayingTheReturnablePlayers.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JPanel boxForWarningForPlayerPurchase = new JPanel();
		GroupLayout glPanelContainingPlayerListAndReturnButton = new GroupLayout(panelContainingPlayerListAndReturnButton);
		glPanelContainingPlayerListAndReturnButton.setHorizontalGroup(
			glPanelContainingPlayerListAndReturnButton.createParallelGroup(Alignment.TRAILING)
				.addGroup(glPanelContainingPlayerListAndReturnButton.createSequentialGroup()
					.addGap(36)
					.addGroup(glPanelContainingPlayerListAndReturnButton.createParallelGroup(Alignment.TRAILING)
						.addComponent(returnPlayerButtonCenterBox, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
						.addComponent(JScrollPaneDisplayingTheReturnablePlayers, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
						.addComponent(jLabelInstructionToReturnPlayers, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
						.addComponent(boxForWarningForPlayerPurchase, GroupLayout.PREFERRED_SIZE, 335, Short.MAX_VALUE))
					.addGap(49))
		);
		glPanelContainingPlayerListAndReturnButton.setVerticalGroup(
			glPanelContainingPlayerListAndReturnButton.createParallelGroup(Alignment.LEADING)
				.addGroup(glPanelContainingPlayerListAndReturnButton.createSequentialGroup()
					.addGap(15)
					.addComponent(jLabelInstructionToReturnPlayers)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(JScrollPaneDisplayingTheReturnablePlayers, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(returnPlayerButtonCenterBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(boxForWarningForPlayerPurchase, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(41))
		);
		
		jLabelForReturnWarning = new JLabel("Warning: ");
		jLabelForReturnWarning.setHorizontalAlignment(SwingConstants.LEFT);
		GroupLayout glBoxForWarningForPlayerPurchase = new GroupLayout(boxForWarningForPlayerPurchase);
		glBoxForWarningForPlayerPurchase.setHorizontalGroup(
			glBoxForWarningForPlayerPurchase.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, glBoxForWarningForPlayerPurchase.createSequentialGroup()
					.addComponent(jLabelForReturnWarning, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		glBoxForWarningForPlayerPurchase.setVerticalGroup(
			glBoxForWarningForPlayerPurchase.createParallelGroup(Alignment.LEADING)
				.addGroup(glBoxForWarningForPlayerPurchase.createSequentialGroup()
					.addGap(5)
					.addComponent(jLabelForReturnWarning)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		boxForWarningForPlayerPurchase.setLayout(glBoxForWarningForPlayerPurchase);
		
		listOfPlayersInSquad = new JList();
		listOfPlayersInSquad.setLayoutOrientation(JList.VERTICAL_WRAP);
		listOfPlayersInSquad.addListSelectionListener(this);
		JScrollPaneDisplayingTheReturnablePlayers.setViewportView(listOfPlayersInSquad);
		
	
		
		selectedPLayerReturnButton = new JButton("Return player");
		selectedPLayerReturnButton.setEnabled(false);
		selectedPLayerReturnButton.addActionListener(this);
		GroupLayout glReturnPlayerButtonCenterBox = new GroupLayout(returnPlayerButtonCenterBox);
		glReturnPlayerButtonCenterBox.setHorizontalGroup(
			glReturnPlayerButtonCenterBox.createParallelGroup(Alignment.LEADING)
				.addGroup(glReturnPlayerButtonCenterBox.createSequentialGroup()
					.addGap(116)
					.addComponent(selectedPLayerReturnButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(124))
		);
		glReturnPlayerButtonCenterBox.setVerticalGroup(
			glReturnPlayerButtonCenterBox.createParallelGroup(Alignment.LEADING)
				.addGroup(glReturnPlayerButtonCenterBox.createSequentialGroup()
					.addComponent(selectedPLayerReturnButton)
					.addContainerGap(11, Short.MAX_VALUE))
		);
		returnPlayerButtonCenterBox.setLayout(glReturnPlayerButtonCenterBox);
		panelContainingPlayerListAndReturnButton.setLayout(glPanelContainingPlayerListAndReturnButton);
		
		JLabel jLabelForPlayerReturnSectionOfTheMarket = new JLabel("Player return ");
		jLabelForPlayerReturnSectionOfTheMarket.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelForPlayerReturnSectionOfTheMarket.setFont(new Font("Tahoma", Font.PLAIN, 16));
		playerReturnSection.setColumnHeaderView(jLabelForPlayerReturnSectionOfTheMarket);
		
		JPanel panelContainingPurchasablePlayers = new JPanel();
		purchasablePlayingListJScrollPanel.setViewportView(panelContainingPurchasablePlayers);
		
		proLeftDefenderCard = new JPanel();
		proLeftDefenderCard.setBackground(new Color(128, 128, 255));
		
		proRightDefenderCard = new JPanel();
		proRightDefenderCard.setBackground(new Color(128, 128, 255));
		
		proAttackerCard = new JPanel();
		proAttackerCard.setBackground(new Color(128, 128, 255));
		
		proGoalKeeeprCard = new JPanel();
		proGoalKeeeprCard.setBackground(new Color(128, 128, 255));
		
		reserveLeftDefenderCard = new JPanel();
		reserveLeftDefenderCard.setBackground(new Color(255, 0, 0));
		
		reserveRightDefenderCard = new JPanel();
		reserveRightDefenderCard.setBackground(new Color(255, 0, 0));
		
		reserveAttackerCard = new JPanel();
		reserveAttackerCard.setBackground(new Color(255, 0, 0));
		
		reserveGoalKeeperCard = new JPanel();
		reserveGoalKeeperCard.setBackground(new Color(255, 0, 0));
		
		jLabelForAllViewStatButtonsOfProPlayer = new JPanel();
		jLabelForAllViewStatButtonsOfProPlayer.setBackground(new Color(240, 240, 240));
		
		jLabelForAllviewstatButtonOfReservePlayers = new JPanel();
		jLabelForAllviewstatButtonOfReservePlayers.setBackground(new Color(240, 240, 240));
		
		
		
	
		buttonToViewStatOfReserveLeftDefender = new JButton("View stats");
		buttonToViewStatOfReserveLeftDefender.addActionListener(this);
		buttonToViewStatOfReserveLeftDefender.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		
		buttonToViewStatOfReserveRightDefender = new JButton("View stats");
		buttonToViewStatOfReserveRightDefender.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		buttonToViewStatOfReserveRightDefender.addActionListener(this);
		
		buttonToViewReserveAttacker = new JButton("View stats");
		buttonToViewReserveAttacker.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		buttonToViewReserveAttacker.addActionListener(this);
		
		buttonToVIewReserveGoalkeeper = new JButton("View stats");
		buttonToVIewReserveGoalkeeper.addActionListener(this);
		buttonToVIewReserveGoalkeeper.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		GroupLayout glJLabelForAllviewstatButtonOfReservePlayers = new GroupLayout(jLabelForAllviewstatButtonOfReservePlayers);
		glJLabelForAllviewstatButtonOfReservePlayers.setHorizontalGroup(
			glJLabelForAllviewstatButtonOfReservePlayers.createParallelGroup(Alignment.LEADING)
				.addGap(0, 338, Short.MAX_VALUE)
				.addGroup(glJLabelForAllviewstatButtonOfReservePlayers.createSequentialGroup()
					.addComponent(buttonToViewStatOfReserveLeftDefender, GroupLayout.PREFERRED_SIZE, 65, Short.MAX_VALUE)
					.addGap(28)
					.addComponent(buttonToViewStatOfReserveRightDefender, GroupLayout.PREFERRED_SIZE, 65, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(buttonToViewReserveAttacker, GroupLayout.PREFERRED_SIZE, 65, Short.MAX_VALUE)
					.addGap(23)
					.addComponent(buttonToVIewReserveGoalkeeper, GroupLayout.PREFERRED_SIZE, 65, Short.MAX_VALUE))
		);
		glJLabelForAllviewstatButtonOfReservePlayers.setVerticalGroup(
			glJLabelForAllviewstatButtonOfReservePlayers.createParallelGroup(Alignment.LEADING)
				.addGap(0, 15, Short.MAX_VALUE)
				.addGroup(glJLabelForAllviewstatButtonOfReservePlayers.createSequentialGroup()
					.addComponent(buttonToViewReserveAttacker, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(glJLabelForAllviewstatButtonOfReservePlayers.createSequentialGroup()
					.addComponent(buttonToVIewReserveGoalkeeper, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(glJLabelForAllviewstatButtonOfReservePlayers.createSequentialGroup()
					.addGroup(glJLabelForAllviewstatButtonOfReservePlayers.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(buttonToViewStatOfReserveLeftDefender, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(buttonToViewStatOfReserveRightDefender, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 15, Short.MAX_VALUE))
					.addContainerGap())
		);
		jLabelForAllviewstatButtonOfReservePlayers.setLayout(glJLabelForAllviewstatButtonOfReservePlayers);
		
		JPanel jLabelAllProPlayerPurchaseButtonBox = new JPanel();
		jLabelAllProPlayerPurchaseButtonBox.setBackground(SystemColor.menu);
		
		purchaseProLeftDefenderAsReserveButton = new JButton("Buy player");
		purchaseProLeftDefenderAsReserveButton.addActionListener(this);
		purchaseProLeftDefenderAsReserveButton.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		
		purchaseProRightDefenderAsReserveButton = new JButton("Buy player");
		purchaseProRightDefenderAsReserveButton.addActionListener(this);
		purchaseProRightDefenderAsReserveButton.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		
		purchaseProAttackerAsReserveButton = new JButton("Buy player");
		purchaseProAttackerAsReserveButton.addActionListener(this);
		purchaseProAttackerAsReserveButton.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		
		purchaseProGoalKeeperAsReserveButton = new JButton("Buy player");
		purchaseProGoalKeeperAsReserveButton.addActionListener(this);
		purchaseProGoalKeeperAsReserveButton.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		

		
		
		purchaseProLeftDefenderButton = new JButton("Buy player");
		purchaseProLeftDefenderButton.addActionListener(this);
		purchaseProLeftDefenderButton.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		
		purchaseProRIghtDefenderButton = new JButton("Buy player");
		purchaseProRIghtDefenderButton.addActionListener(this);
		purchaseProRIghtDefenderButton.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		
		purchaseProAttackerButton = new JButton("Buy player");
		purchaseProAttackerButton.addActionListener(this);
		purchaseProAttackerButton.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		
		purchaseProGoalkeeperButton = new JButton("Buy player");
		purchaseProGoalkeeperButton.addActionListener(this);
		purchaseProGoalkeeperButton.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		
		

		pro_reserves = new ArrayList<JButton>();
		pro_reserves.add(purchaseProGoalKeeperAsReserveButton);
		pro_reserves.add(purchaseProLeftDefenderAsReserveButton);
		pro_reserves.add(purchaseProRightDefenderAsReserveButton);
		pro_reserves.add(purchaseProAttackerAsReserveButton);
		
		JLabel jLabelInstructionForBuyProPlayerTwo = new JLabel("Buy players for the playing squad");
		jLabelInstructionForBuyProPlayerTwo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabelInstructionForBuyProPlayerTwo.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout glJLabelAllProPlayerPurchaseButtonBox = new GroupLayout(jLabelAllProPlayerPurchaseButtonBox);
		glJLabelAllProPlayerPurchaseButtonBox.setHorizontalGroup(
			glJLabelAllProPlayerPurchaseButtonBox.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, glJLabelAllProPlayerPurchaseButtonBox.createSequentialGroup()
					.addGroup(glJLabelAllProPlayerPurchaseButtonBox.createParallelGroup(Alignment.LEADING)
						.addGroup(glJLabelAllProPlayerPurchaseButtonBox.createSequentialGroup()
							.addComponent(purchaseProLeftDefenderAsReserveButton, GroupLayout.PREFERRED_SIZE, 81, Short.MAX_VALUE)
							.addGap(28))
						.addGroup(glJLabelAllProPlayerPurchaseButtonBox.createSequentialGroup()
							.addComponent(purchaseProLeftDefenderButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(glJLabelAllProPlayerPurchaseButtonBox.createParallelGroup(Alignment.LEADING)
						.addGroup(glJLabelAllProPlayerPurchaseButtonBox.createSequentialGroup()
							.addComponent(purchaseProRightDefenderAsReserveButton, GroupLayout.PREFERRED_SIZE, 81, Short.MAX_VALUE)
							.addGap(27))
						.addGroup(glJLabelAllProPlayerPurchaseButtonBox.createSequentialGroup()
							.addComponent(purchaseProRIghtDefenderButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(glJLabelAllProPlayerPurchaseButtonBox.createParallelGroup(Alignment.LEADING)
						.addGroup(glJLabelAllProPlayerPurchaseButtonBox.createSequentialGroup()
							.addComponent(purchaseProAttackerButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
							.addComponent(purchaseProGoalkeeperButton, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, glJLabelAllProPlayerPurchaseButtonBox.createSequentialGroup()
							.addComponent(purchaseProAttackerAsReserveButton, GroupLayout.PREFERRED_SIZE, 81, Short.MAX_VALUE)
							.addGap(23)
							.addComponent(purchaseProGoalKeeperAsReserveButton, GroupLayout.PREFERRED_SIZE, 83, Short.MAX_VALUE))))
				.addGroup(glJLabelAllProPlayerPurchaseButtonBox.createSequentialGroup()
					.addComponent(jLabelInstructionForBuyProPlayerTwo, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addContainerGap())
		);
		glJLabelAllProPlayerPurchaseButtonBox.setVerticalGroup(
			glJLabelAllProPlayerPurchaseButtonBox.createParallelGroup(Alignment.LEADING)
				.addGroup(glJLabelAllProPlayerPurchaseButtonBox.createSequentialGroup()
					.addGroup(glJLabelAllProPlayerPurchaseButtonBox.createParallelGroup(Alignment.LEADING)
						.addComponent(purchaseProAttackerAsReserveButton, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(purchaseProGoalKeeperAsReserveButton, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addGroup(glJLabelAllProPlayerPurchaseButtonBox.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(purchaseProLeftDefenderAsReserveButton, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(purchaseProRightDefenderAsReserveButton, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 15, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addComponent(jLabelInstructionForBuyProPlayerTwo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glJLabelAllProPlayerPurchaseButtonBox.createParallelGroup(Alignment.BASELINE)
						.addComponent(purchaseProAttackerButton, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(purchaseProRIghtDefenderButton, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(purchaseProLeftDefenderButton, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(purchaseProGoalkeeperButton, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
		);
		jLabelAllProPlayerPurchaseButtonBox.setLayout(glJLabelAllProPlayerPurchaseButtonBox);
		
		JPanel jLabelForAllPurchaseForAllReserves = new JPanel();
		jLabelForAllPurchaseForAllReserves.setBackground(SystemColor.menu);
		
		buttonToPurchaseReserveLeftDefender = new JButton("Buy player");
		buttonToPurchaseReserveLeftDefender.addActionListener(this);
		buttonToPurchaseReserveLeftDefender.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		

		buttonToPurcahseReserveRIghtDefender = new JButton("Buy player");
		buttonToPurcahseReserveRIghtDefender.addActionListener(this);
		buttonToPurcahseReserveRIghtDefender.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		
		buttonToPurchaseReserveAttacker = new JButton("Buy player");
		buttonToPurchaseReserveAttacker.addActionListener(this);
		buttonToPurchaseReserveAttacker.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		
		buttonToPurchaseReserveGoalKeeper = new JButton("Buy player");
		buttonToPurchaseReserveGoalKeeper.addActionListener(this);
		buttonToPurchaseReserveGoalKeeper.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		
		GroupLayout glJLabelForAllPurchaseForAllReserves = new GroupLayout(jLabelForAllPurchaseForAllReserves);
		glJLabelForAllPurchaseForAllReserves.setHorizontalGroup(
			glJLabelForAllPurchaseForAllReserves.createParallelGroup(Alignment.LEADING)
				.addGap(0, 338, Short.MAX_VALUE)
				.addGroup(glJLabelForAllPurchaseForAllReserves.createSequentialGroup()
					.addComponent(buttonToPurchaseReserveLeftDefender, GroupLayout.PREFERRED_SIZE, 65, Short.MAX_VALUE)
					.addGap(28)
					.addComponent(buttonToPurcahseReserveRIghtDefender, GroupLayout.PREFERRED_SIZE, 65, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(buttonToPurchaseReserveAttacker, GroupLayout.PREFERRED_SIZE, 65, Short.MAX_VALUE)
					.addGap(23)
					.addComponent(buttonToPurchaseReserveGoalKeeper, GroupLayout.PREFERRED_SIZE, 65, Short.MAX_VALUE))
		);
		glJLabelForAllPurchaseForAllReserves.setVerticalGroup(
			glJLabelForAllPurchaseForAllReserves.createParallelGroup(Alignment.LEADING)
				.addGap(0, 15, Short.MAX_VALUE)
				.addGroup(glJLabelForAllPurchaseForAllReserves.createSequentialGroup()
					.addGroup(glJLabelForAllPurchaseForAllReserves.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonToPurchaseReserveAttacker, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonToPurchaseReserveGoalKeeper, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addGroup(glJLabelForAllPurchaseForAllReserves.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(buttonToPurchaseReserveLeftDefender, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(buttonToPurcahseReserveRIghtDefender, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 15, Short.MAX_VALUE)))
					.addContainerGap())
		);
		jLabelForAllPurchaseForAllReserves.setLayout(glJLabelForAllPurchaseForAllReserves);
		
		JPanel displaySelectedPlayerStat = new JPanel();
		displaySelectedPlayerStat.setBackground(new Color(128, 128, 192));
		
		
		
		buttonToViewStatOfProLeftDefender = new JButton("View stats");
		buttonToViewStatOfProLeftDefender.addActionListener(this);
		
		buttonToViewStatOfProLeftDefender.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		buttonToViewStatOfProLeftDefender.addActionListener(this);
		
		buttonToViewStatOfProRightDefender = new JButton("View stats");
		buttonToViewStatOfProRightDefender.addActionListener(this);
		buttonToViewStatOfProRightDefender.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		
		buttonToViewStatOfProAttacker = new JButton("View stats");
		buttonToViewStatOfProAttacker.addActionListener(this);
		buttonToViewStatOfProAttacker.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		
		buttonToViewSatOfProGoalKeeper = new JButton("View stats");
		buttonToViewSatOfProGoalKeeper.addActionListener(this);
		buttonToViewSatOfProGoalKeeper.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		GroupLayout glJLabelForAllViewStatButtonsOfProPlayer = new GroupLayout(jLabelForAllViewStatButtonsOfProPlayer);
		glJLabelForAllViewStatButtonsOfProPlayer.setHorizontalGroup(
			glJLabelForAllViewStatButtonsOfProPlayer.createParallelGroup(Alignment.LEADING)
				.addGroup(glJLabelForAllViewStatButtonsOfProPlayer.createSequentialGroup()
					.addComponent(buttonToViewStatOfProLeftDefender, GroupLayout.PREFERRED_SIZE, 65, Short.MAX_VALUE)
					.addGap(28)
					.addComponent(buttonToViewStatOfProRightDefender, GroupLayout.PREFERRED_SIZE, 65, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(buttonToViewStatOfProAttacker, GroupLayout.PREFERRED_SIZE, 65, Short.MAX_VALUE)
					.addGap(23)
					.addComponent(buttonToViewSatOfProGoalKeeper, GroupLayout.PREFERRED_SIZE, 65, Short.MAX_VALUE))
		);
		glJLabelForAllViewStatButtonsOfProPlayer.setVerticalGroup(
			glJLabelForAllViewStatButtonsOfProPlayer.createParallelGroup(Alignment.LEADING)
				.addGroup(glJLabelForAllViewStatButtonsOfProPlayer.createSequentialGroup()
					.addComponent(buttonToViewStatOfProAttacker, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(glJLabelForAllViewStatButtonsOfProPlayer.createSequentialGroup()
					.addComponent(buttonToViewSatOfProGoalKeeper, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(glJLabelForAllViewStatButtonsOfProPlayer.createSequentialGroup()
					.addGroup(glJLabelForAllViewStatButtonsOfProPlayer.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(buttonToViewStatOfProLeftDefender, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(buttonToViewStatOfProRightDefender, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 15, Short.MAX_VALUE))
					.addContainerGap())
		);
		jLabelForAllViewStatButtonsOfProPlayer.setLayout(glJLabelForAllViewStatButtonsOfProPlayer);
		
		JPanel leftDefenderCard = new JPanel();
		leftDefenderCard.setBackground(new Color(128, 255, 0));
		
		JPanel rightDefenderCard = new JPanel();
		rightDefenderCard.setBackground(new Color(128, 255, 0));
		
		JPanel attackerCard = new JPanel();
		attackerCard.setBackground(new Color(128, 255, 0));
		
		JPanel goalKeeperCard = new JPanel();
		goalKeeperCard.setBackground(new Color(128, 255, 0));
		
		JPanel jLabelForAllViewStatsOfPlayers = new JPanel();
		jLabelForAllViewStatsOfPlayers.setBackground(SystemColor.menu);
		
	
		
		buttonToViewLeftDefender = new JButton("View stats");
		buttonToViewLeftDefender.setEnabled(false);
		buttonToViewLeftDefender.addActionListener(this);
		buttonToViewLeftDefender.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		
		butttonToViewRightDefender = new JButton("View stats");
		butttonToViewRightDefender.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		butttonToViewRightDefender.addActionListener(this);
		butttonToViewRightDefender.setEnabled(false);
		
		buttonToViewstatOfAttacker = new JButton("View stats");
		buttonToViewstatOfAttacker.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		buttonToViewstatOfAttacker.addActionListener(this);
		buttonToViewstatOfAttacker.setEnabled(false);
		
		buttonToViewStatGoalkeeper = new JButton("View stats");
		buttonToViewStatGoalkeeper.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		buttonToViewStatGoalkeeper.addActionListener(this);
		buttonToViewStatGoalkeeper.setEnabled(false);
		
		GroupLayout glJLabelForAllViewStatsOfPlayers = new GroupLayout(jLabelForAllViewStatsOfPlayers);
		glJLabelForAllViewStatsOfPlayers.setHorizontalGroup(
			glJLabelForAllViewStatsOfPlayers.createParallelGroup(Alignment.LEADING)
				.addGap(0, 404, Short.MAX_VALUE)
				.addGroup(glJLabelForAllViewStatsOfPlayers.createSequentialGroup()
					.addComponent(buttonToViewLeftDefender, GroupLayout.PREFERRED_SIZE, 81, Short.MAX_VALUE)
					.addGap(28)
					.addComponent(butttonToViewRightDefender, GroupLayout.PREFERRED_SIZE, 81, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(buttonToViewstatOfAttacker, GroupLayout.PREFERRED_SIZE, 81, Short.MAX_VALUE)
					.addGap(23)
					.addComponent(buttonToViewStatGoalkeeper, GroupLayout.PREFERRED_SIZE, 83, Short.MAX_VALUE))
		);
		glJLabelForAllViewStatsOfPlayers.setVerticalGroup(
			glJLabelForAllViewStatsOfPlayers.createParallelGroup(Alignment.LEADING)
				.addGap(0, 15, Short.MAX_VALUE)
				.addGroup(glJLabelForAllViewStatsOfPlayers.createSequentialGroup()
					.addGroup(glJLabelForAllViewStatsOfPlayers.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonToViewstatOfAttacker, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonToViewStatGoalkeeper, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addGroup(glJLabelForAllViewStatsOfPlayers.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(buttonToViewLeftDefender, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(butttonToViewRightDefender, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 15, Short.MAX_VALUE)))
					.addContainerGap())
		);
		jLabelForAllViewStatsOfPlayers.setLayout(glJLabelForAllViewStatsOfPlayers);
		
		JPanel jLabelForAllPlayerPurchaseButtons = new JPanel();
		jLabelForAllPlayerPurchaseButtons.setBackground(SystemColor.menu);
		
		
		

		buttonToPurchaseLeftDefender = new JButton("sold");
		buttonToPurchaseLeftDefender.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		buttonToPurchaseLeftDefender.setEnabled(false);
		buttonToPurchaseLeftDefender.addActionListener(this);
		
		
		buttonToPurchaseRightDefender = new JButton("sold");
		buttonToPurchaseRightDefender.setEnabled(false);
		buttonToPurchaseRightDefender.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		buttonToPurchaseRightDefender.addActionListener(this);
		
		buttonToPurchaseAttacker = new JButton("sold");
		buttonToPurchaseAttacker.setEnabled(false);
		buttonToPurchaseAttacker.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		buttonToPurchaseAttacker.addActionListener(this);
		
		buttonToPurchaseGoalKeeper = new JButton("sold");
		buttonToPurchaseGoalKeeper.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		buttonToPurchaseGoalKeeper.setEnabled(false);
		buttonToPurchaseGoalKeeper.addActionListener(this);
		GroupLayout glJLabelForAllPlayerPurchaseButtons = new GroupLayout(jLabelForAllPlayerPurchaseButtons);
		glJLabelForAllPlayerPurchaseButtons.setHorizontalGroup(
			glJLabelForAllPlayerPurchaseButtons.createParallelGroup(Alignment.LEADING)
				.addGap(0, 404, Short.MAX_VALUE)
				.addGroup(glJLabelForAllPlayerPurchaseButtons.createSequentialGroup()
					.addComponent(buttonToPurchaseLeftDefender, GroupLayout.PREFERRED_SIZE, 81, Short.MAX_VALUE)
					.addGap(28)
					.addComponent(buttonToPurchaseRightDefender, GroupLayout.PREFERRED_SIZE, 81, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(buttonToPurchaseAttacker, GroupLayout.PREFERRED_SIZE, 81, Short.MAX_VALUE)
					.addGap(23)
					.addComponent(buttonToPurchaseGoalKeeper, GroupLayout.PREFERRED_SIZE, 83, Short.MAX_VALUE))
		);
		glJLabelForAllPlayerPurchaseButtons.setVerticalGroup(
			glJLabelForAllPlayerPurchaseButtons.createParallelGroup(Alignment.LEADING)
				.addGap(0, 18, Short.MAX_VALUE)
				.addGroup(glJLabelForAllPlayerPurchaseButtons.createSequentialGroup()
					.addGroup(glJLabelForAllPlayerPurchaseButtons.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonToPurchaseAttacker, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonToPurchaseGoalKeeper, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addGroup(glJLabelForAllPlayerPurchaseButtons.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(buttonToPurchaseLeftDefender, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(buttonToPurchaseRightDefender, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 15, Short.MAX_VALUE)))
					.addContainerGap())
		);
		jLabelForAllPlayerPurchaseButtons.setLayout(glJLabelForAllPlayerPurchaseButtons);
		
		WarningJLabelForAllPurchasePlayer = new JLabel("Warning: ");
		
		jLabelInstructionForBuyProPlayerOne = new JLabel("Buy players as reserves");
		jLabelInstructionForBuyProPlayerOne.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabelInstructionForBuyProPlayerOne.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout glPanelContainingPurchasablePlayers = new GroupLayout(panelContainingPurchasablePlayers);
		glPanelContainingPurchasablePlayers.setHorizontalGroup(
			glPanelContainingPurchasablePlayers.createParallelGroup(Alignment.LEADING)
				.addGroup(glPanelContainingPurchasablePlayers.createSequentialGroup()
					.addContainerGap()
					.addGroup(glPanelContainingPurchasablePlayers.createParallelGroup(Alignment.TRAILING)
						.addGroup(glPanelContainingPurchasablePlayers.createSequentialGroup()
							.addGroup(glPanelContainingPurchasablePlayers.createParallelGroup(Alignment.LEADING, false)
								.addGroup(glPanelContainingPurchasablePlayers.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(leftDefenderCard, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(rightDefenderCard, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addGap(27)
									.addComponent(attackerCard, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(goalKeeperCard, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
								.addGroup(glPanelContainingPurchasablePlayers.createSequentialGroup()
									.addGap(10)
									.addGroup(glPanelContainingPurchasablePlayers.createParallelGroup(Alignment.LEADING)
										.addComponent(jLabelAllProPlayerPurchaseButtonBox, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
										.addGroup(glPanelContainingPurchasablePlayers.createSequentialGroup()
											.addComponent(proLeftDefenderCard, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
											.addGap(26)
											.addComponent(proRightDefenderCard, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
											.addGap(26)
											.addComponent(proAttackerCard, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
											.addGap(26)
											.addComponent(proGoalKeeeprCard, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
										.addComponent(jLabelForAllViewStatButtonsOfProPlayer, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
										.addGroup(glPanelContainingPurchasablePlayers.createSequentialGroup()
											.addComponent(reserveLeftDefenderCard, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
											.addGap(26)
											.addComponent(reserveRightDefenderCard, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
											.addGap(26)
											.addComponent(reserveAttackerCard, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
											.addGap(26)
											.addComponent(reserveGoalKeeperCard, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
										.addComponent(jLabelForAllviewstatButtonOfReservePlayers, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabelForAllPurchaseForAllReserves, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.UNRELATED))
						.addGroup(glPanelContainingPurchasablePlayers.createSequentialGroup()
							.addComponent(jLabelInstructionForBuyProPlayerOne, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
							.addGap(14)))
					.addComponent(displaySelectedPlayerStat, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
				.addGroup(glPanelContainingPurchasablePlayers.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabelForAllViewStatsOfPlayers, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(259, Short.MAX_VALUE))
				.addGroup(glPanelContainingPurchasablePlayers.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabelForAllPlayerPurchaseButtons, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(259, Short.MAX_VALUE))
				.addGroup(glPanelContainingPurchasablePlayers.createSequentialGroup()
					.addContainerGap()
					.addComponent(WarningJLabelForAllPurchasePlayer, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(294, Short.MAX_VALUE))
		);
		glPanelContainingPurchasablePlayers.setVerticalGroup(
			glPanelContainingPurchasablePlayers.createParallelGroup(Alignment.LEADING)
				.addGroup(glPanelContainingPurchasablePlayers.createSequentialGroup()
					.addGap(7)
					.addComponent(WarningJLabelForAllPurchasePlayer, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glPanelContainingPurchasablePlayers.createParallelGroup(Alignment.LEADING)
						.addGroup(glPanelContainingPurchasablePlayers.createSequentialGroup()
							.addGroup(glPanelContainingPurchasablePlayers.createParallelGroup(Alignment.LEADING)
								.addComponent(proLeftDefenderCard, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(proRightDefenderCard, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(proAttackerCard, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(proGoalKeeeprCard, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addComponent(jLabelForAllViewStatButtonsOfProPlayer, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(jLabelInstructionForBuyProPlayerOne)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jLabelAllProPlayerPurchaseButtonBox, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(glPanelContainingPurchasablePlayers.createParallelGroup(Alignment.LEADING)
								.addComponent(reserveLeftDefenderCard, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
								.addComponent(reserveRightDefenderCard, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
								.addComponent(reserveAttackerCard, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
								.addComponent(reserveGoalKeeperCard, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addComponent(jLabelForAllviewstatButtonOfReservePlayers, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(jLabelForAllPurchaseForAllReserves, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
						.addComponent(displaySelectedPlayerStat, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glPanelContainingPurchasablePlayers.createParallelGroup(Alignment.LEADING)
						.addComponent(rightDefenderCard, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
						.addComponent(attackerCard, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
						.addComponent(goalKeeperCard, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
						.addComponent(leftDefenderCard, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jLabelForAllViewStatsOfPlayers, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jLabelForAllPlayerPurchaseButtons, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		
		goalKeeperCurrentPrice = new JLabel("current price: 200");
		goalKeeperCurrentPrice.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GroupLayout glGoalKeeperCard = new GroupLayout(goalKeeperCard);
		glGoalKeeperCard.setHorizontalGroup(
			glGoalKeeperCard.createParallelGroup(Alignment.LEADING)
				.addComponent(goalKeeperCurrentPrice, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
		);
		glGoalKeeperCard.setVerticalGroup(
			glGoalKeeperCard.createParallelGroup(Alignment.TRAILING)
				.addGroup(glGoalKeeperCard.createSequentialGroup()
					.addContainerGap(110, Short.MAX_VALUE)
					.addComponent(goalKeeperCurrentPrice)
					.addContainerGap())
		);
		goalKeeperCard.setLayout(glGoalKeeperCard);
		
		attackerCurrentPrice = new JLabel("current price: 200");
		attackerCurrentPrice.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GroupLayout glAttackerCard = new GroupLayout(attackerCard);
		glAttackerCard.setHorizontalGroup(
			glAttackerCard.createParallelGroup(Alignment.LEADING)
				.addComponent(attackerCurrentPrice, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
		);
		glAttackerCard.setVerticalGroup(
			glAttackerCard.createParallelGroup(Alignment.TRAILING)
				.addGroup(glAttackerCard.createSequentialGroup()
					.addContainerGap(110, Short.MAX_VALUE)
					.addComponent(attackerCurrentPrice)
					.addContainerGap())
		);
		attackerCard.setLayout(glAttackerCard);
		
		rightDefenderCurrentPrice = new JLabel("current price: 200");
		rightDefenderCurrentPrice.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GroupLayout glRightDefenderCard = new GroupLayout(rightDefenderCard);
		glRightDefenderCard.setHorizontalGroup(
			glRightDefenderCard.createParallelGroup(Alignment.LEADING)
				.addComponent(rightDefenderCurrentPrice, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
		);
		glRightDefenderCard.setVerticalGroup(
			glRightDefenderCard.createParallelGroup(Alignment.TRAILING)
				.addGroup(glRightDefenderCard.createSequentialGroup()
					.addContainerGap(110, Short.MAX_VALUE)
					.addComponent(rightDefenderCurrentPrice)
					.addContainerGap())
		);
		rightDefenderCard.setLayout(glRightDefenderCard);
		
		leftDefenderCurrentPrice = new JLabel("current price: 200");
		leftDefenderCurrentPrice.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GroupLayout glLeftDefenderCard = new GroupLayout(leftDefenderCard);
		glLeftDefenderCard.setHorizontalGroup(
			glLeftDefenderCard.createParallelGroup(Alignment.LEADING)
				.addComponent(leftDefenderCurrentPrice, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
		);
		glLeftDefenderCard.setVerticalGroup(
			glLeftDefenderCard.createParallelGroup(Alignment.TRAILING)
				.addGroup(glLeftDefenderCard.createSequentialGroup()
					.addContainerGap(110, Short.MAX_VALUE)
					.addComponent(leftDefenderCurrentPrice)
					.addContainerGap())
		);
		leftDefenderCard.setLayout(glLeftDefenderCard);
		
		
		reserveGoalKeeperCurrentPrice = new JLabel("current price: 200");
		reserveGoalKeeperCurrentPrice.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GroupLayout glReserveGoalKeeperCard = new GroupLayout(reserveGoalKeeperCard);
		glReserveGoalKeeperCard.setHorizontalGroup(
			glReserveGoalKeeperCard.createParallelGroup(Alignment.LEADING)
				.addComponent(reserveGoalKeeperCurrentPrice, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
		);
		glReserveGoalKeeperCard.setVerticalGroup(
			glReserveGoalKeeperCard.createParallelGroup(Alignment.TRAILING)
				.addGroup(glReserveGoalKeeperCard.createSequentialGroup()
					.addContainerGap(110, Short.MAX_VALUE)
					.addComponent(reserveGoalKeeperCurrentPrice)
					.addContainerGap())
		);
		
		reserveGoalKeeperCard.setLayout(glReserveGoalKeeperCard);

		reserveAttackerCurrentPrice = new JLabel("current price: 200");
		reserveAttackerCurrentPrice.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GroupLayout glReserveAttackerCard = new GroupLayout(reserveAttackerCard);
		glReserveAttackerCard.setHorizontalGroup(
			glReserveAttackerCard.createParallelGroup(Alignment.LEADING)
				.addComponent(reserveAttackerCurrentPrice, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
		);
		glReserveAttackerCard.setVerticalGroup(
			glReserveAttackerCard.createParallelGroup(Alignment.TRAILING)
				.addGroup(glReserveAttackerCard.createSequentialGroup()
					.addContainerGap(110, Short.MAX_VALUE)
					.addComponent(reserveAttackerCurrentPrice)
					.addContainerGap())
		);
		reserveAttackerCard.setLayout(glReserveAttackerCard);
	
		reserveRightDefenderCurrentPrice = new JLabel("current price: 200");
		reserveRightDefenderCurrentPrice.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GroupLayout glReserveRightDefenderCard = new GroupLayout(reserveRightDefenderCard);
		glReserveRightDefenderCard.setHorizontalGroup(
			glReserveRightDefenderCard.createParallelGroup(Alignment.LEADING)
				.addComponent(reserveRightDefenderCurrentPrice, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
		);
		glReserveRightDefenderCard.setVerticalGroup(
			glReserveRightDefenderCard.createParallelGroup(Alignment.TRAILING)
				.addGroup(glReserveRightDefenderCard.createSequentialGroup()
					.addContainerGap(110, Short.MAX_VALUE)
					.addComponent(reserveRightDefenderCurrentPrice)
					.addContainerGap())
		);
		reserveRightDefenderCard.setLayout(glReserveRightDefenderCard);
		
		reserveLeftDefenderCurrentPrice = new JLabel("current price: 200");
		reserveLeftDefenderCurrentPrice.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GroupLayout glReserveLeftDefenderCard = new GroupLayout(reserveLeftDefenderCard);
		glReserveLeftDefenderCard.setHorizontalGroup(
			glReserveLeftDefenderCard.createParallelGroup(Alignment.LEADING)
				.addComponent(reserveLeftDefenderCurrentPrice, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
		);
		glReserveLeftDefenderCard.setVerticalGroup(
			glReserveLeftDefenderCard.createParallelGroup(Alignment.TRAILING)
				.addGroup(glReserveLeftDefenderCard.createSequentialGroup()
					.addContainerGap(110, Short.MAX_VALUE)
					.addComponent(reserveLeftDefenderCurrentPrice)
					.addContainerGap())
		);
		reserveLeftDefenderCard.setLayout(glReserveLeftDefenderCard);
		
	
		proGoalKeeperCurrentPrice = new JLabel("current price: 800");
		proGoalKeeperCurrentPrice.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GroupLayout glProGoalKeeeprCard = new GroupLayout(proGoalKeeeprCard);
		glProGoalKeeeprCard.setHorizontalGroup(
			glProGoalKeeeprCard.createParallelGroup(Alignment.LEADING)
				.addComponent(proGoalKeeperCurrentPrice, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
		);
		glProGoalKeeeprCard.setVerticalGroup(
			glProGoalKeeeprCard.createParallelGroup(Alignment.TRAILING)
				.addGroup(glProGoalKeeeprCard.createSequentialGroup()
					.addContainerGap(109, Short.MAX_VALUE)
					.addComponent(proGoalKeeperCurrentPrice)
					.addContainerGap())
		);
		proGoalKeeeprCard.setLayout(glProGoalKeeeprCard);
		
	
		proAttackerCurrentPrice = new JLabel("current price: 800");
		proAttackerCurrentPrice.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GroupLayout glProAttackerCard = new GroupLayout(proAttackerCard);
		glProAttackerCard.setHorizontalGroup(
			glProAttackerCard.createParallelGroup(Alignment.LEADING)
				.addComponent(proAttackerCurrentPrice, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
		);
		glProAttackerCard.setVerticalGroup(
			glProAttackerCard.createParallelGroup(Alignment.TRAILING)
				.addGroup(glProAttackerCard.createSequentialGroup()
					.addContainerGap(109, Short.MAX_VALUE)
					.addComponent(proAttackerCurrentPrice)
					.addContainerGap())
		);
		proAttackerCard.setLayout(glProAttackerCard);
		
		proRightDefenderCurrentPrice = new JLabel("current price: 800");
		proRightDefenderCurrentPrice.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GroupLayout glProRightDefenderCard = new GroupLayout(proRightDefenderCard);
		glProRightDefenderCard.setHorizontalGroup(
			glProRightDefenderCard.createParallelGroup(Alignment.LEADING)
				.addComponent(proRightDefenderCurrentPrice, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
		);
		glProRightDefenderCard.setVerticalGroup(
			glProRightDefenderCard.createParallelGroup(Alignment.TRAILING)
				.addGroup(glProRightDefenderCard.createSequentialGroup()
					.addContainerGap(109, Short.MAX_VALUE)
					.addComponent(proRightDefenderCurrentPrice)
					.addContainerGap())
		);
		proRightDefenderCard.setLayout(glProRightDefenderCard);
		
		proLeftDefenderCurrentPRice = new JLabel("current price: 800");
		proLeftDefenderCurrentPRice.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GroupLayout glProLeftDefenderCard = new GroupLayout(proLeftDefenderCard);
		glProLeftDefenderCard.setHorizontalGroup(
			glProLeftDefenderCard.createParallelGroup(Alignment.LEADING)
				.addComponent(proLeftDefenderCurrentPRice, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
		);
		glProLeftDefenderCard.setVerticalGroup(
			glProLeftDefenderCard.createParallelGroup(Alignment.TRAILING)
				.addGroup(glProLeftDefenderCard.createSequentialGroup()
					.addContainerGap(109, Short.MAX_VALUE)
					.addComponent(proLeftDefenderCurrentPRice)
					.addContainerGap())
		);
		proLeftDefenderCard.setLayout(glProLeftDefenderCard);
		
		allPlayerNameDisplayJLabel = new JLabel("Hi my name is ");
		allPlayerNameDisplayJLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		allPlayerNameDisplayJLabel.setHorizontalAlignment(SwingConstants.CENTER);
	
		
		staminaLabel = new JLabel("Stamina:");
		
		offenseLabel = new JLabel("Offense: ");
		
		defenceLabel = new JLabel("Defence: ");
		
		reflexLabel = new JLabel("Reflex: ");
		
		positionLabel = new JLabel("Position: ");
		
		GroupLayout glDisplaySelectedPlayerStat = new GroupLayout(displaySelectedPlayerStat);
		glDisplaySelectedPlayerStat.setHorizontalGroup(
			glDisplaySelectedPlayerStat.createParallelGroup(Alignment.LEADING)
				.addGroup(glDisplaySelectedPlayerStat.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(allPlayerNameDisplayJLabel, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addGap(73))
				.addGroup(glDisplaySelectedPlayerStat.createSequentialGroup()
					.addContainerGap()
					.addComponent(staminaLabel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(165, Short.MAX_VALUE))
				.addGroup(glDisplaySelectedPlayerStat.createSequentialGroup()
					.addContainerGap()
					.addComponent(offenseLabel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(165, Short.MAX_VALUE))
				.addGroup(glDisplaySelectedPlayerStat.createSequentialGroup()
					.addContainerGap()
					.addComponent(defenceLabel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(165, Short.MAX_VALUE))
				.addGroup(glDisplaySelectedPlayerStat.createSequentialGroup()
					.addContainerGap()
					.addComponent(reflexLabel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(165, Short.MAX_VALUE))
				.addGroup(glDisplaySelectedPlayerStat.createSequentialGroup()
					.addContainerGap()
					.addComponent(positionLabel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(91, Short.MAX_VALUE))
		);
		glDisplaySelectedPlayerStat.setVerticalGroup(
			glDisplaySelectedPlayerStat.createParallelGroup(Alignment.LEADING)
				.addGroup(glDisplaySelectedPlayerStat.createSequentialGroup()
					.addContainerGap()
					.addComponent(allPlayerNameDisplayJLabel)
					.addGap(98)
					.addComponent(staminaLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(offenseLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(defenceLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(reflexLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(positionLabel)
					.addContainerGap(147, Short.MAX_VALUE))
		);
		displaySelectedPlayerStat.setLayout(glDisplaySelectedPlayerStat);
		panelContainingPurchasablePlayers.setLayout(glPanelContainingPurchasablePlayers);
		
		JLabel JLabelForTheTitleOfReserveAndProPlayersPartOfTheMarket = new JLabel("Reserve and Pro players ");
		purchasablePlayingListJScrollPanel.setColumnHeaderView(JLabelForTheTitleOfReserveAndProPlayersPartOfTheMarket);
		JLabelForTheTitleOfReserveAndProPlayersPartOfTheMarket.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JLabelForTheTitleOfReserveAndProPlayersPartOfTheMarket.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelContainingPurchasedItem = new JPanel();
		panelContainingPurchasedItem.setPreferredSize(new Dimension(450, 500));
		inventoryItems.setViewportView(panelContainingPurchasedItem);
		
		goalkeeperTrainingPassReturnBackButton = new JButton("goalkeeper training pass sale back price");
		goalkeeperTrainingPassReturnBackButton.setEnabled(false);
		goalkeeperTrainingPassReturnBackButton.addActionListener(this);
		
		defenceTrainingPassReturnBackButton = new JButton("Defender training pass sale back price");
		defenceTrainingPassReturnBackButton.setEnabled(false);
		defenceTrainingPassReturnBackButton.addActionListener(this);
		
		attackerTrainingPassReturnBackButton = new JButton("Attacker training passs sale back price");
		attackerTrainingPassReturnBackButton.setEnabled(false);
		attackerTrainingPassReturnBackButton.addActionListener(this);
		
		proteinSuppliementSaleBackButton = new JButton("Protein suppliment sale back price");
		proteinSuppliementSaleBackButton.setEnabled(false);
		proteinSuppliementSaleBackButton.addActionListener(this);
		
		goalKeeperSaleBackTextField = new JTextField();
		goalKeeperSaleBackTextField.setColumns(10);
		goalKeeperSaleBackTextField.setEnabled(false);
		
		defenfderSaleBackTextField = new JTextField();
		defenfderSaleBackTextField.setColumns(10);
		defenfderSaleBackTextField.setEnabled(false);
		
		attackerSaleBackTextField = new JTextField();
		attackerSaleBackTextField.setColumns(10);
		attackerSaleBackTextField.setEnabled(false);
		
		proteinSupplimenentReturnBackTextField = new JTextField();
		proteinSupplimenentReturnBackTextField.setColumns(10);
		proteinSupplimenentReturnBackTextField.setEnabled(false);
		
		
		goalKeeperSoldBackTrainingWarningDisplayLabel = new JLabel("Warning: ");
		goalKeeperSoldBackTrainingWarningDisplayLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		defenderSoldBackTrainingWarningDisplayLabel = new JLabel("Warning: ");
		defenderSoldBackTrainingWarningDisplayLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		attackerSolderBackTrainingWarningDisplayLabel = new JLabel("Warning: ");
		attackerSolderBackTrainingWarningDisplayLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		proteinSuppliementSoldbackDisplay = new JLabel("Warning: ");
		proteinSuppliementSoldbackDisplay.setHorizontalAlignment(SwingConstants.LEFT);
		
		confirmDefenderPassReturnBackButton = new JButton("confirm");
		confirmDefenderPassReturnBackButton.addActionListener(this);
		
		
		confirmAttackerPassReturnBackButton = new JButton("confirm");
		confirmAttackerPassReturnBackButton.addActionListener(this);
		
		
		
		proteinSuppliementReturnBackButton = new JButton("confirm");
		proteinSuppliementReturnBackButton.addActionListener(this);
		
		
		
		confirmGoalKeeperPassReturnBackButton = new JButton("confirm");
		confirmGoalKeeperPassReturnBackButton.addActionListener(this);

		
		

		
		JLabel itemReturnInstruction = new JLabel("<html><p>Enter the number of items to sale back and press the \"sale back price\" button  to check their price.</html>.");
		itemReturnInstruction.setFont(new Font("Tahoma", Font.PLAIN, 9));
		itemReturnInstruction.setHorizontalAlignment(SwingConstants.LEFT);
		
		remainingGoalKeeperPassLabel = new JLabel("number remaining: "+ClubRoom.numberOfWeeklPassesForGoalkeeper);
		remainingDefenderPassLabel = new JLabel("number remaining: "+ClubRoom.numberOfWeeklyPassesForDefenders);
		remainingAttackerPassLabel = new JLabel("number remaining: "+ClubRoom.numberOfWeeklyPassesForAttackers);
		remainingProteinSuppliementPassDisplay = new JLabel("number remaining: "+ClubRoom.numberOfProteinSuppliements);
	
		
		
		
		
		
	
		
	
	
		
		GroupLayout glPanelContainingPurchasedItem = new GroupLayout(panelContainingPurchasedItem);
		glPanelContainingPurchasedItem.setHorizontalGroup(
			glPanelContainingPurchasedItem.createParallelGroup(Alignment.LEADING)
				.addGroup(glPanelContainingPurchasedItem.createSequentialGroup()
					.addGap(28)
					.addGroup(glPanelContainingPurchasedItem.createParallelGroup(Alignment.TRAILING)
						.addGroup(glPanelContainingPurchasedItem.createSequentialGroup()
							.addComponent(goalKeeperSoldBackTrainingWarningDisplayLabel, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
							.addGap(286))
						.addGroup(glPanelContainingPurchasedItem.createSequentialGroup()
							.addGroup(glPanelContainingPurchasedItem.createParallelGroup(Alignment.LEADING)
								.addGroup(glPanelContainingPurchasedItem.createSequentialGroup()
									.addComponent(goalkeeperTrainingPassReturnBackButton, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
									.addGap(40))
								.addGroup(glPanelContainingPurchasedItem.createSequentialGroup()
									.addComponent(remainingGoalKeeperPassLabel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(glPanelContainingPurchasedItem.createParallelGroup(Alignment.LEADING)
								.addComponent(goalKeeperSaleBackTextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
								.addComponent(confirmGoalKeeperPassReturnBackButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
								.addComponent(itemReturnInstruction, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)))
						.addGroup(glPanelContainingPurchasedItem.createSequentialGroup()
							.addGroup(glPanelContainingPurchasedItem.createParallelGroup(Alignment.LEADING)
								.addGroup(glPanelContainingPurchasedItem.createSequentialGroup()
									.addComponent(defenceTrainingPassReturnBackButton, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
									.addGap(40))
								.addGroup(glPanelContainingPurchasedItem.createSequentialGroup()
									.addComponent(defenderSoldBackTrainingWarningDisplayLabel, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(glPanelContainingPurchasedItem.createSequentialGroup()
									.addComponent(remainingDefenderPassLabel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(glPanelContainingPurchasedItem.createParallelGroup(Alignment.LEADING)
								.addComponent(confirmDefenderPassReturnBackButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
								.addComponent(defenfderSaleBackTextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)))
						.addGroup(glPanelContainingPurchasedItem.createSequentialGroup()
							.addGroup(glPanelContainingPurchasedItem.createParallelGroup(Alignment.LEADING)
								.addGroup(glPanelContainingPurchasedItem.createSequentialGroup()
									.addComponent(attackerTrainingPassReturnBackButton, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
									.addGap(40))
								.addGroup(glPanelContainingPurchasedItem.createSequentialGroup()
									.addComponent(attackerSolderBackTrainingWarningDisplayLabel, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
									.addGap(12))
								.addGroup(glPanelContainingPurchasedItem.createSequentialGroup()
									.addComponent(remainingAttackerPassLabel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(glPanelContainingPurchasedItem.createParallelGroup(Alignment.LEADING)
								.addComponent(confirmAttackerPassReturnBackButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
								.addComponent(attackerSaleBackTextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)))
						.addGroup(glPanelContainingPurchasedItem.createSequentialGroup()
							.addGroup(glPanelContainingPurchasedItem.createParallelGroup(Alignment.LEADING)
								.addGroup(glPanelContainingPurchasedItem.createSequentialGroup()
									.addComponent(proteinSuppliementSoldbackDisplay, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
									.addGap(9))
								.addGroup(glPanelContainingPurchasedItem.createSequentialGroup()
									.addComponent(proteinSuppliementSaleBackButton, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
									.addGap(42))
								.addGroup(glPanelContainingPurchasedItem.createSequentialGroup()
									.addComponent(remainingProteinSuppliementPassDisplay, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(glPanelContainingPurchasedItem.createParallelGroup(Alignment.LEADING)
								.addComponent(proteinSuppliementReturnBackButton, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
								.addComponent(proteinSupplimenentReturnBackTextField, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))))
					.addContainerGap())
		);
		glPanelContainingPurchasedItem.setVerticalGroup(
			glPanelContainingPurchasedItem.createParallelGroup(Alignment.LEADING)
				.addGroup(glPanelContainingPurchasedItem.createSequentialGroup()
					.addContainerGap()
					.addGroup(glPanelContainingPurchasedItem.createParallelGroup(Alignment.TRAILING)
						.addComponent(itemReturnInstruction)
						.addComponent(remainingGoalKeeperPassLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glPanelContainingPurchasedItem.createParallelGroup(Alignment.BASELINE)
						.addComponent(goalKeeperSaleBackTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(goalkeeperTrainingPassReturnBackButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glPanelContainingPurchasedItem.createParallelGroup(Alignment.BASELINE)
						.addComponent(goalKeeperSoldBackTrainingWarningDisplayLabel)
						.addComponent(confirmGoalKeeperPassReturnBackButton))
					.addGap(18)
					.addComponent(remainingDefenderPassLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glPanelContainingPurchasedItem.createParallelGroup(Alignment.BASELINE)
						.addComponent(defenceTrainingPassReturnBackButton)
						.addComponent(defenfderSaleBackTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glPanelContainingPurchasedItem.createParallelGroup(Alignment.LEADING)
						.addComponent(defenderSoldBackTrainingWarningDisplayLabel)
						.addComponent(confirmDefenderPassReturnBackButton))
					.addGap(18)
					.addComponent(remainingAttackerPassLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glPanelContainingPurchasedItem.createParallelGroup(Alignment.BASELINE)
						.addComponent(attackerTrainingPassReturnBackButton)
						.addComponent(attackerSaleBackTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glPanelContainingPurchasedItem.createParallelGroup(Alignment.BASELINE)
						.addComponent(attackerSolderBackTrainingWarningDisplayLabel)
						.addComponent(confirmAttackerPassReturnBackButton))
					.addGap(18)
					.addComponent(remainingProteinSuppliementPassDisplay)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glPanelContainingPurchasedItem.createParallelGroup(Alignment.BASELINE)
						.addComponent(proteinSuppliementSaleBackButton)
						.addComponent(proteinSupplimenentReturnBackTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glPanelContainingPurchasedItem.createParallelGroup(Alignment.BASELINE)
						.addComponent(proteinSuppliementSoldbackDisplay)
						.addComponent(proteinSuppliementReturnBackButton))
					.addContainerGap(409, Short.MAX_VALUE))
		);
		panelContainingPurchasedItem.setLayout(glPanelContainingPurchasedItem);
		
		JLabel jLabelForInventoryItemReturnSection = new JLabel("Item return ");
		inventoryItems.setColumnHeaderView(jLabelForInventoryItemReturnSection);
		jLabelForInventoryItemReturnSection.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelForInventoryItemReturnSection.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(30, 350));
		itemShop.setViewportView(panel);
		
		goalKeeperTrainingPassButton = new JButton("weekly training pass for goalkeepers");
		goalKeeperTrainingPassButton.addActionListener(this);
		defenceTrainingPassButton = new JButton("weekly training pass for defenders ");
		defenceTrainingPassButton.addActionListener(this);
		
		attackerTrainingPassPurchaseButton = new JButton("weekly training pass for attackers");
		attackerTrainingPassPurchaseButton.addActionListener(this);
		
		JLabel goalKeeperMaxPruchaseLabel = new JLabel("Max purchase per week: 2 ");
		goalKeeperMaxPruchaseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel defenderMaxPurchaseLabel = new JLabel("Max purchase per week: 4");
		defenderMaxPurchaseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		JLabel attackerMaxPruchaseLabel = new JLabel("Max purchase per week: 2 ");
		attackerMaxPruchaseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		proteinSupplimentPurcahseButton = new JButton("protein suppliment");
		proteinSupplimentPurcahseButton.addActionListener(this);
		
		JLabel proteinSupplimentMaxPurchasePurAtheleteLabel = new JLabel("Max purchase per week: 1 per athelete");
		proteinSupplimentMaxPurchasePurAtheleteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		goalkeeperPassWeeklyPurchaseLabel = new JLabel("total purchase this week: 0");
		totalDefenderPassWeeklyPurcahseLabel = new JLabel("total purchase this week: 0");
		MaxAttackerWeeeklyPurchaseLabel = new JLabel("total purchase this week: 0");
		maxxProteinSupplmenetWeeklyPurchaseLabel = new JLabel("total purchase this week: 0");
		
		
		
		goaLKeeperCurrentPriceLabel = new JLabel("Curent price: 100");
	
		CurrentAttackerPrizeLabel = new JLabel("Curent price: 100");
		
		defenderCurrentPriceLabel = new JLabel("Curent price: 100");
		
		proteinSuppliementCurrentPrize = new JLabel("Curent price: 100");
		
		GeneralPurchasingItemWarningLabel = new JLabel("Warning: ");
		GroupLayout glPanel = new GroupLayout(panel);
		glPanel.setHorizontalGroup(
			glPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(glPanel.createSequentialGroup()
					.addGroup(glPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(glPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(glPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(glPanel.createSequentialGroup()
									.addGroup(glPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(goaLKeeperCurrentPriceLabel, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
										.addComponent(defenceTrainingPassButton, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
										.addComponent(goalKeeperTrainingPassButton, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
										.addGroup(glPanel.createSequentialGroup()
											.addGap(3)
											.addGroup(glPanel.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(defenderMaxPurchaseLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(totalDefenderPassWeeklyPurcahseLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(goalkeeperPassWeeklyPurchaseLabel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
												.addComponent(goalKeeperMaxPruchaseLabel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)))
									.addGap(0))
								.addGroup(glPanel.createSequentialGroup()
									.addComponent(defenderCurrentPriceLabel, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(glPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(proteinSuppliementCurrentPrize, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
								.addComponent(attackerMaxPruchaseLabel, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
								.addComponent(attackerTrainingPassPurchaseButton, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
								.addComponent(maxxProteinSupplmenetWeeklyPurchaseLabel, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
								.addComponent(proteinSupplimentPurcahseButton, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
								.addComponent(proteinSupplimentMaxPurchasePurAtheleteLabel, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
								.addGroup(glPanel.createSequentialGroup()
									.addGap(2)
									.addGroup(glPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(MaxAttackerWeeeklyPurchaseLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
										.addComponent(CurrentAttackerPrizeLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)))))
						.addComponent(GeneralPurchasingItemWarningLabel, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		glPanel.setVerticalGroup(
			glPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(glPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(GeneralPurchasingItemWarningLabel)
					.addGap(26)
					.addGroup(glPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(goaLKeeperCurrentPriceLabel)
						.addComponent(CurrentAttackerPrizeLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(goalkeeperPassWeeklyPurchaseLabel)
						.addComponent(MaxAttackerWeeeklyPurchaseLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(goalKeeperTrainingPassButton, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(attackerTrainingPassPurchaseButton, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(goalKeeperMaxPruchaseLabel)
						.addComponent(attackerMaxPruchaseLabel, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(glPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(defenderCurrentPriceLabel)
						.addComponent(proteinSuppliementCurrentPrize))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(glPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(totalDefenderPassWeeklyPurcahseLabel)
						.addComponent(maxxProteinSupplmenetWeeklyPurchaseLabel, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(defenceTrainingPassButton, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(proteinSupplimentPurcahseButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(defenderMaxPurchaseLabel)
						.addComponent(proteinSupplimentMaxPurchasePurAtheleteLabel))
					.addContainerGap(133, Short.MAX_VALUE))
		);
		panel.setLayout(glPanel);
		
		JLabel ItemShopTitle = new JLabel("Item shop");
		itemShop.setColumnHeaderView(ItemShopTitle);
		ItemShopTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ItemShopTitle.setHorizontalAlignment(SwingConstants.CENTER);
		marketFrame.getContentPane().setLayout(groupLayout);
		
		
	}

	
	/**
	 * Updates the number of players in the squad and displays them in a JList.
	 */
	public void numberOfPlayersInTheSquad()
	{
	
		Object[] playerlist = new Object[SignUpShop.playerList.player.size()];
		listOfPlayersInSquad= new JList<Object>(playerlist);
		int i = 0;
		for(Team player: SignUpShop.playerList.player)
		{
			
			playerlist[i] = player;
			i += 1;

		}
		
		
		listOfPlayersInSquad.addListSelectionListener(this);
		JScrollPaneDisplayingTheReturnablePlayers.setViewportView(listOfPlayersInSquad);

	}
	
	/**
	 * sets all the numbers of purchased item variables and their corresponding 
	 * JLabels to zero. 
	 */
	public static void totalPurchaseDisplayUpdate()
	{
		numberOfProteinSupplmenetPurchasedThisWeek = 0;
		numberOfWeeklyPassesForAttackerPurchaseThisWeek =0;
		numberOfWeeklyPassesForDefenderPuchasedThisWeek = 0;
		numberOfWeeklyPassesForGoalKeeperPuchasedThisWeek = 0;
		totalDefenderPassWeeklyPurcahseLabel.setText("total purchase this week: 0");
		MaxAttackerWeeeklyPurchaseLabel.setText("total purchase this week: 0");
		maxxProteinSupplmenetWeeklyPurchaseLabel.setText("total purchase this week: 0");
		goalkeeperPassWeeklyPurchaseLabel.setText("total purchase this week: 0");	
		
	
	}
	/**
	 * updates the already purchased buttons.
	 * and the activates or disables the item purchasable and the return buttons .
	 * depending on the number of items the player has.
	 */
	public static void buttonActivationStatus()
	{
		selectedPLayerReturnButton.setEnabled(false);
		for (Team player: SignUpShop.playerList.player) 
		{
			
			if (((Player) player).getName() == "Kush")
			{
				buttonToViewStatOfReserveLeftDefender.setEnabled(false);
				buttonToPurchaseReserveLeftDefender.setText("Sold");
				buttonToPurchaseReserveLeftDefender.setEnabled(false);
			}
			if (((Player) player).getName() == "Aakrista")
			{
				buttonToViewReserveAttacker.setEnabled(false);
				buttonToPurchaseReserveAttacker.setText("Sold");
				buttonToPurchaseReserveAttacker.setEnabled(false);
			}
			if (((Player) player).getName() == "Will")
			{
				buttonToVIewReserveGoalkeeper.setEnabled(false);
				buttonToPurchaseReserveGoalKeeper.setText("Sold");
				buttonToPurchaseReserveGoalKeeper.setEnabled(false);
			}
			if (((Player) player).getName() == "Martin")
			{
				buttonToViewStatOfReserveRightDefender.setEnabled(false);
				buttonToPurcahseReserveRIghtDefender.setText("Sold");
				buttonToPurcahseReserveRIghtDefender.setEnabled(false);
			}
		}
		
		

		
		if(ClubRoom.numberOfProteinSuppliements == 8 )
		{
			proteinSupplimentPurcahseButton.setEnabled(false);
		}	
		if(ClubRoom.numberOfWeeklyPassesForAttackers == 2)
		{
			attackerTrainingPassPurchaseButton.setEnabled(false);
		}
		if(ClubRoom.numberOfWeeklyPassesForDefenders == 4)
		{	
			defenceTrainingPassButton.setEnabled(false);
		}
		if(ClubRoom.numberOfWeeklPassesForGoalkeeper == 2)
		{
			goalKeeperTrainingPassButton.setEnabled(false);
		
		}
		
		
		
		
		
		if(ClubRoom.numberOfProteinSuppliements == 0)
		{
			
			if(numberOfProteinSupplmenetPurchasedThisWeek < 8)
			{
				proteinSupplimentPurcahseButton.setEnabled(true);
			}
			if(numberOfProteinSupplmenetPurchasedThisWeek >= 8)
			{
				proteinSupplimentPurcahseButton.setEnabled(false);
			}
			
			
			proteinSuppliementReturnBackButton.setEnabled(false);
			proteinSupplimenentReturnBackTextField.setEnabled(false);
			proteinSuppliementSaleBackButton.setEnabled(false);
		}	
		if(ClubRoom.numberOfWeeklyPassesForAttackers == 0)
		{
			
			if(numberOfWeeklyPassesForAttackerPurchaseThisWeek < 2)
			{
				attackerTrainingPassPurchaseButton.setEnabled(true);
			}
			if(numberOfWeeklyPassesForAttackerPurchaseThisWeek >= 2)
			{
				attackerTrainingPassPurchaseButton.setEnabled(false);
			}
			attackerSaleBackTextField.setEnabled(false);
			attackerTrainingPassReturnBackButton.setEnabled(false);
			confirmAttackerPassReturnBackButton.setEnabled(false);
		
		}
		if(ClubRoom.numberOfWeeklyPassesForDefenders == 0)
		{	
			if(numberOfWeeklyPassesForDefenderPuchasedThisWeek < 4)
			{
				defenceTrainingPassButton.setEnabled(true);
			}
			if(numberOfWeeklyPassesForDefenderPuchasedThisWeek >= 4)
			{
				defenceTrainingPassButton.setEnabled(false);
			}
			confirmDefenderPassReturnBackButton.setEnabled(false);
			defenfderSaleBackTextField.setEnabled(false);
			defenceTrainingPassReturnBackButton.setEnabled(false);
		}
		if(ClubRoom.numberOfWeeklPassesForGoalkeeper == 0)
		{
			if(numberOfWeeklyPassesForGoalKeeperPuchasedThisWeek < 2)
			{
				goalKeeperTrainingPassButton.setEnabled(true);
			}
			if(numberOfWeeklyPassesForGoalKeeperPuchasedThisWeek > 2)
			{
				goalKeeperTrainingPassButton.setEnabled(false);
			}
			goalKeeperSaleBackTextField.setEnabled(false);
			goalkeeperTrainingPassReturnBackButton.setEnabled(false);
			confirmGoalKeeperPassReturnBackButton.setEnabled(false);
		}
	
		
	}

	/**
	 * String variable to store the player name.
	 * @param playerPosition using the player position provided 
	 * the player name is determined. 
	 * @return name the name of the player determined.
	 */
	public String getPlayerName(String playerPosition)
	{
		String name = new String();
		for(Player player: SignUpShop.playerList.player)
		{
			if(player.getPosition() == playerPosition)
			{
				name = player.getName();
				break;
			}
		}
		return name;
	}
	/**
	 * Prints the player's stats on the screen.
	 *
	 * @param object The player object whose stats are to be printed.
	 */
	public void printPlayerstat(Player object) {
		allPlayerNameDisplayJLabel.setText("Hello my name is " + object.getName());
		staminaLabel.setText("Stamina: " + object.stamina());
		offenseLabel.setText("Offense: " + object.offense());
		defenceLabel.setText("Defence: " + object.defence());
		reflexLabel.setText("Reflex: " + object.goalKeeperReflex());
		positionLabel.setText("Position: " + object.getPosition());

		scollUpPurchasePlayerList.setValue(0);
		scrollRightPurchaseblePlayerList.setValue(0);
	}

	/**
	 * Determines the outcome after returning a selected player.
	 *
	 * @param firstReturn A boolean value indicating if it is the first return.
	 * @param purchaseButton2 The purchase button for the player.
	 * @param viewButton  The view stats button for the player.
	 */
	public void selectedReturnPlayerOutcomeDecider(boolean firstReturn, JButton purchaseButton2, JButton viewButton) {
		if (firstReturn == false) {
			GameMenu.money += (normalPlayerPurchasePrice - GameMenu.currentWeek * 6);
			moneyInAmountJLabel.setText("Money in account: " + GameMenu.money + " ");
			viewButton.setEnabled(true);
			purchaseButton2.setEnabled(true);
			purchaseButton2.setText("Buy player");
		}
		if (firstReturn == true) {
			viewButton.setEnabled(true);
			purchaseButton2.setEnabled(true);
			purchaseButton2.setText("Buy player");
		}
	}

	/**
	 * Determines the outcome after returning a selected professional player.
	 *
	 * @param purchase The purchase button for the player.
	 * @param purchaseBotton2 The second purchase button for the player.
	 * @param viewButton The view stats button for the player.
	 */
	public void selectedReturnProPlayerOutcomeDecider(JButton purchase, JButton purchaseBotton2, JButton viewButton) {
		GameMenu.money += (proPlayerPurchasePrice - GameMenu.currentWeek * 10);
		moneyInAmountJLabel.setText("Money in account: " + GameMenu.money + " ");
		viewButton.setEnabled(true);
		purchase.setEnabled(true);
		purchase.setEnabled(true);
		purchaseBotton2.setText("Buy player");
		purchaseBotton2.setText("Buy player");
	}

	/**
	 * Generates a random value to update the item prices.
	 *
	 * @return The randomly generated value.
	 */
	public int randomUpdatePriceValueGenerator() {
		Random randomValue = new Random();
		int value = randomValue.nextInt(100) + 50;
		return value;
	}

	/**
	 * Updates the prices of the items and players.
	 */
	public void updateItemPrices() {
		GameMenu.noticeCollecter.add("The market prices have been updated");
		GameMenu.noticeDisplayer();

		int currentPrice = weeklyTrainingPassForGoalkeeperItem.currentPrize();
		ItemPrice = currentPrice + randomUpdatePriceValueGenerator();

		weeklyTrainingPassForGoalkeeperItem.setPrice(ItemPrice);
		weeklyTrainingPassForDefenceItem.setPrice(ItemPrice);
		weekyTrainingPassForAttackersItem.setPrice(ItemPrice);
		proteinSupplementItem.setPrice(ItemPrice);

		goaLKeeperCurrentPriceLabel.setText("current prize: " + weeklyTrainingPassForGoalkeeperItem.currentPrize());
		CurrentAttackerPrizeLabel.setText("current prize: " + weekyTrainingPassForAttackersItem.currentPrize());
		defenderCurrentPriceLabel.setText("current prize: " + weeklyTrainingPassForDefenceItem.currentPrize());
		proteinSuppliementCurrentPrize.setText("current prize: " + proteinSupplementItem.currentPrize());

		normalPlayerPurchasePrice += randomUpdatePriceValueGenerator();
		proPlayerPurchasePrice += randomUpdatePriceValueGenerator();

		rightDefenderCurrentPrice.setText("current prize: " + normalPlayerPurchasePrice);
		leftDefenderCurrentPrice.setText("current_prize: " + normalPlayerPurchasePrice);
		goalKeeperCurrentPrice.setText("current_prize: " + normalPlayerPurchasePrice);
		attackerCurrentPrice.setText("current_prize: " + normalPlayerPurchasePrice);

		proLeftDefenderCurrentPRice.setText("current prize: " + proPlayerPurchasePrice);
		proRightDefenderCurrentPrice.setText("current_prize: " + proPlayerPurchasePrice);
		proAttackerCurrentPrice.setText("current_prize: " + proPlayerPurchasePrice);
		proGoalKeeperCurrentPrice.setText("current_prize: " + proPlayerPurchasePrice);

		reserveLeftDefenderCurrentPrice.setText("current_prize: " + normalPlayerPurchasePrice);
		reserveGoalKeeperCurrentPrice.setText("current_prize: " + normalPlayerPurchasePrice);
		reserveAttackerCurrentPrice.setText("current_prize: " + normalPlayerPurchasePrice);
		reserveRightDefenderCurrentPrice.setText("current_prize: " + normalPlayerPurchasePrice);
	}

	
	/**
	 * Updates the individual stats of the player being added.
	 * Sets the stamina, defense, offense, and player reflex (if applicable).
	 *
	 * @param playerBeingAdded The player being added to the team.
	 */
	public void individualStatUpdate(Player playerBeingAdded) {
		if (playerBeingAdded.isPro() == false) {
			playerBeingAdded.setStamina(100);
			playerBeingAdded.setDefence(SignUpShop.randomInitialStatsSenerator());
			playerBeingAdded.setOffense(SignUpShop.randomInitialStatsSenerator());
			if (playerBeingAdded.getPosition() == "goal keeper") {
				playerBeingAdded.setPlayerreflex(SignUpShop.randomInitialStatsSenerator());
			}
		}
	}


	/**
	 * Checks if the purchase is possible based on the available money.
	 *
	 * @param amount The amount of money required for the purchase.
	 * @return true if the purchase is possible, false otherwise.
	 */
	public boolean purchaseable(int amount) {
		if (GameMenu.money - amount < 0) {
			return false;
		}
		return true;
	}

	/**
	 * Checks if there is space available for a purchased player in the team.
	 * Displays a warning if the team is full, otherwise proceeds with the purchase.
	 *
	 * @param purchaseButton The purchase button for the player.
	 * @param viewstatButton The button to view player stats.
	 * @param playerBeingAdded The player being added to the team.
	 * @param amountTakenOff The amount of money taken off for the purchase.
	 */
	public void spaceForPurcahsedPlayer(JButton purchaseButton, JButton viewstatButton, Player playerBeingAdded, int amountTakenOff) {
		if (SignUpShop.playerList.player.size() >= 9) {
			jLabelForReturnWarning.setText("Warning: the team is full (including the reserve slots)");
		} else {
			jLabelForReturnWarning.setText("Warning: ");
			purchasingPlayer(purchaseButton, viewstatButton, playerBeingAdded, amountTakenOff);
		}
	}

	/**
	 * Checks if there is space available for a purchased pro player in the team.
	 * Displays a warning if the team is full, otherwise proceeds with the purchase.
	 *
	 * @param purchaseButton  The purchase button for the player.
	 * @param purchaseButton22 Another purchase button for the player.
	 * @param viewstatButton The button to view player stats.
	 * @param playerBeingAdded The player being added to the team.
	 * @param amountTakenOff The amount of money taken off for the purchase.
	 */
	public void spaceForPurchasedProPlayer(JButton purchaseButton, JButton purchaseButton22, JButton viewstatButton, Player playerBeingAdded, int amountTakenOff) {
		if (SignUpShop.playerList.player.size() >= 9) {
			jLabelForReturnWarning.setText("Warning: the team is full (including the reserve slots)");
		} else {
			jLabelForReturnWarning.setText("Warning: ");
			if (playerBeingAdded.isReserve()) {
				purchasingPlayerProReserve(purchaseButton22, purchaseButton, viewstatButton, playerBeingAdded, amountTakenOff);
			} else {
				purchasingPlayerPro(purchaseButton22, purchaseButton, viewstatButton, playerBeingAdded, amountTakenOff);
			}
		}
	}

	/**
	 * Performs the processing for a purchased player.
	 * Updates player stats, adds the player to the team, updates the squad display,
	 * disables the purchase button, deducts money from the account, and updates the UI.
	 *
	 * @param purchaseButton  The purchase button for the player.
	 * @param viewstatButton The button to view player stats.
	 * @param playerBeingAdded The player being added to the team.
	 * @param amountTakenOff The amount of money taken off for the purchase.
	 */
	public void purchasingProcessing(JButton purchaseButton, JButton viewstatButton, Player playerBeingAdded, int amountTakenOff) {
		individualStatUpdate(playerBeingAdded);
		SignUpShop.playerList.player.add(playerBeingAdded);
		GameMenu.club.updatePlayerSquad();
		purchaseButton.setEnabled(false);
		GameMenu.money -= amountTakenOff;
		moneyInAmountJLabel.setText("Money in account: " + GameMenu.money + " ");
		purchaseButton.setText("sold");
		viewstatButton.setEnabled(false);
		WarningJLabelForAllPurchasePlayer.setText("Warning: purchase confirmed");
		numberOfPlayersInTheSquad();
	}

	/**
	 * Performs the processing for a purchased pro player.
	 * Updates player stats, adds the player to the team, updates the squad display,
	 * disables the purchase button, deducts money from the account, and updates the UI.
	 *
	 * @param purchaseButton22 Another purchase button for the player.
	 * @param purchaseButton The purchase button for the player.
	 * @param viewstatButton The button to view player stats.
	 * @param playerBeingAdded The player being added to the team.
	 * @param amountTakenOff The amount of money taken off for the purchase.
	 */
	public void purchasingProcessingForProPlayer(JButton purchaseButton22, JButton purchaseButton, JButton viewstatButton, Player playerBeingAdded, int amountTakenOff) {
		individualStatUpdate(playerBeingAdded);
		SignUpShop.playerList.player.add(playerBeingAdded);
		GameMenu.club.updatePlayerSquad();
		purchaseButton.setEnabled(false);
		GameMenu.money -= amountTakenOff;
		moneyInAmountJLabel.setText("Money in account: " + GameMenu.money + " ");
		purchaseButton.setText("sold");
		purchaseButton22.setEnabled(false);
		purchaseButton22.setText("sold");
		viewstatButton.setEnabled(false);
		WarningJLabelForAllPurchasePlayer.setText("Warning: purchase confirmed");
		numberOfPlayersInTheSquad();
	}

	/**
	 * Processes the purchase of a reserve player for a the normal player section.
	 *
	 * @param purchaseButton The purchase button for the player.
	 * @param viewstatButton The button to view player stats.
	 * @param playerBeingAddeded The player being added to the team.
	 * @param amountTakenOff The amount of money taken off for the purchase.
	 */
	public void purchasingPlayer(JButton purchaseButton ,JButton viewstatButton, Player playerBeingAddeded,int amountTakenOff)
	{
		GameMenu.club.updatePlayerSquad();
			if(ClubRoom.playingFour.length < 4 && ClubRoom.positionOpenInThePlayingList(playerBeingAddeded) == true)
			{
				playerBeingAddeded.setReserve(false);
			}
			else if(ClubRoom.positionOpenInThePlayingList(playerBeingAddeded) == false
					|| ClubRoom.playingFour.length >= 4)
			{
				playerBeingAddeded.setReserve(true);
			}
			if (purchaseable(amountTakenOff) == true)
			{
				purchasingProcessing( purchaseButton,  viewstatButton,  playerBeingAddeded,  amountTakenOff);
			}
			else {
				WarningJLabelForAllPurchasePlayer.setText("Warning: you don't have enough money to buy the players");
			}
			
			
	}
	
	/**
	 * Processes the purchase of a reserve player for a the pro player section.
	 *
	 * @param purchaseButton The purchase button for the player.
	 * @param purchaseButton22 Another purchase button for the player.
	 * @param viewstatButton The button to view player stats.
	 * @param playerBeingAddeded The player being added to the team.
	 * @param amountTakenOff  The amount of money taken off for the purchase.
	 */
	
	public void purchasingPlayerProReserve(JButton purchaseButton,JButton purchaseButton22 ,JButton viewstatButton, Player playerBeingAddeded,int amountTakenOff)
	{
		
		GameMenu.club.updatePlayerSquad();
		if (purchaseable(amountTakenOff) == true)
		{
			if(ClubRoom.reserves.length < 5)
			{	
	 
				playerBeingAddeded.setReserve(true);
				purchasingProcessingForProPlayer(purchaseButton, purchaseButton22,  viewstatButton,  playerBeingAddeded,  amountTakenOff);
	    	}
			 else 
		        {
		        	WarningJLabelForAllPurchasePlayer.setText("Warning: the reserves have no slot left");
		        }
		}
    
        else if(purchaseable(amountTakenOff) == false){
        	WarningJLabelForAllPurchasePlayer.setText("Warning: you don't have enough money to buy the players");
    	}
       
        
	}

	/**
	 * Processes the purchase of a player for the pro player section.
	 *
	 * @param purchaseButton  The purchase button for the player.
	 * @param purchaseButton22 Another purchase button for the player.
	 * @param viewstatButton The button to view player stats.
	 * @param playerBeingAdded The player being added to the team.
	 * @param amountTakenOff The amount of money taken off for the purchase.
	 */
	public void purchasingPlayerPro(JButton purchaseButton, JButton purchaseButton22, JButton viewstatButton, Player playerBeingAdded, int amountTakenOff) {

		if (purchaseable(amountTakenOff)) {
			playerBeingAdded.setReserve(false);
			if (ClubRoom.playingFour.length < 4 && ClubRoom.positionOpenInThePlayingList(playerBeingAdded)) {
				purchasingProcessingForProPlayer(purchaseButton, purchaseButton22, viewstatButton, playerBeingAdded, amountTakenOff);
			} else if (ClubRoom.playingFour.length == 4 && !ClubRoom.positionOpenInThePlayingList(playerBeingAdded)) {
				swapper(playerBeingAdded);
				purchasingProcessingForProPlayer(purchaseButton, purchaseButton22, viewstatButton, playerBeingAdded, amountTakenOff);
			} else if (ClubRoom.playingFour.length > 4) {
				WarningJLabelForAllPurchasePlayer.setText("Warning: the squad is filled");
			}
		} else {
			WarningJLabelForAllPurchasePlayer.setText("Warning: you don't have enough money to buy the players");
		}
	}

	
	/**
	 * swaps substitutes the pro player with the current player in the playing squad and
	 * puts the substituted player to the reserve list if possible. 
	 * @param playerBeingAddeded the pro player being added. 
	 */
	public void swapper(Player playerBeingAddeded)
	{
		int i = 0;

		for(Object player: ClubRoom.playingFour)
		{	i += 1;
			if(playerBeingAddeded.getPosition() == ((Player) player).getPosition())
				
			{
				((Player) ClubRoom.playingFour[i - 1]).setReserve(true);
				GameMenu.club.updatePlayerSquad();
		
				break;
				
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		// removes the selected player from the playing squad
		if(e.getSource() == selectedPLayerReturnButton)
		{
			
			int counter = 0;
			// the loop searches for the selected players and finds its index so that it can be removed.
			jLabelForReturnWarning.setText("Warning: ");
			for (Player player: SignUpShop.playerList.player)
			{
				counter += 1;
				if((((Player) selected_player).getName() == player.getName()))
				{
					counter -= 1;
					
					if(((Player) selected_player).getName() == "Ronaldo")
					{
						
						selectedReturnProPlayerOutcomeDecider( purchaseProAttackerButton,purchaseProAttackerAsReserveButton,buttonToViewStatOfProAttacker);
			
						
					}
					if(((Player) selected_player).getName() == "Antonio")
					{
						
						selectedReturnProPlayerOutcomeDecider( purchaseProLeftDefenderButton, purchaseProLeftDefenderAsReserveButton,buttonToViewStatOfProLeftDefender);
						
		
					}
					if(((Player) selected_player).getName() == "Marquinhos")
					{
				
						selectedReturnProPlayerOutcomeDecider( purchaseProRIghtDefenderButton,purchaseProRightDefenderAsReserveButton,buttonToViewStatOfProRightDefender);
					}
					if(((Player) selected_player).getName() == "Manuel")
					{
						
						
						selectedReturnProPlayerOutcomeDecider( purchaseProGoalkeeperButton,purchaseProGoalKeeperAsReserveButton,buttonToViewSatOfProGoalKeeper);
						
					}					
					if(((Player) selected_player).getName() == "Aakrista")
					{
						
						selectedReturnPlayerOutcomeDecider(firstTimeReturnReserveAttacker, buttonToPurchaseReserveAttacker, buttonToViewReserveAttacker);
						
						firstTimeReturnReserveAttacker = false;
					}
					if(((Player) selected_player).getName() == "Martin")
					{
						selectedReturnPlayerOutcomeDecider(firstTimeReturnReserveRightDefender,buttonToPurcahseReserveRIghtDefender,buttonToViewStatOfReserveRightDefender);
						firstTimeReturnReserveRightDefender = false;
					}
					if(((Player) selected_player).getName() == "Kush")
					{
						selectedReturnPlayerOutcomeDecider(firstTimeReturnReserveLeftDefender,buttonToPurchaseReserveLeftDefender,buttonToViewStatOfReserveLeftDefender);
						firstTimeReturnReserveLeftDefender = false;
					}
					if(((Player) selected_player).getName() == "Will")
					{
						selectedReturnPlayerOutcomeDecider(firstTimeReturnReserveGoalkeeper,buttonToPurchaseReserveGoalKeeper,buttonToVIewReserveGoalkeeper);
						firstTimeReturnReserveGoalkeeper =false;
					}
					
					if(((Player) selected_player).getName() == "Jack")
					{
						selectedReturnPlayerOutcomeDecider(firstTimeReturnGoalKeeper,buttonToPurchaseGoalKeeper,buttonToViewStatGoalkeeper);
						firstTimeReturnReserveRightDefender= false;
					}
					if(((Player) selected_player).getName() == "Uday")
					{
						selectedReturnPlayerOutcomeDecider(firstTimeReturnReftDefender,buttonToPurchaseRightDefender,butttonToViewRightDefender);
						firstTimeReturnReftDefender = false;
					}
					if(((Player) selected_player).getName() == "Josh")
					{
						selectedReturnPlayerOutcomeDecider(firstTimeReturnLeftDefender,buttonToPurchaseLeftDefender,buttonToViewLeftDefender);
						firstTimeReturnLeftDefender = false;
					}if(((Player) selected_player).getName() == "Chris")
					{
						selectedReturnPlayerOutcomeDecider(firstTimeReturnAttacker,buttonToPurchaseAttacker,buttonToViewstatOfAttacker);
						firstTimeReturnAttacker = false;
					}
					break;
				}
			}
			
			SignUpShop.playerList.player.remove(counter);
			GameMenu.club.updatePlayerSquad();
			numberOfPlayersInTheSquad();
			
			if(SignUpShop.playerList.player.size() == 4);
			{
				JScrollPaneDisplayingTheReturnablePlayers.setEnabled(false);
				selectedPLayerReturnButton.setEnabled(false);
			}
		}
		
		// if the buttons are from the pro player or normal player purchase section 
		// the players are purchased and the purchasing is processed to see if there is enough space for those players. 
	
		
		if(e.getSource() == buttonToPurchaseLeftDefender)
		{
			firstTimeReturnLeftDefender = false;
			spaceForPurcahsedPlayer(buttonToPurchaseLeftDefender ,buttonToViewLeftDefender,playerTwo, normalPlayerPurchasePrice);
			
		}
		if(e.getSource() == buttonToPurchaseRightDefender)
		{
			firstTimeReturnReftDefender = false;
			spaceForPurcahsedPlayer(buttonToPurchaseRightDefender ,butttonToViewRightDefender,playerThree, normalPlayerPurchasePrice);
			
		}
		if(e.getSource() == buttonToPurchaseAttacker)
		{
			firstTimeReturnAttacker = false;
			spaceForPurcahsedPlayer(buttonToPurchaseAttacker ,buttonToViewstatOfAttacker,playerFour, normalPlayerPurchasePrice);
			
		}
		if(e.getSource() == buttonToPurchaseGoalKeeper)
		{
			firstTimeReturnGoalKeeper = false;
			spaceForPurcahsedPlayer(buttonToPurchaseGoalKeeper ,buttonToViewStatGoalkeeper,playerOne, normalPlayerPurchasePrice);

		}
		

		
		if(e.getSource() == purchaseProLeftDefenderButton)	
		{
			proLeftDefender.setReserve(false);
			spaceForPurchasedProPlayer(purchaseProLeftDefenderButton,purchaseProLeftDefenderAsReserveButton,buttonToViewStatOfProLeftDefender,proLeftDefender,proPlayerPurchasePrice);
		}
		if(e.getSource() == purchaseProRIghtDefenderButton)
		{
			proRightDefender.setReserve(false);
			spaceForPurchasedProPlayer(purchaseProRIghtDefenderButton,purchaseProRightDefenderAsReserveButton,buttonToViewStatOfProRightDefender,proRightDefender,proPlayerPurchasePrice);
		}
		if(e.getSource() == purchaseProAttackerButton)
		{
			proAttacker.setReserve(false);
			spaceForPurchasedProPlayer(purchaseProAttackerButton,purchaseProAttackerAsReserveButton,buttonToViewStatOfProAttacker,proAttacker,proPlayerPurchasePrice);
		}
		if(e.getSource() == purchaseProGoalkeeperButton)
		{
			proGoalKeeper.setReserve(false);
			spaceForPurchasedProPlayer(purchaseProGoalkeeperButton,purchaseProGoalKeeperAsReserveButton,buttonToViewSatOfProGoalKeeper,proGoalKeeper,proPlayerPurchasePrice);
		}
		
		if(e.getSource() == purchaseProLeftDefenderAsReserveButton) 
		{
			proLeftDefender.setReserve(true);
			spaceForPurchasedProPlayer(purchaseProLeftDefenderAsReserveButton,purchaseProLeftDefenderButton,buttonToViewStatOfProLeftDefender,proLeftDefender,proPlayerPurchasePrice);
		}
		if(e.getSource() == purchaseProRightDefenderAsReserveButton) 
		{
			proRightDefender.setReserve(true);
			spaceForPurchasedProPlayer(purchaseProRightDefenderAsReserveButton,purchaseProRIghtDefenderButton,buttonToViewStatOfProRightDefender,proRightDefender,proPlayerPurchasePrice);
		}
		if(e.getSource() == purchaseProAttackerAsReserveButton) 
		{
			proAttacker.setReserve(true);
			spaceForPurchasedProPlayer(purchaseProAttackerAsReserveButton,purchaseProAttackerButton,buttonToViewStatOfProAttacker,proAttacker,proPlayerPurchasePrice);
		}
		if(e.getSource() == purchaseProGoalKeeperAsReserveButton) 
		{
			proGoalKeeper.setReserve(true);
			spaceForPurchasedProPlayer(purchaseProGoalKeeperAsReserveButton,purchaseProGoalkeeperButton,buttonToViewSatOfProGoalKeeper,proGoalKeeper,proPlayerPurchasePrice);
		}
		
		
		// if the buttons are from the view pro player section 
		// the status of the pro player is displayed
	
		if(e.getSource() == buttonToViewStatOfProLeftDefender)
		{
			
			printPlayerstat(proLeftDefender);
			
		}
		if(e.getSource() == buttonToViewStatOfProRightDefender)
		{
			
			printPlayerstat(proGoalKeeper);
			
			
		}
		if(e.getSource() == buttonToViewStatOfProAttacker)
		{
			
			printPlayerstat(proAttacker);
			
		}
		if(e.getSource() == buttonToViewSatOfProGoalKeeper)
		{
			
			printPlayerstat(proRightDefender);
			
		}

		// if the buttons are from the view reserve or normal player section 
		// the status of the players as well as their names is displayed.
		
		if(e.getSource() == buttonToViewLeftDefender)
		{
			individualStatUpdate(reservePlayerTwo);
			printPlayerstat(reservePlayerTwo);
		}
		if(e.getSource() == butttonToViewRightDefender)
		{
			individualStatUpdate(reservePlayerThree);
			printPlayerstat(reservePlayerThree);
		}
		if(e.getSource() == buttonToViewstatOfAttacker )
		{
			individualStatUpdate(reservePlayerFour);
			printPlayerstat(reservePlayerFour);
		}
		if(e.getSource() == buttonToViewStatGoalkeeper)
		{
			individualStatUpdate(reservePlayerOne);
			printPlayerstat(reservePlayerOne);
		}
	
		if(e.getSource() == buttonToViewStatOfReserveLeftDefender)
		{
			individualStatUpdate(playerTwo);
			printPlayerstat(playerTwo);
		}
		if(e.getSource() == buttonToViewStatOfReserveRightDefender)
		{
			individualStatUpdate(playerThree);
			printPlayerstat(playerThree);
		}
		if(e.getSource() == buttonToViewReserveAttacker )
		{
			individualStatUpdate(playerFour);
			printPlayerstat(playerFour);
		}
		if(e.getSource() == buttonToVIewReserveGoalkeeper)
		{
			individualStatUpdate(playerOne);
			printPlayerstat(playerOne);
		}
		
		
		//if the buttons are from any of the reserve player section their purchasing is processed. 
		
		if(e.getSource() == buttonToPurchaseReserveLeftDefender)
		{
			firstTimeReturnReserveLeftDefender = false;
			spaceForPurcahsedPlayer(buttonToPurchaseReserveLeftDefender ,buttonToViewStatOfReserveLeftDefender,reservePlayerTwo, normalPlayerPurchasePrice);
		}
		if(e.getSource() == buttonToPurcahseReserveRIghtDefender)
		{
			firstTimeReturnReserveRightDefender = false;
			spaceForPurcahsedPlayer(buttonToPurcahseReserveRIghtDefender ,buttonToViewStatOfReserveRightDefender,reservePlayerThree, normalPlayerPurchasePrice);
		}
		if(e.getSource() == buttonToPurchaseReserveAttacker)
		{
			firstTimeReturnReserveAttacker = false;
			spaceForPurcahsedPlayer(buttonToPurchaseReserveAttacker ,buttonToViewReserveAttacker,reservePlayerFour, normalPlayerPurchasePrice);
		}
		if(e.getSource() == buttonToPurchaseReserveGoalKeeper)
		{
			firstTimeReturnReserveGoalkeeper = false;
			spaceForPurcahsedPlayer(buttonToPurchaseReserveGoalKeeper ,buttonToVIewReserveGoalkeeper,reservePlayerOne, normalPlayerPurchasePrice);
		}
		
		if (e.getSource() == backToMenuButton)
		{
			selectedPLayerReturnButton.setEnabled(true);
			marketFrame = GameMenu.market.marketFrame;
			Market.marketFrame.setVisible(false);
			GameMenu.club.updatePlayerSquad();
			GameMenu.market.marketFrame.setBounds(GameMenu.market.marketFrame.getBounds());
			GameMenu.frame.setBounds(Market.marketFrame.getBounds());
			GameMenu.frame.setVisible(true);
			GameMenu.gameMenuMoneyInAccount.setText(Market.moneyInAmountJLabel.getText());
		}

		
		// the following cope checks for pruchase button clicks and 
		// and added the item to the inventory according 
		// and also updates the displays as per the requirements
		// to indicate the user of the purchase made. 
		if(e.getSource() == attackerTrainingPassPurchaseButton)
		{
		
			if(ClubRoom.numberOfWeeklyPassesForAttackers <= 2)
			{

				
				if (purchaseable(((Items)weekyTrainingPassForAttackersItem).initialPurchasePrize()) == true)
				{
				GeneralPurchasingItemWarningLabel.setText("Warning: purchase confirmed");
				GameMenu.money -= ((Items)weekyTrainingPassForAttackersItem).initialPurchasePrize();
				moneyInAmountJLabel.setText("Money in account: "+GameMenu.money+" ");
				inventory.addItemToInventory(weekyTrainingPassForAttackersItem);
				numberOfWeeklyPassesForAttackerPurchaseThisWeek += 1;
				MaxAttackerWeeeklyPurchaseLabel.setText("total purchase this week: "+numberOfWeeklyPassesForAttackerPurchaseThisWeek);
				numberOfPurchasedItemRemaining();
				attackerSaleBackTextField.setEnabled(true);
				attackerTrainingPassReturnBackButton.setEnabled(true);
				confirmAttackerPassReturnBackButton.setEnabled(true);
				
				if(ClubRoom.numberOfWeeklyPassesForAttackers == 2)
				{
					buttonActivationStatus();
				}
			}
			else {
				GeneralPurchasingItemWarningLabel.setText("Warning: you don't have enough money to purchase the items");
			}
			
			}
		}
		
		if(e.getSource() == defenceTrainingPassButton)
		{
				
				if(ClubRoom.numberOfWeeklyPassesForDefenders <= 4)
				{
	
				if (purchaseable(((Items)weeklyTrainingPassForDefenceItem).initialPurchasePrize()) == true)
				{
				GeneralPurchasingItemWarningLabel.setText("Warning: purchase confirmed");
				GameMenu.money -= ((Items)weeklyTrainingPassForDefenceItem).initialPurchasePrize();
				inventory.addItemToInventory(weeklyTrainingPassForDefenceItem);
				moneyInAmountJLabel.setText("Money in account: "+GameMenu.money+" ");
				numberOfWeeklyPassesForDefenderPuchasedThisWeek += 1;
				totalDefenderPassWeeklyPurcahseLabel.setText("total purchase this week: "+numberOfWeeklyPassesForDefenderPuchasedThisWeek);
				numberOfPurchasedItemRemaining();
				confirmDefenderPassReturnBackButton.setEnabled(true);
				defenfderSaleBackTextField.setEnabled(true);
				defenceTrainingPassReturnBackButton.setEnabled(true);
				if (ClubRoom.numberOfWeeklyPassesForDefenders == 4)
				{
					buttonActivationStatus();
				}
			}
			else {
				GeneralPurchasingItemWarningLabel.setText("Warning: you don't have enough money to purchase the items");
			}
			
			}
			
		}
		if(e.getSource() == goalKeeperTrainingPassButton)
		{
		
			if(ClubRoom.numberOfWeeklPassesForGoalkeeper <= 2)
			{
				if(purchaseable(((Items)weeklyTrainingPassForGoalkeeperItem).initialPurchasePrize()) == true)
				{
				GeneralPurchasingItemWarningLabel.setText("Warning: purchase confirmed");
				GameMenu.money -= ((Items)weeklyTrainingPassForGoalkeeperItem).initialPurchasePrize();
				inventory.addItemToInventory(weeklyTrainingPassForGoalkeeperItem);
				moneyInAmountJLabel.setText("Money in account: "+GameMenu.money+" ");
				numberOfWeeklyPassesForGoalKeeperPuchasedThisWeek += 1;
				goalkeeperPassWeeklyPurchaseLabel.setText("total purchase this week: "+numberOfWeeklyPassesForGoalKeeperPuchasedThisWeek);
				numberOfPurchasedItemRemaining();
				goalKeeperSaleBackTextField.setEnabled(true);
				goalkeeperTrainingPassReturnBackButton.setEnabled(true);
				confirmGoalKeeperPassReturnBackButton.setEnabled(true);
				if(ClubRoom.numberOfWeeklPassesForGoalkeeper == 2)
				{
					buttonActivationStatus();
				}
				
			}
			else {
				GeneralPurchasingItemWarningLabel.setText("Warning: you don't have enough money to purchase the items");
			}
			
			
			
			}
			
		}
		
		if(e.getSource() == proteinSupplimentPurcahseButton)
		{
			
			
				if(ClubRoom.numberOfProteinSuppliements <= 8){
					if( purchaseable(((Items)proteinSupplementItem).initialPurchasePrize()) == true)
					{
					GeneralPurchasingItemWarningLabel.setText("Warning: purchase confirmed");
					GameMenu.money -= ((Items)proteinSupplementItem).initialPurchasePrize();
					inventory.addItemToInventory(proteinSupplementItem);
					moneyInAmountJLabel.setText("Money in account: "+GameMenu.money+" ");
					numberOfProteinSupplmenetPurchasedThisWeek += 1;
					maxxProteinSupplmenetWeeklyPurchaseLabel.setText("total purchase this week: "+numberOfProteinSupplmenetPurchasedThisWeek);
					numberOfPurchasedItemRemaining();
					proteinSuppliementReturnBackButton.setEnabled(true);
					proteinSupplimenentReturnBackTextField.setEnabled(true);
					proteinSuppliementSaleBackButton.setEnabled(true);
					if(ClubRoom.numberOfProteinSuppliements == 8)
					{
					buttonActivationStatus();
					}
				}
				else {
					GeneralPurchasingItemWarningLabel.setText("Warning: you don't have enough money to purchase the items");
				}
				
			}
			
		}
		
		// these buttons control the return back item feature that enables user to return items 
		// back to the shop. the returnback buttons warns the user accordingly depending on their input 
		// ie if the input is not valid nothing is returns. 
		if(e.getSource() == goalkeeperTrainingPassReturnBackButton)
		{
			
			int numberOfGoalKeeperPassesAvaiable = ClubRoom.numberOfWeeklPassesForGoalkeeper;
			boolean outcomeGoalkeeperReturnBackButtonClick = itemButtonClickOutcome(goalKeeperSaleBackTextField,numberOfGoalKeeperPassesAvaiable, goalKeeperSoldBackTrainingWarningDisplayLabel,weeklyTrainingPassForGoalkeeperItem );
			if ( outcomeGoalkeeperReturnBackButtonClick == true)
			{
				numOfGoalKeeper = Integer.parseInt(goalKeeperSaleBackTextField.getText());
				goalKeeperSoldBackTrainingWarningDisplayLabel.setText("being sold back for: "+ weeklyTrainingPassForGoalkeeperItem.currentPrize()*numOfGoalKeeper);
			
			}
		
		}
		if(e.getSource() == defenceTrainingPassReturnBackButton)
		{
			int numberOfWeeklyDefenderPassesAvialable = ClubRoom.numberOfWeeklyPassesForDefenders;
			boolean outcomeDefenderSaleBack = itemButtonClickOutcome(defenfderSaleBackTextField, numberOfWeeklyDefenderPassesAvialable, defenderSoldBackTrainingWarningDisplayLabel, weeklyTrainingPassForDefenceItem);
			if ( outcomeDefenderSaleBack == true)
			{
				numOfdefender = Integer.parseInt(defenfderSaleBackTextField.getText());
				defenderSoldBackTrainingWarningDisplayLabel.setText("being sold back for: "+ weeklyTrainingPassForDefenceItem.currentPrize()*numOfdefender);
			
			}
	
		}
		if(e.getSource() == attackerTrainingPassReturnBackButton)
		{
			
			int numberOfWeeklyAttackerPassesAvaialable = ClubRoom.numberOfWeeklyPassesForAttackers;
			boolean outcomeOfAttackerSaleBack = itemButtonClickOutcome(attackerSaleBackTextField,numberOfWeeklyAttackerPassesAvaialable,attackerSolderBackTrainingWarningDisplayLabel,weekyTrainingPassForAttackersItem);
			if (outcomeOfAttackerSaleBack == true) {
				numOfAttacker =  Integer.parseInt(attackerSaleBackTextField.getText());
				attackerSolderBackTrainingWarningDisplayLabel.setText("being sold back for: "+weekyTrainingPassForAttackersItem.currentPrize()*numOfAttacker);
				
			}
	    
		}
		if(e.getSource() == proteinSuppliementSaleBackButton)
		{
			int numberOfProteinSupplimeentAvaialable = ClubRoom.numberOfProteinSuppliements;
			boolean outcomeProteinSupplicementSaleBack = itemButtonClickOutcome(proteinSupplimenentReturnBackTextField,numberOfProteinSupplimeentAvaialable,proteinSuppliementSoldbackDisplay,proteinSupplementItem);
			if (outcomeProteinSupplicementSaleBack == true)
			{
				NumOfProteinSupplmenet = Integer.parseInt(proteinSupplimenentReturnBackTextField.getText());
				proteinSuppliementSoldbackDisplay.setText("being sold back for " + proteinSupplementItem.currentPrize()*NumOfProteinSupplmenet);
			}
			
			
		}
		
		
		if(e.getSource() == proteinSuppliementReturnBackButton)
		{
	
			
			int numberProteinAvaiable = ClubRoom.numberOfProteinSuppliements;
			boolean salebackproteinSupplimenet = itemButtonClickOutcome(proteinSupplimenentReturnBackTextField,numberProteinAvaiable,proteinSuppliementSoldbackDisplay,proteinSupplementItem);
			if (salebackproteinSupplimenet == true)
			{
				
				NumOfProteinSupplmenet = Integer.parseInt(proteinSupplimenentReturnBackTextField.getText());
				inventory.removeItemFromInventory(proteinSupplementItem,NumOfProteinSupplmenet);
				numberOfPurchasedItemRemaining();
				ClubRoom.proteinSupplimentAvaiableCounterJLabel.setText("number remaining: "+ClubRoom.numberOfProteinSuppliements);
				GameMenu.money += proteinSupplementItem.currentPrize()*NumOfProteinSupplmenet;
				proteinSuppliementSoldbackDisplay.setText("Warning: transaction confirmed");
				moneyInAmountJLabel.setText("Money in account: "+GameMenu.money+" ");
				if(NumOfProteinSupplmenet <= ClubRoom.numberOfProteinSuppliements)
				{
					numberOfPurchasedItemRemaining();
					proteinSuppliementReturnBackButton.setEnabled(true);
				}else if(ClubRoom.numberOfProteinSuppliements == 0){
				buttonActivationStatus();
				proteinSuppliementReturnBackButton.setEnabled(false);
				proteinSupplimenentReturnBackTextField.setEnabled(false);
				proteinSuppliementSaleBackButton.setEnabled(false);
				}
			}
		
		}
		
		
		if(e.getSource() == confirmAttackerPassReturnBackButton)
		{
		
			numberOfPurchasedItemRemaining();
			int attackerPassesAvaiable = ClubRoom.numberOfWeeklyPassesForAttackers;
			boolean attackerReturnBackOutcome = itemButtonClickOutcome(attackerSaleBackTextField,attackerPassesAvaiable,attackerSolderBackTrainingWarningDisplayLabel,weekyTrainingPassForAttackersItem);
			if (attackerReturnBackOutcome == true) {
				
				numOfAttacker =  Integer.parseInt(attackerSaleBackTextField.getText());
				attackerSolderBackTrainingWarningDisplayLabel.setText("being sold back for: "+weekyTrainingPassForAttackersItem.currentPrize()*numOfAttacker);
				inventory.removeItemFromInventory(weekyTrainingPassForAttackersItem,numOfAttacker);
				numberOfPurchasedItemRemaining();
				GameMenu.money += weekyTrainingPassForAttackersItem.currentPrize()*numOfAttacker;
				ClubRoom.StrickerPassesRemainingCounterJLabel.setText("number remaining: "+ClubRoom.numberOfWeeklyPassesForAttackers);
				attackerSolderBackTrainingWarningDisplayLabel.setText("Warning: transaction confirmed");
				moneyInAmountJLabel.setText("Money in account: "+GameMenu.money+" ");
				if(numOfAttacker <= ClubRoom.numberOfWeeklyPassesForAttackers ) {
					confirmAttackerPassReturnBackButton.setEnabled(true);
				}
				else if(ClubRoom.numberOfWeeklyPassesForAttackers == 0) {
					buttonActivationStatus();
					attackerSaleBackTextField.setEnabled(false);
					attackerTrainingPassReturnBackButton.setEnabled(false);
					confirmAttackerPassReturnBackButton.setEnabled(false);
				}
			}
					
				
			
			
		}
	
		if(e.getSource() == confirmDefenderPassReturnBackButton)
		{

			numberOfPurchasedItemRemaining();
			int weeklyPassesRemaining = ClubRoom.numberOfWeeklyPassesForDefenders;
			boolean defendersaleBackoutcome = itemButtonClickOutcome(defenfderSaleBackTextField, weeklyPassesRemaining, defenderSoldBackTrainingWarningDisplayLabel, weeklyTrainingPassForDefenceItem);
			if ( defendersaleBackoutcome == true)
			{
				
				numOfdefender = Integer.parseInt(defenfderSaleBackTextField.getText());
				inventory.removeItemFromInventory(weeklyTrainingPassForDefenceItem,numOfdefender);
				numberOfPurchasedItemRemaining();
				ClubRoom.defenderPassRemainingCounter.setText("number remaining: "+ClubRoom.numberOfWeeklyPassesForDefenders);
				GameMenu.money += weeklyTrainingPassForDefenceItem.currentPrize()*numOfdefender;
				defenderSoldBackTrainingWarningDisplayLabel.setText("Warning: transaction confirmed");
				moneyInAmountJLabel.setText("Money in account: "+GameMenu.money+" ");
					if (numOfdefender <= ClubRoom.numberOfWeeklyPassesForDefenders)
					{
						confirmDefenderPassReturnBackButton.setEnabled(true);
					
					}
					else if(ClubRoom.numberOfWeeklyPassesForDefenders == 0) {
						buttonActivationStatus();
						confirmDefenderPassReturnBackButton.setEnabled(false);
						defenfderSaleBackTextField.setEnabled(false);
						defenceTrainingPassReturnBackButton.setEnabled(false);
					}
			}
			
			
	
		
		}
		if(e.getSource() == confirmGoalKeeperPassReturnBackButton)
		{
			
			numberOfPurchasedItemRemaining();
			int numberOfGoalKeeperPassesAvaiable = ClubRoom.numberOfWeeklPassesForGoalkeeper;
			boolean outcomeGoalKeeper = itemButtonClickOutcome(goalKeeperSaleBackTextField,numberOfGoalKeeperPassesAvaiable, goalKeeperSoldBackTrainingWarningDisplayLabel,weeklyTrainingPassForGoalkeeperItem );
			if ( outcomeGoalKeeper == true)
			{
				
				numOfGoalKeeper = Integer.parseInt(goalKeeperSaleBackTextField.getText());
				inventory.removeItemFromInventory(weeklyTrainingPassForGoalkeeperItem,numOfGoalKeeper);
				numberOfPurchasedItemRemaining();
				GameMenu.money += weeklyTrainingPassForGoalkeeperItem.currentPrize()*numOfGoalKeeper;
				ClubRoom.goalKeeperPassesRemainingCounterJLabel.setText("number remaining: "+ClubRoom.numberOfWeeklPassesForGoalkeeper);
				goalKeeperSoldBackTrainingWarningDisplayLabel.setText("Warning: transaction confirmed");
				moneyInAmountJLabel.setText("Money in account: "+GameMenu.money+" ");
				if(numOfGoalKeeper <= ClubRoom.numberOfWeeklPassesForGoalkeeper)
				{
					confirmGoalKeeperPassReturnBackButton.setEnabled(true);
				}
				else if(ClubRoom.numberOfWeeklPassesForGoalkeeper == 0){
					buttonActivationStatus();
					goalKeeperSaleBackTextField.setEnabled(false);
					goalkeeperTrainingPassReturnBackButton.setEnabled(false);
				confirmGoalKeeperPassReturnBackButton.setEnabled(false);
				
				}
			}
		
			
			
		
		}
		
		
	}
	

	/**
	 * Displays the number of remaining purchased items.
	 */
	public void numberOfPurchasedItemRemaining() {
		remainingGoalKeeperPassLabel.setText("number remaining: " + ClubRoom.numberOfWeeklPassesForGoalkeeper);
		remainingDefenderPassLabel.setText("number remaining: " + ClubRoom.numberOfWeeklyPassesForDefenders);
		remainingAttackerPassLabel.setText("number remaining: " + ClubRoom.numberOfWeeklyPassesForAttackers);
		remainingProteinSuppliementPassDisplay.setText("number remaining: " + ClubRoom.numberOfProteinSuppliements);
	}

	/**
	 * Checks the outcome of item button click based on user input.
	 *
	 * @param integerInput   The input field for the item quantity.
	 * @param numberAvailable The number of available items.
	 * @param displayWarning The label to display any warnings.
	 * @param item           The item being purchased.
	 * @return true if the purchase is confirmed, false otherwise.
	 */
	public boolean itemButtonClickOutcome(JTextField integerInput, int numberAvailable, JLabel displayWarning, Items item) {
		boolean confirmation = false;
		try {
			if (integerInput.getText().toString().length() == 0) {
				displayWarning.setText("Warning: no input");
			}
			int integer = Integer.parseInt(integerInput.getText());

			if (integer > numberAvailable) {
				displayWarning.setText("Warning: you only have " + numberAvailable);
			} else if (integer <= 0) {
				displayWarning.setText("Warning: invalid");
			} else {
				confirmation = true;
			}
		} catch (Exception e4) {
			displayWarning.setText("Warning: not an integer");
		}
		return confirmation;
	}
	/**
	 * Handles the click event on the list containing all the players in the squad.
	 */

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == listOfPlayersInSquad) {
			selected_player = (Object) listOfPlayersInSquad.getSelectedValue();
			selectedPLayerReturnButton.setEnabled(true);
		}
	}

	
	
}
