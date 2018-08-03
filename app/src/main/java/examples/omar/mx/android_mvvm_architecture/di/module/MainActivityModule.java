package examples.omar.mx.android_mvvm_architecture.di.module;

import android.arch.lifecycle.ViewModelProviders;

import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import examples.omar.mx.android_mvvm_architecture.di.scope.MainActivityScope;
import examples.omar.mx.android_mvvm_architecture.ui.activity.MainActivity;
import examples.omar.mx.android_mvvm_architecture.ui.adapter.RandomUserAdapter;
import examples.omar.mx.android_mvvm_architecture.viewmodel.UserRandomViewModel;

@Module

public class MainActivityModule {

    private MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @MainActivityScope
    @Provides
    UserRandomViewModel viewModel(){
        

        return ViewModelProviders.of(mainActivity).get(UserRandomViewModel.class);
    }

    @MainActivityScope
    @Provides
    RandomUserAdapter getUserAdapter(Picasso picasso){
        return new RandomUserAdapter(picasso,mainActivity);
    }
}
