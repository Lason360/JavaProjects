import java.util.*;
class AlreadyAvailableErr extends Exception{
    public String getMessage(){
        return "Selected study room is already released";
    }
}
class StudyRoomUnavailableException extends Exception{
    public String getMessage(){
        return "Selected study room is not available";
    }
}
class StudyRoom{
    private Integer roomNumber;
    private Integer capacity;
    private Boolean status = true;
    
    public StudyRoom(int rN,int c){
        roomNumber = rN;
        capacity = c;
        StudyRoomReservationSystem.StudyRoomCollection.put(rN, this);
    }

    public boolean getAvailability(){
        return status;
    }
    public Integer getRoomNumber(){
        return roomNumber;
    }
    public Integer getCapacity(){
        return capacity;
    }
    public void statusChange(boolean status){
        this.status = status;
    }
    

}


class StudyRoomReservationSystem {
    public static final Object collectionLock = new Object();
    public static String availabilityCheck(boolean B) {
        if (B) {
            return "Available";
        } else {
            return "Unavaliable";
        }

    }

    public static HashMap<Integer, StudyRoom> StudyRoomCollection = new HashMap<>();

    public StudyRoomReservationSystem() {
    }

    public void releaseStudyRoom(int n) throws AlreadyAvailableErr, NullPointerException {
        synchronized (StudyRoomCollection.get(n)) {
            if (StudyRoomCollection.get(n).getAvailability() == false) StudyRoomCollection.get(n).statusChange(true);
            else {
                throw new AlreadyAvailableErr();
            }
        }
    }

    public void reserveStudyRoom(int n) throws StudyRoomUnavailableException, NullPointerException {
        synchronized (StudyRoomCollection.get(n)) {
            if (StudyRoomCollection.get(n).getAvailability() == true) StudyRoomCollection.get(n).statusChange(false);
            else {
                throw new StudyRoomUnavailableException();
            }
        }
    }

    public void displayStudyRoomStatus() {
        synchronized (collectionLock) {
            System.out.println("Study Room Status:");
            for (Map.Entry<Integer, StudyRoom> entry : StudyRoomCollection.entrySet()) {
                System.out.println("Room Number: " + entry.getKey() + ", Capacity: " + entry.getValue().getCapacity() + ", Availability: " + availabilityCheck(entry.getValue().getAvailability()));
            }
        }
    }

    public void addStudyRoom(StudyRoom s){
    }
}

//    public static void main(String[] args) throws StudyRoomUnavailableException {
//        StudyRoom room1 = new StudyRoom(1, 4);
//        StudyRoom room2 = new StudyRoom(2, 56);
//        StudyRoom room3 = new StudyRoom(3, 8);
//
//        StudyRoomReservationSystem ERC = new StudyRoomReservationSystem();
//
//
//        ERC.displayStudyRoomStatus();
//
//        Thread thread1 = new Thread(() -> {
//            try {
//                ERC.reserveStudyRoom(1);
//            } catch (StudyRoomUnavailableException e) {
//                System.out.println(e.getMessage());
//            } catch (NullPointerException e2) {
//                System.out.println("Invalid Room Number");
//                ERC.displayStudyRoomStatus();
//            }
//        });
//
//
//        Thread thread2 = new Thread(() -> {
//            try {
//                ERC.reserveStudyRoom(4);
//            } catch (StudyRoomUnavailableException e) {
//                System.out.println(e.getMessage());
//            } catch (NullPointerException e3) {
//                System.out.println("Invalid Room Number");
//            }
//        });
//
//        Thread thread3 = new Thread(() -> {
//            try {
//                ERC.releaseStudyRoom(1);
//            } catch (AlreadyAvailableErr e) {
//                System.out.println(e.getMessage());
//            } catch (NullPointerException e4) {
//                System.out.println("Invalid Room Number");
//                ERC.displayStudyRoomStatus();
//            }
//        });
//        Thread thread4 = new Thread(() -> {
//            try {
//                ERC.reserveStudyRoom(1);
//            } catch (StudyRoomUnavailableException e) {
//                System.out.println(e.getMessage());
//            } catch (NullPointerException e3) {
//                System.out.println("Invalid Room Number");
//            }
//        });
//        Thread thread5 = new Thread(() -> {
//            ERC.displayStudyRoomStatus();
//        });
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();
//    }
//}


public class Main {
    public static void main(String[] args) {
        // Create StudyRoom objects
        StudyRoom room1 = new StudyRoom(1, 4);
        StudyRoom room2 = new StudyRoom(2, 6);
        StudyRoom room3 = new StudyRoom(3, 8);

        // Create StudyRoomReservationSystem
        StudyRoomReservationSystem reservationSystem = new StudyRoomReservationSystem();

        // Add study rooms to the reservation system
        reservationSystem.addStudyRoom(room1);
        reservationSystem.addStudyRoom(room2);
        reservationSystem.addStudyRoom(room3);

        // Display initial study room status
        reservationSystem.displayStudyRoomStatus();

        // Test Case 1: Single student reserving an available study room
        try {
            reservationSystem.reserveStudyRoom(1);
            System.out.println("Student 1 reserved Study Room 1.");
        } catch (StudyRoomUnavailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}