/**
 * 
 */
package x32scenerator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author stevandupor
 *
 */
public class Show {

	/** Show is a list of scenes.
	 * 
	 */
	
	private Scene scenes [];
	private Cast cast;
	
	
	public Show(String sceneFileName, String castFileName) {
	
		
		Cast cast = new Cast();
		scenes =	parse(sceneFileName);
		cast.parse(castFileName);
	}
	
	private Scene [] parse (String filename)
	{
		String row;
		String [] textBased = new String [500];
		Scene databloc[];
		int i = 0;
		int j=0;
		BufferedReader csvReader;
		
		
		try {
			csvReader = new BufferedReader(new FileReader(filename));
		
		
		while ((row = csvReader.readLine()) != null) {
		    textBased[i]=row;
		    i++;
			
		}
		csvReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("CSV Format Import Complete. QTY Rows Imported: " + i  + "Processing Data Structure.");
	
		//Create and Populate Scene Array
		
		databloc = new Scene[i+1];
		
		
		
		for(j=0;j<i;j++) {
			
			//take data from textBased[j] and insert into databloc[j]
			databloc[j] = new Scene(textBased[j]);

		}
		System.out.println("CSV Parsing Complete. Scenes Processed: " + j); 
		
	return databloc;
	}

	public Scene getScene(int index) {
		return scenes[index];
		
	}
}


