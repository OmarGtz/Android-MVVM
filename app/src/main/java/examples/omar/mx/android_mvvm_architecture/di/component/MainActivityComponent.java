package examples.omar.mx.android_mvvm_architecture.di.component;


import dagger.Component;
import examples.omar.mx.android_mvvm_architecture.di.module.MainActivityModule;
import examples.omar.mx.android_mvvm_architecture.di.module.UserViewModelModule;
import examples.omar.mx.android_mvvm_architecture.di.scope.MainActivityScope;
import examples.omar.mx.android_mvvm_architecture.ui.activity.MainActivity;

@Component(modules =  {MainActivityModule.class},dependencies = UserRamdomComponent.class)
@MainActivityScope
public interface MainActivityComponent {
   void injectMainActivity(MainActivity mainActivity);
}
