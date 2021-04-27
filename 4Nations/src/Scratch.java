import java.util.Random;

public class Scratch {
	public static void main(String[] args) {
		Legionary l = new Legionary();
		Pegasus  p = new Pegasus();
		TypicalEgyptian te = new TypicalEgyptian(l);
		//Random r = new Random();
		
		//System.out.println(te.getAttacks()[1].findAttackDamage());

		for (int i = 0; i < 10; i++) {
			
			System.out.println(te.getName() + ": \t" + te.getCurVitality() + "\nLegionary: \t" + l.getCurVitality() + "\n");
			l.useAttack(0, te);
			System.out.println(te.getName() + ": \t" + te.getCurVitality() + "\nLegionary: \t" + l.getCurVitality() + "\n");
			te.useAttack();
			
			
			
		}
	}

}
