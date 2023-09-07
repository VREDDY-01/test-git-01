package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
	public static void main(String[] args) throws IOException {
		URL url =null;
		HttpURLConnection connection = null;
		String urlString = "https://api.chucknorris.io/jokes/random";
		int response = 0;

		try{
			url = new URL(urlString);
		}catch (MalformedURLException e){
			System.out.println("Url is not correct");
		}

		try{
			connection = (HttpURLConnection) url.openConnection();
			response = connection.getResponseCode();
		}catch (Exception e){
			System.out.println("Connection did not formed");
		}

		if(response == 200)
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder apiData = new StringBuilder();
			String readLine = null;

			while((readLine = in.readLine())!= null)
			{
				apiData.append(readLine);
			}

			try {
				in.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}

			System.out.println(apiData.toString());
			JSONObject jsonAPIResponse = new JSONObject(apiData.toString());
			System.out.println(jsonAPIResponse);

		}
		else
			System.out.println("API call could not be made!!!");
	}
}