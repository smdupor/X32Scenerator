package x32scenerator;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class Cast {

	private Actor [] cOC;
	private String showName;
	private String date;
	private int castSize;
	
	public Cast() {
		// TODO Auto-generated constructor stub
		cOC = new Actor[30];
		showName="TBD";
		date = Calendar.getInstance().toString();
		castSize=0;
	}
	
	public void parse(String filename)
	{
		BufferedReader csvReader;
		String row="";
		String[] data;
		String colTP;
		int i,j,k;
		char kch;
		int startingChannelNumber=0; // Normal Channel Number Minus 1
		
		try {
			csvReader = new BufferedReader(new FileReader(filename));
			row = csvReader.readLine();
			csvReader.close();
		}
		
		 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Character File Read successfully. Processing Data Structure.");
		
		data = row.split(",");
		
		if(data.length!=90) {System.out.println("Error in Character File Formatting. Exiting."); return;}
		/* Data Layout for Character File:
		 * 0 thru 29 -- Alt (mid Column)
		 * 30 thru 59 -- B Alt
		 * 60 thru 99 -- Main Char Name
		 */
		i=0;
		
		j=0;
		while(i<=29) //Parse Alt Column
		{
			cOC[i] = new Actor();
			
			if(data[i].length()<=2) {cOC[j].setCharNames(1, "");}
				
			else {
				cOC[j].setCharNames(1, data[i].substring(1, data[i].length()-1));
			}
			i++;
			j++;
		}
		
		j=0;
		while(i<=59) // Parse Skin Tone Column
		{
			cOC[j].setSkinTone(data[i].substring(1, data[i].length()-1));
			i++;
			j++;
		}
		j=0;
		while(i<=89) // Parse Primary Character Column
		{
			cOC[j].setCharNames(0, data[i].substring(1, data[i].length()-1));
			i++;
			j++;
		}
		
		i=0;
		j=startingChannelNumber;
		
		while (i<30 && (!cOC[i].getCharName(0).isBlank()||!cOC[i].getCharName(1).isBlank()))
		{
			cOC[i].setChanNumber(j+1);
			
			
			System.out.print("Please Choose a Channel Color for : "+cOC[i].getCharName(0)+" 1-MG 2-CY 3-YL 4-GR 5-RD 6-BL 7-WH: ");
			try
			
			{

				kch=(char)System.in.read();
				k=Character.getNumericValue(kch);
				kch=(char)System.in.read(); // clear the newline
				
			if (k>-10 && k < 10) 
			{
				cOC[i].setChanColorViaInt(k);
				System.out.println("Color Assigned: "+cOC[i].getchanColor());
			}
			else
			{
				System.out.print("Please Choose a Channel Color for : "+cOC[i].getCharName(0)+" 1-MG 2-CY 3-YL 4-GR 5-RD 6-BL 7-WH: ");
				k=System.in.read();
				if (k>-10 && k < 10) {cOC[i].setChanColorViaInt(k);}
				else
				{
					System.out.println("Fail");
				}
			}
			i++;
			j++;
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println ("Recording Cast Size as: "+i);
		castSize=i;
		
		
		
		
		
		
	}

	public void report()
	{
		int i;
		
		System.out.println("Running Cast Report. The cast size is: "+castSize);
		for(i=0;i<castSize;i++)
		{
			System.out.print("Indx(" +i+ ") report: ");
			cOC[i].report();
		}
	}
	
}
