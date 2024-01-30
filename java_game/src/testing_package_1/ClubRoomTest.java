package testing_package_1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import foot.Player;
import foot.Team;
import game_main_menu.ClubRoom;
import game_start_and_login_page.SignUpShop;
import junit.framework.Assert;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;

/**
 * test Class for ClubRroom
 * @author udayd
 *
 */
public class ClubRoomTest {

	/**
	 * empty constructor
	 */
	ClubRoomTest()
	{
		
	}
	/**
	 * club room object.
	 */
	private ClubRoom club = new ClubRoom();
	/**
	 * SignUpShop object.
	 */
	private SignUpShop signupShop = new SignUpShop();
	
	/**
	 * setup before each test.
	 */
	@BeforeEach
	public void setup()
	{
		club.initialize();
		signupShop.playerList.player.add(new Player(0, 0, 0, 0, "Player 1", "goal keeper", true, false));
		signupShop.playerList.player.add(new Player(0, 0, 0, 0, "Player 2", "attacker", true, false));
		signupShop.playerList.player.add(new Player(0, 0, 0, 0, "Player 3", "goal keeper", false, false));
	}
	/**
	 * test for Update Player Squad method.
	 */
	@Test
	public void testUpdatePlayerSquad() {
		
		Object[] fourPlayingPlayers = club.playingFour;
		Object[] reservesList = club.reserves;
		Object[] playerList = club.totalPlayers;

		
		// Assert the player names in the lists
		Player player1 = (Player) fourPlayingPlayers[0];
		Player reservePlayer = (Player) reservesList[0];
		Player reservePlayer_1 = (Player) reservesList[1];
		
		assertEquals("Player 3", player1.getName());
		assertEquals("Player 1", reservePlayer.getName());
		assertEquals("Player 2", reservePlayer_1.getName());

		// Assert the player names in the player available list
		assertEquals("Player 1", playerList[0].toString());
		assertEquals("Player 2", playerList[1].toString());
		assertEquals("Player 3", playerList[2].toString());
		
	}
	
	/**
	 * test for PurcahseButtonActivation method.
	 */
	@Test
    public void testPurchaseButtonActivation() {
		club.numberOfWeeklPassesForGoalkeeper = 2;
		club.numberOfWeeklyPassesForDefenders = 1;
		club.numberOfWeeklyPassesForAttackers = 0;
		club.numberOfProteinSuppliements = 3;

        
		club.purchaseButtonActivation();

		
        assertTrue(club.weeklyTrainingPassForGoalKeeperTextField.isEnabled());
        assertTrue(club.goalKeeperTextField.isEnabled());
        assertEquals("number remaining: 2", club.goalKeeperPassesRemainingCounterJLabel.getText());

        assertTrue(club.defenderTextField.isEnabled());
        assertTrue(club.defenderTrainingPassButton.isEnabled());
        assertEquals("number remaining: 1", club.defenderPassRemainingCounter.getText());

        assertFalse(club.strickerTrainingButton.isEnabled());
        assertFalse(ClubRoom.strickerTextField.isEnabled());

        assertTrue(club.proteinSupplimentButton.isEnabled());
        assertTrue(club.proteinSupplimenetTextField.isEnabled());
        assertEquals("number remaining: 3", club.proteinSupplimentAvaiableCounterJLabel.getText());
    }
	
	/**
	 * test for InSquadPlayerExistsReturnsTrue() method.
	 */
	@Test
	public void testInSquadPlayerExistsReturnsTrue() {
		boolean result = club.InSquad("Player 3", "goal keeper");
		assertTrue(result);
	}

	/**
	 * test for InSquadPlayerDoesNotExistReturnsFalse() method.
	 */
	@Test
	public void testInSquadPlayerDoesNotExistReturnsFalse() {
		boolean result = club.InSquad("Player 3", "attacker");
		assertFalse(result);
	}

	/**
	 * test for InSquadPlayerExistsWithDifferentPositionReturnsFalse.
	 */
	@Test
	public void testInSquadPlayerExistsWithDifferentPositionReturnsFalse() {
		boolean result = club.InSquad("Player 2", "goal keeper");
		assertFalse(result);
	}
	/**
	 * test for InSquadWithUnknownPositionPlayerExistsReturnsPosition() method.
	 */
	@Test
	public void testInSquadWithUnknownPositionPlayerExistsReturnsPosition() {
		String result = club.inSquadWithUnknownPosition("Player 1");
		assertEquals("goal keeper", result);
	}

	/**
	 * test for InSquadWithUnknownPositionPlayerDoesNotExistReturnsEmptyString() method.
	 */
	@Test
	public void testInSquadWithUnknownPositionPlayerDoesNotExist_ReturnsEmptyString() {
		String result = club.inSquadWithUnknownPosition("Player 4");
		assertEquals("", result);
	}

	/**
	 * test for PlayerCastingHelperPlayerExistsReturnsPlayerObject() method
	 */
	@Test
	public void testPlayerCastingHelperPlayerExistsReturnsPlayerObject() {
		Object result = club.playerCastingHelper("Player 2");
		assertEquals(Player.class, result.getClass());
	}
	
	/**
	 * test casees for PositionOpenTest() method
	 */
	@Test
    public void testPositionOpen() {
        // Create players for testing
        Team player1 = new Player(0, 0, 0, 0, "John", "offense", false, false);
        Team player2 = new Player(0, 0, 0, 0, "Sarah", "attacker", false, false);
        Team player3 = new Player(0, 0, 0, 0, "Michael", "Defense", false, false);
        Team player4 = new Player(0, 0, 0, 0, "Emily", "goal keeper", false, false);
        Team player5 = new Player(0,0,0,0,"Stupid","",false,false);
        
        // Add players to the playing_four list
        
        club.playingFour[0] = player1;
        club.playingFour[1] = player2;
        club.playingFour[2] = player3;
        club.playingFour[3] = player4;
        
        // Test with a player whose position is not present in the playing_four list
        boolean result1 = club.positionOpenInThePlayingList(player5);
        assertTrue(result1);
        
        // Test with a player whose position is already present in the playing_four list
        boolean result2 = club.positionOpenInThePlayingList(player1);
        assertFalse(result2);
        
        // Test with an empty playing_four list
        club.updatePlayerSquad();
        club.playingFour = new Object[0];
        boolean result3 = club.positionOpenInThePlayingList(player1);
        assertTrue(result3);
      
    }
	
	/**
	 * creates test cases for ValueChangeWithSelectedPlayer method
	 */
	@Test
    public void testValueChangeWithSelectedPlayer() {
        
        Player player1 = new Player(0, 0, 0, 0, "John", "attacker", false, false);
        Team player2 = new Player(0, 0, 0, 0, "Sarah", "goal keeper", false, false);
        Object[] team = new Object[2];
        team[0] = player1;
        team[1] = player2;
       
        
        club.playerList = new JList<Object>(team);
   
        // Set up the initial state
        club.playerList.setSelectedValue(player1, true);
        
        // Create the event object
        ListSelectionEvent event = new ListSelectionEvent(club.playerList, 0, 0, false);
        
       
        club.valueChanged(event);
        
        // Assert the expected values
        assertEquals("player nickname: " + player1.getnickName() + " ", club.playerNickname.getText());
        assertEquals("stamina: " + player1.stamina() + " ", club.staminaDisplay.getText());
        assertEquals("offense: " + player1.offense() + " ", club.offenseDisplay.getText());
        assertEquals("defense: " + player1.defence() + " ", club.defenseDisplay.getText());
        assertEquals("position: " + player1.getPosition() + " ", club.position.getText());
        assertEquals("protein suppliement taken this week: " + player1.hasProteinSuppliement(),
        		club.proteinSuppliementStatDisplay.getText());
        assertEquals("reflex: ", club.reflex.getText());
        assertEquals("weekly training pass: " + player1.hasWeeklyPassForAttacker(),
        		club.weeklyTrainingPassDisplay.getText());
        assertEquals("reserve: No ", club.isRevserve.getText());
    }
    
	/**
	 *  Create a test for the ValueChangeWithGoalKeeper()method.
	 */
    @Test
    public void testValueChangeWithGoalkeeper() {
        
        Player goalkeeper = new Player(0, 0, 0, 0, "Michael", "goal keeper", false, true);
        
        
      
        Object[] team = new Object[1];
        team[0] = goalkeeper;
      
        club.playerList = new JList<Object>(team);
        
        // Set up the initial state
        club.playerList.setSelectedValue(goalkeeper, true);
        
        // Create the event object
        ListSelectionEvent event = new ListSelectionEvent(club.playerList, 0, 0, false);
        
        // Call the method under test
        club.valueChanged(event);
        
        // Assert the expected values 
        assertEquals("player nickname: " + goalkeeper.getnickName() + " ", club.playerNickname.getText());
        assertEquals("stamina: " + goalkeeper.stamina() + " ", club.staminaDisplay.getText());
        assertEquals("offense: " + goalkeeper.offense() + " ", club.offenseDisplay.getText());
        assertEquals("defense: " + goalkeeper.defence() + " ", club.defenseDisplay.getText());
        assertEquals("position: " + goalkeeper.getPosition() + " ", club.position.getText());
        assertEquals("protein suppliement taken this week: " + goalkeeper.hasProteinSuppliement(),
                club.proteinSuppliementStatDisplay.getText());
        assertEquals("reflex: " + goalkeeper.goalKeeperReflex(), club.reflex.getText());
        assertEquals("weekly training pass: " + goalkeeper.hasWeeklyPassForGoalKeepers(),
                club.weeklyTrainingPassDisplay.getText());
        assertEquals("reserve: No ", club.isRevserve.getText());
    }
	
    /**
     *  Create a test for the clubRoom class addPLayerToPLayerList() method
     */
    @Test 
    public void testAddPlayerToPlayerList() {
       
        ClubRoom testClass = new ClubRoom();

        
        Object selectedPlayer = new Player(0, 0, 0, 0, "John", null, false, false);
        Object player1 = new Player(0, 0, 0, 0, "John", null, false, false);
        Object player2 = new Player(0, 0, 0, 0, "Alice", null, true, false);
        ArrayList<Player> playerList = new ArrayList<Player>();
        playerList.add((Player) player1);
        playerList.add((Player) player2);
        
        SignUpShop.playerList.player = playerList;

      
        testClass.addPlayerToPlayerList();

        
        
        assertFalse(((Player) player1).isReserve());
        assertTrue(((Player) player2).isReserve());
        
    }


  
}

