# 🚗 Automated Parking Lot System

This Java-based console application simulates an automated parking lot management system. It uses object-oriented design, clean architecture, and efficient data structures (like min-heaps) to manage the parking of cars in the nearest available slots.

---

## 📦 Features

- Create parking lot with any number of slots  
- Automatically park a car in the nearest free slot  
- Park a car in a specific slot (`park_at`)  
- Leave a slot  
- Show parking lot status  
- Query registration numbers by car color  
- Query slot numbers by car color  
- Query slot number by registration number  
- Easy interactive console interface  

---

## 📐 Design Diagram

```
+----------------+          +-------------+          +--------+
|  ParkingLot    |<>--------|   Slot      |<>--------|  Car   |
+----------------+          +-------------+          +--------+
| - capacity:int |          | - number:int|          | - reg:String
| - slots:Slot[] |          | - car:Car   |          | - color:String
| - freeSlots:   |          +-------------+          +--------+
|   PriorityQueue|          | + isFree():boolean     |        |
+----------------+          | + park(Car):void       |        |
| + park()       |          | + leave():void         |        |
| + parkAt()     |          +-------------+          +--------+
| + leave()      |
| + status()     |
| + queries...   |
+----------------+

ParkingLotApp (main) drives the interactive prompt.
```

---

## 🧠 Class Responsibilities

### 1. `Car.java`
- **Fields:** `registrationNumber`, `color`  
- **Purpose:** Encapsulates car details.

### 2. `Slot.java`
- **Fields:** `number`, `car` (nullable)  
- **Methods:**  
  - `isFree()`  
  - `park(Car)`  
  - `leave()`  
  - `compareTo(...)`  
- **Purpose:** Represents a single parking slot.

### 3. `ParkingLot.java`
- **Fields:**  
  - `capacity`  
  - `slots[]` (1-based array)  
  - `freeSlots` (PriorityQueue<Slot>)  
- **Methods:**  
  - `park(reg, color)`  
  - `parkAt(slotNum, reg, color)`  
  - `leave(slotNum)`  
  - `status()`  
  - `registrationNumbersForCarsWithColor(color)`  
  - `slotNumbersForCarsWithColor(color)`  
  - `slotNumberForRegistrationNumber(reg)`  
- **Purpose:** Core logic managing slots and queries.

### 4. `ParkingLotApp.java`
- **Function:**  
  - Reads commands in a loop  
  - Parses and delegates to `ParkingLot`  
  - Handles invalid input gracefully  
- **Supported Commands:**  
  - `create_parking_lot <n>`  
  - `park <reg> <color>`  
  - `park_at <slot> <reg> <color>`  
  - `leave <slot>`  
  - `status`  
  - `registration_numbers_for_cars_with_colour <color>`  
  - `slot_numbers_for_cars_with_colour <color>`  
  - `slot_number_for_registration_number <reg>`  
  - `exit`  

---

## ⚙️ How to Compile & Run

\`\`\`bash
# Compile all Java files
javac *.java

# Run the main class
java ParkingLotApp
\`\`\`

---

## 🧪 Example Session

\`\`\`
> create_parking_lot 6
Created a parking lot with 6 slots

> park KA-01-HH-1234 White
Allocated slot number: 1

> park_at 4 DL-12-AA-9999 Blue
Allocated slot number: 4

> status
Slot No.  Registration No.  Colour
1         KA-01-HH-1234     White
4         DL-12-AA-9999     Blue
\`\`\`

---

## 🚫 Current Limitation

Data is stored **in memory** only. Closing the program clears all state. Future enhancements could add file or database persistence.

---

Made with ☕ by Samiun Alim Auntor
