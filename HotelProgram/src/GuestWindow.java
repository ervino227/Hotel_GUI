import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class GuestWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public GuestWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 242, 204));
		panel.setBounds(0, 0, 754, 606);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 88, 668, 355);
		panel.add(scrollPane);
		
		String[] colNames = {"Guest #", "First Name", "Last Name", "Address", "City", "State", "Phone", "Email" };
		DBConnector DB = new DBConnector();
		Object[][] data = DB.getGuests();
		table = new JTable(data,colNames);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(4).setPreferredWidth(40);
		table.getColumnModel().getColumn(5).setPreferredWidth(30);
		table.setRowHeight(22);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JLabel lbleditGuest = new JLabel("<html><span style='font-size:15px'>Edit Guest</span></html>");
		lbleditGuest.setHorizontalAlignment(SwingConstants.LEFT);
		lbleditGuest.setForeground(new Color(0, 100, 0));
		lbleditGuest.setBounds(44, 22, 294, 40);
		panel.add(lbleditGuest);
		
		JButton btnUpdateInfo = new JButton("UPDATE INFO");
		btnUpdateInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int myRow = table.getSelectedRow();
				if(myRow != -1) {
					int guestNum = (int) table.getValueAt(myRow, 0);
					String address = (String) table.getValueAt(myRow, 3);
					String city = (String) table.getValueAt(myRow, 4);
					String state = (String) table.getValueAt(myRow, 5);
					String phone = (String) table.getValueAt(myRow, 6);
					String email = (String) table.getValueAt(myRow, 7);
					int selection = JOptionPane.showConfirmDialog(null, "Confirm changes to guest?", "Edit Guest", 0);
					if(selection == 0) {
						DB.updateGuest(guestNum,address,city,state,phone,email);
						table = new JTable(data,colNames);
						table.setRowHeight(22);
						scrollPane.setViewportView(table);
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Select a guest to edit");
			}
		});
		btnUpdateInfo.setOpaque(false);
		btnUpdateInfo.setForeground(new Color(0, 100, 0));
		btnUpdateInfo.setBounds(549, 500, 163, 40);
		panel.add(btnUpdateInfo);
		
		JButton btnGoBack = new JButton("GO BACK");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnGoBack.setOpaque(false);
		btnGoBack.setForeground(new Color(0, 100, 0));
		btnGoBack.setBounds(44, 500, 163, 40);
		panel.add(btnGoBack);
	}
	
	private void closeWindow() {
		this.dispose();
	}
}
