package fr.tse.info.projet.stackoverflow;
/**
 * <b>User class : defines user profile</b> <\n>
 * Contains user's name and user's badges
 */
public class User {
	
	/**
	 * User's Name in StackOverflow
	 */
	String name; 
	String password; 
	/**
	 * User's Badges
	 * @see Badge
	 */
	Badge[] badges; // TODO compare to datas extracted from Json files
	
	/**
	 * Function to show user's name and badges
	 */
	public void show() {
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
