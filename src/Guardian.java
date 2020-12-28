import java.util.ArrayList;

public class Guardian {
    private double amount;
    private String cardnumber;
    private ArrayList<Child> myChildes;

    public Guardian(String cardnumber, double amount) {
        this.cardnumber= cardnumber;
        this.amount = amount;
        myChildes = new ArrayList<>();
    }


    public ArrayList<Child> getMyChildes() {
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
