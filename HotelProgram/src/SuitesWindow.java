import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelListener;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class SuitesWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuitesWindow frame = new SuitesWindow();
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
	@SuppressWarnings("deprecation")
	public SuitesWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 242, 204));
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
		btnCancel.setBounds(44, 518, 163, 40);
		contentPane.add(btnCancel);

		JButton btnAddRooms = new JButton("ADD ROOM(S)");
		btnAddRooms.setVisible(false);
		btnAddRooms.setForeground(new Color(0, 100, 0));
		btnAddRooms.setBounds(475, 174, 220, 40);
		contentPane.add(btnAddRooms);

		JButton btnEnabledisable = new JButton("ENABLE/DISABLE");
		btnEnabledisable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int myRow = table.getSelectedRow();
				if (myRow != -1) {
					int rowData = (int) table.getValueAt(myRow, 0);
					String rowStatus = (String) table.getValueAt(myRow, 2);
					DBConnector DB = new DBConnector();
					if (!rowStatus.equals("Reserved")) {
						DB.changeRoomStatus(rowData, rowStatus);
						String[] colNames = { "Room Number", "Room Type", "Status" };
						Object[][] newlist = DB.getRooms();
						table = new JTable(newlist, colNames);
						table.setRowHeight(22);
						scrollPane.setViewportView(table);
						textArea.append("Room " + rowData + " status has been changed.\n");
					} else
						textArea.append("This room is reserved\n");
				} else
					textArea.append("No room selected\n");
			}
		});
		btnEnabledisable.setForeground(new Color(0, 100, 0));
		btnEnabledisable.setBounds(475, 106, 220, 40);
		contentPane.add(btnEnabledisable);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 106, 386, 373);
		contentPane.add(scrollPane);

		String[] colNames = { "Room Number", "Room Type", "Status" };
		DBConnector DB = new DBConnector();
		Object[][] data = DB.getRooms();
		table = new JTable(data, colNames);
		table.setRowHeight(22);
		/*
		 * table.setModel(new DefaultTableModel( new Object[][] { { new Integer(101),
		 * "Family", "Open" }, { new Integer(102), "Family", "Open" }, { new
		 * Integer(103), "Family", "Open" }, { new Integer(104), "Family", "Open" }, {
		 * new Integer(105), "Family", "Open" }, { new Integer(201), "Twin", "Open" }, {
		 * new Integer(202), "Twin", "Open" }, { new Integer(203), "Twin", "Open" }, {
		 * new Integer(204), "Twin", "Open" }, { new Integer(205), "Twin", "Open" }, {
		 * new Integer(301), "Queen", "Open" }, { new Integer(302), "Queen", "Open" }, {
		 * new Integer(303), "Queen", "Open" }, { new Integer(304), "Queen", "Open" }, {
		 * new Integer(305), "Queen", "Open" }, { new Integer(401), "Master", "Reserved"
		 * }, { new Integer(402), "Master", "Open" }, { new Integer(403), "Master",
		 * "Open" }, { new Integer(404), "Master", "Open" }, { new Integer(405),
		 * "Master", "Open" }, }, new String[] { "Room Number", "Room Type", "Status" })
		 * {
		 *//**
				 * 
				 *//*
					 * private static final long serialVersionUID = 1L; boolean[] columnEditables =
					 * new boolean[] { false, false, false };
					 * 
					 * public boolean isCellEditable(int row, int column) { return
					 * columnEditables[column]; } });
					 */
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		
		JLabel lblmanageSuites = new JLabel("<html><span style='font-size:15px'>Manage Suites</span></html>");
		lblmanageSuites.setHorizontalAlignment(SwingConstants.LEFT);
		lblmanageSuites.setForeground(new Color(0, 100, 0));
		lblmanageSuites.setBounds(44, 55, 294, 40);
		contentPane.add(lblmanageSuites);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(475, 254, 220, 216);
		contentPane.add(scrollPane_1);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane_1.setViewportView(textArea);
		
		JLabel lblRecentChanges = new JLabel("Recent Changes");
		lblRecentChanges.setBounds(475, 235, 100, 20);
		contentPane.add(lblRecentChanges);
		
		

	}

	public void closeWindow() {
		this.dispose();
	}
}
