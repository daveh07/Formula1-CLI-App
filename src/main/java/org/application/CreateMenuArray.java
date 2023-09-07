package org.application;

public class CreateMenuArray {

    // Create & edit main menu option titles.
    static void optionArray() {
        String[] optionArray = new String[]{"1 - Drivers", "2 - Constructors", "3 - Circuits", "4 - Results",
                "5 - Qualifying", "6 - Standings", "7 - Schedule/Calendar"};
        int var2 = optionArray.length;

        // For loop to print each menu option
        for (String arrayOptionsString : optionArray) {
            System.out.println(arrayOptionsString);
        }
    }

}
