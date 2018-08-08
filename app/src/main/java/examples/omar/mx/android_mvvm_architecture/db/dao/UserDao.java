package examples.omar.mx.android_mvvm_architecture.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.icu.lang.UScript;

import java.util.Date;

import examples.omar.mx.android_mvvm_architecture.model.User;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {

    @Insert(onConflict = REPLACE)
    void save(User user);

    @Query("SELECT * FROM TABLE_USER WHERE login = :userLogin")
    LiveData<User> loadUser(String userLogin);

    @Query("SELECT * FROM TABLE_USER Where login = :userLogin AND last_refresh >:lastRefresh LIMIT 1")
    User getUser(String userLogin,Date lastRefresh);

}
