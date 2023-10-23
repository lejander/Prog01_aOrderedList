import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//Runs from main program
//File name is called text
public class MainProgram {
    public static void main(String[] args) {
        aOrderedList orderedList = new aOrderedList();

        String inputFileName = "text";
        Scanner inputScanner = getInputScanner(inputFileName);
        if (inputScanner == null) {
            System.out.println("Program terminated.");
            return;
        }

        while (inputScanner.hasNextLine()) {
            String line = inputScanner.nextLine();
            String[] parts = line.split(",");
            if (parts[0].equals("A")) {
                if (parts.length == 4) {
                    String make = parts[1];
                    int year = Integer.parseInt(parts[2]);
                    int price = Integer.parseInt(parts[3]);
                    orderedList.add(new Car(make, year, price));
                }
            } else if (parts[0].equals("D")) {
                if (parts.length == 3) {
                    String make = parts[1];
                    int year = Integer.parseInt(parts[2]);

                    int index = findCarIndex(orderedList, make, year);
                    if (index != -1) {
                        orderedList.remove(index);
                    } else {
                        System.out.println("Car not found: " + make + ", " + year);
                    }
                }
            }
        }
        inputScanner.close();

        printSpecialFormat(orderedList);
    }

    private static Scanner getInputScanner(String fileName) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found. Program terminated.");
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
                System.out.println();
                System.out.println("Current Working Directory: " + System.getProperty("user.dir"));
            }
        }
    }

    private static int findCarIndex(aOrderedList orderedList, String make, int year) {
        for (int i = 0; i < orderedList.size(); i++) {
            Car car = (Car) orderedList.get(i);
            if (car.getMake().equals(make) && car.getYear() == year) {
                return i;
            }
        }
        return -1;
    }
}
