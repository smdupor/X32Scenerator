package x32scenerator;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ScenefileOutputModule {
	private FileLine header; // Line 1 thru 37 on version 4.0;
	private FileLine chanBody; // Line 38 thru 486 (DYNAMIC, end of Chan 14) on version 4.0; Starts at channel 1;
	private FileLine remainingBody; // Line 486(DYNAMIC) thru 1682 Bus 13 Config for Reverb Sends
	private FileLine verbSendsBody; // Line 1682 thru 1757 Bus 13-16
	private int sceneNumber;
	private String [] array;
	private int endLine;
	private int startChanBody, startRemainingBody,startVerbSendsBody;
	
	//Linked List of Lines of File Text
private class FileLine {
	
	private int index;
	private String content;
	private FileLine next;
	
	public FileLine(int ind, String cont)
	{
		this.index=ind;
		this.content = "".concat(cont);
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the next
	 */
	public FileLine getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(FileLine next) {
		this.next = next;
	}
	
	
}
	





	public ScenefileOutputModule(String filename) //Constructor when reading original file from disk
	{
		

			String row;
			array = new String[2000];
			int i = 0;
			int j=0;
			BufferedReader csvReader;
			
			
			try {
				csvReader = new BufferedReader(new FileReader(filename));
				
				
				
				
				//read line 1 thru 37
				while ((row = csvReader.readLine()) != null) {
			    
					array[i]=row;
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
			
			System.out.println("OLD X32 File Read complete");
		
			header = new FileLine(1,array[0]); //create the head of the list
			endLine = i;
			populate(header,0);
		
	}
	
	public void populate(FileLine fln, int ind) //create new list element and set link into it
	{ 
		FileLine tempLoc;
		int i = ind;
		
		//tempLoc = new FileLine(i,array[i]);
		//fln.setNext(tempLoc);
		
	//	fln = fln.getNext();
//		i++;
		
		while(i < endLine) { 
			
			tempLoc = new FileLine(i,array[i]);
			fln.setNext(tempLoc);
			
			
			//startChanBody, startRemainingBody,startVerbSendsBody;
			if(i==startChanBody) { chanBody = fln;}
			else if (i == startRemainingBody) { remainingBody = fln;}
			else if (i == startVerbSendsBody) { verbSendsBody = fln;}			
			fln = fln.getNext();
			i++;
			
		}
		
		
		
		
		/*FileLine tempLoc = new FileLine(ind,array[ind]);
		fln.setNext(tempLoc);
		ind++;
		
		if(ind < endLine) { this.populate(tempLoc,ind);}
		*/
	}

}


/* 
/ch/01/config "BEAST" 1 CY 1
/ch/01/delay OFF   0.3
/ch/01/preamp +0.0 OFF ON 24 136
/ch/01/gate OFF GATE -80.0 60.0 1  502  983 0
/ch/01/gate/filter OFF 3.0 990.9
/ch/01/dyn ON COMP PEAK LOG -41.0 2.5 1 0.00 0 10.0  151 POST 0 100 OFF
/ch/01/dyn/filter OFF 3.0 990.9
/ch/01/insert OFF POST OFF
/ch/01/eq ON
/ch/01/eq/1 PEQ 124.7 +0.00 2.0
/ch/01/eq/2 PEQ 496.6 +0.00 2.0
/ch/01/eq/3 PEQ 1k97 +0.00 2.0
/ch/01/eq/4 HShv 10k02 +0.00 2.0
/ch/01/mix ON   -oo OFF +2 OFF -81.0
/ch/01/mix/01 ON   -oo +0 POST 0
/ch/01/mix/02 ON   -oo
/ch/01/mix/03 ON   -oo +0 POST 0
/ch/01/mix/04 ON  -0.3
/ch/01/mix/05 ON   -oo +0 POST 0
/ch/01/mix/06 ON   -oo
/ch/01/mix/07 ON   -oo +0 POST 0
/ch/01/mix/08 ON   -oo
/ch/01/mix/09 ON  +3.0 +0 POST 0
/ch/01/mix/10 ON   -oo
/ch/01/mix/11 ON   -oo +0 POST 0
/ch/01/mix/12 ON   -oo
/ch/01/mix/13 ON  -4.0 +0 POST 0
/ch/01/mix/14 ON  -1.0
/ch/01/mix/15 ON   -oo +0 POST 0
/ch/01/mix/16 ON   -oo
/ch/01/grp %00000001 %000000
/ch/01/automix OFF  +0.0
*/