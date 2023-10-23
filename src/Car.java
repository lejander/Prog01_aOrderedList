//File name is called text.
//Runs from main program

public class Car implements Comparable<Car> {
    private final String make;
    private final int year;
    private final int price;

    public Car(String make, int year, int price) {
        this.make = make;
        this.year = year;
        this.price = price;
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

    @Override
    public int compareTo(Car other) {
        if (!make.equals(other.make)) {
            return make.compareTo(other.make);
        }
        if (year != other.year) {
            return year - other.year;
        }
        return 0; // Objects are equal
    }

    @Override
    public String toString() {
        return "Make: " + make + ", Year: " + year + ", Price: $" + price;
    }
}
