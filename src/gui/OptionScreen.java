package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import processing.GameManager;
import processing.SoundPlayer;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JSlider;
import java.awt.Insets;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.awt.event.ActionEvent;

/**
 * Class OptionScreen creates a screen that enables editing of sound and difficulty level.
 *
 */
@SuppressWarnings("serial")
public class OptionScreen extends GUISuperClass {

	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionScreen frame = new OptionScreen();
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
	public OptionScreen() {
		setTitle("options");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setScreenSize();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{300, 200, 200, 300};
		gbl_contentPane.rowHeights = new int[]{50, 50, 300,0,0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0,1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0,0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblOptions = new JLabel("Options");
		lblOptions.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblOptions = new GridBagConstraints();
		gbc_lblOptions.insets = new Insets(0, 0, 5, 5);
		gbc_lblOptions.gridwidth = 4;
		gbc_lblOptions.gridx = 0;
		gbc_lblOptions.gridy = 0;
		lblOptions.setFont(new Font(FONT, Font.PLAIN, 45));
		contentPane.add(lblOptions, gbc_lblOptions);
		
		JLabel lblSetYourDifficulty = new JLabel("Set your difficulty:");
		lblSetYourDifficulty.setForeground(Color.WHITE);
		lblSetYourDifficulty.setFont(new Font(FONT, Font.PLAIN, 18));
		GridBagConstraints gbc_lblSetYourDifficulty = new GridBagConstraints();
		gbc_lblSetYourDifficulty.insets = new Insets(0, 0, 5, 5);
		gbc_lblSetYourDifficulty.gridx = 1;
		gbc_lblSetYourDifficulty.gridy = 1;
		contentPane.add(lblSetYourDifficulty, gbc_lblSetYourDifficulty);
		
		JSlider difficultySlider = new JSlider();
		difficultySlider.setToolTipText("Set your lives between 1 and 7");
		difficultySlider.setMinimum(1);
		difficultySlider.setMaximum(7);
		difficultySlider.setValue(7);
		difficultySlider.setOrientation(SwingConstants.VERTICAL);
		difficultySlider.setMajorTickSpacing(1);
		difficultySlider.setPaintTicks(true);
		difficultySlider.setSnapToTicks(true);
		GridBagConstraints gbc_difficultySlider = new GridBagConstraints();
		gbc_difficultySlider.anchor = GridBagConstraints.CENTER;
		gbc_difficultySlider.fill = GridBagConstraints.BOTH;
		gbc_difficultySlider.insets = new Insets(0, 5, 5, 5);
		gbc_difficultySlider.gridx = 1;
		gbc_difficultySlider.gridy = 2;
		contentPane.add(difficultySlider, gbc_difficultySlider);
		
		Hashtable<Integer, JLabel> difficultyLabelTable = new Hashtable<>();
		JLabel L1 = new JLabel("You can't be serious");
		JLabel L2 = new JLabel("Insane");
		JLabel L3 = new JLabel("A little insane");
		JLabel L4 = new JLabel("Hard");
		JLabel L5 = new JLabel("Getting harder");
		JLabel L6 = new JLabel("A tiny bit harder");
		JLabel L7 = new JLabel("Regular");
		
		L1.setForeground(Color.WHITE);
		L2.setForeground(Color.WHITE);
		L3.setForeground(Color.WHITE);
		L4.setForeground(Color.WHITE);
		L5.setForeground(Color.WHITE);
		L6.setForeground(Color.WHITE);
		L7.setForeground(Color.WHITE);		

		difficultyLabelTable.put(1, L1);
		difficultyLabelTable.put(2, L2);
		difficultyLabelTable.put(3, L3);
		difficultyLabelTable.put(4, L4);
		difficultyLabelTable.put(5, L5);
		difficultyLabelTable.put(6, L6);
		difficultyLabelTable.put(7, L7);
		difficultySlider.setLabelTable(difficultyLabelTable);
		difficultySlider.setPaintLabels(true);
		difficultySlider.setBackground(Color.DARK_GRAY);
		
		SoundPlayer playSound = SoundPlayer.getInstance();
		
		JSlider volumeSlider = new JSlider();
		volumeSlider.setToolTipText("Set volume");
		volumeSlider.setMinimum(0);
		volumeSlider.setMaximum(100);
		volumeSlider.setValue(playSound.getVolume());
		volumeSlider.setOrientation(SwingConstants.VERTICAL);
		volumeSlider.setMajorTickSpacing(20);
		volumeSlider.setPaintTicks(true);
		volumeSlider.setSnapToTicks(false);
		GridBagConstraints gbc_volumeSlider = new GridBagConstraints();

		gbc_volumeSlider.anchor = GridBagConstraints.CENTER;
		gbc_volumeSlider.fill = GridBagConstraints.BOTH;
		gbc_volumeSlider.insets = new Insets(0, 5, 5, 5);
		gbc_volumeSlider.gridx = 2;
		gbc_volumeSlider.gridy = 2;
		contentPane.add(volumeSlider, gbc_volumeSlider);
		
		Hashtable<Integer, JLabel> volumeLabelTable = new Hashtable<>();
		JLabel JL1 = new JLabel("0");
		JLabel JL2 = new JLabel("20");
		JLabel JL3 = new JLabel("40");
		JLabel JL4 = new JLabel("60");
		JLabel JL5 = new JLabel("80");
		JLabel JL6 = new JLabel("100");
		JL1.setForeground(Color.WHITE);
		JL2.setForeground(Color.WHITE);
		JL3.setForeground(Color.WHITE);
		JL4.setForeground(Color.WHITE);
		JL5.setForeground(Color.WHITE);
		JL6.setForeground(Color.WHITE);
		volumeLabelTable.put(0, JL1);
		volumeLabelTable.put(20, JL2);
		volumeLabelTable.put(40, JL3);
		volumeLabelTable.put(60, JL4);
		volumeLabelTable.put(80, JL5);
		volumeLabelTable.put(100, JL6);
		volumeSlider.setLabelTable(volumeLabelTable);
		volumeSlider.setBackground(Color.DARK_GRAY);
		volumeSlider.setPaintLabels(true);
		
		JLabel lblSetYourVolume = new JLabel("Set volume:");
		lblSetYourVolume.setForeground(Color.WHITE);
		lblSetYourVolume.setFont(new Font(FONT, Font.PLAIN, 18));
		GridBagConstraints gbc_lblSetYourVolume = new GridBagConstraints();
		gbc_lblSetYourVolume.insets = new Insets(0, 0, 5, 5);
		gbc_lblSetYourVolume.gridx = 2;
		gbc_lblSetYourVolume.gridy = 1;
		contentPane.add(lblSetYourVolume, gbc_lblSetYourVolume);

		volumeSlider.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent e) {
		        int newVolume = volumeSlider.getValue();
		        playSound.setVolume(newVolume);
		      }
		    });
		
		
		JButton btnReturn = new JButton("Return to menu");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToMenu();
				}
		});
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound.click();
				GameManager gameManager = new GameManager(difficultySlider.getValue());
				
				gameManager.startMainFrame();
				disposeCurrentScreen();
				
			}
		});
		
				
		btnStartGame.setToolTipText("Start Game with selected difficulty");
		GridBagConstraints gbc_btnStartGame = new GridBagConstraints();
		gbc_btnStartGame.fill = GridBagConstraints.BOTH;
		gbc_btnStartGame.insets = new Insets(15, 0, 5, 5);
		gbc_btnStartGame.gridwidth = 2;
		gbc_btnStartGame.gridx = 1;
		gbc_btnStartGame.gridy = 3;
		btnStartGame.setBackground(BUTTONCOLOUR);
		contentPane.add(btnStartGame, gbc_btnStartGame);
		btnReturn.setToolTipText("");
		btnReturn.setBackground(BUTTONCOLOUR);
		GridBagConstraints gbc_btnReturn = new GridBagConstraints();
		gbc_btnReturn.insets = new Insets(0, 0, 0, 5);
		gbc_btnReturn.fill = GridBagConstraints.BOTH;
		gbc_btnReturn.gridwidth = 2;
		gbc_btnReturn.gridx = 1;
		gbc_btnReturn.gridy = 4;
		contentPane.add(btnReturn, gbc_btnReturn);

	}


}
