import java.util.ArrayList;

public class Device {
    private int minWeight;
    private int minHeight;
    private int minAge;
    private boolean isOpen;
    private final ArrayList<eTicket> eTickets;

    public Device(int minWeight, int minHeight, int minAge, boolean isOpen) {
        this.minWeight = minWeight;
        this.minHeight = minHeight;
        this.minAge = minAge;
        this.isOpen = isOpen;
        this.eTickets = new ArrayList<>();
    }

    public void addETicket(eTicket ticket){
        this.eTickets.add(ticket);
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
}