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
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.awt.event.ActionEvent;

/**
 * Class LoginScreen creates a screen that enables logging into an account.
 *
 */
@SuppressWarnings("serial")
public class LoginScreen extends AccountGUISuperClass {

	private JTextField txtFldUsername;
	private JPasswordField txtFldpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
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
	public LoginScreen() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setScreenSize();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{200, 100, 400, 300};
		gbl_contentPane.rowHeights = new int[]{200, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.gridwidth = 4;
		gbc_lblLogin.gridx = 0;
		gbc_lblLogin.gridy = 0;
		lblLogin.setFont(new Font(FONT, Font.PLAIN, 45));
		contentPane.add(lblLogin, gbc_lblLogin);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		txtFldUsername = new JTextField();
		GridBagConstraints gbc_txtFldUsername = new GridBagConstraints();
		gbc_txtFldUsername.insets = new Insets(0, 0, 5, 5);
		gbc_txtFldUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFldUsername.gridx = 2;
		gbc_txtFldUsername.gridy = 1;
		contentPane.add(txtFldUsername, gbc_txtFldUsername);
		txtFldUsername.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtFldpassword = new JPasswordField();
		GridBagConstraints gbc_txtFldpassword = new GridBagConstraints();
		txtFldpassword.setEchoChar('*');
		gbc_txtFldpassword.insets = new Insets(0, 0, 5, 5);
		gbc_txtFldpassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFldpassword.gridx = 2;
		gbc_txtFldpassword.gridy = 3;
		contentPane.add(txtFldpassword, gbc_txtFldpassword);
		
		SoundPlayer playSound = SoundPlayer.getInstance();
		
		JRadioButton rdbtnShowPassword = new JRadioButton("Show password");
		rdbtnShowPassword.setForeground(Color.WHITE);
		rdbtnShowPassword.setBackground(Color.DARK_GRAY);
		rdbtnShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnShowPassword.isSelected())
				{
					txtFldpassword.setEchoChar((char) 0);
				}
				else
				{
					txtFldpassword.setEchoChar('*');
				}
			}
		});
		GridBagConstraints gbc_rdbtnShowPassword = new GridBagConstraints();
		gbc_rdbtnShowPassword.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnShowPassword.gridx = 2;
		gbc_rdbtnShowPassword.gridy = 4;
		contentPane.add(rdbtnShowPassword, gbc_rdbtnShowPassword);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound.click();
				String userName = txtFldUsername.getText();
				char[] passWord = txtFldpassword.getPassword();
				guiSetUserName(userName);
				guiSetPassWord(passWord);
				if(userName.length() < 13 && Array.getLength(passWord) < 13)
				{
					boolean logInSuccess = guiLogIntoAccount(); 
					if (logInSuccess){
						
						CurrentLogin currentLogin = CurrentLogin.getInstance();
						currentLogin.login(userName);
						
						playSound.click();
						AccountScreen account = new AccountScreen();
						account.openScreen();
						disposeCurrentScreen();
					}
				}
				else{
				JOptionPane.showMessageDialog(null, "password and username must be 12 or less characters");	
				}
			}
		});
		GridBagConstraints gbc_btnLogIn = new GridBagConstraints();
		btnLogIn.setBackground(BUTTONCOLOUR);
		gbc_btnLogIn.fill = GridBagConstraints.BOTH;
		gbc_btnLogIn.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogIn.gridx = 2;
		gbc_btnLogIn.gridy = 5;
		contentPane.add(btnLogIn, gbc_btnLogIn);
		
		JButton btnReturnToMenu = new JButton("Return to menu");
		btnReturnToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToStartMenu();
			}
		});
		GridBagConstraints gbc_btnReturnToMenu = new GridBagConstraints();
		btnReturnToMenu.setBackground(BUTTONCOLOUR);
		gbc_btnReturnToMenu.fill = GridBagConstraints.BOTH;
		gbc_btnReturnToMenu.insets = new Insets(0, 0, 0, 5);
		gbc_btnReturnToMenu.gridx = 2;
		gbc_btnReturnToMenu.gridy = 7;
		contentPane.add(btnReturnToMenu, gbc_btnReturnToMenu);
	}

}
