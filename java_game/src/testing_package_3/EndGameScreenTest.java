package testing_package_3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import game_main_menu.GameMenu;
import stadium_game_screen.EndGameScreen;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

/**
 * calss to test the EndGameScreen.
 * @author udayd
 *
 */
public class EndGameScreenTest {

	/**
	 * empty constructor
	 */
	public EndGameScreenTest() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * endGameScreen instance
	 */
    private EndGameScreen endGameScreen;

    /**
     *  setup before all the tests.
     */
    @Before
    public void setUp() {
        endGameScreen = new EndGameScreen();
        endGameScreen.initialize();
        endGameScreen.teamName = new JLabel();
        endGameScreen.seasonDuration = new JLabel();
        endGameScreen.totalMoneyGained = new JLabel();
        endGameScreen.moneyGained = new JLabel();
    }

    /**
     * test for UpdateDisplayLabel method.
     */
    @Test
    public void testUpdateDisplayLabel() {
        // Set up test data
        GameMenu.team = "Test Team";
        GameMenu.durationConst = 10;
        GameMenu.game.gameOutcomeScreen.totalMoneyGainedThroughMatches = 100;
        GameMenu.game.TotalScore = 50;
        

        // Call the update_display_label() method
        endGameScreen.update_display_label();

        // Verify the updated label text
        Assert.assertEquals("Team: Test Team", endGameScreen.teamName.getText());
        Assert.assertEquals("Season duration: 10", endGameScreen.seasonDuration.getText());
        Assert.assertEquals("Money gained: 100", endGameScreen.totalMoneyGained.getText());
        Assert.assertEquals("Points gained: 50", endGameScreen.moneyGained.getText());
    }

    
}