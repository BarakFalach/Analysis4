import java.util.ArrayList;

public class Device {
    private final float price;
    public String name;
    private final float minWeight;
    private final float minHeight;
    private final int minAge;
    private boolean isOpen;

    public Device(float minWeight, float minHeight, int minAge, boolean isOpen,String name,float price) {

        this.minWeight = minWeight;
        this.minHeight = minHeight;
        this.minAge = minAge;
        this.isOpen = isOpen;
        this.price = price;
        this.name = name;
    }

    public float getMinWeight() {
        return minWeight;
    }


    public float getMinHeight() {
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

    public float getPrice() {
        return this.price;
    }
}
