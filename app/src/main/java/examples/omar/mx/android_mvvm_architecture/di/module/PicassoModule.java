package examples.omar.mx.android_mvvm_architecture.di.module;

import android.app.Application;
import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module(includes = OkHttpClientModule.class)
public class PicassoModule {

    @Provides
    public Picasso getPicasso(@Named("App_context") Context context, OkHttp3Downloader okHttp3Downloader){
        return new Picasso.Builder(context).downloader(okHttp3Downloader).build();
    }

    @Provides
    public OkHttp3Downloader getOkhttpDownloader(OkHttpClient okHttpClient){
        return new OkHttp3Downloader(okHttpClient);
    }
}