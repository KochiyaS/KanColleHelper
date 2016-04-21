package com.kochiyasanae.kancollehelper;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kochiyasanae.kancollehelper.Database.MyDatabaseHelper;


public class RenwuxinxiActivity extends AppCompatActivity {
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


        setContentView(R.layout.activity_renwuxinxi);


        String mdata = this.getIntent().getExtras().getString("mdata");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle(R.string.activity_title31);
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


        final String sqlrenwuxinxi = "select bianhao,leibie1,leibie2,mingcheng,xiangximiaoshu,renwubeizhu,shouyiran,shouyidan,shouyigang,shouyilv,daojushouyi1,daojushuliang1,daojushouyi2,daojushuliang2,qitashouyi,qianzhibianhao1,qianzhirenwu1,qianzhibianhao2,qianzhirenwu2,qitaneirong from renwu where bianhao = ? ";

        dbhelper = new MyDatabaseHelper(this, "GaixiuDB", null, MainActivity.databasevesion);
        final SQLiteDatabase db = dbhelper.getReadableDatabase();
        Cursor c = db.rawQuery(sqlrenwuxinxi, new String[]{mdata});
        String renwubianhao = null;
        String renwuleibie1 = null;
        String renwuleibie2 = null;
        String renwumingcheng = null;
        String renwushuoming = null;
        String renwubeizhu = null;
        Integer shouyiran = null;
        Integer shouyidan = null;
        Integer shouyigang = null;
        Integer shouyilv = null;
        String daojushouyi1 = null;
        Integer daojushuliang1 = null;
        String daojushouyi2 = null;
        Integer daojushuliang2 = null;

        String qianzhibianhao1 = null;
        String qianzhirenwu1 = null;
        String qianzhibianhao2 = null;
        String qianzhirenwu2 = null;

        String qitaneirong = null;

        while (c.moveToNext()) {
            renwubianhao = c.getString(c.getColumnIndex("bianhao"));
            renwuleibie1 = c.getString(c.getColumnIndex("leibie1"));
            renwuleibie2 = c.getString(c.getColumnIndex("leibie2"));
            renwumingcheng = c.getString(c.getColumnIndex("mingcheng"));
            renwushuoming = c.getString(c.getColumnIndex("xiangximiaoshu"));
            renwubeizhu = c.getString(c.getColumnIndex("renwubeizhu"));

            shouyiran = c.getInt(c.getColumnIndex("shouyiran"));
            shouyidan = c.getInt(c.getColumnIndex("shouyidan"));
            shouyigang = c.getInt(c.getColumnIndex("shouyigang"));
            shouyilv = c.getInt(c.getColumnIndex("shouyilv"));

            daojushouyi1 = c.getString(c.getColumnIndex("daojushouyi1"));
            daojushuliang1 = c.getInt(c.getColumnIndex("daojushuliang1"));
            daojushouyi2 = c.getString(c.getColumnIndex("daojushouyi2"));
            daojushuliang2 = c.getInt(c.getColumnIndex("daojushuliang2"));

            qianzhibianhao1 = c.getString(c.getColumnIndex("qianzhibianhao1"));
            qianzhirenwu1 = c.getString(c.getColumnIndex("qianzhirenwu1"));
            qianzhibianhao2 =c .getString(c.getColumnIndex("qianzhibianhao2"));
            qianzhirenwu2 = c.getString(c.getColumnIndex("qianzhirenwu2"));

            qitaneirong = c.getString(c.getColumnIndex("qitaneirong"));

        }
        c.close();
        db.close();

        TextView renwumingcheng1 = (TextView) findViewById(R.id.renwumingcheng);
        renwumingcheng1.setText(renwumingcheng);

        TextView renwubianhao1 = (TextView) findViewById(R.id.renwubianhao);
        renwubianhao1.setText(renwubianhao);

        TextView renwuleibie11 = (TextView) findViewById(R.id.renwuleibie);
        renwuleibie11.setText(renwuleibie1);

        TextView renwuleibie21 = (TextView) findViewById(R.id.renwushuxing);
        if(qitaneirong==null){
        renwuleibie21.setText(renwuleibie2);}
        else {renwuleibie21.setText(renwuleibie2+" · "+qitaneirong);}

        TextView renwushuoming1 = (TextView) findViewById(R.id.renwumiaoshu);
        renwushuoming1.setText(renwushuoming);

        if (renwubeizhu!=null){
            TextView renwubeizhu1 = (TextView) findViewById(R.id.renwubeizhubiaoti);
            renwubeizhu1.setVisibility(View.VISIBLE);
            TextView renwubeizhu2 = (TextView) findViewById(R.id.renwubeizhu);
            renwubeizhu2.setVisibility(View.VISIBLE);
            renwubeizhu2.setText(renwubeizhu);};

        if (qianzhibianhao1!=null){
        TextView renwuqianzhi11 = (TextView) findViewById(R.id.renwuqianzhi1);
        renwuqianzhi11.setText(qianzhibianhao1 +" · "+ qianzhirenwu1);
            final String finalQianzhibianhao1 = qianzhibianhao1;

            CardView cardView =(CardView) findViewById(R.id.qianzhirenwu);
            assert cardView != null;
            cardView.setOnClickListener(new android.view.View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    restartActivity(finalQianzhibianhao1);
                }
            });


        }

        if (qianzhibianhao2!=null){
        TextView renwuqianzhi21 = (TextView) findViewById(R.id.renwuqianzhi2);
        renwuqianzhi21.setVisibility(View.VISIBLE);
        renwuqianzhi21.setText(qianzhibianhao2 +" · "+ qianzhirenwu2);
            final String finalQianzhirenwu1 = qianzhibianhao1 +" · "+ qianzhirenwu1;
            final String finalQianzhirenwu2 = qianzhibianhao2 +" · "+ qianzhirenwu2;
            final String finalQianzhibianhao1 = qianzhibianhao1;
            final String finalQianzhibianhao2 = qianzhibianhao2;
            CardView cardView =(CardView) findViewById(R.id.qianzhirenwu);
            assert cardView != null;
            cardView.setOnClickListener(new android.view.View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(RenwuxinxiActivity.this);
                    dialog.setTitle("任务跳转");
                    final String[] renwutiaozhuan = {finalQianzhirenwu1, finalQianzhirenwu2};
                    final String[] renwutiaozhuan1 = {finalQianzhibianhao1, finalQianzhibianhao2};

                    dialog.setCancelable(true);
                    dialog.setItems(renwutiaozhuan, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            restartActivity(renwutiaozhuan1[which]);

                        }
                    });

                    dialog.show();
                }
            });

        }

        TextView shouyiran1 = (TextView) findViewById(R.id.renwuran);
        shouyiran1.setText("×" + shouyiran);

        TextView shouyidan1 = (TextView) findViewById(R.id.renwudan);
        shouyidan1.setText("×" + shouyidan);

        TextView shouyigang1 = (TextView) findViewById(R.id.renwugang);
        shouyigang1.setText("×" + shouyigang);

        TextView shouyilv1 = (TextView) findViewById(R.id.renwulv);
        shouyilv1.setText("×" + shouyilv);

     /*   TextView yuanzhengjiangli111 = (TextView) findViewById(R.id.jiangli11);
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




*/


    }


    public void restartActivity(String data)
    {

        Intent intent = new Intent();
        intent.setClass(RenwuxinxiActivity.this, RenwuxinxiActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("mdata", data); //要传递的数据
        intent.putExtras(bundle);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();

    }

}
