package Database;
import java.sql.Timestamp;

public class OrderDetail {
    private int orderDetailID;
    private int coordinationTableID;
    private int inventoryID;
    private int quantity;
    private Timestamp created;
    private Timestamp lastUpdated;

    public OrderDetail() { }

    public OrderDetail(int orderDetailID, int coordinationTableID, int inventoryID, int quantity, Timestamp created, Timestamp lastUpdated) {
        this.orderDetailID = orderDetailID;
        this.coordinationTableID = coordinationTableID;
        this.inventoryID = inventoryID;
        this.quantity = quantity;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public int getCoordinationTableID() {
        return coordinationTableID;
    }

    public void setCoordinationTableID(int coordinationTableID) {
        this.coordinationTableID = coordinationTableID;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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