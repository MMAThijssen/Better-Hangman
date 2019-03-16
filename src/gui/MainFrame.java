package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import processing.GameLoop;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

/**
 * Class MainFrame creates a screen that displays the gallow, the word to guess, 
 * the letters that were guessed, score, avatar and username. 
 *
 */
public class MainFrame extends GUISuperClass implements Hangman {

	private static final long serialVersionUID = 1L;
	private JTextField entryInputLetter;
	private JButton btnGo;
	private JLabel lblWordField;
	private JLabel lblGallow;
	private JTextPane txtpnGuessedWrongLetters;
	private JButton btnRestart;
	private JTextComponent instructions;
	private JButton btnReturn;
	
	GameLoop gameLoop;
	
	private JLabel lblUsername;
	private JLabel lblTotalScore;
	private JLabel lblAvatar;
	
		
	/**
	 * Create the frame;
	 */
	public MainFrame(int initialLives) {
		gameLoop = new GameLoop(initialLives);	
		setLocationRelativeTo(null);
		setResizable(true);
		setScreenSize();
		setTitle("The Ultimate Hangman");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowHeights = new int[]{48, 200, 50, 403, 0, 45, 45};
		gbl_contentPane.columnWidths = new int[]{350, 376, 274};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, .0};
		contentPane.setLayout(gbl_contentPane);
		
		
		
		instructions = new JTextPane();
		instructions.setFont(textFont);
		instructions.setPreferredSize( new Dimension(500, 500));
		instructions.setEditable(false);
		instructions.setBackground(Color.DARK_GRAY);
		instructions.setForeground(Color.WHITE);
		instructions.setText(
				"Welcome to the Ultimate Hangman Game! \n\n"
				+ "You are trying the guess the name of an animal, with as few guesses as possible."
				+ "If the man is hung on the gallow, you lose. \n\n"
				+ "To start the game, enter your first letter in the field at the bottom "
				+ "and press either 'enter' or 'GO!'\n\n"
				+ "If you think you know the animal, you may also guess the whole word at once. "
				+ "However, if you are mistaken, you will take an extra penalty..."
				+ "\n\nGood luck!");
		GridBagConstraints gbc_instructions = new GridBagConstraints();
		gbc_instructions.fill = GridBagConstraints.BOTH;
		gbc_instructions.gridheight = 4;
		gbc_instructions.anchor = GridBagConstraints.NORTHWEST;
		gbc_instructions.insets = new Insets(5, 5, 5, 5);
		gbc_instructions.gridx = 0;
		gbc_instructions.gridy = 0;
		gbc_instructions.gridwidth = 2;
		contentPane.add(instructions, gbc_instructions);

		lblGallow = new JLabel("");
//		lblGallow.setHorizontalAlignment(SwingConstants.NORTH_WEST);
		
		GridBagConstraints gbc_lblGallow = new GridBagConstraints();
		gbc_lblGallow.anchor = GridBagConstraints.CENTER;
		gbc_lblGallow.weighty = 0;
		gbc_lblGallow.weightx = 0;
		gbc_lblGallow.gridwidth = 2;
		gbc_lblGallow.gridheight = 4;
		gbc_lblGallow.insets = new Insets(5, 5, 5, 5);
		gbc_lblGallow.gridx = 0;
		gbc_lblGallow.gridy = 0;
//		lblGallow.setBounds( 10, 10, 400, 400);
		lblGallow.setVisible(true);
		

		
		lblUsername = new JLabel(gameLoop.getUsername());
		lblUsername.setFont(textFont);
		lblUsername.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.WEST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 0);
		gbc_lblUsername.gridx = 2;
		gbc_lblUsername.gridy = 0;
		contentPane.add(lblUsername, gbc_lblUsername);
		
		int x = 200;
		int y = 200;
		lblAvatar = new JLabel("");
		lblAvatar.setPreferredSize( new Dimension(x, y));
		GridBagConstraints gbc_lblAvatar = new GridBagConstraints();
		gbc_lblAvatar.anchor = GridBagConstraints.WEST;
		gbc_lblAvatar.insets = new Insets(0, 0, 5, 0);
		gbc_lblAvatar.gridx = 2;
		gbc_lblAvatar.gridy = 1;
		
		if (gameLoop.getUsername() == null) {
			}
		else {
			Image avatarIcon = gameLoop.getAvatar();
			lblAvatar.setIcon(new ImageIcon(avatarIcon));
			}
	
		contentPane.add(lblAvatar, gbc_lblAvatar);
		
		
		
		
		lblTotalScore = new JLabel();
		if (gameLoop.getUsername() == null) {
			lblTotalScore.setText("You're not logged in");
			}
		else {
			lblTotalScore.setText("Score: " + gameLoop.getTotalScore());
			}
		lblTotalScore.setFont(textFont);
		lblTotalScore.setForeground(Color.WHITE);
		
		GridBagConstraints gbc_lblTotalScore = new GridBagConstraints();
		gbc_lblTotalScore.anchor = GridBagConstraints.WEST;
		gbc_lblTotalScore.insets = new Insets(5, 5, 5, 5);
		gbc_lblTotalScore.gridx = 2;
		gbc_lblTotalScore.gridy = 2;
		contentPane.add(lblTotalScore, gbc_lblTotalScore);
		contentPane.add(lblGallow,gbc_lblGallow);
		
		txtpnGuessedWrongLetters = new JTextPane();
		txtpnGuessedWrongLetters.setEditable(false);
		txtpnGuessedWrongLetters.setBackground(SystemColor.DARK_GRAY);
		txtpnGuessedWrongLetters.setForeground(Color.WHITE);
		txtpnGuessedWrongLetters.setFont(textFont);
		txtpnGuessedWrongLetters.setText("Guessed letters:");
		GridBagConstraints gbc_txtpnGuessedWrongLetters = new GridBagConstraints();
		gbc_txtpnGuessedWrongLetters.fill = GridBagConstraints.BOTH;
		gbc_txtpnGuessedWrongLetters.anchor = GridBagConstraints.NORTH;
		gbc_txtpnGuessedWrongLetters.insets = new Insets(5, 5, 5, 0);
		gbc_txtpnGuessedWrongLetters.gridx = 2;
		gbc_txtpnGuessedWrongLetters.gridy = 3;
		contentPane.add(txtpnGuessedWrongLetters, gbc_txtpnGuessedWrongLetters);
		
		lblWordField = new JLabel(gameLoop.getCorrectlyGuessedString(), SwingConstants.CENTER);
		lblWordField.setFont(correctWordFont);
		lblWordField.setForeground(Color.WHITE);
		lblWordField.setPreferredSize(new Dimension(400, 90));
		GridBagConstraints gbc_lblWordField = new GridBagConstraints();
		gbc_lblWordField.gridwidth = 2;
		gbc_lblWordField.insets = new Insets(5, 5, 5, 5);
		gbc_lblWordField.gridx = 0;
		gbc_lblWordField.gridy = 4;
		contentPane.add(lblWordField, gbc_lblWordField);
		
		JLabel lblMessage = new JLabel("Guess a letter:");
		lblMessage.setForeground(Color.WHITE);
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setPreferredSize(new Dimension(400, 50));
		lblMessage.setFont(buttonFont);

		GridBagConstraints gbc_lblGuessLetter = new GridBagConstraints();
		gbc_lblGuessLetter.gridwidth = 2;
		gbc_lblGuessLetter.insets = new Insets(5, 5, 5, 5);
		gbc_lblGuessLetter.gridx = 0;
		gbc_lblGuessLetter.gridy = 5;
		contentPane.add(lblMessage, gbc_lblGuessLetter);
		
		btnReturn = new JButton("Return to menu");
		btnReturn.setPreferredSize(new Dimension(100, 50));
		btnReturn.setFont(buttonFont);
		btnReturn.setBackground(BUTTONCOLOUR);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToMenu();
			}
		});
		GridBagConstraints gbc_btnReturn = new GridBagConstraints();
		gbc_btnReturn.fill = GridBagConstraints.BOTH;
		gbc_btnReturn.insets = new Insets(0, 0, 5, 0);
		gbc_btnReturn.gridx = 2;
		gbc_btnReturn.gridy = 5;
		contentPane.add(btnReturn, gbc_btnReturn);
		
		entryInputLetter = new JTextField();
		entryInputLetter.setHorizontalAlignment(SwingConstants.CENTER);
		entryInputLetter.setFont(buttonFont);
		entryInputLetter.setPreferredSize(new Dimension(100, 50));
		GridBagConstraints gbc_entryInputLetter = new GridBagConstraints();
		gbc_entryInputLetter.fill = GridBagConstraints.BOTH;
		gbc_entryInputLetter.anchor = GridBagConstraints.EAST;
		gbc_entryInputLetter.insets = new Insets(0, 5, 0, 5);
		gbc_entryInputLetter.gridx = 0;
		gbc_entryInputLetter.gridy = 6;
		contentPane.add(entryInputLetter, gbc_entryInputLetter);
		entryInputLetter.setColumns(3);
		
		class WordListener implements ActionListener   {			
			public void actionPerformed(ActionEvent arg0) {
				// This code creates a new Thread, which enables us to update the GUI, while also
				// processing the guess. This will be useful, especially, because we want to update
				// several parts of the GUI (WordField, GuessedWrongLetter) when processing the
				// guessed Input.
				
				Thread guess = new Thread(new Runnable() {
					@Override
					public void run() {
						
						String guess=entryInputLetter.getText();
						gameLoop.giveGuess(guess);
						lblMessage.setText(gameLoop.getMessage());
						
						instructions.setVisible(false);
						
						gameLoop.updateGame(MainFrame.this);
						
						gameLoop.checkGameState();
						reset();
						
					}
				});
				guess.start();
				
			}
		}

		
		btnGo = new JButton("GO!");
		btnGo.setPreferredSize(new Dimension(100, 50));
		btnGo.setFont(buttonFont);
		btnGo.setBackground(BUTTONCOLOUR);

		btnGo.addActionListener(new WordListener());
		GridBagConstraints gbc_btnGo = new GridBagConstraints();
		gbc_btnGo.fill = GridBagConstraints.VERTICAL;
		gbc_btnGo.anchor = GridBagConstraints.WEST;
		gbc_btnGo.gridx = 1;
		gbc_btnGo.gridy = 6;
		contentPane.add(btnGo, gbc_btnGo);
		entryInputLetter.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					WordListener go = new WordListener();
					go.actionPerformed(null);
				}
			}
		});
				
		btnRestart = new JButton("Restart");
		btnRestart.setFont(buttonFont);
		btnRestart.setPreferredSize(new Dimension(100, 50));
		btnRestart.setBackground(BUTTONCOLOUR);


		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playSound.click();
				gameLoop = new GameLoop(initialLives);
				gameLoop.updateGame(MainFrame.this);
				
				if (gameLoop.getUsername() == null) {
					lblTotalScore.setText("You're not logged in");
					}
				else {
					lblTotalScore.setText("Score: " + gameLoop.getTotalScore());
					}
			}
		});
		GridBagConstraints gbc_btnRestart = new GridBagConstraints();
		gbc_btnRestart.fill = GridBagConstraints.BOTH;
		gbc_btnRestart.gridx = 2;
		gbc_btnRestart.gridy = 6;
		contentPane.add(btnRestart, gbc_btnRestart);
	}

	public void reset() {
		      entryInputLetter.setText("");
		}
	
	/* (non-Javadoc)
	 * @see GUI.Hangman#updateHangman()
	 */
	@Override
	public void updateHangman() {
		Image image = gameLoop.getImage();

		lblGallow.setIcon(new ImageIcon(image));
		// update correctly guessed field
		lblWordField.setText(gameLoop.getCorrectlyGuessedString());
		
		// update incorrectly guessed field
		txtpnGuessedWrongLetters.setText("Guessed letters:" + 
		gameLoop.getIncorrectlyGuessedString());
	}
	
	

}
