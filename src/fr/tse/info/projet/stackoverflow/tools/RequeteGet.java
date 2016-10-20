package fr.tse.info.projet.stackoverflow.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
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
	 * @param url url to join to have data
	 * @return the string in JSON return by the API
	 */
	private static String recuperationDonnee(String url) throws IOException {

		String source = "";
		URL oracle = new URL(url);
		HttpURLConnection yc = (HttpURLConnection) oracle.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		String inputLine;

		while ((inputLine = in.readLine()) != null)
			source += inputLine;
		in.close();
		return source;
	}

	public static void main(String[] args) {
		
	}
}
