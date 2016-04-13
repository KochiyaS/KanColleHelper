package com.kochiyasanae.kancollehelper.Fragment.GuanyuShezhiFragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.kochiyasanae.kancollehelper.R;

/**
 * Created by KochiyaSanae on 2016/4/13.
 */
public class GuanyugengxinFragment extends PreferenceFragment{

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);


        addPreferencesFromResource(R.xml.guanyugengxin);


    }



}
