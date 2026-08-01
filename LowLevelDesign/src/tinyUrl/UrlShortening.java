package tinyUrl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import java.util.Random;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

public class UrlShortening {

	private static final Map<String, String> urlStore = new HashMap<>();
	private static final Map<String, Integer> clickCount = new HashMap<>();

	private static final String CHARSET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public static void main(String[] args) throws IOException {
// TODO Auto-generated method stub
		HttpServer server = HttpServer.create(new InetSocketAddress(8082), 0);
		server.createContext("/shorten", UrlShortening::handleShorten);
		server.createContext("/stats", UrlShortening::handleStats);
		server.createContext("/", UrlShortening::handleRedirect);
		server.setExecutor(null);
		server.start();
		System.out.println("Server is running at local host 8082");

	}

	private static void handleShorten(HttpExchange exchange) throws IOException {

		if ("POST".equals(exchange.getRequestMethod())) // here we are giving original huge URL & it will convert to tinyUrl

		{
			BufferedReader reader = new BufferedReader(new

			InputStreamReader(exchange.getRequestBody()));
			String longUrl = reader.readLine();
			String shortCode = generateShortCode(); // lrngth 6
			urlStore.put(shortCode, longUrl); // mapping short url to long url
			clickCount.put(shortCode, 0);

			String response = "Short URL:http://localhost:8082/" + shortCode;
			exchange.sendResponseHeaders(200, response.length());
			exchange.getResponseBody().write(response.getBytes());
			System.out.println("Shorten called");
		    System.out.println(exchange.getRequestMethod());
		    System.out.println(exchange.getRequestURI());
			exchange.close();

		}

	}

	private static void handleRedirect(HttpExchange exchange) throws IOException {
		String path = exchange.getRequestURI().getPath().substring(1);

		if (urlStore.containsKey(path)) {
			clickCount.put(path, clickCount.get(path) + 1);  // every click to the path count's
			exchange.getResponseHeaders().add("Location", urlStore.get(path)); //response sending the original url
			exchange.sendResponseHeaders(302, -1);
		} else {
			String repsonse = "URL not found";
			exchange.sendResponseHeaders(404, repsonse.length());
			exchange.getResponseBody().write(repsonse.getBytes());
			exchange.close();

		}
	}

	public static void handleStats(HttpExchange exchange) throws IOException {
		String[] parts = exchange.getRequestURI().getPath().split("/");

		if (parts.length < 3) {
			String response = "Invalid statics URL";
			exchange.sendResponseHeaders(404, response.length());
			exchange.getResponseBody().write(response.getBytes());
			exchange.close();

		}

		String shortCode = parts[2];
		int count = clickCount.getOrDefault(shortCode, 0);
		String response = "Total Click for the product was:" + count;
		exchange.sendResponseHeaders(200, response.length());
		exchange.getResponseBody().write(response.getBytes());
		exchange.close();
	}

	private static String generateShortCode() {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			sb.append(CHARSET.charAt(random.nextInt(CHARSET.length())));

		}

		return sb.toString();
	}

}
