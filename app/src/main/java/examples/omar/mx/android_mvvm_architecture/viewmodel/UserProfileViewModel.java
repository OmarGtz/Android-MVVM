package examples.omar.mx.android_mvvm_architecture.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import examples.omar.mx.android_mvvm_architecture.model.RandomUsers;
import examples.omar.mx.android_mvvm_architecture.model.User;

public class UserProfileViewModel extends ViewModel{

    private String userId;
    private LiveData<RandomUsers> randomUsers ;

    public void init(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public LiveData<RandomUsers> getRandomUsers() {
        return randomUsers;
    }

}
