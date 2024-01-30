package testing_package;

import static org.junit.Assert.*;

import org.junit.Test;
import foot.Items;
import game_main_menu.GameMenu;
/**
 * class testing the Items class 
 * @author udayd
 *
 */
public class ItemsText {

	/**
	 * uses the default constructor to initialize nothing
	 */
	public ItemsText()
	{
		
	}
	/**
     * Test case for getting the item name.
     */
    @Test
    public void testGetItems() {
        Items item = new Items("Football", 50);
        assertEquals("Football", item.getItems());
    }

    /**
     * Test case for getting the initial purchase price of the item.
     */
    @Test
    public void testInitialPurchasePrize() {
        Items item = new Items("Football", 50);
        assertEquals(50, item.initialPurchasePrize());
    } 

    /**
     * Test case for setting the price of the item.
     */
    @Test
    public void testSetPrice() {
        Items item = new Items("Football", 50);
        item.setPrice(60);
        assertEquals(60, item.initialPurchasePrize());
    }

    /**
     * Test case for getting the current price of the item based on the current week.
     */
    @Test
    public void testCurrentPrize() {
        GameMenu.currentWeek = 2;
        Items item = new Items("Football", 50);
        assertEquals(30, item.currentPrize());
    }

}



