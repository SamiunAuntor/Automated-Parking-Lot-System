import java.util.*;

public class ParkingLot {
    private final int capacity;
    private final Slot[] slots;
    private final PriorityQueue<Slot> freeSlots;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.slots = new Slot[capacity + 1];  // 1-based indexing
        this.freeSlots = new PriorityQueue<>();
        for (int i = 1; i <= capacity; i++) {
            Slot slot = new Slot(i);
            slots[i] = slot;
            freeSlots.add(slot);
        }
    }

    public void park(String reg, String color) {
        if (freeSlots.isEmpty()) {
            System.out.println("Sorry, parking lot is full");
            return;
        }
        Slot slot = freeSlots.poll();
        slot.park(new Car(reg, color));
        System.out.println("Allocated slot number: " + slot.getNumber());
    }

    public void leave(int slotNumber) {
        if (slotNumber < 1 || slotNumber > capacity) {
            System.out.println("Invalid slot number");
            return;
        }
        Slot slot = slots[slotNumber];
        if (slot.isFree()) {
            System.out.println("Slot number " + slotNumber + " is already free");
        } else {
            slot.leave();
            freeSlots.add(slot);
            System.out.println("Slot number " + slotNumber + " is free");
        }
    }

    public void status() {
        System.out.println("Slot No.  Registration No.  Colour");
        for (int i = 1; i <= capacity; i++) {
            Slot slot = slots[i];
            if (!slot.isFree()) {
                Car car = slot.getCar();
                System.out.printf("%d         %s      %s%n", i, car.getRegistrationNumber(), car.getColor());
            }
        }
    }

    public void registrationNumbersForCarsWithColor(String color) {
        List<String> regs = new ArrayList<>();
        for (Slot slot : slots) {
            if (slot != null && !slot.isFree() && slot.getCar().getColor().equalsIgnoreCase(color)) {
                regs.add(slot.getCar().getRegistrationNumber());
            }
        }
        if (regs.isEmpty()) System.out.println("Not found");
        else System.out.println(String.join(", ", regs));
    }

    public void slotNumbersForCarsWithColor(String color) {
        List<String> nums = new ArrayList<>();
        for (Slot slot : slots) {
            if (slot != null && !slot.isFree() && slot.getCar().getColor().equalsIgnoreCase(color)) {
                nums.add(String.valueOf(slot.getNumber()));
            }
        }
        if (nums.isEmpty()) System.out.println("Not found");
        else System.out.println(String.join(", ", nums));
    }

    public void slotNumberForRegistrationNumber(String reg) {
        for (Slot slot : slots) {
            if (slot != null && !slot.isFree() && slot.getCar().getRegistrationNumber().equals(reg)) {
                System.out.println(slot.getNumber());
                return;
            }
        }
        System.out.println("Not found");
    }

    public void parkAt(int slotNumber, String reg, String color) {
        if (slotNumber < 1 || slotNumber > capacity) {
            System.out.println("Invalid slot number");
            return;
        }
        Slot slot = slots[slotNumber];
        if (!slot.isFree()) {
            System.out.println("Slot number " + slotNumber + " is already occupied");
            return;
        }
        slot.park(new Car(reg, color));
        freeSlots.remove(slot); // Remove manually to sync with PriorityQueue
        System.out.println("Allocated slot number: " + slot.getNumber());
    }

}