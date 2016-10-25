package fr.tse.info.projet.stackoverflow.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.net.HttpURLConnection;

/**
 * Class which contains all methods to import data from the Stack Exchanges API
 *
 */
public class RequeteGet {

	/*
	 * Main function of data recovery from StackExchange API by a GET Method
	 * 
	 * @exception IOException
	 * 
	 * @param url url to join to have data
	 * 
	 * @return the string in JSON return by the API
	 */
	private static String recupData(String url) throws IOException {

		String resultat = "";
		URL ourUrl = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) ourUrl.openConnection();
		connection.setRequestMethod("GET");
		BufferedReader in = new BufferedReader(new InputStreamReader(new GZIPInputStream(connection.getInputStream())));
		String inputLine;

		while ((inputLine = in.readLine()) != null)
			resultat += inputLine;
		in.close();
		return resultat;
		
	}

	public static String findContributor(String subject) throws IOException {
		String contributor = "";
		contributor = recupData(
				"https://api.stackexchange.com/2.2/tags/"+subject+"/top-answerers/all_time?site=stackoverflow");
		Gson json = new Gson();
		
		return contributor;
	}

	public static void main(String[] args) {
		try {
			String tag;
			Scanner sc = new Scanner(System.in);
			System.out.println("Bonjour sur quel tag souhaitez vous trouver l'utilisateur le plus actif?");
			tag = sc.next();
			System.out.println(findContributor(tag));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
