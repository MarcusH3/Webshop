package Database;
import java.sql.Timestamp;

public class Product {
    private int productID;
    private String modelName;
    private int manufacturerID;
    private int categoryID;
    private int sizeID;
    private int colorID;
    private double price;
    private Timestamp created;
    private Timestamp lastUpdated;

    public Product() { }

    public Product(int productID, String modelName, int manufacturerID, int categoryID, int sizeID, int colorID, double price, Timestamp created, Timestamp lastUpdated) {
        this.productID = productID;
        this.modelName = modelName;
        this.manufacturerID = manufacturerID;
        this.categoryID = categoryID;
        this.sizeID = sizeID;
        this.colorID = colorID;
        this.price = price;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public Product(int id, String modelName, double price, Size size, Manufacturer manufacturer, Color color) {
    }
    //TODO NY Konstruktor, borde ej påverka.

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getManufacturerID() {
        return manufacturerID;
    }

    public void setManufacturerID(int manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getSizeID() {
        return sizeID;
    }

    public void setSizeID(int sizeID) {
        this.sizeID = sizeID;
    }

    public int getColorID() {
        return colorID;
    }

    public void setColorID(int colorID) {
        this.colorID = colorID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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