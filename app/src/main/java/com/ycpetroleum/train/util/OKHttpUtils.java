package com.ycpetroleum.train.util;

import android.app.Activity;
import android.util.Log;

import com.ycpetroleum.train.R;
import com.ycpetroleum.train.application.YCTApplication;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLSocketFactory;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @Auth 刘泽旻
 * @Date 16/2/8
 * @Time 下午9:23
 */
public class OKHttpUtils {
    public static final MediaType JSON = MediaType
            .parse("application/json; charset=utf-8");

    public static String doHttps(String header, String token, String json,
                                 SSLSocketFactory sslSocketFactory, String url) throws IOException {
        String body = "";
        OkHttpClient okHttpClient = null;
        okHttpClient = new OkHttpClient.Builder().sslSocketFactory(
                sslSocketFactory).build();
        // okHttpClient.setSslSocketFactory(sslSocketFactory);
        RequestBody formBody = FormBody.create(JSON, json);
        Request request = new Request.Builder().url(url)
                .addHeader(header, token).post(formBody).build();
        Response response = okHttpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            body = response.body().string();
            response.body().close();
        } else {
            throw new IOException("Unexpected code " + response);
        }
        return body;
    }

    /***
     * public static String okHttpPost(String str1, String str2, String str3,
     * String str4, String url, Activity context) throws IOException { String
     * body = ""; RequestBody formBody = new FormBody.Builder().add(str1, str2)
     * .add(str3, str4).build(); Request request = new
     * Request.Builder().url(url).post(formBody).build(); Response response =
     * DGJApplication.getInstance().okHttpClient.newCall( request).execute(); if
     * (response.isSuccessful()) { body = response.body().string(); } else {
     * errorCode(response, context); } return body; }
     */
    public static String doheader(String header, String token, String json,
                                  String uls, Activity activity) throws IOException {
        String body = "";
        RequestBody formBody = RequestBody.create(JSON, json);
        Request request = new Request.Builder().addHeader(header, token).addHeader("Connection", "close").addHeader("Content-Length", "0").url(uls)
                .post(formBody).build();
        Response response = YCTApplication.getInstance().okHttpClient.newCall(
                request).execute();
        if (response.isSuccessful()) {
            body = response.body().string();
            response.body().close();
        } else {
            errorCode(response, activity);
        }
        return body;
    }

    public static String okHttpJson(String header, String token, String json,
                                    String uls, Activity activity) throws IOException {
        String body = "";
        RequestBody formBody = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(uls).header("Connection", "close")
                .header(header, token).post(formBody).build();
        Response response = YCTApplication.getInstance().okHttpClient.newCall(
                request).execute();
        if (response.isSuccessful()) {
            body = response.body().string();
        } else {
            errorCode(response, activity);
        }
        return body;
    }

    public static String doJson(String str1, String json, String uls,
                                Activity activity) throws IOException {
        String body = "";
        RequestBody formBody = new FormBody.Builder().add(str1, json).build();
        Request request = new Request.Builder().url(uls).post(formBody).build();
        Response response = YCTApplication.getInstance().okHttpClient.newBuilder().connectTimeout(30, TimeUnit.SECONDS).build().newCall(
                request).execute();
        if (response.isSuccessful()) {
            body = response.body().string();
        } else {
            errorCode(response, activity);
        }
        return body;
    }

    public static String doJson(String str1, String json, String token, String tokee, String uls,
                                Activity activity) throws IOException {
        String body = "";
        RequestBody formBody = new FormBody.Builder().add(str1, json).add(token, tokee).build();
        Request request = new Request.Builder().url(uls).post(formBody).build();
        Response response = YCTApplication.getInstance().okHttpClient.newBuilder().connectTimeout(30, TimeUnit.SECONDS).build().newCall(
                request).execute();
        if (response.isSuccessful()) {
            body = response.body().string();
        } else {
            errorCode(response, activity);
        }
        return body;
    }

    public static String okUpHttpJson(String header, String token, String json,
                                      String uls, Activity activity) throws IOException {
        String body = "";
        RequestBody formBody = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(uls)
                .addHeader(header, token).post(formBody).build();
        Response response = YCTApplication.getInstance().okHttpClient.newCall(
                request).execute();
        if (response.isSuccessful()) {
            body = response.body().string();
        } else {
            errorCode(response, activity);
        }
        return body;
    }

    public static String dojsonheader(String header, String token, String json,
                                      SSLSocketFactory sslSocketFactory, String url) throws IOException {
        String body = "";
        OkHttpClient okHttpClient = null;
        okHttpClient = new OkHttpClient.Builder().sslSocketFactory(
                sslSocketFactory).build();
        RequestBody formBody = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url)
                .addHeader(header, token).addHeader("Connection", "close").post(formBody).build();
        Response response = okHttpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            body = response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
        return body;
    }

    public static String okHttpget(String url, Activity context)
            throws IOException {
        System.out.println("url = " + url);
        String body = "";
        Request request = new Request.Builder().url(url).build();
        Response response = YCTApplication.getInstance().okHttpClient.newCall(
                request).execute();
        if (response.isSuccessful()) {
            body = response.body().string();
        } else {
            errorCode(response, context);
        }
        return body;
    }

    public static String okHttpPost(String str1, String str2, String url,
                                    Activity context) throws IOException {
        String body = "";
        RequestBody formBody = null;
        hasToken(context, str1, str2, url);
        formBody = new FormBody.Builder().add(str1, str2).build();
        Request request = new Request.Builder().url(url).post(formBody).build();
        Response response = YCTApplication.getInstance().okHttpClient.newCall(
                request).execute();
        if (response.isSuccessful()) {
            body = response.body().string();
        } else {
            errorCode(response, context);
        }
        return body;
    }

    public static String okHttpPost(String str1, String str2, String str3,
                                    String str4, String url, Activity context) throws IOException {
        Log.e("11","111");
        String body = "";
        RequestBody formBody = null;
        hasToken(context, str1, str2, str3, str4, url);
        formBody = new FormBody.Builder().add(str1, str2)
                .add(str3, str4).build();
        Log.e("222","222");
        Request request = new Request.Builder().url(url).post(formBody).build();
        Log.e("333","333");
        Response response = YCTApplication.getInstance().okHttpClient.newCall(
                request).execute();
        Log.e("444","444");
        if (response.isSuccessful()) {
            body = response.body().string();
        } else {
            errorCode(response, context);
        }
        return body;
    }

    public static String okHttpPost(String str1, String str2, String str3,
                                    String str4, String str5, String str6, String url, Activity context)
            throws IOException {
        String body = "";
        RequestBody formBody = null;
        hasToken(context, str1, str2, str3, str4, str5, str6, url);
        formBody = new FormBody.Builder().add(str1, str2)
                .add(str3, str4).add(str5, str6).build();
        Request request = new Request.Builder().url(url).post(formBody).build();
        Response response = YCTApplication.getInstance().okHttpClient.newCall(
                request).execute();
        if (response.isSuccessful()) {
            body = response.body().string();
        } else {
            errorCode(response, context);
        }
        return body;
    }

    public static String okHttpPost(String str1, String str2, String str3,
                                    String str4, String str5, String str6, String str7, String str8,
                                    String url, Activity context) throws IOException {
        String body = "";
        RequestBody formBody = null;
        hasToken(context, str1, str2, str3, str4, str5, str6, str7, str8, url);
        formBody = new FormBody.Builder().add(str1, str2)
                .add(str3, str4).add(str5, str6).add(str7, str8).build();
        Request request = new Request.Builder().url(url).post(formBody).build();
        Response response = YCTApplication.getInstance().okHttpClient.newCall(
                request).execute();
        if (response.isSuccessful()) {
            body = response.body().string();
            ToastUtils.Log_e("OKHttpUtils", "body ：" + body);
        } else {
            errorCode(response, context);
        }
        return body;
    }

    public static String okHttpPost(String str1, String str2, String str3,
                                    String str4, String str5, String str6, String str7, String str8,
                                    String str9, String str10, String url, Activity context)
            throws IOException {
        String body = "";
        RequestBody formBody = null;
        hasToken(context, str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, url);
        formBody = new FormBody.Builder().add(str1, str2)
                .add(str3, str4).add(str5, str6).add(str7, str8).add(str9, str10).build();
        Request request = new Request.Builder().addHeader("Connection", "close").addHeader("Content-Length", "0").url(url).post(formBody).build();
        Response response = YCTApplication.getInstance().okHttpClient.newCall(
                request).execute();
        if (response.isSuccessful()) {
            body = response.body().string();
            response.body().close();
        } else {
            errorCode(response, context);
        }
        return body;
    }





    public static String okHttpPost(String string, String app_token,
                                    String string2, String cellid, String string3, String id,
                                    String string4, String taypid, String string5, String string6,
                                    String string7, String string8, String string9, String roomid,
                                    String string10, String tupianid, String string11, String content,
                                    String url, Activity context) throws IOException {
        String body = "";
        RequestBody formBody = null;
        hasToken(context, string, app_token, string2, cellid, string3, id, string4, taypid, string5, string6, string7, string8, string9, roomid, string10, tupianid, string11, content, url);
        formBody = new FormBody.Builder().add(string, app_token)
                .add(string2, cellid).add(string3, id).add(string4, taypid)
                .add(string5, string6).add(string7, string8)
                .add(string9, roomid).add(string10, tupianid)
                .add(string11, content).build();
        Request request = new Request.Builder().url(url).post(formBody).build();
        Response response = YCTApplication.getInstance().okHttpClient.newCall(
                request).execute();
        if (response.isSuccessful()) {
            body = response.body().string();
        } else {
            errorCode(response, context);
        }
        return body;
    }

    public static String okHttpPost(String string, String app_token,
                                    String string2, String cellid, String string3, String id,
                                    String string4, String taypid, String string5, String string6,
                                    String string7, String string8, String string9, String roomid,
                                    String string10, String tupianid,
                                    String url, Activity context) throws IOException {
        String body = "";
        RequestBody formBody = null;
        hasToken(context, string, app_token, string2, cellid, string3, id, string4, taypid, string5, string6, string7, string8, string9, roomid, string10, tupianid, url);
        formBody = new FormBody.Builder().add(string, app_token)
                .add(string2, cellid).add(string3, id).add(string4, taypid)
                .add(string5, string6).add(string7, string8)
                .add(string9, roomid).add(string10, tupianid)
                .build();
        Request request = new Request.Builder().url(url).post(formBody).build();
        Response response = YCTApplication.getInstance().okHttpClient.newCall(
                request).execute();
        if (response.isSuccessful()) {
            body = response.body().string();
        } else {
            errorCode(response, context);
        }
        return body;
    }
    public static String okHttpPost(String str1, String str2, String str3,
                                    String str4, String str5, String str6, String str7, String str8,
                                    String str9, String str10, String str11, String str12, String url,
                                    Activity context) throws IOException {
        Log.e("---1","----1");
        String body = "";
        RequestBody formBody = null;

        if (str1.equals("token") || str3.equals("token") || str5.equals("token") || str7.equals("token") || str9.equals("token") || str11.equals("token")) {
            Log.e("---2","----2");
            hasToken(context, str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, url);
            formBody = new FormBody.Builder().add(str1, str2).add(str3, str4).add(str5, str6).add(str7, str8)
                    .add(str9, str10).add(str11, str12).build();
        } else {
            Log.e("---3","----3");
            formBody = new FormBody.Builder().add("token", "03d41117123b47f08117c8cbdaaecf2c").add(str1, str2).add(str3, str4).add(str5, str6).add(str7, str8)
                    .add(str9, str10).add(str11, str12).build();
        }
        Log.e("---4","----4");
        Request request = new Request.Builder().url(url).post(formBody).build();
        Log.e("---5","----5");
        Response response = YCTApplication.getInstance().okHttpClient.newCall(
                request).execute();
        Log.e("---6","----6");
        if (response.isSuccessful()) {
            body = response.body().string();
            Log.e("---7","----7");
        } else {
            Log.e("---8","----8");
            errorCode(response, context);
        }
        return body;
    }
    public static void errorCode(Response response, final Activity context)
            throws IOException {
        ToastUtils.Log_e("OKHttpUtils", "response.code() ：" + response.code());
        switch (response.code()) {
            case 404:
                if (context != null) {

                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ToastUtils.showToast(context,
                                    R.string.message_server_unavailable);
                        }
                    });
                }
                break;
            case 500:
                if (context != null) {
                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ToastUtils.showToast(context,
                                    R.string.unrecoverable_error);
                        }
                    });
                }
                break;
            case 1111:
                /** 单点登录, */
                if (context != null) {
                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ((YCTApplication) context.getApplication())
                                    .kickUser(context);
                        }
                    });
                }
                break;
            default:
                throw new IOException("Unexpected code " + response);
        }
    }

    public static void httpException(Exception e, final Activity activity) {
        if (e instanceof UnknownHostException) {
            Log.e("UnknownHostException", e.getStackTrace() + "");
            if (activity != null) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtils.showToast(activity,
                                R.string.message_server_unavailable);
                    }
                });
            }

        } else if (e instanceof ConnectException) {
            Log.e("ConnectException", e.getStackTrace() + "");
            if (activity != null) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtils
                                .showToast(activity, R.string.request_outtime);
                    }
                });
            }

        } else if (e instanceof SocketTimeoutException) {
            Log.e("SocketTimeoutException", e.getStackTrace() + "");
            if (activity != null) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtils.showToast(activity,
                                R.string.socket_exception_error);
                    }
                });
            }

        } else if (e instanceof SocketException) {
            Log.e("SocketException", e.getStackTrace() + "");
            if (activity != null) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtils.showToast(activity,
                                R.string.socket_exception);
                    }
                });
            }

        } else if (e instanceof IOException) {
            Log.e("IOException", e.getStackTrace() + "");
        } else {
            Log.e("Exception", e.getStackTrace() + "");
        }
    }
    /***
     * 检测接口是否传入token
     **/
    public static boolean hasToken(Activity context, String... value) {
//        boolean isToken = false;
//        for (int i = 0; i < value.length - 1; i++) {
//            if (i % 2 == 0 && i + 1 < value.length - 1) {
//                if (value[i].equals("token")) {
//                    isToken = true;
//                } else {
//                }
//                ToastUtils.Log_e("hasToken方法" + i, value[i] + " = " + value[i + 1]);
//            }
//        }
//        ToastUtils.Log_e("hasToken方法", isToken + " , url：" + value[value.length - 1]);
        return true;
    }
}
