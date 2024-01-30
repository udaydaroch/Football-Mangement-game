package foot;

import java.util.HashMap;
import java.util.ArrayList;
import game_main_menu.ClubRoom;

/** 
 * Interface contains methods for adding and removing items from an athlete's inventory
 * 
 * @author Jack Kuruvilla
 *
 */
interface itemsAvailableToAthelete {
	/**
	 * general method that is used to add Items to the inventory
	 * @param items instance of the Items class holding the number of items and the name of the item. 
	 */
    void addItemToInventory(Items items);
    /**
     * general method that is used to remove Items from the inventory.
     * @param items the instance of the Item class
     * @param remove is the integer amount of that particular item that is taken off the Inventory
     */
    void removeItemFromInventory(Items items, int remove);
}

/**
 *  Class representing the total items list and implementing the itemsAvailableToAthelete interface
 * @author udayd
 *
 */
public class Inventory implements itemsAvailableToAthelete {
	/**
	 * uses the default construct to create an Inventory without initializing any variables
	 */
	public  Inventory()
	{
		
	}
    /**
     *  HashMap called itemsAvaiable to store all the available items and their quantities
     */
    public static HashMap<Items, Integer> itemsAvaiable = new HashMap<>();
    /**
     *  HashMap called the nameOfItems to store all the item names nad their quantities.
     */
    public HashMap<String, Integer> nameOfItems = new HashMap<String, Integer>();

    /** Method to remove items from the inventory
     * 
     */
    public void removeItemFromInventory(Items items, int remove) {
        String name = items.getItems();
        switch(name) {
            case "weekly training pass for goalkeepers":
                // Update the quantity of weekly training passes for goalkeepers
                ClubRoom.numberOfWeeklPassesForGoalkeeper -= remove;
                itemsAvaiable.put(items, ClubRoom.numberOfWeeklPassesForGoalkeeper);
                nameOfItems.put(name, ClubRoom.numberOfWeeklPassesForGoalkeeper);
                break;
            case "weekly training pass for defenders":
                // Update the quantity of weekly training passes for defenders
                ClubRoom.numberOfWeeklyPassesForDefenders -= remove;
                itemsAvaiable.put(items, ClubRoom.numberOfWeeklyPassesForDefenders);
                nameOfItems.put(name,  ClubRoom.numberOfWeeklyPassesForDefenders);
                break;
            case "weekly training pass for strickers":
                // Update the quantity of weekly training passes for strikers
                ClubRoom.numberOfWeeklyPassesForAttackers -= remove;
                nameOfItems.put(name, ClubRoom.numberOfWeeklyPassesForAttackers);
                itemsAvaiable.put(items, ClubRoom.numberOfWeeklyPassesForAttackers);
                break;
            case "protein_suppliments":
                // Update the quantity of protein supplements
                ClubRoom.numberOfProteinSuppliements -= remove;
                nameOfItems.put(name, ClubRoom.numberOfProteinSuppliements);
                itemsAvaiable.put(items, ClubRoom.numberOfProteinSuppliements);
                break;
        }
    }

    /** Method to add items to the inventory
   
     */
    public void addItemToInventory(Items items) {
        String name = items.getItems();
        switch(name) {
            case "weekly training pass for goalkeepers":
                // Update the quantity of weekly training passes for goalkeepers
                ClubRoom.numberOfWeeklPassesForGoalkeeper += 1;
                nameOfItems.put(name,  ClubRoom.numberOfWeeklPassesForGoalkeeper);
                itemsAvaiable.put(items, ClubRoom.numberOfWeeklPassesForGoalkeeper);
                break;
            case "weekly training pass for defenders":
                // Update the quantity of weekly training passes for defenders
                ClubRoom.numberOfWeeklyPassesForDefenders += 1;
                nameOfItems.put(name,  ClubRoom.numberOfWeeklyPassesForDefenders);
                itemsAvaiable.put(items, ClubRoom.numberOfWeeklyPassesForDefenders);
                break;
            case "weekly training pass for strickers":
                // Update the quantity of weekly training passes for strikers
                ClubRoom.numberOfWeeklyPassesForAttackers += 1;
                nameOfItems.put(name,  ClubRoom.numberOfWeeklyPassesForAttackers);
                itemsAvaiable.put(items, ClubRoom.numberOfWeeklyPassesForAttackers);
                break;
            case "protein_suppliments":
                // Update the quantity of protein supplements
                ClubRoom.numberOfProteinSuppliements += 1;
                nameOfItems.put(name,   ClubRoom.numberOfProteinSuppliements);
                itemsAvaiable.put(items, ClubRoom.numberOfProteinSuppliements);
                break;
        }
    }
}
