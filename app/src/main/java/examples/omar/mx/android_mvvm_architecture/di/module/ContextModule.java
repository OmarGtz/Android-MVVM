package examples.omar.mx.android_mvvm_architecture.di.module;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import examples.omar.mx.android_mvvm_architecture.di.scope.RandomUserScope;

@Module
public class ContextModule {

    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Named("App_context")
    @RandomUserScope
    @Provides
    public Context getContextApp() {
        return context.getApplicationContext();
    }
}
