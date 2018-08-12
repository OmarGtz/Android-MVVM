package examples.omar.mx.android_mvvm_architecture.viewmodel.factory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import examples.omar.mx.android_mvvm_architecture.Repository.UserRandomRepository;
import examples.omar.mx.android_mvvm_architecture.viewmodel.UserRandomViewModel;

public class UserViewModelFactory implements ViewModelProvider.Factory {

    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> creators;

    @Inject
    public UserViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> creator) {
        this.creators = creator;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        Provider<? extends ViewModel> creator = creators.get(modelClass);
        if(creator==null){
            for (Map.Entry<Class<? extends ViewModel>,Provider<ViewModel>> entry: creators.entrySet()){
                if(modelClass.isAssignableFrom(entry.getKey())){
                    creator = entry.getValue();
                    break;
                }
            }
        }
        try {
            return (T)creator.get();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}