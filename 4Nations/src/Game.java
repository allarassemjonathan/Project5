import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * 
 * @author ALLARASSEMJJ20
 *
 */
public class Game {
	
	/**
	 * Play the game
	 */
	public void GameLoop() {
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
//			GameManager gm = new GameManager();
//			gm.Manager();
			
			Integer [][] aarr = new Integer [5][5];
			
			System.out.println(aarr[2].length);
//			File file = new File("Jo*1234.txt");
//			String [] arr = file.getName().substring(0, file.getName().length() -4).split("*");
//			System.out.println(file.getName().substring(0, file.getName().length() -4));
			
		

			for(int i = 0; i < aarr[0].length - 1; i++) {
				for(int j = 0; j < aarr.length - 1;j++) {
					System.out.println(aarr[i][j] = 3);
				}
			}
			
			
			
	}

}
