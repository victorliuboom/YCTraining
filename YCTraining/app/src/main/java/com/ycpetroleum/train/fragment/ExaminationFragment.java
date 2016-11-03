package com.ycpetroleum.train.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.ycpetroleum.train.R;

public class ExaminationFragment extends ParentFragment {

    public static ExaminationFragment instance() {
        ExaminationFragment view = new ExaminationFragment();
        return view;
    }

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_examination;
    }

    @Override
    protected void onFirstUserVisible() {

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

    }

}
