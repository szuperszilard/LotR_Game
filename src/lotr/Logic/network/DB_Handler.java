package lotr.Logic.network;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lotr.DataConstructs.User;


//jdbc:mysql://localhost:3306/?user=root

public class DB_Handler {

	private static Connection con;
	private static PreparedStatement ps;
	private String username = System.getenv("MYSQL_USERNAME");
	private String password = System.getenv("MYSQL_PASSWORD");
	
	public DB_Handler(){
		
	}
	
	public void connect() throws SQLException {
		
		try {
			String connectionURL = "jdbc:mysql://localhost:3307/lotrdb";
			con = DriverManager.getConnection(connectionURL, "szabszil95", "egerfogo95");
		}catch(Exception e) {			
			throw new SQLException("Couldn't connect to server. " + e.getMessage());
		}
	}
	
	public void disconnect() throws SQLException {
		
		try {
			con.close();
		}catch(Exception e) {			
			throw new SQLException("Couldn't disconnect from server. " + e.getMessage());
		}
		
	}
	
	public void login(User user) throws SQLException {
		
		try {
			
			ps = con.prepareStatement("SELECT * FROM users WHERE username=? AND `password`=?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			ResultSet res = ps.executeQuery();
			
			if(res.next()) {
				ps.clearParameters();
				ps = con.prepareStatement("UPDATE users SET `online` = TRUE WHERE username=?");
				ps.setString(1, user.getUsername());
				ps.executeUpdate();
			}else {
				throw new NullPointerException("Incorrect username/password");
			}
			
		}catch(SQLException e) {
			
			throw new SQLException("Failed to log in." + e.getMessage());			
		}
	}
	
	public void logout(User user) throws SQLException {
		
		try {
			
			ps = con.prepareStatement("UPDATE users SET `online` = FALSE where username =?");
			ps.setString(1, user.getUsername());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			
			throw new SQLException("Failed to log out." + e.getMessage());
		}		
	}
	
	public void register(User user) throws SQLException {
		
		try {
			
			ps = con.prepareStatement("INSERT INTO users(username,password) VALUES (?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e.getClass());
			throw new SQLException("Couldn't register user. " + e.getMessage());
		}
		
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
