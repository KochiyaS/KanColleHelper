package com.kochiyasanae.kancollehelper;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.kochiyasanae.kancollehelper.Database.MyDatabaseHelper;


public class YuanzhengxinxiActivity extends AppCompatActivity {
    private MyDatabaseHelper dbhelper;

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


        setContentView(R.layout.activity_yuanzhengxinxi);


        String mdata = this.getIntent().getExtras().getString("mdata");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle(R.string.activity_title41);
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


        final String sqlyuanzhengxinxi = "select bianhao,haiyu,mingcheng,nandu,haoshi2,haoshi3,xiaohaoran1,xiaohaodan1,tidujingyan,jianniangjingyan,shouyiran,shouyidan,shouyigang,shouyilv,jiangli11,jiangli12,jiangli21,jiangli22,qijiandengji,hejidengji,yuanzhengyaoqiu,yuanzhengbeizhu,xiaohaoran2,xiaohaoran3,xiaohaodan2,xiaohaodan3 from yuanzheng where mingcheng = ? ";

        dbhelper = new MyDatabaseHelper(this, "GaixiuDB", null, MainActivity.databasevesion);
        final SQLiteDatabase db = dbhelper.getReadableDatabase();
        Cursor c = db.rawQuery(sqlyuanzhengxinxi, new String[]{mdata});
        String yuanzhengbianhao = null;
        String yuanzhenghaiyu = null;
        String yuanzhengmingcheng = null;
        String yuanzhengnandu = null;
        String yuanzhengshijian = null;
        String yuanzhengxiaohaoran = null;
        String yuanzhengxiaohaodan = null;
        String yuanzhengtidujingyan = null;
        String yuanzhengjianniangjingyan = null;
        Integer yuanzhengran = null;
        Integer yuanzhengdan = null;
        Integer yuanzhenggang = null;
        Integer yuanzhenglv = null;
        String yuanzhengjiangli11 = null;
        Integer yuanzhengjiangli12 = null;
        String yuanzhengjiangli21 = null;
        Integer yuanzhengjiangli22 = null;

        String qijiandengji = null;
        String hejidengji = null;
        String yuanzhengpeizhi = null;
        String yuanzhengbeizhu = null;

        Integer haoshi3 = null;
        Integer xiaohaoran2 = null;
        Integer xiaohaoran3 = null;
        Integer xiaohaodan2 = null;
        Integer xiaohaodan3 = null;

        while (c.moveToNext()) {
            yuanzhengbianhao = c.getString(c.getColumnIndex("bianhao"));
            yuanzhenghaiyu = c.getString(c.getColumnIndex("haiyu"));
            yuanzhengmingcheng = c.getString(c.getColumnIndex("mingcheng"));
            yuanzhengnandu = c.getString(c.getColumnIndex("nandu"));
            yuanzhengshijian = c.getString(c.getColumnIndex("haoshi2"));
            haoshi3=c.getInt(c.getColumnIndex("haoshi3"));
            yuanzhengxiaohaoran = c.getString(c.getColumnIndex("xiaohaoran1"));
            yuanzhengxiaohaodan = c.getString(c.getColumnIndex("xiaohaodan1"));
            yuanzhengtidujingyan = c.getString(c.getColumnIndex("tidujingyan"));
            yuanzhengjianniangjingyan = c.getString(c.getColumnIndex("jianniangjingyan"));

            yuanzhengran = c.getInt(c.getColumnIndex("shouyiran"));
            yuanzhengdan = c.getInt(c.getColumnIndex("shouyidan"));
            yuanzhenggang = c.getInt(c.getColumnIndex("shouyigang"));
            yuanzhenglv = c.getInt(c.getColumnIndex("shouyilv"));


            yuanzhengjiangli11 = c.getString(c.getColumnIndex("jiangli11"));
            yuanzhengjiangli12 = c.getInt(c.getColumnIndex("jiangli12"));
            yuanzhengjiangli21 = c.getString(c.getColumnIndex("jiangli21"));
            yuanzhengjiangli22 = c.getInt(c.getColumnIndex("jiangli22"));

            qijiandengji = c.getString(c.getColumnIndex("qijiandengji"));
            hejidengji = c.getString(c.getColumnIndex("hejidengji"));
            yuanzhengpeizhi =c .getString(c.getColumnIndex("yuanzhengyaoqiu"));
            yuanzhengbeizhu = c.getString(c.getColumnIndex("yuanzhengbeizhu"));


            xiaohaoran2=c.getInt(c.getColumnIndex("xiaohaoran2"));
            xiaohaoran3=c.getInt(c.getColumnIndex("xiaohaoran3"));
            xiaohaodan2=c.getInt(c.getColumnIndex("xiaohaodan2"));
            xiaohaodan3=c.getInt(c.getColumnIndex("xiaohaodan3"));

        }
        c.close();
        db.close();

        TextView yuanzhengmingcheng1 = (TextView) findViewById(R.id.yuanzhengmingcheng);
        yuanzhengmingcheng1.setText(yuanzhengmingcheng);

        TextView yuanzhengbianhao1 = (TextView) findViewById(R.id.yuanzhengbianhao);
        yuanzhengbianhao1.setText(yuanzhengbianhao);

        TextView yuanzhenghaiyu1 = (TextView) findViewById(R.id.yuanzhenghaiyu);
        yuanzhenghaiyu1.setText(yuanzhenghaiyu);

        TextView yuanzhengxiaohaoran1 = (TextView) findViewById(R.id.xiaohaoran);
        yuanzhengxiaohaoran1.setText(yuanzhengxiaohaoran);

        TextView yuanzhengxiaohaodan1 = (TextView) findViewById(R.id.xiaohaodan);
        yuanzhengxiaohaodan1.setText(yuanzhengxiaohaodan);

        TextView yuanzhengshijian1 = (TextView) findViewById(R.id.xiaohaoshijian);
        yuanzhengshijian1.setText(yuanzhengshijian);

        TextView yuanzhengtidujingyan1 = (TextView) findViewById(R.id.tidujingyan);
        yuanzhengtidujingyan1.setText(yuanzhengtidujingyan);

        TextView jianniangjingyan1 = (TextView) findViewById(R.id.jianniangjingyan);
        jianniangjingyan1.setText(yuanzhengjianniangjingyan);

        TextView yuanzhengran1 = (TextView) findViewById(R.id.yuanzhengran);
        yuanzhengran1.setText("×" + yuanzhengran);

        TextView yuanzhengdan1 = (TextView) findViewById(R.id.yuanzhengdan);
        yuanzhengdan1.setText("×" + yuanzhengdan);

        TextView yuanzhenggang1 = (TextView) findViewById(R.id.yuanzhenggang);
        yuanzhenggang1.setText("×" + yuanzhenggang);

        TextView yuanzhenglv1 = (TextView) findViewById(R.id.yuanzhenglv);
        yuanzhenglv1.setText("×" + yuanzhenglv);

        TextView yuanzhengjiangli111 = (TextView) findViewById(R.id.jiangli11);
        yuanzhengjiangli111.setText( yuanzhengjiangli11+"×" + yuanzhengjiangli12);





        TextView xiaoshiranchanggui1 = (TextView) findViewById(R.id.xiaoshichangguiran);
        TextView xiaoshidanchanggui1 = (TextView) findViewById(R.id.xiaoshichanguidan);
        TextView xiaoshigangchanggui1 = (TextView) findViewById(R.id.xiaoshichangguigang);
        TextView xiaoshilvchanggui1 = (TextView) findViewById(R.id.xiaoshichangguilv);
        double ran =( yuanzhengran - xiaohaoran2)*60/haoshi3;
        double dan = ( yuanzhengdan - xiaohaodan2)*60/haoshi3;
        double gang = yuanzhenggang *60/haoshi3;
        double lv = yuanzhenglv*60/haoshi3;

        String rans = String .format("%.1f",ran);
        String dans = String .format("%.1f",dan);
        String gangs = String .format("%.1f",gang);
        String lvs = String .format("%.1f",lv);





        xiaoshiranchanggui1.setText("×"+rans);
        if (ran < 0){xiaoshiranchanggui1.setTextColor(this.getResources().getColor(R.color.fense));}
        xiaoshidanchanggui1.setText("×"+dans);
        if (dan < 0){xiaoshidanchanggui1.setTextColor(this.getResources().getColor(R.color.fense));}
        xiaoshigangchanggui1.setText("×"+gangs);
        xiaoshilvchanggui1.setText("×"+lvs);






        TextView daojushouyi1 = (TextView) findViewById(R.id.daojushouyi);


        if (yuanzhengjiangli11==null)  {
            yuanzhengjiangli111.setVisibility(View.GONE);
            daojushouyi1.setVisibility(View.GONE);

        }


        TextView xiaoshiran1 = (TextView) findViewById(R.id.xiaoshiran);
        TextView xiaoshidan1 = (TextView) findViewById(R.id.xiaoshidan);
        TextView xiaoshigang1 = (TextView) findViewById(R.id.xiaoshigang);
        TextView xiaoshilv1 = (TextView) findViewById(R.id.xiaoshilv);
        double ran1 =( yuanzhengran*1.5 - xiaohaoran3)*60/haoshi3;
        double dan1 = ( yuanzhengdan*1.5 - xiaohaodan3)*60/haoshi3;
        double gang1 = yuanzhenggang*1.5 *60/haoshi3;
        double lv1 = yuanzhenglv*1.5*60/haoshi3;

        String ran1s = String .format("%.1f",ran1);
        String dan1s = String .format("%.1f",dan1);
        String gang1s = String .format("%.1f",gang1);
        String lv1s = String .format("%.1f",lv1);


        xiaoshiran1.setText("×"+ran1s);
        if (ran1 < 0){xiaoshiran1.setTextColor(this.getResources().getColor(R.color.fense));}
        xiaoshidan1.setText("×"+dan1s);
        if (dan1 < 0){xiaoshidan1.setTextColor(this.getResources().getColor(R.color.fense));}
        xiaoshigang1.setText("×"+gang1s);
        xiaoshilv1.setText("×"+lv1s);



        TextView yuanzhengjiangli211 = (TextView) findViewById(R.id.jiangli21);
        yuanzhengjiangli211.setText(yuanzhengjiangli21+ "×" + yuanzhengjiangli22);




        if (yuanzhengjiangli21==null) {
            yuanzhengjiangli211.setVisibility(View.GONE);


        }


        TextView qijiandengji1 = (TextView)findViewById(R.id.qijiandengji);
        qijiandengji1.setText(qijiandengji);

        if (hejidengji!=null){
        TextView hejidengji1 = (TextView)findViewById(R.id.hejidengji);
        hejidengji1.setText(hejidengji);
        hejidengji1.setVisibility(View.VISIBLE);
            TextView hejidengjiwenzi=(TextView)findViewById(R.id.hejidengjiwenzi);
            hejidengjiwenzi.setVisibility(View.VISIBLE);
        }

        TextView yuanzhengpeizhi1 = (TextView)findViewById(R.id.yuanzhengpeizhi);
        yuanzhengpeizhi1.setText(yuanzhengpeizhi);


        if (yuanzhengbeizhu!=null) {

            TextView yuangzhengbeizhubiaoti1 =(TextView) findViewById(R.id.yuanzhengbeizhubiaoti);
            yuangzhengbeizhubiaoti1.setVisibility(View.VISIBLE);
            TextView yuanzhengbeizhu1 = (TextView) findViewById(R.id.yuanzhengbeizhu);
            yuanzhengbeizhu1.setVisibility(View.VISIBLE);
            yuanzhengbeizhu1.setText(yuanzhengbeizhu);

        }





        ImageView imageView1 =(ImageView)findViewById(R.id.yuanzhengcaidaitubiao);

        if ("S".equals(yuanzhengnandu)){imageView1.setImageResource(R.mipmap.ic_yuanzheng_s);}
        else if ("C".equals(yuanzhengnandu)){imageView1.setImageResource(R.mipmap.ic_yuanzheng_c);}
        else if ("E".equals(yuanzhengnandu)){imageView1.setImageResource(R.mipmap.ic_yuanzheng_e);}
        else if ("B".equals(yuanzhengnandu)){imageView1.setImageResource(R.mipmap.ic_yuanzheng_b);}
        else if ("D".equals(yuanzhengnandu)){imageView1.setImageResource(R.mipmap.ic_yuanzheng_d);}
        else if ("A".equals(yuanzhengnandu)){imageView1.setImageResource(R.mipmap.ic_yuanzheng_a);}







    }



}
