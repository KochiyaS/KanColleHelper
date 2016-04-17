package com.kochiyasanae.kancollehelper.GuanyuShezhiActivity;



import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.kochiyasanae.kancollehelper.Fragment.GuanyuShezhiFragment.GuanyugengxinFragment;
import com.kochiyasanae.kancollehelper.R;

/**
 * Created by KochiyaSanae on 2016/4/13.
 */
public class GuanyugengxinActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final boolean nightmode= PreferenceManager.getDefaultSharedPreferences(this).getBoolean("chuannei_switch",false);
        final int zhuti = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(this).getString("zhuti_list", "1"));

        if (nightmode) {
            setTheme(R.style.AppTheme_Dark);
        }
        else{

            switch (zhuti){
                case 1:
                    setTheme(R.style.AppTheme_Light);
                    break;
                case 2:
                    setTheme(R.style.mingshifen);
                    break;
                case 3:
                    setTheme(R.style.xizhanglv);
                    break;
                case 4:
                    setTheme(R.style.gaoyuehuang);
                    break;
                case 5:
                    setTheme(R.style.dadianlan);
                    break;


            }


        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guanyugengxin);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.activity_title8);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);

            ab.setHomeButtonEnabled(true);
            ab.setHomeAsUpIndicator(R.mipmap.ic_arrow_back_white_24dp);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });


            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            GuanyugengxinFragment prefFragment = new GuanyugengxinFragment();
            transaction.add(R.id.fragment, prefFragment);
            transaction.commit();



}

    @Override
    public void onBackPressed(){

        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

    }



}






