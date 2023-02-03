package Database;

public class Size {
    private int sizeID;
    private double euSize;
    private double ukSize;
    private double usSize;



    public Size(int sizeID, int euSize, int ukSize, int usSize) {
        this.sizeID = sizeID;
        this.euSize = euSize;
        this.ukSize = ukSize;
        this.usSize = usSize;

    }
    public double getEuSize(){
    return euSize;}

    public double getukSize(){
    return ukSize;}

    public double getusSize(){
        return usSize;}

    @Override
    public String toString(){
        return "Size{" +
                "id=" + sizeID + ", eu=" + euSize +
                ", uk=" + ukSize + ", us=" + usSize +
                '}';
    }

    public int getSizeID() {
        return sizeID;
    }

    public void setSizeID(int sizeID) {
        this.sizeID = sizeID;
    }

    public void setEuSize(double euSize) {
        this.euSize = euSize;
    }

    public double getUkSize() {
        return ukSize;
    }

    public void setUkSize(double ukSize) {
        this.ukSize = ukSize;
    }

    public double getUsSize() {
        return usSize;
    }

    public void setUsSize(double usSize) {
        this.usSize = usSize;
    }
}

