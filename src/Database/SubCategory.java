package Database;

import java.sql.Timestamp;

public class SubCategory {
    private int subCategoryID;
    private String subCategoryName;
    private Timestamp created;
    private Timestamp lastUpdated;

    public SubCategory() { }

    public SubCategory(int subCategoryID, String subCategoryName, Timestamp created, Timestamp lastUpdated) {
        this.subCategoryID = subCategoryID;
        this.subCategoryName = subCategoryName;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public int getSubCategoryID() {
        return subCategoryID;
    }

    public void setSubCategoryID(int subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
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