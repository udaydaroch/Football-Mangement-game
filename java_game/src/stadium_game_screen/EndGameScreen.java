package stadium_game_screen;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import game_main_menu.GameMenu;

/**
 * 
 * EndGameScreenClass sets up the GameEndScreen when the player either lose the game or finish the last 
 * week of their sesson.
 */
 public class EndGameScreen {
 
	 /**
	  * The main frame for displaying team information.
	  */
	 public JFrame frame;

	 /**
	  * Label for displaying the team name.
	  */
	 public static JLabel teamName;

	 /**
	  * Label for displaying the duration of the season.
	  */
	 public static JLabel seasonDuration;

	 /**
	  * Label for displaying the total money gained.
	  */
	 public static JLabel totalMoneyGained;

	 /**
	  * Label for displaying the current amount of money gained.
	  */
	 public static JLabel moneyGained;


    /**
     * Constructor used to call the intialize method that generators the frame and the content in it.
     */
    public EndGameScreen() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    public void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the team name label
        teamName = new JLabel("Team: " + GameMenu.team);
        teamName.setFont(new Font("Tahoma", Font.PLAIN, 30));

        // Initialize the season duration label
        seasonDuration = new JLabel("Season duration: " + GameMenu.durationConst);
        seasonDuration.setFont(new Font("Tahoma", Font.PLAIN, 18));

        // Initialize the total money gained label
        totalMoneyGained = new JLabel("Money gained: " + GameMenu.game.gameOutcomeScreen.totalMoneyGainedThroughMatches);
        totalMoneyGained.setFont(new Font("Tahoma", Font.PLAIN, 18));

        // Initialize the money gained label
        moneyGained = new JLabel("Points gained: " + GameMenu.game.TotalScore);
        moneyGained.setFont(new Font("Tahoma", Font.PLAIN, 18));

        // Set up the layout of the frame
        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                                .addContainerGap(133, Short.MAX_VALUE)
                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                                        .addComponent(moneyGained, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(seasonDuration, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(totalMoneyGained, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                        .addComponent(teamName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(45))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(49)
                                .addComponent(teamName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(seasonDuration, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(totalMoneyGained, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(moneyGained, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(72, Short.MAX_VALUE))
        );
        frame.getContentPane().setLayout(groupLayout);
    }

    /** Update the  teamname, seasonDuration, totalMoneyGained , moneyGained label.
     * 
     */
    public static void update_display_label() {
        teamName.setText("Team: " + GameMenu.team);
        seasonDuration.setText("Season duration: " + GameMenu.durationConst);
        totalMoneyGained.setText("Money gained: " + GameMenu.game.gameOutcomeScreen.totalMoneyGainedThroughMatches);
        moneyGained.setText("Points gained: " + GameMenu.game.TotalScore);
    }
}
