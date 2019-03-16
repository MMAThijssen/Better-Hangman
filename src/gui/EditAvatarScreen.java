package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import processing.CurrentLogin;

import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JSlider;

/**
 * Class EditAvatarScreen creates a screen that enables editing of the avatar.
 *
 */
@SuppressWarnings("serial")
public class EditAvatarScreen extends AccountGUISuperClass {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditAvatarScreen frame = new EditAvatarScreen();
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
	public EditAvatarScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setScreenSize();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{300, 400, 300};
		gbl_contentPane.rowHeights = new int[]{200, 0, 300, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		CurrentLogin currentLogin = CurrentLogin.getInstance();
		
		JLabel lblEditAvatar = new JLabel("Edit avatar");
		lblEditAvatar.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblEditAvatar = new GridBagConstraints();
		gbc_lblEditAvatar.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditAvatar.gridwidth = 3;
		gbc_lblEditAvatar.gridx = 0;
		gbc_lblEditAvatar.gridy = 0;
		lblEditAvatar.setFont(new Font(FONT, Font.PLAIN, 45));
		contentPane.add(lblEditAvatar, gbc_lblEditAvatar);
		
		JLabel lblUsername = new JLabel("User: " + currentLogin.getLogin());
		lblUsername.setFont(textFont);
		lblUsername.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.CENTER;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 0);
		gbc_lblUsername.gridx = 2;
		gbc_lblUsername.gridy = 0;
		contentPane.add(lblUsername, gbc_lblUsername);
		
		
		
		JLabel lblSetYourAccount = new JLabel("Choose your account avatar:");
		lblSetYourAccount.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblSetYourAccount = new GridBagConstraints();
		gbc_lblSetYourAccount.insets = new Insets(0, 0, 15, 5);
		gbc_lblSetYourAccount.gridx = 1;
		gbc_lblSetYourAccount.gridy = 1;
		contentPane.add(lblSetYourAccount, gbc_lblSetYourAccount);
		
		JSlider avatarSlider = new JSlider();
		avatarSlider.setToolTipText("Choose your account avatar");
		avatarSlider.setMinimum(1);
		avatarSlider.setMaximum(5);
		avatarSlider.setValue(guiGetAvatar()); // Should take avatar integer from database 
		avatarSlider.setOrientation(SwingConstants.VERTICAL);
		avatarSlider.setMajorTickSpacing(1);
		avatarSlider.setPaintTicks(true);
		avatarSlider.setSnapToTicks(true);
		GridBagConstraints gbc_avatarSlider = new GridBagConstraints();
		gbc_avatarSlider.anchor = GridBagConstraints.CENTER;
		gbc_avatarSlider.fill = GridBagConstraints.BOTH;
		gbc_avatarSlider.insets = new Insets(0, 5, 5, 5);
		gbc_avatarSlider.gridx = 1;
		gbc_avatarSlider.gridy = 2;
		contentPane.add(avatarSlider, gbc_avatarSlider);
		
		Hashtable<Integer, JLabel> avatarTable = new Hashtable<>();
		JLabel L1 = new JLabel("Rabbit");
		JLabel L2 = new JLabel("Deer");
		JLabel L3 = new JLabel("Badger");
		JLabel L4 = new JLabel("Fox");
		JLabel L5 = new JLabel("Bear");
		
		L1.setForeground(Color.WHITE);
		L2.setForeground(Color.WHITE);
		L3.setForeground(Color.WHITE);
		L4.setForeground(Color.WHITE);
		L5.setForeground(Color.WHITE);
		
		avatarTable.put(1, L1);
		avatarTable.put(2, L2);
		avatarTable.put(3, L3);
		avatarTable.put(4, L4);
		avatarTable.put(5, L5);
		avatarSlider.setLabelTable(avatarTable);
		avatarSlider.setPaintLabels(true);
		avatarSlider.setBackground(Color.DARK_GRAY);

		
		JButton btnReturnToMenu = new JButton("Return to Menu");
		btnReturnToMenu.setBackground(BUTTONCOLOUR);
		GridBagConstraints gbc_btnReturnToMenu = new GridBagConstraints();
		gbc_btnReturnToMenu.insets = new Insets(15, 0, 0, 5);
		gbc_btnReturnToMenu.fill = GridBagConstraints.BOTH;
		gbc_btnReturnToMenu.gridx = 1;
		gbc_btnReturnToMenu.gridy = 3;
		contentPane.add(btnReturnToMenu, gbc_btnReturnToMenu);
		
		btnReturnToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int avatarNumber = avatarSlider.getValue();
				guiEditAvatar(avatarNumber);
				backToMenu();
				}
		});
	}

}
