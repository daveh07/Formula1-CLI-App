package org.application;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class StandingsOptionSelect {

    static Scanner standingsScanner = new Scanner(System.in);

    static void getStandingsList() throws IOException, InterruptedException {
        // System prompt for user input for championship year
        System.out.println("Input Championship Year (eg. 2021): ");

        // Declarations
        int standings_year = standingsScanner.nextInt();
        final int FIRST_YEAR = 1950;
        final int CURRENT_YEAR = 2022;

        // API circuits for year URL - Dynamic input for user to choose the championship year (required)
        final String POSTS_STAND_API_URL = ("http://ergast.com/api/f1/"+standings_year+"/driverStandings");

        if (standings_year >= FIRST_YEAR && standings_year<= CURRENT_YEAR) {
            System.out.println("You chose championship year: " + standings_year);
            System.out.println("#-------------------Driver Standings for " + standings_year + "-----------------------#");

            // SEND HTTP REQUESTS
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .header("accept", "application/json")
                    .uri(URI.create(POSTS_STAND_API_URL))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Test printing XML results & HTTP Response
            System.out.println(response.body());
            System.out.println(response);
        }
        else {
            System.out.println("Choose a year between "+ FIRST_YEAR +" & " + CURRENT_YEAR);
            getStandingsList();
        }
    }

}
