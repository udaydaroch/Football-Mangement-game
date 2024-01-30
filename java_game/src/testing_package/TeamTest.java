package testing_package;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import foot.Team;
import foot.Inventory;
import game_main_menu.GameMenu;
import game_main_menu.Market;
import foot.Items;
import foot.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import foot.Team;
import game_main_menu.ClubRoom;
import game_main_menu.GameMenu;
import game_start_and_login_page.SignUpShop;
import foot.Player;
/**
 * test class for Team
 * @author udayd
 *
 */
public class TeamTest {
    
	/**
	 * empty constructor
	 */
	public TeamTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * team object initizalised.
	 */
	private Team team;
    
    /**
     * setUp before all tests.
     */
    @Before
    public void setUp() {
    	
    	
    	team = new Team();
    }

  /**
   * Test case where all positions are filled.
   * 
   */
    @Test
    public void testCheckIfNoFullSquadAndNoReservesToSubstitudeFound() {
        
        Player goalkeeper = new Player(0, 0, 0, 0, "John", "goal keeper", false, false);
        Player leftDefender = new Player(0, 0, 0, 0, "Mike", "left defender", false, false);
        Player rightDefender = new Player(0, 0, 0, 0, "Tom", "right defender", false, false);
        Player attacker = new Player(0, 0, 0, 0, "Jake", "attacker", false, false);
        
        team.player.add(goalkeeper);
        team.player.add(leftDefender);
        team.player.add(rightDefender);
        team.player.add(attacker);

        Assert.assertFalse(team.checkIfNoFullSquadAndNoReservesToSubstitudeFound());
    }

    /**
     *  Test case where not enough money and players to substitute
     */
    @Test
    public void testNotFullSquadAndNoReservesToSubstitude() {
       
    	
         
    	SignUpShop shop = new SignUpShop();
    	SignUpShop.playerList = new Team();
    
    	Player goalkeeper = new Player(0, 0, 0, 0, "John", "goal keeper", false, false);
        Player leftDefender = new Player(0, 0, 0, 0, "Mike", "left defender", false, false);
        Player rightDefender = new Player(0, 0, 0, 0, "Tom", "right defender", false, false);

       
        SignUpShop.playerList.player.add(goalkeeper);
        SignUpShop.playerList.player.add(leftDefender);
        SignUpShop.playerList.player.add(rightDefender);
        
        GameMenu.market = new Market();
        GameMenu.market.inventory.nameOfItems.put("weekly training pass for goalkeepers", 0);
        GameMenu.market.inventory.nameOfItems.put("weekly training pass for defenders", 0);
        GameMenu.market.inventory.nameOfItems.put("weekly training pass for strikers", 0);
        GameMenu.market.inventory.nameOfItems.put("protein_supplements", 0);

        GameMenu.money = 100;
        GameMenu.market.proPlayerPurchasePrice = 200;
        GameMenu.market.normalPlayerPurchasePrice = 200;
   
        Assert.assertFalse(SignUpShop.playerList.notFullSquadAndNoReservesToSubstitude());
    }

   /**
    * Test case where stamina is good and full squad is available
    */
    @Test
    public void testPlayDecide() {
       
    	Player goalkeeper = new Player(40, 40, 40, 40, "John", "goal keeper", false, false);
        Player leftDefender = new Player(50, 40, 40, 40, "Mike", "left defender", false, false);
        Player rightDefender = new Player(50, 40,40, 40, "Tom", "right defender", false, false);
        Player attacker = new Player(50, 40, 40, 40, "Jake", "attacker", false, false);

        SignUpShop.playerList.player.add(goalkeeper);
        SignUpShop.playerList.player.add(leftDefender);
        SignUpShop.playerList.player.add(rightDefender);
        SignUpShop.playerList.player.add(attacker);
        
        GameMenu.club = new ClubRoom();
        
        GameMenu.club.updatePlayerSquad();
        
        GameMenu.market = new Market();
        
        GameMenu.market.inventory.nameOfItems.put("weekly training pass for goalkeepers", 1);
        GameMenu.market.inventory.nameOfItems.put("weekly training pass for defenders", 2);
        GameMenu.market.inventory.nameOfItems.put("weekly training pass for strikers", 3);
        GameMenu.market.inventory.nameOfItems.put("protein_supplements", 1);

        GameMenu.money = 100;
        GameMenu.market.proPlayerPurchasePrice = 200;
        GameMenu.market.normalPlayerPurchasePrice = 200;
        
        Assert.assertTrue(team.PlayDecide());
    }

    /**
     *  Test case where all players have non-zero stamina
     */
    @Test
    public void testCheckIfStaminaGood() {
        // Test case where all players have non-zero stamina
    	Player goalkeeper = new Player(0, 0, 0, 0, "John", "goal keeper", false, false);
        Player leftDefender = new Player(0, 0, 0, 0, "Mike", "left defender", false, false);
        Player rightDefender = new Player(0, 0, 0, 0, "Tom", "right defender", false, false);
        Player attacker = new Player(0, 0, 0, 0, "Jake", "attacker", false, false);

        SignUpShop.playerList.player.add(goalkeeper);
        SignUpShop.playerList.player.add(leftDefender);
        SignUpShop.playerList.player.add(rightDefender);
        SignUpShop.playerList.player.add(attacker);
        
        ClubRoom.playingFour = new Object[4];
        ClubRoom.playingFour[0] = goalkeeper;
        ClubRoom.playingFour[1] = leftDefender;
        ClubRoom.playingFour[2] = rightDefender;
        ClubRoom.playingFour[3] = attacker;
       
        
       
        goalkeeper.setStamina(50);
        leftDefender.setStamina(80);
        rightDefender.setStamina(60);
        attacker.setStamina(70);

        SignUpShop.playerList.player.add(goalkeeper);
        SignUpShop.playerList.player.add(leftDefender);
        SignUpShop.playerList.player.add(rightDefender);
        SignUpShop.playerList.player.add(attacker);

        
        Team.zeroStaminaPlayers = new ArrayList<Player>();
        
        Assert.assertTrue(SignUpShop.playerList.checkIfStaminaGood());
    }

    /** 
     * Test case where enough money can be made after returning items
     * 
     */
    @Test
    public void testPotentialMoneyCanBeMadeAfterReturningItems() {
      
    	GameMenu.club = new ClubRoom();
        GameMenu.money = 100;
        GameMenu.market = new Market();
       
        GameMenu.market.inventory.nameOfItems.put("weekly training pass for goalkeepers", 2);
        GameMenu.market.inventory.nameOfItems.put("weekly training pass for defenders", 1);
        GameMenu.market.inventory.nameOfItems.put("weekly training pass for strickers", 3);
        GameMenu.market.inventory.nameOfItems.put("protein_suppliments", 4);

        GameMenu.market.weeklyTrainingPassForDefenceItem.setPrice(20);
        GameMenu.market.weeklyTrainingPassForGoalkeeperItem.setPrice(25);
        // Continue from the last test case

        GameMenu.market.weekyTrainingPassForAttackersItem.setPrice(100);
        GameMenu.market.proteinSupplementItem.setPrice(100);

        GameMenu.market.proPlayerPurchasePrice = 500;
        GameMenu.market.normalPlayerPurchasePrice = 300;

        Assert.assertTrue(team.potentialMoneyCanBeMadeAfterReturningItems());
    }

    /**
     * Test case where the player position is "left defender"
     * 
     */
    @Test
    public void testReturnMoneyRequiredToGetPlayerToNonZero() {
       
        String proteinSupplement = "protein_suppliments";
        String specificPass = "weekly training pass for defenders";

        GameMenu.market = new Market();
        GameMenu.market.inventory = new Inventory();
        SignUpShop.playerList = new Team();
        Player goalkeeper = new Player(0, 0, 0, 0, "John", "goal keeper", false, false);
        Player leftDefender = new Player(0, 0, 0, 0, "Mike", "left defender", false, false);
        Player rightDefender = new Player(0, 0, 0, 0, "Tom", "right defender", false, false);
        Player attacker = new Player(0, 0, 0, 0, "Jake", "attacker", false, false);

        SignUpShop.playerList.player.add(goalkeeper);
        SignUpShop.playerList.player.add(leftDefender);
        SignUpShop.playerList.player.add(rightDefender);
        SignUpShop.playerList.player.add(attacker);
      
        
        Items protein = new Items(proteinSupplement,3);
        Items pass = new Items(specificPass,2);
        Market.weeklyTrainingPassForDefenceItem.setPrice(15);
        Market.proteinSupplementItem.setPrice(10);
     
        Market.inventory.addItemToInventory(GameMenu.market.proteinSupplementItem);
      
        Market.inventory.addItemToInventory(GameMenu.market.weeklyTrainingPassForDefenceItem);
        
        Market.inventory.nameOfItems.put(proteinSupplement, 3);
        Market.inventory.nameOfItems.put(specificPass, 2);

        

        int expectedAmount = (3*GameMenu.market.proteinSupplementItem.currentPrize())
                + (2*GameMenu.market.weeklyTrainingPassForDefenceItem.currentPrize());

        int actualAmount = SignUpShop.playerList.ReturnMoneyRequiredToGetPlayerToNonZero(proteinSupplement, specificPass);
        Assert.assertEquals(expectedAmount, actualAmount);
    }

    /** 
     * Test case where the player position is "goal keeper"
     * 
     */
    @Test
    public void testReturnMoneyRequiredToGetPlayerToNonZero_WithGoalkeeper() {
       
        String proteinSupplement = "protein_supplements";
        String specificPass = "weekly training pass for goalkeepers";

        Market.inventory.addItemToInventory(GameMenu.market.proteinSupplementItem);
        Market.inventory.addItemToInventory(GameMenu.market.weeklyTrainingPassForGoalkeeperItem);
        
        GameMenu.market.inventory.nameOfItems.put(proteinSupplement, 4);
        GameMenu.market.inventory.nameOfItems.put(specificPass, 3);

        GameMenu.market.proteinSupplementItem.setPrice(10);
        GameMenu.market.weeklyTrainingPassForGoalkeeperItem.setPrice(20);

        int expectedAmount = 4 * GameMenu.market.proteinSupplementItem.currentPrize()
                + 3 * GameMenu.market.weeklyTrainingPassForGoalkeeperItem.currentPrize();

        int actualAmount = team.ReturnMoneyRequiredToGetPlayerToNonZero(proteinSupplement, specificPass);

        Assert.assertEquals(expectedAmount, actualAmount);
    }
}

