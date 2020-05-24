import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MainWindow extends JFrame {
	MainWindow frame; 
	private JPanel contentPane;

	/**
	 * Constructor for creating the MainWindow JFrame
	 */
	public MainWindow() {
		//details for creating the window 
		setName("MainWindow");
		setTitle("Lakeview Hotel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(213,232,212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 782, 31);
		contentPane.add(toolBar);
		JButton btnNewButton_1 = new JButton("Main");
		toolBar.add(btnNewButton_1);
		JButton btnNewButton_2 = new JButton("Settings");
		toolBar.add(btnNewButton_2);
		
		//Panel to hold the buttons
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(new Color(255,242,204));
		buttonsPanel.setBounds(0, 0, 314, 511);
		contentPane.add(buttonsPanel);
		buttonsPanel.setLayout(null);
		
		//Title for reservations section
		JLabel lblNewLabel = new JLabel("<html><span style='font-size:15px'>"+"Reservations"+"</span></html>");
		lblNewLabel.setForeground(new Color(0, 100, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 56, 294, 40);
		buttonsPanel.add(lblNewLabel);
		
		//button to open window to add new reservation 
		JButton btnOpenAddNew = new JButton("ADD NEW");
		btnOpenAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservationWindow frame2 = new ReservationWindow();
				frame2.setLocationRelativeTo(null);
				frame2.setVisible(true);
			}
		});
		btnOpenAddNew.setForeground(new Color(0, 100, 0));
		btnOpenAddNew.setBounds(76, 107, 163, 40);
		buttonsPanel.add(btnOpenAddNew);
		
		//button to open window to manage existing reservations 
		JButton btnOpenManage = new JButton("MANAGE");
		btnOpenManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageWindow frame3 = new ManageWindow();
				frame3.setLocationRelativeTo(null);
				frame3.setVisible(true);
			}
		});
		btnOpenManage.setForeground(new Color(0, 100, 0));
		btnOpenManage.setBounds(76, 169, 163, 40);
		buttonsPanel.add(btnOpenManage);
		
		//Title for managing rooms section
		JLabel lblManageSuites = new JLabel("<html><span style='font-size:15px'>Manage Suites</span></html>");
		lblManageSuites.setForeground(new Color(0, 100, 0));
		lblManageSuites.setHorizontalAlignment(SwingConstants.CENTER);
		lblManageSuites.setBounds(10, 221, 294, 40);
		buttonsPanel.add(lblManageSuites);
		
		//Button to open window to manage rooms 
		JButton btnOpenManageRooms = new JButton("MANAGE ROOMS");
		btnOpenManageRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuitesWindow frame4 = new SuitesWindow();
				frame4.setLocationRelativeTo(null);
				frame4.setVisible(true); 
			}
		});
		btnOpenManageRooms.setForeground(new Color(0, 100, 0));
		btnOpenManageRooms.setBounds(76, 273, 163, 40);
		buttonsPanel.add(btnOpenManageRooms);
		
		//title for editing guest info section
		JLabel lblEditGuest = new JLabel("<html><span style='font-size:15px'>Edit Guest</span></html>");
		lblEditGuest.setForeground(new Color(0, 100, 0));
		lblEditGuest.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditGuest.setBounds(10, 325, 294, 40);
		buttonsPanel.add(lblEditGuest);
		
		//button to open a window to edit/update guest information 
		JButton btnOpenUpdateInfo = new JButton("UPDATE INFO");
		btnOpenUpdateInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuestWindow frame5 = new GuestWindow();
				frame5.setLocationRelativeTo(null);
				frame5.setVisible(true);
			}
		});
		btnOpenUpdateInfo.setForeground(new Color(0, 100, 0));
		btnOpenUpdateInfo.setBounds(76, 377, 163, 40);
		buttonsPanel.add(btnOpenUpdateInfo);
		
		//labels below contain info about the author 
		JLabel lblNewLabel_1 = new JLabel("Ervens Delva");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(104, 463, 106, 14);
		buttonsPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Author");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(104, 446, 106, 14);
		buttonsPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("2020");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(104, 477, 106, 14);
		buttonsPanel.add(lblNewLabel_1_2);
	}

}
