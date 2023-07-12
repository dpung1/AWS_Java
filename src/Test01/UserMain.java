package Test01;

class User {
	
	private String Username;
	private String password;
	private String name;
	private String email;
	
	public User(String username, String password, String name, String email) {
		this.Username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		
		
		
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

public class UserMain {
	public static void main(String[] args) {
		User user = new User("junil", "1234", "김준일", "junil@gmail.com");
		
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("name : " + user.getName());
		System.out.println("email : " + user.getEmail());
		
	}
	
}
