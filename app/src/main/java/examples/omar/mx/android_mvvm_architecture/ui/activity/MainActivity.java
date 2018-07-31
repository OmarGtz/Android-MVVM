package examples.omar.mx.android_mvvm_architecture.ui.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.File;

import javax.inject.Inject;

import examples.omar.mx.android_mvvm_architecture.App;
import examples.omar.mx.android_mvvm_architecture.R;
import examples.omar.mx.android_mvvm_architecture.di.component.DaggerMainActivityComponent;
import examples.omar.mx.android_mvvm_architecture.di.component.MainActivityComponent;
import examples.omar.mx.android_mvvm_architecture.di.component.UserRamdomComponent;
import examples.omar.mx.android_mvvm_architecture.di.module.ContextModule;
import examples.omar.mx.android_mvvm_architecture.di.module.MainActivityModule;
import examples.omar.mx.android_mvvm_architecture.ui.adapter.RandomUserAdapter;
import examples.omar.mx.android_mvvm_architecture.api.RandomUsersApi;
import examples.omar.mx.android_mvvm_architecture.model.RandomUsers;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Inject
    RandomUserAdapter mAdapter;
    @Inject
    RandomUsersApi api;

    private MainActivityComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        component = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .userRamdomComponent(App.get(this).getComponent())
                .build();
        component.injectMainActivity(this);
        populateUsers();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private void populateUsers() {
        Call<RandomUsers> randomUsersCall = getRandomUserService().getRandomUsers();
        randomUsersCall.enqueue(new Callback<RandomUsers>() {
            @Override
            public void onResponse(Call<RandomUsers> call, @NonNull Response<RandomUsers> response) {
                if(response.isSuccessful()) {
                    mAdapter.setItems(response.body().getResults());
                    recyclerView.setAdapter(mAdapter);
                }
            }

            @Override
            public void onFailure(Call<RandomUsers> call, Throwable t) {
                Timber.i(t.getMessage());
            }
        });
    }

    public RandomUsersApi getRandomUserService(){
        return api;
    }


}
