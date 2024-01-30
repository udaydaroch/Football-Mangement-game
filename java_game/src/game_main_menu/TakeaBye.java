package game_main_menu;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;

import foot.Player;
import foot.RandomEvents;
import foot.Team;
import game_start_and_login_page.SignUpShop;
import stadium_game_screen.TheGameScreen;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;

/**
 * TakeaBye class implements the resting week mechanics for the game.
 * which includes  
 * - updating player stamina.
 * - updating a players stat.
 * - triggering random events.
 * the class also uses ActionListener to detect button on click events(for all the back to menu button). 
 * and the ListSelectionListener to deteck the click of an item in the list(the team list).
 * @author udayd
 *
 */
public class TakeaBye implements ActionListener,ListSelectionListener {

	/**
	 * Represents the main frame of the application.
	 */
	public static JFrame frame;

	/**
	 * Button for choosing a player.
	 */
	private JButton chosePlayer;

	/**
	 * Button for navigating back to the menu.
	 */
	private JButton backToMenu;

	/**
	 * List for displaying the squad.
	 */
	private JList squadList;

	/**
	 * Represents the selected player.
	 */
	private Object selectedPlayer = new Player(0, 0, 0, "", "", false, false);

	/**
	 * Controller for random events.
	 */
	private RandomEvents randomEventController = new RandomEvents();

	/**
	 * Button for increasing the defense stat.
	 */
	private JButton defenceIncreaseButton;

	/**
	 * Button for increasing the offense stat.
	 */
	private JButton offenseIncreaseButton;

	/**
	 * Button for increasing the reflex stat.
	 */
	private JButton reflexIncreaseButton;

	/**
	 * Scroll pane for the whole squad.
	 */
	private JScrollPane wholeSquadJScollPane;

	/**
	 * Label for displaying the stat when 03.
	 */
	private JLabel statWhen03;

	/**
	 * Label for displaying the stat when 04.
	 */
	private JLabel statWhen04;

	/**
	 * Label for displaying the stat when 05.
	 */
	private JLabel statWhen05;

	/**
	 * Label for displaying the stat when 06.
	 */
	private JLabel statWhen06;

	/**
	 * Label for displaying the stat when 07.
	 */
	private JLabel statWhen07;

	/**
	 * Label for displaying the stat when 08.
	 */
	private JLabel statWhen08;

	/**
	 * Label for displaying the stat when 09.
	 */
	private JLabel statWhen09;

	/**
	 * Label for displaying the current desired stat.
	 */
	private JLabel currentDesiredStat;

	/**
	 * Label for displaying the updated stat.
	 */
	private JLabel updatedStatLabel;

	/**
	 * Warning label for the optional player enhancement feature.
	 */
	private JLabel optionaPlayerEnhencementFeatureWarning;

	/**
	 * Warning label for the optional player enhancement feature.
	 */
	private JLabel optionaPlayerEnhencementFeatureWarning1;

	/**
	 * Warning label for the optional player enhancement feature.
	 */
	private JLabel optionaPlayerEnhencementFeatureWarning2;

	/**
	 * Label for displaying the cost of enhancing the player step.
	 */
	private JLabel costOfEnhancingThePlayerStep;

	/**
	 * Warning label for the selected player button.
	 */
	private JLabel warningFOrSelectedPlayerButton;

	/**
	 * 
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public TakeaBye(){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 897, 355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		wholeSquadJScollPane = new JScrollPane();
		
		JPanel boxForPlayerButton = new JPanel();
		
		backToMenu = new JButton("< menu");
		backToMenu.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		
		currentDesiredStat = new JLabel("current : ");
		
		updatedStatLabel = new JLabel("updated :");
		
		optionaPlayerEnhencementFeatureWarning = new JLabel("If you wish to enchance the player stat (which is used in the game) please select a player from the ");
		
		optionaPlayerEnhencementFeatureWarning1 = new JLabel(" list below and press the select player button ");
		
		optionaPlayerEnhencementFeatureWarning2 = new JLabel("Warning: onces the select player button has been clicked it can't be undone");
		
		costOfEnhancingThePlayerStep = new JLabel("Cost: ");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(backToMenu))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(optionaPlayerEnhencementFeatureWarning, GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
						.addComponent(optionaPlayerEnhencementFeatureWarning1, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
						.addComponent(updatedStatLabel, GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(currentDesiredStat, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
							.addGap(42)
							.addComponent(costOfEnhancingThePlayerStep, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(optionaPlayerEnhencementFeatureWarning2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(boxForPlayerButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
							.addComponent(wholeSquadJScollPane, Alignment.LEADING)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(backToMenu)
						.addComponent(optionaPlayerEnhencementFeatureWarning))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(optionaPlayerEnhencementFeatureWarning1)
							.addGap(17)
							.addComponent(optionaPlayerEnhencementFeatureWarning2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(wholeSquadJScollPane, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(currentDesiredStat)
								.addComponent(costOfEnhancingThePlayerStep))
							.addGap(10)
							.addComponent(boxForPlayerButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(updatedStatLabel))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JLabel statWhen0 = new JLabel("if stat = 0");
		
		JLabel statWhen01 = new JLabel("increase of 40 in stat and cost of 200");
		
		JLabel statWhen02 = new JLabel("if current stat between 10 and 50(50 inclusive)");
		
		statWhen03 = new JLabel("increase of 30 in stat and cost of 160");
		
		statWhen04 = new JLabel("if current stat between 50 and 80(80 inclusive)");
		
		statWhen05 = new JLabel("increase of 20 in stat and cost of 120");
		
		statWhen06 = new JLabel("if current stat between 80 and 90(90 inclusive)");
		
		statWhen07 = new JLabel("increase of 10 in satt and cost of 80");
		
		statWhen08 = new JLabel("if current stat between 90 and 95(95 inclusive)");
		
		statWhen09 = new JLabel("increase of 5 in stat and cost of 40");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(statWhen02, GroupLayout.PREFERRED_SIZE, 346, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(statWhen08, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(76, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(statWhen07, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(statWhen05, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(statWhen03, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(statWhen06, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(statWhen04, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(statWhen09, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(120, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(statWhen01, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(127, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(statWhen0, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(statWhen0)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(statWhen01)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(statWhen02)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(statWhen03, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(statWhen04)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(statWhen05)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(statWhen06)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(statWhen07)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(statWhen08)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(statWhen09)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		boxForPlayerButton.setLayout(null);
		
		chosePlayer = new JButton("Select Player");
		chosePlayer.setEnabled(false);
		chosePlayer.addActionListener(this);
		chosePlayer.setBounds(183, 10, 120, 21);
		boxForPlayerButton.add(chosePlayer);
		

		
		defenceIncreaseButton = new JButton("Stamima");
		defenceIncreaseButton.addActionListener(this);
		defenceIncreaseButton.setBounds(26, 60, 106, 21);
		boxForPlayerButton.add(defenceIncreaseButton);
		
		offenseIncreaseButton = new JButton("Offence");
		offenseIncreaseButton.addActionListener(this);
		offenseIncreaseButton.setBounds(183, 60, 120, 21);
		boxForPlayerButton.add(offenseIncreaseButton);
	
		reflexIncreaseButton = new JButton("Reflex");
		reflexIncreaseButton.addActionListener(this);
		reflexIncreaseButton.setBounds(373, 60, 95, 21);
		
		offenseIncreaseButton .setEnabled(false);
		defenceIncreaseButton.setEnabled(false);
		reflexIncreaseButton.setEnabled(false);
		
		boxForPlayerButton.add(reflexIncreaseButton);
		
		warningFOrSelectedPlayerButton = new JLabel("Warning : ");
		warningFOrSelectedPlayerButton.setBounds(183, 39, 152, 11);
		boxForPlayerButton.add(warningFOrSelectedPlayerButton);
		
		squadList = new JList<Object>(ClubRoom.totalPlayers);
		squadList.addListSelectionListener(this);
		wholeSquadJScollPane.setViewportView(squadList);
		frame.getContentPane().setLayout(groupLayout);
	}
	/**
	 * updateAllPlayerStamina updates the stamina for all the players in the squad. 
	 */
	public void updateAllPlayerStamina()
	{
		GameMenu.club.updatePlayerSquad();
		
		GameMenu.noticeCollecter.add("All player stamina has been updated");
		for(int i = 0; i < 4; i++ )
		{
			((Player) ClubRoom.totalPlayers[i]).setStamina(100);
		}
		
		GameMenu.club.updatePlayerSquad();
		squadList = new JList<Object>(ClubRoom.totalPlayers);
		squadList.addListSelectionListener(this);
		wholeSquadJScollPane.setViewportView(squadList);
		
	}
	/**
	 * the function updates a particular stat of the player.
	 * the stat that is updated depends on the player and the speciality of the player.
	 * ie for a goalkeeper on the reflex stat is improved because that is the only stat used in the match 
	 * that gets compared against the reflex of the opponent player.
	 * 
	 * @param selectedPlayer the player the player has selected from the list of players provided in frame.
	 */
	public void updatePlayerSelectedStat(Object selectedPlayer )
	{
		
		GameMenu.club.updatePlayerSquad();
		for (int i = 0; i < ClubRoom.totalPlayers.length; i++)
		{
			if(((Player) ClubRoom.totalPlayers[i]).getName() == ((Player) selectedPlayer).getName())
			{
				GameMenu.noticeCollecter.add(((Player) ClubRoom.totalPlayers[i]).getName() + "'s stat was improved during the bye week");
				if (((Player) ClubRoom.totalPlayers[i]).getPosition() == "goal keeper")
				{
					int currentReflex = ((Player) ClubRoom.totalPlayers[i]).goalKeeperReflex();
					((Player) ClubRoom.totalPlayers[i]).setPlayerreflex(currentReflex + amountToAddToPlayerStat(currentReflex).get(0));
					 
				}
				if (((Player) ClubRoom.totalPlayers[i]).getPosition() == "left defender" || ((Player) ClubRoom.totalPlayers[i]).getPosition() == "right defender")
				{
					int currentDefence = ((Player) ClubRoom.totalPlayers[i]).defence();
					((Player) ClubRoom.totalPlayers[i]).setDefence(currentDefence + amountToAddToPlayerStat(currentDefence).get(0));
					
				}
				if (((Player) ClubRoom.totalPlayers[i]).getPosition() == "attacker")
				{
					int currentOffense = ((Player) ClubRoom.totalPlayers[i]).offense();
					((Player) ClubRoom.totalPlayers[i]).setOffense(currentOffense + amountToAddToPlayerStat(currentOffense).get(0));
					
				}
			}
		}
		GameMenu.club.updatePlayerSquad();
	}
	/**
	 * this function take the current stat of a randomly chosen player
	 * and calculates the cost and amount the variable can be incremented 
	 * depending on current stat. 
	 * @param currentStat is the current stat of the player.
	 * @return an ArrayList/tuple of the cost and stat increase value.
	 */
	public List<Integer> amountToAddToPlayerStat(int currentStat)
	{
		List<Integer> additionValueAndAmounts = new ArrayList();
		
		if(currentStat == 0)
		{
			additionValueAndAmounts.add(40);
			additionValueAndAmounts.add(200);
			
		}
		if(currentStat > 0 &&currentStat < 50 && currentStat >= 10)
		{
			additionValueAndAmounts.add(30);
			additionValueAndAmounts.add(160);
			
		}
		if(currentStat < 80 && currentStat >= 50)
		{
			additionValueAndAmounts.add(20);
			additionValueAndAmounts.add(120);
			
		}
		if(currentStat < 90 && currentStat >= 80)
		{
			additionValueAndAmounts.add(10);
			additionValueAndAmounts.add(80);
			
		}
		if(currentStat < 95 && currentStat >= 90)
		{
			additionValueAndAmounts.add(5);
			additionValueAndAmounts.add(40);
			
		}
		return additionValueAndAmounts;
	}
	@Override

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backToMenu)
		{
			randomEventController.triggerRandomEventOfPlayerBeingAdded();
			randomEventController.triggerRandomEventOfPlayerBeingRemoved();
			randomEventController.triggerRandomEventOfPlayerStatIncreasing();
			GameMenu.noticeDisplayer();
			
			int current_match_history_count = TheGameScreen.matchHistoryCounter;
			Stadium.weekList[TheGameScreen.matchHistoryCounter] = "Week "+(current_match_history_count+1)+" : " +"a bye was taken";
			TheGameScreen.matchHistoryCounter+= 1;
			GameMenu.takingBye.frame.setVisible(false);
			GameMenu.club.updatePlayerSquad();
			GameMenu.frame.setVisible(true);
			GameMenu.duration -=1;
			GameMenu.currentWeek += 1;
			GameMenu.currentWeekDisplay.setText("Current week: "+GameMenu.currentWeek);
			GameMenu.weekRemainingDisplay.setText("Week remaining: "+GameMenu.duration);
			GameMenu.gameMenuMoneyInAccount.setText("Money in account: "+GameMenu.money);
			GameMenu.takeABye.setEnabled(false);
			GameMenu.market.updateItemPrices();
			GameMenu.market.buttonActivationStatus();
			GameMenu.market.totalPurchaseDisplayUpdate();
			GameMenu.stadium.updateMarket();
		}
		if(e.getSource() == reflexIncreaseButton)
		{
			updatePlayerSelectedStat( selectedPlayer);
			updatedStatLabel.setText("updated "+desiredStat(selectedPlayer));
			reflexIncreaseButton.setEnabled(false);
			backToMenu.setEnabled(true);
		}
		if(e.getSource() == offenseIncreaseButton)
		{
			updatePlayerSelectedStat( selectedPlayer);
			updatedStatLabel.setText("updated "+desiredStat(selectedPlayer));
			offenseIncreaseButton.setEnabled(false);
			backToMenu.setEnabled(true);
		}
		if(e.getSource() == defenceIncreaseButton)
		{
			updatePlayerSelectedStat( selectedPlayer);
			updatedStatLabel.setText("updated "+desiredStat(selectedPlayer));
			defenceIncreaseButton.setEnabled(false);
			backToMenu.setEnabled(true);
		}
		
		
		if(e.getSource() == chosePlayer)
		{
			if(purchasablity(amountToAddToPlayerStat(desiredStatIntegerVal( selectedPlayer)).get(1)) == true)
			{
			GameMenu.money -= amountToAddToPlayerStat(desiredStatIntegerVal( selectedPlayer)).get(1);
			backToMenu.setEnabled(false);
			if(((Player) selectedPlayer).getPosition() == "goal keeper")
			{
				reflexIncreaseButton.setEnabled(true);
				defenceIncreaseButton.setEnabled(false);
				offenseIncreaseButton .setEnabled(false);
			}
			if(((Player) selectedPlayer).getPosition() == "left defender" || ((Player) selectedPlayer).getPosition() == "right defender")
			{
			 	offenseIncreaseButton .setEnabled(false);
				defenceIncreaseButton.setEnabled(true);
				reflexIncreaseButton.setEnabled(false);
			}
			if(((Player) selectedPlayer).getPosition() == "attacker")
			{ 
				offenseIncreaseButton .setEnabled(true);
				defenceIncreaseButton.setEnabled(false);
				reflexIncreaseButton.setEnabled(false);
			}
			squadList.setEnabled(false);
			chosePlayer.setEnabled(false);
			}
			else {
				warningFOrSelectedPlayerButton.setText("Warning: out of Money");
			}
		}
		
	}

	/**
	 * checked the purchasiabiltiy of the item by comparing it directly to the 
	 * amount of money the player already has. 
	 * @param amountTakeOff the amount that will be taken from the account after purchasing a particular item/ player from the shop.
	 * @return true or false edpending on whether the money in account stays in the positives.
	 */
	public Boolean purchasablity(int amountTakeOff)
	{
		if(GameMenu.money - amountTakeOff < 0 )
		{
			return false;
		}
		return true;
	}
	/**
	 *  the desiredStat method only takes in consideration the stat of the player that is used for the player
	 *  to compare it with the oppponent player in the match.
	 *  ie for a goalkeeper only the reflex stat is improved.
	 *  ie for a left and right defender onl the defence stat is improved. 
	 *  
	 * @param selectedPlayer Object that is selected to be improved by the desiredStat function.  
	 * @return returns a string object that displays the stat of the player. 
	 */
	public String desiredStat(Object selectedPlayer)
	{
		String statNameAndValue = "";
		if (((Player) selectedPlayer).getPosition() == "goal keeper")
		{
			statNameAndValue = "reflex:" + " "+ ((Player) selectedPlayer).goalKeeperReflex();
		}
		if (((Player) selectedPlayer).getPosition() == "left defender" || ((Player) selectedPlayer).getPosition() == "right defender")
		{
			statNameAndValue = "defence:" + " "+ ((Player) selectedPlayer).defence();
		}
		if (((Player) selectedPlayer).getPosition() == "attacker")
		{
			statNameAndValue = "offense:" + " "+ ((Player) selectedPlayer).offense();
		}
		return statNameAndValue;
	}
	/**
	 * calcualtes the desired stat value for the selectedplayer(similar to the function above)
	* @param selectedPlayer Object that is selected to be improved by the desiredStat function.  
	 * @return returns an integer/the value of the stat of the player. 
	 */
	public int desiredStatIntegerVal(Object selectedPlayer) 
	{
		int value = 0;
		if (((Player) selectedPlayer).getPosition() == "goal keeper")
		{
			value= ((Player) selectedPlayer).goalKeeperReflex();
		}
		if (((Player) selectedPlayer).getPosition() == "left defender" || ((Player) selectedPlayer).getPosition() == "right defender")
		{
			value=((Player) selectedPlayer).defence();
		}
		if (((Player) selectedPlayer).getPosition() == "attacker")
		{
			value=((Player) selectedPlayer).offense();
		}
		return value;
	} 

	/**
	 * valueChanged is a method provided by the interface that enables the player to select players from the 
	 * list provided in the take a bye screen to improve. 
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == squadList)
		{
			GameMenu.club.updatePlayerSquad();
			selectedPlayer = (Object)squadList.getSelectedValue();
			currentDesiredStat.setText("current " + desiredStat(selectedPlayer));
			costOfEnhancingThePlayerStep.setText("cost :"+amountToAddToPlayerStat(desiredStatIntegerVal( selectedPlayer)).get(1));
			chosePlayer.setEnabled(true);
		}
		
	}
}
