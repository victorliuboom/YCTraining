package com.ycpetroleum.train.application;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.ycpetroleum.train.R;
import com.ycpetroleum.train.enity.Constant;
import com.ycpetroleum.train.enity.LoginConfig;

import java.util.LinkedList;
import java.util.List;

import okhttp3.OkHttpClient;

/**
 * 创建人：${刘泽旻}
 * 创建时间：2016/9/6 17:23
 * 修改备注：
 */
public class YCTApplication extends Application{
    private static Context context;
    private static YCTApplication app;
    private static YCTApplication instance;
    public final String PREF_USERNAME = "username";
    private LoginConfig loginConfig;
    private SharedPreferences preferences;
    private List<Activity> activityList = new LinkedList<Activity>();
    public OkHttpClient okHttpClient = new OkHttpClient();
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        app=this;
        instance=this;
        preferences = getSharedPreferences(Constant.LOGIN_SET, 0);
        loginConfig=getLoginConfig();
        saveLoginConfig(loginConfig);
        ImagePipelineConfig frescoConfig = OkHttpImagePipelineConfigFactory
                .newBuilder(this, new com.squareup.okhttp.OkHttpClient())
                .build();
        Fresco.initialize(this, frescoConfig);
    }
    /**
     * 获取登录信息
     * */
    public  LoginConfig getLoginConfig(){
        if(loginConfig==null){
            loginConfig=new LoginConfig();
        }
        loginConfig.setUsername(preferences.getString(Constant.USERNAME, ""));
        loginConfig.setPassword(preferences.getString(Constant.PASSWORD, ""));
        loginConfig.setNickname(preferences.getString(Constant.NICKNAME, ""));
        loginConfig.setRealname(preferences.getString(Constant.REALNAME, ""));
        loginConfig.setSex(preferences.getString(Constant.SEX, "0"));
        loginConfig.setUserid(preferences.getString(Constant.USERID, ""));
        loginConfig.setUseravatar(preferences.getString(Constant.USERAVATAR, ""));
        loginConfig.setIsUpdata(preferences.getBoolean(Constant.IS_UPDATA,
                getResources().getBoolean(R.bool.is_updata)));
        loginConfig.setIsAutoLogin(preferences.getBoolean(Constant.IS_AUTOLOGIN,
                getResources().getBoolean(R.bool.is_autologin)));
        loginConfig.setIsNovisible(preferences.getBoolean(Constant.IS_NOVISIBLE,
                getResources().getBoolean(R.bool.is_novisible)));
        loginConfig.setIsRemember(preferences.getBoolean(Constant.IS_REMEMBER,
                getResources().getBoolean(R.bool.is_remember)));
        loginConfig.setIsExit(preferences.getBoolean(Constant.IS_EXIT, false));
        return loginConfig;
    }
    public void saveLoginConfig(LoginConfig loginConfig) {

        preferences.edit()
                .putString(Constant.PASSWORD, loginConfig.getPassword())
                .commit();
        preferences.edit()
                .putString(Constant.USERNAME, loginConfig.getUsername())
                .commit();
        preferences.edit().putString(Constant.USERID, loginConfig.getUserid())
                .commit();
        preferences.edit()
                .putString(Constant.NICKNAME, loginConfig.getNickname())
                .commit();
        preferences.edit()
                .putString(Constant.REALNAME, loginConfig.getRealname())
                .commit();
        preferences.edit().putString(Constant.SEX, loginConfig.getSex())
                .commit();
        preferences.edit()
                .putString(Constant.USERAVATAR, loginConfig.getUseravatar())
                .commit();
        preferences.edit()
                .putBoolean(Constant.IS_UPDATA, loginConfig.isUpdata())
                .commit();
        preferences.edit()
                .putBoolean(Constant.IS_AUTOLOGIN, loginConfig.isAutoLogin())
                .commit();
        preferences.edit()
                .putBoolean(Constant.IS_NOVISIBLE, loginConfig.isNovisible())
                .commit();
        preferences.edit()
                .putBoolean(Constant.IS_REMEMBER, loginConfig.isRemember())
                .commit();
        preferences.edit().putBoolean(Constant.IS_EXIT, loginConfig.isExit())
                .commit();

    }
    public void clearLoginConfig(LoginConfig loginConfig) {
        loginConfig.setPassword("");
        loginConfig.setIsAutoLogin(false);
        loginConfig.setNickname("");
        loginConfig.setRealname("");
        loginConfig.setSex("");
        loginConfig.setIsRemember(false);
        loginConfig.setIsExit(true);
        loginConfig.setUseravatar("");
        loginConfig.setUserid("");
        loginConfig.setIsUpdata(false);
        saveLoginConfig(loginConfig);
    }
    public static YCTApplication getInstance() {
        return instance;
    }
    // 添加Activity到容器中
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }
    /**
     * 单点登录踢出用户
     */

    public void kickUser(final Context context) {
        final AlertDialog dlg = new AlertDialog.Builder(this).create();
        dlg.show();
        dlg.setCanceledOnTouchOutside(false);
        dlg.setOnKeyListener(new DialogInterface.OnKeyListener() {

            @Override
            public boolean onKey(DialogInterface arg0, int keyCode,
                                 KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        Window window = dlg.getWindow();
        window.setContentView(R.layout.blend_dialog_preview_layout);
        TextView cancel = (TextView) window
                .findViewById(R.id.blend_dialog_cancle_btn);
        TextView relogin = (TextView) window
                .findViewById(R.id.blend_dialog_relogin);
        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                dlg.dismiss();
                clearLoginConfig(loginConfig);
                exit();
                System.exit(0);
            }
        });
        relogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                dlg.dismiss();
                clearLoginConfig(loginConfig);
                exit();
                Intent i = new Intent();
           //     i.setClass(context, Login.class);
                i.putExtra("Activity", "MyMainActivity");
                startActivity(i);
                ((Activity) context).overridePendingTransition(
                        R.anim.silde_up_in, R.anim.silde_up_out);
            }
        });
    }
    public void exit() {
        for (Activity activity : activityList) {
            System.out.print("退出" + activity + "\n");
            activity.finish();
        }
    }
}
