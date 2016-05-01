package com.kochiyasanae.kancollehelper;

import android.content.ClipData;
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
import android.text.Html;
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


        final String sqlrenwuxinxi = "select bianhao,leibie1,leibie2,mingcheng,miaoshu,renwubeizhu,shouyiran,shouyidan,shouyigang,shouyilv,daojushouyi1,daojushuliang1,daojushouyi2,daojushuliang2,qitashouyi,qianzhibianhao1,qianzhirenwu1,qianzhibianhao2,qianzhirenwu2,qitaneirong,teshurenwu,haiyuditu from renwu where bianhao = ? ";

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

        String qitashouyi = null;

        String qitaneirong = null;
        String teshuneirong =null;
        String haiyuditu=null;

        while (c.moveToNext()) {
            renwubianhao = c.getString(c.getColumnIndex("bianhao"));
            renwuleibie1 = c.getString(c.getColumnIndex("leibie1"));
            renwuleibie2 = c.getString(c.getColumnIndex("leibie2"));
            renwumingcheng = c.getString(c.getColumnIndex("mingcheng"));
            renwushuoming = c.getString(c.getColumnIndex("miaoshu"));
            renwubeizhu = c.getString(c.getColumnIndex("renwubeizhu"));

            shouyiran = c.getInt(c.getColumnIndex("shouyiran"));
            shouyidan = c.getInt(c.getColumnIndex("shouyidan"));
            shouyigang = c.getInt(c.getColumnIndex("shouyigang"));
            shouyilv = c.getInt(c.getColumnIndex("shouyilv"));

            daojushouyi1 = c.getString(c.getColumnIndex("daojushouyi1"));
            daojushuliang1 = c.getInt(c.getColumnIndex("daojushuliang1"));
            daojushouyi2 = c.getString(c.getColumnIndex("daojushouyi2"));
            daojushuliang2 = c.getInt(c.getColumnIndex("daojushuliang2"));
            qitashouyi=c.getString(c.getColumnIndex("qitashouyi"));

            qianzhibianhao1 = c.getString(c.getColumnIndex("qianzhibianhao1"));
            qianzhirenwu1 = c.getString(c.getColumnIndex("qianzhirenwu1"));
            qianzhibianhao2 =c .getString(c.getColumnIndex("qianzhibianhao2"));
            qianzhirenwu2 = c.getString(c.getColumnIndex("qianzhirenwu2"));

            qitaneirong = c.getString(c.getColumnIndex("qitaneirong"));
            teshuneirong = c.getString(c.getColumnIndex("teshurenwu"));
            haiyuditu = c.getString(c.getColumnIndex("haiyuditu"));

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
            renwubeizhu2.setText(Html.fromHtml(renwubeizhu));};

        if (qianzhibianhao1!=null){
        TextView renwuqianzhi11 = (TextView) findViewById(R.id.renwuqianzhi1);
        renwuqianzhi11.setText(qianzhibianhao1 + " · " + qianzhirenwu1);
            final String finalQianzhibianhao1 = qianzhibianhao1;

            CardView cardView =(CardView) findViewById(R.id.qianzhirenwu);
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
                            dialog.dismiss();
                            restartActivity(renwutiaozhuan1[which]);


                        }
                    });

                    dialog.show();
                }
            });

        }

        if (haiyuditu!=null){

            final String finalhaiyuditu = haiyuditu;

            CardView cardView =(CardView) findViewById(R.id.renwuditu);
            cardView.setOnClickListener(new android.view.View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int mint = finalhaiyuditu.indexOf("-");
                    if ( mint!=-1 ) {

                        /*Intent intent = new Intent();
                        intent.setClass(RenwuxinxiActivity.this, DituxinxiActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("mdata", finalhaiyuditu); //要传递的数据
                        intent.putExtras(bundle);
                        startActivity(intent);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);*/
                    }
                    else
                    {

                        Intent intent = new Intent();
                        intent.setClass(RenwuxinxiActivity.this, YuanzhengxinxiActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("mdata", finalhaiyuditu); //要传递的数据
                        intent.putExtras(bundle);
                        startActivity(intent);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    }
                }
            });  }




        TextView shouyiran1 = (TextView) findViewById(R.id.renwuran);
        shouyiran1.setText("×" + shouyiran);

        TextView shouyidan1 = (TextView) findViewById(R.id.renwudan);
        shouyidan1.setText("×" + shouyidan);

        TextView shouyigang1 = (TextView) findViewById(R.id.renwugang);
        shouyigang1.setText("×" + shouyigang);

        TextView shouyilv1 = (TextView) findViewById(R.id.renwulv);
        shouyilv1.setText("×" + shouyilv);


        TextView daojushouyi11=(TextView)findViewById(R.id.daojushouyi1);
        TextView daojushouyi21=(TextView)findViewById(R.id.daojushouyi2);
        TextView daojushouyi0 =(TextView)findViewById(R.id.daojushouyi0);

        if(daojushouyi1!=null) {
            daojushouyi11.setText(daojushouyi1 + "×" + daojushuliang1);
            daojushouyi0.setVisibility(View.VISIBLE);
            daojushouyi11.setVisibility(View.VISIBLE);
        }

        if (daojushouyi2!=null){
            daojushouyi21.setText(daojushouyi2 + "×" + daojushuliang2);
            daojushouyi21.setVisibility(View.VISIBLE);
        }


        TextView qitashouyi11=(TextView)findViewById(R.id.qitashouyi1);
        TextView qitashouyi00=(TextView)findViewById(R.id.qitashouyi0);

        if (qitashouyi!=null){
            qitashouyi11.setText(qitashouyi);
            qitashouyi00.setVisibility(View.VISIBLE);
            qitashouyi11.setVisibility(View.VISIBLE);
        }


        ImageView imageView1 =(ImageView)findViewById(R.id.renwuleibietubiao);

        if ("出击类".equals(renwuleibie1)){imageView1.setImageResource(R.mipmap.ic_chuji);}
        else if ("编成类".equals(renwuleibie1)){imageView1.setImageResource(R.mipmap.ic_biancheng);}
        else if ("远征类".equals(renwuleibie1)){imageView1.setImageResource(R.mipmap.ic_yuanzheng);}
        else if ("工厂类".equals(renwuleibie1)){imageView1.setImageResource(R.mipmap.ic_gongchang);}
        else if ("演习类".equals(renwuleibie1)){imageView1.setImageResource(R.mipmap.ic_yanxi);}
        else if ("补给/入渠类".equals(renwuleibie1)){imageView1.setImageResource(R.mipmap.ic_buji);}
        else if ("改装类".equals(renwuleibie1)){imageView1.setImageResource(R.mipmap.ic_gaizhuang);}



        if (teshuneirong!=null){
            TextView yijuhua=(TextView)findViewById(R.id.yijuhua);
            TextView yijuhuagonglue=(TextView)findViewById(R.id.yijuhuagonglue);
            yijuhua.setVisibility(View.VISIBLE);
            yijuhuagonglue.setVisibility(View.VISIBLE);
            yijuhuagonglue.setText(teshuneirong);


            if(teshuneirong.equals("参见建议配置。")){
                CardView cardView = (CardView)findViewById(R.id.teshuneirong);
                cardView.setVisibility(View.VISIBLE);
                final String sqlxiangxirenwuxinxi = "select jianduipeizhi,buchongneirong,peizhuang1,beizhu1,peizhuang2,beizhu2,peizhuang3,beizhu3,peizhuang4,beizhu4,peizhuang5,beizhu5,peizhuang6,beizhu6 from Renwugonglue where bianhao = ? ";

                dbhelper = new MyDatabaseHelper(this, "GaixiuDB", null, MainActivity.databasevesion);
                final SQLiteDatabase db1 = dbhelper.getReadableDatabase();
                Cursor d = db1.rawQuery(sqlxiangxirenwuxinxi, new String[]{mdata});
                String jianduipeizhi = null;
                String peizhuang1 = null;
                String beizhu1 = null;
                String peizhuang2 = null;
                String beizhu2 = null;
                String peizhuang3 = null;
                String beizhu3 = null;
                String peizhuang4 = null;
                String beizhu4 = null;
                String peizhuang5 = null;
                String beizhu5 = null;
                String peizhuang6 = null;
                String beizhu6 = null;
                String buchongneirong = null;

                while (d.moveToNext()) {
                    buchongneirong = d.getString(d.getColumnIndex("buchongneirong"));
                    jianduipeizhi = d.getString(d.getColumnIndex("jianduipeizhi"));
                    peizhuang1 = d.getString(d.getColumnIndex("peizhuang1"));
                    beizhu1 = d.getString(d.getColumnIndex("beizhu1"));
                    peizhuang2 = d.getString(d.getColumnIndex("peizhuang2"));
                    beizhu2 = d.getString(d.getColumnIndex("beizhu2"));
                    peizhuang3 = d.getString(d.getColumnIndex("peizhuang3"));
                    beizhu3 = d.getString(d.getColumnIndex("beizhu3"));
                    peizhuang4 = d.getString(d.getColumnIndex("peizhuang4"));
                    beizhu4 = d.getString(d.getColumnIndex("beizhu4"));
                    peizhuang5 = d.getString(d.getColumnIndex("peizhuang5"));
                    beizhu5 = d.getString(d.getColumnIndex("beizhu5"));
                    peizhuang6 = d.getString(d.getColumnIndex("peizhuang6"));
                    beizhu6 = d.getString(d.getColumnIndex("beizhu6"));

                }
                d.close();
                db.close();

                TextView buchongneirong1 = (TextView) findViewById(R.id.buchongneirong);
                buchongneirong1.setText(buchongneirong);

                TextView jianduipeizhi1 =(TextView)findViewById(R.id.jianduipeizhi);
                jianduipeizhi1.setText(jianduipeizhi);

                TextView peizhuang11 =(TextView)findViewById(R.id.peizhuang1);
                peizhuang11.setText(peizhuang1);
                TextView beizhu11 =(TextView)findViewById(R.id.beizhu1);
                beizhu11.setText(beizhu1);


                if(peizhuang2!=null) {
                    TextView peizhuang21 = (TextView) findViewById(R.id.peizhuang2);
                    peizhuang21.setText(peizhuang2);
                    peizhuang21.setVisibility(View.VISIBLE);
                    TextView beizhu21 = (TextView) findViewById(R.id.beizhu2);
                    beizhu21.setText(beizhu2);
                    beizhu21.setVisibility(View.VISIBLE);
                if (peizhuang3!=null){
                    TextView peizhuang31 = (TextView) findViewById(R.id.peizhuang3);
                    peizhuang31.setText(peizhuang3);
                    peizhuang31.setVisibility(View.VISIBLE);
                    TextView beizhu31 = (TextView) findViewById(R.id.beizhu3);
                    beizhu31.setText(beizhu3);
                    beizhu31.setVisibility(View.VISIBLE);
                if (peizhuang4!=null){
                    TextView peizhuang41 = (TextView) findViewById(R.id.peizhuang4);
                    peizhuang41.setText(peizhuang4);
                    peizhuang41.setVisibility(View.VISIBLE);
                    TextView beizhu41 = (TextView) findViewById(R.id.beizhu4);
                    beizhu41.setText(beizhu4);
                    beizhu41.setVisibility(View.VISIBLE);
                if (peizhuang5!=null){
                    TextView peizhuang51 = (TextView) findViewById(R.id.peizhuang5);
                    peizhuang51.setText(peizhuang5);
                    peizhuang51.setVisibility(View.VISIBLE);
                    TextView beizhu51 = (TextView) findViewById(R.id.beizhu5);
                    beizhu51.setText(beizhu5);
                    beizhu51.setVisibility(View.VISIBLE);
                if (peizhuang6!=null){
                    TextView peizhuang61 = (TextView) findViewById(R.id.peizhuang6);
                    peizhuang61.setText(peizhuang6);
                    peizhuang61.setVisibility(View.VISIBLE);
                    TextView beizhu61 = (TextView) findViewById(R.id.beizhu6);
                    beizhu61.setText(beizhu6);
                    beizhu61.setVisibility(View.VISIBLE);}}}}

                }


            }



        }




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
