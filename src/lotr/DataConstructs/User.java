package lotr.DataConstructs;

public class User {

	private String username;
	private String password;
	private boolean online;
	
	private static final User instance = new User();
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		
		if(!username.isBlank()) {
			this.username = username;
		}else {
			throw new IllegalArgumentException("Username field empty.");
		}
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		if(!password.isBlank()) {
			this.password = password;
		}else {
			throw new IllegalArgumentException("Password field empty.");
		}
		
	}
	public boolean isOnline() {
		return online;
	}
	public void setOnline(boolean online) {
		this.online = online;
	}
	
	
	
	private User() {}
	
	public static User getInstance() {
		return instance;
	}
	
	
	
}
