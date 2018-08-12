package examples.omar.mx.android_mvvm_architecture.di.module;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import examples.omar.mx.android_mvvm_architecture.ui.activity.MainActivity;
import examples.omar.mx.android_mvvm_architecture.viewmodel.UserRandomViewModel;
import examples.omar.mx.android_mvvm_architecture.viewmodel.factory.UserViewModelFactory;

@Module
public class UserViewModelModule {
    private MainActivity mainActivity;
    public UserViewModelModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    UserRandomViewModel getUserViewModel(UserViewModelFactory factory){
        return ViewModelProviders.of(mainActivity, factory).get(UserRandomViewModel.class);
        }
}