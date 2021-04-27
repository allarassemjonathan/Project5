import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * @author ALLARASSEMJJ20
 *
 */
public class Session {

	private int numWins;
	private int level = numWins%5;
	private Arena currentArena;
	private String username;
	private String password;
	private Integer [][] mapArena;
	private static final ArrayList <Arena> ArenaList = new ArrayList(List.of(new Arena(), new Arena(), new Arena(), new Arena()));
	private GameCharacter personas;
	private final int SIZE = 5;
	public Session() {
		
	}
	/**
	 * 
	 * @param username of the new user
	 * @param password of the new user 
	 */
	public Session(String username,String password) {
		this.numWins = 0;
		this.level = 0;
		// this.currentArena = ?? 
		this.username = username;
		this.password = password;
		this.mapArena = new Integer[SIZE][SIZE];
		mapArena[0][0] = 1;
		this.personas = new GameCharacter();
	}
	
	/**
	 * 
	 * @param file containing the user's data
	 * @throws FileNotFoundException 
	 */
	public Session(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()) {
			this.username = sc.nextLine().substring(11);
			this.password = sc.nextLine().substring(11);
			this.numWins = Integer.parseInt(sc.nextLine().substring(10));
			
		}
		
	}
	
	/**
	 * 
	 * @param NumWins of the session's user to set
	 */
	public void setNumWins(int NumWins) {
		this.numWins = numWins;
	}
	
	/**
	 * 
	 * @return the number of victories in the session
	 */
	public int getNumWins() {
		return this.numWins;
	}
	
	/**
	 * 
	 * @param password of the session's user to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 
	 * @return the password of the session's user
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * 
	 * @param username of the session's user to set
	 */
	public void setUsername(String username) {
		
	}
	
	/**
	 * 
	 * @return the username of the session's user
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * 
	 * @param level of the session's user to set
	 */
	public void setLevel(int level) {
		
	}
	/**
	 * 
	 * @return the level of the session's user
	 */
	public int getLevel() {
		return this.level;
	}
	
	/**
	 * 
	 * @param persona of the session's user to set
	 */
	public GameCharacter getCharacter() {
		return this.personas;
	}
	
	/**
	 * 
	 * @param list of personas of the session's user to set
	 */
	public void setCharacter(GameCharacter gc) {
		this.personas = gc ;
	}
	
	/**
	 * 
	 * @param arena of the session's user to set
	 */
	public void setcurrentArena(Arena arena) {
		this.currentArena = arena;
	}
	
	/**
	 * 
	 * @return the Arena of the session's user
	 */
	public Arena getcurrentArena() {
		return this.currentArena;
	}
	/**
	 * 
	 * @return the stage in the game
	 * which is how far you are to end
	 * the current arena
	 */
	public int getStage() {
		return numWins%SIZE;
	}
	/**
	 * 
	 * @return the arena index
	 */
	public int getArenaIndex() {
		return numWins/SIZE;
	}
	/**
	 * 
	 * @param numWins
	 */
	public void updateMapArena(int numWins) {
		
		for(int i = 0; i < this.mapArena[0].length - 1; i++) {
			for(int j = i; j < this.mapArena.length - 1;j++) {
				this.mapArena[i][j] = 3;
			}
		}
		
		this.mapArena[numWins%SIZE][numWins/SIZE] = 1;
	}
}

