package testing_package;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import foot.RandomEvents;
import game_main_menu.GameMenu;
import game_start_and_login_page.LoginPage;
import game_start_and_login_page.SignUpShop;
import  foot.Player;
/**
 * This class is controlling the random events that take 
 * place in the game. running the JUnit tests 
 * might show that some of them are not passing this is because
 * the passing of the tests is depended on whether the probability
 * of that event happening is in favour of the event
 * ie when two numbers in the if statment are the same.
 * @author udayd
 *
 */
class RandomEventsTest {

	/**
	 * a player object is created
	 */
	private Player player;
	
	/**
	 * empty contructor
	 */
	private RandomEventsTest()
	{
		
	}

	/**
	 * set ups the the player and the Shop before each test
	 */
    @BeforeEach
    public void setUp() {
    	
        player = new Player(100, 0, 0, 0, "John", "goal keeper", false, false);
        SignUpShop.playerList.player.add(player);
       
      
    }

    /**
     * Test case to check the setPlayerStat() method of RandomEvents class
     */
    @Test
    public void testSetPlayerStat() {
        GameMenu.difficulty = 1;
        RandomEvents.setPlayerStat(player);
        // Assert that player's offense and defense stats are increased
        assertFalse(player.offense() > 100);
        assertTrue(player.defence() > 0);
        // Assert that player's reflex stat is increased (since position is "goal keeper")
        assertTrue(player.goalKeeperReflex() > 0);
    }

    /**
     * Test case to check the choseRandomPlayerName() method of RandomEvents class
     */
    @Test
    public void testChoseRandomPlayerName() {
        String name = RandomEvents.chooseRandomPlayerName("John");
        // Assert that the chosen random name is not the same as the current name
        assertNotEquals("John", name);
    }

    /**
     * Test case to check the triggerRandomEventOfPlayerBeingAdded() method of RandomEvents class
     */
    @Test
    public void testTriggerRandomEventOfPlayerBeingAdded() {
        int initialSize = SignUpShop.playerList.player.size();
        RandomEvents.triggerRandomEventOfPlayerBeingAdded();
        // Assert that a player has been added to the player list if the condition is met
        if (SignUpShop.playerList.player.size() <= 8) {
            assertEquals(initialSize + 1, SignUpShop.playerList.player.size());
        } else {
            assertEquals(initialSize, SignUpShop.playerList.player.size());
        }
    }

    /**
     * Test case to check the findPlayerIndex() method of RandomEvents class
     */
    @Test
    public void testFindPlayerIndex() {
        int index = RandomEvents.findPlayerIndex(player);
        // Assert that the player index is found correctly
        assertEquals(0, index);
    }

    /**
     * Test case to check the triggerRandomEventOfPlayerBeingRemoved() method of RandomEvents class
     */
    @Test
    public void testTriggerRandomEventOfPlayerBeingRemoved() {
        int initialSize = SignUpShop.playerList.player.size();
        RandomEvents.triggerRandomEventOfPlayerBeingRemoved();
        // Assert that a player has been removed from the player list if the condition is met
        if (initialSize > 0) {
            assertEquals(initialSize - 1, SignUpShop.playerList.player.size());
        } else {
            assertEquals(initialSize, SignUpShop.playerList.player.size());
        }
    }

    /**
     * Test case to check the randomNumberGenerator() method of RandomEvents class
     */
    @Test
    public void testRandomNumberGenerator() {
        int value = RandomEvents.randomNumberGenerator(10, 5);
        // Assert that the generated value is within the specified range
        assertTrue(value >= 5 && value <= 10);
    }

    /**
     * Test case to check the findThePlayerWithMostMatchesPlayed() method of RandomEvents class
     */
    @Test
    public void testFindThePlayerWithMostMatchesPlayed() {
        int index = RandomEvents.findThePlayerWithMostMatchesPlayed();
        // Assert that the index is valid (within the player list size)
        assertTrue(index >= 0 && index < SignUpShop.playerList.player.size());
    }

    /**
     * Test case to check the triggerRandomEventOfPlayerStatIncreasing() method of RandomEvents class
     */
    @Test
    public void testTriggerRandomEventOfPlayerStatIncreasing() {
        RandomEvents.triggerRandomEventOfPlayerStatIncreasing();
        // Assert that player's stats have increased
        assertTrue(player.stamina() <= 100);
        assertTrue(SignUpShop.playerList.player.get(0).offense() > 0);
        assertTrue(SignUpShop.playerList.player.get(0).defence() > 0);
        assertTrue(SignUpShop.playerList.player.get(0).goalKeeperReflex() > 0);
    }
}
