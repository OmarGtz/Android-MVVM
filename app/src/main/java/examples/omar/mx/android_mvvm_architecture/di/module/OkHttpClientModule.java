package examples.omar.mx.android_mvvm_architecture.di.module;

import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Module
public class OkHttpClientModule {


    @Provides
    public OkHttpClient getHttpClient(Cache cache, HttpLoggingInterceptor loggingInterceptor){
        return new OkHttpClient().newBuilder()
                .cache(cache)
                .addInterceptor(loggingInterceptor)
                .build();
    }

    public HttpLoggingInterceptor getHttpLoggingInterceptor(){

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {

            }
        });

        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }

    public Cache getCache(File file){

        return new Cache(file,10*100*100);
    }

    public File file(Context context){
       File file = new File(context.getCacheDir(),"SimiCache");
       file.mkdirs();
       return file;
    }
}
