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

    public eTicket(String childId, double timeInMin, double height, double weight, double age){
        this.id = childId;
        this.status = 0;
        this.height = height;
        this.weight = weight;
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
        this.numOfActiveRides.put(d.getName(), (this.numOfActiveRides.containsKey(d.getName()))? this.numOfActiveRides.get(d.getName()) + 1 :0);
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

    public String[] getOptionalRidesToRemove(){
        Map<Object, Object> collect = this.numOfActiveRides.entrySet().stream()
                .filter(x -> x.getValue() > 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return (String[]) collect.keySet().toArray();
    }

    public void jumpOnRide(String rideName){
        boolean b = eParkSystem.getDevice(rideName).rideOnDevice();

        if(b){
            this.removeRide(rideName);
            this.numOfRidesOnDevice.put(rideName, this.numOfRidesOnDevice.get(rideName)+1);
        }
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

    public double getAge() {
        return age;
    }

    public boolean isValid() {
        return isValid;
    }
}
