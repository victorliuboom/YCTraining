package com.ycpetroleum.train.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 *
 *
 * @auther Mr Jobs
 * @date 2015/5/17
 * @time 14:37
 */
public abstract class ParentFragment extends Fragment {
    protected Context mContext;
    private final String className = getClass().getName();
    protected final String TAG = className.substring(className.lastIndexOf(".") + 1, className.length());
    private boolean isPrepared;
    private boolean isFirstResume = true;
    private boolean isFirstVisible = true;
    private boolean isFirstInvisible = true;
    public int index =0;
    public int top = 0;
    private ProgressDialog loadDialog;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity.getApplicationContext();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    protected abstract int setLayout(LayoutInflater inflater);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mMainView = inflater.inflate(setLayout(inflater), container, false);
        ButterKnife.bind(this, mMainView);
        init(savedInstanceState);
        return mMainView;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initprepare();
    }
    @Override
    public void onPause() {
        super.onPause();
        if (getUserVisibleHint()) {
            onUserInvisible();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isFirstResume) {
            isFirstResume = false;
            return;
        }
        if (getUserVisibleHint()) {
            onUserVisble();
        }
    }

    public synchronized  void initprepare() {
        if (isPrepared){
            onFirstUserVisible();
        }else
            isPrepared = true;
    }

    protected abstract void onFirstUserVisible();


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            if (isFirstVisible){
                isFirstVisible = false;
                initprepare();
            }else
                onUserVisble();
        }else {
            if (isFirstInvisible){
                isFirstInvisible = false;
                onFirstUserInvisble();
            }else
                onUserInvisible();
        }
    }

    protected abstract void onUserInvisible();

    protected abstract void onFirstUserInvisble();

    protected abstract void onUserVisble();


    protected abstract void init(Bundle savedInstanceState);

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dismissDialog();
        loadDialog=null;

    }

    public void showLoadDialog(String message){
        if (loadDialog==null){
            loadDialog= ProgressDialog.show(getActivity(), "", message);
        } else if (!loadDialog.isShowing()){
            loadDialog.show();
        }
    }

    public void showLoadDialog(){
       showLoadDialog("加载中");
    }
    public void dismissDialog(){
        if (loadDialog!=null&&loadDialog.isShowing()){
            loadDialog.dismiss();
        }
    }
}