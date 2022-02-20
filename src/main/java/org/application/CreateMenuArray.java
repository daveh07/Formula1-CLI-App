package org.application;

public class CreateMenuArray {

    // Create & edit main menu option titles.
    static void optionArray() {
        String[] optionArray = new String[]{"1 - Drivers", "2 - Constructors", "3 - Circuits", "4 - Results",
                "5 - Qualifying", "6 - Standings", "7 - Schedule/Calendar"};
        String[] var1 = optionArray;
        int var2 = optionArray.length;

        // For loop to print each menu option
        for(int var3 = 0; var3 < var2; ++var3) {
            String arrayOptionsString = var1[var3];
            System.out.println(arrayOptionsString);
        }
    }

}
