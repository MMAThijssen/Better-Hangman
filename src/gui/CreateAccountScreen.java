package gui;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import processing.CurrentLogin;
import processing.SoundPlayer;

/**
 * Class CreateAccountScreen holds the constructor and method to create 
 * a screen for creating an account.
 *
 */
@SuppressWarnings("serial")
public class CreateAccountScreen extends AccountGUISuperClass {

	private JPasswordField passFldEnterPassWord;
	private JPasswordField passFldConfirmPassWord;
	private JTextField txtFldEnterUserName;
	private GridBagConstraints gbc_passFldEnterPassWord;
	private final String pwContainsForbidden = "Please don't use the following symbols in your username" +
			"\nor your password: '    \"   \\";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccountScreen frame = new CreateAccountScreen();
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
	public CreateAccountScreen() {
		setResizable(false);
		setTitle("Create Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setScreenSize();
		setResizable(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{200, 100, 400, 300};
		gbl_contentPane.rowHeights = new int[]{200, 0, 0, 0, 0, 0, 0, 0, 20, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblCreateAccount = new JLabel("Create account");
		lblCreateAccount.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblCreateAccount = new GridBagConstraints();
		gbc_lblCreateAccount.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreateAccount.gridwidth = 4;
		gbc_lblCreateAccount.gridx = 0;
		gbc_lblCreateAccount.gridy = 0;
		lblCreateAccount.setFont(new Font(FONT, Font.PLAIN, 45));
		contentPane.add(lblCreateAccount, gbc_lblCreateAccount);
		
		JLabel lblUserName = new JLabel("Username:");
		lblUserName.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblUserName = new GridBagConstraints();
		gbc_lblUserName.anchor = GridBagConstraints.EAST;
		gbc_lblUserName.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserName.gridx = 1;
		gbc_lblUserName.gridy = 3;
		contentPane.add(lblUserName, gbc_lblUserName);
		
		txtFldEnterUserName = new JTextField();
		GridBagConstraints gbc_txtFldEnterUserName = new GridBagConstraints();
		gbc_txtFldEnterUserName.insets = new Insets(0, 0, 5, 5);
		gbc_txtFldEnterUserName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFldEnterUserName.gridx = 2;
		gbc_txtFldEnterUserName.gridy = 3;
		contentPane.add(txtFldEnterUserName, gbc_txtFldEnterUserName);
		txtFldEnterUserName.setColumns(10);
		
		JLabel lblEnterPassWord = new JLabel("Password:");
		lblEnterPassWord.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblEnterPassWord = new GridBagConstraints();
		gbc_lblEnterPassWord.anchor = GridBagConstraints.EAST;
		gbc_lblEnterPassWord.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterPassWord.gridx = 1;
		gbc_lblEnterPassWord.gridy = 4;
		contentPane.add(lblEnterPassWord, gbc_lblEnterPassWord);
		
		passFldEnterPassWord = new JPasswordField();
		gbc_passFldEnterPassWord = new GridBagConstraints();
		gbc_passFldEnterPassWord.insets = new Insets(0, 0, 5, 5);
		gbc_passFldEnterPassWord.fill = GridBagConstraints.HORIZONTAL;
		gbc_passFldEnterPassWord.gridx = 2;
		gbc_passFldEnterPassWord.gridy = 4;
		contentPane.add(passFldEnterPassWord, gbc_passFldEnterPassWord);

		
		JLabel lblConfirmPassword = new JLabel("Confirm password:");
		lblConfirmPassword.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblConfirmPassword = new GridBagConstraints();
		gbc_lblConfirmPassword.anchor = GridBagConstraints.EAST;
		gbc_lblConfirmPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmPassword.gridx = 1;
		gbc_lblConfirmPassword.gridy = 5;
		contentPane.add(lblConfirmPassword, gbc_lblConfirmPassword);
		
		passFldConfirmPassWord = new JPasswordField();
		GridBagConstraints gbc_passFldConfirmPassWord = new GridBagConstraints();
		gbc_passFldConfirmPassWord.insets = new Insets(0, 0, 5, 5);
		gbc_passFldConfirmPassWord.fill = GridBagConstraints.HORIZONTAL;
		gbc_passFldConfirmPassWord.gridx = 2;
		gbc_passFldConfirmPassWord.gridy = 5;
		contentPane.add(passFldConfirmPassWord, gbc_passFldConfirmPassWord);
		
		SoundPlayer playSound = SoundPlayer.getInstance();
		
		JButton btnReturnToMenu = new JButton("Return to menu");
		btnReturnToMenu.setBackground(BUTTONCOLOUR);
		btnReturnToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToStartMenu();
			}
		});
		
		JRadioButton rdbtnShowPassword = new JRadioButton("Show Password");
		rdbtnShowPassword.setBackground(Color.DARK_GRAY);
		rdbtnShowPassword.setForeground(Color.WHITE);
		rdbtnShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnShowPassword.isSelected()){
					passFldEnterPassWord.setEchoChar((char) 0 ); 
					passFldConfirmPassWord.setEchoChar((char) 0 ); 
				}
				else{
					passFldEnterPassWord.setEchoChar('*' ); 
					passFldConfirmPassWord.setEchoChar('*'); 
				}
			}
		});
		GridBagConstraints gbc_rdbtnShowPassword = new GridBagConstraints();
		gbc_rdbtnShowPassword.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnShowPassword.gridx = 2;
		gbc_rdbtnShowPassword.gridy = 6;
		contentPane.add(rdbtnShowPassword, gbc_rdbtnShowPassword);
		
		JButton btnCreateAccount = new JButton("Create account");
		btnCreateAccount.setBackground(BUTTONCOLOUR);
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound.click();
				char[] enter = passFldEnterPassWord.getPassword();
				char[] confirm = passFldConfirmPassWord.getPassword();
				String userName = txtFldEnterUserName.getText();
				char[] passWord = passFldConfirmPassWord.getPassword();
				guiSetUserName(userName);
				guiSetPassWord(passWord);
				CurrentLogin login = CurrentLogin.getInstance();
				if (login.getLogin()!=null) {
					login.logout();
				}
				if(userName.length() != 0 && passWord.length !=0)
				{
					String passwordString = new String(passWord);
					if(userName.length() < 13 && Array.getLength(passWord) < 13)
					{
						if (userName.contains("'") || userName.contains("\"") || userName.contains("\\")
								|| passwordString.contains("'") || passwordString.contains("\"") || passwordString.contains("\\")) {
							JOptionPane.showMessageDialog(null, pwContainsForbidden);
						}
						else {
							if (guiFindAccount(userName) == false)
							{
								if (Arrays.equals(enter, confirm))
								{
									guiCreateNewAccount();
									login.login(userName);
									
									AccountScreen account = new AccountScreen();
									account.openScreen();
									disposeCurrentScreen();
								}
								else
								{
									Toolkit.getDefaultToolkit().beep();
									JOptionPane.showMessageDialog(null, "the entered passwords don't match");
								}
							}
							else
							{
								Toolkit.getDefaultToolkit().beep();
								JOptionPane.showMessageDialog(null, "That username is taken");	
							}
						}

					}
					else{
							JOptionPane.showMessageDialog(null, "password and username must be 12 or less characters");	
						}
				}else{
					JOptionPane.showMessageDialog(null, "username and password must be at least one character");
				}
			}
		});
		GridBagConstraints gbc_btnCreateAccount = new GridBagConstraints();
		gbc_btnCreateAccount.fill = GridBagConstraints.BOTH;
		gbc_btnCreateAccount.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateAccount.gridx = 2;
		gbc_btnCreateAccount.gridy = 7;
		contentPane.add(btnCreateAccount, gbc_btnCreateAccount);
		GridBagConstraints gbc_btnReturnToMenu = new GridBagConstraints();
		gbc_btnReturnToMenu.fill = GridBagConstraints.BOTH;
		gbc_btnReturnToMenu.insets = new Insets(0, 0, 0, 5);
		gbc_btnReturnToMenu.gridx = 2;
		gbc_btnReturnToMenu.gridy = 8;
		contentPane.add(btnReturnToMenu, gbc_btnReturnToMenu);
	}
	
}
