package com.kochiyasanae.kancollehelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.kochiyasanae.kancollehelper.Database.MyDatabaseHelper;

import com.kochiyasanae.kancollehelper.Fragment.YuanzhengFragment.*;
import com.kochiyasanae.kancollehelper.GuanyuShezhiActivity.GuanyugengxinActivity;
import com.kochiyasanae.kancollehelper.GuanyuShezhiActivity.XuanxiangshezhiActivity;

import java.util.ArrayList;
import java.util.List;

public class YuanzhengActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private MyDatabaseHelper dbhelper;

    public FragmentAdapter mFragmentAdapteradapter;
    private List<Fragment> fragment = null;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_yuanzheng);
    mViewPager = (ViewPager) findViewById(R.id.viewpager);
    mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_main_drawer);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    toolbar.setTitle(R.string.activity_title2);
    setSupportActionBar(toolbar);

    final ActionBar ab = getSupportActionBar();
        if (ab != null){
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

                                Intent intent1 = new Intent();
                                intent1.setClass(YuanzhengActivity.this,MainActivity.class);
                                startActivity(intent1);
                                finish();
                                break;

                            case R.id.nav_yuanzheng:
                                break;



                            case R.id.nav_setting:
                                Intent intent7 = new Intent();
                                intent7.setClass(YuanzhengActivity.this, XuanxiangshezhiActivity.class);
                                startActivity(intent7);
                                break;

                            case R.id.nav_update:
                                Intent intent8 = new Intent();
                                intent8.setClass(YuanzhengActivity.this, GuanyugengxinActivity.class);
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
                Toast.makeText(this, "搜索功能同友军舰队一样暂未实装！", Toast.LENGTH_LONG).show();

                return true;


        }
        return super.onOptionsItemSelected(item);


    }




    private void initViewPager() {
        mTabLayout = (TabLayout) findViewById(R.id.tabs);

        List<String> titles = new ArrayList<>();
        titles.add("镇守府海域");
        titles.add("南西诸岛海域");
        titles.add("北方海域");
        titles.add("西方海域");
        titles.add("南方海域");
//        titles.add("中部海域");
//        titles.add("皋月的24小时远征规划");
//       titles.add("Z1的大型舰建造计划");

        for(int i=0;i<titles.size();i++){
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
        }

        fragment = new ArrayList<>();
        fragment.add(new YuanzhengZhenshoufuhaiyuFragment());
        fragment.add(new YuanzhengNanxizhudaohaiyuFragment());
        fragment.add(new YuanzhengBeifanghaiyuFragment());
        fragment.add(new YuanzhengXifanghaiyuFragment());
        fragment.add(new YuanzhengNanfanghaiyuFragment());
//        fragment.add(new YuanzhengZhongbuhaiyuFragment());
//        fragment.add(new YuanzhengGaoyueFragment());
//        fragment.add(new YuanzhengZ1Fragment());


        mFragmentAdapteradapter =
                new FragmentAdapter(getSupportFragmentManager(), fragment, titles);

        mFragmentAdapteradapter.setOnReloadListener(new FragmentAdapter.OnReloadListener()
        {
            @Override
            public void onReload()
            {
                fragment = null;
                List<Fragment> list = new ArrayList<Fragment>();
                list.add(new YuanzhengZhenshoufuhaiyuFragment());
                list.add(new YuanzhengNanxizhudaohaiyuFragment());
                list.add(new YuanzhengBeifanghaiyuFragment());
                list.add(new YuanzhengXifanghaiyuFragment());
                list.add(new YuanzhengNanfanghaiyuFragment());
//                list.add(new YuanzhengZhongbuhaiyuFragment());
//                list.add(new YuanzhengGaoyueFragment());
//                list.add(new YuanzhengZ1Fragment());

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
