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

    public HashMap<String, Child> getChildrenInPark(){
        HashMap<String, Child> tmp = new HashMap<>();
        for (String key : this.getMyChildren().keySet()){
            if(this.getMyChildren().get(key).getBracelet()!=null)
                tmp.put(key, this.getMyChildren().get(key));
        }
        return tmp;
    }

    public String childrenInPark()
    {
        System.out.println("---- Children in Park ----");
        StringBuilder stringBuilder = new StringBuilder();
        for (String childId: getChildrenInPark().keySet()) {
            Child child = myChildren.get(childId);
            stringBuilder.append(child.getFirstName());
            stringBuilder.append(" ");
            stringBuilder.append(child.getLastName());
            stringBuilder.append(" id: ");
            stringBuilder.append(child.getId());
            stringBuilder.append("\n");
        }

        if (stringBuilder.length()==0)
            return "You have no children's in the Park";
        return stringBuilder.toString();
    }
    public String childrenNotInPark()
    {
        System.out.println("---Children Not in Park---");
        StringBuilder stringBuilder = new StringBuilder();
        for (String childID : myChildren.keySet()){
            Child child = myChildren.get(childID);
            if (child.getBracelet()==null){
                stringBuilder.append('\t');
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

    public void addChild(Child child){
        if(child == null)
            return;
        for(Child existChild : myChildren.values()){
            if(child.isEqual(existChild)){
                return;
            }
        }
        myChildren.put(child.getId(), child);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount += amount;
    }
}
