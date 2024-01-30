package testing_package_2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game_start_and_login_page.LoginPage;
import game_start_and_login_page.SignUpShop;

import static org.junit.jupiter.api.Assertions.*;
import foot.Player;
/**
 * SignupShopTest class for SignUpShop
 * @author udayd
 *
 */
class SignupShopTest {

	/**
	 * constructor
	 */
	public SignupShopTest() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * SignUpShop object intialization
	 */
	private SignUpShop signupShop;
	/**
	 * LoginPage object initialization
	 */
	private LoginPage loginPage;
	
	
	
	/**
	 * setup before each test
	 */
    @BeforeEach
    public void setUp() {
    	loginPage = new LoginPage();
        signupShop = new SignUpShop(); 
        
    }
   
    /**
     * test for BackToHomeButton.
     */
    @Test
    void testActionPerformedBackToHome() {
      
    	signupShop.backToHomeButton.doClick();

      
        assertFalse(SignUpShop.frame.isVisible());
        assertTrue(loginPage.frame.isVisible());
    }

    /**
     * test for SelectAll.
     */
    @Test
    public void testActionPerformed_SelectAll() {
        // Simulate the Select All button click
    	signupShop.selectAllButton.doClick();

        // Verify that all the buttons are disabled and labeled as "Sold"
        assertFalse(signupShop.playerOneButton.isEnabled());
        assertFalse(signupShop.playerTwoButton.isEnabled());
        assertFalse(signupShop.playerThreeButton.isEnabled());
        assertFalse(signupShop.playerFourButton.isEnabled());
        assertFalse(signupShop.reservePlayerOneButton.isEnabled());
        assertFalse(signupShop.reservePlayerTwoButton.isEnabled());
        assertFalse(signupShop.reservePlayerThreeButton.isEnabled());
        assertFalse(signupShop.reservePlayerFourButton.isEnabled());

        assertEquals("Sold", signupShop.playerOneButton.getText());
        assertEquals("Sold", signupShop.playerTwoButton.getText());
        assertEquals("Sold", signupShop.playerThreeButton.getText());
        assertEquals("Sold", signupShop.playerFourButton.getText());
        assertEquals("Sold", signupShop.reservePlayerOneButton.getText());
        assertEquals("Sold", signupShop.reservePlayerTwoButton.getText());
        assertEquals("Sold", signupShop.reservePlayerThreeButton.getText());
        assertEquals("Sold", signupShop.reservePlayerFourButton.getText());

        // Verify that all the players are added to the player_list
        assertEquals(8, SignUpShop.playerList.player.size());
    }

    /**
     * test for DeselectAll method.
     */
    @Test
    public void testActionPerformedDeselectAll() {
        // Select all the players
    	signupShop.selectAllButton.doClick();

        // Simulate the Deselect All button click
        signupShop.deselectAllButton.doClick();

        // Verify that all the buttons are enabled and labeled correctly
        assertTrue(signupShop.playerOneButton.isEnabled());
        assertTrue(signupShop.playerTwoButton.isEnabled());
        assertTrue(signupShop.playerThreeButton.isEnabled());
        assertTrue(signupShop.playerFourButton.isEnabled());
        assertTrue(signupShop.reservePlayerOneButton.isEnabled());
        assertTrue(signupShop.reservePlayerTwoButton.isEnabled());
        assertTrue(signupShop.reservePlayerThreeButton.isEnabled());
        assertTrue(signupShop.reservePlayerFourButton.isEnabled());

        assertEquals("Buy Player( goal keeper)", signupShop.playerOneButton.getText());
        assertEquals("Buy Player (left defender)", signupShop.playerTwoButton.getText());
        assertEquals("Buy Player (right defender)", signupShop.playerThreeButton.getText());
        assertEquals("Buy Player (attacker) ", signupShop.playerFourButton.getText());
        assertEquals("Buy reserve Player (goal keeper) ", signupShop.reservePlayerOneButton.getText());
        assertEquals("Buy reserve Player (attacker)", signupShop.reservePlayerTwoButton.getText());
        assertEquals("Buy reserve Player(left defender)", signupShop.reservePlayerThreeButton.getText());
        assertEquals("Buy reserve Player(right defender) ", signupShop.reservePlayerFourButton.getText());

        assertEquals(0, SignUpShop.playerList.player.size());
    }
   

    



}
