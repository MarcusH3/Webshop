package Database;
import java.sql.Timestamp;

public class Color {
    private int colorID;
    private String colorName;

    public Color(int colorID, String colorName) {
        this.colorID = colorID;
        this.colorName = colorName;
    }
    public String getColorName(){
    return colorName;
    }

    @Override
    public String toString(){
        return "Color{" +
                "id=" + colorID +
                ", color='" + colorName + '\'' +
                '}';
    }
}