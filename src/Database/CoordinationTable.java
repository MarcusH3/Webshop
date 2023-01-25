package Database;
import java.sql.Timestamp;

public class CoordinationTable {
    private int coordinationTableID;
    private int customerID;
    private Timestamp created;
    private Timestamp lastUpdated;

    public CoordinationTable() { }

    public CoordinationTable(int coordinationTableID, int customerID, Timestamp created, Timestamp lastUpdated) {
        this.coordinationTableID = coordinationTableID;
        this.customerID = customerID;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public int getCoordinationTableID() {
        return coordinationTableID;
    }

    public void setCoordinationTableID(int coordinationTableID) {
        this.coordinationTableID = coordinationTableID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
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