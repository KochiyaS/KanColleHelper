package com.kochiyasanae.kancollehelper;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
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
import android.widget.Toast;

import com.kochiyasanae.kancollehelper.Database.MyDatabaseHelper;
import com.kochiyasanae.kancollehelper.Fragment.UpgrateFragment.*;
import com.kochiyasanae.kancollehelper.GuanyuShezhiActivity.GuanyugengxinActivity;
import com.kochiyasanae.kancollehelper.GuanyuShezhiActivity.XuanxiangshezhiActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private MyDatabaseHelper dbhelper;
    public static int databasevesion=3;
    static int NewAPPVesion=3;
    public FragmentAdapter mFragmentAdapteradapter;
    private List<Fragment> fragment = null;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);


//数据库建立
        dbhelper=new MyDatabaseHelper(this,"GaixiuDB",null,databasevesion);
        SQLiteDatabase db= dbhelper.getWritableDatabase();
        db.close();



        SharedPreferences sharedPreferences = this.getSharedPreferences("APP", MODE_PRIVATE);
        int APPVersion = sharedPreferences.getInt("APPVersion",1);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (APPVersion!=NewAPPVesion)
        {
            Intent intent0 = new Intent();
            intent0.setClass(MainActivity.this,HuanyingActivity.class);
            startActivity(intent0);

            editor.putInt("APPVersion", NewAPPVesion);
            editor.commit();
            Log.d("debug", "第一次运行");

        } else {


            Log.d("debug", "不是第一次运行");



        }



        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_main_drawer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.activity_title1);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
        ab.setHomeAsUpIndicator(R.mipmap.ic_menu_white_24dp);
        ab.setDisplayHomeAsUpEnabled(true);}

        NavigationView navigationView =
                (NavigationView) findViewById(R.id.nv_main_navigation);

        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(MenuItem menuItem) {
                            switch (menuItem.getItemId()) {
                                case R.id.nav_gaixiu:


                                   break;
                                case R.id.nav_yuanzheng:
                                    Intent intent4 = new Intent();
                                    intent4.setClass(MainActivity.this, YuanzhengActivity.class);
                                    startActivity(intent4);
                                    finish();
                                    break;




                                case R.id.nav_setting:
                                    Intent intent7 = new Intent();
                                    intent7.setClass(MainActivity.this, XuanxiangshezhiActivity.class);
                                    startActivity(intent7);
                                    break;

                                case R.id.nav_update:
                                    Intent intent8 = new Intent();
                                    intent8.setClass(MainActivity.this, GuanyugengxinActivity.class);
                                    startActivity(intent8);
                                    break;
                            }


                            mDrawerLayout.closeDrawers();
                            return true;
                        }
                    });
        }
        initViewPager();
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



