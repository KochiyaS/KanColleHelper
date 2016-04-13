package com.kochiyasanae.kancollehelper;

/**
 * Created by KochiyaSanae on 2016/3/11.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragments;
    private List<String> mTitles;
    private FragmentManager fm;

    private OnReloadListener mListener;


    public FragmentAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
        super(fm);
        this.fragments = fragments;
        this.mTitles = titles;
        this.fm = fm;

    }


    //* 重新设置页面内容
    //* @param items
   // */
    public void setPagerItems(List<Fragment> items)
    {
        if (items != null) {
            for (int i = 0; i < fragments.size(); i++)
            {
                fm.beginTransaction().remove(fragments.get(i)).commit();
            }
            fragments = items;
        }
    }






    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    //显示tab上的名字
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }


    @Override
    public int getItemPosition(Object object)
    {
        return POSITION_NONE;
    }
    public void reLoad()
    {
        if(mListener != null)
        {
            mListener.onReload();
        }
        this.notifyDataSetChanged();
    }
    public void setOnReloadListener(OnReloadListener listener)
    {
        this.mListener = listener;
    }
    /**
     * @author Rowand jj
     *回调接口
     */
    public interface OnReloadListener
    {
        public void onReload();
    }


}





