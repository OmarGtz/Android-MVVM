package examples.omar.mx.android_mvvm_architecture.ui.fragment;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import examples.omar.mx.android_mvvm_architecture.R;
import examples.omar.mx.android_mvvm_architecture.model.RandomUsers;
import examples.omar.mx.android_mvvm_architecture.viewmodel.UserRandomViewModel;

public class UserProfileFragment extends Fragment {

    UserRandomViewModel userRandomViewModel;
    public static String UID_KEY = "uid";

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String userId = getArguments().getString(UID_KEY);
        //userRandomViewModel = ViewModelProviders.of(this).get(UserRandomViewModel.class);

        //userRandomViewModel.init("u1");
        //userRandomViewModel.getRandomUsers().observe(this, new Observer<RandomUsers>() {
          //  @Override
          //  public void onChanged(@Nullable RandomUsers randomUsers) {

            //}
        //});

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_profile, container, false);
    }

}
