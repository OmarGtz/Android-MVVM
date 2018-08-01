package examples.omar.mx.android_mvvm_architecture.di.component;

import com.squareup.picasso.Picasso;

import dagger.Component;
import examples.omar.mx.android_mvvm_architecture.api.RandomUsersApi;
import examples.omar.mx.android_mvvm_architecture.di.module.PicassoModule;
import examples.omar.mx.android_mvvm_architecture.di.module.RandomUserModule;
import examples.omar.mx.android_mvvm_architecture.di.scope.RandomUserScope;

@RandomUserScope
@Component(modules = {RandomUserModule.class,PicassoModule.class})
public interface UserRamdomComponent {


    void inject();

}
