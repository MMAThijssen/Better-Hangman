package gui;


import java.awt.Color;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import processing.CurrentLogin;
import processing.GameManager;

import java.awt.GridBagLayout;
import java.awt.Image;

import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Class StartScreen creates a screen with the options to start a game, log in, create a new 
 * account, go to option, get the high scores or exit.
 *
 */
@SuppressWarnings("serial")
public class StartScreen extends GUISuperClass {

	private int initialLives = 7;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartScreen frame = new StartScreen();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	CurrentLogin current = CurrentLogin.getInstance();
	
	/**
	 * Create the frame.
	 */
	public StartScreen() {
		setTitle("The Ultimate Hangman");
		setResizable(true);
		setScreenSize();		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{250, 250, 250, 250};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel startScreenImage = new JLabel();
		startScreenImage.setBackground(SystemColor.control);
		ImageIcon startImage = new ImageIcon(new ImageIcon("../BetterHangman/data/startscreen/hangmanstartscreen.png").getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT));
		startScreenImage.setIcon(startImage);
		GridBagConstraints gbc_startScreenImage = new GridBagConstraints();
		gbc_startScreenImage.insets = new Insets(0, 0, 5, 0);
		gbc_startScreenImage.gridwidth = 4;
		gbc_startScreenImage.anchor = GridBagConstraints.CENTER;
		gbc_startScreenImage.gridx = 0;
		gbc_startScreenImage.gridy = 0;
		contentPane.add(startScreenImage, gbc_startScreenImage);

		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playSound.click();
				GameManager gameManager = new GameManager(initialLives);
				gameManager.startMainFrame();
				disposeCurrentScreen();
			}
		});
		
		btnStartGame.setToolTipText("Press to start the game.");
		GridBagConstraints gbc_btnStartGame = new GridBagConstraints();
		gbc_btnStartGame.insets = new Insets(0, 0, 5, 0);
		gbc_btnStartGame.fill = GridBagConstraints.BOTH;
		gbc_btnStartGame.gridwidth = 2;
		gbc_btnStartGame.gridx = 1;
		gbc_btnStartGame.gridy = 1;
		btnStartGame.setBackground(BUTTONCOLOUR);
		//btnStartGame.Button.darkShadow(new Color(124,142,92));
		contentPane.add(btnStartGame, gbc_btnStartGame);
		
		JButton loginButton = new JButton("Log In");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound.click();
				if (current.getLogin() == null){
					LoginScreen login = new LoginScreen();
					login.openScreen();
					disposeCurrentScreen();
				}
				else {
					AccountScreen account = new AccountScreen();
					account.openScreen();
					disposeCurrentScreen();
				}
			}
		});
		
		GridBagConstraints gbc_LoginButton = new GridBagConstraints();
		gbc_LoginButton.insets = new Insets(0, 0, 5, 3);
		gbc_LoginButton.fill = GridBagConstraints.BOTH;
		gbc_LoginButton.gridx = 1;
		gbc_LoginButton.gridy = 2;
		loginButton.setBackground(BUTTONCOLOUR);
		contentPane.add(loginButton, gbc_LoginButton);
		
		JButton createAccountButton = new JButton("Create Account");
		createAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound.click();
				CreateAccountScreen createAccount = new CreateAccountScreen();
				createAccount.setLocationRelativeTo(null);
				createAccount.setVisible(true);
				disposeCurrentScreen();
			}
		});
		
		GridBagConstraints gbc_CreateAccountButton = new GridBagConstraints();
		createAccountButton.setBackground(BUTTONCOLOUR);
		gbc_CreateAccountButton.insets = new Insets(0, 0, 5, 3);
		gbc_CreateAccountButton.fill = GridBagConstraints.BOTH;
		gbc_CreateAccountButton.gridx = 1;
		gbc_CreateAccountButton.gridy = 3;
		contentPane.add(createAccountButton, gbc_CreateAccountButton);
		
		JButton btnOptions = new JButton("Options");
		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playSound.click();
				OptionScreen options = new OptionScreen();
				options.openScreen();
				disposeCurrentScreen();
			}
		});
		
		btnOptions.setToolTipText("Set options to be declared.");
		btnOptions.setBackground(BUTTONCOLOUR);
		GridBagConstraints gbc_btnOptions = new GridBagConstraints();
		gbc_btnOptions.insets = new Insets(0, 3, 5, 0);
		gbc_btnOptions.fill = GridBagConstraints.BOTH;
		gbc_btnOptions.gridx = 2;
		gbc_btnOptions.gridy = 2;
		contentPane.add(btnOptions, gbc_btnOptions);
		
		JButton btnHighscores = new JButton("Highscores");
		btnHighscores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound.click();
				HighscoreScreen score = new HighscoreScreen();
				score.openScreen();
				disposeCurrentScreen();
			}
		});
	
		btnHighscores.setToolTipText("Show highscores");
		btnHighscores.setBackground(BUTTONCOLOUR);
		GridBagConstraints gbc_btnHighscores = new GridBagConstraints();
		gbc_btnHighscores.insets = new Insets(0, 3, 5, 0);
		gbc_btnHighscores.fill = GridBagConstraints.BOTH;
		gbc_btnHighscores.gridx = 2;
		gbc_btnHighscores.gridy = 3;
		contentPane.add(btnHighscores, gbc_btnHighscores);
	
		JButton btnQuit = new JButton("Exit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playSound.click();
				disposeCurrentScreen();
			}
		});
		
		btnQuit.setToolTipText("Exit the game.");
		btnQuit.setBackground(BUTTONCOLOUR);
		GridBagConstraints gbc_btnQuit = new GridBagConstraints();
		gbc_btnQuit.insets = new Insets(0, 0, 0, 0);
		gbc_btnQuit.fill = GridBagConstraints.BOTH;
		gbc_btnQuit.gridwidth = 2;
		gbc_btnQuit.gridx = 1;
		gbc_btnQuit.gridy = 4;
		contentPane.add(btnQuit, gbc_btnQuit);
		

	}	
}
