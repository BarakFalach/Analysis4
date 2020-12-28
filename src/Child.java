public class Child {
    private String id;
    private String firstName;
    private String lastName;
    private float height;
    private float weight;
    private int age;
    private Bracelet bracelet;
    private eTicket ticket;
    //TODO location

    public Child(String id, String firstName, String lastName, float height, float weight, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    public Bracelet getBracelet() {
        return bracelet;
    }

    public eTicket getTicket() {
        return ticket;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBracelet(Bracelet bracelet) {
        if(bracelet==null)
            return;
        this.bracelet = bracelet;
    }

    public void setTicket(eTicket ticket) {
        if(ticket==null)
            return;
        this.ticket = ticket;
    }

    public boolean isEqual(Child child){
        if(child != null)
            return this.id == child.id;
        return false;
    }
}
