package Database;

import java.sql.Timestamp;

public class Manufacturer {
    private int manufacturerID;
    private String manufacturerName;

    public Manufacturer(int manufacturerID, String manufacturerName) {
        this.manufacturerID = manufacturerID;
        this.manufacturerName = manufacturerName;
    }
    public String getManufacturerName(){
    return manufacturerName;}

    @Override
    public String toString(){
        return "Manufacturer{" + "id=" + manufacturerID +
                ", brandName='" + manufacturerName + '\'' +
                '}';
    }

    public int getManufacturerID() {
        return manufacturerID;
    }

    public void setManufacturerID(int manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }
}