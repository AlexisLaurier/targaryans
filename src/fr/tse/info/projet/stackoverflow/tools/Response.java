package fr.tse.info.projet.stackoverflow.tools;

import java.util.ArrayList;

import com.google.gson.JsonArray;

public class Response {
	private User user;
	private int post_count;
	
	@Override
	public String toString() {
		return "Response [user=" + user + ", post_count=" + post_count + "]";
	}
	public int getPost_count() {
		return post_count;
	}
	public void setPost_count(int post_count) {
		this.post_count = post_count;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
