package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import processing.CurrentLogin;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Class EditUsernameScreen creates a screen that enables editing a username.
 *
 */
@SuppressWarnings("serial")
public class EditUsernameScreen extends AccountGUISuperClass {

	private JPanel contentPane;
	private JTextField textNewUsername;
	private JLabel lblNewUsername;
	private JButton btnSubmitChanges;
	private JButton btnReturnToMenu;
	private JPasswordField passwordField;
	private JRadioButton rdbtnShowPassword;
	private static final String USER_CONTAINS_FORBIDDEN = "Please don't use the following symbols in your username: '    \"   \\";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditUsernameScreen frame = new EditUsernameScreen();
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
	public EditUsernameScreen() {
		setTitle("Edit username");
		setScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{200, 150, 350, 300};
		gbl_contentPane.rowHeights = new int[]{200, 0, 0, 0, 0, 0, 0, 0, 0, 300};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		CurrentLogin currentLogin = CurrentLogin.getInstance();
		
		JLabel lblEditUsername = new JLabel("Edit username");
		lblEditUsername.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblEditUsername = new GridBagConstraints();
		gbc_lblEditUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditUsername.gridwidth = 4;
		gbc_lblEditUsername.gridx = 0;
		gbc_lblEditUsername.gridy = 0;
		lblEditUsername.setFont(new Font(FONT, Font.PLAIN, 45));
		contentPane.add(lblEditUsername, gbc_lblEditUsername);
		
		JLabel lblUsername = new JLabel("User: " + currentLogin.getLogin());
		lblUsername.setFont(textFont);
		lblUsername.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.CENTER;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 0);
		gbc_lblUsername.gridx = 3;
		gbc_lblUsername.gridy = 0;
		contentPane.add(lblUsername, gbc_lblUsername);
		
		
		JLabel lblUsernameRestriction = new JLabel("Your username must be 12 or less characters long");
		lblUsernameRestriction.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblUsernameRestriction = new GridBagConstraints();
		gbc_lblUsernameRestriction.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsernameRestriction.gridx = 2;
		gbc_lblUsernameRestriction.gridy = 1;
		contentPane.add(lblUsernameRestriction, gbc_lblUsernameRestriction);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 2;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		passwordField.setEchoChar('*');
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 2;
		contentPane.add(passwordField, gbc_passwordField);
		
		lblNewUsername = new JLabel("New username: ");
		lblNewUsername.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewUsername = new GridBagConstraints();
		gbc_lblNewUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewUsername.anchor = GridBagConstraints.EAST;
		gbc_lblNewUsername.gridx = 1;
		gbc_lblNewUsername.gridy = 3;
		contentPane.add(lblNewUsername, gbc_lblNewUsername);
		
		textNewUsername = new JTextField();
		textNewUsername.setToolTipText("enter your new username");
		GridBagConstraints gbc_textNewUsername = new GridBagConstraints();
		gbc_textNewUsername.insets = new Insets(0, 0, 5, 5);
		gbc_textNewUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNewUsername.gridx = 2;
		gbc_textNewUsername.gridy = 3;
		contentPane.add(textNewUsername, gbc_textNewUsername);
		textNewUsername.setColumns(10);
		
		rdbtnShowPassword = new JRadioButton("Show password");
		rdbtnShowPassword.setForeground(Color.WHITE);
		rdbtnShowPassword.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_rdbtnShowPassword = new GridBagConstraints();
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
		gbc_rdbtnShowPassword.anchor = GridBagConstraints.WEST;
		gbc_rdbtnShowPassword.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnShowPassword.gridx = 2;
		gbc_rdbtnShowPassword.gridy = 4;
		contentPane.add(rdbtnShowPassword, gbc_rdbtnShowPassword);
		
		btnSubmitChanges = new JButton("Submit");
		btnSubmitChanges.setBackground(BUTTONCOLOUR);
		btnSubmitChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newUsername = textNewUsername.getText();
				char[] password = passwordField.getPassword();
				if (newUsername.contains("'") || newUsername.contains("\"") || newUsername.contains("\\")) {
					JOptionPane.showMessageDialog(null, USER_CONTAINS_FORBIDDEN);
				}
				else {
					guiSetUserName(currentLogin.getLogin());
					guiSetPassWord(password);
					guiEditUsername(newUsername);
					currentLogin.login(newUsername);
					lblUsername.setText("User: " + newUsername);
				}
			}
		});
		btnSubmitChanges.setToolTipText("Submit your new username");
		GridBagConstraints gbc_btnSubmitChanges = new GridBagConstraints();
		gbc_btnSubmitChanges.fill = GridBagConstraints.BOTH;
		gbc_btnSubmitChanges.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubmitChanges.gridx = 2;
		gbc_btnSubmitChanges.gridy = 5;
		contentPane.add(btnSubmitChanges, gbc_btnSubmitChanges);
		
		btnReturnToMenu = new JButton("Return to menu");
		btnReturnToMenu.setBackground(BUTTONCOLOUR);
		btnReturnToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToMenu();
			}
		});
		GridBagConstraints gbc_btnReturnToMenu = new GridBagConstraints();
		gbc_btnReturnToMenu.fill = GridBagConstraints.BOTH;
		gbc_btnReturnToMenu.insets = new Insets(0, 0, 5, 5);
		gbc_btnReturnToMenu.gridx = 2;
		gbc_btnReturnToMenu.gridy = 6;
		contentPane.add(btnReturnToMenu, gbc_btnReturnToMenu);
	}

}
