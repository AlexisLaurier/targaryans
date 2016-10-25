package fr.tse.info.projet.stackoverflow.tools;
/**
 * user class: Used to get information from stackoverflow user
 */
public class User {
	private int reputation;
	private int user_id;
	private String user_type;
	private int accept_rate;
	private String profile_image;
	private String display_name;
	private String link;
	
	@Override
	public String toString() {
		return display_name + "(" + link + ")";
	}

	
}
