package examples.omar.mx.android_mvvm_architecture;

import android.app.Activity;
import android.app.Application;

import examples.omar.mx.android_mvvm_architecture.di.component.DaggerUserRamdomComponent;
import examples.omar.mx.android_mvvm_architecture.di.component.MainActivityComponent;
import examples.omar.mx.android_mvvm_architecture.di.component.UserRamdomComponent;
import examples.omar.mx.android_mvvm_architecture.di.module.ContextModule;

public class App extends Application{

    UserRamdomComponent component;

    public static App get(Activity activity){
        return (App)activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerUserRamdomComponent.builder().contextModule(new ContextModule(this)).build();
    }

    public UserRamdomComponent getComponent() {
        return component;
    }
}
