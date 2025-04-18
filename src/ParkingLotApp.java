import java.util.Scanner;

public class ParkingLotApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot lot = null;

        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split(" ");
            String cmd = parts[0];

            try {
                switch (cmd) {
                    case "create_parking_lot":
                        int n = Integer.parseInt(parts[1]);
                        lot = new ParkingLot(n);
                        System.out.println("Created a parking lot with " + n + " slots");
                        break;
                    case "park":
                        lot.park(parts[1], parts[2]);
                        break;
                    case "park_at":
                        int slotNum = Integer.parseInt(parts[1]);
                        lot.parkAt(slotNum, parts[2], parts[3]);
                        break;
                    case "leave":
                        lot.leave(Integer.parseInt(parts[1]));
                        break;
                    case "status":
                        lot.status();
                        break;
                    case "registration_numbers_for_cars_with_colour":
                        lot.registrationNumbersForCarsWithColor(parts[1]);
                        break;
                    case "slot_numbers_for_cars_with_colour":
                        lot.slotNumbersForCarsWithColor(parts[1]);
                        break;
                    case "slot_number_for_registration_number":
                        lot.slotNumberForRegistrationNumber(parts[1]);
                        break;
                    case "exit":
                        scanner.close();
                        return;
                    default:
                        System.out.println("Unknown command");
                }
            } catch (Exception e) {
                System.out.println("Error processing command. Please check input format.");
            }
        }
    }
}