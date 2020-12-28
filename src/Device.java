import java.util.ArrayList;

public class Device {
    private final double price;
    public String name;
    private final double minWeight;
    private final double minHeight;
    private final int minAge;
    private boolean isOpen;


    public Device(double minWeight, double minHeight, int minAge, boolean isOpen,String name,double price) {

        this.minWeight = minWeight;
        this.minHeight = minHeight;
        this.minAge = minAge;
        this.isOpen = isOpen;
        this.price = price;
        this.name = name;
    }

    public double getMinWeight() {
        return minWeight;
    }


    public double getMinHeight() {
        return minHeight;
    }


    public int getMinAge() {
        return minAge;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return this.price;
    }

    public boolean canAddDevice(eTicket ticket)
    {
        return ticket.getHeight() > minHeight && ticket.getWeight() > minWeight && ticket.getAge() > minAge;
    }

    public boolean rideOnDevice(eTicket ticket)
    {
        if  (!ticket.isTimeOk()){
            System.out.println(ticket.getId() +" time limit exceeded" );
            return false;
        }
        if  (!ticket.existActiveRideToDevice(name)){
            System.out.println(ticket.getId() +" have no ride to this device: " + name);
            return false;
        }

        System.out.println(ticket.getId() +" can jump on ride: " + name);
        return true;
    }
}
