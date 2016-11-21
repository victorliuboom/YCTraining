package com.ycpetroleum.train.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ListView;

import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;
import com.ycpetroleum.train.R;
import com.ycpetroleum.train.enity.BodyReactBean;
import com.ycpetroleum.train.util.FastJsonTools;
import com.ycpetroleum.train.util.OKHttpUtils;
import com.ycpetroleum.train.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


public class MainFragment extends ParentFragment implements SwipyRefreshLayout.OnRefreshListener {
    @Bind(R.id.swipyrefreshlayout)SwipyRefreshLayout swipyRefreshLayout;
    @Bind(R.id.mListview)ListView listView;
    private int page=1;
    private int index =0;
    private int top =0;
    private boolean is_refresh = true;
    List<BodyReactBean.ObjBean.ListBean> lists = new ArrayList<>();
    public static MainFragment instance() {
        MainFragment view = new MainFragment();
        return view;
    }
    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_main;
    }

    @Override
    protected void onFirstUserVisible() {
//        Uri uri = Uri.parse("market://details?id=" + "com.youlian.dgj.activity");
//        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
//        try {
//            startActivity(goToMarket);
//        } catch (ActivityNotFoundException e) {
//            Toast.makeText(getActivity(), "Couldn't launch the market !", Toast.LENGTH_SHORT).show();
//        }
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
        ListTask   listTask = new ListTask();
        listTask.execute();
    }

    @Override
    public void onRefresh(SwipyRefreshLayoutDirection direction) {
        if(direction==SwipyRefreshLayoutDirection.TOP){
            ListTask   listTask = new ListTask();
            listTask.execute();
        }else if(direction==SwipyRefreshLayoutDirection.BOTTOM){
            ListTask   listTask = new ListTask();
            listTask.execute();
        }
    }
    private  class ListTask extends AsyncTask<Void,Void,BodyReactBean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (page==1){
                showLoadDialog();
            }
        }

        @Override
        protected BodyReactBean doInBackground(Void... voids) {
            String body="";
            Log.e("111==","===");
            try {
                Log.e("2222==","===");
                body= OKHttpUtils.okHttpPost("userid","13060393903","token","03d41117123b47f08117c8cbdaaecf2c",
                        "socketcode","edcfa004-ff8d-49e7-8055-20c0f84b277e", "currentPage",page+"", "rows","10", "type","0",
                        "http://manage.dgjgw.cn/app/socketController.do?getInduceList",getActivity());
                Log.e("333==","===");
                Log.e(TAG, body);
                if (lists.size()!=0&&is_refresh){
                    lists.clear();
                }
                if (FastJsonTools.getBean(body,BodyReactBean.class)!=null&&
                        FastJsonTools.getBean(body,BodyReactBean.class).getObj()!=null &&
                        FastJsonTools.getBean(body,BodyReactBean.class).getObj().getList()!=null){
                    lists.addAll(FastJsonTools.getBean(body,BodyReactBean.class).getObj().getList());
                }

                Log.e(TAG,body);
            } catch (Exception e) {
                e.printStackTrace();
                OKHttpUtils.httpException(e,getActivity());
                return null;
            }
            return FastJsonTools.getBean(body, BodyReactBean.class);
        }

        @Override
        protected void onPostExecute(BodyReactBean batteryWeekChartyBean) {
            super.onPostExecute(batteryWeekChartyBean);
            dismissDialog();
            if (batteryWeekChartyBean!=null){
                if (!batteryWeekChartyBean.isSuccess()){
                    ToastUtils.showToast(mContext, batteryWeekChartyBean.getMsg());
                    return;
                }
                if (batteryWeekChartyBean.getObj().getCount()==0){
                    return;
                }

                if (batteryWeekChartyBean.getObj().getList()==null||batteryWeekChartyBean.getObj().getList().size()==0){
                    Log.e(TAG,"loadover");
                 //   lv_load_more.loadMoreFinish(false, false);
                }else {
//                    Log.e(TAG,"loadmore");
//                    adapter = new BodyReactionAdapter(mContext,lists);
//                    lv_time.setAdapter(adapter);
//                    lv_time.setSelectionFromTop(index,top);
//                    lv_load_more.loadMoreFinish(false, true);
//                    adapter.notifyDataSetChanged();
                }
                /**flag==1是已通知*/

            }
        }

    }
}
