package com.kochiyasanae.kancollehelper;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.kochiyasanae.kancollehelper.MainActivity;

import com.kochiyasanae.kancollehelper.Database.MyDatabaseHelper;

public class GaixiuxinxiActivity extends AppCompatActivity {
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

        setContentView(R.layout.activity_gaixiuxinxi);


        String mdata = this.getIntent().getExtras().getString("mdata");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.activity_title11);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);

        ab.setHomeButtonEnabled(true);
        ab.setHomeAsUpIndicator(R.mipmap.ic_arrow_back_white_24dp);}
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        final String sqlgaixiuxinxi = "select leibie1,leibie2,mingcheng,mubiao1,mubiao2,ran,dan,gang,lv,zicai1,luosi1,zhuangbei1,zicai2,luosi2,zhuangbei2,zicai3,luosi3,zhuangbei3,gaixiujian,zhouri,zhouyi,zhouer,zhousan,zhousi,zhouwu,zhouliu from gaixiu where mingcheng = ? ";

        dbhelper = new MyDatabaseHelper(this, "GaixiuDB", null, MainActivity.databasevesion);
        final SQLiteDatabase db = dbhelper.getReadableDatabase();
        Cursor c = db.rawQuery(sqlgaixiuxinxi, new String[]{mdata});
        String leibie1 = null;
        String leibie2 = null;
        String mingcheng = null;
        String mubiao1 = null;
        String mubiao2 = null;
        String gaixiujian = null;
        String ran = null;
        String dan = null;
        String gang = null;
        String lv = null;
        String zicai1 = null;
        String luosi1 = null;
        String zhuangbei1 = null;
        String zicai2 = null;
        String luosi2 = null;
        String zhuangbei2 = null;
        String zicai3 = null;
        String luosi3 = null;
        String zhuangbei3 = null;
        String zhouri = null;
        String zhouyi = null;
        String zhouer = null;
        String zhousan = null;
        String zhousi = null;
        String zhouwu = null;
        String zhouliu = null;




        while (c.moveToNext()) {
            leibie1 = c.getString(c.getColumnIndex("leibie1"));
            leibie2 = c.getString(c.getColumnIndex("leibie2"));
            mingcheng = c.getString(c.getColumnIndex("mingcheng"));
            mubiao1 = c.getString(c.getColumnIndex("mubiao1"));
            mubiao2 = c.getString(c.getColumnIndex("mubiao2"));
            ran = c.getString(c.getColumnIndex("ran"));
            dan = c.getString(c.getColumnIndex("dan"));
            gang = c.getString(c.getColumnIndex("gang"));
            lv = c.getString(c.getColumnIndex("lv"));
            zicai1 = c.getString(c.getColumnIndex("zicai1"));
            luosi1 = c.getString(c.getColumnIndex("luosi1"));
            zhuangbei1 = c.getString(c.getColumnIndex("zhuangbei1"));
            zicai2 = c.getString(c.getColumnIndex("zicai2"));
            luosi2 = c.getString(c.getColumnIndex("luosi2"));
            zhuangbei2 = c.getString(c.getColumnIndex("zhuangbei2"));
            zicai3 = c.getString(c.getColumnIndex("zicai3"));
            luosi3 = c.getString(c.getColumnIndex("luosi3"));
            zhuangbei3 = c.getString(c.getColumnIndex("zhuangbei3"));
            gaixiujian = c.getString(c.getColumnIndex("gaixiujian"));
            zhouri= c.getString(c.getColumnIndex("zhouri"));
            zhouyi= c.getString(c.getColumnIndex("zhouyi"));
            zhouer= c.getString(c.getColumnIndex("zhouer"));
            zhousan= c.getString(c.getColumnIndex("zhousan"));
            zhousi= c.getString(c.getColumnIndex("zhousi"));
            zhouwu= c.getString(c.getColumnIndex("zhouwu"));
            zhouliu= c.getString(c.getColumnIndex("zhouliu"));



        }
        c.close();
        db.close();

        TextView zhuangbeileibie1 = (TextView) findViewById(R.id.zhuangbeileibie1);
        zhuangbeileibie1.setText(leibie1);

        TextView zhuangbeileibie2 = (TextView) findViewById(R.id.zhuangbeileibie2);
        zhuangbeileibie2.setText(leibie2);

        TextView zhuangbeimingcheng = (TextView) findViewById(R.id.zhuangbeimingcheng);
        zhuangbeimingcheng.setText(mingcheng);

        TextView gaixiuzhushou = (TextView) findViewById(R.id.gaixiuzhushou);
        gaixiuzhushou.setText(gaixiujian);


        TextView gaixiumubiao1 = (TextView) findViewById(R.id.gaixiumubiao1);
        gaixiumubiao1.setText(mubiao1);

        TextView gaixiumubiao2 = (TextView) findViewById(R.id.gaixiumubiao2);
        gaixiumubiao2.setText(mubiao2);

        TextView gaixiuran = (TextView) findViewById(R.id.gaixiuran);
        gaixiuran.setText(ran);
        TextView gaixiudan = (TextView) findViewById(R.id.gaixiudan);
        gaixiudan.setText(dan);
        TextView gaixiugang = (TextView) findViewById(R.id.gaixiugang);
        gaixiugang.setText(gang);
        TextView gaixiulv = (TextView) findViewById(R.id.gaixiulv);
        gaixiulv.setText(lv);

        TextView zicai11 = (TextView) findViewById(R.id.zicai1);
        zicai11.setText(zicai1);
        TextView luosi11 = (TextView) findViewById(R.id.luosi1);
        luosi11.setText(luosi1);
        TextView zhuangbei11 = (TextView) findViewById(R.id.zhuangbei1);
        if (zhuangbei1 == null) {
            zhuangbei11.setText("——");
        } else zhuangbei11.setText(zhuangbei1);

        TextView zicai21 = (TextView) findViewById(R.id.zicai2);
        zicai21.setText(zicai2);
        TextView luosi21 = (TextView) findViewById(R.id.luosi2);
        luosi21.setText(luosi2);
        TextView zhuangbei21 = (TextView) findViewById(R.id.zhuangbei2);
        if (zhuangbei2 == null) {
            zhuangbei21.setText("——");
        } else zhuangbei21.setText(zhuangbei2);


        TextView zicai31 = (TextView) findViewById(R.id.zicai3);
        if (zicai3 == null) {
            zicai31.setText("—/—");
        } else zicai31.setText(zicai3);
        TextView luosi31 = (TextView) findViewById(R.id.luosi3);
        if (luosi3 == null) {
            luosi31.setText("—/—");
        } else luosi31.setText(luosi3);
        TextView zhuangbei31 = (TextView) findViewById(R.id.zhuangbei3);
        if (zhuangbei3 == null) {
            zhuangbei31.setText("——");
        } else zhuangbei31.setText(zhuangbei3);


        TextView xingqiri = (TextView)findViewById(R.id.xingqiri);
        if(zhouri==null){
            xingqiri.setText("——");
        }else xingqiri.setText(zhouri);

        TextView xingqiyi = (TextView)findViewById(R.id.xingqiyi);
        if(zhouyi==null){
            xingqiyi.setText("——");
        }else xingqiyi.setText(zhouyi);


        TextView xingqier = (TextView)findViewById(R.id.xingqier);
        if(zhouer==null){
            xingqier.setText("——");
        }else xingqier.setText(zhouer);


        TextView xingqisan = (TextView)findViewById(R.id.xingqisan);
        if(zhousan==null){
            xingqisan.setText("——");
        }else xingqisan.setText(zhousan);


        TextView xingqisi = (TextView)findViewById(R.id.xingqisi);
        if(zhousi==null){
            xingqisi.setText("——");
        }else xingqisi.setText(zhousi);


        TextView xingqiwu = (TextView)findViewById(R.id.xingqiwu);
        if(zhouwu==null){
            xingqiwu.setText("——");
        }else xingqiwu.setText(zhouwu);


        TextView xingqiliu = (TextView)findViewById(R.id.xingqiliu);
        if(zhouliu==null){
            xingqiliu.setText("——");
        }else xingqiliu.setText(zhouliu);



        ImageView imageView1 =(ImageView)findViewById(R.id.caidaitubiao);
        if ("小口径高角主炮+高射装置".equals(leibie2)|"高角副炮+高射装置".equals(leibie2))
        {imageView1.setImageResource(R.mipmap.ic_gaojiaopaojiqiang);}
        else if ("主炮".equals(leibie1)|"对舰强化弹".equals(leibie1)){imageView1.setImageResource(R.mipmap.ic_zhupao);}
        else if ("副炮".equals(leibie1)){imageView1.setImageResource(R.mipmap.ic_putongfupao);}
        else if ("鱼雷".equals(leibie1)){imageView1.setImageResource(R.mipmap.ic_yulei);}
        else if ("水上飞机".equals(leibie1)){imageView1.setImageResource(R.mipmap.ic_shuishangfeiji);}
        else if ("电探/雷达".equals(leibie1)){imageView1.setImageResource(R.mipmap.ic_diantanleida);}
        else if ("对潜装备".equals(leibie1)){imageView1.setImageResource(R.mipmap.ic_duiqianzhuangbei);}
        else if ("对空机枪".equals(leibie2)){imageView1.setImageResource(R.mipmap.ic_gaojiaopaojiqiang);}
        else if ("高射装置".equals(leibie2)){imageView1.setImageResource(R.mipmap.ic_gaoshezhuangzhi);}
        else if ("探照灯".equals(leibie2)|"大型探照灯".equals(leibie2)){imageView1.setImageResource(R.mipmap.ic_tanzhaodeng);}
        else if ("登陆艇".equals(leibie2)|"特型内火艇".equals(leibie2)){imageView1.setImageResource(R.mipmap.ic_gaoshezhuangzhi);}







    }











}