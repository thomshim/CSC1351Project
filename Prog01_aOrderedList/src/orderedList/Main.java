package orderedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * This program reads car information from a user's
 * input file. It then stores all the cars into
 * arrays, while also managing their sizes, acting similar
 * to an arrayList.
 * CSC 1351 Programming Project No <1>
 * Section <002>
 *
 * @author THOMAS SHIMER
 * @since 10/23/2023
 */

public class Main {
    public static void main(String[] args) {
        Scanner inputFileScanner = getInputFile();
        aOrderedList carList = scanReader(inputFileScanner);
        System.out.print(carList);
    }

    /**
     * Asks the user for a file name.
     * If not valid, it asks to repeat this step or to end the program.
     * If the file name is valid, it will return a scanner object.
     * CSC 1351 Programming Project No <1></1>
     * Section <002></002>
     *
     * @author THOMAS SHIMER
     * @since 10/23/2023
     */

    public static Scanner getInputFile() {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter file name:\n");

        String userFile = cin.next();
        Scanner fileScanner = null;

        while (fileScanner == null) {
            try {

                fileScanner = new Scanner(new File(userFile));

            } catch (FileNotFoundException e) {
                System.out.println("File specified <" + userFile + "> does not exist.");
                System.out.print("Would you like to continue? <Y/N> ");
                String choice = cin.next().trim();

                if (choice.equalsIgnoreCase("N")) {
                    System.out.println("\nProgram execution canceled.\n" + e.getMessage());

                    cin.close();
                    System.exit(1);
                } else {
                    System.out.print("Enter file name:\n");
                    userFile = cin.next();
                }
            }
        }

        return fileScanner;
    }

    /**
     * Reads the information from the scanner object and stores/removes
     * items into/from an ordered list.
     * CSC 1351 Programming Project No <1>
     * Section <002>
     *
     * @author THOMAS SHIMER
     * @since 10/23/2023
     */

    public static aOrderedList scanReader(Scanner obj) {

        aOrderedList carList = new aOrderedList();
        while (obj.hasNextLine()) {
            String line = obj.nextLine();
            String[] parts = line.split(",");

            if (parts.length == 4 && parts[0].equals("A")) {
                String make = parts[1];
                int year = Integer.parseInt(parts[2]);
                int price = Integer.parseInt(parts[3]);
                Car car = new Car(make, year, price);
                carList.add(car);

            } else if (parts[0].equals("D")) {
                if (parts.length == 3) {
                    for (int i = 0; i < carList.getSize(); i++) {
                        String make = parts[1];
                        int year = Integer.parseInt(parts[2]);
                        Car car = (Car) carList.getIndex(i);
                        if (car != null) {
                            if (Objects.equals(car.getMake(), make) &&
                                    Objects.equals(car.getYear(), year)) {
                                carList.remove(i);
                            }
                        }

                    }
                } else {
                    int index = Integer.parseInt(parts[1]);
                    carList.remove(index);
                }
            }
        }
        obj.close();
        return carList;
    }

    /**
     * Not used, however it returns a PrintWriter object from a users input string.
     * Will be used in a later version of the program.
     * CSC 1351 Programming Project No <1>
     * Section <002>
     *
     * @author THOMAS SHIMER
     * @since 10/23/2023
     */
    public static PrintWriter getOutputFile() {
        Scanner cin = new Scanner(System.in);
        String userFile = cin.next();
        PrintWriter filePrinter = null;
        while (filePrinter == null) {
            try {
                filePrinter = new PrintWriter(userFile);
            } catch (FileNotFoundException e) {
                System.out.println("Failed to create the file <" + userFile + ">: ");
                System.out.print("Would you like to continue? <Y/N> ");
                String choice = cin.next().trim();

                if (choice.equalsIgnoreCase("N")) {
                    System.out.println("Program Execution canceled.\n" + e.getMessage());
                    System.exit(1);
                } else {
                    System.out.print("Enter file name:\n");
                    userFile = cin.next();
                }
            }
        }
        return filePrinter;
    }
}

