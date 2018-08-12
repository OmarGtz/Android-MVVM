package examples.omar.mx.android_mvvm_architecture.Repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import javax.inject.Inject;

import examples.omar.mx.android_mvvm_architecture.App;
import examples.omar.mx.android_mvvm_architecture.api.RandomUsersApi;
import examples.omar.mx.android_mvvm_architecture.model.RandomUsers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRandomRepository {

    RandomUsersApi api;

    @Inject
    public UserRandomRepository(RandomUsersApi api) {
        this.api = api;
    }

    public LiveData<RandomUsers> getUsers(){
        final MutableLiveData<RandomUsers> randomUsers = new MutableLiveData<>();
        api.getRandomUsers().enqueue(new Callback<RandomUsers>() {
            @Override
            public void onResponse(Call<RandomUsers> call, Response<RandomUsers> response) {
                randomUsers.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RandomUsers> call, Throwable t) {

            }
        });
        return randomUsers;
    }
}
