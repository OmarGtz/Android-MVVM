package examples.omar.mx.android_mvvm_architecture.db.entity;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "table_user")
public class User {

    @PrimaryKey
    @NonNull
    @SerializedName("id")
    @ColumnInfo(name = "id")
    private String id;

    @SerializedName("login")
    @ColumnInfo(name = "login")
    private String login;
    @ColumnInfo(name = "avatar_url")
    @SerializedName("avatarURL")
    private String avatarURL;
    @ColumnInfo(name = "name")
    @SerializedName("name")
    private String name;
    @ColumnInfo(name = "company")
    @SerializedName("company")
    private String company;
    @SerializedName("blog")
    @ColumnInfo(name = "bog")
    private String blog;
    @SerializedName("lastRefresh")
    @ColumnInfo(name = "last_refresh")
    private String lastRefresh;

    public User() {
    }

    public User( @NonNull String id, String login, String avatarURL, String name, String company, String blog, String lastRefresh) {
        this.id = id;
        this.login = login;
        this.avatarURL = avatarURL;
        this.name = name;
        this.company = company;
        this.blog = blog;
        this.lastRefresh = lastRefresh;
    }


    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getLastRefresh() {
        return lastRefresh;
    }

    public void setLastRefresh(String lastRefresh) {
        this.lastRefresh = lastRefresh;
    }
}
