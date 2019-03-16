package sql;
import java.sql.*;

import javax.swing.JOptionPane;

import processing.CurrentLogin;
import processing.Utilities;

/**
 * 
 * Class FindAccount contains all methods to handle interaction with the database that stores user data.
 * It stores userdata like username, password and scores. It also stores the names of the columns in the
 * database and the error message for if the connection to the database fails.
 *
 */

public class AccountManager extends Utilities{
	
	public String userName;
	private String passWord;
	private int total_score;
	private int high_score;
	private int avatar;
	private static final String COLUMN1 = "user_name";
	private static final String COLUMN2 = "user_password";
	private static final String COLUMN3 = "total_score";
	private static final String COLUMN4 = "high_score";
	private static final String COLUMN5 = "avatar";
	private static final String CONFAIL = "Can't connect to database! Please check your internet connection!";
	private static final String USER_UNKNOWN_MSG = "Username not known";
	private static final String PASSWORD_UNKNOWN_MSG = "Password not known";
	private static final String ACCOUNT_CREATED_MSG = "account creation successful";
	private static final String UPDATE_MSG = "Update successful!";
	private static final String NAME_USED_MSG = "That name already exists";
	private static final String ACCOUNT_DELETE_MSG = "Account deletion successful!";
	
	/**
	 * Default constructor, sets the userName and passWord as null
	 */
	public AccountManager() {
		this.userName = null;
		this.passWord = null;
	}
	
	/**
	 * Overloaded constructor
	 * @param username
	 * @param password
	 */
	public AccountManager(String username, char[] password) {
		String passWordString = new String (password);
		this.userName = username;
		this.passWord = passWordString;
	}
	
	/**
	 * Returns a connection to the database with the given login data.
	 * Shows a message pop-up if the connection fails.
	 */
	public Connection connectToDB() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7233352", "sql7233352", "l7wrCjrYCH");
			return con;
		}
		catch (Exception e) {
			System.out.println(e);
			return con;
		}
		finally {
			if (con==null) {
				JOptionPane.showMessageDialog(null, CONFAIL);
			}
		}
	}


	/**
	 * Method to set username. 
	 * This method and the method setPassWord are used to enable us to put the AccountManager object into the GUI superclass and initiate
	 * it with null values, that is set to the user input when the respective buttons are clicked.
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName=userName;
	}
	
	/**
	 * Method to set password. 
	 * This method and the method setPassWord are used to enable us to put the AccountManager object into the GUI superclass and initiate
	 * it with null values, that is set to the user input when the respective buttons are clicked.
	 * @param passWord
	 */
	public void setPassWord(char[] passWord) {
		this.passWord=new String (passWord);
	}
	
	
	/**
	 * Returns the username.
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Returns password.
	 */
	public String getPassWord() {
		return passWord;
	}
	
	/**
	 * Returns a users total score.
	 */
	public int getTotalScore() {
		Connection con = connectToDB();
		if (con!=null) {
			try {
				PreparedStatement preSt = con.prepareStatement("SELECT total_score FROM user WHERE user_name=\""+userName+"\"");
				ResultSet rs1 = preSt.executeQuery();
				rs1.next();
				this.total_score = rs1.getInt(COLUMN3);
			} 
			catch(Exception e) {
				System.out.println(e);
			}
			finally {
				terminateConnection(con);
			}
		}
		return total_score;
	}
	
	/**
	 * Returns a users high score.
	 */
	public int getHighScore() {
		return high_score;
	}
	
	/**
	 * Method returns whether a specific account exists in the database.
	 * If the connection to the database fails, it returns false.
	 */
	public boolean findAccount(String userName) {
		Connection con = connectToDB();
		if (con!=null) {
			try {
				PreparedStatement preSt = con.prepareStatement("SELECT user_name FROM user WHERE user_name=\""+userName+"\"");
				ResultSet rs1 = preSt.executeQuery();
					
				if (!rs1.isBeforeFirst() ) {    
					return false;
				} 
				else {
					return true;
				}
			} 
			catch (SQLException e) {
				System.out.println(e);;
				return false;
			} 
			finally {
				terminateConnection(con);
			}
		}
		else {
			return false;
		}		
	}
	
	/**
	 * Creates a new Account in the database.
	 * Does nothing if connection to the database fails.
	 */
	public void createNewAccount() {
		Connection con = connectToDB();
		if (con!=null) {
			try {
				if (findAccount(userName)==true) {
				}
				else {
					String columns = "`"+COLUMN1+"`, `"+COLUMN2+"`, `" + COLUMN3 + "`, `" + COLUMN4 + "`, `" + COLUMN5 + "`";
					String values = "\'"+userName+"\', \'"+passWord+"\', 0, 0, 1";
					String statement = "INSERT INTO `user` ("+ columns + ") VALUES (" + values + ")";
					PreparedStatement preSt = con.prepareStatement(statement);
					preSt.executeUpdate();
					JOptionPane.showMessageDialog(null, ACCOUNT_CREATED_MSG);
				}
			}
			catch (Exception e) {
				System.out.println(e);
			}
			finally {
				terminateConnection(con);
			}
		}
	}
	
	/**
	 * Returns a boolean depending on whether the password entered by the user matches the password
	 * for the username.
	 * Returns false if the connection fails to disable the possibility of errors if the program tries
	 * to log in.
	 */
	public boolean checkPassword() {		
		Connection con = connectToDB();
		if (con!=null) {
			try {
				PreparedStatement preSt = con.prepareStatement("SELECT user_password FROM user WHERE user_name=\""+userName+"\"");
				ResultSet rs1 = preSt.executeQuery();
			
				if (rs1.first()) {
					String dbPassword = rs1.getString(COLUMN2);
				
					if (dbPassword.equals(passWord)) {
						return true;
					}
				
					else {
						return false;
					}
				
				}
				else {
					return false;
				}
			}
			catch (Exception e)
			{
				System.out.println(e);
				return false; 
			}
			finally{
				terminateConnection(con);
			}
		}
		else {
			return false;
		}
	}

	/**
	 * Checks whether an account exists, then uses checkPassword to check whether the password matches
	 * the username, then logs the user in.
	 */
	public boolean logIntoAccount() {		
		boolean accountExists = findAccount(userName);
		if (accountExists) {
			if(checkPassword()) {
				JOptionPane.showMessageDialog(null, "Welcome " + userName + "!");
				return true;
			}
			else {
				JOptionPane.showMessageDialog(null, "Password not known");
				return false;
			}
		}
		JOptionPane.showMessageDialog(null, USER_UNKNOWN_MSG);
		return false;
	}
	
	/**
	 * Sets the password in the database to the newly entered password.
	 */
	public void editPassword(char[] newPassword) {
		String stringPassword = makeArrayIntoString(newPassword, "");
		if(validateCredentials()) {
			Connection con = connectToDB();
			if (con!=null) {
				try {
					PreparedStatement preSt = con.prepareStatement("UPDATE user SET user_password = ? WHERE user_name=\""+userName+"\"");//						PreparedStatement preSt = con.prepareStatement("UPDATE user SET user_name = ? WHERE user_name=\""+userName+"\"");
					preSt.setString(1, stringPassword);
					preSt.execute();
					this.passWord = stringPassword;
					con.close();
				} 
				catch(Exception e) {
					System.out.println(e);
				}
				finally {
					terminateConnection(con);
				}
			}
		}
	}

	/**
	 * Sets the username in the database to the newly entered username.
	 */
	public void editUserName(String newUserName) {
		if(findAccount(newUserName) == false) {
			if(validateCredentials()) {
				Connection con = connectToDB();
				if (con!=null) {
					try {
						PreparedStatement preSt = con.prepareStatement("UPDATE user SET user_name = ? WHERE user_name=\""+userName+"\"");
						preSt.setString(1, newUserName);
						preSt.execute();
						this.userName = newUserName;
						JOptionPane.showMessageDialog(null, UPDATE_MSG);
					} 
					catch(Exception e) {
						System.out.println(e);
					}
					finally {
						terminateConnection(con);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, NAME_USED_MSG);
				}
			}
		}	
	}
	
	/**
	 * Deletes a FindAccount object from the database.
	 */
	public void deleteAccount() {
		if(validateCredentials()) {
			Connection con = connectToDB();
			if (con!=null) {
				try {	
					PreparedStatement preSt = con.prepareStatement("DELETE FROM user WHERE user_name=\""+userName+"\"");
					preSt.execute();
					JOptionPane.showMessageDialog(null, ACCOUNT_DELETE_MSG);
				} 
				catch(Exception e) {
					System.out.println(e);
				}
				finally {
					terminateConnection(con);
				}
			}
		}
	}
	
	/**
	 * Updates a user's score in the database according to the int input (which is going to be the
	 * score of the recently played game)
	 */
	public void editScore(int scoreEdit) {
			Connection con = connectToDB();
			if (con!=null) {
				try {	
					PreparedStatement preSt = con.prepareStatement("SELECT total_score, high_score FROM user WHERE user_name=\""+userName+"\"");
					ResultSet rs1 = preSt.executeQuery();
					rs1.next();
					this.total_score = rs1.getInt(COLUMN3);
					int highScoreDB = rs1.getInt(COLUMN4);
					this.total_score += scoreEdit;
					if (scoreEdit > +highScoreDB) {
						this.high_score = scoreEdit;
						PreparedStatement editHS = con.prepareStatement("UPDATE user SET high_score = ? WHERE user_name=\""+userName+"\"");
						editHS.setInt(1, this.high_score);
						editHS.executeUpdate();
					}
					PreparedStatement editTS = con.prepareStatement("UPDATE user SET total_score = ? WHERE user_name=\""+userName+"\"");
					editTS.setInt(1, this.total_score);
					editTS.executeUpdate();
				} 
				catch(Exception e) {
					System.out.println(e);
				}
				finally {
					terminateConnection(con);
				}
			}
		}
	
	/**
	 * Updates a user's avatar in the database according to the int input (which is going to be the
	 * avatar number of the avatar choosing slider)
	 */
	public void editAvatar(int avatar) {
			Connection con = connectToDB();
			if (con!=null) {
				try {	
					this.avatar = avatar;
					CurrentLogin user = CurrentLogin.getInstance();
					PreparedStatement editAvatar = con.prepareStatement("UPDATE user SET avatar = ? WHERE user_name=\""+user.getLogin()+"\"");
					editAvatar.setInt(1, this.avatar);
					editAvatar.executeUpdate();
				} 
				catch(Exception e) {
					System.out.println(e);
				}
				finally {
					terminateConnection(con);
				}
			}
		}
	
	/**
	 * Updates a user's avatar in the database according to the int input (which is going to be the
	 * avatar number of the avatar choosing slider)
	 */
	public int getAvatar() {
			int returnAvatar = 0;
			Connection con = connectToDB();
			if (con!=null) {
				try {	
					CurrentLogin user = CurrentLogin.getInstance();
					PreparedStatement editAvatar = con.prepareStatement("SELECT avatar From user WHERE user_name=\""+user.getLogin()+"\"");
					ResultSet rs1 = editAvatar.executeQuery();
					rs1.next();
					returnAvatar = rs1.getInt(COLUMN5);
				} 
				catch(Exception e) {
					System.out.println(e);
				}
				finally {
					terminateConnection(con);
				}
			}
			return returnAvatar;
		}
	
	/**
	 * Terminates the connection to the database.
	 */
	private void terminateConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Checks username and password for the log in method. Returns true, if username and password match
	 * and false if they don't.
	 */
	private boolean validateCredentials() {
		if(findAccount(userName)) {
			if (checkPassword()) {
				return true;
			}
			else {
				JOptionPane.showMessageDialog(null, USER_UNKNOWN_MSG);
				return false;
			}
		}
		else{
			JOptionPane.showMessageDialog(null, PASSWORD_UNKNOWN_MSG);
			return false;
		}	
	}
	
	/**
	 * Returns the Top 10 (!) High Scores for all users in the database.
	 */
	public String showTopTenHighScores() {
		String highScoreStatement = "\n ------------------------------------------------------\n";
		Connection con = connectToDB();
		if (con!=null) {
			try {	
				PreparedStatement preSt = con.prepareStatement("SELECT user_name, high_score FROM user ORDER BY high_score DESC LIMIT 10");
				ResultSet rs1 = preSt.executeQuery();
				int rank = 0;
				while (rs1.next()) {
					rank += 1;
					String addString = String.format("| %s: %s%s | %s%s |\n",Utilities.padLine(Integer.toString(rank),2), "user name: ", padLine(rs1.getString(COLUMN1), 14), "high score: ",
					padLine(Integer.toString(rs1.getInt(COLUMN4)),8)); 
					highScoreStatement += addString;
				}
			} 
			catch(Exception e) {
				System.out.println(e);
			}
			finally {
				terminateConnection(con);
			}
		}
		highScoreStatement += "-------------------------------------------------------\n";
		return highScoreStatement;
	}
	
	/**
	 * Returns the Top 10 (!) Total Scores for all users in the database.
	 */
	public String showTopFiveTotalScores() {
		String totalScoreStatement = "\n-------------------------------------------------------\n";
		Connection con = connectToDB();
		if (con!=null) {
			try {	
				PreparedStatement preSt = con.prepareStatement("SELECT user_name, total_score FROM user ORDER BY total_score DESC LIMIT 10");
				ResultSet rs1 = preSt.executeQuery();
				int rank = 0;
				while (rs1.next()) {
					rank += 1;
					String addString = String.format("| %s: %s%s | %s%s |\n",Utilities.padLine(Integer.toString(rank),2), "user name: ", padLine(rs1.getString(COLUMN1), 14), "total score: ",
					padLine(Integer.toString(rs1.getInt(COLUMN3)),8)); 
					totalScoreStatement += addString;
				}
			} 
			catch(Exception e) {
				System.out.println(e);
			}
			finally {
				terminateConnection(con);
			}
		}
		totalScoreStatement += "-------------------------------------------------------\n";
		return totalScoreStatement;
	}
	
	/**
	 * Creates the path for accessing the avatar icon
	 */
	public String avatarPath() {
		String avatarInt = Integer.toString(getAvatar());
		String imageString = "../BetterHangman/data/hangmanimals/icon_" 
								+ avatarInt + ".png";
		return imageString;
	}
	
}
