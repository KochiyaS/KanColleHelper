package com.kochiyasanae.kancollehelper.Fragment.GuanyuShezhiFragment;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v4.app.FragmentActivity;

import com.kochiyasanae.kancollehelper.MainActivity;
import com.kochiyasanae.kancollehelper.R;
import com.kochiyasanae.kancollehelper.Unit.UpdateChecker;

/**
 * Created by KochiyaSanae on 2016/4/13.
 */
public class GuanyugengxinFragment extends PreferenceFragment{

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);


        addPreferencesFromResource(R.xml.guanyugengxin);

        findPreference("gengxin").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {

                UpdateChecker.checkForDialog((FragmentActivity) getActivity(), MainActivity.APP_UPDATE_SERVER_URL, MainActivity.APK_IS_AUTO_INSTALL);

                return true;
            }
        });


    }



}
