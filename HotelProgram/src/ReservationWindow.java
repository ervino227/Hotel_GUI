import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;

public class ReservationWindow extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup RoomGroup = new ButtonGroup();
	private JTextField myFirstName;
	private JTextField myLastName;
	private JTextField myAddress;
	private JTextField myCity;
	private JTextField myPhone;
	private JTextField myEmail;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public ReservationWindow() {
		//Database Connector obtains number of rooms of each room type
		int masterRooms, queenRooms, twinRooms, familyRooms;
		DBConnector DB = new DBConnector();
		masterRooms = DB.getNumMasterRooms();
		queenRooms = DB.getNumQueenRooms();
		twinRooms = DB.getNumTwinRooms();
		familyRooms = DB.getNumFamilyRooms();
		
		//details for this window
		setTitle("Lakeview Hotel - New Reservation");
		setBounds(100, 100, 770, 646);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,242,204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//JPanel containing reservation details 
		JPanel detailsPanel = new JPanel();
		detailsPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), 
				new Color(160, 160, 160)), "Date and Party Options", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		detailsPanel.setBackground(new Color(255,242,204));
		detailsPanel.setBounds(38, 74, 306, 212);
		contentPane.add(detailsPanel);
		detailsPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Check In Date");
		lblNewLabel_1.setBounds(39, 39, 91, 14);
		detailsPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nights");
		lblNewLabel_2.setBounds(38, 117, 57, 14);
		detailsPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Adults");
		lblNewLabel_2_1.setBounds(41, 159, 57, 14);
		detailsPanel.add(lblNewLabel_2_1);
		
		JSpinner adultsCount = new JSpinner();
		adultsCount.setModel(new SpinnerNumberModel(1, 0, 6, 1));
		adultsCount.setBounds(100, 156, 30, 20);
		detailsPanel.add(adultsCount);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Children");
		lblNewLabel_2_1_1.setBounds(161, 159, 57, 14);
		detailsPanel.add(lblNewLabel_2_1_1);
		
		JSpinner childCount = new JSpinner();
		childCount.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		childCount.setBounds(227, 156, 30, 20);
		detailsPanel.add(childCount);
		
		
		JComboBox nightsSelector = new JComboBox();
		nightsSelector.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		nightsSelector.setBounds(97, 113, 57, 22);
		detailsPanel.add(nightsSelector);
		
		JComboBox monthSelector = new JComboBox();
		monthSelector.setModel(new DefaultComboBoxModel(new String[] {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"}));
		monthSelector.setBounds(39, 66, 49, 22);
		detailsPanel.add(monthSelector);
		
		JComboBox daySelector = new JComboBox();
		daySelector.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		daySelector.setBounds(100, 66, 49, 22);
		detailsPanel.add(daySelector);
		
		JComboBox yearSelector = new JComboBox();
		yearSelector.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021", "2022", "2023"}));
		yearSelector.setBounds(161, 66, 64, 22);
		detailsPanel.add(yearSelector);
		
		//JPanel containing Suite type and available rooms 
		JPanel roomPanel = new JPanel();
		roomPanel.setBackground(new Color(255,242,204));
		roomPanel.setBorder(new TitledBorder(null, "Suite Selection", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		roomPanel.setBounds(38, 322, 306, 184);
		contentPane.add(roomPanel);
		roomPanel.setLayout(null);
		
		JRadioButton radioMaster = new JRadioButton("Master Suite");
		radioMaster.setBackground(new Color(255,242,204));
		RoomGroup.add(radioMaster);
		radioMaster.setBounds(23, 33, 109, 23);
		if(masterRooms == 0)
			radioMaster.setEnabled(false);
		roomPanel.add(radioMaster);
		
		JRadioButton radioQueen = new JRadioButton("Queen Suite");
		radioQueen.setBackground(new Color(255,242,204));
		RoomGroup.add(radioQueen);
		radioQueen.setBounds(23, 59, 109, 23);
		if(queenRooms==0)
			radioQueen.setEnabled(false);
		roomPanel.add(radioQueen);
		
		JRadioButton radioTwin = new JRadioButton("Twin Suite");
		radioTwin.setBackground(new Color(255,242,204));
		RoomGroup.add(radioTwin);
		radioTwin.setBounds(23, 85, 109, 23);
		if(twinRooms==0)
			radioTwin.setEnabled(false);
		roomPanel.add(radioTwin);
		
		JRadioButton radioFamily = new JRadioButton("Family Suite");
		radioFamily.setBackground(new Color(255,242,204));
		RoomGroup.add(radioFamily);
		radioFamily.setBounds(23, 111, 109, 23);
		if(familyRooms==0)
			radioFamily.setEnabled(false);
		roomPanel.add(radioFamily);
		
		String masterString = "" + masterRooms + " rooms available";
		JLabel availableMaster = new JLabel(masterString);
		availableMaster.setBounds(150, 35, 146, 19);
		roomPanel.add(availableMaster);
		
		String queenString = "" + queenRooms + " rooms available";
		JLabel availableQueen = new JLabel(queenString);
		availableQueen.setBounds(150, 61, 146, 19);
		roomPanel.add(availableQueen);
		
		String twinString = "" + twinRooms + " rooms available";
		JLabel availableTwin = new JLabel(twinString);
		availableTwin.setBounds(150, 87, 146, 19);
		roomPanel.add(availableTwin);
		
		String familyString = "" + familyRooms + " rooms available";
		JLabel availableFamily = new JLabel(familyString);
		availableFamily.setBounds(150, 113, 146, 19);
		roomPanel.add(availableFamily);
		
		//JPanel containing fields for entering guest information 
		JPanel guestInfoPanel = new JPanel();
		guestInfoPanel.setBorder(new TitledBorder(null, "Guest Information", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		guestInfoPanel.setBackground(new Color(255,242,204));
		guestInfoPanel.setBounds(396, 74, 306, 434);
		contentPane.add(guestInfoPanel);
		guestInfoPanel.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(34, 40, 90, 14);
		guestInfoPanel.add(lblFirstName);
		
		myFirstName = new JTextField();
		myFirstName.setColumns(10);
		myFirstName.setBounds(140, 37, 114, 20);
		guestInfoPanel.add(myFirstName);
		
		myLastName = new JTextField();
		myLastName.setColumns(10);
		myLastName.setBounds(140, 68, 114, 20);
		guestInfoPanel.add(myLastName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(34, 71, 90, 14);
		guestInfoPanel.add(lblLastName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(34, 113, 90, 14);
		guestInfoPanel.add(lblAddress);
		
		myAddress = new JTextField();
		myAddress.setColumns(10);
		myAddress.setBounds(34, 138, 220, 20);
		guestInfoPanel.add(myAddress);
		
		myCity = new JTextField();
		myCity.setColumns(10);
		myCity.setBounds(34, 193, 96, 20);
		guestInfoPanel.add(myCity);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(34, 168, 90, 14);
		guestInfoPanel.add(lblCity);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(140, 168, 90, 14);
		guestInfoPanel.add(lblState);
		
		myPhone = new JTextField();
		myPhone.setColumns(10);
		myPhone.setBounds(34, 249, 220, 20);
		guestInfoPanel.add(myPhone);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(34, 224, 90, 14);
		guestInfoPanel.add(lblPhone);
		
		myEmail = new JTextField();
		myEmail.setColumns(10);
		myEmail.setBounds(34, 305, 220, 20);
		guestInfoPanel.add(myEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(34, 280, 90, 14);
		guestInfoPanel.add(lblEmail);
		
		JComboBox stateSelector = new JComboBox();
		stateSelector.setModel(new DefaultComboBoxModel(new String[] {"AL", "AK", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "HI", "IA", 
				"ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", 
				"OK", "OH", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY"}));
		stateSelector.setBounds(140, 192, 114, 22);
		guestInfoPanel.add(stateSelector);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnCancel.setForeground(new Color(0, 100, 0));
		btnCancel.setBounds(38, 536, 163, 40);
		contentPane.add(btnCancel);
		
		//Button to add a reservation and a guest to the database
		JButton btnMakeReservation = new JButton("MAKE RESERVATION");
		btnMakeReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String checkIn, mySuite, myState, dateString;
				String firstName,lastName,address,city,phone,email;
				int numAdults, numChild, numNights;
				
				int month = (monthSelector.getSelectedIndex() + 1);
				String day =  (String) daySelector.getSelectedItem();
				String year = (String) yearSelector.getSelectedItem();
				dateString = month + "/" + day + "/" + year;
				
				numNights = (nightsSelector.getSelectedIndex() + 1);
				numAdults = (int) adultsCount.getValue();
				numChild = (int) childCount.getValue();
				mySuite = getSuite();
				
				firstName = myFirstName.getText();
				lastName = myLastName.getText();
				address = myAddress.getText();
				city = myCity.getText();
				myState = (String) stateSelector.getSelectedItem();
				phone = myPhone.getText();
				email = myEmail.getText();
				
				int n = JOptionPane.showConfirmDialog(
					    null,
					    "Confirm Reservation?",
					    "Reservation Details",
					    JOptionPane.YES_NO_OPTION);
				if(n==0) {
					DBConnector DB = new DBConnector();
					Guest thisGuest = new Guest(firstName, lastName, address, city, myState, phone, email);
					DB.createGuest(thisGuest);
					int roomNum = DB.getRoomNumber(mySuite);
					Reservation thisReservation = new Reservation(thisGuest, numAdults, numChild, dateString, numNights, mySuite, roomNum);
					DB.createReservation(thisReservation);
					DB.reserveRoom(roomNum);
					
					JOptionPane.showMessageDialog(null,
						    "Reservation has been created.");
					closeWindow();
				}
			}
 
			/**
			 * Method for getting the suite type the user selected
			 * @return the type of suite the user selected 
			 */
			private String getSuite() {
				// TODO Auto-generated method stub
				if(radioMaster.isSelected())
					return "Master";
				else if(radioQueen.isSelected())
					return "Queen";
				else if(radioTwin.isSelected())
					return "Twin";
				else if(radioFamily.isSelected())
					return "Family";
				else
					return null;
			}
		});
		btnMakeReservation.setForeground(new Color(0, 100, 0));
		btnMakeReservation.setBounds(476, 536, 226, 40);
		contentPane.add(btnMakeReservation);
		
		JLabel titleLabel = new JLabel("<html><span style='font-size:15px'>New Reservation</span></html>");
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		titleLabel.setForeground(new Color(0, 100, 0));
		titleLabel.setBounds(38, 11, 294, 40);
		contentPane.add(titleLabel);
	}
	
	public void closeWindow() {
		this.dispose();
	}
}
