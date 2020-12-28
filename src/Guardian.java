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


    public boolean buyTicket(Child child, Device device, int numOfTicket){
        return true;
    }

    public String childrenInPark()
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (String childId : myChildes.keySet()){
            Child child = myChildes.get(childId);
            if (child.getBracelet()!=null){
                stringBuilder.append(child.getFirstName());
                stringBuilder.append(" ");
                stringBuilder.append(child.getLastName());
                stringBuilder.append(" id: ");
                stringBuilder.append(child.getId());
                stringBuilder.append("\n");
            }
        }
        if (stringBuilder.length() == 0)
            return "You have no children's in the Park";
        return stringBuilder.toString();

    }
    public String childrenNotInPark()
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (String childID : myChildes.keySet()){
            Child child = myChildes.get(childID);
            if (child.getBracelet()==null){
                stringBuilder.append(child.getFirstName());
                stringBuilder.append(" ");
                stringBuilder.append(child.getLastName());
                stringBuilder.append(" id: ");
                stringBuilder.append(child.getId());
                stringBuilder.append("\n");
            }
        }
        if (stringBuilder.length() == 0)
            return "You have no children's that can Enter The park ";
        return stringBuilder.toString();
    }


}
