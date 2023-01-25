package Database;
import java.sql.Timestamp;

public class Inventory {
    private int inventoryID;
    private int productID;
    private int inStock;
    private Timestamp created;
    private Timestamp lastUpdated;

    public Inventory() { }

    public Inventory(int inventoryID, int productID, int inStock, Timestamp created, Timestamp lastUpdated) {
        this.inventoryID = inventoryID;
        this.productID = productID;
        this.inStock = inStock;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
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