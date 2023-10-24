package orderedList;

/**
 * Car class. Has three parameters (make, year, price)
 * CSC 1351 Programming Project No <1>
 * Section <002>
 *
 * @author THOMAS SHIMER
 * @since 10/23/2023
 */

public class Car implements Comparable<Car> {
    private final String make;
    private final int year;
    private final int price;

    public Car(String Make, int Year, int Price) {
        this.make = Make;
        this.year = Year;
        this.price = Price;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    /**
     * Prints a single car's data. To be used more for future debugging, rather than for actual outputs.
     * CSC 1351 Programming Project No <1>
     * Section <002>
     *
     * @author THOMAS SHIMER
     * @since 10/23/2023
     */
    @Override
    public String toString() {
        return "Make: " + make + ", Year : "
                + year + ", Price: " + price + ";";
    }

    /**
     * Compares two cars based on their make.
     * CSC 1351 Programming Project No <1>
     * Section <002>
     *
     * @Parameter other : Compares this instance's object to the "other" object.
     * @author THOMAS SHIMER
     * @since 10/23/2023
     */
    @Override
    public int compareTo(Car other) {
        if (other == null) {
            return 1;
        }
        return this.make.compareTo(other.getMake());
    }
}
