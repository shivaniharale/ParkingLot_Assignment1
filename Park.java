
import java.util.ArrayList;
import java.util.Scanner;

public class Park {

    private static Scanner scanner = new Scanner(System.in);
    private static ParkingLot parkingLot;
    static int parked = 0, vacant, toAvoidNullPointerException = 0;
    static ArrayList<ParkingLot> ParkingLotList=new ArrayList<>();

    public static void main(String args[]) {
        int choice = 1;
        while (choice != 8) {

            try {
                switch (choice) {
                    case 1:
                        displaychoices();
                        break;
                    case 2:
                        toAvoidNullPointerException++;
                        createParkingLot();
                        vacant = parkingLot.getParkingLotSize();
                        break;
                    case 3:
                        parked++;
                        vacant--;
                        park(true);
                        break;
                    case 4:
                        park(false);
                        vacant++;
                        parked--;
                        break;
                    case 5:
                        System.out.println("Total parked lots:" + parked + "\nTotal vacant slots:" + vacant);
                        ParkInterface parkInterface=()->{
                            System.out.print("Status of parking lot " + parkingLot.getParkingLotName() + " is:");
                            parkingLot.displayStatus();
                        };
                        parkInterface.status();
                        break;
                    case 6:
                        registrationNumbersForCarsWithColour();
                        break;
                    case 7:
                        slotNumbersForCarsWithColour();
                        break;

                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }
            catch (NullPointerException e){
                System.out.println("Exception :"+e);
            }
            System.out.println("Enter choice");
            choice = scanner.nextInt();
        }
    }

    public static void displaychoices() {
        System.out.println("Choices are \n1.Display choices\n2.Create parking lot \n"
                + "3.Park \n"
                + "4.Leave \n"
                + "5.Status \n"
                + "6.Registration numbers for vehicles with colour \n"
                + "7.Slot numbers for vehicles with colour\n"
                + "8.Exit");
    }

    public static void createParkingLot() {
        System.out.println("Enter parking lot name:");
        String parkingLotName = scanner.next();
        System.out.println("Enter parking lot size:");
        int parkingLotSize = scanner.nextInt();
        vacant = parkingLotSize;
        parkingLot = new ParkingLot(parkingLotName, parkingLotSize);
        ParkingLotList.add(parkingLot);
    }

    public static void park(Boolean parkaction) {
        if (toAvoidNullPointerException == 0) {
            System.out.println("Parking lot yet to be created.");
        } else {

            if (parkingLot.getParkingLotSize() == parked - 1 && parkaction == true) {
                System.out.println("Parking lot is full.");
            } else if (parkingLot.getParkingLotSize() == vacant && parkaction == false) {
                System.out.println("Parking lot is Empty.");
            } else {
                System.out.println("Vehicle registration number:");
                String registration = scanner.next();
                System.out.println("Vehicle color:");
                String color = scanner.next();
                parkingLot.park(registration, color, parkaction);
            }
        }
    }



    public static void registrationNumbersForCarsWithColour() {
            System.out.println("Enter the color to get vehicle registrations of that color:");
            String color = scanner.next();
            System.out.println("Vehicles are:");
            parkingLot.registrationsForGivenColor(color);
    }

    public static void slotNumbersForCarsWithColour() {
        if (toAvoidNullPointerException == 0) {
            System.out.println("Parking lot yet to be created.");
        } else {
            System.out.println("Enter the color to get slot numbers of parking:");
            String color = scanner.next();
            System.out.println("Slots are:");
            parkingLot.slotsForGivenColor(color);
        }
    }

}
