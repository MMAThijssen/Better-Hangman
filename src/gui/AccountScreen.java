package gui;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import processing.CurrentLogin;
import processing.GameManager;
import processing.SoundPlayer;

import java.awt.GridBagLayout;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Class AccountWindow creates a screen with options to start a game, edit an account, log out
 * or return to menu.
 *
 */
@SuppressWarnings("serial")
public class AccountScreen extends GUISuperClass {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountScreen frame = new AccountScreen();
					frame.setLocationRelativeTo(null);
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
	public AccountScreen() {
		setTitle("Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setScreenSize();
		setResizable(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{300, 400, 300};
		gbl_contentPane.rowHeights = new int[]{200, 0, 0, 0, 0, 300};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		SoundPlayer playSound = SoundPlayer.getInstance();
		CurrentLogin currentLogin = CurrentLogin.getInstance();

		
		JLabel lblAccountMenu = new JLabel("Account menu");
		lblAccountMenu.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblAccountMenu = new GridBagConstraints();
		gbc_lblAccountMenu.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccountMenu.gridwidth = 3;
		gbc_lblAccountMenu.gridx = 0;
		gbc_lblAccountMenu.gridy = 0;
		lblAccountMenu.setFont(new Font(FONT, Font.PLAIN, 45));
		contentPane.add(lblAccountMenu, gbc_lblAccountMenu);
		
		JLabel lblUsername = new JLabel("User: " + currentLogin.getLogin());
		lblUsername.setFont(textFont);
		lblUsername.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.CENTER;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 0);
		gbc_lblUsername.gridx = 2;
		gbc_lblUsername.gridy = 0;
		contentPane.add(lblUsername, gbc_lblUsername);
		
		JButton btnStart = new JButton("Start game");
		btnStart.setBackground(BUTTONCOLOUR);
		btnStart.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * Initializes GameManager object, starts the game and disposes current screen.
			 */
			public void actionPerformed(ActionEvent e) {
				playSound.click();
				GameManager gameManager = new GameManager(7);
				gameManager.startMainFrame();
				disposeCurrentScreen();
			}
		});
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.fill = GridBagConstraints.BOTH;
		gbc_btnStart.insets = new Insets(0, 0, 5, 5);
		gbc_btnStart.gridx = 1;
		gbc_btnStart.gridy = 1;
		contentPane.add(btnStart, gbc_btnStart);
		
		
		JButton btnEditAccount = new JButton("Edit Account");
		btnEditAccount.setBackground(BUTTONCOLOUR);
		btnEditAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound.click();
				EditAccountScreen edit = new EditAccountScreen();
				edit.openScreen();
				disposeCurrentScreen();
			}
		});
		GridBagConstraints gbc_btnEditAccount = new GridBagConstraints();
		gbc_btnEditAccount.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditAccount.fill = GridBagConstraints.BOTH;
		gbc_btnEditAccount.gridx = 1;
		gbc_btnEditAccount.gridy = 2;
		contentPane.add(btnEditAccount, gbc_btnEditAccount);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBackground(BUTTONCOLOUR);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound.click();
				CurrentLogin logout = CurrentLogin.getInstance();
				logout.logout();
				JOptionPane.showMessageDialog(null, "You are successfully logged out");
				backToMenu();
			}
		});
		GridBagConstraints gbc_btnLogOut = new GridBagConstraints();
		gbc_btnLogOut.fill = GridBagConstraints.BOTH;
		gbc_btnLogOut.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogOut.gridx = 1;
		gbc_btnLogOut.gridy = 3;
		contentPane.add(btnLogOut, gbc_btnLogOut);
		
		JButton btnReturnToMenu = new JButton("Return to Menu");
		btnReturnToMenu.setBackground(BUTTONCOLOUR);
		btnReturnToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToMenu();
			}
		});
		GridBagConstraints gbc_btnReturnToMenu = new GridBagConstraints();
		gbc_btnReturnToMenu.fill = GridBagConstraints.BOTH;
		gbc_btnReturnToMenu.insets = new Insets(0, 0, 0, 5);
		gbc_btnReturnToMenu.gridx = 1;
		gbc_btnReturnToMenu.gridy = 4;
		contentPane.add(btnReturnToMenu, gbc_btnReturnToMenu);
	}


}
