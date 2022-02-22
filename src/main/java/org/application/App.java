package org.application;

import java.io.IOException;
import java.util.Scanner;


public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        MenuData();

        while (true) {
            System.out.print("Select an option (number): ");
            int new_input = scanner.nextInt();

            if (new_input == 1) {
                DriversOptionSelect.getDriversList();
            } else if (new_input == 2) {
                ConstructorsOptionSelect.getConstructorsList();
            } else if (new_input == 3) {
                CircuitOptionSelect.getCircuitsList();
            } else if (new_input == 4) {
                ResultsOptionSelect.getResultsList();
            } else if (new_input == 5) {
                QualifyingOptionSelect.getQualifyingList();
            } else if (new_input == 6) {
                StandingsOptionSelect.getStandingsList();
            } else if (new_input == 7) {
                CalendarOptionSelect.getCalendarList();
            }
            else {
                System.out.println("Choose a corresponding menu number in the menu range.");
                MenuData();
                continue;
            }
        break;
        }
    }

    // Create application main menu
    public static void MenuData() {

        int selection;

        System.out.println("#--------------------------------------------------------------#");
        System.out.println("#---------------------------F1 API-----------------------------#");
        System.out.println("# MENU: ");

        CreateMenuArray.optionArray();

        System.out.println("_");
        System.out.println("# To exit app, type: quit "); // Input and action to be added
        System.out.println("#--------------------------------------------------------------#");
    }
}
