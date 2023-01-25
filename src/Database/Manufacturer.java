package Database;

import java.sql.Timestamp;

public class Manufacturer {
    private int manufacturerID;
    private String manufacturerName;
    private String manufacturerAddress;
    private String manufacturerPhoneNumber;
    private Timestamp created;
    private Timestamp lastUpdated;

    public Manufacturer() { }

    public Manufacturer(int manufacturerID, String manufacturerName, String manufacturerAddress, String manufacturerPhoneNumber, Timestamp created, Timestamp lastUpdated) {
        this.manufacturerID = manufacturerID;
        this.manufacturerName = manufacturerName;
        this.manufacturerAddress = manufacturerAddress;
        this.manufacturerPhoneNumber = manufacturerPhoneNumber;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public int getManufacturerID() {
        return manufacturerID;
    }

    public void setManufacturerID(int manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerAddress() {
        return manufacturerAddress;
    }

    public void setManufacturerAddress(String manufacturerAddress) {
        this.manufacturerAddress = manufacturerAddress;
    }

    public String getManufacturerPhoneNumber() {
        return manufacturerPhoneNumber;
    }

    public void setManufacturerPhoneNumber(String manufacturerPhoneNumber) {
        this.manufacturerPhoneNumber = manufacturerPhoneNumber;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}