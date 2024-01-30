package game_main_menu;

import javax.swing.JFrame;
import javax.swing.DefaultButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.channels.Pipe.SourceChannel;
import java.util.ArrayList;
import java.util.EventListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import foot.Player;
import foot.Team;
import game_start_and_login_page.SignUpShop;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import java.awt.GridLayout;
import java.awt.Color;

/**
 * ClubRoom class provides users with the ability to swap players from the playing squad and the rerserves.
 * Enables players to implement purchased items on the players. 
 * Enables players to nickname players. 
 * Edd reserves to the playing squad. 
 * 
 * it also uses ActionListener and ListSelectionListener to handle on click events with the buttons and list item clicks respectively.
 * 
 * @author UdayD
 *
 */

public class ClubRoom implements ActionListener, ListSelectionListener {

	/**
	 * Number of weekly passes for goalkeepers.
	 */
	public static int numberOfWeeklPassesForGoalkeeper = 0;

	/**
	 * Number of weekly passes for defenders.
	 */
	public static int numberOfWeeklyPassesForDefenders = 0;

	/**
	 * Number of weekly passes for attackers.
	 */
	public static int numberOfWeeklyPassesForAttackers = 0;

	/**
	 * Number of protein supplements available.
	 */
	public static int numberOfProteinSuppliements = 0;

	/**
	 * Scroll pane for the player available list.
	 */
	public JScrollPane playerAvailable;

	/**
	 * Frame for the club.
	 */
	public static JFrame clubFrame = new JFrame();

	/**
	 * Button to go back to the game menu.
	 */
	static JButton backToGameMenu;

	/**
	 * Label to display the defense value.
	 */
	public static JLabel defenseDisplay;

	/**
	 * Label to display the offense value.
	 */
	public static JLabel offenseDisplay;

	/**
	 * Label to display the player's position.
	 */
	public static JLabel position;

	/**
	 * Label to display the stamina value.
	 */
	public static JLabel staminaDisplay;

	/**
	 * Label to display the player's nickname.
	 */
	public static JLabel playerNickname;

	/**
	 * Label to display the team name.
	 */
	static JLabel teamNameDisplay;

	/**
	 * JList to display the player list.
	 */
	public static JList playerList;

	/**
	 * Label for the total team player list display.
	 */
	private JLabel jLabelforTotalTeamPlayerListdisplay;

	/**
	 * Label for the player nickname change instruction.
	 */
	private JLabel playerNicknameChangeIntstruction;

	/**
	 * Label to display if the player is a reserve.
	 */
	public JLabel isRevserve;

	/**
	 * Label for the individual player stat display title.
	 */
	private JLabel individualPlayerstatdisplayTitleJLabel;

	/**
	 * Label for swapping instruction.
	 */
	private JLabel labelOneForSwappingInstruction;

	/**
	 * Text field for nickname change.
	 */
	private JTextField nickNameChangeTextField;

	/**
	 * Button to confirm name change.
	 */
	static JButton confirmNameChange;

	/**
	 * Object representing the selected player.
	 */
	Object selectedPlayer = new Player(0, 0, 0, "", "", false, false);

	/**
	 * Panel for purchased item implementation.
	 */
	private JPanel purchasedItemImplmentationBox;

	/**
	 * JPanel for playing four players.
	 */
	public JPanel PlayingFourJPanel;

	/**
	 * Scroll pane for inventory items.
	 */
	private JScrollPane inventoryItems;

	/**
	 * Text field for reserve player name.
	 */
	private JTextField reservePlayerNameTextField;

	/**
	 * Text field for entering playing athlete.
	 */
	private JTextField enterPlayingAtheleteTextField;

	/**
	 * Button for swapping players.
	 */
	private JButton swapButton;

	/**
	 * Label for playing athlete swap warning.
	 */
	private JLabel warningForPlayingAtheleteSwap;

	/**
	 * Label for non-playing swap warning.
	 */
	private JLabel jLabelForNonPlayingSwapWarning;

	/**
	 * Label for playing athlete text field.
	 */
	private JLabel labelForPlayingAtheleteTextField;

	/**
	 * Label for non-playing athlete text field.
	 */
	private JLabel labelForNonPlayingAtheletesTextField;

	/**
	 * Array to store all players.
	 */
	public static Object[] totalPlayers;

	/**
	 * Array to store playing four players.
	 */
	public static Object[] playingFour;

	/**
	 * Array to store reserve players.
	 */
	public static Object[] reserves;

	/**
	 * JList for displaying the four playing players.
	 */
	public static JList<Object> fourPlayingPlayers;

	/**
	 * JList for displaying the reserve players.
	 */
	public static JList<Object> reservePlayersList;

	/**
	 * Temporary object for reserve player.
	 */
	private Team tempObjectReserve;

	/**
	 * Temporary object for playing player.
	 */
	private Team tempPlayingObject;

	/**
	 * Scroll pane for playing four player list.
	 */
	private JScrollPane playingfourPlayerJScrollPane;

	/**
	 * Button for weekly training pass for goalkeeper.
	 */
	public static JButton weeklyTrainingPassForGoalKeeperTextField;

	/**
	 * Text field for goalkeeper training pass.
	 */
	public static JTextField goalKeeperTextField;

	/**
	 * Button for defender training pass.
	 */
	public static JButton defenderTrainingPassButton;

	/**
	 * Text field for defender training pass.
	 */
	public static JTextField defenderTextField;

	/**
	 * Panel for player swap.
	 */
	private JPanel playerSwapPanel;

	/**
	 * Button for striker training.
	 */
	public static JButton strickerTrainingButton;

	/**
	 * Text field for striker training.
	 */
	public static JTextField strickerTextField;

	/**
	 * Button for protein supplement.
	 */
	public static JButton proteinSupplimentButton;

	/**
	 * Text field for protein supplement.
	 */
	public static JTextField proteinSupplimenetTextField;

	/**
	 * Panel for name change.
	 */
	private JPanel nameChangePanel;

	/**
	 * Scroll pane for general item information.
	 */
	private JScrollPane generalItemInfoScollPane;

	/**
	 * Label for goalkeeper purchase warning.
	 */
	private JLabel goalkeeperPuchaseWarningJLabel;

	/**
	 * Label for defender purchase warning.
	 */
	private JLabel defenderPurchaseWarningJLabel;

	/**
	 * Label for striker purchase warning.
	 */
	private JLabel strickerPurchaseWarningJLabel;

	/**
	 * Label for protein supplement warning.
	 */
	private JLabel proteinSupplimenetWarningJLabel;

	/**
	 * Label for item information section title.
	 */
	private JLabel itemInformationSectionJLabelTitle;

	/**
	 * Label for weekly training pass display.
	 */
	public static JLabel weeklyTrainingPassDisplay;

	/**
	 * Label for goalkeeper passes remaining counter.
	 */
	public static JLabel goalKeeperPassesRemainingCounterJLabel;

	/**
	 * Label for defender passes remaining counter.
	 */
	public static JLabel defenderPassRemainingCounter;

	/**
	 * Label for striker passes remaining counter.
	 */
	static JLabel StrickerPassesRemainingCounterJLabel;

	/**
	 * Label for protein supplement available counter.
	 */
	public static JLabel proteinSupplimentAvaiableCounterJLabel;

	/**
	 * Label for protein supplement stat display.
	 */
	public JLabel proteinSuppliementStatDisplay;

	/**
	 * Label for instruction to enter player name.
	 */
	private JLabel InstrcutionToEnterPLayerNameLabel;

	/**
	 * Label for reflex.
	 */
	public JLabel reflex;

	/**
	 * Scroll pane for playing four squad list.
	 */
	private JScrollPane playingFourSquadList;

	/**
	 * Label for player addition instruction.
	 */
	private JLabel playerAdditionIInstructionJLabel2;

	/**
	 * Label for player addition instruction.
	 */
	private JLabel playerAdditionIInstructionJLabel3;

	/**
	 * Button for adding player to playing list.
	 */
	private JButton addPlayerToPlayingListButton;
	private JLabel ProteinSupplimentINstruction1;
	private JLabel proteinSupplimenetINstruction2;
	private JLabel weeklyTrainingPassesInstruction2;
	private JLabel lblDifficultyChosen;
	private JLabel lblDifficultyChosen2;
	
	/**
	 * Constructor used to initialize the frame contant
	 * including buttons 
	 * labels 
	 * items etc. 
	 */
	
	public ClubRoom() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the ClubFrame.
	 */
	
	public  void initialize() {
		
		ClubRoom.clubFrame.setLocationRelativeTo(null);
		clubFrame.setBounds(100, 100, 1384, 770);
		clubFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		backToGameMenu = new JButton("< back");
		backToGameMenu.addActionListener(this);
		backToGameMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		teamNameDisplay = new JLabel("Team: "+ GameMenu.team);
		teamNameDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		teamNameDisplay.setFont(new Font("Arial", Font.BOLD, 75));
		
		JScrollPane playerJScrollPane = new JScrollPane();
		playerJScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		playerJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		playerAvailable = new JScrollPane();
		playerAvailable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		playerAvailable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		jLabelforTotalTeamPlayerListdisplay = new JLabel("Total Team players available");
		jLabelforTotalTeamPlayerListdisplay.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelforTotalTeamPlayerListdisplay.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		inventoryItems = new JScrollPane();
		inventoryItems.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		inventoryItems.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		individualPlayerstatdisplayTitleJLabel = new JLabel("Select player from the list to see their statistics ");
		individualPlayerstatdisplayTitleJLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		individualPlayerstatdisplayTitleJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		playingFourSquadList = new JScrollPane();
		playingFourSquadList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		playingFourSquadList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JLabel playingSquadTitleJLabel = new JLabel("Atheletes chosen for the game ");
		playingSquadTitleJLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		playingSquadTitleJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		playingfourPlayerJScrollPane = new JScrollPane();
		playingfourPlayerJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		playingfourPlayerJScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JLabel lblNewLabel31 = new JLabel("Reserve(*)/non-playing atheletes");
		lblNewLabel31.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel31.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		playerSwapPanel = new JPanel();
		
		nameChangePanel = new JPanel();
		nameChangePanel.setForeground(new Color(0, 128, 192));
		
		JScrollPane scrollPane = new JScrollPane();
		
		generalItemInfoScollPane = new JScrollPane();
		generalItemInfoScollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		generalItemInfoScollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JLabel InventoryJLabelTitle = new JLabel("Items available to the athelete");
		InventoryJLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		InventoryJLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JPanel addReserveToPlayingListJLabelBox = new JPanel();
		
		addPlayerToPlayingListButton = new JButton("Add to playing list");
		addPlayerToPlayingListButton.addActionListener(this);
		JLabel playerAdditionIInstructionJLabel = new JLabel("please select a player from the list above and click the");
		playerAdditionIInstructionJLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		playerAdditionIInstructionJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		playerAdditionIInstructionJLabel2 = new JLabel("add button below to add the player to playing 4 list ");
		playerAdditionIInstructionJLabel2.setFont(new Font("Tahoma", Font.BOLD, 10));
		playerAdditionIInstructionJLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		
		playerAdditionIInstructionJLabel3 = new JLabel("note: the player must be a reserve and its position should be open in the playing list ");
		playerAdditionIInstructionJLabel3.setFont(new Font("Tahoma", Font.BOLD, 10));
		playerAdditionIInstructionJLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout glAddReserveToPlayingListJLabelBox = new GroupLayout(addReserveToPlayingListJLabelBox);
		glAddReserveToPlayingListJLabelBox.setHorizontalGroup(
			glAddReserveToPlayingListJLabelBox.createParallelGroup(Alignment.LEADING)
				.addGroup(glAddReserveToPlayingListJLabelBox.createSequentialGroup()
					.addGap(103)
					.addGroup(glAddReserveToPlayingListJLabelBox.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(addPlayerToPlayingListButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(playerAdditionIInstructionJLabel, Alignment.LEADING)
						.addComponent(playerAdditionIInstructionJLabel2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
					.addGap(114))
				.addGroup(glAddReserveToPlayingListJLabelBox.createSequentialGroup()
					.addContainerGap()
					.addComponent(playerAdditionIInstructionJLabel3, GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
					.addContainerGap())
		);
		glAddReserveToPlayingListJLabelBox.setVerticalGroup(
			glAddReserveToPlayingListJLabelBox.createParallelGroup(Alignment.LEADING)
				.addGroup(glAddReserveToPlayingListJLabelBox.createSequentialGroup()
					.addComponent(playerAdditionIInstructionJLabel)
					.addGap(3)
					.addComponent(playerAdditionIInstructionJLabel2)
					.addGap(2)
					.addComponent(addPlayerToPlayingListButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(playerAdditionIInstructionJLabel3, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
					.addContainerGap())
		);
		addReserveToPlayingListJLabelBox.setLayout(glAddReserveToPlayingListJLabelBox);
		
		itemInformationSectionJLabelTitle = new JLabel("                 general information about the items ");
		generalItemInfoScollPane.setColumnHeaderView(itemInformationSectionJLabelTitle);
		itemInformationSectionJLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		itemInformationSectionJLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		confirmNameChange = new JButton("change or set player nickname");
		confirmNameChange.addActionListener(this);
		
		playerNicknameChangeIntstruction = new JLabel("please select a player from the list above in order ");
		playerNicknameChangeIntstruction.setFont(new Font("Tahoma", Font.BOLD, 10));
		playerNicknameChangeIntstruction.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel playerNicknameChangeIntstruction1 = new JLabel("to change give/set their nickname.");
		playerNicknameChangeIntstruction1.setFont(new Font("Tahoma", Font.BOLD, 10));
		playerNicknameChangeIntstruction1.setHorizontalAlignment(SwingConstants.CENTER);
		nickNameChangeTextField = new JTextField();
		nickNameChangeTextField.setColumns(10);
		GroupLayout glNameChangePanel = new GroupLayout(nameChangePanel);
		glNameChangePanel.setHorizontalGroup(
			glNameChangePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, glNameChangePanel.createSequentialGroup()
					.addGap(20)
					.addGroup(glNameChangePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(playerNicknameChangeIntstruction, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
						.addGroup(glNameChangePanel.createSequentialGroup()
							.addGap(31)
							.addComponent(confirmNameChange, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
							.addGap(43))
						.addGroup(glNameChangePanel.createSequentialGroup()
							.addGap(55)
							.addComponent(playerNicknameChangeIntstruction1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(57))
						.addGroup(glNameChangePanel.createSequentialGroup()
							.addGap(79)
							.addComponent(nickNameChangeTextField, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
							.addGap(90)))
					.addContainerGap())
		);
		glNameChangePanel.setVerticalGroup(
			glNameChangePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, glNameChangePanel.createSequentialGroup()
					.addGap(0, 0, Short.MAX_VALUE)
					.addComponent(nickNameChangeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(confirmNameChange)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(playerNicknameChangeIntstruction)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(playerNicknameChangeIntstruction1)
					.addGap(39))
		);
		nameChangePanel.setLayout(glNameChangePanel);
		
		swapButton = new JButton("swap players");
		swapButton.addActionListener(this);
		
		reservePlayerNameTextField = new JTextField();
		reservePlayerNameTextField.setColumns(10);
		
		enterPlayingAtheleteTextField = new JTextField();
		enterPlayingAtheleteTextField.setColumns(10);
		
		labelForNonPlayingAtheletesTextField = new JLabel("Non-playing atheletes ");
		labelForNonPlayingAtheletesTextField.setHorizontalAlignment(SwingConstants.CENTER);
		
		labelForPlayingAtheleteTextField = new JLabel("Playing athelete");
		labelForPlayingAtheleteTextField.setHorizontalAlignment(SwingConstants.CENTER);
		
		warningForPlayingAtheleteSwap = new JLabel("Warning: ");
		warningForPlayingAtheleteSwap.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		jLabelForNonPlayingSwapWarning = new JLabel("Warning: ");
		jLabelForNonPlayingSwapWarning.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		labelOneForSwappingInstruction = new JLabel("To swap the playing atheletes with reserves use their provided names");
		labelOneForSwappingInstruction.setFont(new Font("Tahoma", Font.BOLD, 8));
		labelOneForSwappingInstruction.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel labelTwoForSwappingInstruction = new JLabel("(not nicknames) and make sure they are playing for the same position.");
		labelTwoForSwappingInstruction.setFont(new Font("Tahoma", Font.BOLD, 8));
		labelTwoForSwappingInstruction.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout glPlayerSwapPanel = new GroupLayout(playerSwapPanel);
		glPlayerSwapPanel.setHorizontalGroup(
			glPlayerSwapPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(labelTwoForSwappingInstruction, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
				.addGroup(glPlayerSwapPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelOneForSwappingInstruction, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(glPlayerSwapPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelForPlayingAtheleteTextField, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelForNonPlayingAtheletesTextField, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(glPlayerSwapPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(glPlayerSwapPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(glPlayerSwapPanel.createSequentialGroup()
							.addGap(77)
							.addComponent(swapButton, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
							.addGap(72))
						.addGroup(glPlayerSwapPanel.createSequentialGroup()
							.addGroup(glPlayerSwapPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(warningForPlayingAtheleteSwap, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
								.addComponent(reservePlayerNameTextField, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
							.addGap(4)
							.addGroup(glPlayerSwapPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(glPlayerSwapPanel.createSequentialGroup()
									.addGap(2)
									.addComponent(enterPlayingAtheleteTextField, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
								.addGroup(glPlayerSwapPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(jLabelForNonPlayingSwapWarning, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))))
					.addGap(10))
		);
		glPlayerSwapPanel.setVerticalGroup(
			glPlayerSwapPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(glPlayerSwapPanel.createSequentialGroup()
					.addGap(39)
					.addGroup(glPlayerSwapPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelForPlayingAtheleteTextField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelForNonPlayingAtheletesTextField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glPlayerSwapPanel.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(enterPlayingAtheleteTextField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(reservePlayerNameTextField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glPlayerSwapPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabelForNonPlayingSwapWarning, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(warningForPlayingAtheleteSwap))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(swapButton, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(labelOneForSwappingInstruction, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelTwoForSwappingInstruction, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addGap(63))
		);
		playerSwapPanel.setLayout(glPlayerSwapPanel);
		
		
		PlayingFourJPanel = new JPanel();
		
		playingfourPlayerJScrollPane.setViewportView(reservePlayersList);
		
		
		
		playingFourSquadList.setViewportView(fourPlayingPlayers);
		PlayingFourJPanel.setPreferredSize(new Dimension(100,280));
			
		
			JPanel playerInfo = new JPanel();
			playerJScrollPane.setViewportView(playerInfo);
			playerInfo.setPreferredSize(new Dimension(400, 350));
			
			staminaDisplay = new JLabel("stamina: ");
			staminaDisplay.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
			
			offenseDisplay = new JLabel("offense: ");
			offenseDisplay.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
			
			defenseDisplay = new JLabel("defense: ");
			defenseDisplay.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
			
			position = new JLabel("position: ");
			position.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
			
			playerNickname = new JLabel("player nickname:");
			playerNickname.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
			
			isRevserve = new JLabel("reserve: ");
			isRevserve.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
			
			weeklyTrainingPassDisplay = new JLabel("weekly training pass: ");
			weeklyTrainingPassDisplay.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
			
			proteinSuppliementStatDisplay = new JLabel("protein suppliement taken this week: ");
			proteinSuppliementStatDisplay.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
			
			reflex = new JLabel("reflex: ");
			reflex.setVisible(false);
			reflex.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
			GroupLayout glPlayerInfo = new GroupLayout(playerInfo);
			glPlayerInfo.setHorizontalGroup(
				glPlayerInfo.createParallelGroup(Alignment.LEADING)
					.addGroup(glPlayerInfo.createSequentialGroup()
						.addContainerGap()
						.addGroup(glPlayerInfo.createParallelGroup(Alignment.LEADING)
							.addGroup(glPlayerInfo.createSequentialGroup()
								.addGroup(glPlayerInfo.createParallelGroup(Alignment.LEADING)
									.addGroup(glPlayerInfo.createParallelGroup(Alignment.LEADING, false)
										.addComponent(defenseDisplay, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
										.addComponent(staminaDisplay, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(offenseDisplay, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
									.addComponent(isRevserve, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
								.addGap(18))
							.addGroup(glPlayerInfo.createSequentialGroup()
								.addComponent(reflex, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(glPlayerInfo.createParallelGroup(Alignment.LEADING)
							.addGroup(glPlayerInfo.createSequentialGroup()
								.addGroup(glPlayerInfo.createParallelGroup(Alignment.LEADING)
									.addGroup(glPlayerInfo.createParallelGroup(Alignment.TRAILING)
										.addGroup(glPlayerInfo.createSequentialGroup()
											.addComponent(playerNickname, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
											.addGap(109))
										.addComponent(position, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
									.addGroup(glPlayerInfo.createSequentialGroup()
										.addComponent(weeklyTrainingPassDisplay, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 96, GroupLayout.PREFERRED_SIZE)))
								.addGap(97))
							.addComponent(proteinSuppliementStatDisplay, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)))
			);
			glPlayerInfo.setVerticalGroup(
				glPlayerInfo.createParallelGroup(Alignment.TRAILING)
					.addGroup(glPlayerInfo.createSequentialGroup()
						.addContainerGap(180, Short.MAX_VALUE)
						.addGroup(glPlayerInfo.createParallelGroup(Alignment.BASELINE)
							.addComponent(proteinSuppliementStatDisplay, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
							.addComponent(reflex))
						.addGap(18)
						.addGroup(glPlayerInfo.createParallelGroup(Alignment.LEADING)
							.addGroup(glPlayerInfo.createSequentialGroup()
								.addComponent(staminaDisplay, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(offenseDisplay, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(glPlayerInfo.createParallelGroup(Alignment.BASELINE)
									.addComponent(defenseDisplay, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addComponent(weeklyTrainingPassDisplay)))
							.addGroup(glPlayerInfo.createSequentialGroup()
								.addComponent(playerNickname, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(position, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(isRevserve, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
			);
			playerInfo.setLayout(glPlayerInfo);
		
		
		purchasedItemImplmentationBox = new JPanel();
		inventoryItems.setViewportView(purchasedItemImplmentationBox);
		purchasedItemImplmentationBox.setPreferredSize(new Dimension(360, 400));
		
		goalKeeperTextField = new JTextField();
		goalKeeperTextField.setColumns(10);
		weeklyTrainingPassForGoalKeeperTextField = new JButton("weekly training pass for goalkeepers");
		
		weeklyTrainingPassForGoalKeeperTextField.addActionListener(this);
		weeklyTrainingPassForGoalKeeperTextField.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		
		defenderTextField = new JTextField();
		defenderTextField.setColumns(10);
		defenderTrainingPassButton = new JButton("weekly training pass for defenders");
		
		defenderTrainingPassButton.addActionListener(this);
		defenderTrainingPassButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		
		
		strickerTrainingButton = new JButton("weekly training pass for strickers");
		strickerTextField = new JTextField();
		strickerTextField.setColumns(10);
	
		strickerTrainingButton.addActionListener(this);
		strickerTrainingButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		

		
		proteinSupplimentButton = new JButton("protein_suppliments");
		proteinSupplimenetTextField = new JTextField();
		proteinSupplimenetTextField.setColumns(10);

		proteinSupplimentButton.addActionListener(this);
		proteinSupplimentButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		
		
		goalkeeperPuchaseWarningJLabel = new JLabel("Warning: ");
		
		defenderPurchaseWarningJLabel = new JLabel("Warning: ");
		
		strickerPurchaseWarningJLabel = new JLabel("Warning: ");
		
		proteinSupplimenetWarningJLabel = new JLabel("Warning: ");
		
		goalKeeperPassesRemainingCounterJLabel = new JLabel("number remaining: "+numberOfWeeklPassesForGoalkeeper);
		
		defenderPassRemainingCounter = new JLabel("number remaining: "+numberOfWeeklyPassesForDefenders);
		
		StrickerPassesRemainingCounterJLabel = new JLabel("number remaining: "+numberOfWeeklyPassesForAttackers);
		
		proteinSupplimentAvaiableCounterJLabel = new JLabel("number remaining: "+numberOfProteinSuppliements);
		
		InstrcutionToEnterPLayerNameLabel = new JLabel("Enter the player names below");
		InstrcutionToEnterPLayerNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GroupLayout glPurchasedItemImplmentationBox = new GroupLayout(purchasedItemImplmentationBox);
		glPurchasedItemImplmentationBox.setHorizontalGroup(
			glPurchasedItemImplmentationBox.createParallelGroup(Alignment.LEADING)
				.addGroup(glPurchasedItemImplmentationBox.createSequentialGroup()
					.addGap(12)
					.addComponent(defenderTrainingPassButton, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(defenderTextField, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
					.addGap(449))
				.addGroup(glPurchasedItemImplmentationBox.createSequentialGroup()
					.addContainerGap()
					.addComponent(defenderPurchaseWarningJLabel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(584, Short.MAX_VALUE))
				.addGroup(glPurchasedItemImplmentationBox.createSequentialGroup()
					.addGap(11)
					.addComponent(StrickerPassesRemainingCounterJLabel, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(581, Short.MAX_VALUE))
				.addGroup(glPurchasedItemImplmentationBox.createSequentialGroup()
					.addGap(11)
					.addComponent(defenderPassRemainingCounter, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(574, Short.MAX_VALUE))
				.addGroup(glPurchasedItemImplmentationBox.createSequentialGroup()
					.addContainerGap()
					.addGroup(glPurchasedItemImplmentationBox.createParallelGroup(Alignment.TRAILING)
						.addGroup(glPurchasedItemImplmentationBox.createSequentialGroup()
							.addComponent(strickerPurchaseWarningJLabel, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(246))
						.addGroup(glPurchasedItemImplmentationBox.createSequentialGroup()
							.addGroup(glPurchasedItemImplmentationBox.createParallelGroup(Alignment.LEADING)
								.addGroup(glPurchasedItemImplmentationBox.createSequentialGroup()
									.addComponent(strickerTrainingButton, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(strickerTextField, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
									.addGap(404))
								.addGroup(glPurchasedItemImplmentationBox.createSequentialGroup()
									.addGroup(glPurchasedItemImplmentationBox.createParallelGroup(Alignment.LEADING)
										.addGroup(glPurchasedItemImplmentationBox.createSequentialGroup()
											.addGap(6)
											.addComponent(goalKeeperPassesRemainingCounterJLabel, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(InstrcutionToEnterPLayerNameLabel)
											.addGap(0, 0, Short.MAX_VALUE))
										.addGroup(glPurchasedItemImplmentationBox.createSequentialGroup()
											.addComponent(weeklyTrainingPassForGoalKeeperTextField, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(goalKeeperTextField, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
									.addGap(403)))
							.addGap(46))))
				.addGroup(glPurchasedItemImplmentationBox.createSequentialGroup()
					.addGap(11)
					.addComponent(goalkeeperPuchaseWarningJLabel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(601, Short.MAX_VALUE))
				.addGroup(glPurchasedItemImplmentationBox.createSequentialGroup()
					.addContainerGap()
					.addGroup(glPurchasedItemImplmentationBox.createParallelGroup(Alignment.LEADING)
						.addGroup(glPurchasedItemImplmentationBox.createSequentialGroup()
							.addGap(1)
							.addComponent(proteinSupplimentAvaiableCounterJLabel, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 158, GroupLayout.PREFERRED_SIZE))
						.addGroup(glPurchasedItemImplmentationBox.createParallelGroup(Alignment.LEADING)
							.addComponent(proteinSupplimenetWarningJLabel, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
							.addGroup(glPurchasedItemImplmentationBox.createSequentialGroup()
								.addComponent(proteinSupplimentButton, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(proteinSupplimenetTextField, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(203, Short.MAX_VALUE))
		);
		glPurchasedItemImplmentationBox.setVerticalGroup(
			glPurchasedItemImplmentationBox.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, glPurchasedItemImplmentationBox.createSequentialGroup()
					.addGap(83)
					.addGroup(glPurchasedItemImplmentationBox.createParallelGroup(Alignment.BASELINE)
						.addComponent(goalKeeperPassesRemainingCounterJLabel)
						.addComponent(InstrcutionToEnterPLayerNameLabel, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glPurchasedItemImplmentationBox.createParallelGroup(Alignment.BASELINE)
						.addComponent(weeklyTrainingPassForGoalKeeperTextField)
						.addComponent(goalKeeperTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(goalkeeperPuchaseWarningJLabel)
					.addGap(12)
					.addComponent(defenderPassRemainingCounter)
					.addGroup(glPurchasedItemImplmentationBox.createParallelGroup(Alignment.LEADING)
						.addGroup(glPurchasedItemImplmentationBox.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(defenderTrainingPassButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(defenderPurchaseWarningJLabel))
						.addGroup(glPurchasedItemImplmentationBox.createSequentialGroup()
							.addGap(5)
							.addComponent(defenderTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(9)
					.addComponent(StrickerPassesRemainingCounterJLabel)
					.addGap(12)
					.addGroup(glPurchasedItemImplmentationBox.createParallelGroup(Alignment.BASELINE)
						.addComponent(strickerTrainingButton)
						.addComponent(strickerTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(strickerPurchaseWarningJLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
			 		.addComponent(proteinSupplimentAvaiableCounterJLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glPurchasedItemImplmentationBox.createParallelGroup(Alignment.BASELINE)
						.addComponent(proteinSupplimenetTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(proteinSupplimentButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(proteinSupplimenetWarningJLabel)
					.addContainerGap(338, Short.MAX_VALUE))
		);
		purchasedItemImplmentationBox.setLayout(glPurchasedItemImplmentationBox);
		updatePlayerSquad();
		GroupLayout groupLayout = new GroupLayout(clubFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(backToGameMenu)
							.addGap(40)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(376)
									.addComponent(individualPlayerstatdisplayTitleJLabel, GroupLayout.PREFERRED_SIZE, 548, GroupLayout.PREFERRED_SIZE))
								.addComponent(teamNameDisplay, GroupLayout.PREFERRED_SIZE, 1110, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1067)
							.addComponent(InventoryJLabelTitle, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(jLabelforTotalTeamPlayerListdisplay, GroupLayout.PREFERRED_SIZE, 493, GroupLayout.PREFERRED_SIZE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(playerAvailable, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
						.addComponent(addReserveToPlayingListJLabelBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addComponent(playerJScrollPane, GroupLayout.PREFERRED_SIZE, 539, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(inventoryItems, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(nameChangePanel, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE)
						.addComponent(playerSwapPanel, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel31, GroupLayout.PREFERRED_SIZE, 539, GroupLayout.PREFERRED_SIZE)
						.addComponent(playingfourPlayerJScrollPane, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE)
						.addComponent(playingSquadTitleJLabel, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE)
						.addComponent(playingFourSquadList, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addComponent(generalItemInfoScollPane, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(1363)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(backToGameMenu)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(78)
									.addComponent(individualPlayerstatdisplayTitleJLabel))
								.addComponent(teamNameDisplay, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(89)
							.addComponent(InventoryJLabelTitle))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(89)
							.addComponent(jLabelforTotalTeamPlayerListdisplay)))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(playerAvailable, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(addReserveToPlayingListJLabelBox, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
						.addComponent(playerJScrollPane, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
						.addComponent(inventoryItems, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(nameChangePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(playerSwapPanel, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel31)
							.addGap(2)
							.addComponent(playingfourPlayerJScrollPane, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(playingSquadTitleJLabel)
							.addGap(2)
							.addComponent(playingFourSquadList, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
						.addComponent(generalItemInfoScollPane, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		
		JPanel panel = new JPanel();
		generalItemInfoScollPane.setViewportView(panel);
		
		JLabel Pro = new JLabel("Protein Supplement:");
		
		JLabel weeklyTrainngPassesTItle = new JLabel("Weekly trainig passes:");
		
		JLabel weeklyTrainingPassesInstruction = new JLabel("Increases player stat by a certain amount depending on difficulty chosen ");
		
		JLabel lblNewLabel_1_1_1 = new JLabel("New label");
		
		ProteinSupplimentINstruction1 = new JLabel("increases stamian of player by 25 ");
		
		proteinSupplimenetINstruction2 = new JLabel("can only be consumed onces a week");
		
		weeklyTrainingPassesInstruction2 = new JLabel("Difficulty chosen 1 = stat set 15");
		
		lblDifficultyChosen = new JLabel("Difficulty chosen 2 = stat set 10");
		
		lblDifficultyChosen2 = new JLabel("Difficulty chosen 3 = stat set 5");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(ProteinSupplimentINstruction1, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
							.addComponent(proteinSupplimenetINstruction2, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
							.addComponent(Pro, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(5)
								.addComponent(lblDifficultyChosen2, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblNewLabel_1_1_1, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(weeklyTrainngPassesTItle, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(weeklyTrainingPassesInstruction2, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 281, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDifficultyChosen, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(weeklyTrainingPassesInstruction)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(Pro, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(ProteinSupplimentINstruction1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(proteinSupplimenetINstruction2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(weeklyTrainngPassesTItle, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(weeklyTrainingPassesInstruction, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(weeklyTrainingPassesInstruction2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(lblDifficultyChosen, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDifficultyChosen2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		clubFrame.getContentPane().setLayout(groupLayout);
		
		
	
	}
	/**
	 * Updates/Activates the button based on the available passes and protein suppplment.
	 */
	public static void purchaseButtonActivation()
	{
		

		if(numberOfWeeklyPassesForAttackers== 0)
		{
			strickerTextField.setEnabled(false);
			strickerTrainingButton.setEnabled(false);
		}
		else if(numberOfWeeklyPassesForAttackers > 0) {
			strickerTextField.setEnabled(true);
			StrickerPassesRemainingCounterJLabel.setText("number remaining: "+numberOfWeeklyPassesForAttackers);
			strickerTrainingButton.setEnabled(true);
		}
		
		if(numberOfProteinSuppliements == 0)
		{
			proteinSupplimentButton.setEnabled(false);
			proteinSupplimenetTextField.setEnabled(false);
			
		}else if(numberOfProteinSuppliements > 0)
		{
			proteinSupplimentButton.setEnabled(true);
			proteinSupplimentAvaiableCounterJLabel.setText("number remaining: "+numberOfProteinSuppliements);
			proteinSupplimenetTextField.setEnabled(true);
			
		}
		if(numberOfWeeklyPassesForDefenders == 0)
		{
			defenderTrainingPassButton.setEnabled(false);
			defenderTextField.setEnabled(false);
		}else if(numberOfWeeklyPassesForDefenders > 0)
		{
			defenderTrainingPassButton.setEnabled(true);
			defenderPassRemainingCounter.setText("number remaining: "+numberOfWeeklyPassesForDefenders);
			defenderTextField.setEnabled(true);
		}
		
		if (numberOfWeeklPassesForGoalkeeper == 0)
		{
			goalKeeperTextField.setEnabled(false);
			weeklyTrainingPassForGoalKeeperTextField.setEnabled(false);
		}
		else if (numberOfWeeklPassesForGoalkeeper > 0)
		{
			goalKeeperTextField.setEnabled(true);
			goalKeeperPassesRemainingCounterJLabel.setText("number remaining: "+numberOfWeeklPassesForGoalkeeper);
			weeklyTrainingPassForGoalKeeperTextField.setEnabled(true);
		}
	}
	/**
	 * Updates the player squad based on the current list of players.
	 */
	public void updatePlayerSquad()
	{
	    int i = 0;
	    int reserveCounter = 0;
	    
	    // Count the number of players in the reserve and playing list
	    for (Player player : SignUpShop.playerList.player)
	    {
	        if (player.isReserve())
	        {
	            reserveCounter += 1;
	        }
	        else {
	            i += 1;
	        }
	    }
	    
	    // Initialize the playingFour and reserves arrays based on the counts
	    playingFour = new Object[i];
	    fourPlayingPlayers = new JList<Object>(playingFour);
	    reserves = new Object[reserveCounter];

	    i = 0;
	    reservePlayersList = new JList<Object>(reserves);
	    totalPlayers = new Object[SignUpShop.playerList.player.size()];
	    playerList = new JList<Object>(totalPlayers);
	    playerList.addListSelectionListener(this);

	    //Assigns all the players in the playersList to the totalPlayers array 
	    for (Team player : SignUpShop.playerList.player)
	    {
	        totalPlayers[i] = player;
	        i += 1;
	    }

	    reserveCounter = 0;
	    i = 0;
	    // adds players into playingFour and reserves arrays according to their reserve status
	    if (SignUpShop.playerList.player.size() > 0)
	    {
	        for (Player player : SignUpShop.playerList.player)
	        {
	            if (!player.isReserve())
	            {
	                playingFour[i] = player;
	                i += 1;
	            }
	            else {
	                reserves[reserveCounter] = player;
	                reserveCounter += 1;
	            }
	        }
	    }

	    // Set the view of the JLists
	    playingfourPlayerJScrollPane.setViewportView(reservePlayersList);
	    playingFourSquadList.setViewportView(fourPlayingPlayers);
	    playerAvailable.setViewportView(playerList);
	}

	/**
	 * Checks if a player with the given name and position is present in the squad.
	 * @param name The name of the player
	 * @param position The position of the player
	 * @return True if the player is found in the squad with the specified position, false otherwise
	 */
	public boolean InSquad(String name, String position)
	{
	    boolean playerFound = false;
	    for (Team player : SignUpShop.playerList.player)
	    {
	        if (name.equals(((Player) player).getName()) && position.equals(((Player) player).getPosition()))
	        {
	            playerFound = true;
	        }
	    }
	    return playerFound;
	}

	/**
	 * Checks the position of a player with the given name in the squad.
	 * @param name The name of the player
	 * @return The position of the player, or an empty string if the player is not found in the squad
	 */
	public String inSquadWithUnknownPosition(String name)
	{
	    String playerPosition = "";
	    for (Team player : SignUpShop.playerList.player)
	    {
	        if (name.equals(((Player) player).getName()))
	        {
	            playerPosition = ((Player) player).getPosition();
	        }
	    }
	    return playerPosition;
	}

	/**
	 * Helper method to cast the player object to the appropriate type.
	 * @param name The name of the player
	 * @return The player object with the given name
	 */
	public Object playerCastingHelper(String name)
	{
	    Object playerFound = new Object();

	    for (Team player : SignUpShop.playerList.player)
	    {
	        if (name.equals(((Player) player).getName()))
	        {
	            playerFound = player;
	        }
	    }
	    return playerFound;
	}

	/**
	 * Updates the display of stamina, offense, and defense values for a player.
	 * @param playerName The name of the player
	 */
	public void displayStaAndOffAndDifUpdate(String playerName)
	{
	    staminaDisplay.setText("stamina: " + ((Player) playerCastingHelper(playerName)).stamina() + " ");

	    offenseDisplay.setText("offense: " + ((Player) playerCastingHelper(playerName)).offense() + " ");

	    defenseDisplay.setText("defense: " + ((Player) playerCastingHelper(playerName)).defence() + " ");
	}

	
	/**
	 * actionPerformed Handles all the ActionEvents triggered by button clicsk
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == proteinSupplimentButton) {
			// Get the name entered in the protein supplement text field
			String playerName = proteinSupplimenetTextField.getText();
			// Determine the position of the player in the squad
			String playerPosition = inSquadWithUnknownPosition(playerName);
			
			if (playerName.length() == 0 && playerPosition.length() == 0) {
				proteinSupplimenetWarningJLabel.setText("Warning: no input");
			}
			if (playerName.length() > 0 && playerPosition.length() == 0) {
				proteinSupplimenetWarningJLabel.setText("Warning: player not in squad");
			} else {
				if (InSquad(playerName, playerPosition) == true) {
					// Check if the player already has a protein supplement applied
					if (((Player) playerCastingHelper(playerName)).hasProteinSuppliement() == "yes") {
						proteinSupplimenetWarningJLabel.setText("Warning: already applied");
					} else {
						// Apply the protein supplement to the player
						((Player) playerCastingHelper(playerName)).setProteinSuppliement(true);
						((Player) playerCastingHelper(playerName)).isProteinSuppliement();
						proteinSupplimenetWarningJLabel.setText("Warning: Confirmed");
						proteinSupplimentAvaiableCounterJLabel.setText("number remaining: " + numberOfProteinSuppliements);
						if (numberOfProteinSuppliements == 0) {
							proteinSupplimentButton.setEnabled(false);
							proteinSupplimenetTextField.setText("");
							proteinSupplimenetTextField.setEnabled(false);
						}
						if (selectedPlayer == ((Team) playerCastingHelper(playerName))) {
							proteinSuppliementStatDisplay.setText("protein suppliement taken this week: " +
									((Player) playerCastingHelper(playerName)).hasProteinSuppliement());
							displayStaAndOffAndDifUpdate(playerName);
						}
					}
				}
			}
		}
		
		
		if (e.getSource() == weeklyTrainingPassForGoalKeeperTextField) {
		    // Get the goal keeper name from the goalKeeperTextField
		    String goalKeeperName = goalKeeperTextField.getText();

		    // Check if the length of the string returned by inSquadWithUnknownPosition is greater than 0
		    boolean length = inSquadWithUnknownPosition(goalKeeperName).length() > 0;
		    
		    // Check if the goal keeper name is not "goal keeper" and the length condition is true
		    if (inSquadWithUnknownPosition(goalKeeperName) != "goal keeper" && length) {
		        goalkeeperPuchaseWarningJLabel.setText("Warning: not a goal keeper");
		    }
		    
		    // Check if the length of the goal keeper name is 0
		    if (goalKeeperName.length() == 0) {
		        goalkeeperPuchaseWarningJLabel.setText("Warning: no input");
		    }
		    
		    // Check if the result of inSquadWithUnknownPosition is an empty string
		    if (inSquadWithUnknownPosition(goalKeeperName) == "") {
		        goalkeeperPuchaseWarningJLabel.setText("Warning: not in squad");
		    } else {
		        // Check if the goal keeper is already in the squad as a goal keeper
		        if (InSquad(goalKeeperName, "goal keeper")) {
		            // Check if the goal keeper already has a weekly pass for goal keepers
		            if (((Player) playerCastingHelper(goalKeeperName)).hasWeeklyPassForGoalKeepers() == "yes") {
		                goalkeeperPuchaseWarningJLabel.setText("Warning: already applied");
		            } else {
		                // Set the weekly pass for goal keepers for the player
		                ((Player) playerCastingHelper(goalKeeperName)).setWeeklyPassForGoalKeepers(true);
		                ((Player) playerCastingHelper(goalKeeperName)).weeklyPassForGoalKeepers();
		                goalkeeperPuchaseWarningJLabel.setText("Warning: Confirmed");
		                goalKeeperPassesRemainingCounterJLabel.setText("number remaining: " + numberOfWeeklPassesForGoalkeeper);
		                if (numberOfWeeklPassesForGoalkeeper == 0) {
		                    goalKeeperTextField.setText("");
		                    goalKeeperTextField.setEnabled(false);
		                    weeklyTrainingPassForGoalKeeperTextField.setEnabled(false);
		                }
		                if (selectedPlayer == ((Team) playerCastingHelper(goalKeeperName))) {
		                    weeklyTrainingPassDisplay.setText("weekly training pass: " + ((Player) playerCastingHelper(goalKeeperName)).hasWeeklyPassForGoalKeepers());
		                    displayStaAndOffAndDifUpdate(goalKeeperName);
		                }
		            }
		        }
		    }
		}

		
		
		
		
		if (e.getSource() == defenderTrainingPassButton) {
		    // Get the defender name from the defenderTextField
		    String defenderName = defenderTextField.getText();
		    
		    // Check if the length of the string returned by inSquadWithUnknownPosition is greater than 0
		    boolean length = inSquadWithUnknownPosition(defenderName).length() > 0;
		    
		    // Check if the length condition is true and the defender is not a left defender or right defender
		    if (length && (inSquadWithUnknownPosition(defenderName) != "left defender" || inSquadWithUnknownPosition(defenderName) != "right defender")) {
		        defenderPurchaseWarningJLabel.setText("Warning: not a defender");
		    }
		    
		    // Check if the length of the defender name is 0
		    if (defenderName.length() == 0) {
		        defenderPurchaseWarningJLabel.setText("Warning: no input");
		    }
		    
		    // Check if the result of inSquadWithUnknownPosition is an empty string
		    if (inSquadWithUnknownPosition(defenderName) == "") {
		        defenderPurchaseWarningJLabel.setText("Warning: not in squad");
		    }
		    
		    // Check if the defender is already in the squad as a left defender
		    if (InSquad(defenderName, "left defender")) {
		        // Check if the defender already has a weekly pass for left defenders
		        if (((Player) playerCastingHelper(defenderName)).hasWeeklyPassForLeftDefender() == "yes") {
		            defenderPurchaseWarningJLabel.setText("Warning: already applied");
		        } else {
		            // Set the weekly pass for left defenders for the player
		            ((Player) playerCastingHelper(defenderName)).setWeeklyPassForLeftDefenders(true);
		            ((Player) playerCastingHelper(defenderName)).weeklyPassForLeftDefenders();
		            defenderPurchaseWarningJLabel.setText("Warning: Confirmed");
		            defenderPassRemainingCounter.setText("number remaining: " + numberOfWeeklyPassesForDefenders);
		            if (numberOfWeeklyPassesForDefenders == 0) {
		                defenderTrainingPassButton.setEnabled(false);
		                defenderTextField.setText("");
		                defenderTextField.setEnabled(false);
		            }
		            if (selectedPlayer == ((Team) playerCastingHelper(defenderName))) {
		                weeklyTrainingPassDisplay.setText("weekly training pass: " + ((Player) playerCastingHelper(defenderName)).hasWeeklyPassForLeftDefender());
		                displayStaAndOffAndDifUpdate(defenderName);
		            }
		        }
		    }
				
		    if (InSquad(defenderName, "right defender") == true) {
		        // Check if the defender already has a weekly pass for right defenders
		        if (((Player) playerCastingHelper(defenderName)).hasWeeklyPassForRightDefender() == "yes") {
		            defenderPurchaseWarningJLabel.setText("Warning: already applied");
		        } else {
		            // Set the weekly pass for right defenders for the player
		            ((Player) playerCastingHelper(defenderName)).setWeeklyPassForRightDefenders(true);
		            ((Player) playerCastingHelper(defenderName)).weeklyPassForRightDefenders();
		            defenderPurchaseWarningJLabel.setText("Warning: Confirmed");
		            defenderPassRemainingCounter.setText("number remaining: " + numberOfWeeklyPassesForDefenders);
		            if (numberOfWeeklyPassesForDefenders == 0) {
		                defenderTrainingPassButton.setEnabled(false);
		                defenderTextField.setText("");
		                defenderTextField.setEnabled(false);
		            }
		            if (selectedPlayer == ((Team) playerCastingHelper(defenderName))) {
		                weeklyTrainingPassDisplay.setText("weekly training pass: " + ((Player) playerCastingHelper(defenderName)).hasWeeklyPassForRightDefender());
		                displayStaAndOffAndDifUpdate(defenderName);
		            }
		        }
		    }	

		}
	 

		
		
		
		if (e.getSource() == strickerTrainingButton) {
		    String attackerName = strickerTextField.getText();
		    boolean length = inSquadWithUnknownPosition(attackerName).length() > 0;

		    // Check if the attacker is in the squad and if their position is attacker
		    if (length && (inSquadWithUnknownPosition(attackerName) != "attacker")) {
		        strickerPurchaseWarningJLabel.setText("Warning: not an attacker");
		    }

		    if (attackerName.length() == 0) {
		        strickerPurchaseWarningJLabel.setText("Warning: no input");
		    }

		    if (inSquadWithUnknownPosition(attackerName) == "") {
		        strickerPurchaseWarningJLabel.setText("Warning: not in squad");
		    } else {
		        if (InSquad(attackerName, "attacker") == true) {
		            // Check if the attacker already has a weekly pass for attackers
		            if (((Player) playerCastingHelper(attackerName)).hasWeeklyPassForAttacker() == "yes") {
		                strickerPurchaseWarningJLabel.setText("Warning: already applied");
		            } else {
		                // Set the weekly pass for attackers for the player
		                ((Player) playerCastingHelper(attackerName)).setWeeklyPassForAttacker(true);
		                ((Player) playerCastingHelper(attackerName)).weeklyPassForAttacker();
		                strickerPurchaseWarningJLabel.setText("Warning: Confirmed");
		                StrickerPassesRemainingCounterJLabel.setText("number remaining: " + numberOfWeeklyPassesForAttackers);

		                if (numberOfWeeklyPassesForAttackers == 0) {
		                    strickerTrainingButton.setEnabled(false);
		                    strickerTextField.setText("");
		                    strickerTextField.setEnabled(false);
		                }
		                if (selectedPlayer == ((Team) playerCastingHelper(attackerName))) {
		                    weeklyTrainingPassDisplay.setText("weekly training pass: " + ((Player) playerCastingHelper(attackerName)).hasWeeklyPassForAttacker());
		                    displayStaAndOffAndDifUpdate(attackerName);
		                }
		            }
		        }
		    }
		}

		
		
		String playing = reservePlayerNameTextField.getText();
		
		String reserve = enterPlayingAtheleteTextField.getText();
	
		if(e.getSource() == swapButton)
		{
			
			if (playing.length() == 0 && reserve.length() == 0)
			{
				warningForPlayingAtheleteSwap.setText("Warning: no name entered");
				jLabelForNonPlayingSwapWarning.setText("Warning: no name entered");
			}
			else
			{
				int countertwo = 0; 
				boolean playerFound = false; 
				// Search for the playing player
				for (Object players: playingFour)
				{
					
					if(playing.equals(((Player) players).getName()))
					{
					
						playerFound  = true;
						tempPlayingObject = (Team) players;
						
						break;
					}
					countertwo += 1;
				}
				if (playerFound == true) {
					warningForPlayingAtheleteSwap.setText("Warning: Confirmed");
				}
				if(countertwo == playingFour.length && playing.length() == 0)
				{
					warningForPlayingAtheleteSwap.setText("Warning: no name entered");
				}
				else if (countertwo == playingFour.length && playing.length() > 0)
				{
					warningForPlayingAtheleteSwap.setText("Warning: not playing");
				}
				
				
				
				int counterOne = 0; 
				boolean foundReserve = false;
				// Search for hte reserve player
				for (Object players1: reserves)
				{
				
					
					if (reserve.equals(((Player) players1).getName()))
					{
						foundReserve = true;
						tempObjectReserve = (Team) players1;		
						jLabelForNonPlayingSwapWarning.setVisible(false);
						jLabelForNonPlayingSwapWarning.setVisible(true);
						break;
					}
					counterOne += 1;
		
				}
				if (foundReserve == true)
				{
					jLabelForNonPlayingSwapWarning.setText("Warning: Confirmed");
				}
				if (counterOne == reserves.length && reserve.length() == 0)
				{
					jLabelForNonPlayingSwapWarning.setText("Warning: no name entered");
					
				}
				else if(counterOne == reserves.length && reserve.length() > 0)
				{
					jLabelForNonPlayingSwapWarning.setText("Warning: not a reserve");
				}
				
				// if a reserveis found and a player is found 
				// then they are swapped. 
				if(foundReserve == true && playerFound == true)
				{
				if (((Player) tempPlayingObject).getPosition() == ((Player) tempObjectReserve).getPosition())
				{
					// Swap the players' reserve status
					((Player) tempPlayingObject).setReserve(true);
					((Player) tempObjectReserve).setReserve(false);
					//Update the reserve status.
					if(((Team) tempPlayingObject).equals((Team) selectedPlayer)) {
						isRevserve.setText("reserve: Yes");
					}
					if(((Team) tempObjectReserve).equals((Team) selectedPlayer)) {
						isRevserve.setText("reserve: no");
					}
					
					// Update the reserves and playingFour arrays;
					reserves[counterOne] = tempPlayingObject;
					playingFour[countertwo]= (Team) tempObjectReserve;
					updateTheDisplayOfReserveAndReserveList();
		
				}
				if (((Player) tempPlayingObject).getPosition() != ((Player) tempObjectReserve).getPosition())
				{
				
					warningForPlayingAtheleteSwap.setText("Warning: "+((Player) tempPlayingObject).getPosition());
					jLabelForNonPlayingSwapWarning.setText("Warning: "+((Player) tempObjectReserve).getPosition());
				}
				}
				else if(foundReserve == true && playerFound == false){
					warningForPlayingAtheleteSwap.setText("Warning: not in squad");
					jLabelForNonPlayingSwapWarning.setText("Warning: confirmed");
				}
				else if(foundReserve == false&& playerFound == true) {
					warningForPlayingAtheleteSwap.setText("Warning: confirmed");
					jLabelForNonPlayingSwapWarning.setText("Warning: not in squad");
				}
			}

		}
		
		if (e.getSource() == backToGameMenu)
		{
		    // Hide the Club Room frame
		    ClubRoom.clubFrame.setVisible(false);
		    // Set the bounds of the Game Menu frame to match the Club Room frame
		    GameMenu.club.clubFrame.setBounds(GameMenu.club.clubFrame.getBounds());
		    GameMenu.frame.setBounds(ClubRoom.clubFrame.getBounds());
		    // Show the Game Menu frame
		    GameMenu.frame.setVisible(true);
		}

		if (e.getSource() == confirmNameChange)
		{
		    String str = nickNameChangeTextField.getText();
		    if (str.length() > 0)
		    {
		        // Set the nickname of the selected player to the entered value
		        ((Player) selectedPlayer).setnickName(str);
		        nickNameChangeTextField.setText("");
		        playerNickname.setText("player nickname: " + ((Player) selectedPlayer).getnickName() + " ");
		    }
		}

		if (e.getSource() == addPlayerToPlayingListButton)
		{
		    if (positionOpenInThePlayingList(selectedPlayer) == true)
		    {
		        // Increase the size of the playingFour array by 1
		        playingFour = new Object[playingFour.length + 1];
		        // Add the selected player to the last position in the playingFour array
		        playingFour[playingFour.length - 1] = selectedPlayer;
		        // Update the display of reserve players and the reserve players list
		        updateTheDisplayOfReserveAndReserveList();
		    }
		}

		if (e.getSource() == addPlayerToPlayingListButton)
		{
		    // Update the player squad
		    updatePlayerSquad();
		    // Add the selected player to the player list
		    addPlayerToPlayerList();
		}
	}
		
	
	
	/**
	 * Adds the selected player to the player list.
	 * 
	 *   the method checks if there is an open position in the playing list for the selected player.
	 *   If there is, it iterates over the player list and finds the player with the same name. 
	 *   It then sets the reserve status of that player to false, updates the player squad, 
	 *   and calls the updateTheDisplayOfReserveAndReserveList() method.
	 */
	public void addPlayerToPlayerList() {
	    if (positionOpenInThePlayingList(selectedPlayer) == true) {
	        for (Object player : SignUpShop.playerList.player) {
	            if (((Player) player).getName() == ((Player) selectedPlayer).getName()) {
	                ((Player) player).setReserve(false);
	                updatePlayerSquad();
	                updateTheDisplayOfReserveAndReserveList();
	                break;
	            }
	        }
	    }
	}

	/**
	 * Updates the display of reserve players and the reserve players list.
	 */
	public void updateTheDisplayOfReserveAndReserveList() {
	    fourPlayingPlayers.setVisible(false);
	    fourPlayingPlayers.setVisible(true);
	    reservePlayersList.setVisible(false);
	    reservePlayersList.setVisible(true);
	}

	/**
	 * Checks if a position is open in the playing list for the given player.
	 *
	 * @param playerName The player object to check the position for.
	 * @return True if the position is open, false otherwise.
	 */
	public static boolean positionOpenInThePlayingList(Object playerName) {
		boolean isOpen = false;
		int counter = 0;
		
		// Iterate through the playingFour list in the GameMenu.club
		for (Object player : GameMenu.club.playingFour) {
			// Check if the position of the current player is different from the position of the playerName
			if (((Player) player).getPosition() != ((Player) playerName).getPosition()) {
				counter += 1;
			}
		}
		
		// If the counter is equal to the length of the playingFour list, it means all positions are different
		if (counter == GameMenu.club.playingFour.length) {
			isOpen = true;
			counter = 0;
		}
		
		return isOpen;
	}

	/**
	 * Handles the value change event of the playerList.
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == playerList) {
			// Get the selected player from the playerList
			selectedPlayer = (Object) playerList.getSelectedValue();

			// Display player information
			playerNickname.setText("player nickname: " + ((Player) selectedPlayer).getnickName() + " ");
			staminaDisplay.setText("stamina: " + ((Player) selectedPlayer).stamina() + " ");
			offenseDisplay.setText("offense: " + ((Player) selectedPlayer).offense() + " ");
			defenseDisplay.setText("defense: " + ((Player) selectedPlayer).defence() + " ");
			position.setText("position: " + ((Player) selectedPlayer).getPosition() + " ");
			proteinSuppliementStatDisplay.setText("protein sup"
					+ "pliement taken this week: " + ((Player) selectedPlayer).hasProteinSuppliement());

			// Check the position of the selected player
			if (((Player) selectedPlayer).getPosition() == "goal keeper") {
				reflex.setVisible(true);
				reflex.setText("reflex: " + ((Player) selectedPlayer).goalKeeperReflex());
				weeklyTrainingPassDisplay.setText("weekly training pass: " + ((Player) selectedPlayer).hasWeeklyPassForGoalKeepers());
			} else {
				reflex.setText("reflex: ");
				if (((Player) selectedPlayer).getPosition() == "attacker") {
					weeklyTrainingPassDisplay.setText("weekly training pass: " + ((Player) selectedPlayer).hasWeeklyPassForAttacker());
				} else if (((Player) selectedPlayer).getPosition() == "left defender") {
					weeklyTrainingPassDisplay.setText("weekly training pass: " + ((Player) selectedPlayer).hasWeeklyPassForLeftDefender());
				} else if (((Player) selectedPlayer).getPosition() == "right defender") {
					weeklyTrainingPassDisplay.setText("weekly training pass: " + ((Player) selectedPlayer).hasWeeklyPassForRightDefender());
				}
			}

			// Display if the player is a reserve or not
			if (((Player) selectedPlayer).isReserve() == true) {
				isRevserve.setText("reserve: Yes ");
			} else {
				isRevserve.setText("reserve: No ");
			}
		}
	}
}