package examples.omar.mx.android_mvvm_architecture.di.module;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import examples.omar.mx.android_mvvm_architecture.Repository.UserRandomRepository;
import examples.omar.mx.android_mvvm_architecture.api.RandomUsersApi;
import examples.omar.mx.android_mvvm_architecture.di.scope.RandomUserScope;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module(includes = OkHttpClientModule.class)
public class RandomUserModule {

    private final String BASE_URL= "https://randomuser.me";

    @Provides
    UserRandomRepository getUserRepository(RandomUsersApi api){
        return new UserRandomRepository(api);
    }

    @Provides
    public RandomUsersApi getRandomUserApi(Retrofit retrofit){
        return retrofit.create(RandomUsersApi.class);
    }

    @RandomUserScope
    @Provides
    public Retrofit getRetrofit(OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    @Provides
    public GsonConverterFactory getGsonConvertFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }

    @Provides
    public Gson getGson(){
        return new GsonBuilder().create();
    }
}
