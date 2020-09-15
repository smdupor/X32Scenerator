/**
 * 
 */
package x32scenerator;

/**
 * @author stevandupor
 *
 */
public class Actor {

	/**
	 * this class represents mic transmitters rather than actors.
	 */
	
	private String iRLName;
	private String [] charNames;
	private int chanNumber;
	private String chanColor;
	private String skinTone;
	
	public Actor() {
		
		iRLName = "TBD";
		charNames = new String[8];
		charNames[0]="TBDChar";
		chanNumber = -1;
		chanColor = "";
		skinTone = "Acid Green";
	}
	
	public void report()
	{
		System.out.println("Actor Report for IRLNAME:"+iRLName+" on Channel No: "+chanNumber+" using color: "+chanColor+" playing: "+charNames[0]+ " as well as "+charNames[1]);
	}
	
	public boolean isChar(String inName) {
		int i=0;
		boolean retVal=false;
		for (i =0; i<charNames.length; i++) {
			if(inName.compareTo(charNames[i])==0) {
				retVal=true;
				break;
			}
		}
		return retVal;
	}
	
	public void setiRLName(String name) { iRLName="".concat(name);}
	
	public void setCharNames(int index, String name){ charNames[index]="".concat(name);}
	
	public void setChanNumber(int chanNum) {chanNumber = chanNum;}
	
	public void setChanColor(String color) {chanColor = "".concat(color);}
	
	public void setChanColorViaInt(int index)
	{
		
		/* Color Reference Chart:
		 * 
		 * 0 -- Black -- "BK"
		 * 1 -- Magenta -- "MG"
		 * 2 -- Cyan -- "CY"
		 * 3 -- Yellow -- "YL"
		 * 4 -- Green -- "GR"
		 * 5 -- Red -- "RD"
		 * 6 -- Dk Blue -- "BL"
		 * 7 -- White -- "WH"
		 * 
		 * Negative Values are inverted
		 */
		
		if(index >7 || index < -7) { this.chanColor = "WH"; } //Default to white color in case of bad index input
		else
		{
			switch(index) {
			
			case 0:
				this.chanColor = "BK";
				break;
			case 1:
				this.chanColor = "MG";
				break;
			case 2:
				this.chanColor = "CY";
				break;
			case 3:
				this.chanColor = "YL";
				break;
			case 4:
				this.chanColor = "GR";
				break;
			case 5:
				this.chanColor = "RD";
				break;
			case 6:
				this.chanColor = "BL";
				break;
			case 7:
				this.chanColor = "WH";
				break;
			case -1:
				this.chanColor = "MGi";
				break;
			case -2:
				this.chanColor = "CYi";
				break;
			case -3:
				this.chanColor = "YLi";
				break;
			case -4:
				this.chanColor = "GRi";
				break;
			case -5:
				this.chanColor = "RDi";
				break;
			case -6:
				this.chanColor = "BLi";
				break;
			case -7:
				this.chanColor = "WHi";
				break;
			}
			}
		
		
		
	}
	
	public void setSkinTone(String tone) { skinTone="".concat(tone);}
	
	
	
	public String getiRLName() {return iRLName;}
	
	public String getCharName(int index) {return charNames[index];}
	
	public int getchanNumber() {return chanNumber;}
	
	public String getchanColor() {return chanColor;}
	
	public String getSkinTone() {return skinTone;}
	

}
