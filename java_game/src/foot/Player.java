/**

The 'foot' package contains classes related to foot-related activities or components.
This package includes the necessary imports to access the 'ClubRoom' and 'GameMenu' classes from the 'game_main_menu' package.
Additionally, the 'ArrayList' class from the Java util library is imported, suggesting that this package might involve working with collections.
It is important to provide more detailed comments within the code to explain the purpose, functionality, and usage of the classes and methods within the package.
*/


package foot;

import java.util.ArrayList;

import game_main_menu.ClubRoom;
import game_main_menu.GameMenu;

/**
 * 
 * The Stats interface defines methods for retrieving and updating player statistics.
 */
interface Stats {
	/**
	 * Retrieves the player's status.
	 * 
	 * @return The player's status.
	 */
	String getstatus();

	/**
	 * Retrieves the player's stamina.
	 * 
	 * @return The player's stamina.
	 */
	int stamina();

	/**
	 * Retrieves the player's defense.
	 * 
	 * @return The player's defense.
	 */
	int defence();

	/**
	 * Retrieves the player's offense.
	 * 
	 * @return The player's offense.
	 */
	int offense();

	/**
	 * Retrieves the player's goalkeeper reflex.
	 * 
	 * @return The player's goalkeeper reflex.
	 */
	int goalKeeperReflex();

	/**
	 * Sets the player's reflex.
	 * 
	 * @param reflexs The new reflex value.
	 */
	void setPlayerreflex(int reflexs);

	/**
	 * Sets the player's stamina.
	 * 
	 * @param st The new stamina value.
	 */
	void setStamina(int st);

	/**
	 * Sets the player's offense.
	 * 
	 * @param Off The new offense value.
	 */
	void setOffense(int Off);

	/**
	 * Sets the player's defense.
	 * 
	 * @param def The new defense value.
	 */
	void setDefence(int def);

	/**
	 * Checks if the player is a reserve player.
	 * 
	 * @return True if the player is a reserve player, false otherwise.
	 */
	boolean isReserve();

	/**
	 * Checks if the player is a professional player.
	 * 
	 * @return True if the player is a professional player, false otherwise.
	 */
	boolean isPro();

	/**
	 * Sets the reserve status of the player.
	 * 
	 * @param reserveUpdate The reserve status of the player.
	 */
	void setReserve(boolean reserveUpdate);

	/**
	 * Retrieves the player's position.
	 * 
	 * @return The player's position.
	 */
	String getPosition();

	/**
	 * Retrieves the player's name.
	 * 
	 * @return The player's name.
	 */
	String getName();

	/**
	 * Updates the player's health based on the damage taken.
	 * 
	 * @param damage The damage taken.
	 */
	void damageTaken(int damage);

	/**
	 * Sets the player's name.
	 * 
	 * @param name The player's name.
	 */
	void setName(String name);

	/**
	 * Checks if the player has a weekly pass for the left defender position.
	 * 
	 * @return The player's weekly pass status for the left defender position.
	 */
	String hasWeeklyPassForLeftDefender();

	/**
	 * Sets the player's weekly pass status for the left defender position.
	 * 
	 * @param setter The weekly pass status for the left defender position.
	 */
	void setWeeklyPassForLeftDefenders(boolean setter);

	/**
	 * Performs the weekly pass action for the left defender position.
	 */
	void weeklyPassForLeftDefenders();

	/**
	 * Checks if the player has a weekly pass for the right defender.
	 * 
	 * @return The player's weekly pass status for the right defender.
	 */
	String hasWeeklyPassForRightDefender();

	/**
	 * Sets the player's weekly pass status for the right defender .
	 * 
	 * @param setter The weekly pass status for the right defender .
	 */
	void setWeeklyPassForRightDefenders(boolean setter);
	/**
	 * Performs the weekly pass action for the right defender.
	 */
	void weeklyPassForRightDefenders();

	/**
	 * Checks if the player has a weekly pass for the goalkeepers.
	 * 
	 * @return The player's weekly pass status for the goalkeepers.
	 */
	String hasWeeklyPassForGoalKeepers();

	/**
	 * Sets the player's weekly pass status for the goalkeepers.
	 * 
	 * @param setter The weekly pass status for the goalkeepers.
	 */
	void setWeeklyPassForGoalKeepers(boolean setter);

	/**
	 * Performs the weekly pass action for the goalkeepers.
	 */
	void weeklyPassForGoalKeepers();

	/**
	 * Checks if the player has a weekly pass for the attacker position.
	 * 
	 * @return The player's weekly pass status for the attacker position.
	 */
	String hasWeeklyPassForAttacker();

	/**
	 * Sets the player's weekly pass status for the attacker position.
	 * 
	 * @param setter The weekly pass status for the attacker position.
	 */
	void setWeeklyPassForAttacker(boolean setter);

	/**
	 * Performs the weekly pass action for the attacker position.
	 */
	void weeklyPassForAttacker();

	/**
	 * Activates the protein supplement for the player.
	 */
	void isProteinSuppliement();

	/**
	 * Checks if the player has a protein supplement activated.
	 * 
	 * @return The player's protein supplement status.
	 */
	String hasProteinSuppliement();

	/**
	 * Sets the player's protein supplement status.
	 * 
	 * @param setter The protein supplement status.
	 */
	void setProteinSuppliement(boolean setter);

	/**
	 * Sets the player's nickname.
	 * 
	 * @param nicknam The player's nickname.
	 */
	void setnickName(String nicknam);

	/**
	 * Retrieves the player's nickname.
	 * 
	 * @return The player's nickname.
	 */
	String getnickName();
}


/**
 *  Player class represents a player in the game.
 *  It extends the Team class and implements the Stats interface.
 *  This class encapsulates the attributes and behaviors of a player.
 * 
 * @author  Jack Kuruvilla
 */
public class Player extends Team implements Stats{

	/**
	 * Represents the stamina level of the player.
	 */
	private int stamina;

	/**
	 * Represents the offensive ability of the player.
	 */
	private int Offense;

	/**
	 * Represents the defensive ability of the player.
	 */
	private int defence;

	/**
	 * Represents the reflex ability of the player.
	 */
	private int reflex;

	/**
	 * Stores the historical records of stamina levels for the player.
	 */
	public ArrayList<Integer> playerStaminaRecord = new ArrayList<Integer>();

	/**
	 * Represents the position of the player in the team.
	 */
	private String position;

	/**
	 * Represents the name of the player.
	 */
	public String name;

	/**
	 * Indicates whether the player is a reserve player or not.
	 */
	private boolean reserve;

	/**
	 * Indicates whether the player is a professional player or not.
	 */
	private boolean isPro;

	/**
	 * Represents the nickname of the player.
	 */
	private String nickName = "";

	/**
	 * Indicates whether a weekly training pass for goalkeepers is available for the player.
	 */
	public boolean isWeeklyPassGoallyAvaialble = false;

	/**
	 * Indicates whether a weekly training pass for left defenders is available for the player.
	 */
	public boolean isWeeklyPassLeftDefence = false;

	/**
	 * Indicates whether a weekly training pass for right defenders is available for the player.
	 */
	public boolean isWeeklyPassRightDefence = false;

	/**
	 * Indicates whether a weekly training pass for attackers is available for the player.
	 */
	public boolean isWeeklyPassOffenseAvaialble = false;

	/**
	 * Indicates whether a protein suppliemnet is available for all the players.
	 */
	public boolean isProteinSupplimentAvaialble = false;

	/**
	 * constructor use to initial the player attributes.
	 * @param sta random stamina stat generated for the player.
	 * @param off random offence stat generated for the player.
	 * @param def random defence stat generated for the player.
	 * @param names the name of the player.
	 * @param posi the position the player is playing for.
	 * @param isReserve whether the player is a reseve.
	 * @param pro whether the player is a pro player.
	 */
	
	public Player(int sta, int off, int def, String names, String posi, boolean isReserve,boolean pro)
	{
		
		stamina = sta;
		Offense = off;
		defence = def;
		name = names;
		position = posi;
		reserve = isReserve;
		isPro = pro;
	}
	
	/**
	 * // Constructor for the Player class with additional reflex parameter for goalkeepers.
	    // Initializes a player with the given attributes.
	 * @param reflexs the reflex of the goalkeeper.
	 * @param sta random stamina stat generated for the goalkeeper.
	 * @param off random offence stat generated for the goalkeeper.
	 * @param def random defence stat generated for the goalkeeper.
	 * @param names the name of the goalkeeper.
	 * @param posi the position the player is goalkeeper for.
	 * @param isReserve whether the player is a reseve.
	 * @param pro whether the player is a pro goalkeeper.
	 */
	public Player(int sta, int off, int def,int reflexs, String names, String posi,boolean isReserve, boolean pro)
	{
		
		reflex = reflexs;
		stamina = sta;
		Offense = off;
		defence = def;
		name = names;
		position = posi;
		reserve = isReserve;
		isPro = pro;
	}

	/**
	 * the following methods Retrieve parameters values 
	 * and reset the attributes these are specfic to the 
	 * players and hence need unique to the player
	 */
	public void setnickName(String nicknam)
	{
		
		nickName = nicknam;
	}
	public String getnickName()
	{
		
		return nickName;
	}
	
	public String getName()
	{
		return name;
	}
	public int stamina()
	{
		return stamina;
	}
	public int defence()
	{
		return defence;
	}
	public int offense()
	{
		return Offense; 
	}
	
	/**
	 * the following methods are part of the 
	 * stats inteface implements by the player class
	 * this enables easier parametrizing of variables 
	 * spefically those that are impacted by game results 
	 * and the use of items throughout the game. 
	 * ie when the player purchases and implements weekly training passes
	 *
	 */
	
	@Override
	public int goalKeeperReflex()
	{
		return reflex;
	}

	@Override
	public String getstatus() {
		return ""+name+"\nstamina: " +stamina +"\nOffense: " +Offense +"\ndefence: " + defence;
		
	}
	public String toString()
	{
		return name;
	
	}
	
	@Override
	public void setName(String nam) {
		// TODO Auto-generated method stub

		name = nam;
	}

	@Override
	public void setPlayerreflex(int reflexs) {
		if(reflexs  >= 100)
		{
			reflex = 100;
		}
		else {
		reflex = reflexs;
		}
		
	}
	
	@Override
	public void setStamina(int st) {
		if(st >= 100)
		{
			stamina = 100;
		}
		else {
		stamina = st;
		}
		
	}

	@Override
	public void setOffense(int Off) {
		if (Off >= 100)
		{
			Offense = 100;
		}
		else {
		Offense = Off;
		}
		
	}

	@Override
	public void setDefence(int def) {
		if(def >= 100)
		{
			defence = 100;
		}
		else {
		defence = def;
		}
		
	}
	@Override
	public String getPosition() {
		return position;
		
	}

	@Override
	public boolean isReserve() {
		return reserve;
		
	}
	
	

	/**
	 * the following weeklyPass methods (and the proteinSupplment methods)
	 * also belong to the Stats interface and are implemented
	 * by the player class. As evident by the methods names
	 * the following are specfically used when the player purchases
	 * and applies the weeklytrainingpasses to the player.
	 * the setter methods set the boolean varaibles true or false
	 * depending on when the player purchases and implements the passes 
	 * or the protein supplmenet to the player. 
	 * 
	 * the ClubRoom is also used to access the number of the passes that 
	 * are avaiable to the player and are cruital to activate the 
	 * impact of the passes. 
	 * 
	 * 
	 * depending on the type of method called the stamina or the offense/ defence/ reflex 
	 * are incremented. 
	 * 
	 * the amount that is incremented is also depended on the difficulty set the player 
	 * in the gameloginpage which simply detected by a value that was passed onto 
	 * the GameMenu Class by the LoginPage class after the login was successful. 
	 */
	@Override
	public void weeklyPassForAttacker() {
		if(ClubRoom.numberOfWeeklyPassesForAttackers > 0)
		{
		if(this.isWeeklyPassOffenseAvaialble == true)
		{
			if(GameMenu.currentWeek < GameMenu.duration && stamina >= 0)
			{
				if(GameMenu.difficulty == 1)
				{
				stamina += 15;
				setStamina(stamina); 
				Offense += 15;
				setOffense(stamina);
				defence += 0;
				}
				if(GameMenu.difficulty == 2)
				{
				stamina += 15;
				setStamina(stamina);
				Offense += 10;
				setOffense(stamina);
				defence += 0;
				}
				if(GameMenu.difficulty == 3)
				{
				stamina += 15;
				setStamina(stamina);
				Offense += 5;
				setOffense(stamina);
				defence += 0;
				}
				
			
			}
		}
		
		ClubRoom.numberOfWeeklyPassesForAttackers -=1;
		}
	}
	
	@Override
	public void weeklyPassForLeftDefenders() {

		if(isWeeklyPassLeftDefence == true)
		{
			if(GameMenu.currentWeek < GameMenu.duration && stamina >= 0)
			{
				if(GameMenu.difficulty == 1)
				{
				stamina += 15;
				setStamina(stamina);
				Offense += 0;
				defence += 15;
				setDefence(defence);
				}
				if(GameMenu.difficulty == 2)
				{
				stamina += 15;
				setStamina(stamina);
				Offense += 0;
				defence += 10;
				setDefence(defence);
				}
				if(GameMenu.difficulty == 3)
				{
				stamina += 15;
				setStamina(stamina);
				Offense += 0;
				defence += 5;
				setDefence(defence);
				}
				
			}
		}
		
		ClubRoom.numberOfWeeklyPassesForDefenders -=1;
		
	}


	@Override
	public void weeklyPassForRightDefenders() {
		if(isWeeklyPassRightDefence == true)
		{
			if(GameMenu.currentWeek < GameMenu.duration && stamina >= 0)
			{
				if(GameMenu.difficulty == 1)
				{
				stamina += 15;
				setStamina(stamina);
				Offense += 0;
				defence += 15;
				setDefence(defence);
				}
				if(GameMenu.difficulty == 2)
				{
				stamina += 15;
				setStamina(stamina);
				Offense += 0;
				defence += 10;
				setDefence(defence);
				}
				if(GameMenu.difficulty == 3)
				{
				stamina += 15;
				setStamina(stamina);
				Offense += 0;
				defence += 5;
				setDefence(defence);
				}
				
			}
		}
		
		ClubRoom.numberOfWeeklyPassesForDefenders -=1;
		
	}


	@Override
	public void weeklyPassForGoalKeepers() {

		if(isWeeklyPassGoallyAvaialble == true)
		{
			if(GameMenu.currentWeek < GameMenu.duration && stamina >= 0)
			{
				if(GameMenu.difficulty == 1)
				{
				stamina += 15;
				setStamina(stamina);
				reflex += 15;
				setPlayerreflex(reflex);
				}
				if(GameMenu.difficulty == 2)
				{
				stamina += 15;
				setStamina(stamina);
				reflex += 10;
				setPlayerreflex(reflex);
				}
				if(GameMenu.difficulty == 3)
				{
				stamina += 15;
				setStamina(stamina);
				reflex += 5;
				setPlayerreflex(reflex);
				}
				
			}
		}
		ClubRoom.numberOfWeeklPassesForGoalkeeper -=1;
		
	}
	
	/**
	 * isProteinSuppliment method that increments the stamina,defence or the offense of the player depending on the type of player.
	 */

	@Override
	public void isProteinSuppliement() {
		
	
		if (isProteinSupplimentAvaialble == true)
		{
			stamina += 25;
			if(this.getPosition() == "left defender" || this.getPosition() == "right defender")
			{
				incrementStat(defence);
			}
			if(this.getPosition() == "attacker")
			{
				incrementStat(Offense);
			}
			if(this.getPosition() == "goal keeper")
			{
				incrementStat(reflex);
				
			}
		}
		ClubRoom.numberOfProteinSuppliements -= 1;
		
	}
	/**
	 * 
	 * increments Stat
	 * 
	 * @param value that is passed onto the method by the isProteinSuppliment method.
	 * this allows for the method to incrmeent values of the given stat by a certain amount.
	 * depending on the GameDifficulty. 
	 * 
	 */
	public void incrementStat(int value)
	{
		if(GameMenu.difficulty == 1)
		{
		value += 7;
		setPlayerreflex(value);
		}
		if(GameMenu.difficulty == 2)
		{
		value += 5;  
		setPlayerreflex(value);
		}
		if(GameMenu.difficulty == 3)
		{
		value += 3;
		setPlayerreflex(value);
		}
	}
	
	
	@Override
	public String hasWeeklyPassForLeftDefender() {
		String comfirmation = "no";
		if (this.getPosition() == "left defender")
		{
			if(this.isWeeklyPassLeftDefence == true)
			{
				comfirmation = "yes";
			}
		}
		return comfirmation;
		
	}

	@Override
	public String hasWeeklyPassForRightDefender() {
		

		String comfirmation = "no";
		if (this.getPosition() == "right defender")
		{
			if(this.isWeeklyPassRightDefence == true)
			{
				comfirmation = "yes";
			}
		}
		return comfirmation;
	}

	@Override
	public String hasWeeklyPassForGoalKeepers() {
		String comfirmation = "no";
		if (getPosition() == "goal keeper")
		{
			if(this.isWeeklyPassGoallyAvaialble == true)
			{
				comfirmation = "yes";
			}
		}
		return comfirmation;
		
	}

	@Override
	public String hasWeeklyPassForAttacker() {
		String comfirmation = "no";
		if (getPosition() == "attacker")
		{
			if(this.isWeeklyPassOffenseAvaialble == true)
			{
				comfirmation = "yes";
			}
		}
		return comfirmation;
		
	}


	@Override
	public String hasProteinSuppliement() {
		
		String comfirmation = "no";
		if (isProteinSupplimentAvaialble == true)
		{
			comfirmation = "yes"; 
		}
		return comfirmation;
	}
	
	/**
	 * the follwing set methods set the weeklyPass boolean variables 
	 * to true or false depending on when they are pruchased or implmeented
	 * on the players or returned back to the market.
	 */

	@Override
	public void setWeeklyPassForLeftDefenders(boolean setter) {
		isWeeklyPassLeftDefence = setter;
		
	}

	@Override
	public void setWeeklyPassForGoalKeepers(boolean setter) {
		isWeeklyPassGoallyAvaialble = setter;
		
	}

	@Override
	public void setWeeklyPassForAttacker(boolean setter) {
		isWeeklyPassOffenseAvaialble = setter;
		
	}

	@Override
	public void setProteinSuppliement(boolean setter) {
		isProteinSupplimentAvaialble = setter;
		
	}
	@Override
	public void setWeeklyPassForRightDefenders(boolean setter) {
		isWeeklyPassRightDefence = setter;
		
	}

	/**
	 * the following methods are also part of 
	 * stats inteface.
	 * 
	 * the damage Taken method simply decrements the stamina 
	 * and sets it to 0 if the stamina goes below zero.
	 * 
	 * the setReserve sets the player to a reserve boolean varaible to reserve
	 * when the player is added to the reserve list. 
	 * 
	 * the isPro is used to check if the player is is proplayer or not.
	 */

	@Override
	public void damageTaken(int damage) {
		stamina -= damage;
		if (stamina < 0)
		{
			stamina = 0;
		}
			
	}

	@Override
	public void setReserve(boolean reserveUpdate) {
		
		reserve = reserveUpdate;
	}

	@Override
	public boolean isPro() {
		
		return isPro;
	}

	
	
}
