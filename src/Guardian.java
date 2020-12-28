import java.util.ArrayList;

public class Guardian {
    private int id;
    private ArrayList<Child> myChildes;
    //TODO credit card

    public Guardian(int id, Child child) {
        this.id = id;
        myChildes = new ArrayList<>();
        myChildes.add(child);
    }

    public Guardian(int id, ArrayList<Child> myChildes) {
        this.id = id;
        this.myChildes = myChildes;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Child> getMyChildes() {
        return myChildes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMyChildes(ArrayList<Child> myChildes) {
        if(myChildes==null)
            return;
        this.myChildes = myChildes;
    }
    public boolean buyTicket(Child child, Device device, int numOfTicket){

        return true;
    }


}
