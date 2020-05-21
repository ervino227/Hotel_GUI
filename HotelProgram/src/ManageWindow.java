import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class ManageWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageWindow frame = new ManageWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManageWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,242,204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnCancel.setForeground(new Color(0, 100, 0));
		btnCancel.setBounds(43, 36, 163, 40);
		contentPane.add(btnCancel);
		
		JLabel lblmanageReservations = new JLabel("<html><span style='font-size:15px'>Manage Reservations</span></html>");
		lblmanageReservations.setHorizontalAlignment(SwingConstants.LEFT);
		lblmanageReservations.setForeground(new Color(0, 100, 0));
		lblmanageReservations.setBounds(43, 87, 294, 40);
		contentPane.add(lblmanageReservations);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(43, 141, 90, 14);
		contentPane.add(lblFirstName);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(130, 138, 114, 20);
		contentPane.add(textField);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(43, 172, 90, 14);
		contentPane.add(lblLastName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(130, 169, 114, 20);
		contentPane.add(textField_1);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(304, 141, 90, 14);
		contentPane.add(lblPhone);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(375, 138, 114, 20);
		contentPane.add(textField_2);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(304, 172, 90, 14);
		contentPane.add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(375, 169, 114, 20);
		contentPane.add(textField_3);
		
		String[] colNames = {"Reservation #", "First Name", "Last Name", "Adults", "Children", "Check-In", "Nights", "Suite" };
		DBConnector DB = new DBConnector();
		Object[][] data = DB.getReservations();
		
		JButton btnApplyFilter = new JButton("APPLY FILTER");
		btnApplyFilter.setForeground(new Color(0, 100, 0));
		btnApplyFilter.setBounds(541, 152, 163, 40);
		contentPane.add(btnApplyFilter);
		
		JButton btnUpdateReservation = new JButton("UPDATE RESERVATION");
		btnUpdateReservation.setForeground(new Color(0, 100, 0));
		btnUpdateReservation.setBounds(541, 520, 163, 40);
		contentPane.add(btnUpdateReservation);
		
		JButton btnDeleteReservation = new JButton("DELETE RESERVATION");
		btnDeleteReservation.setOpaque(false);
		btnDeleteReservation.setForeground(new Color(0, 100, 0));
		btnDeleteReservation.setBounds(326, 520, 163, 40);
		contentPane.add(btnDeleteReservation);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 228, 667, 281);
		contentPane.add(scrollPane);
		table = new JTable(data ,colNames);
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	public void closeWindow() {
		this.dispose();
	}
}
