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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ReservationWindow extends JFrame {

	private JPanel contentPane;
	private JTextField myCheckIn;
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
	public ReservationWindow() {
		setTitle("Lakeview Hotel - New Reservation");
		setBounds(100, 100, 770, 646);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,242,204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel detailsPanel = new JPanel();
		detailsPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), 
				new Color(160, 160, 160)), "Date and Party Options", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		detailsPanel.setBackground(new Color(255,242,204));
		detailsPanel.setBounds(38, 74, 306, 184);
		contentPane.add(detailsPanel);
		detailsPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Check In Date");
		lblNewLabel_1.setBounds(38, 46, 110, 14);
		detailsPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nights");
		lblNewLabel_2.setBounds(38, 85, 57, 14);
		detailsPanel.add(lblNewLabel_2);
		
		myCheckIn = new JTextField();
		myCheckIn.setBounds(158, 43, 96, 20);
		detailsPanel.add(myCheckIn);
		myCheckIn.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Adults");
		lblNewLabel_2_1.setBounds(38, 129, 57, 14);
		detailsPanel.add(lblNewLabel_2_1);
		
		JSpinner adultsCount = new JSpinner();
		adultsCount.setBounds(97, 126, 30, 20);
		detailsPanel.add(adultsCount);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Children");
		lblNewLabel_2_1_1.setBounds(158, 129, 57, 14);
		detailsPanel.add(lblNewLabel_2_1_1);
		
		JSpinner childCount = new JSpinner();
		childCount.setBounds(224, 126, 30, 20);
		detailsPanel.add(childCount);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setBounds(97, 81, 57, 22);
		detailsPanel.add(comboBox);
		
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
		roomPanel.add(radioMaster);
		
		JRadioButton radioQueen = new JRadioButton("Queen Suite");
		radioQueen.setBackground(new Color(255,242,204));
		RoomGroup.add(radioQueen);
		radioQueen.setBounds(23, 59, 109, 23);
		roomPanel.add(radioQueen);
		
		JRadioButton radioTwin = new JRadioButton("Twin Suite");
		radioTwin.setBackground(new Color(255,242,204));
		RoomGroup.add(radioTwin);
		radioTwin.setBounds(23, 85, 109, 23);
		roomPanel.add(radioTwin);
		
		JRadioButton radioFamily = new JRadioButton("Family Suite");
		radioFamily.setBackground(new Color(255,242,204));
		RoomGroup.add(radioFamily);
		radioFamily.setBounds(23, 111, 109, 23);
		roomPanel.add(radioFamily);
		
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
		
		JList list = new JList();
		list.setBounds(140, 193, 114, 20);
		guestInfoPanel.add(list);
		
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
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnCancel.setForeground(new Color(0, 100, 0));
		btnCancel.setBounds(38, 536, 163, 40);
		contentPane.add(btnCancel);
		
		JButton btnMakeReservation = new JButton("MAKE RESERVATION");
		btnMakeReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String checkIn, checkOut, mySuite;
				String firstName,lastName,address,city,phone,email;
				int numAdults, numChild;
				checkIn = myCheckIn.getText();
				checkOut = "";
				numAdults = (int) adultsCount.getValue();
				numChild = (int) childCount.getValue();
				mySuite = getSuite();
				
				firstName = myFirstName.getText();
				lastName = myLastName.getText();
				address = myAddress.getText();
				city = myCity.getText();
				phone = myPhone.getText();
				email = myEmail.getText();
				
				Guest thisGuest = new Guest(firstName, lastName, address, city, phone, email);
				DBConnector DB = new DBConnector();
				DB.createGuest(thisGuest);
				
				//get a room number based on selected suite
				//add room number to the reservation details 
				
				Reservation thisReservation = new Reservation(thisGuest, numAdults, numChild, checkIn, checkOut, mySuite);
				
				//JOptionPane.showMessageDialog(null, "name Details: " + thisReservation.getSuiteSelected() + " \nAdults: " + thisReservation.getNumAdults());
				
				//confirm();
			}

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
	
	public void confirm() {
		//set room status to 'reserved'
		
		//add guest to guest table
		
		//add reservation to reservation table 
		int n = JOptionPane.showConfirmDialog(
			    this,
			    "Confirm Reservation?",
			    "Reservation Details",
			    JOptionPane.YES_NO_OPTION);
	}
	
	public int getRoomNumber(String suiteType) {
		//open the database
		
		//open rooms table
		
		//get a room number with matching room type and 'open' status 
		
		//close the database 
		return 0;
	}
	
	public void finalizeReservation() {
		//input validation for text fields
		
		//create a guest object
		
		//create a reservation object 
		
		//add guest to guest table
		
		//add reservation to reservations table 
		
		//show final message 
	}
	
	public void closeWindow() {
		this.dispose();
	}
}
