package fr.tse.info.projet.stackoverflow.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
		Gson json = new Gson();
		String contributor;
		String jsonData = "";
		jsonData = recupData("https://api.stackexchange.com/2.2/tags/" + subject
				+ "/top-answerers/all_time?pagesize=1&site=stackoverflow");

		// Creation d'un parser pour recup les donnée sous forme de JsonObject
		JsonParser parser = new JsonParser();
		JsonObject obj = parser.parse(jsonData).getAsJsonObject();

		// Recuperation du seul parametre interessant "items" qui est sous forme
		// de tableau
		JsonArray responseString = (JsonArray) obj.get("items");
		// Test de l'existance d'une reponse (donc du tag)
		
		if (responseString.size()>0){
		// Recuperation de l'user et du nombre de message du premier element du
		// tableau (meilleure contributeur
		Response response = json.fromJson(responseString.get(0), Response.class);

		contributor = "L'utilisateur le plus actif sur le tag : " + subject + " est "
				+ response.getUser().toString() + " avec un total de " + response.getPost_count() + " participation.";
		}
		else{
			contributor = "Desole le tag specifie n'a pas ete trouve.";
		}
		return contributor;
		
	}

	public static void main(String[] args) {
		try {
			String tag;
			Scanner sc = new Scanner(System.in);
			System.out.println("Bonjour sur quel tag souhaitez vous trouver l'utilisateur le plus actif?");
			tag = sc.next();
			System.out.println(findContributor(tag));
			sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
