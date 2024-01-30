package testing_package_2;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import foot.Player;
import game_start_and_login_page.LoginPage;
import game_start_and_login_page.SignUpShop;
import foot.Player;

/**
 * LoginPageTest class to test LoginPage class
 * @author udayd
 *
 */
class LoginPageTest {
	/**
	 * constructor 
	 */
	LoginPageTest()
	{
		
	}
	/**
	 * LoginPage instance;
	 */
	private LoginPage loginPage;

	/**
	 * setUp before each test
	 */
    @BeforeEach
    public void setUp() {
        loginPage = new LoginPage();
    }

    /**
     * test for InnerIfStatement
     */
    @Test
    public void testInnerIfStatement() {
        
        LoginPage window = new LoginPage();
        
       
        window.namefield.setText("MyTeam");
        window.specialChardetector("MyTeam");
        SignUpShop.playerList.player.clear();
        SignUpShop.playerList.player.add(new Player(0, 0, 0, 0, null, null, false, false));
        SignUpShop.playerList.player.add(new Player(0, 0, 0, 0, null, null, false, false));
        SignUpShop.playerList.player.add(new Player(0, 0, 0, 0, null, null, false, false));
        SignUpShop.playerList.player.add(new Player(0, 0, 0, 0, null, null, false, false));
        
       
        ActionEvent event = new ActionEvent(window.startSeasonButton, ActionEvent.ACTION_PERFORMED, null);
        window.actionPerformed(event);
        
        // Verify that the inner if statement is run and the conditions are met
        assertTrue(window.teamNameConfirmed);
        assertEquals("", window.labelName.getText());
    }
    
    /**
     * test for SpecialDetector() method.
     */
    @Test
    public void testSpecialDetector() {
 
        String strWithSpecialChars = "Hello!";
        boolean result1 = loginPage.specialChardetector(strWithSpecialChars);
        assertTrue(result1);
        
        String strPasses = "Helloasfwefwaeqweqw";
        boolean result4 = loginPage.specialChardetector(strWithSpecialChars);
        assertTrue(result4);

        // Test a string without special characters
        String strWithoutSpecialChars = "Hell1232414123412";
        boolean result2 = loginPage.specialChardetector(strWithoutSpecialChars);
        assertFalse(result2);
   
        
        String stChars = "!!@E!@";
        boolean strCha = loginPage.specialChardetector(stChars);
        assertTrue(strCha);

        // Test an empty string
        String emptyString = "";
        boolean result3 = loginPage.specialChardetector(emptyString);
        assertFalse(result3);
    	
    }

    /**
     * test for ActionPerformedmethod().
     */
    @Test
    public void testActionPerformed() {
        
        loginPage.namefield.setText("MyTeam");
        loginPage.startSeasonButton.doClick();
  
        assertFalse(loginPage.teamNameConfirmed);
 
        assertEquals("", loginPage.labelName.getText());
      
        loginPage.namefield.setText("Abc$");
        loginPage.startSeasonButton.doClick();
        
        
        
        assertFalse(loginPage.teamNameConfirmed);
      
        assertEquals("Please read the requirements!", loginPage.labelName.getText());
       
        loginPage.purchaseSquadButton.doClick();
        
      
     
        assertEquals("", loginPage.labelName.getText());
    }

    /**
     * test  for StateChanged() method.
     * 
     */
    @Test
    public void testStateChanged() {
        
    	loginPage.sliderForDifficulty.setValue(1);
    	
    	assertEquals("Difficulty level: 1", loginPage.diffcultyLevelChosen.getText());
        
    	loginPage.sliderForSeasonLength.setValue(8);
        
        assertEquals("season length: 8", loginPage.seasonLength.getText());

       
    }
    /**
     * test for ActionPerformedStartYourSeasonButtonInsufficientPlayers() method.
     */
    @Test
    void testActionPerformedStartYourSeasonButtonInsufficientPlayers() {
        
        loginPage.namefield.setText("MyTeam");
        SignUpShop.playerList.player.clear(); // Empty player list

        // Add only 3 playing team players (less than the required 4)
        SignUpShop.playerList.player.add(new Player(0, 0, 0, 0, "Player 1", null, true, false));
        SignUpShop.playerList.player.add(new Player(0, 0, 0, 0, "Player 2", null, true, false));
        SignUpShop.playerList.player.add(new Player(0, 0, 0, 0, "Player 3", null, true, false));

       
        loginPage.namefield.setText("ValidTeamName");
        loginPage.startSeasonButton.doClick();

       
        assertFalse(loginPage.teamNameConfirmed);
       
    }

    /**
     * test for ActionPerformedStartYourSeasonButtonInvalidTeamName() method.
     */
    @Test
    public void testActionPerformed_StartYourSeasonButtonInvalidTeamName() {
        
        loginPage.namefield.setText("#InvalidName"); // Team name contains special characters
 
        loginPage.startSeasonButton.doClick();

       
        assertFalse(loginPage.teamNameConfirmed);
        assertNotEquals("", loginPage.labelName.getText());
       
    }
    /**
     * test for ActionPerformedStartYourSeasonButtonInvalidTeamNameLength() method.
     */

    @Test
    public void testActionPerformedStartYourSeasonButtonInvalidTeamNameLength() {
        
        LoginPage.namefield.setText("A"); // Team name has less than 3 characters

        
        loginPage.startSeasonButton.doClick();

        
        assertFalse(loginPage.teamNameConfirmed);
        assertNotEquals("", loginPage.labelName.getText());

        
        loginPage.namefield.setText("ANameThatIsTooLong"); // Team name has more than 15 characters

        
        loginPage.startSeasonButton.doClick();

        
        assertFalse(loginPage.teamNameConfirmed);
        assertNotEquals("", loginPage.labelName.getText());
    }
    /**
     * test for ActionPerformedPurchaseYourTeamButton() method.
     */

    @Test
    public void testActionPerformedPurchaseYourTeamButton() {
        
        loginPage.purchaseSquadButton.doClick();

        
        assertTrue(SignUpShop.frame.isVisible());
        assertEquals("", loginPage.labelName.getText());
        assertFalse(loginPage.frame.isVisible());
    }
    /**
     * test for InvalidTeamNameTooShort() method.
     */
    @Test
    public void testInvalidTeamNameTooShort() {
       
        loginPage.namefield.setText("A");
        loginPage.startSeasonButton.doClick();

        
        assertFalse(loginPage.teamNameConfirmed);
        assertEquals("Please read the requirements and enter a team name accordingly!", loginPage.labelName.getText());
    }

    /**
     * test for testInvalidTeamNameTooLong() method.
     */
    @Test
    public void testInvalidTeamNameTooLong() {
        
        loginPage.namefield.setText("VeryLongTeamNameWithMoreThan15Characters");
        loginPage.startSeasonButton.doClick();

    
        assertFalse(loginPage.teamNameConfirmed);
        assertEquals("Please read the requirements and enter a team name accordingly!", loginPage.labelName.getText());
    }

    /**
     * test for InvalidTeamNameContainsSpecialCharacters() method.
     */
    @Test
    public void testInvalidTeamNameContainsSpecialCharacters() {
        
        loginPage.namefield.setText("TeamName#");
        loginPage.startSeasonButton.doClick();

        assertFalse(loginPage.teamNameConfirmed);
        assertEquals("Please read the requirements!", loginPage.labelName.getText());
    }

 


}
