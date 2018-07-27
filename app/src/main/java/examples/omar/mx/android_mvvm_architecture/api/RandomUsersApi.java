package examples.omar.mx.android_mvvm_architecture.api;


import examples.omar.mx.android_mvvm_architecture.model.RandomUsers;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Hari on 20/11/17.
 */

public interface RandomUsersApi {

    @GET("api/")
    Call<RandomUsers> getRandomUsers(@Query("results") int results);
}