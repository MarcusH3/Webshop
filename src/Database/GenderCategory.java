package Database;

import java.sql.Timestamp;

public class GenderCategory {
    private int genderCategoryID;
    private String genderCategoryName;
    private Timestamp created;
    private Timestamp lastUpdated;

    public GenderCategory() { }

    public GenderCategory(int genderCategoryID, String genderCategoryName, Timestamp created, Timestamp lastUpdated) {
        this.genderCategoryID = genderCategoryID;
        this.genderCategoryName = genderCategoryName;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public int getGenderCategoryID() {
        return genderCategoryID;
    }

    public void setGenderCategoryID(int genderCategoryID) {
        this.genderCategoryID = genderCategoryID;
    }

    public String getGenderCategoryName() {
        return genderCategoryName;
    }

    public void setGenderCategoryName(String genderCategoryName) {
        this.genderCategoryName = genderCategoryName;
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