import java.util.ArrayList;
import java.util.HashMap;

public class Guardian {

    private double amount;
    private String cardnumber;
    private HashMap<String,Child> myChildes;

    public Guardian(String cardnumber, double amount) {
        this.cardnumber= cardnumber;
        this.amount = amount;
        myChildes = new HashMap<>();
    }

    public HashMap<String, Child> getMyChildes() {
        return myChildes;
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
