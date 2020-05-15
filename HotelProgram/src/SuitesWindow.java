import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SuitesWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
	public SuitesWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,242,204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(44, 229, 661, 249);
		contentPane.add(table);
		
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
		btnAddRooms.setForeground(new Color(0, 100, 0));
		btnAddRooms.setBounds(267, 518, 163, 40);
		contentPane.add(btnAddRooms);
		
		JButton btnEnabledisable = new JButton("ENABLE/DISABLE");
		btnEnabledisable.setForeground(new Color(0, 100, 0));
		btnEnabledisable.setBounds(485, 518, 220, 40);
		contentPane.add(btnEnabledisable);
	}
	
	public void closeWindow() {
		this.dispose();
	}

}
