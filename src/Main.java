import java.util.*;
//TODO : 1 -
public class Main {
    public static List<Object> systemObjects = new LinkedList<>();
    public static eParkSystem system = new eParkSystem();
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        InitDevices();
        String choise = null;
        do {
            System.out.println("Please press the requested option:");
            System.out.println("\t1: Register child");
            System.out.println("\t2: Enter Park");
            System.out.println("\t3: Manage ticket");
            System.out.println("\t4: Jump on ride");
            System.out.println("\t5: Exit park");
            System.out.println("\t0: Exit");
            choise = scan.nextLine();

            switch (choise) {
                case "1": //Register child
                    register_child(scan);
                    break;
                case "2": //Enter Park
                    break;
                case "3": //Manage ticket
                    manage_ticket(scan);
                    break;
                case "4": //jump on Ride
                    break;
                case "5": //Exit Park
                    exit_park(scan);
                    break;
                case "0": //Exit
                    System.exit(0);
                    break;
                }
        }while (!choise.equals("0")) ;
    }

    private static void InitDevices() {
        //Device mambaRide = new extremeDevice(40,1.4,12,true,"Mamba Ride",50);
    }

    private static void exit_park_all(){
        for (Child c : system.getGuardians().get(0).getMyChildes().keySet()) {
            exit_park_child(c.getId());
        }
    }

    private static void exit_park_child(Scanner scan){
        try {
            int id = Integer.parseInt(scan.toString());
            if(system.getGuardians().get(0).getMyChildes().contains(id)){
                exit_park_child(id);
            }
        } catch (ClassCastException e){
            System.out.println("Please insert digits only");
        }
    }

    private static void exit_park_child(int id){
        if(system.getGuardians().get(0).getMyChildes().contains(id)){
            Child c = system.getGuardians().get(0).getMyChildes().get(id);
            double debt = c.getTicket().getDebt();
            System.out.println(String.format("child : %s child Id: %d has left the park, Debt: %.2f", c.getFirstName(), c.getId(), debt));
        }
    }

    private static void exit_park(Scanner scan) {
        boolean exit_park = true;
        do {
            System.out.println("\t 1: All children of current guardian");
            System.out.println("\t 2: Chose specific child");
            String choice = scan.nextLine();
            switch (choice) {
                case "1": // All children of current guardian
                    exit_park_all();
                    exit_park = false;
                    break;
                case "2": // Specific child
                    exit_park_child(scan);
                    exit_park = false;
                    break;
            }

        }while(exit_park);
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
        //Registration Form
        String firstName="", lastName="", id="";
        int age=0;
        float height = 0,weight=0;
        boolean childAdd = true;
        do {
            try {
                System.out.println("Enter your first name:");
                firstName = scan.nextLine();
                if (!firstName.matches("[a-zA-Z]+")){
                    System.out.println("first name must contain only letters");
                }

                System.out.println("Enter your last name:");
                lastName = scan.nextLine();
                if (!lastName.matches("[a-zA-Z]+")){
                    System.out.println("Last name must contain only letters");
                }

                System.out.println("Enter your id:");
                id = scan.nextLine();
                if (!id.matches("[0-9]+")){
                    System.out.println("ID must contain only numbers");
                    childAdd = false;
                }

                System.out.println("Enter child age:");
                age = Integer.parseInt(scan.nextLine());
                if( age <= 0 ){
                    System.out.println("age must be greater then zero,try again");
                    childAdd = false;
                }
                System.out.println("Enter child height:");
                height = Float.parseFloat(scan.nextLine());
                if( height <= 0 ){
                    System.out.println("height must be greater then zero,try again");
                    childAdd = false;
                }
                System.out.println("Enter child weight:");
                weight = Float.parseFloat(scan.nextLine());
                if( weight <= 0 ){
                    System.out.println("weight must be greater then zero,try again");
                    childAdd = false;
                }
                childAdd= !childAdd;
            } catch (Exception e) {
                System.out.println("Incorrect input,try again");
            }
        }while (!childAdd);

        Child newChild = new Child(id,firstName,lastName,height,weight,age);
    }
}
