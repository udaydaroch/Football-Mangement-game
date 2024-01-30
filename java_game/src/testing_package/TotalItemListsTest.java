package testing_package;

import static org.junit.Assert.*;

import org.junit.Test;
import foot.Inventory;
import game_main_menu.ClubRoom;
import foot.Items;
import java.util.HashMap;

/**
 * test cases for the Inventory class
 * @author udayd
 *
 */
public class TotalItemListsTest {
	
	/**
	 * inventory object created for test cases.
	 */
	private Inventory inventory;
	
	/**
	 * constructor TotalItemsListTest
	 */
	public TotalItemListsTest()
	{
		
	}

	/**
	 * tests the Addition of items to the Inventory.
	 */
	@Test
    public void testAddItemToInventory() {
        Inventory inventory = new Inventory();
        Items item1 = new Items("weekly training pass for goalkeepers", 10);
        inventory.addItemToInventory(item1);

        HashMap<Items, Integer> expectedItems = new HashMap<>();
        expectedItems.put(item1, ClubRoom.numberOfWeeklPassesForGoalkeeper);

        assertEquals(expectedItems, Inventory.itemsAvaiable);
        inventory.itemsAvaiable.remove(item1);
    }


	/**
	 * test the removeal of items from the inventory.
	 */
    @Test
    public void testRemoveItemFromInventory() {
        Inventory inventory = new Inventory();
        Items item1 = new Items("weekly training pass for goalkeepers", 10);
        Inventory.itemsAvaiable.put(item1, 5);

        inventory.removeItemFromInventory(item1, 2);

        HashMap<Items, Integer> expectedItems = new HashMap<>();
        expectedItems.put(item1, ClubRoom.numberOfWeeklPassesForGoalkeeper);
        expectedItems.put(item1, ClubRoom.numberOfWeeklPassesForGoalkeeper);
  
        assertEquals(expectedItems, Inventory.itemsAvaiable);
    }
}


