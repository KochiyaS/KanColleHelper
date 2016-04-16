package com.kochiyasanae.kancollehelper.Fragment.GuanyuShezhiFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v4.app.FragmentActivity;

import com.kochiyasanae.kancollehelper.GuanyuShezhiActivity.XuanxiangshezhiActivity;
import com.kochiyasanae.kancollehelper.MainActivity;
import com.kochiyasanae.kancollehelper.R;

/**
 * Created by KochiyaSanae on 2016/4/13.
 */
public class XuanxiangshezhiFragment extends PreferenceFragment {




        @Override
        public void onCreate(Bundle savedInstanceState){

            super.onCreate(savedInstanceState);


            addPreferencesFromResource(R.xml.xuanxiangshezhi);

            findPreference("chuannei_switch").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(final Preference preference, final Object newValue) {
                    restartActivity();
                    return true;
                }
            });




        }

    public void restartActivity()
    {

        Intent intent = new Intent();
        intent.setClass(getActivity(), XuanxiangshezhiActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("activity", null); //要传递的数据
        intent.putExtras(bundle);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        getActivity().finish();

    }

}
