package examples.omar.mx.android_mvvm_architecture.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import examples.omar.mx.android_mvvm_architecture.Repository.UserRandomRepository;
import examples.omar.mx.android_mvvm_architecture.api.RandomUsersApi;
import examples.omar.mx.android_mvvm_architecture.model.RandomUsers;
import examples.omar.mx.android_mvvm_architecture.model.User;

public class UserProfileViewModel extends ViewModel{

    private String userId;
    private LiveData<RandomUsers> user ;
    private UserRandomRepository repository;

    public UserProfileViewModel(UserRandomRepository repository) {
        this.repository = repository;
    }

    public void init(String userId) {
        this.userId = userId;
        if(this.user!=null){
            return;
        }

        user = repository.getUsers();

    }

    public String getUserId() {
        return userId;
    }

    public LiveData<RandomUsers> getRandomUsers() {
        return user;
    }

}
