package org.application;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalendarOptionSelect {

    static Scanner calyearScanner = new Scanner(System.in);

    /**
     *
     * @throws IOException
     * @throws InterruptedException
     */
    static void getCalendarList() throws IOException, InterruptedException {
        // System prompt for user input for championship year
        System.out.println("Input Championship Year (eg. 2021): ");
        try {
            int calendar_year = calyearScanner.nextInt();


            // Declarations
            final int FIRST_YEAR = 1950;
            final int CURRENT_YEAR = 2022;

            // API circuits for year URL - Dynamic input for user to choose the championship year & round (required)
            final String POSTS_QUAL_API_URL = ("http://ergast.com/api/f1/" + calendar_year);

            if (calendar_year >= FIRST_YEAR && calendar_year <= CURRENT_YEAR) {
                System.out.println("You chose championship year: " + calendar_year);
                System.out.println("#---------------------Race Calendar for " + calendar_year + "-----------------------#");

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
            } else {
                System.out.println("Choose a year between " + FIRST_YEAR + " & " + CURRENT_YEAR);
                getCalendarList();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid year (e.g., 2021).");
            calyearScanner.nextLine(); // Consume the invalid input
            return; // Exit the method or handle it accordingly
        }
    }
}
