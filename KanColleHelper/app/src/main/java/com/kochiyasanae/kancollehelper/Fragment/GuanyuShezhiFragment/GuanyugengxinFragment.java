package com.kochiyasanae.kancollehelper.Fragment.GuanyuShezhiFragment;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v4.app.FragmentActivity;

import com.kochiyasanae.kancollehelper.R;
import com.kochiyasanae.kancollehelper.Unit.UpdateChecker;

/**
 * Created by KochiyaSanae on 2016/4/13.
 */
public class GuanyugengxinFragment extends PreferenceFragment{

    protected static final String APP_UPDATE_SERVER_URL = "https://raw.githubusercontent.com/KochiyaS/KancolleHelperUpdate/master/UpdateInformation.json";
    private static final boolean APK_IS_AUTO_INSTALL = false;


    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);


        addPreferencesFromResource(R.xml.guanyugengxin);

        findPreference("gengxin").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {

                UpdateChecker.checkForDialog((FragmentActivity) getActivity(), APP_UPDATE_SERVER_URL, APK_IS_AUTO_INSTALL);




                return false;
            }
        });


    }



}
