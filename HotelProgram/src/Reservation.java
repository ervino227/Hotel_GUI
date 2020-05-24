public class Reservation {
	//Class fields
	private String checkIn;
	private int numAdults, numChildren, numNights, roomNum;
	private String suiteSelected;
	private String firstName, lastName, phone;
	
	/**
	 * Constructor for creating a reservation object 
	 * @param g the guest
	 * @param adults the number of adults
	 * @param children the number of children
	 * @param inDate the check-in date 
	 * @param numNights the number of nights
	 * @param suite the suite type
	 * @param room the room number
	 */
	public Reservation(Guest g,int adults,int children,String inDate, int numNights, String suite, int room) {
		firstName = g.getFirstName();
		lastName = g.getLastName();
		phone = g.getPhone();
		numAdults = adults;
		numChildren = children;
		checkIn = inDate;
		this.numNights = numNights;
		suiteSelected = suite;
		roomNum = room;
	}
 
	/**
	 * Get the number of adults in the reservation
	 * @return the number of adults
	 */
	public int getNumAdults() {
		return numAdults;
	}

	/**
	 * Set the number of adults in the reservation
	 * @param numAdults the number of adults
	 */
	public void setNumAdults(int numAdults) {
		this.numAdults = numAdults;
	}

	/**
	 * Get the number of children in the reservation
	 * @return the number of children
	 */
	public int getNumChildren() {
		return numChildren;
	}

	/**
	 * Set the number of children in the reservation
	 * @param numChildren the number of children 
	 */
	public void setNumChildren(int numChildren) {
		this.numChildren = numChildren;
	}

	/**
	 * Get the room type for the reservation
	 * @return the room type selected
	 */
	public String getSuiteSelected() {
		return suiteSelected;
	}

	/**
	 * Set the room type for the reservation
	 * @param suiteSelected the room type selected 
	 */
	public void setSuiteSelected(String suiteSelected) {
		this.suiteSelected = suiteSelected;
	}

	/**
	 * Get the check-in date for the reservation
	 * @return the check-in date
	 */
	public String getCheckIn() {
		return checkIn;
	}

	/**
	 * Set the check-in date of the reservation
	 * @param checkIn the check-in date
	 */
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	/**
	 * Get the number of nights for the reservation
	 * @return the number of nights
	 */
	public int getNumNights() {
		return numNights;
	}

	/**
	 * Set the number of nights for the reservation
	 * @param numNights the number of nights
	 */
	public void setNumNights(int numNights) {
		this.numNights = numNights;
	}

	/**
	 * Get the first name of the guest in the reservations
	 * @return the guests first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set the first name of the guest in the reservation
	 * @param firstName the guests first name 
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Get the last name of the guest in the reservations
	 * @return the guests last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Set the last name of the guest in the reservation
	 * @param lastName the guests last name 
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Get the room number in the reservation
	 * @return the room number in the reservation
	 */
	public int getRoomNum() {
		return roomNum;
	}

	/**
	 * Set the room number in the reservation
	 * @param roomNum the room number in the reservation
	 */
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	
	
	
}
