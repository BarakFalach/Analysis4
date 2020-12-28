import java.util.*;

public class eParkSystem {
    private HashMap<String, Device> Devices;
    private List<Guardian> Guardians;
    private HashMap<Child, Guardian> Childs;

    public eParkSystem(){
        this.Devices = new HashMap<>();
        this.Childs = new HashMap<>();
        this.Guardians = new LinkedList<>();
    }

    public List<Guardian> getGuardians() {
        return Guardians;
    }

    public HashMap<String, Device> getDevices() {
        return Devices;
    }

    public HashMap<Child, Guardian> getChilds() {
        return Childs;
    }

    public void addGuardian(Guardian g){
        this.Guardians.add(g);
    }

    public void removeGuardian(Guardian g){
        this.Guardians.remove(g);
    }

    public void addChild(Child c,Guardian g){
        this.Childs.put(c,g);
    }
}
