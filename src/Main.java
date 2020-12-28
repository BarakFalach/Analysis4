import java.util.*;
//TODO : 1 -
public class Main {
    public static List<Object> systemObjects = new LinkedList<>();
    public static eParkSystem system = new eParkSystem();
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        InitDevices();
        InitGuardian();
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
                    enter_park(scan);
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


    private static void InitGuardian() {
        System.out.println(" ⭐⭐⭐⭐ Welcome To Gashash Land ⭐⭐⭐⭐ \n ");
        System.out.println("Guardian Please enter the following details inorder to continue. ");
        boolean cardDetails = true;
        double amount=0;
        String cardnumber="";
        while (cardDetails){
            try{
                System.out.println("Please enter your Credit Card number");
                cardnumber = scan.nextLine();
                if (!cardnumber.matches("[0-9]+")){
                    System.out.println("Card Number must contain only numbers,try again");
                    throw new Exception("");
                }
                else{
                    System.out.println("Please enter your Maximum amount you are willing to pay");
                    amount = Double.parseDouble(scan.nextLine());
                    if (amount <=0){
                        System.out.println("Credit Card Declined by you company,try again");
                        throw new Exception("");
                    }
                }
                cardDetails = false;
            }catch (Exception e){
                System.out.println("Try Again!");
                cardDetails = true;
            }
        }
        System.out.println("\n Request Approved, Congrats!");
        Guardian guardian = new Guardian(cardnumber,amount);
        systemObjects.add(guardian);
        system.setGuardian(guardian);
        System.out.println("Guardian Registered!");
    }

    private static void InitDevices() {
        Device mambaRide = new extremeDevice(0, 1.4,12,true,"Mamba Ride",50);
        systemObjects.add(mambaRide);
        system.addDevice(mambaRide);
        Device GiantWheel = new Device(0,0,0,true,"Giant Wheel",30);
        systemObjects.add(GiantWheel);
        system.addDevice(GiantWheel);
        Device Carrousel = new Device(0,0,8,true,"Carrousel",25);
        systemObjects.add(Carrousel);
        system.addDevice(Carrousel);
    }

    private static void exit_park_all(){
        if(system.getGuardian() != null && system.getGuardian().getMyChildren() != null) {
            for (String childID : system.getGuardian().getMyChildren().keySet()) {
                exit_park_child(childID);
            }
            System.out.println("All children of current guardian were exit from the park");
        }
        else {
            System.out.println("The are not children of current guardian at the park");
        }
    }

    private static void exit_park_child(Scanner scan){
        boolean flag = false;
        do {
            if(system.getGuardian() != null && system.getGuardian().getMyChildren()!=null){
                System.out.println("Please insert child Id to exit from park:");
                for (String childId: system.getGuardian().getMyChildren().keySet()){
                    System.out.println(childId);
                }
                String id = scan.nextLine();
                if (!id.matches("[0-9]+")) {
                    System.out.println("ID must contain only numbers");
                }
                else {
                    exit_park_child(id);
                    flag = true;
                }
            }

            else {
                System.out.println("guardian not exist");
                flag = true;
            }
        } while (!flag);
    }

    private static void exit_park_child(String id){
        if(system.getGuardian().getMyChildren().containsKey(id)){
            Child c = system.getGuardian().getMyChildren().get(id);
            double debt = c.getTicket().getDebt();
            System.out.println(String.format("child : %s (child Id: %s) has left the park, Debt: %.2f", c.getFirstName(), c.getId(), debt));
        }
    }

    private static void enter_park(Scanner scan) {
        Guardian guardian = system.getGuardian();
        HashMap<String, Child> myChildren = guardian.getMyChildren();
        if(myChildren.keySet().size()==0){
            System.out.println("you dont have any children in the system.");
            return;
        }
        boolean manageMenu = true;
        do {
            System.out.println("\t 1: Enter child");
            System.out.println("\t 2: Enter children");
            System.out.println("\t 3: Exit");
            String choise = scan.nextLine();
            switch (choise) {
                case "1":
                    System.out.println(guardian.childrenNotInPark());
                    System.out.println("\t Please enter child ID: ");
                    String childID = scan.nextLine();
                    if(myChildren.containsKey(childID)) {
                        Child child = myChildren.get(childID);
                        if (!enter_child(child))
                            System.out.println("The child is in the park already");
                        else
                            manageMenu=false;
                    }
                    else
                        System.out.println("\t The ID number is not valid");
                    break;
                case "2":
                    for(Child child : myChildren.values())
                        enter_child(child);
                    System.out.println("all your children entered the park");
                    break;
                case "3":
                    manageMenu=false;
                default:
                    System.out.println("please enter valid value");
            }
        }while(manageMenu);
    }

    private static boolean enter_child(Child child){
        if(child.getBracelet()!=null)
            return false;
        Bracelet newBracelet = new Bracelet(child.getId());
        child.setBracelet(newBracelet);
        eTicket ticket = child.getTicket();
        ticket.setHeight(child.getHeight());
        ticket.setWeight(child.getWeight());
        systemObjects.add(newBracelet);
        return true;
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
        while(childAdd){
            try {
                System.out.println("Enter your first name:");
                firstName = scan.nextLine();
                if (!firstName.matches("[a-zA-Z]+")){
                    System.out.println("first name must contain only letters");
                    throw new Exception("");
                }

                System.out.println("Enter your last name:");
                lastName = scan.nextLine();
                if (!lastName.matches("[a-zA-Z]+")){
                    System.out.println("Last name must contain only letters");
                    throw new Exception("");
                }

                System.out.println("Enter your id:");
                id = scan.nextLine();
                if (!id.matches("[0-9]+")){
                    System.out.println("ID must contain only numbers");
                    throw new Exception("");
                }

                System.out.println("Enter child age:");
                age = Integer.parseInt(scan.nextLine());
                if( age <= 0 ){
                    System.out.println("age must be greater then zero,try again");
                    throw new Exception("");
                }
                childAdd= false;
            } catch (Exception e) {
                System.out.println("Incorrect input,try again");
                childAdd= true;
            }
        }
        RegisterationForm regForm = new RegisterationForm(firstName,lastName,id,age);
        Child newChild = new Child(regForm.getId(),regForm.getFirstName(),regForm.getLastName(),regForm.getAge());
        systemObjects.add(newChild);
        System.out.println(String.format("\n Final step guardian , please enter time limit in minutes(positive double) for {} :)", regForm.getFirstName()));
        // TODO : TOM - add eTicket creation with and ask for timelimit
        double timelimit;
        try {
            timelimit = Double.parseDouble(scan.nextLine());
        }catch (Exception e){
            System.out.println("Wrong time limit entered setting default time limit to 30 min");
            timelimit = 30;
        }
        eTicket et = new eTicket(newChild.getId(),timelimit, newChild.getAge());
        systemObjects.add(et);
        newChild.setTicket(et);
        system.getGuardian().addChild(newChild);
        System.out.println("Child Added ! \n");

    }







}
