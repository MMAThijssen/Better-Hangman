package sql;
import java.sql.*;

import processing.Utilities;

/**
 * Class ReadoutDataBase reads out the database by printing the information in the database in a format.
 * 
 */

public class ReadoutDataBase extends Utilities{
	
	/**
	 *  This method is used to print the information contained in the database according to the format:
	 *  account name, username, password, total score, highscore.
	 */
	public static void showDataBase() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7233352", "sql7233352", "l7wrCjrYCH");
			PreparedStatement preSt = con.prepareStatement("SELECT * FROM user");
			ResultSet rs1 = preSt.executeQuery();
			
			while(rs1.next()) {
				System.out.printf("%s%s%s%s%s%s%s%s\n","account name: ", padLine(rs1.getString("user_name"), 14), "| password: " 
	            		, padLine(rs1.getString("user_password"), 14), "| total score: " , padLine(Integer.toString(rs1.getInt("total_score")), 14),
	              		"| high score: ", padLine(Integer.toString(rs1.getInt("high_score")), 14),"| avatar: ",padLine(Integer.toString(rs1.getInt("avatar")), 14));
	        }
		}
		catch (Exception e) {
			System.out.println(e);
		}
		if (con!=null) {
			try {
				con.close();
			} 
			catch (SQLException e) {
				System.out.println(e);
			}
		}
	}
}
