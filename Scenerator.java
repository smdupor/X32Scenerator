/**
 * 
 */
package x32scenerator;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author stevandupor
 *
 */

public class Scenerator {

	/**
	 * @param args
	 */
	
	
	
	
	public static void main(String[] args) {
		
		String sceneFile = "/Users/stevandupor/eclipse-workspace/x32scenerator/bin/x32scenerator/batb3.csv";
		String castFile = "/Users/stevandupor/eclipse-workspace/x32scenerator/bin/x32scenerator/batbChars.csv";
		
		
		Show show = new Show(sceneFile, castFile);
		
		show.getScene(3).sceneReport();
		
//		Cast cast = new Cast();
//		Scene datab []=	parse(fileTemp);
//		cast.parse(castTemp);

		
//		cast.report();
		//datab[6].sceneReport();
		

	
	}


	
	
	
}