package foot;

import java.util.Random;

import game_main_menu.GameMenu;
import game_start_and_login_page.LoginPage;
import game_start_and_login_page.SignUpShop;

import java.util.ArrayList;

/**
 * The RandomEvents class handles generating random events within the game.
 * It contains static variables and methods for generating random values and performing related operations.
 * uses a default constructor
 * 
 */
public class RandomEvents {

	/**
	 * uses the default construct to make instances of the RandomEvent class wihout any sort of intialization.
	 */
	public RandomEvents()
	{
		
	}
    /**
     *  Random number generator instance.
     */
    private static Random random = new Random();
    
    /**
     *  Array of positions in the game.
     */
    private static String[] positions = {"goal keeper", "left defender", "right defender", "attacker"};

    /**
     * Probability factor for random events.
     */
    private static int probabilityFactor = 100;

    /**
     *  Array of player names for randomly generated players.
     */
    private static String[] playerNamesForRandomPersonBeingAdded = {
        "Liam", "Noah", "Oliver", "William", "Elijah", "James", "Benjamin", "Lucas", "Henry", "Alexander",
        "Mason", "Michael", "Ethan", "Daniel", "Matthew"
    };

    /**
     *  List called usedRandomNames that is  used to store random names to prevent duplicates
     */
    public static ArrayList<String> usedRandomNames = new ArrayList<String>();

    /**
     *  Random static variable called nameGenerators that is used to index a random name from a given list of strings
     */
    private static Random nameGenerators = new Random();

    /**
     * Returns the number of reserves and playing members from the player list in the sign-up shop.
     *
     * @return An array with two elements: the number of reserves and the number of playing members.
     */
    public static int[] findNumberOfReservesAndPlayingMembers() {
        int reserve = 0;
        int playing = 0;
        for (Player player : SignUpShop.playerList.player) {
            if (player.isReserve()) {
                reserve += 1;
            } else {
                playing += 1;
            }
        }
        return new int[]{reserve, playing};
    }


    /**
     * Generates a random initial stat based on the game difficulty.
     * 
     * @return The randomly generated stat value.
     */
	
	public static int randomInitialStatGenerator() {
	    Random stat = new Random();
	    int statReturn = 0;
	    
	 // Based on the game difficulty set in the GameMenu class, generate a random stat value
	    if (GameMenu.difficulty == 1) {
	    	statReturn = stat.nextInt(11) + 10;
	    } else if (GameMenu.difficulty == 2) {
	    	statReturn = stat.nextInt(11) + 20;
	    } else if (GameMenu.difficulty == 3) {
	    	statReturn = stat.nextInt(11) + 30;
	    }
	    
	    return statReturn;
	}
	
	/**
	 * Sets the player's stats based on certain conditions and generates random initial stats.
	 * 
	 * @param player The player object for which the statistics are being set.
	 */
	
	public static void setPlayerStat(Player player) {
	    // Check if the number of playing members is less than 4 and set player as non-reserve
	    if (findNumberOfReservesAndPlayingMembers()[1] < 4) {
	        player.setReserve(false);
	    }
	    
	    // Check if the number of reserves is less than 5 and set player as reserve
	    if (findNumberOfReservesAndPlayingMembers()[0] < 5) {
	        player.setReserve(true);
	    }
	    
	    // Increase the player's offense and defense stats by generating random initial stats
	    player.setOffense(player.offense() + randomInitialStatGenerator());
	    player.setDefence(player.defence() + randomInitialStatGenerator());
	    
	    // If the player's position is 'goal keeper', increase the player's goal keeper reflex stat
	    if (player.getPosition().equals("goal keeper")) {
	        player.setPlayerreflex(player.goalKeeperReflex() + randomInitialStatGenerator());
	    }
	}

	/**
	 * Chooses a random player name that is not already used.
	 *
	 * @param currentName The current name of the player.
	 * @return A random player name that is not already used.
	 */
	public static String chooseRandomPlayerName(String currentName) {
	    String name = "";
	    while (usedRandomNames.contains(currentName)) {
	        name = playerNamesForRandomPersonBeingAdded[nameGenerators.nextInt(15)];
	    }
	    return name;
	}


	/**
	 * Triggers a random event of a player being added to the team.
	 */
	public static void triggerRandomEventOfPlayerBeingAdded() {
	    // Generate a random position index
	    int randomPosition = randomNumberGenerator(3, 0);

	    // Generate a random name for the new player
	    String name = playerNamesForRandomPersonBeingAdded[nameGenerators.nextInt(15)];

	    // Create a new player with default initial stats, random name, random position, and reserve status set to false
	    Player selectedPlayer = new Player(100, 0, 0, 0, name, positions[randomPosition], false, false);

	    // Choose a random name that is not already used
	    String randomName = chooseRandomPlayerName(name);

	    // Add the chosen random name to the list of used names
	    usedRandomNames.add(randomName);

	    // Set initial stats for the selected player
	    setPlayerStat(selectedPlayer);

	    // Check the team size and add the selected player based on the conditions
	    if (SignUpShop.playerList.player.size() < 4 || SignUpShop.playerList.player.size() >= 0) {
	        // Generate random numbers
	        int random = randomNumberGenerator(10, 0);
	        int random2 = randomNumberGenerator(10, 0);

	        if (random == random2) {
	            // Add the selected player to the team
	            SignUpShop.playerList.player.add(selectedPlayer);
	            // Add a notice to the notice collector
	            GameMenu.noticeCollecter.add(selectedPlayer.getName() + " has been added to the team");
	        }
	    }
	    if (SignUpShop.playerList.player.size() < 6 || SignUpShop.playerList.player.size() >= 4) {
	        // Generate random numbers
	        int random = randomNumberGenerator(20, 0);
	        int random2 = randomNumberGenerator(20, 0);

	        if (random == random2) {
	            // Add the selected player to the team
	            SignUpShop.playerList.player.add(selectedPlayer);
	            // Add a notice to the notice collector
	            GameMenu.noticeCollecter.add(selectedPlayer.getName() + " has been added to the team");
	        }
	    }
	    if (SignUpShop.playerList.player.size() < 8 || SignUpShop.playerList.player.size() >= 6) {
	        // Generate random numbers
	        int random = randomNumberGenerator(30, 0);
	        int random2 = randomNumberGenerator(30, 0);

	        if (random == random2) {
	            // Add the selected player to the team
	            SignUpShop.playerList.player.add(selectedPlayer);
	            // Add a notice to the notice collector
	            GameMenu.noticeCollecter.add(selectedPlayer.getName() + " has been added to the team");
	        }
	    }
	    if (SignUpShop.playerList.player.size() == 8) {
	        // Generate random numbers
	        int random = randomNumberGenerator(40, 0);
	        int random2 = randomNumberGenerator(40, 0);

	        if (random == random2) {
	            // Add the selected player to the team
	            SignUpShop.playerList.player.add(selectedPlayer);
	            // Add a notice to the notice collector
	            GameMenu.noticeCollecter.add(selectedPlayer.getName() + " has been added to the team");
	        }
	    }
	}

	/**
	 * Finds the index of the specified player in the player list.
	 *
	 * @param player The player whose index needs to be found.
	 * @return The index of the player, or -1 if the player is not found.
	 */
	public static int findPlayerIndex(Player player) {
	    int count = -1;
	    for (Player playerIndex : SignUpShop.playerList.player) {
	        count += 1;
	        if (playerIndex.getName().equals(player.getName())) {
	            break;
	        }
	    }
	    return count;
	}

	/**
	 * Triggers a random event where a player is removed from the squad.
	 */
	public static void triggerRandomEventOfPlayerBeingRemoved() {
	    int smallestInteger = 100;
	    Player selectedPlayer = new Player(0, 0, 0, 0, "", "", false, false);
	    int value = randomNumberGenerator(SignUpShop.playerList.player.size() * 2 + probabilityFactor - 60, 0);
	    int value2 = randomNumberGenerator(SignUpShop.playerList.player.size() * 2 + probabilityFactor - 60, 0);
	    
	    // Find the player with the smallest stamina value in their stamina record
	    for (Player player : SignUpShop.playerList.player) {
	        if (player.playerStaminaRecord.size() > 0) {
	            for (int integer : player.playerStaminaRecord) {
	                if (integer <= smallestInteger) {
	                    selectedPlayer = player;
	                    smallestInteger = integer;
	                }
	            }
	        }
	    }
	    
	    // If no player has a stamina record or all stamina values are 100, select a random player
	    if (smallestInteger == 100) {
	        selectedPlayer = SignUpShop.playerList.player.get(randomNumberGenerator(SignUpShop.playerList.player.size() - 1, 0));
	    }
	    
	    // If the randomly generated values are equal, remove the selected player from the squad
	    if (value == value2) {
	        int playerIndex = findPlayerIndex(selectedPlayer);
	        if (playerIndex >= 0) {
	            GameMenu.noticeCollecter.add(SignUpShop.playerList.player.get(playerIndex).getName() + " has been removed from the squad");
	            SignUpShop.playerList.player.remove(playerIndex);
	        }
	    }
	}

	/**
	 * Generates a random number between the given minValue (inclusive) and maxValue (exclusive).
	 *
	 * @param maxValue The upper bound (exclusive) for the generated random number.
	 * @param minValue The lower bound (inclusive) for the generated random number.
	 * @return The generated random number.
	 */

	public static int randomNumberGenerator(int maxValue, int minValue) {
		int value = random.nextInt((maxValue - minValue)) + minValue;
		return value;
	}

	/**
	 * Finds the player with the most matches played.
	 * 
	 * @return The index of the player with the most matches played.
	 */
	public static int findThePlayerWithMostMatchesPlayed() {
	    int highest = 0;
	    int counter = 0;
	    int index = 0;
	    
	    // Iterate over the player list to find the player with the highest number of matches played
	    for (Player player : SignUpShop.playerList.player) {
	        if (player.playerStaminaRecord.size() >= counter) {
	            counter = player.playerStaminaRecord.size();
	        }
	    }
	    
	    // If no matches have been played or all players have played 15 matches, choose a random player
	    if (counter == 0 || counter == 15) {
	        index = randomNumberGenerator(SignUpShop.playerList.player.size() - 1, 0);
	    } 
	    // Otherwise, find the player with the highest number of matches played and return their index
	    else {
	        for (Player player : SignUpShop.playerList.player) {
	            index += 1;
	            if (player.playerStaminaRecord.size() == counter) {
	                break;
	            }
	        }
	    }
	    
	    return index;
	}


	/**
	 * Triggers a random event where a player's stats are increased.
	 */
	public static void triggerRandomEventOfPlayerStatIncreasing() {
	    // Find the player with the most matches played
	    int value = findThePlayerWithMostMatchesPlayed();
	    
	    // Generate two random numbers for comparison
	    int randomness = randomNumberGenerator(probabilityFactor, 0);
	    int randomness2 = randomNumberGenerator(probabilityFactor, 0);
	    
	    // If the two random numbers are equal, increase the player's stats
	    if (randomness == randomness2) {
	        Player player = SignUpShop.playerList.player.get(value);
	        player.setOffense(player.offense() + randomNumberGenerator(25, 5));
	        player.setDefence(player.defence() + randomNumberGenerator(25, 5));
	        
	        // If the player's position is 'goal keeper', increase their goal keeper reflex stat
	        if (player.getPosition().equals("goal keeper")) {
	            player.setDefence(player.goalKeeperReflex() + randomNumberGenerator(25, 5));
	        }
	        
	        SignUpShop.playerList.player.set(value, player);
	        GameMenu.noticeCollecter.add(player.getName() + " stats have increased");
	    }
	}

}