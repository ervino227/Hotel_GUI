public class Reservation {
	private String checkIn, checkOut;
	private int numAdults, numChildren;
	private String suiteSelected;
	private String firstName, lastName, phone;
	
	public Reservation(Guest g,int adults,int children,String inDate, String outDate, String suite) {
		firstName = g.getFirstName();
		lastName = g.getLastName();
		phone = g.getPhone();
		numAdults = adults;
		numChildren = children;
		checkIn = inDate;
		checkOut = outDate;
		suiteSelected = suite;
	}

	public int getNumAdults() {
		return numAdults;
	}

	public void setNumAdults(int numAdults) {
		this.numAdults = numAdults;
	}

	public int getNumChildren() {
		return numChildren;
	}

	public void setNumChildren(int numChildren) {
		this.numChildren = numChildren;
	}

	public String getSuiteSelected() {
		return suiteSelected;
	}

	public void setSuiteSelected(String suiteSelected) {
		this.suiteSelected = suiteSelected;
	}
	
	
	
}
