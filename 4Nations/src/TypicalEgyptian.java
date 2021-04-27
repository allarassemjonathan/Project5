import java.util.ArrayList;
import java.util.Random;

public class TypicalEgyptian extends GameCharacter{
	
	private final static int BASE_ATTACK = 0;
	private final static int BASE_VITALITY = 22;
	private final static int BASE_SPEED = 1;
	private final static char NATURAL_AFFINITY = 'E';

	final static int[][] D1 = {{4,2}};
	final static int[][] D2 = {{10,1}};
	final static int[][] D3 = {{12,2}};
	
	final static Attack A1 = new Attack(D1, false, false, 0);
	final static Attack A2 = new Attack(D2, false, true, 0);
	final static Attack A3 = new Attack(D3, true, false, 0);
	
	final static Attack[] ATTACKS = {A1, A2, A3};
	
	private GameCharacter opponent;
	
	final static String[] ALIASES = {"Ahmose", "Ammon", "Akhraten", "Amenhotep"
			, "Bek", "Cheops", "Djedi", "Hannu", "Imhotep", "Khayu", "Khufu",
			"Meketre", "Menkare", "Nebet", "Neferu", "Pabasa", "Senedj", "Seti"
			, "Thutmose"};
	
	public TypicalEgyptian(GameCharacter o) {
		super(NATURAL_AFFINITY, "", BASE_ATTACK, BASE_VITALITY, BASE_SPEED, ATTACKS);
	
		Random r = new Random();
		setName(ALIASES[r.nextInt(ALIASES.length)]);
		
		opponent = o;
		
		setAttack(BASE_ATTACK + o.getLevel());
		setMaxVitality(BASE_VITALITY + o.getLevel());
		setCurVitality(BASE_VITALITY + o.getLevel());
		setSpeed(BASE_SPEED + o.getLevel());
	
	}
	
	public int findBestAttackDamage() {
		
		ArrayList<Attack> possibleAttacks = new ArrayList<>();
		
		if(getCurVitality() < 10) {
			for (int i = 0; i < 15 - getCurVitality(); i++) {
				possibleAttacks.add(A2);
			}
		}
		
		for (int i = 0; i < 5; i++) {
			possibleAttacks.add(A1);
		}
		
		if(opponent.getCurVitality() == opponent.getMaxVitality()) {
			possibleAttacks.add(A3);
		}
		
		Random r = new Random();
		int rand = r.nextInt(possibleAttacks.size());
		int force = possibleAttacks.get(rand).findAttackDamage();
		
		return (force > 0) ? force + getAttack() : force - getAttack();
		
//		if(getCurVitality() < 10) {
//			return getAttacks()[1].findAttackDamage();
//		}
//		if((opponent.getMaxVitality() - opponent.getCurVitality()) < 5) {
//			return getAttacks()[2].findAttackDamage();
//		}
//		return getAttacks()[0].findAttackDamage();
	}
	
	public void useAttack() {
		int force = findBestAttackDamage();
		if (force > 0) {
			opponent.takeDamage(force + getAttack());
		}
		else {
			this.takeDamage(force - getAttack());
		}
	}
}
