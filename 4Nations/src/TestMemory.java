import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class TestMemory {
	
	public static void main(String []args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		File file = new File(db);
		Scanner in = new Scanner(file);
		String content = "";
		String line = "";
		HashMap<String,String> credentials = new HashMap<>();
		int progress = 0;
		int numWin = 0;
		int coins = 0;
		
		while(in.hasNext()) {
			/*
			 * LOAD THE DATA IN THE HASHMAP
			 */
			String un = "";
			String pw = "";
			line = in.nextLine();
			content += line + "\n";
			Scanner mapSc = new Scanner(line);
			System.out.println(line);
			
			if(mapSc.next().equals("username")) {
				un = mapSc.next();
				System.out.println(un);
			}
			if(mapSc.next().equals("password")) {
				pw = mapSc.next();
				System.out.println(pw);
			}
			credentials.put(un, pw);
			
		}
		
		int choice = 1;
		
		if(choice == 1) {
			/*
			 * UPDATE DATA WITH A NEW USERNAME
			 */
			System.out.print("username: ");
			String username = sc.next();
			System.out.print("password: ");
			String password = sc.next();
			
			/*
			 *  CHECK IF THE USER IS NOT ALREADY IN THE DATABASE
			 */
			while(in.hasNext()) {
				
			}
			
			PrintWriter pen = new PrintWriter("memory.txt");
			pen.println(content  + "username " + username + " password " + password);
			pen.close();
			/*
			 * create file for users
			 */
			OutputStream ou = new FileOutputStream(username + password + "data.txt");
			PrintWriter bic = new PrintWriter(ou);
			bic.println(username);
			bic.println("progess :" + progress);
			bic.println("coins : " + coins);
			bic.println("numWin : " + numWin);
			bic.close();
		}
		else if(choice == 2){
			/*
			 * CHECK IF A USER IS IN THE DATABASE
			 */
			System.out.print("username: ");
			String username = sc.next();
			System.out.print("password: ");
			String password = sc.next();
			
			if(credentials.get(username).equals(password)) {
				System.out.println(true);
			}
			else {
				System.out.println(false);
			}
		}
		
		
	}
}
