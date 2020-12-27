import java.util.*;

public class Main {
    public static List<Object> systemObjects = new LinkedList<>();
    //public static eParkSystem system = new eParkSystem();
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        String choise = null;
        do {
            /*
            System.out.println("Please press the requested option:");
            System.out.println("1: Manage eTicket");
            System.out.println("2: Ride a device");
            System.out.println("3: Leave park");
            System.out.println("0: Exit");
             */
            System.out.println("Please press the requested option:");
            System.out.println("\t1: Register child");
            System.out.println("\t2: Manage ticket");
            System.out.println("\t3: Exit park");
            System.out.println("\t0: Exit");
            choise = scan.nextLine();

            switch (choise) {
                case "1": //Register child
                    register_child(scan);
                    break;
                case "2": //Manage ticket
                    manage_ticket(scan);
                    break;
                case "3": //Exit park
                    exit_park(scan);
                    break;
                case "4": //Exit
                    System.exit(0);
                    break;
                }
        }while (!choise.equals("0")) ;
    }

    private static void exit_park(Scanner scan) {
    }

    private static void manage_ticket(Scanner scan) {
        boolean manageMenu = true;
        do {
            System.out.println("\t 1: Add ride");
            System.out.println("\t 2: Remove ride");
            String choice = scan.nextLine();
            switch (choice) {
                case "1": //Add Ride
                    //Add_ride(scan, id);
                    manageMenu = false;
                    break;
                case "2": //Remove Ride
                    //Remove_ride(id);
                    manageMenu = false;
                    break;
            }

            }while(manageMenu);


    }

    private static void register_child(Scanner scan) {
        
    }
}
