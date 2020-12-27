import java.util.*;

public class Main {
    public static List<Object> systemObjects = new LinkedList<>();
    public static eParkSystem system = new eParkSystem();
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        String choise = null;
        do {
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
