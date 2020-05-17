public class Reservation {
	private String checkIn;
	private int numAdults, numChildren, numNights;
	private String suiteSelected;
	private String firstName, lastName, phone;
	
	public Reservation(Guest g,int adults,int children,String inDate, int numNights, String suite) {
		firstName = g.getFirstName();
		lastName = g.getLastName();
		phone = g.getPhone();
		numAdults = adults;
		numChildren = children;
		checkIn = inDate;
		this.numNights = numNights;
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

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public int getNumNights() {
		return numNights;
	}

	public void setNumNights(int numNights) {
		this.numNights = numNights;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	
}
