package x32scenerator;

import java.util.Stack;

public class DCA {

	
	private String dcaName;
	private String dcaColor;
	private int dcaOn; // 1 on, 0 off, -1 null
	private boolean dcaSafe;
	private Stack<Actor> members;
	private int level;
	private boolean empty;
	
	public DCA() { //Construct an Empty, Valid DCA 
		
		int dcaO = 0; //DCA Muted
		int dcaLev = -999; //DCA Level set to Minus Inf
		boolean dcaS = false; // DCA Safety not implemented in X32 hardware.
		String dcaC = "BK"; // Default to Black color
		
		members = new Stack<Actor> ();
		this.dcaName="None";
		this.dcaColor=dcaC;
		this.dcaOn=dcaO;
		this.dcaSafe=dcaS;
		this.level=dcaLev;	
		empty=true;
		
	}
	
	public DCA(String dcaN) {//constructor when we only know name 
		
		int dcaO = -1; //DCA Mute set to invalid by default
		int dcaLev = -98765; //DCA Level set to invalid by default
		boolean dcaS = false; // DCA Safety not implemented in X32 hardware.
		String dcaC = "WH"; // Default to white color
		
		members = new Stack<Actor> ();
		this.dcaName=dcaN;
		this.dcaColor=dcaC;
		this.dcaOn=dcaO;
		this.dcaSafe=dcaS;
		this.level=dcaLev;	
		
	}
	
	public DCA(String dcaN, String dcaC) {//constructor when we only know name and color
	
		int dcaO = -1; //DCA Mute set to invalid by default
		int dcaLev = -98765; //DCA Level set to invalid by default
		boolean dcaS = false; // DCA Safety not implemented in X32 hardware.
		
		members = new Stack<Actor> ();
		this.dcaName=dcaN;
		this.dcaColor=dcaC;
		this.dcaOn=dcaO;
		this.dcaSafe=dcaS;
		this.level=dcaLev;	
	}
	public DCA(String dcaN, String dcaC,int dcaO,int dcaLev,boolean dcaS) {//constructor when we have all params
		
	//	int dcaO = -1; //DCA Mute set to invalid by default
	//	int dcaLev = -98765; //DCA Level set to invalid by default
	//	boolean dcaS = false; // DCA Safety not implemented in X32 hardware.
		
		members = new Stack<Actor> ();
		this.dcaName=dcaN;
		this.dcaColor=dcaC;
		this.dcaOn=dcaO;
		this.dcaSafe=dcaS;
		this.level=dcaLev;	
	}

	public boolean isEmpty() {
		return empty;
	}
	
	public void setEmpty() {
		empty=true;
		this.dcaName="None";
		this.dcaColor="BK";
		this.dcaOn=0;
		this.dcaSafe=false;
		this.level=-999;
	}
	
	public String getDcaName() {
		return dcaName;
	}


	public void setDcaName(String dcaName) {
		this.dcaName = dcaName;
	}


	public String getDcaColor() {
		return dcaColor;
	}


	public void setDcaColor(String dcaColor) {
		this.dcaColor = dcaColor;
	}


	public int getDcaOn() {
		return dcaOn;
	}


	public void setDcaOn(int dcaOn) {
		this.dcaOn = dcaOn;
	}


	public boolean isDcaSafe() {
		return dcaSafe;
	}


	public void setDcaSafe(boolean dcaSafe) {
		this.dcaSafe = dcaSafe;
	}


	public Actor searchMembers(String find) { //returns a null if unfound
		Stack <Actor> temp = new Stack<Actor>();
		Actor retVal=null;	
		while (!members.isEmpty()) {
			if(members.peek().isChar(find))
			{
				retVal=members.peek();
				break;
			}
			temp.push(members.pop());
		}
		while (!temp.isEmpty())
		{
			members.push(temp.pop());
		}
		
		
		return retVal;
	}
	
	public Actor popMember() {
		return (Actor)members.pop();
	}


	public void pushMember(Actor newMember) {
		this.members.push(newMember);
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}

}
