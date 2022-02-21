package org.application;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class DriversOptionSelect {

    static Scanner drScanner = new Scanner(System.in);

    static void getDriversList() throws IOException, InterruptedException {
        // System prompt for user input for championship year
        System.out.println("Input Championship Year (eg. 2021): ");

        // Declarations
        int drivers_year = drScanner.nextInt();
        final int FIRST_YEAR = 1950;
        final int CURRENT_YEAR = 2022;

        // API Drivers URL - Dynamic input for user to choose the championship year (required)
        final String POSTS_API_URL = ("https://ergast.com/api/f1/"+drivers_year+"/drivers");

        if (drivers_year >= FIRST_YEAR && drivers_year<= CURRENT_YEAR) {
            System.out.println("You chose championship year: " + drivers_year);
            System.out.println("#------------------List of Drivers in " + drivers_year + "----------------------#");

            // SEND HTTP REQUESTS
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .header("accept", "application/json")
                    .uri(URI.create(POSTS_API_URL))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Test printing XML results
            System.out.println(response.body());
            System.out.println(response);
        }
        else {
            System.out.println("Choose a year between "+ FIRST_YEAR +" & " + CURRENT_YEAR);
            getDriversList();
        }
    }

}
