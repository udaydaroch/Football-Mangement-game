package foot;

import game_main_menu.GameMenu;

/**
 * The GeneralItemInfo interface defines methods for retrieving information about items.
 * @author  Jack Kuruvilla
 */
interface GeneralItemInfo {
	/**
	 * Retrieves the name of the item.
	 * 
	 * @return The name of the item.
	 */
	public String getItems();

	/**
	 * Retrieves the initial purchase price of the item.
	 * 
	 * @return The initial purchase price of the item.
	 */
	public int initialPurchasePrize();

	/**
	 * Sets the price of the item.
	 * 
	 * @param value The new price of the item.
	 */
	public void setPrice(int value);

	/**
	 * Retrieves the current price of the item.
	 * 
	 * @return sets the current price of the item.
	 */
	public int currentPrize();
	
	
}

/**
 * The Items class represents an item and implements the GeneralItemInfo interface.
 */
public class Items extends Inventory implements GeneralItemInfo {
	/**
	 * varaiable used to name the Item.
	 */
	private String nameOfItem;
	/**
	 * sets the inital prize of the player.
	 */
	private int initialPrice;
	/**
	 * the number of a particular item.
	 */
	private int amount;

	/**
	 * Constructs a new Items object with the specified itemName and price.
	 * 
	 * @param itemName The name of the item.
	 * @param numberOfItem the number of items of that kind that are purchased from the market.
	 */
	
	public Items(String itemName, int numberOfItem) {
		nameOfItem = itemName;
		amount = numberOfItem;
		initialPrice = 0;
	}

	/**
	 * Retrieves the name of the item.
	 * 
	 * @return The name of the item.
	 */
	public String getItems() {
		return nameOfItem;
	}

	/**
	 * Returns a string representation of the item.
	 * 
	 * @return The name of the item.
	 */
	public String toString() {
		return nameOfItem;
	}

	/**
	 * Retrieves the initial purchase price of the item.
	 * 
	 * @return The initial purchase price of the item.
	 */
	public int initialPurchasePrize() {
		return amount;
	}

	/**
	 * Retrieves the current price of the item.
	 * 
	 * @return The current price of the item.
	 */
	public int currentPrize() {
		return amount - 10 * (GameMenu.currentWeek);
	}

	/**
	 * Sets the price of the item.
	 * 
	 * @param value The new price of the item.
	 */
	@Override
	public void setPrice(int value) {
		amount = value;
	}

	/**
	 * Retrieves the name of the Item.
	 * @return the name of the Item.
	 */
	public  String getName() {
		// TODO Auto-generated method stub
		return nameOfItem;
	}
	
}
