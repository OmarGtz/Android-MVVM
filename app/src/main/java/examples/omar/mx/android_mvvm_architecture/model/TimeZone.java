package examples.omar.mx.android_mvvm_architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimeZone {

    @Expose
    @SerializedName("offset")
    String offSet;

    @Expose
    @SerializedName("description")
    String description;

    public String getOffSet() {
        return offSet;
    }

    public void setOffSet(String offSet) {
        this.offSet = offSet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TimeZone{" +
                "offSet='" + offSet + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
