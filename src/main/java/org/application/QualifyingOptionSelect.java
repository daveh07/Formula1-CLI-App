package org.application;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class QualifyingOptionSelect {

    static Scanner qualyearScanner = new Scanner(System.in);
    static Scanner qualroundScanner = new Scanner(System.in);

    static void getQualifyingList() throws IOException, InterruptedException {
        // System prompt for user input for championship year
        System.out.println("Input Championship Year (eg. 2021): ");
        int qualifying_year = qualyearScanner.nextInt();

        // System prompt for user input for round
        System.out.println("Input Championship Round, (eg. 12): ");
        int qualifying_round = qualroundScanner.nextInt();

        // Declarations
        final int FIRST_YEAR = 1950;
        final int CURRENT_YEAR = 2022;

        // API circuits for year URL - Dynamic input for user to choose the championship year & round (required)
        final String POSTS_QUAL_API_URL = ("http://ergast.com/api/f1/"+qualifying_year+"/"+qualifying_round+"/qualifying");

        if (qualifying_year >= FIRST_YEAR && qualifying_year<= CURRENT_YEAR) {
            System.out.println("You chose championship year: " + qualifying_year);
            System.out.println("#-------------------List of Circuits in " + qualifying_year + "---------------------#");

            // SEND HTTP REQUESTS
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .header("accept", "application/json")
                    .uri(URI.create(POSTS_QUAL_API_URL))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Test printing XML results & HTTP Response
            System.out.println(response.body());
            System.out.println(response);
        }
        else {
            System.out.println("Choose a year between "+ FIRST_YEAR +" & " + CURRENT_YEAR);
        }
    }

}
