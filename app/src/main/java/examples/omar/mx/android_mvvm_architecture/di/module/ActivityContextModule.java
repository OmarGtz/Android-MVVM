package examples.omar.mx.android_mvvm_architecture.di.module;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import examples.omar.mx.android_mvvm_architecture.di.scope.RandomUserScope;

@Module
public class ActivityContextModule {

    private Context context;

    public ActivityContextModule(Context context) {
        this.context = context;
    }

    @Named("Activity_Context")
    @RandomUserScope
    @Provides
    public Context getActivityContext(){
        return context;
    }
}
