package examples.omar.mx.android_mvvm_architecture.db.room;

import android.arch.persistence.room.Database;

import examples.omar.mx.android_mvvm_architecture.db.dao.UserDao;
import examples.omar.mx.android_mvvm_architecture.db.entity.User;

@Database(entities = {User.class},version = 1)
public abstract class userRoomDatabase {
    public static volatile userRoomDatabase INSTANCE;
    public abstract UserDao userDao();
}
