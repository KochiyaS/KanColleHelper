package com.kochiyasanae.kancollehelper.GuanyuShezhiActivity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.kochiyasanae.kancollehelper.Fragment.GuanyuShezhiFragment.XuanxiangshezhiFragment;
import com.kochiyasanae.kancollehelper.HuanyingActivity;
import com.kochiyasanae.kancollehelper.MainActivity;
import com.kochiyasanae.kancollehelper.R;
import com.kochiyasanae.kancollehelper.RenwuActivity;
import com.kochiyasanae.kancollehelper.YuanzhengActivity;

/**
 * Created by KochiyaSanae on 2016/4/14.
 */
public class XuanxiangshezhiActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        final boolean nightmode= PreferenceManager.getDefaultSharedPreferences(this).getBoolean("chuannei_switch",false);
        final int zhuti = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(this).getString("zhuti_list","1"));

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

        String activity = this.getIntent().getExtras().getString("activity");
        if (activity != null) {

            SharedPreferences sharedPreferences = this.getSharedPreferences("ACTIVITY", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("ACTIVITY", activity);
                editor.commit();

        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle(R.string.activity_title7);
        }
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);

            ab.setHomeButtonEnabled(true);
            ab.setHomeAsUpIndicator(R.mipmap.ic_arrow_back_white_24dp);
        }
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onBackPressed();

                }
            });
        }


        if (savedInstanceState == null) {
            XuanxiangshezhiFragment fragment = new XuanxiangshezhiFragment();

            getFragmentManager().beginTransaction().replace(R.id.fragment,
                    fragment).commit();}

    }

    @Override
    public void onBackPressed(){
        SharedPreferences sharedPreferences = this.getSharedPreferences("ACTIVITY", MODE_PRIVATE);
        String activity1 = sharedPreferences.getString("ACTIVITY", "改修");


            switch (activity1) {

                case "改修":
                    Intent intent1 = new Intent();
                    intent1.setClass(XuanxiangshezhiActivity.this, MainActivity.class);
                    startActivity(intent1);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                    break;

                case "任务":
                    Intent intent3 = new Intent();
                    intent3.setClass(XuanxiangshezhiActivity.this, RenwuActivity.class);
                    startActivity(intent3);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                    break;

                case "远征":
                    Intent intent4 = new Intent();
                    intent4.setClass(XuanxiangshezhiActivity.this, YuanzhengActivity.class);
                    startActivity(intent4);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                    break;


                }

    }


}