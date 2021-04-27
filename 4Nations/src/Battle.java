/**
 * 
 * @author STEIGERNA20
 * This is the class where battles between the player and computer is played in
 *
 */
import java.util.*;
//test
public class Battle {
	private boolean turn;
	private boolean loop;
	private GameCharacter player;
	private GameCharacter computer;
	Scanner input = new Scanner(System.in);
	/**
	 * constructs Battle
	 * sets advantages and the first turn
	 */
	public Battle(GameCharacter hero,GameCharacter villian) {
		turn = true;
		player = hero;
		computer = villian;
		loop = false;
		
	}
	/**
	 * The turn method determines who plays next depending on who played last
	 * also governs the current turn
	 * @return true or false depending on who plays next 
	 */
	public boolean turn() {
		if (this.turn = true) {
			this.turn = false;
			return this.turn;
		}
		else {
			this.turn = true;
			return this.turn;
		}
	}
	
	public boolean getTurn() {
		return this.turn;
	}
	/**
	 * The hasWon method determines a winner which will end the battle
	 * @return false if there is no loser and true when there is a winner
	 */
	public boolean hasWon() {
		if (player.getCurVitality() == 0) {
			return true;
		}
		else if (computer.getCurVitality() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * The hasAdvantage takes the affinity of the player and computer
	 * and gives the necessary advantages to either of them
	 * @param af1 - the player's affinity i.e. Roman, Greek, Persian, or Egyptian
	 * @param af2 - the computer's affinity
	 * @return true if the player has an advantage or false if the computer 
	 * has an advantage
	 */
	public boolean hasAdvantage(char af1, char af2) {//TODO
		return true;
	}
	/**
	 * This method will update the progress of the player
	 * The fighter the player uses, their stats will update and improve 
	 * Also The players save file will update.
	 * 
	 */
	public void updateData() {//TODO
		
	}
	/**
	 * This is the method where the actual battle will commence
	 * It will call upon the hasAdvantage() class to determine advantages given to
	 * the fighters.
	 * It will also call upon turn() to keep track of who is currently attacking
	 * It will also call upon hasWon() at the end of each turn to determine
	 * if there is a winner
	 * It will handle the attacks, speed, and success of the player's attack
	 */
	public void battleSequence() {
		
		while(loop == false) {
			if(getTurn() == true) {//Player's turn
				System.out.println("It is your turn.\nYour health is " + player.getCurVitality() + " Please select your attack");
				int selection = input.nextInt();
				player.attack(selection);
				int damage = Attack.findAttackDamage();
				if (damage >= 0) {
					computer.takeDamage(damage);
				}
				else {
					player.takeDamage(damage);
				}
				loop = hasWon();
				turn();
				
			}
			else {//Computer's Turn TODO
				
			}
		}
	}
}
