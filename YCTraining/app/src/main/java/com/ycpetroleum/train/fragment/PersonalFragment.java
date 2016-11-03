package com.ycpetroleum.train.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.ycpetroleum.train.R;


public class PersonalFragment extends ParentFragment {
    public static PersonalFragment instance() {
        PersonalFragment view = new PersonalFragment();
        return view;
    }

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_personal;
    }

    @Override
    protected void onFirstUserVisible() {
        Log.e("2", "2");
    }

    @Override
    protected void onUserInvisible() {

    }

    @Override
    protected void onFirstUserInvisble() {

    }

    @Override
    protected void onUserVisble() {

    }

    @Override
    protected void init(Bundle savedInstanceState) {
        Log.e("1", "1");
    }
}
