package com.ycpetroleum.train.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.ycpetroleum.train.Pager.APSTSViewPager;
import com.ycpetroleum.train.Pager.AdvancedPagerSlidingTabStrip;
import com.ycpetroleum.train.R;
import com.ycpetroleum.train.application.YCTApplication;
import com.ycpetroleum.train.fragment.CourseFragment;
import com.ycpetroleum.train.fragment.ExaminationFragment;
import com.ycpetroleum.train.fragment.MainFragment;
import com.ycpetroleum.train.fragment.PersonalFragment;

import lib.lhh.fiv.library.FrescoImageView;

/***
 * 主界面
 */

public class MyMainActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    public AdvancedPagerSlidingTabStrip mAPSTS;
    public APSTSViewPager mVP;

    private static final int VIEW_FIRST 		= 0;
    private static final int VIEW_SECOND	    = 1;
    private static final int VIEW_THIRD       = 2;
    private static final int VIEW_FOURTH    = 3;

    private static final int VIEW_SIZE = 4;

    private MainFragment mMainFragment = null;
    private CourseFragment mCourseFragment = null;
    private ExaminationFragment mExaminationFragment = null;
    private PersonalFragment mPersonalFragment = null;
    private YCTApplication yctApplication;
    @Override
    protected int getResourcesId() {
        return R.layout.activity_my_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

        yctApplication= (YCTApplication) getApplication();
        yctApplication.addActivity(this);
        findViews();

        mVP.setOffscreenPageLimit(VIEW_SIZE);
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        mVP.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        adapter.notifyDataSetChanged();
        mAPSTS.setViewPager(mVP);
        mAPSTS.setOnPageChangeListener(this);
        mVP.setCurrentItem(VIEW_FIRST);
      //  mAPSTS.showDot(VIEW_FIRST, "99+");
    }
    private void findViews(){
        mAPSTS = (AdvancedPagerSlidingTabStrip)findViewById(R.id.tabs);
        mVP = (APSTSViewPager)findViewById(R.id.vp_main);
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    public class FragmentAdapter extends FragmentStatePagerAdapter implements AdvancedPagerSlidingTabStrip.ViewTabProvider{

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position >= 0 && position < VIEW_SIZE){
                switch (position){
                    case  VIEW_FIRST:
                        if(null == mMainFragment)
                            mMainFragment = mMainFragment.instance();
                        return mMainFragment;

                    case VIEW_SECOND:
                        if(null == mCourseFragment)
                            mCourseFragment = mCourseFragment.instance();
                        return mCourseFragment;

                    case VIEW_THIRD:
                        if(null == mExaminationFragment)
                            mExaminationFragment = mExaminationFragment.instance();
                        return mExaminationFragment;

                    case VIEW_FOURTH:
                        if(null == mPersonalFragment)
                            mPersonalFragment = mPersonalFragment.instance();
                        return mPersonalFragment;
                    default:
                        break;
                }
            }
            return null;
        }

        @Override
        public int getCount() {
            return VIEW_SIZE;
        }

        @Override
        public View onSelectIconView(int position, View view, ViewGroup parent) {
            FrescoImageView draweeView;
            if(view == null){
                draweeView = new FrescoImageView(MyMainActivity.this);
                draweeView.setLayoutParams(new RelativeLayout.LayoutParams(80,80));
                view = draweeView;
            }
            draweeView = (FrescoImageView)view;
            switch (position){
                case  VIEW_FIRST:
                    draweeView.setBackgroundResource(R.mipmap.categry_icon_p);
                    break;
                case  VIEW_SECOND:
                    draweeView.setBackgroundResource(R.mipmap.classify_icon_p);
                    break;
                case  VIEW_THIRD:
                    draweeView.setBackgroundResource(R.mipmap.mine_icon_p);
                    break;
                case  VIEW_FOURTH:
                    draweeView.setBackgroundResource(R.mipmap.update_dynamic_p);
                    break;
                default:
                    break;
            }
            return draweeView;
        }

        @Override
        public View onIconView(int position, View view, ViewGroup parent) {
            FrescoImageView draweeView;
            if(view == null){
                draweeView = new FrescoImageView(MyMainActivity.this);
                draweeView.setLayoutParams(new RelativeLayout.LayoutParams(80,80));
                view = draweeView;
            }
            draweeView = (FrescoImageView)view;
            switch (position){
                case  VIEW_FIRST:
                    draweeView.setBackgroundResource(R.mipmap.categry_icon_n);
                    break;
                case  VIEW_SECOND:
                    draweeView.setBackgroundResource(R.mipmap.classify_icon_n);
                    break;
                case  VIEW_THIRD:
                    draweeView.setBackgroundResource(R.mipmap.mine_icon_n);
                    break;
                case  VIEW_FOURTH:
                    draweeView.setBackgroundResource(R.mipmap.update_dynamic_n);
                    break;
                default:
                    break;
            }
            return draweeView;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position >= 0 && position < VIEW_SIZE){
                switch (position){
                    case  VIEW_FIRST:
                        return  getString(R.string.shouye);
                    case  VIEW_SECOND:
                        return  getString(R.string.kecheng);
                    case  VIEW_THIRD:
                        return  getString(R.string.kaoshi);
                    case  VIEW_FOURTH:
                        return  getString(R.string.wode);
                    default:
                        break;
                }
            }
            return null;
        }

    }
}
