package x32scenerator;

public class Scene 

{


		
		/* Layout of CSV Export:
		 
		 0>7 DCA 1 THRU 8
		 8 Flex 1
		 9 Flex 2
		 10 Flex 1 State ON
		 11 Flex 2 State ON
		 12 Levels (String)
		 13>20 DCA 1 THRU 8 State ON
		 21 >28 DCA 1 Thru 8 Safe ON
		 29 Reverb On/Off
		 30 Scene Name
		 31 Scene Number
		 32 Scene Note 1
		 33 Scene Note 2
		 34 Script Page
		*/

		
/*		private String [] dcaName;
		private String [] dcaColor;
		private int dcaOn[]; // 1 on, 0 off, -1 null
		private boolean dcaSafe[];
*/
		private DCA dcas[];
		private String flexName[];
		private boolean flexState[];
		private String levels;
		private boolean sceneReverb;
		private String sceneName;
		private String sceneNumber;
		
		private String sceneNotes[];
		private String scriptPage;
		    
		public  Scene(String line) {
			/*dcaName = new String[8];
			dcaOn = new int[8];
			dcaSafe = new boolean[8];
			*/
			dcas=new DCA[8];
			flexName = new String [2];
			flexState = new boolean[2];
			levels="";
			sceneName="";
			sceneNumber="";
			scriptPage="";
			sceneNotes=new String[2];
			sceneReverb=false;
			
	
			String temptemp;
			String[] data = line.split(",");
			int i=0,j=0;
			
			while(i<=7) //read names of DCA 1 thru 8
			{
				temptemp=data[i].substring(1, data[i].length()-1);
				if(data[i].substring(1, data[i].length()-1).compareTo("")==0) //Empty DCA
				{
					dcas[i]= new DCA(); // Create an "Empty" Blank DCA

				}
				else //Full DCA
				{
					dcas[i]= new DCA(data[i].substring(1, data[i].length()-1)); // Full DCA, avoid setting Color at this time
				}
				i++;
			}
			//i == 8
			flexName[0] = data[i].substring(1, data[i].length()-1);
			i++;
			//i == 9
			flexName[1] = data[i].substring(1, data[i].length()-1);
			i++;
			//i == 10
			if(data[i].substring(1,data[i].length()-1).compareTo("0")==0)//FLEX ON STATE
			{
				flexState[0]=true;
			}
			else
			{
				flexState[0]=false;
			}
			i++;
			//i == 11
			if(data[i].substring(1,data[i].length()-1).compareTo("0")==0)//FLEX ON STATE
			{
				flexState[0]=true;
			}
			else
			{
				flexState[0]=false;
			}
			i++;
			//i == 12
			if(data[i].substring(0,data[i].length()-1).compareTo("")==0)//IMPORT OVERALL LEVELS. Write Logic later to translate to nmbers
			{
				levels="UNSPECIFIED";
			}
			else
			{
				levels=data[i].substring(1,data[i].length()-1);
			}
			i++;
			j=0;
			//i == 13 thru 20, DCA States
			while(i<=20) //read On/off Status of DCA 1 thru 8
			{
				if(dcas[j].isEmpty()) //DCA is Empty/Null
				{
					//Do Nothing
				}
				else if(data[i].substring(1,data[i].length()-1).compareTo("0")==0) //Defined and ON
				{
					
					dcas[j].setDcaOn(1);
				}
				else if(data[i].substring(1,data[i].length()-1).compareTo("")==0)//Defined and OFF
				{
					dcas[j].setDcaOn(0);
				}
				else
				{
					System.out.println("ERROR IN DCA Mute SECTION!!!");
					//throw new CSVFormatException("Format Error in DCA State Section.");
				}
				i++;
				j++;
			}
			//i==21 thru 28, Read DCA Safety Information
			j=0;
			while(i<=28) //read safety Status of DCA 1 thru 8
			{
				if(dcas[j].isEmpty()) //DCA is Empty/Null
				{
					//Do Nothing
				}
				else if(data[i].substring(1,data[i].length()-1).compareTo("0")==0) //Defined and ON
				{
					dcas[j].setDcaSafe(true);
				}
				else if(data[i].substring(1,data[i].length()-1).compareTo("")==0)//Defined and OFF
				{
					dcas[j].setDcaSafe(false);
				}
				else
				{
					System.out.println("ERROR IN DCA SAFETY SECTION!!!");
					//throw new CSVFormatException("Format Error in DCA State Section.");
				}
				i++;
				j++;
			}
			//i == 29, Reverb On/Off
			if(data[i].substring(1,data[i].length()-1)=="")
			{
				sceneReverb=false;
			}
			else
			{
				sceneReverb=true;
			}
			i++;
			//i == 30, Scene Name
			sceneName=data[i].substring(1,data[i].length()-1);
			i++;
			//i == 31, Scene Number
			sceneNumber = data[i].substring(1,data[i].length()-1);
			i++;
			//i == 32, Scene Note #1
			sceneNotes[0] = data[i].substring(1,data[i].length()-1);
			i++;
			//i == 33, Scene Note #1
			sceneNotes[1] = data[i].substring(1,data[i].length()-1);
			i++;
			//i == 34, Scene Page Number
			scriptPage = data[i].substring(1,data[i].length()-1);
			
			
		}
		
		public DCA getDca(int index) {
			return dcas[index];
		}
		
	/*	public int findDca(String search) { //returns DCA number if found, -1 if not found.
			int i=0;
			int result=-1;
			
			while( i<8) {
				if(dcaName[i].compareTo(search)==0) {//found
					result = i;
					
				}
				i++;	
			}
			return result;
		}
		public DCA suckDCA(String search) { //returns DCA number if found, -1 if not found.
			int i=0;
			DCA result;
			
			while( i<8) {
				if(dcas[i]..compareTo(search)==0) {//found
					result = i;
					
				}
				i++;	
			}
			return result;
		}
*/
		public String getFlexName(int index) {
			return flexName[index];
		}


		public boolean getFlexState(int index) {
			return flexState[index];
		}

		public String getLevels() {
			return levels;
		}

		public boolean isSceneReverb() {
			return sceneReverb;
		}

		public String getSceneName() {
			return sceneName;
		}

		public String getSceneNumber() {
			return sceneNumber;
		}

		public String[] getSceneNotes() {
			return sceneNotes;
		}

		public String getScriptPage() {
			return scriptPage;
		}

	/*	public void setScene(String line) 
		{
			
			
			String temptemp;
			String[] data = line.split(",");
			int i=0,j=0;
			
			while(i<=7) //read names of DCA 1 thru 8
			{
				temptemp=data[i].substring(1, data[i].length()-1);
				if(data[i].substring(1, data[i].length()-1).compareTo("")==0) //Empty DCA
				{
					dcaName[i]=data[i];
					dcaOn[i]=-1;
				}
				else //Full DCA
				{
					dcaName[i]=data[i].substring(1, data[i].length()-1);
				}
				i++;
			}
			//i == 8
			flexName[0] = data[i].substring(1, data[i].length()-1);
			i++;
			//i == 9
			flexName[1] = data[i].substring(1, data[i].length()-1);
			i++;
			//i == 10
			if(data[i].substring(1,data[i].length()-1).compareTo("0")==0)//FLEX ON STATE
			{
				flexState[0]=true;
			}
			else
			{
				flexState[0]=false;
			}
			i++;
			//i == 11
			if(data[i].substring(1,data[i].length()-1).compareTo("0")==0)//FLEX ON STATE
			{
				flexState[0]=true;
			}
			else
			{
				flexState[0]=false;
			}
			i++;
			//i == 12
			if(data[i].substring(0,data[i].length()-1).compareTo("")==0)//IMPORT OVERALL LEVELS
			{
				levels="UNSPECIFIED";
			}
			else
			{
				levels=data[i].substring(1,data[i].length()-1);
			}
			i++;
			j=0;
			//i == 13 thru 20, DCA States
			while(i<=20) //read On/off Status of DCA 1 thru 8
			{
				if(dcaOn[j]==-1) //DCA is Empty/Null
				{
					//Do Nothing
				}
				else if(data[i].substring(1,data[i].length()-1).compareTo("0")==0) //Defined and ON
				{
					
					dcaOn[j]=1;
				}
				else //Defined and OFF
				{
					dcaOn[j]=0;
				}
				i++;
				j++;
			}
			//i==21 thru 28, Read DCA Safety Information
			j=0;
			while(i<=28) //read On/off Status of DCA 1 thru 8
			{
				if(dcaOn[j]==-1) //DCA is Empty/Null
				{
					//Do Nothing
				}
				else if(data[i].substring(1,data[i].length()-1).compareTo("0")==0) //Defined and ON
				{
					
					dcaSafe[j]=true;
				}
				else //Defined and OFF
				{
					dcaSafe[j]=false;
				}
				i++;
				j++;
			}
			//i == 29, Reverb On/Off
			if(data[i].substring(1,data[i].length()-1)=="")
			{
				sceneReverb=false;
			}
			else
			{
				sceneReverb=true;
			}
			i++;
			//i == 30, Scene Name
			sceneName=data[i].substring(1,data[i].length()-1);
			i++;
			//i == 31, Scene Number
			sceneNumber = data[i].substring(1,data[i].length()-1);
			i++;
			//i == 32, Scene Note #1
			sceneNotes[0] = data[i].substring(1,data[i].length()-1);
			i++;
			//i == 33, Scene Note #1
			sceneNotes[1] = data[i].substring(1,data[i].length()-1);
			i++;
			//i == 34, Scene Page Number
			scriptPage = data[i].substring(1,data[i].length()-1);
		}*/
			
				
				


public void sceneReport()
{
	String vrb;
	int i=0;
	System.out.println("Scene Report for Scene #: "+ sceneNumber +" Name: "+sceneName+" on Script Pg. "+scriptPage+" ");
	if(sceneReverb) {vrb="Verb ON";}else{vrb="Verb OFF";}
	
	System.out.println("Scene Levels are: "+levels+" Reverb Is: "+vrb+"\n");
	while(i<8)
	{
		if(dcas[i].isEmpty()){System.out.println("DCA "+i+" is EMPTY");}
		else if(dcas[i].getDcaOn()==0) {System.out.println("DCA "+i+" is "+dcas[i].getDcaName()+" and is MUTED");}
		else {System.out.println("DCA "+i+" is "+dcas[i].getDcaName()+" and is LIVE");}
		i++;		
	}
	System.out.println("\n");
}
			
			
}
/* Layout of CSV Export:


0>7 DCA 1 THRU 8
8 Flex 1
9 Flex 2
10 Flex 1 State ON
11 Flex 2 State ON
12 Levels (String)
13>20 DCA 1 THRU 8 State ON
21 >28 DCA 1 Thru 8 Safe ON
29 Reverb On/Off
30 Scene Name
31 Scene Number
32 Scene Note 1
33 Scene Note 2
34 Script Page
*/ 
		


