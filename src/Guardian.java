import java.util.ArrayList;
import java.util.HashMap;

public class Guardian {
    private int id;
    private HashMap<String,Child> myChildes;
    //TODO credit card

    public Guardian(int id, Child child) {
        this.id = id;
        myChildes = new HashMap<>();
        myChildes.put(child.getId(), child);
    }

    public Guardian(int id, HashMap<String, Child> myChildes) {
        this.id = id;
        this.myChildes = myChildes;
    }

    public int getId() {
        return id;
    }

    public HashMap<String, Child> getMyChildes() {
        return myChildes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMyChildes(HashMap<String, Child> myChildes) {
        if(myChildes==null)
            return;
        this.myChildes = myChildes;
    }
    public boolean buyTicket(Child child, Device device, int numOfTicket){

        return true;
    }


}
