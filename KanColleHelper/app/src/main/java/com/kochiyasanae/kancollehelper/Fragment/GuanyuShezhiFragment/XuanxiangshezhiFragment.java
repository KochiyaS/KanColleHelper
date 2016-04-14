package com.kochiyasanae.kancollehelper.Fragment.GuanyuShezhiFragment;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v4.app.FragmentActivity;

import com.kochiyasanae.kancollehelper.R;

/**
 * Created by KochiyaSanae on 2016/4/13.
 */
public class XuanxiangshezhiFragment extends PreferenceFragment {




        @Override
        public void onCreate(Bundle savedInstanceState){

            super.onCreate(savedInstanceState);


            addPreferencesFromResource(R.xml.xuanxiangshezhi);




        }
}
