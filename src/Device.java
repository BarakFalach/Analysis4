import java.util.ArrayList;

public class Device {
    private float price;


    public String name;
    private int minWeight;
    private int minHeight;
    private int minAge;
    private boolean isOpen;
    private float price;
    private final ArrayList<eTicket> eTickets;

    public Device(int minWeight, int minHeight, int minAge, boolean isOpen,String name,float price) {

        this.minWeight = minWeight;
        this.minHeight = minHeight;
        this.minAge = minAge;
        this.isOpen = isOpen;
        this.price = price;
        this.eTickets = new ArrayList<>();
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addETicket(eTicket ticket){
        this.eTickets.add(ticket);
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public int getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(int minWeight) {
        this.minWeight = minWeight;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
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

    public float getPrice() {
        return this.price;
    }
}
