import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class ManageWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	JScrollPane scrollPane;
	Object[][] data;

	/**
	 * Constructor for creating the ManageWindow JFrame
	 */
	public ManageWindow() {
		//details for creating the window 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,242,204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//button for closing the current window
		JButton btnCancel = new JButton("GO BACK");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnCancel.setForeground(new Color(0, 100, 0));
		btnCancel.setBounds(43, 520, 163, 40);
		contentPane.add(btnCancel);
		
		//Label for the title of current window
		JLabel lblmanageReservations = new JLabel("<html><span style='font-size:15px'>Manage Reservations</span></html>");
		lblmanageReservations.setHorizontalAlignment(SwingConstants.LEFT);
		lblmanageReservations.setForeground(new Color(0, 100, 0));
		lblmanageReservations.setBounds(43, 11, 294, 40);
		contentPane.add(lblmanageReservations);
		
		//details for adding to the table 
		String[] colNames = {"Reservation #", "First Name", "Last Name", "Adults", "Children", "Check-In", "Nights", "Suite", "Room"};
		DBConnector DB = new DBConnector();
		data = DB.getReservations();
		
		//ScrollPane for holding the table 
		scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 81, 667, 405);
		contentPane.add(scrollPane);
		table = new JTable(data ,colNames);
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//button used to delete a reservation selected from the table 
		JButton btnDeleteReservation = new JButton("DELETE RESERVATION");
		btnDeleteReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int myRow = table.getSelectedRow();
				if(myRow!=-1) {
					int confirm = JOptionPane.showConfirmDialog(null, "Delete this reservation?", "Delete", 0);
					if(confirm == 0) {
						int resNum = (int) table.getValueAt(myRow, 0);
						int roomNum = (int) table.getValueAt(myRow, 8);
						DB.deleteReservation(resNum);
						DB.clearRoom(roomNum);
						JOptionPane.showMessageDialog(null, "Reservation Deleted");
						data = DB.getReservations();
						table = new JTable(data ,colNames);
						scrollPane.setViewportView(table);
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Select a reservation.");
			}
		});
		btnDeleteReservation.setOpaque(false);
		btnDeleteReservation.setForeground(new Color(0, 100, 0));
		btnDeleteReservation.setBounds(547, 520, 163, 40);
		contentPane.add(btnDeleteReservation);
		
		
	}
	/**
	 * Method for closing the current window 
	 */
	public void closeWindow() {
		this.dispose();
	}
}
