package com.ycpetroleum.train.Pager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by linhonghong on 2015/8/10.
 */
public class APSTSViewPager extends ViewPager {
    private boolean mNoFocus = true; //if true, keep View don't move

    public APSTSViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public APSTSViewPager(Context context){
        this(context,null);
    }

    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (mNoFocus) {
            return false;
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (mNoFocus)
            return false;
        else
            return super.onTouchEvent(ev);
    }

    public void setNoFocus(boolean b){
        mNoFocus = b;
    }
}