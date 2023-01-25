package Database;

import java.sql.Timestamp;

public class Size {
    private int sizeID;
    private int euSize;
    private int ukSize;
    private int usSize;
    private Timestamp created;
    private Timestamp lastUpdated;

    public Size() { }

    public Size(int sizeID, int euSize, int ukSize, int usSize, Timestamp created, Timestamp lastUpdated) {
        this.sizeID = sizeID;
        this.euSize = euSize;
        this.ukSize = ukSize;
        this.usSize = usSize;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public int getSizeID() {
        return sizeID;
    }

    public void setSizeID(int sizeID) {
        this.sizeID = sizeID;
    }

    public int getEuSize() {
        return euSize;
    }

    public void setEuSize(int euSize) {
        this.euSize = euSize;
    }

    public int getUkSize() {
        return ukSize;
    }

    public void setUkSize(int ukSize) {
        this.ukSize = ukSize;
    }

    public int getUsSize() {
        return usSize;
    }

    public void setUsSize(int usSize) {
        this.usSize = usSize;
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