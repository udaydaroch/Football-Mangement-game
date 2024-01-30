package game_start_and_login_page;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

/**
 * class used to create the LoginPage(the main start page of the page).
 * the class also makes use of the ActionListner and ChangeListener to detect button clicks and 
 * slider value changes.
 * @author  Jack Kuruvilla
 */
public class LoginPage implements ActionListener,ChangeListener{
	
	/**
	 * Represents the main frame of the application.
	 * 
	 */
	public static JFrame frame;

	/**
	 * Text field for entering a the team anme.
	 */
	public static JTextField namefield;

	/**
	 * Indicates whether the team name has been confirmed.
	 */
	public boolean teamNameConfirmed = false;

	/**
	 * Indicates whether the season length has been confirmed.
	 */
	public boolean seasonLengthConfirm = false;

	/**
	 * Indicates whether the difficulty level has been chosen.
	 */
	public boolean difficultyLevelChosenConfirm = false;

	/**
	 * Indicates whether a player has been bought.
	 */
	private boolean playerBought;

	/**
	 * Warning label for the signup shop.
	 */
	public JLabel singupShopWarning;

	/**
	 * Label for displaying a teamName
	 */
	public JLabel labelName;

	/**
	 * Label for displaying the season length.
	 */
	public JLabel seasonLength;

	/**
	 * Label for displaying the chosen difficulty level.
	 */
	public JLabel diffcultyLevelChosen;

	/**
	 * Button for starting the season(not used).
	 */
	public JButton startSeasonButton;

	/**
	 * Slider for selecting the season length.
	 */
	public static JSlider sliderForSeasonLength;

	/**
	 * Slider for selecting the difficulty level.
	 */
	public static JSlider sliderForDifficulty;

	/**
	 * Button for purchasing a squad(Shop button).
	 */
	public JButton purchaseSquadButton;

	/**
	 * Button for confirming the team name(not used).
	 */
	public JButton confirmTeamName;

	/**
	 * Button for selecting the season length.
	 */
	public JButton SeasonLengthButton;

	/**
	 * Button for selecting the difficulty level.
	 */
	public JButton DifficultyButton;

	/**
	 * Represents the LoginPage window.
	 */
	public static LoginPage window;

	/**
	 * Represents the game main menu.
	 */
	public static game_main_menu.GameMenu gameMenu;

	/**
	 * Represents the signup shop window.
	 */
	public static SignUpShop shopWindow;

	/**
	 * Launch the application.
	 * @param args no argument was passed to the main method.
	 */
	public static void main(String[] args) {
		shopWindow = new SignUpShop();
		window = new LoginPage();
		SignUpShop.player();
		SignUpShop.setPlayerStat();
		window.frame.setVisible(true);
		window.frame.setLocationRelativeTo(null);
				
	}

	/**
	 * uses the default construct to generate the create the application 
	 */
	public LoginPage() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	
		
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setResizable(true);
		frame.setBounds(100, 100, 1384, 770);
		frame.setMinimumSize(new Dimension(1384,800));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel footLeagueSignupTitle = new JLabel("Football League Signup");
		footLeagueSignupTitle.setFont(new Font("Tahoma", Font.PLAIN, 29));
		footLeagueSignupTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		confirmTeamName = new JButton("Team name");
		confirmTeamName.setEnabled(false);
		confirmTeamName.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		namefield = new JTextField();
		namefield.setColumns(10);
		
		sliderForSeasonLength = new JSlider(5,15,10);
		sliderForSeasonLength.setPaintTicks(true);
		sliderForSeasonLength.setMinorTickSpacing(2);
		sliderForSeasonLength.setPaintTrack(true);
		sliderForSeasonLength.setMajorTickSpacing(1);
		sliderForSeasonLength.setPaintLabels(true);
		sliderForSeasonLength.addChangeListener(this);
		SeasonLengthButton = new JButton("Season length");
		SeasonLengthButton.setEnabled(false);
		SeasonLengthButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		seasonLength = new JLabel("season length: 10");
		seasonLength.setFont(new Font("Tahoma", Font.PLAIN, 14));
		seasonLength.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel nameInstructionLabel = new JLabel("The team name must contain between 3 and 15 character(s) and must not include special character(s)  ie. #,  !, $, etc.");
		nameInstructionLabel.setHorizontalAlignment(SwingConstants.CENTER);

		sliderForDifficulty = new JSlider(1,3,2);
		sliderForDifficulty.setPaintTicks(true);
		sliderForDifficulty.setMinorTickSpacing(2);
		sliderForDifficulty.setPaintTrack(true);
		sliderForDifficulty.setMajorTickSpacing(1);
		sliderForDifficulty.setPaintLabels(true);
		sliderForDifficulty.addChangeListener(this);
		DifficultyButton = new JButton("Difficulty");
		DifficultyButton.setEnabled(false);
		DifficultyButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		diffcultyLevelChosen = new JLabel("Diffculty level: 2");
		diffcultyLevelChosen.setHorizontalAlignment(SwingConstants.CENTER);
		diffcultyLevelChosen.setFont(new Font("Tahoma", Font.PLAIN, 14));

		
		
	
		
		
		
		purchaseSquadButton = new JButton("Shop  ");
		purchaseSquadButton.addActionListener(this);
	
		purchaseSquadButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		JLabel labelForDuration = new JLabel("How many weeks would you like the season to last ");
		labelForDuration.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel labelForDifficulty = new JLabel("The difficulty can range from 1 to 3 ( 1 being the easiest and 3 being the hardest)");
		labelForDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
		
		startSeasonButton = new JButton("Start your Season  ");
		startSeasonButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		startSeasonButton.addActionListener(this);
		
		labelName = new JLabel("");
		labelName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelName.setHorizontalAlignment(SwingConstants.CENTER);
		labelName.setForeground(Color.RED);
		
		singupShopWarning = new JLabel("Must buy at least 4 reserve and must buy 4 playing team players!");
		singupShopWarning.setFont(new Font("Tahoma", Font.PLAIN, 12));
		singupShopWarning.setHorizontalAlignment(SwingConstants.CENTER);
	
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(DifficultyButton, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
								.addComponent(seasonLength, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
								.addComponent(confirmTeamName, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
								.addComponent(SeasonLengthButton, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
								.addComponent(labelName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE))
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(diffcultyLevelChosen, GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(2)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(labelForDuration, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(labelForDifficulty, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
									.addGap(19))
								.addComponent(sliderForDifficulty, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE))
							.addGap(28))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(sliderForSeasonLength, GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
							.addGap(39))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(nameInstructionLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
								.addComponent(namefield, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE))
							.addGap(40)))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(266)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(singupShopWarning, GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
						.addComponent(startSeasonButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
						.addComponent(purchaseSquadButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE))
					.addGap(315))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(498)
					.addComponent(footLeagueSignupTitle, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(498, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(footLeagueSignupTitle, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(confirmTeamName)
						.addComponent(namefield, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(labelName)
						.addComponent(nameInstructionLabel))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(SeasonLengthButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(seasonLength))
						.addComponent(sliderForSeasonLength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(labelForDuration)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(sliderForDifficulty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(labelForDifficulty))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(DifficultyButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(diffcultyLevelChosen, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
					.addGap(22)
					.addComponent(purchaseSquadButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(singupShopWarning)
					.addGap(26)
					.addComponent(startSeasonButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(321, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	/**
	 * method used to check the existence of special Character in the team name.
	 * (its a helper method that is used later in the actionPerformed below).
	 * @param str Retrieves a Team name string.
	 * @return a boolean that confirmed whether the Team name contains specical character.
	 */
	public boolean specialChardetector(String str)
	{
		Pattern specialChar = Pattern.compile("[!@#$%&*();:_+=|<>?{}\\\\[\\\\]~-]");
	    Matcher hasSpecialChar = specialChar.matcher(str);
	    return hasSpecialChar.find(); 
		
	}
	@Override
	
	
	public void actionPerformed(ActionEvent e) {
		singupShopWarning.setForeground(Color.RED);
		String str = namefield.getText();
		str = str.replaceAll("\\s","");
		
		if (e.getSource() == startSeasonButton)
		{
			if (str.length() >= 3 && str.length() <= 15 && specialChardetector(str) == false)
			{
				labelName.setText("");
			}
			if(SignUpShop.playerList.player.size() < 4)
			{
				singupShopWarning.setText("must buy 4 playing team players ( and the reserve players are optional to buy)!");
			}
		}
		if (str.length() >= 3 && str.length() <= 15) 
		{
			if (e.getSource() == startSeasonButton)
			{
				if(specialChardetector(str) == true)
					{
						labelName.setText("Please read the requirements!");
					}
				if(specialChardetector(str) == false && SignUpShop.playerList.player.size() >= 4)
				{
			
					gameMenu = new game_main_menu.GameMenu(str ,sliderForSeasonLength.getValue(),sliderForDifficulty.getValue());
					window.frame.setVisible(false);
					teamNameConfirmed = true;
					labelName.setText("");	
				}
			}
		}
		else if(str.length() < 3 || str.length() > 15)
		{
			labelName.setText("Please read the requirements and enter a team name accordingly!");
		}
		
		if(e.getSource() == purchaseSquadButton)
		{
			shopWindow.frame.setVisible(true);
			labelName.setText("");
			shopWindow.frame.setBounds(window.frame.getBounds());
			shopWindow.frame.setLocationRelativeTo(null);
			window.frame.setVisible(false);
			singupShopWarning.setText(" ");
		}	 
	}

	@Override
	public void stateChanged(ChangeEvent e) {
	    
		if(e.getSource() == sliderForSeasonLength)
		{	
			seasonLength.setText("season length: "+sliderForSeasonLength.getValue());
		}
		if(e.getSource() == sliderForDifficulty)
		{	
			diffcultyLevelChosen.setText("Difficulty level: " + sliderForDifficulty.getValue());
			SignUpShop.player();
			SignUpShop.setPlayerStat();
			
		}	
	}
}
