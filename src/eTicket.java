import java.util.*;
import java.util.stream.Collectors;


public class eTicket {
    private String id;
    private int status;
    private double height;
    private double weight;
    private double age;
    private double debt;
    private boolean isValid;
    private double timeLimit;
    private long timeStarted;
    private HashMap<String, Integer> numOfActiveRides;
    private HashMap<String, Integer> numOfRidesOnDevice;
    private HashMap<String, Double> pricePerDevice;

    public eTicket(String childId, double timeInMin, double age){
        this.id = childId;
        this.status = 0;
        this.age = age;
        this.debt = 0;
        this.isValid = true;
        this.timeLimit = timeInMin;
        this.numOfActiveRides = new HashMap<>();
        this.numOfRidesOnDevice = new HashMap<>();
        this.pricePerDevice = new HashMap<>();
        this.timeStarted = System.currentTimeMillis();
    }

    public void addRide(Device d){
        this.numOfActiveRides.put(d.getName(), (this.numOfActiveRides.containsKey(d.getName()))? this.numOfActiveRides.get(d.getName()) + 1 :1);
        if (!this.numOfRidesOnDevice.containsKey(d.getName())){
            this.numOfRidesOnDevice.put(d.getName(), 0);
            this.pricePerDevice.put(d.getName(), d.getPrice());
        }
        this.status++;
    }

    public void removeRide(String rideName){
        if(this.numOfActiveRides.containsKey(rideName))
            this.numOfActiveRides.put(rideName, this.numOfActiveRides.get(rideName)-1);
    }

    public ArrayList<String> getOptionalRides(){
        ArrayList<String> s = new ArrayList<>();
        for (String key : numOfActiveRides.keySet()){
            if (numOfActiveRides.get(key)>0){
                s.add(key);
            }
        }
        return s;
    }

    public boolean jumpOnRide(String rideName){
        Device d = eParkSystem.getDeviceByName(rideName);
        if (d != null){
            boolean b = Objects.requireNonNull(eParkSystem.getDeviceByName(rideName)).rideOnDevice(this);

            if(b){
                this.removeRide(rideName);
                this.numOfRidesOnDevice.put(rideName, this.numOfRidesOnDevice.get(rideName)+1);
                System.out.println(String.format("Child is riding on %s Ohhh Yeah!", rideName));
            }

            else
                System.out.println(String.format("Child cant ride on: %s ", rideName));
            return b;
        }

        else {
            System.out.println(String.format("There is no such a device: %s", rideName));
        }

        return false;
    }

    public boolean existActiveRideToDevice(String deviceName){
        return (this.numOfActiveRides.containsKey(deviceName) && this.numOfActiveRides.get(deviceName) > 0);
    }

    public double getDebt(){
        this.debt = 0;
        for (String key : this.numOfRidesOnDevice.keySet()){
            this.debt+= numOfRidesOnDevice.get(key) * pricePerDevice.get(key);
        }
        return this.debt;
    }

    public boolean isTimeOk(){
        double curr_time = System.currentTimeMillis();
        if ((curr_time-this.timeStarted)/1000/60 > this.timeLimit){
            this.isValid = false;
        }
        return this.isValid;
    }

    public String getId() {
        return id;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public void setHeight(double height){this.height = height;}

    public void setWeight(double weight){this.weight =weight;}

    public double getAge() {
        return age;
    }

    public boolean isValid() {
        return isValid;
    }
}
