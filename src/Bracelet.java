public class Bracelet {
    public String visitorId;
    public double[] coordinate;


    public Bracelet(String visitorId) {
        this.visitorId = visitorId;
        this.coordinate = new double[2];
    }

    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public double[] getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(double longitude, double latitude) {

        this.coordinate[0] = longitude;
        this.coordinate[1] = latitude;
    }
}
