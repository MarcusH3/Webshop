package Database;

import java.sql.Timestamp;

public class Category {
    private int categoryID;
    private int subCategoryID;
    private int genderCategoryID;
    private Timestamp created;
    private Timestamp lastUpdated;

    public Category() { }

    public Category(int categoryID, int subCategoryID, int genderCategoryID, Timestamp created, Timestamp lastUpdated) {
        this.categoryID = categoryID;
        this.subCategoryID = subCategoryID;
        this.genderCategoryID = genderCategoryID;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getSubCategoryID() {
        return subCategoryID;
    }

    public void setSubCategoryID(int subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    public int getGenderCategoryID() {
        return genderCategoryID;
    }

    public void setGenderCategoryID(int genderCategoryID) {
        this.genderCategoryID = genderCategoryID;
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