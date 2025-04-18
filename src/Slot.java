public class Slot implements Comparable<Slot> {
    private final int number;
    private Car car;

    public Slot(int number) {
        this.number = number;
        this.car = null;
    }

    public int getNumber() {
        return number;
    }

    public boolean isFree() {
        return car == null;
    }

    public void park(Car car) {
        this.car = car;
    }

    public void leave() {
        this.car = null;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public int compareTo(Slot other) {
        return Integer.compare(this.number, other.number);
    }
}