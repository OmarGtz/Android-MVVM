package examples.omar.mx.android_mvvm_architecture.di.component;

import com.squareup.picasso.Picasso;

import dagger.Component;
import examples.omar.mx.android_mvvm_architecture.api.RandomUsersApi;

@Component
public interface UserRamdomComponent {

    RandomUsersApi getUserRandomApi();
    Picasso getPicasso();
}
