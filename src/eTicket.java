import java.util.*;

public class eTicket {

    static Map<String, String> mapIds = new HashMap<String, String>();

    private String id;
    private float debt;
    private boolean isValid;
    private Date timeLimit;
    private ArrayList<Device> devices;

    public eTicket(String childId){
        this.id = createUniqueId(childId);
        this.debt = 0;
        this.isValid = true;
        this.timeLimit = new Date();
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
    }

    public void removeRide(String name){
        devices.removeIf(device -> device.name.equal(name));
    }

    public static Map<String, String> getMapIds() {
        return mapIds;
    }

    public static void setMapIds(Map<String, String> mapIds) {
        eTicket.mapIds = mapIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getDebt() {
        return debt;
    }

    public void setDebt(float debt) {
        this.debt = debt;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Date getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Date timeLimit) {
        this.timeLimit = timeLimit;
    }
}
