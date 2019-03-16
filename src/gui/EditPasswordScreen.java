package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import processing.CurrentLogin;

// import processing.PlaySound;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

/**
 * Class EditPasswordScreen creates a screen that enables password editing.
 *
 */
@SuppressWarnings("serial")
public class EditPasswordScreen extends AccountGUISuperClass{

	private JPanel contentPane;
	private JPasswordField passwordFieldOld;
	private JPasswordField passwordFieldNew;
	private JPasswordField passwordFieldConfirmNew;
	private static final String UPDATE_SUCCESSFUL = "Update password was successful!";
	private static final String PW_IS_OLD_PW = "New password should differ from old password";
	private static final String PW_CONTAINS_FORBIDDEN = "Please don't use the following symbols in your password: '    \"   \\";
	private static final String PW_DONT_MATCH = "Passwords do not match";
	public static final String PW_TOO_LONG =  "Password cannot be empty or longer than 12 characters.";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditPasswordScreen frame = new EditPasswordScreen();
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
	public EditPasswordScreen() {
		setTitle("Edit password");
		setScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{150, 200, 350, 300};
		gbl_contentPane.rowHeights = new int[]{200, 0, 0, 0, 0, 0, 0, 0, 300};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		//PlaySound playSound = PlaySound.getInstance();
		CurrentLogin currentLogin = CurrentLogin.getInstance();
		
		JLabel lblEditPassword = new JLabel("Edit password");
		lblEditPassword.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblEditPassword = new GridBagConstraints();
		gbc_lblEditPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditPassword.gridwidth = 4;
		gbc_lblEditPassword.gridx = 0;
		gbc_lblEditPassword.gridy = 0;
		lblEditPassword.setFont(new Font(FONT, Font.PLAIN, 45));
		contentPane.add(lblEditPassword, gbc_lblEditPassword);
		
		JLabel lblUser = new JLabel("User: " + currentLogin.getLogin());
		lblUser.setFont(textFont);
		lblUser.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.anchor = GridBagConstraints.CENTER;
		gbc_lblUser.insets = new Insets(0, 0, 5, 0);
		gbc_lblUser.gridx = 3;
		gbc_lblUser.gridy = 0;
		contentPane.add(lblUser, gbc_lblUser);
		
		JLabel lblPasswordCannotBe = new JLabel("Password cannot be longer than 12 characters.");
		lblPasswordCannotBe.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblPasswordCannotBe = new GridBagConstraints();
		gbc_lblPasswordCannotBe.insets = new Insets(0, 0, 5, 0);
		gbc_lblPasswordCannotBe.gridx = 2;
		gbc_lblPasswordCannotBe.gridy = 1;
		contentPane.add(lblPasswordCannotBe, gbc_lblPasswordCannotBe);
		
		JLabel lblCurrentPassword = new JLabel("Current Password: ");
		lblCurrentPassword.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblCurrentPassword = new GridBagConstraints();
		gbc_lblCurrentPassword.anchor = GridBagConstraints.EAST;
		gbc_lblCurrentPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblCurrentPassword.gridx = 1;
		gbc_lblCurrentPassword.gridy = 2;
		contentPane.add(lblCurrentPassword, gbc_lblCurrentPassword);
		
		passwordFieldOld = new JPasswordField();
		GridBagConstraints gbc_passwordFieldOld = new GridBagConstraints();
		passwordFieldOld.setEchoChar('*');
		gbc_passwordFieldOld.insets = new Insets(0, 0, 5, 0);
		gbc_passwordFieldOld.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordFieldOld.gridx = 2;
		gbc_passwordFieldOld.gridy = 2;
		contentPane.add(passwordFieldOld, gbc_passwordFieldOld);
		
		JLabel lblNewPassword = new JLabel("New Password: ");
		lblNewPassword.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewPassword = new GridBagConstraints();
		gbc_lblNewPassword.anchor = GridBagConstraints.EAST;
		gbc_lblNewPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewPassword.gridx = 1;
		gbc_lblNewPassword.gridy = 3;
		contentPane.add(lblNewPassword, gbc_lblNewPassword);
		
		passwordFieldNew = new JPasswordField();
		GridBagConstraints gbc_passwordFieldNew = new GridBagConstraints();
		passwordFieldNew.setEchoChar('*');
		gbc_passwordFieldNew.insets = new Insets(0, 0, 5, 0);
		gbc_passwordFieldNew.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordFieldNew.gridx = 2;
		gbc_passwordFieldNew.gridy = 3;
		contentPane.add(passwordFieldNew, gbc_passwordFieldNew);
		
		JLabel lblConfirmNewPassword = new JLabel("Confirm New Password: ");
		lblConfirmNewPassword.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblConfirmNewPassword = new GridBagConstraints();
		gbc_lblConfirmNewPassword.anchor = GridBagConstraints.EAST;
		gbc_lblConfirmNewPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmNewPassword.gridx = 1;
		gbc_lblConfirmNewPassword.gridy = 4;
		contentPane.add(lblConfirmNewPassword, gbc_lblConfirmNewPassword);
		
		passwordFieldConfirmNew = new JPasswordField();
		GridBagConstraints gbc_passwordFieldConfirmNew = new GridBagConstraints();
		passwordFieldConfirmNew.setEchoChar('*');
		gbc_passwordFieldConfirmNew.insets = new Insets(0, 0, 5, 0);
		gbc_passwordFieldConfirmNew.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordFieldConfirmNew.gridx = 2;
		gbc_passwordFieldConfirmNew.gridy = 4;
		contentPane.add(passwordFieldConfirmNew, gbc_passwordFieldConfirmNew);
		
		JRadioButton rdbtnShowPassword = new JRadioButton("Show password");
		rdbtnShowPassword.setForeground(Color.WHITE);
		rdbtnShowPassword.setBackground(Color.DARK_GRAY);
		rdbtnShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnShowPassword.isSelected())
				{
					passwordFieldOld.setEchoChar((char) 0);
					passwordFieldNew.setEchoChar((char) 0);
					passwordFieldConfirmNew.setEchoChar((char) 0);
				}
				else
				{
					passwordFieldNew.setEchoChar('*');
					passwordFieldOld.setEchoChar('*');
					passwordFieldConfirmNew.setEchoChar('*');
				}
			}
		});
		GridBagConstraints gbc_rdbtnShowpassword = new GridBagConstraints();
		gbc_rdbtnShowpassword.anchor = GridBagConstraints.WEST;
		gbc_rdbtnShowpassword.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnShowpassword.gridx = 2;
		gbc_rdbtnShowpassword.gridy = 5;
		contentPane.add(rdbtnShowPassword, gbc_rdbtnShowpassword);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(BUTTONCOLOUR);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound.click();
				char[] oldPassword = passwordFieldOld.getPassword();
				char[] newPassword = passwordFieldNew.getPassword();
				char[] confirmNewPassword = passwordFieldConfirmNew.getPassword();
				if (newPassword.length<13 && newPassword.length>0){
					if (Arrays.equals(oldPassword,newPassword)){
						JOptionPane.showMessageDialog(null, PW_IS_OLD_PW);
					}
					else {
						String passwordString = new String(newPassword);
						if (passwordString.contains("'") || passwordString.contains("\"") || passwordString.contains("\\")) {
							JOptionPane.showMessageDialog(null, PW_CONTAINS_FORBIDDEN);
						}
						else {
							if (Arrays.equals(newPassword,confirmNewPassword)){
								
								guiSetUserName(currentLogin.getLogin());
								guiSetPassWord(oldPassword);
								guiEditPassword(newPassword);
								JOptionPane.showMessageDialog(null, UPDATE_SUCCESSFUL);
							}
							else {
								JOptionPane.showMessageDialog(null, PW_DONT_MATCH);
							}
						}
					}
				}
				else {
				JOptionPane.showMessageDialog(null, PW_TOO_LONG);
				}
			}
		});
		btnSubmit.setToolTipText("Submit the changes");

		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.fill = GridBagConstraints.BOTH;
		gbc_btnSubmit.insets = new Insets(0, 0, 5, 0);
		gbc_btnSubmit.gridx = 2;
		gbc_btnSubmit.gridy = 6;
		contentPane.add(btnSubmit, gbc_btnSubmit);
		
		JButton btnReturnToMenu = new JButton("Return to menu");
		btnReturnToMenu.setBackground(BUTTONCOLOUR);
		btnReturnToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToMenu();
			}
		});
		btnReturnToMenu.setToolTipText("Return to the menu");
		GridBagConstraints gbc_btnReturnToMenu = new GridBagConstraints();
		gbc_btnReturnToMenu.fill = GridBagConstraints.BOTH;
		gbc_btnReturnToMenu.gridx = 2;
		gbc_btnReturnToMenu.gridy = 7;
		contentPane.add(btnReturnToMenu, gbc_btnReturnToMenu);
	}

}
