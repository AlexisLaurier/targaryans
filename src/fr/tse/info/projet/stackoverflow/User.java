package fr.tse.info.projet.stackoverflow;

public class User {
	// User class : defines profile
	String name; // User's name
	String password; // Simple String password to acces profile
	Badge[] badges; // TODO compare to datas extracted from Json files

	public void show() {
		// Function to show user's details
		System.out.println("User's name :" + name + "\n" + "User's badges : " // TODO
																				// add
																				// toString(badges)
		);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public boolean comparePassword(String pass) {
		// Function to compare an entered password to user's
		if (pass == password) {
			return true;
		} else
			return false;
	}

}
