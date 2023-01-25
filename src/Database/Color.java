package Database;
import java.sql.Timestamp;

public class Color {
    private int colorID;
    private String colorName;
    private Timestamp created;
    private Timestamp lastUpdated;

    public Color() { }

    public Color(int colorID, String colorName, Timestamp created, Timestamp lastUpdated) {
        this.colorID = colorID;
        this.colorName = colorName;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public int getColorID() {
        return colorID;
    }

    public void setColorID(int colorID) {
        this.colorID = colorID;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
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