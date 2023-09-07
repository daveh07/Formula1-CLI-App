package org.application;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConstructorsOptionSelect {

    static Scanner constScanner = new Scanner(System.in);

    static void getConstructorsList() throws IOException, InterruptedException {
        // System prompt for user input for championship year
        System.out.println("Input Championship Year (eg. 2021): ");

        // Declarations
        int constructor_year = constScanner.nextInt();
        int FIRST_YEAR = 1950;
        int CURRENT_YEAR = 2022;

        // API constructor teams URL - Dynamic input for user to choose the championship year (required)
        final String POSTS_CONST_API_URL = ("http://ergast.com/api/f1/"+constructor_year+"/constructors");

        if (constructor_year >= FIRST_YEAR && constructor_year<= CURRENT_YEAR) {
            System.out.println("You chose championship year: " + constructor_year);
            System.out.println("#----------------List of Constructor Teams in " + constructor_year + "--------------------#");

            // SEND HTTP REQUESTS
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .header("accept", "application/json")
                    .uri(URI.create(POSTS_CONST_API_URL))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Test printing XML results & HTTP Response
            System.out.println(response.body());
            System.out.println(response);
        }
        else {
            System.out.println("Choose a year between "+ FIRST_YEAR +" & " + CURRENT_YEAR);
            getConstructorsList();
        }
    }

}
