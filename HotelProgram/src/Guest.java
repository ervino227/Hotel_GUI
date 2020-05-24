
public class Guest {
	//fields for the guest object
	private String firstName, lastName, Address, City, State, Phone, email;

	/**
	 * Constructor for creating a guest object
	 * @param f the first name
	 * @param l the last name 
	 * @param a the street address
	 * @param c the city 
	 * @param st the state
	 * @param p the phone number
	 * @param e the email
	 */
	public Guest(String f, String l, String a, String c, String st, String p, String e) {
		firstName = f;
		lastName = l;
		Address = a;
		City = c;
		State = st;
		Phone = p;
		email = e;
	}

	/**
	 * Get the guests first name
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set the first name 
	 * @param firstName the first name of the guest
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Get the last name
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the value for the last name
	 * @param lastName the last name of the guest
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the address of the guest
	 * @return the guests address
	 */
	public String getAddress() {
		return Address;
	}

	/**
	 * sets the address of the guest
	 * @param address the address of the guest
	 */
	public void setAddress(String address) {
		Address = address;
	}

	/**
	 * Gets the city of the guest
	 * @return the city of the guest
	 */
	public String getCity() {
		return City;
	}

	/**
	 * sets the city of the guest
	 * @param city the city of the guest
	 */
	public void setCity(String city) {
		City = city;
	}

	/**
	 * Gets the state of the guest
	 * @return the state of the guest
	 */
	public String getState() {
		return State;
	}

	/**
	 * Sets the state of the guest
	 * @param state the state of the guest
	 */
	public void setState(String state) {
		State = state;
	}

	/**
	 * Gets the phone number of the guest
	 * @return the phone number of the guest
	 */
	public String getPhone() {
		return Phone;
	}

	/**
	 * Sets the phone number of the guest
	 * @param phone the phone number of the guest
	 */
	public void setPhone(String phone) {
		Phone = phone;
	}

	/**
	 * Gets the email of the guest
	 * @return the email of the guest
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email of the guest
	 * @param email the email of the guest 
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
