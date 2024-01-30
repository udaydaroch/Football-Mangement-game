package testing_package;

import static org.junit.Assert.*;

import org.junit.Test;


import foot.Player;
import foot.Team;
import game_main_menu.ClubRoom;
import game_main_menu.GameMenu;
/**
* PlayerClassTesting class to test the Player class
*/
public class PlayerClassTesting {

	/**
	 * empty constructor 
	 */
	public PlayerClassTesting()
	{
		
	}
	/**
	* Test case to check the getName() method of Player class
	*/
	@Test
	public void testGetName() {
		Player player = new Player(80, 90, 70, "John", "attacker", false, true);
		assertEquals("John", player.getName());
	}

	/**
	* Test case to check the getStamina() method of Player class
	*/
	@Test
	public void testGetStamina() {
		Player player = new Player(80, 90, 70, "John", "attacker", false, true);
		assertEquals(80, player.stamina());
	}

	/**
	* Test case to check the getOffense() method of Player class
	*/
	@Test
	public void testGetOffense() {
		Player player = new Player(80, 90, 70, "John", "attacker", false, true);
		assertEquals(90, player.offense());
	}

	/**
	* Test case to check the getDefence() method of Player class
	*/
	@Test
	public void testGetDefence() {
		Player player = new Player(80, 90, 70, "John", "attacker", false, true);
		assertEquals(70, player.defence());
	}

	/**
	* Test case to check the getGoalKeeperReflex() method of Player class
	*/
	@Test
	public void testGetGoalKeeperReflex() {
		Team player = new Player(80, 90, 70, 85, "John", "goal keeper", false, true);
		assertEquals(85, ((Player) player).goalKeeperReflex());
	}

	/**
	* Test case to check the getStatus() method of Player class
	*/
	@Test
	public void testGetStatus() {
		Player player = new Player(80, 90, 70, "John", "attacker", false, true);
		String expectedStatus = "John\nstamina: 80\nOffense: 90\ndefence: 70";
		assertEquals(expectedStatus, player.getstatus());
	}

	/**
	* Test case to check the setStamina() method of Player class
	*/
	@Test
	public void testSetStamina() {
		Player player = new Player(80, 90, 70, "John", "attacker", false, true);
		player.setStamina(85);
		assertEquals(85, player.stamina());
	}

	/**
	* Test case to check the setOffense() method of Player class
	*/
	@Test
	public void testSetOffense() {
		Player player = new Player(80, 90, 70, "John", "attacker", false, true);
		player.setOffense(95);
		assertEquals(95, player.offense());
	}

	/**
	* Test case to check the setDefence() method of Player class
	*/
	@Test
	public void testSetDefence() {
		Player player = new Player(80, 90, 70, "John", "attacker", false, true);
		player.setDefence(75);
		assertEquals(75, player.defence());
	}


	 /**
     * Test case to check the isPro() method of Player class
     */
    @Test
    public void testIsPro() {
        Player player1 = new Player(80, 90, 70, "John", "attacker", false, true);
        Player player2 = new Player(80, 90, 70, "Jane", "defender", false, false);
        assertTrue(player1.isPro());
        assertFalse(player2.isPro());
    }

    /**
     * Test case to check the setName() method of Player class
     */
    @Test
    public void testSetName() {
        Player player = new Player(80, 90, 70, "John", "attacker", false, true);
        player.setName("Johnny");
        assertEquals("Johnny", player.getName());
    }

    /**
     * Test case to check the setReserve() method of Player class
     */
    @Test
    public void testSetReserve() {
        Player player = new Player(80, 90, 70, "John", "attacker", false, true);
        player.setReserve(true);
        assertTrue(player.isReserve());
    }


    /**
     * Test case to check the weeklyPassForLeftDefenders() method of Player class
     */
    @Test
    public void testWeeklyPassForLeftDefenders() {

        Player player = new Player(80, 90, 70, "John", "left defender", false, true);
        player.setWeeklyPassForLeftDefenders(true);
        GameMenu.currentWeek = 0;
        GameMenu.duration = 9;

        GameMenu.difficulty = 1;
        player.weeklyPassForLeftDefenders();

        assertEquals(95, player.stamina());
        assertEquals(90, player.offense());
     
        assertEquals(85, player.defence());
    }

    /**
     * Test case to check the weeklyPassForRightDefenders() method of Player class
     */
    @Test
    public void testWeeklyPassForRightDefenders() {
        Player player = new Player(80, 90, 70, "John", "right defender", false, true);
        player.setWeeklyPassForRightDefenders(true);
        player.weeklyPassForRightDefenders();
        GameMenu.currentWeek = 0;
        GameMenu.duration = 10;
        GameMenu.difficulty = 1;
        assertEquals(95, player.stamina());
        assertEquals(90, player.offense());
        assertEquals(85, player.defence());
    }

    /**
     * Test case to check the weeklyPassForGoalKeepers() method of Player class
     */
    @Test
    public void testWeeklyPassForGoalKeepers() {
        Player player = new Player(80, 90, 70, "John", "goal keeper", false, true);
        player.setWeeklyPassForGoalKeepers(true);
        player.weeklyPassForGoalKeepers();
        GameMenu.currentWeek = 0;
        GameMenu.duration = 10;
        GameMenu.difficulty = 1;
    
        assertEquals(95, player.stamina());
        assertEquals(90, player.offense());
        assertEquals(70, player.defence());
    }


    /**
     * Test case to check the hasWeeklyPassForLeftDefenders() method of Player class
     */
    @Test
    public void testHasWeeklyPassForLeftDefenders() {
        Player player = new Player(80, 90, 70, "John", "left defender", false, true);
        player.setWeeklyPassForLeftDefenders(true);
        assertEquals("yes", player.hasWeeklyPassForLeftDefender());
    }

    /**
     * Test case to check the hasWeeklyPassForRightDefenders() method of Player class
     */
    @Test
    public void testHasWeeklyPassForRightDefenders() {
        Player player = new Player(80, 90, 70, "John", "right defender", false, true);
        player.setWeeklyPassForRightDefenders(true);
        assertEquals("yes", player.hasWeeklyPassForRightDefender());
    }

    /**
     * Test case to check the hasWeeklyPassForGoalKeepers() method of Player class
     */
    @Test
    public void testHasWeeklyPassForGoalKeepers() {
        Player player = new Player(80, 90, 70, "John", "goal keeper", false, true);
        player.setWeeklyPassForGoalKeepers(true);
        assertEquals("yes", player.hasWeeklyPassForGoalKeepers());
    }

    /**
     * Test case to check the hasWeeklyPassForAttackers() method of Player class
     */
    @Test
    public void testHasWeeklyPassForAttackers() {
        Player player = new Player(80, 90, 70, "John", "attacker", false, true);
        player.setWeeklyPassForAttacker(true);
        assertEquals("yes", player.hasWeeklyPassForAttacker());
    }

    /**
     * Test case to check the hasProteinSupplement() method of Player class
     */
    @Test
    public void testHasProteinSupplement() {
        Player player = new Player(80, 90, 70, "John", "attacker", false, true);
        player.setProteinSuppliement(true);
        assertEquals("yes", player.hasProteinSuppliement());
    }

    /**
     * Test case to check the setWeeklyPassForLeftDefenders() method of Player class
     */
}






