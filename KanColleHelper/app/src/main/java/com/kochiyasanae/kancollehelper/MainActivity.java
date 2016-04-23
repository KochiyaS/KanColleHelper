package com.kochiyasanae.kancollehelper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kochiyasanae.kancollehelper.Database.MyDatabaseHelper;
import com.kochiyasanae.kancollehelper.Fragment.GaixiuFragment.*;
import com.kochiyasanae.kancollehelper.GuanyuShezhiActivity.GuanyugengxinActivity;
import com.kochiyasanae.kancollehelper.GuanyuShezhiActivity.XuanxiangshezhiActivity;
import com.kochiyasanae.kancollehelper.Unit.UpdateChecker;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private MyDatabaseHelper dbhelper;
    public static int databasevesion=24;
    static int NewAPPVesion=24;
    public static final String APP_UPDATE_SERVER_URL = "https://raw.githubusercontent.com/KochiyaS/KancolleHelperUpdate/master/UpdateInformation.json";
    public static final boolean APK_IS_AUTO_INSTALL = false;


    public FragmentAdapter mFragmentAdapteradapter;
    private List<Fragment> fragment = null;






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


//数据库建立







        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_main_drawer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle(R.string.activity_title1);
        }
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
        ab.setHomeAsUpIndicator(R.mipmap.ic_menu_white_24dp);
        ab.setDisplayHomeAsUpEnabled(true);}

        NavigationView navigationView =
                (NavigationView) findViewById(R.id.nv_main_navigation);

        View headerView = navigationView.getHeaderView(0);
        final int touxiang = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(this).getString("touxiang_list", "1"));
        ImageView mImageView = (ImageView) headerView.findViewById(R.id.kancollehelper);
        TextView mTextView = (TextView) headerView.findViewById(R.id.kancollehelper1);
        switch (touxiang){
            case 1:
                assert mImageView != null;
                mImageView.setImageResource(R.mipmap.touxiang_dachao_gaier);
                assert mTextView != null;
                mTextView.setText(R.string.wenhou_dachao_gaier);
                break;
            case 2:
                assert mImageView != null;
                mImageView.setImageResource(R.mipmap.touxiang_xia_gaier);
                assert mTextView != null;
                mTextView.setText(R.string.wenhou_xia_gaier);
                break;
            case 3:
                assert mImageView != null;
                mImageView.setImageResource(R.mipmap.touxiang_xiao_gaier);
                assert mTextView != null;
                mTextView.setText(R.string.wenhou_xiao_gaier);
                break;
            case 4:
                assert mImageView != null;
                mImageView.setImageResource(R.mipmap.touxiang_xiang_gaier);
                assert mTextView != null;
                mTextView.setText(R.string.wenhou_xiang_gaier);
                break;

        }

        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(MenuItem menuItem) {

                            mDrawerLayout.closeDrawers();

                            switch (menuItem.getItemId()) {
                                case R.id.nav_gaixiu:


                                    break;

                                case R.id.nav_renwu:
                                    Intent intent3 = new Intent();
                                    intent3.setClass(MainActivity.this, RenwuActivity.class);
                                    startActivity(intent3);
                                    overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                                    finish();
                                    break;

                                case R.id.nav_yuanzheng:
                                    Intent intent4 = new Intent();
                                    intent4.setClass(MainActivity.this, YuanzhengActivity.class);
                                    startActivity(intent4);
                                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                                    finish();
                                    break;


                                case R.id.nav_setting:
                                    Intent intent7 = new Intent();
                                    intent7.setClass(MainActivity.this, XuanxiangshezhiActivity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("activity",getString(R.string.activity_title1)); //要传递的数据
                                    intent7.putExtras(bundle);
                                    startActivity(intent7);
                                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                                    finish();


                                    break;

                                case R.id.nav_update:
                                    Intent intent8 = new Intent();
                                    intent8.setClass(MainActivity.this, GuanyugengxinActivity.class);
                                    startActivity(intent8);
                                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                                    break;
                            }


                            return true;
                        }
                    });
        }

        SharedPreferences sharedPreferences = this.getSharedPreferences("APP", MODE_PRIVATE);
        int APPVersion = sharedPreferences.getInt("APPVersion", 1);
        if (APPVersion!=NewAPPVesion)
        {
            dbhelper=new MyDatabaseHelper(this,"GaixiuDB",null,databasevesion);
            SQLiteDatabase db= dbhelper.getWritableDatabase();
            db.close();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("APPVersion", NewAPPVesion);
            editor.commit();

            Intent intent0 = new Intent();
            intent0.setClass(MainActivity.this,HuanyingActivity.class);
            startActivity(intent0);

            Log.d("debug", "第一次运行");

        } else {

            Log.d("debug", "不是第一次运行");
            boolean gengxinmode= PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getBoolean("gengxin_switch", true);

            if(isWifi(MainActivity.this)&&gengxinmode){
                UpdateChecker.checkForDialog(MainActivity.this, MainActivity.APP_UPDATE_SERVER_URL, MainActivity.APK_IS_AUTO_INSTALL);}

        }

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            public void run() {
                initViewPager();




            }
        };
        handler.post(runnable);

      }


    public static boolean isWifi(Context mContext) {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null
                && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return true;
        }
        return false;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_sousuo:
                Toast.makeText(this, "搜索功能同友军舰队一样暂未实装！",Toast.LENGTH_LONG).show();

                return true;



        }
        return super.onOptionsItemSelected(item);


    }



    private void initViewPager() {
        mTabLayout = (TabLayout) findViewById(R.id.tabs);

        List<String> titles = new ArrayList<>();
        titles.add("明石的今日推荐");
        titles.add("夕张的深夜精选");
        titles.add("小口径主炮");
        titles.add("中口径主炮");
        titles.add("大口径主炮");
        titles.add("副炮");
        titles.add("鱼雷");
        titles.add("水上飞机");
        titles.add("电探/雷达");
        titles.add("对潜装备");
        titles.add("对空装备");
        titles.add("对舰装备");
        titles.add("对陆装备");
        titles.add("夜战装备");

        for(int i=0;i<titles.size();i++){
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
        }

        fragment = new ArrayList<>();
        fragment.add(new GaixiuMingshiFragment());
        fragment.add(new GaixiuXizhangFragment());
        fragment.add(new GaixiuXiaozhupaoFragment());
        fragment.add(new GaixiuZhongzhupaoFragment());
        fragment.add(new GaixiuDazhupaoFragment());
        fragment.add(new GaixiuFupaoFragment());
        fragment.add(new GaixiuYuleiFragment());
        fragment.add(new GaixiuShuishangfeijiFragment());
        fragment.add(new GaixiuDiantanleidaFragment());
        fragment.add(new GaixiuDuiqianzhuangbeiFragment());
        fragment.add(new GaixiuDuikongzhuangbeiFragment());
        fragment.add(new GaixiuDuijianzhuangbeiFragment());
        fragment.add(new GaixiuDuiluzhuangbeiFragment());
        fragment.add(new GaixiuYezhanzhuangbeiFragment());

        mFragmentAdapteradapter =
                new FragmentAdapter(getSupportFragmentManager(), fragment, titles);

        mFragmentAdapteradapter.setOnReloadListener(new FragmentAdapter.OnReloadListener()
        {
            @Override
            public void onReload()
            {
                fragment = null;
                List<Fragment> list = new ArrayList<Fragment>();
                list.add( new GaixiuMingshiFragment());
                list.add( new GaixiuXizhangFragment());
                list.add( new GaixiuXiaozhupaoFragment());
                list.add( new GaixiuZhongzhupaoFragment());
                list.add( new GaixiuDazhupaoFragment());
                list.add( new GaixiuFupaoFragment());
                list.add( new GaixiuYuleiFragment());
                list.add( new GaixiuShuishangfeijiFragment());
                list.add( new GaixiuDiantanleidaFragment());
                list.add( new GaixiuDuiqianzhuangbeiFragment());
                list.add( new GaixiuDuikongzhuangbeiFragment());
                list.add( new GaixiuDuijianzhuangbeiFragment());
                list.add( new GaixiuDuiluzhuangbeiFragment());
                list.add( new GaixiuYezhanzhuangbeiFragment());
                mFragmentAdapteradapter.setPagerItems(list);
            }
        });



        //给ViewPager设置适配器

        mViewPager.setAdapter(mFragmentAdapteradapter);
        //将TabLayout和ViewPager关联起来。
        mTabLayout.setupWithViewPager(mViewPager);
        //给TabLayout设置适配器
        mTabLayout.setTabsFromPagerAdapter(mFragmentAdapteradapter);

        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //给fragment设置最大缓存数量
        mViewPager.setOffscreenPageLimit(1);
    }

    public FragmentAdapter getAdapter()
    {
        return mFragmentAdapteradapter;
    }



}



