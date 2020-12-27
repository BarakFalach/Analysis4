import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class eTicket {

    static Map<String, String> mapIds = new HashMap<String, String>();

    private String id;
    private int status;
    private float debt;
    private boolean isValid;
    private float timeLimit;
    private long timeStarted;
    private ArrayList<Device> devices;

    public eTicket(String childId, float timeInMin){
        this.id = createUniqueId(childId);
        this.status = 0;
        this.debt = 0;
        this.isValid = true;
        this.timeLimit = timeInMin;
        this.devices = new ArrayList<Device>();
        this.timeStarted = System.currentTimeMillis();
    }

    private String createUniqueId(String childId){
        String uniqueId = UUID.randomUUID().toString();
        while (mapIds.containsKey(uniqueId))
            uniqueId = UUID.randomUUID().toString();
        mapIds.put(uniqueId, childId);
        return uniqueId;
    }

    public void addRide(Device d){
        devices.add(d);
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

    public void exitDevice(String name){
        this.debt += getDevicePrice(name) != -1 ?getDevicePrice(name) : 0;
        removeRide(name);
    }

    public void getOnDevice(String name){
        if(isValidTicket())
            exitDevice(name);
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
