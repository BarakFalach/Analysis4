import java.util.*;

public class eParkSystem {
    private List<Device> Devices;
    private HashMap<Integer,Guardian> Guardians;
    private HashMap<Child, Guardian> Childs;

    public eParkSystem(){
        this.Devices = new LinkedList<>();
        this.Childs = new HashMap<>();
        this.Guardians = new HashMap<>();
    }

    public HashMap<Integer,Guardian> getGuardians() {
        return Guardians;
    }

    public List<Device> getDevices() {
        return Devices;
    }

    public HashMap<Child, Guardian> getChilds() {
        return Childs;
    }

    public void addGuardian(Guardian g){
        this.Guardians.put(g.getId(),g);
    }

    public void removeGuardian(Guardian g){
        this.Guardians.remove(g);
    }

    public void addChild(Child c,Guardian g){
        this.Childs.put(c,g);
    }

    public void addDevice(Device d){ this.Devices.add(d);}
}
