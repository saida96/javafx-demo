package sample;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * These utilities will be used to communicate with the network.
 */
public class NetworkUtils {

    private final static String WORDNIK_BASE_URL =
            "http://api.wordnik.com:80/v4/word.json";

    private final static String DEFINITION_PATH = "/definitions?";
    private final static String API_KEY = "a2a73e7b926c924fad7001ca3111acd55af2ffabf50eb4ae5&";
    private final static String PARAM_LIMIT = "3";

    /**
     * Builds the URL used to query Wordnik.
     *
     * @param wordSearchQuery The keyword that will be queried for.
     * @return The URL to use to query the Wordnik.
     */
    public static URL buildUrl(String wordSearchQuery) {
        String urlString = WORDNIK_BASE_URL + "/" +
                wordSearchQuery +
                DEFINITION_PATH +
                "api_key=" + API_KEY +
                "limit=" + PARAM_LIMIT;

        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    /**
     * This method returns the entire result from the HTTP response.
     *
     * @param url The URL to fetch the HTTP response from.
     * @return The contents of the HTTP response.
     * @throws IOException Related to network and stream reading
     */
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}