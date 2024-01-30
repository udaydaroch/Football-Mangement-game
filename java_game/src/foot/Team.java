package foot;

import java.util.ArrayList;
import java.util.Map.Entry;

import game_main_menu.ClubRoom;
import game_main_menu.GameMenu;
import game_main_menu.Market;
import game_start_and_login_page.SignUpShop;

/** 
 * class representing a team that is used to set up player and oppoment team players.
 * 
 * uses default constuctor
 * @author  Jack Kuruvilla
 *
 */
public class Team {
	
	/**
	 * Default construct for the team class which constructs the team object wiohut any 
	 * specific initialization of variables 
	 */
	public Team()
	{
		
	}
	/**
	 * Represents the team name.
	 */
	public static String teamName;

	/**
	 * Represents the list of players in the team.
	 */
	public static ArrayList<Player> player = new ArrayList<Player>();

	/**
	 * Represents the list of opponents.
	 */
	public ArrayList<Player> opponents = new ArrayList<Player>();

	/**
	 * Represents the opponent team name.
	 */
	private String opponentTeamName;

	/**
	 * Represents the list of players with zero stamina.
	 */
	public static ArrayList<Player> zeroStaminaPlayers;

	/**
	 * Represents the list of players with zero stamina for reserve players.
	 */
	private ArrayList<Player> zeroStaminaForReservePlayer;


    /**
     *  Getter and setter for opponent team name
     * @return opponentTeamName the name of the opponentTeam.
     */
    public String getOpponentTeamName() {
        return opponentTeamName;
    }

    /**
     * sets the name of the opponent team before the game takes place
     * @param opponentTeam the name passed onto the function that sets the name of the opponentTeamname.
     */
    public void setOpponentTeamName(String opponentTeam) {
        opponentTeamName = opponentTeam;
    }

    /**
     *  Method to check if the team has no full squad and no reserves to substitute.
     * @return the boolean variable that has been assigned whether the next gave will have enough players.
     */
    public boolean checkIfNoFullSquadAndNoReservesToSubstitudeFound() {
        boolean notEnoughPlayer = true;
        boolean hasAtLeastOneGoalKeeper = false;
        boolean hasAtLeastOneLeftDefender = false;
        boolean hasAtLeastOneRightDefender = false;
        boolean hasAtLeastOneAttacker = false;
        int numOfAttacker = 0;
        int numOfLeftDefender = 0;
        int numOfRightDefender = 0;
        int numOfGoalKeeper = 0;

        // Count the number of players in each position
        for (Player player : SignUpShop.playerList.player) {
            if (player.getPosition() == "goal keeper") {
                numOfGoalKeeper += 1;
            }
            if (player.getPosition() == "left defender") {
                numOfLeftDefender += 1;
            }
            if (player.getPosition() == "right defender") {
                numOfRightDefender += 1;
            }
            if (player.getPosition() == "attacker") {
                numOfAttacker += 1;
            }
        }

        // Check if there is at least one player in each position
        if (numOfRightDefender >= 1) {
            hasAtLeastOneRightDefender = true;
        }
        if (numOfAttacker >= 1) {
            hasAtLeastOneAttacker = true;
        }
        if (numOfGoalKeeper >= 1) {
            hasAtLeastOneGoalKeeper = true;
        }
        if (numOfLeftDefender >= 1) {
            hasAtLeastOneLeftDefender = true;
        }

        // Check if all positions have at least one player
        if (hasAtLeastOneRightDefender == false &&
                hasAtLeastOneAttacker == false &&
                hasAtLeastOneLeftDefender == false &&
                hasAtLeastOneGoalKeeper == false) {
            notEnoughPlayer = true;
        } else if (hasAtLeastOneRightDefender == true &&
                hasAtLeastOneAttacker == true &&
                hasAtLeastOneLeftDefender == true &&
                hasAtLeastOneGoalKeeper == true) {
            notEnoughPlayer = false;
        }

        return notEnoughPlayer;
    }

    /** Method to check if the team has no full squad and no reserves to substitute
     * 
     * @return hasEnoughMoney to buy a player
     */
    public boolean notFullSquadAndNoReservesToSubstitude() {
        boolean hasEnoughMoney = false;

        // Check if the team has a full squad and reserves
        if (checkIfNoFullSquadAndNoReservesToSubstitudeFound() == false) {
            // Check if the team has enough money to purchase players
            if (GameMenu.money < GameMenu.market.proPlayerPurchasePrice) {
                if (GameMenu.money < GameMenu.market.normalPlayerPurchasePrice) {
                    // Check if potential money can be made after returning items
                    if (potentialMoneyCanBeMadeAfterReturningItems() == true) {
                        hasEnoughMoney = true;
                    } else {
                        hasEnoughMoney = false;
                    }
                } else {
                    hasEnoughMoney = true;
                }
            } else {
                hasEnoughMoney = true;
            }
        } else {
            hasEnoughMoney = true;
        }

        return hasEnoughMoney;
    }

    /** Method to decide whether to play or not
     * 
     * @return play boolean that tells whether the game can be continued
     */
    public boolean PlayDecide() {
        boolean play = true;

        // Check if stamina is good and there are enough players and reserves
        if (checkIfStaminaGood() == false || notFullSquadAndNoReservesToSubstitude() == true) {
            play = false;
        }

        return play;
    }

    /** Method to check if the stamina of players is good
     * 
     * @return good boolean that returns true if all players have stamina to contnue the game
     */
    public boolean checkIfStaminaGood() {
        boolean good = false;

        // Update player squad in the club
        GameMenu.club.updatePlayerSquad();

        zeroStaminaPlayers = new ArrayList<Player>();

        // Check players with zero stamina
        for (Object player : ClubRoom.playingFour) {
            if (((Player) player).stamina() == 0) {
                zeroStaminaPlayers.add((Player) player);
            }
        }

        // Check if there is enough money to purchase stamina items
        if (GameMenu.money < zeroStaminaPlayers.size() * GameMenu.market.ItemPrice) {
            if (GameMenu.money + next_check() < zeroStaminaPlayers.size() * GameMenu.market.ItemPrice) {
                good = false;
            } else {
                good = true;
            }
        } else {
            good = true;
        }

        return good;
    }

    /** Method to perform the next check for players with zero stamina
     * 
     * @return amount of many that can be made by returning all the items in inventory.
     */
    public int next_check() {
        int counterNumOfPlayerWithZeroStamina = 0;
        zeroStaminaPlayers = new ArrayList<Player>();
        zeroStaminaForReservePlayer = new ArrayList<Player>();

        // Check players with zero stamina among the reserves
        for (Object player : ClubRoom.reserves) {
            for (Player playerWithZeroStam : zeroStaminaPlayers) {
                if (playerWithZeroStam.getPosition() == ((Player) player).getPosition()) {
                    if (((Player) player).stamina() == 0) {
                        zeroStaminaForReservePlayer.add((Player) player);
                    }
                }
            }
        }

        String ProteinSuppliement = "";
        String AttackerPass = "";
        String DefencePass = "";
        String GoalKeeperPass = "";
        int amountThatCanBeMade = 0;

        // Calculate the amount that can be made to get players to non-zero stamina
        for (Player player : zeroStaminaForReservePlayer) {
            if (player.getPosition() == "left defender" || player.getPosition() == "right defender") {
                amountThatCanBeMade += ReturnMoneyRequiredToGetPlayerToNonZero(ProteinSuppliement, DefencePass);
            }
            if (player.getPosition() == "goal keeper") {
                amountThatCanBeMade += ReturnMoneyRequiredToGetPlayerToNonZero(ProteinSuppliement, GoalKeeperPass);
            }
            if (player.getPosition() == "attacker") {
                amountThatCanBeMade += ReturnMoneyRequiredToGetPlayerToNonZero(ProteinSuppliement, AttackerPass);
            }
        }

        return amountThatCanBeMade;
    }

    /**Method to return the money required to get a player to non-zero stamina
     * 
     * @param proteinSuppliment the number of proteinsupplements that are purchased
     * @param SpecificPass the number of a specific pass (out of all the ones avaialble).
     * @return amount of money required to get player to non-zero stamina.
     */
    public static int ReturnMoneyRequiredToGetPlayerToNonZero(String proteinSuppliment, String SpecificPass) {

        int numOfProteinSuppliments = 0;
        int numOfSpecFicPass = 0;
        Items SpecficPass = new Items("", 0);

        /**
         *  Check the number of protein supplements and specific passes in the inventory
         */
        for (Entry<String, Integer> Integer : Market.inventory.nameOfItems.entrySet()) {
            if (Integer.getKey() == proteinSuppliment) {
                numOfProteinSuppliments += Integer.getValue();
            }
            if (Integer.getKey() == SpecificPass) {
                SpecficPass = new Items(Integer.getKey(), Integer.getValue());
                numOfSpecFicPass += Integer.getValue();
            }
        }

        // Check the price of the specific pass
        for (Entry<Items, Integer> Integer : Market.inventory.itemsAvaiable.entrySet()) {
         

            if (Integer.getKey().getName() == SpecficPass.getName()) {
                SpecficPass.setPrice(Integer.getKey().currentPrize());
                
            }
        }
    
        int amount = (GameMenu.market.proteinSupplementItem.currentPrize() * numOfProteinSuppliments);
       
        amount += (SpecficPass.currentPrize() * numOfSpecFicPass);
       
        return amount;
    }

    /**
     *  Method to check if potential money can be made after returning items
     * @return hasEnoughMoney boolean confirms whether the player has enough money to return back items to buy a player.
     */
    public boolean potentialMoneyCanBeMadeAfterReturningItems() {
        int numOfGoalKeeperPass = 0;
        int numOfAttackerPass = 0;
        int numOfDefenderPass = 0;
        int numOfProteinSupply = 0;
        boolean hasEnoughMoney = false;

        /** Check the number of specific passes and protein supplements in the inventory
         * 
         */
        for (Entry<String, Integer> Integer : GameMenu.market.inventory.nameOfItems.entrySet()) {
            String name = Integer.getKey();
            if (name == "weekly training pass for goalkeepers") {
                numOfGoalKeeperPass += Integer.getValue();
            }
            if (name == "weekly training pass for defenders") {
                numOfDefenderPass += Integer.getValue();
            }
            if (name == "weekly training pass for strickers") {
                numOfAttackerPass += Integer.getValue();
            }
            if (name == "protein_suppliments") {
                numOfProteinSupply += Integer.getValue();
            }
        }

        int amount = GameMenu.market.weeklyTrainingPassForDefenceItem.currentPrize() * numOfDefenderPass;
        amount += GameMenu.market.weeklyTrainingPassForGoalkeeperItem.currentPrize() * numOfGoalKeeperPass;
        amount += GameMenu.market.weekyTrainingPassForAttackersItem.currentPrize() * numOfAttackerPass;
        amount += GameMenu.market.proteinSupplementItem.currentPrize() * numOfProteinSupply;

        // Check if there is enough money to purchase players
        if (amount + GameMenu.money < GameMenu.market.proPlayerPurchasePrice) {
            if (amount + GameMenu.money < GameMenu.market.normalPlayerPurchasePrice) {
                hasEnoughMoney = false;
            } else {
                hasEnoughMoney = true;
            }
        } else {
            hasEnoughMoney = true;
        }

        return hasEnoughMoney;
    }
}
