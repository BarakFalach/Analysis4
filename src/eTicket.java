import java.util.*;


public class eTicket {
    private String id;
    private int status;
    private float debt;
    private boolean isValid;
    private float timeLimit;
    private long timeStarted;
    private ArrayList<Device> devices;
    private HashMap<String, Integer> numOfRidesOnDevice;
    private HashMap<String, Float> pricePerDevice;

    public eTicket(String childId, float timeInMin){
        this.id = childId;
        this.status = 0;
        this.debt = 0;
        this.isValid = true;
        this.timeLimit = timeInMin;
        this.devices = new ArrayList<Device>();
        this.numOfRidesOnDevice = new HashMap<>();
        this.pricePerDevice = new HashMap<>();
        this.timeStarted = System.currentTimeMillis();
    }

    public void addRide(Device d){
        devices.add(d);
        if (!this.numOfRidesOnDevice.containsKey(d.getName())){
            this.numOfRidesOnDevice.put(d.getName(), 0);
            this.pricePerDevice.put(d.getName(), d.getPrice());
        }
        this.status++;
    }

    public void removeRide(String name){
        int index = -1;
        for (int i = 0 ; i < devices.size(); i++){
            if (devices.get(i).getName().equals(name)) {
                index = i;
                break;
            }
        }
        if(index!=-1) {
            devices.remove(index);
            this.status--;
        }
    }

    public float getDebt(){
        for (String key : this.numOfRidesOnDevice.keySet()){
            this.debt+= numOfRidesOnDevice.get(key) * pricePerDevice.get(key);
        }
        return this.debt;
    }

    public void jumpOnRide(String name){
        if(!isValidTicket()) {
            System.out.println("you cant jump on this device...");
            return;
        }
        this.removeRide(name);
        this.numOfRidesOnDevice.put(name, this.numOfRidesOnDevice.get(name)+1);
    }

    public boolean isValidTicket(){
        float curr_time = System.currentTimeMillis();
        if(!this.isValid)
            return false;
        if ((curr_time-this.timeStarted)/1000/60 > this.timeLimit){
            this.isValid = false;
        }
        return this.isValid;
    }

    public float getDevicePrice(String name) {
        int index = -1;
        for (int i = 0 ; i < devices.size(); i++){
            if (devices.get(i).getName().equals(name)) {
                index = i;
                break;
            }
        }
        if(index!=-1) {
            return devices.get(index).getPrice();
        }
        return -1;
    }
}
