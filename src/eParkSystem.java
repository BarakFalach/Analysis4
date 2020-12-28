import java.util.*;

public class eParkSystem {
    private static List<Device> devices;
    private Guardian guardian;
    private final HashMap<Child, Guardian> children;

    public eParkSystem(){
        devices = new LinkedList<>();
        this.children = new HashMap<>();
    }

    public static Device getDeviceByName(String deviceName){
        for (Device device : devices){
            if (device.getName().equals(deviceName)){
                return device;
            }
        }
        return null;
    }


    public List<Device> getDevices() {
        return devices;
    }

    public HashMap<Child, Guardian> getChilds() {
        return children;
    }

    public void addChild(Child c,Guardian g){
        this.children.put(c,g);
    }

    public Guardian getGuardian() {
        return guardian;
    }

    public void addDevice(Device d){ devices.add(d);}

    public void setGuardian(Guardian g){this.guardian =g;}
}
