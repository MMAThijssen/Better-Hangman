package gui;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import processing.CurrentLogin;
import processing.SoundPlayer;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Class EditAccountScreen creates a screen that enables editing the account.
 *
 */
@SuppressWarnings("serial")
public class EditAccountScreen extends AccountGUISuperClass {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditAccountScreen frame = new EditAccountScreen();
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
	public EditAccountScreen() {
		setTitle("Edit account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setScreenSize();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{300, 400, 300};
		gbl_contentPane.rowHeights = new int[]{200, 0, 0, 0, 0, 0, 300};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		SoundPlayer playSound = SoundPlayer.getInstance();
		CurrentLogin currentLogin = CurrentLogin.getInstance();

		
		JLabel lblEditAccount = new JLabel("Edit Account");
		lblEditAccount.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblEditAccount = new GridBagConstraints();
		gbc_lblEditAccount.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditAccount.gridwidth = 3;
		gbc_lblEditAccount.gridx = 0;
		gbc_lblEditAccount.gridy = 0;
		lblEditAccount.setFont(new Font(FONT, Font.PLAIN, 45));
		contentPane.add(lblEditAccount, gbc_lblEditAccount);
		
		JLabel lblUsername = new JLabel("User: " + currentLogin.getLogin());
		lblUsername.setFont(textFont);
		lblUsername.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.CENTER;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 0);
		gbc_lblUsername.gridx = 2;
		gbc_lblUsername.gridy = 0;
		contentPane.add(lblUsername, gbc_lblUsername);
		
		JButton btnEditUserName = new JButton("Edit username");
		btnEditUserName.setBackground(BUTTONCOLOUR);
		btnEditUserName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound.click();
				EditUsernameScreen editUser = new EditUsernameScreen();
				editUser.openScreen();
				disposeCurrentScreen();
			}
		});
		btnEditUserName.setToolTipText("Edit the username of an existing account");
		GridBagConstraints gbc_btnEditUserName = new GridBagConstraints();
		gbc_btnEditUserName.fill = GridBagConstraints.BOTH;
		gbc_btnEditUserName.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditUserName.gridx = 1;
		gbc_btnEditUserName.gridy = 1;
		contentPane.add(btnEditUserName, gbc_btnEditUserName);
		
		JButton btnEditPassword = new JButton("Edit password");
		btnEditPassword.setBackground(BUTTONCOLOUR);
		btnEditPassword.setToolTipText("Edit the password of your account");
		btnEditPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound.click();
				EditPasswordScreen passWordScreen = new EditPasswordScreen();
				passWordScreen.openScreen();
				disposeCurrentScreen();	
			}
		});
		GridBagConstraints gbc_btnEditPassword = new GridBagConstraints();
		gbc_btnEditPassword.fill = GridBagConstraints.BOTH;
		gbc_btnEditPassword.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditPassword.gridx = 1;
		gbc_btnEditPassword.gridy = 2;
		contentPane.add(btnEditPassword, gbc_btnEditPassword);
		
		JButton btnEditAvatar = new JButton("Edit avatar");
		btnEditAvatar.setBackground(BUTTONCOLOUR);
		btnEditAvatar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound.click();
				EditAvatarScreen editAvatar = new EditAvatarScreen();
				editAvatar.openScreen();
				disposeCurrentScreen();
			}
		});
		btnEditAvatar.setToolTipText("Edit the avatar of an existing account");
		GridBagConstraints gbc_btnEditAvatar = new GridBagConstraints();
		gbc_btnEditAvatar.fill = GridBagConstraints.BOTH;
		gbc_btnEditAvatar.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditAvatar.gridx = 1;
		gbc_btnEditAvatar.gridy = 3;
		contentPane.add(btnEditAvatar, gbc_btnEditAvatar);
		
		JButton btnDeleteAccount = new JButton("Delete account");
		btnDeleteAccount.setToolTipText("Delete your existing account");
		btnDeleteAccount.setBackground(BUTTONCOLOUR);
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound.click();
				DeleteAccountScreen deleteScreen = new DeleteAccountScreen();
				deleteScreen.openScreen();
				disposeCurrentScreen();	
			}
		});
		GridBagConstraints gbc_btnDeleteAccount = new GridBagConstraints();
		gbc_btnDeleteAccount.fill = GridBagConstraints.BOTH;
		gbc_btnDeleteAccount.insets = new Insets(0, 0, 5, 0);
		gbc_btnDeleteAccount.gridx = 1;
		gbc_btnDeleteAccount.gridy = 4;
		contentPane.add(btnDeleteAccount, gbc_btnDeleteAccount);
		
		JButton btnReturnToMenu = new JButton("Return to menu");
		btnReturnToMenu.setBackground(BUTTONCOLOUR);
		btnReturnToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToMenu();
			}
		});
		btnReturnToMenu.setToolTipText("Return to the previous menu");
		GridBagConstraints gbc_btnReturnToMenu = new GridBagConstraints();
		gbc_btnReturnToMenu.fill = GridBagConstraints.BOTH;
		gbc_btnReturnToMenu.gridx = 1;
		gbc_btnReturnToMenu.gridy = 5;
		contentPane.add(btnReturnToMenu, gbc_btnReturnToMenu);
	}

}
