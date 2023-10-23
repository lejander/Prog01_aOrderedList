//CSC 1351 Programming Project name?
//Section 002
//Kiara Lejander
//10/23/23
//LSU ID 890819413


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//File name is called text.
//Runs from main program
//You can run from any program(configuration), but it has to be based on input placed in the text file

public class Prog01_aOrderedList {
    public static void main(String[] args) {
        Scanner inputScanner = getInputScanner("Enter input filename: ");
        if (inputScanner == null) {
            System.out.println("Program terminated.");
            return;
        }

        aOrderedList orderedList = new aOrderedList();
        while (inputScanner.hasNextLine()) {
            String line = inputScanner.nextLine();
            if (line.startsWith("A,")) {
                // This is an "Add" operation.
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String make = parts[1];
                    int year = Integer.parseInt(parts[2]);
                    int price = Integer.parseInt(parts[3]);
                    orderedList.add(new Car(make, year, price));
                }
            } else if (line.startsWith("D,")) {
                // This is a "Delete" operation.
                int index = Integer.parseInt(line.split(",")[1]);
                if (index >= 0 && index < orderedList.size()) {
                    orderedList.remove(index);
                }
            }
        }
        inputScanner.close();

        printSpecialFormat(orderedList);
    }

    private static Scanner getInputScanner(String prompt) {
        Scanner scanner = null;
        Scanner inputScanner = new Scanner(System.in);
        while (true) {
            System.out.print(prompt);
            String input = inputScanner.nextLine();
            if (input.equals("")) {
                System.out.println("Please enter a valid filename.");
                continue;
            }
            try {
                scanner = new Scanner(new File(input));
                break; // Exit the loop once the file is successfully opened
            } catch (FileNotFoundException e) {
                System.out.println("File specified <" + input + "> does not exist. Would you like to continue? <Y/N> ");
                String choice = inputScanner.nextLine();
                if (!choice.equalsIgnoreCase("Y")) {
                    return null; // Terminate the program
                }
            }
        }
        return scanner;
    }

    private static void printSpecialFormat(aOrderedList orderedList) {
        System.out.println("Number of cars: " + orderedList.size());
        for (int i = 0; i < orderedList.size(); i++) {
            Car car = (Car) orderedList.get(i);
            System.out.println("Make: " + car.getMake());
            System.out.println("Year: " + car.getYear());
            System.out.println("Price: $" + car.getPrice());
            if (i < orderedList.size() - 1) {
                System.out.println(); // Add a blank line between cars
                System.out.println("Current Working Directory: " + System.getProperty("user.dir"));


            }
        }
    }
}
