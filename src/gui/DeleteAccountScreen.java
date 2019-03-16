package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import processing.CurrentLogin;
import processing.SoundPlayer;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Class DeleteAccountScreen creates a screen that enables deleting the account.
 *
 */
@SuppressWarnings("serial")
public class DeleteAccountScreen extends AccountGUISuperClass {
	SoundPlayer playSound = SoundPlayer.getInstance();
	private JPasswordField passwordField;
	private JRadioButton rdbtnShowPassword;
	private JButton btnDeleteAccount;
	private JButton btnReturnToMenu;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteAccountScreen frame = new DeleteAccountScreen();
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
	public DeleteAccountScreen() {
		
		CurrentLogin currentLogin = CurrentLogin.getInstance();
		
		setTitle("Delete account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setScreenSize();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{200, 100, 400, 300};
		gbl_contentPane.rowHeights = new int[]{200, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
				
		JLabel lblEditAvatar = new JLabel("Delete account");
		lblEditAvatar.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblEditAvatar = new GridBagConstraints();
		gbc_lblEditAvatar.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditAvatar.gridwidth = 4;
		gbc_lblEditAvatar.gridx = 0;
		gbc_lblEditAvatar.gridy = 0;
		lblEditAvatar.setFont(new Font(FONT, Font.PLAIN, 45));
		contentPane.add(lblEditAvatar, gbc_lblEditAvatar);
		
		JLabel lblCurrentUsername = new JLabel("User: " + currentLogin.getLogin());
		lblCurrentUsername.setFont(textFont);
		lblCurrentUsername.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblCurrentUsername = new GridBagConstraints();
		gbc_lblCurrentUsername.anchor = GridBagConstraints.CENTER;
		gbc_lblCurrentUsername.insets = new Insets(0, 0, 5, 0);
		gbc_lblCurrentUsername.gridx = 3;
		gbc_lblCurrentUsername.gridy = 0;
		contentPane.add(lblCurrentUsername, gbc_lblCurrentUsername);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 1;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		passwordField.setEchoChar('*');
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 1;
		contentPane.add(passwordField, gbc_passwordField);
		
		rdbtnShowPassword = new JRadioButton("Show password");
		rdbtnShowPassword.setBackground(Color.DARK_GRAY);
		rdbtnShowPassword.setForeground(Color.WHITE);
		rdbtnShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnShowPassword.isSelected())
				{
					passwordField.setEchoChar((char) 0);
				}
				else
				{
					passwordField.setEchoChar('*');
				}
			}
		});
		GridBagConstraints gbc_rdbtnShowPassword = new GridBagConstraints();
		gbc_rdbtnShowPassword.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnShowPassword.anchor = GridBagConstraints.CENTER;
		gbc_rdbtnShowPassword.gridx = 2;
		gbc_rdbtnShowPassword.gridy = 2;
		contentPane.add(rdbtnShowPassword, gbc_rdbtnShowPassword);
		
		btnDeleteAccount = new JButton("Delete account");
		btnDeleteAccount.setBackground(BUTTONCOLOUR);
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound.click();
				char[] password = passwordField.getPassword();
				guiSetUserName(currentLogin.getLogin());
				guiSetPassWord(password);
				guiDeleteAccount();
				if (guiFindAccount(currentLogin.getLogin()) == false) {
						currentLogin.logout();
						backToStartMenu();
				}
				else {
					guiDeleteAccount();
				}
				
			}
		});
		GridBagConstraints gbc_btnDeleteAccount = new GridBagConstraints();
		gbc_btnDeleteAccount.fill = GridBagConstraints.BOTH;
		gbc_btnDeleteAccount.insets = new Insets(0, 0, 5, 0);
		gbc_btnDeleteAccount.gridx = 2;
		gbc_btnDeleteAccount.gridy = 3;
		contentPane.add(btnDeleteAccount, gbc_btnDeleteAccount);
		
		btnReturnToMenu = new JButton("Return to menu");
		btnReturnToMenu.setBackground(BUTTONCOLOUR);
		btnReturnToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToMenu();
			}
		});
		GridBagConstraints gbc_btnReturnToMenu = new GridBagConstraints();
		gbc_btnReturnToMenu.fill = GridBagConstraints.BOTH;
		gbc_btnReturnToMenu.gridx = 2;
		gbc_btnReturnToMenu.gridy = 4;
		contentPane.add(btnReturnToMenu, gbc_btnReturnToMenu);
	}
	


}
