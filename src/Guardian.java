import java.util.ArrayList;
import java.util.HashMap;

public class Guardian {

    private double amount;
    private String cardNumber;
    private HashMap<String,Child> myChildren;

    public Guardian(String cardNumber, double amount) {
        this.cardNumber= cardNumber;
        this.amount = amount;
        myChildren = new HashMap<>();
    }

    public HashMap<String, Child> getMyChildren() {
        return myChildren;
    }

    public boolean buyTicket(Child child, Device device, int numOfTicket){
        return true;
    }

    public String childrenInPark()
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (String childId : myChildren.keySet()){
            Child child = myChildren.get(childId);
            if (child.getBracelet()!=null){
                stringBuilder.append(child.getFirstName());
                stringBuilder.append(" ");
                stringBuilder.append(child.getLastName());
                stringBuilder.append(" id: ");
                stringBuilder.append(child.getId());
                stringBuilder.append("\n");
            }
        }
        if (stringBuilder.length()==0)

            return "You have no children's in the Park";
        return stringBuilder.toString();

    }
    public String childrenNotInPark()
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (String childID : myChildren.keySet()){
            Child child = myChildren.get(childID);
            if (child.getBracelet()==null){
                stringBuilder.append(child.getFirstName());
                stringBuilder.append(" ");
                stringBuilder.append(child.getLastName());
                stringBuilder.append(" id: ");
                stringBuilder.append(child.getId());
                stringBuilder.append("\n");
            }
        }
        if (stringBuilder.length()==0)

            return "You have no children's that can Enter The park ";
        return stringBuilder.toString();
    }

    public Child getChildByID(String childID){
        if(myChildren.containsKey(childID))
            return myChildren.get(childID);
        return null;
    }

    public boolean addChild(Child child){
        if(child == null)
            return false;
        for(Child existChild : myChildren.values()){
            if(child.isEqual(existChild)){
                return false;
            }
        }
        myChildren.put(child.getId(), child);
        return true;
    }





}
