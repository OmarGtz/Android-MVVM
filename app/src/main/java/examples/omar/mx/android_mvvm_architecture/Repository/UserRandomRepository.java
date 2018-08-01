package examples.omar.mx.android_mvvm_architecture.Repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import javax.inject.Inject;

import examples.omar.mx.android_mvvm_architecture.App;
import examples.omar.mx.android_mvvm_architecture.api.RandomUsersApi;
import examples.omar.mx.android_mvvm_architecture.model.RandomUsers;

public class UserRandomRepository {



    public LiveData<RandomUsers> getUsers(){
        final MutableLiveData<RandomUsers> randomUsers = new MutableLiveData<>();
        return randomUsers;

    }
}
