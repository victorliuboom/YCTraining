package com.ycpetroleum.train.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Window;

import com.ycpetroleum.train.R;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    public String TAG ;
    public Context mContext;
    private ProgressDialog loadDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(getResourcesId());

        mContext = getApplicationContext();
        ButterKnife.bind(this);
        TAG = getRunningActivityName();
        init(savedInstanceState);
    }
    protected abstract int getResourcesId();
    protected abstract void init(Bundle savedInstanceState);
    private String getRunningActivityName(){
        String contextString = this.toString();
        return contextString.substring(contextString.lastIndexOf(".")+1, contextString.indexOf("@"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismissDialog();
        loadDialog=null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    public void showLoadDialog(String message){
        if (loadDialog==null){
            loadDialog=ProgressDialog.show(this, "", message);
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


    /**
     * 设置返回键事件
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            finish();
            overridePendingTransition(R.anim.from_left_to_right_in,
                    R.anim.from_left_to_right_out);
        }
        return super.onKeyUp(keyCode, event);
    }
}
