package examples.omar.mx.android_mvvm_architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Registered {

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("age")
    @Expose
    private int age;

    @Override
    public String toString() {
        return "Registered{" +
                "date='" + date + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
