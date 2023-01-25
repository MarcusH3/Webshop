package Database;
import java.sql.Timestamp;

public class Order {
    private int orderID;
    private int coordinationTableID;
    private Timestamp orderDate;
    private Timestamp lastUpdated;

    public Order() { }

    public Order(int orderID, int coordinationTableID, Timestamp orderDate, Timestamp lastUpdated) {
        this.orderID = orderID;
        this.coordinationTableID = coordinationTableID;
        this.orderDate = orderDate;
        this.lastUpdated = lastUpdated;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCoordinationTableID() {
        return coordinationTableID;
    }

    public void setCoordinationTableID(int coordinationTableID) {
        this.coordinationTableID = coordinationTableID;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}