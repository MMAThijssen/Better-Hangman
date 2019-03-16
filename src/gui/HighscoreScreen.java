package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;

import sql.AccountManager;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Class HighScoreScreen creates a screen that displays the highscore.
 *
 */
@SuppressWarnings("serial")
public class HighscoreScreen extends GUISuperClass {
	char[] password = {};
	AccountManager setPanes = new AccountManager("", password);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HighscoreScreen frame = new HighscoreScreen();
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
	public HighscoreScreen() {
		contentPane = new JPanel();
		setResizable(false);
		setTitle("High scores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setScreenSize();
		setContentPane(contentPane);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 400, 400, 100};
		gridBagLayout.rowHeights = new int[]{100, 50, 150, 0,0,0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0,1.0,0.0, Double.MIN_VALUE};
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setLayout(gridBagLayout);
		
		JLabel lblScores = new JLabel("Highscores");
		lblScores.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblScores = new GridBagConstraints();
		gbc_lblScores.insets = new Insets(0, 0, 5, 5);
		gbc_lblScores.gridwidth = 4;
		gbc_lblScores.gridx = 0;
		gbc_lblScores.gridy = 0;
		lblScores.setFont(new Font(FONT, Font.PLAIN, 45));
		contentPane.add(lblScores, gbc_lblScores);
		
		JLabel lblTopHighscores = new JLabel("Top 10 highscores");
		lblTopHighscores.setForeground(Color.WHITE);
		lblTopHighscores.setFont(new Font(FONT, Font.PLAIN, 18));
		GridBagConstraints gbc_lblTopHighscores = new GridBagConstraints();
		gbc_lblTopHighscores.insets = new Insets(0, 0, 5, 5);
		gbc_lblTopHighscores.gridx = 1;
		gbc_lblTopHighscores.gridy = 1;
		getContentPane().add(lblTopHighscores, gbc_lblTopHighscores);
		
		JLabel lblTopTotal = new JLabel("Top 10 total scores");
		lblTopTotal.setForeground(Color.WHITE);
		lblTopTotal.setFont(new Font(FONT, Font.PLAIN, 18));
		GridBagConstraints gbc_lblTopTotal = new GridBagConstraints();
		gbc_lblTopTotal.insets = new Insets(0, 0, 5, 0);
		gbc_lblTopTotal.gridx = 2;
		gbc_lblTopTotal.gridy = 1;
		getContentPane().add(lblTopTotal, gbc_lblTopTotal);
		
		JTextArea textAreaHighScores = new JTextArea();
		textAreaHighScores.setText(setPanes.showTopTenHighScores());
		textAreaHighScores.setFont(new Font("monospaced", Font.PLAIN, 12));
		GridBagConstraints gbc_textAreaHighScores = new GridBagConstraints();
		gbc_textAreaHighScores.weighty = 1.0;
		gbc_textAreaHighScores.weightx = 1.0;
		gbc_textAreaHighScores.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaHighScores.fill = GridBagConstraints.BOTH;
		gbc_textAreaHighScores.gridx = 1;
		gbc_textAreaHighScores.gridy = 2;
		getContentPane().add(textAreaHighScores, gbc_textAreaHighScores);
		
		JTextArea textAreaTotalScores = new JTextArea();
		textAreaTotalScores.setText(setPanes.showTopFiveTotalScores());
		textAreaTotalScores.setFont(new Font("monospaced", Font.PLAIN, 12));
		GridBagConstraints gbc_textAreaTotalScores = new GridBagConstraints();
		gbc_textAreaTotalScores.weighty = 1.0;
		gbc_textAreaTotalScores.weightx = 1.0;
		gbc_textAreaTotalScores.insets = new Insets(0, 0, 5, 0);
		gbc_textAreaTotalScores.fill = GridBagConstraints.BOTH;
		gbc_textAreaTotalScores.gridx = 2;
		gbc_textAreaTotalScores.gridy = 2;
		getContentPane().add(textAreaTotalScores, gbc_textAreaTotalScores);
		
		JButton btnBackToMenu = new JButton("Return to menu");
		btnBackToMenu.setBackground(BUTTONCOLOUR);
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToMenu();
			}
		});
		GridBagConstraints gbc_btnBackToMenu = new GridBagConstraints();
		gbc_btnBackToMenu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBackToMenu.anchor = GridBagConstraints.NORTH;
		gbc_btnBackToMenu.gridx = 2;
		gbc_btnBackToMenu.gridy = 3;
		getContentPane().add(btnBackToMenu, gbc_btnBackToMenu);
	}

}
