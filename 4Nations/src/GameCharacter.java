public class GameCharacter {
	private char affinity; //Egyptian, Persian, Roman, or Greek
	private String name;
	private int attack;
	private int maxVitality;
	private int currentVitality;
	private int speed;
	private int level;
	private Attack[] Attacks;
	
	public GameCharacter(char affinity, String name, int attack, int vitality, int speed, Attack[] Attacks) {
		this.affinity = affinity;
		this.name = name;
		this.attack = attack;
		this.maxVitality = vitality;
		this.currentVitality = vitality;
		this.speed = speed;
		this.Attacks = new Attack[Attacks.length];
		for (int i = 0; i < Attacks.length; i++) {
			this.Attacks[i] = Attacks[i];
		}
	}
	/**
	 * I needed this as well
	 */
	public GameCharacter() {
		
	}
	/**
	 * I needed this too :)
	 * @param numWin
	 */
	public GameCharacter(Integer numWin) {
		
	}
	public GameCharacter(GameCharacter that) {
		this.affinity = that.getAffinity();
		this.name = that.getName();
		this.attack = that.getAttack();
		this.maxVitality = that.getMaxVitality();
		this.currentVitality = that.getCurVitality();
		this.speed = that.getSpeed();
		Attack[] thatAttacks = that.getAttacks();
		this.Attacks = new Attack[thatAttacks.length];
		for (int i = 0; i < Attacks.length; i++) {
			this.Attacks[i] = thatAttacks[i];
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getCurVitality() {
		return currentVitality;
	}
	public void setCurVitality(int vitality) {
		this.currentVitality = vitality;
	}
	public int getMaxVitality() {
		return maxVitality;
	}
	public void setMaxVitality(int vitality) {
		this.maxVitality = vitality;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public char getAffinity() {
		return affinity;
	}
	public void setAffinity(char affinity) {
		this.affinity = affinity;
	}
	public int getLevel() {
		return level;
	}
	/** Increments level member variable
	 */
	public void incrementLevel() {
		level++;
	}
	/** Simulates using an attack.
	 * @param attackNum - the index of the attack within Attacks
	 * @return number of damage to be dealt; negative values are self-restoring rather than damaging
	 */
	public int useAttack(int attackNum) {
		int force = getAttacks()[attackNum].findAttackDamage();
		return ((force > 0) ? getAttack() + force : getAttack() - force);
	}
	
	public void useAttack(int attackNum, GameCharacter o) {
		int force = getAttacks()[attackNum].findAttackDamage();
		if (force > 0) {
			o.takeDamage(force + getAttack());
		}
		else {
			this.takeDamage(force - getAttack());
		}
	}
	
	/** Simulates taking damage by reducing vitality by set amount.
	 * @param numDamage - the amount of damage to be taken
	 */
	public void takeDamage(int numDamage) {
		if(numDamage > currentVitality) {
			setCurVitality(0);
		}
		else if(numDamage < 0 && Math.abs(numDamage) > (maxVitality - currentVitality)){
			setCurVitality(maxVitality);
		}
		else {
			setCurVitality(getCurVitality() - numDamage);
		}
	}
	public String getAttackInfo(int attackNum) {
		return Attacks[attackNum].getInfo();
	}
	public Attack[] getAttacks() {
		return this.Attacks;
	}
}
