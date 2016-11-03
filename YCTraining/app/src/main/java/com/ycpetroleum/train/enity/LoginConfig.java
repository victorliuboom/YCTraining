package com.ycpetroleum.train.enity;

/**
 * 创建人：${刘泽旻}
 * 创建时间：2016/9/6 17:26
 * 修改备注：全局数据类
 */
public class LoginConfig {
    private String username;// 用户名
    private String password;// 密码
    private String userid;// 用户id
    private String realname;// 真实姓名
    private String nickname;// 昵称
    private String sex;// 性别
    private String useravatar;// 用户头像
    private boolean isUpdata;// 是否需要更新
    private boolean isRemember;// 是否记住密码
    private boolean isAutoLogin;// 是否自动登录
    private boolean isNovisible;// 是否隐藏登录
    private boolean isExit;// 是否退出登录

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUseravatar() {
        return useravatar;
    }

    public void setUseravatar(String useravatar) {
        this.useravatar = useravatar;
    }

    public boolean isUpdata() {
        return isUpdata;
    }

    public void setIsUpdata(boolean isUpdata) {
        this.isUpdata = isUpdata;
    }

    public boolean isRemember() {
        return isRemember;
    }

    public void setIsRemember(boolean isRemember) {
        this.isRemember = isRemember;
    }

    public boolean isAutoLogin() {
        return isAutoLogin;
    }

    public void setIsAutoLogin(boolean isAutoLogin) {
        this.isAutoLogin = isAutoLogin;
    }

    public boolean isNovisible() {
        return isNovisible;
    }

    public void setIsNovisible(boolean isNovisible) {
        this.isNovisible = isNovisible;
    }

    public boolean isExit() {
        return isExit;
    }

    public void setIsExit(boolean isExit) {
        this.isExit = isExit;
    }
}
