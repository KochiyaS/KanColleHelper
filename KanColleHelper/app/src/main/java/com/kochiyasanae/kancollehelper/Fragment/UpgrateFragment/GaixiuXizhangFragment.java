package com.kochiyasanae.kancollehelper.Fragment.UpgrateFragment;



import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kochiyasanae.kancollehelper.Database.MyDatabaseHelper;
import com.kochiyasanae.kancollehelper.GaixiuxinxiActivity;
import com.kochiyasanae.kancollehelper.MainActivity;
import com.kochiyasanae.kancollehelper.R;
import com.kochiyasanae.kancollehelper.Adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;
import java.util.TimeZone;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GaixiuXiaozhupaoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GaixiuXizhangFragment extends Fragment {
    private MyDatabaseHelper dbhelper;

    private RecyclerViewAdapter mAdapter;

    private RecyclerView mRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mRecyclerView =
                (RecyclerView) inflater.inflate(R.layout.fragment_gaixiu, container, false);

        return mRecyclerView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<String> zhuangbeimingcheng = new ArrayList<>();
        List<String> gaixiujian = new ArrayList<>();
        List<String> zhuangbeileibie1 = new ArrayList<>();
        List<String> zhuangbeileibie2 = new ArrayList<>();
        List<String> guanzhuxinpin = new ArrayList<>();


        String mWeekday;
        String sqlchaxun = null;


        final Calendar weekday = Calendar.getInstance();
        weekday.setTimeZone(TimeZone.getTimeZone("GMT+9:00"));//东九区
        mWeekday = String.valueOf(weekday.get(Calendar.DAY_OF_WEEK));//得到星期几
        //周日？
        if ("1".equals(mWeekday)) {
            sqlchaxun = "select leibie1,leibie2,mingcheng,zhouyi,guanzhuxinpin from gaixiu where zhouyi is not null and guanzhuxinpin is not null  ";
            dbhelper = new MyDatabaseHelper(getActivity(), "GaixiuDB", null,  MainActivity.databasevesion);
            SQLiteDatabase db = dbhelper.getReadableDatabase();
            Cursor c = db.rawQuery(sqlchaxun, null);
            while (c.moveToNext()) {
                String leibie1 = c.getString(c.getColumnIndex("leibie1"));
                zhuangbeileibie1.add(leibie1);
                String leibie2 = c.getString(c.getColumnIndex("leibie2"));
                zhuangbeileibie2.add(leibie2);
                String mingcheng = c.getString(c.getColumnIndex("mingcheng"));
                zhuangbeimingcheng.add(mingcheng);
                String gaixiujian1 = c.getString(c.getColumnIndex("zhouyi"));
                gaixiujian.add(gaixiujian1);
                String guanzhuxinpin1 = c.getString(c.getColumnIndex("guanzhuxinpin"));
                guanzhuxinpin.add(guanzhuxinpin1);

            }                c.close();
            db.close();

        } else if ("2".equals(mWeekday)) {
            sqlchaxun = "select leibie1,leibie2,mingcheng,zhouer,guanzhuxinpin from gaixiu where zhouer is not null and guanzhuxinpin is not null  ";
            dbhelper = new MyDatabaseHelper(getActivity(), "GaixiuDB", null,  MainActivity.databasevesion);
            SQLiteDatabase db = dbhelper.getReadableDatabase();
            Cursor c = db.rawQuery(sqlchaxun, null);
            while (c.moveToNext()) {
                String leibie1 = c.getString(c.getColumnIndex("leibie1"));
                zhuangbeileibie1.add(leibie1);
                String leibie2 = c.getString(c.getColumnIndex("leibie2"));
                zhuangbeileibie2.add(leibie2);
                String mingcheng = c.getString(c.getColumnIndex("mingcheng"));
                zhuangbeimingcheng.add(mingcheng);
                String gaixiujian1 = c.getString(c.getColumnIndex("zhouer"));
                gaixiujian.add(gaixiujian1);
                String guanzhuxinpin1 = c.getString(c.getColumnIndex("guanzhuxinpin"));
                guanzhuxinpin.add(guanzhuxinpin1);

            }                c.close();
            db.close();

        } else if ("3".equals(mWeekday)) {
            sqlchaxun = "select leibie1,leibie2,mingcheng,zhousan,guanzhuxinpin from gaixiu where zhousan is not null and guanzhuxinpin is not null  ";
            dbhelper = new MyDatabaseHelper(getActivity(), "GaixiuDB", null,  MainActivity.databasevesion);
            SQLiteDatabase db = dbhelper.getReadableDatabase();
            Cursor c = db.rawQuery(sqlchaxun, null);
            while (c.moveToNext()) {
                String leibie1 = c.getString(c.getColumnIndex("leibie1"));
                zhuangbeileibie1.add(leibie1);
                String leibie2 = c.getString(c.getColumnIndex("leibie2"));
                zhuangbeileibie2.add(leibie2);
                String mingcheng = c.getString(c.getColumnIndex("mingcheng"));
                zhuangbeimingcheng.add(mingcheng);
                String gaixiujian1 = c.getString(c.getColumnIndex("zhousan"));
                gaixiujian.add(gaixiujian1);
                String guanzhuxinpin1 = c.getString(c.getColumnIndex("guanzhuxinpin"));
                guanzhuxinpin.add(guanzhuxinpin1);

            }
            c.close();
            db.close();

        } else if ("4".equals(mWeekday)) {
            sqlchaxun = "select leibie1,leibie2,mingcheng,zhousi,guanzhuxinpin from gaixiu where zhousi is not null and guanzhuxinpin is not null  ";
            dbhelper = new MyDatabaseHelper(getActivity(), "GaixiuDB", null,  MainActivity.databasevesion);
            SQLiteDatabase db = dbhelper.getReadableDatabase();
            Cursor c = db.rawQuery(sqlchaxun, null);
            while (c.moveToNext()) {
                String leibie1 = c.getString(c.getColumnIndex("leibie1"));
                zhuangbeileibie1.add(leibie1);
                String leibie2 = c.getString(c.getColumnIndex("leibie2"));
                zhuangbeileibie2.add(leibie2);
                String mingcheng = c.getString(c.getColumnIndex("mingcheng"));
                zhuangbeimingcheng.add(mingcheng);
                String gaixiujian1 = c.getString(c.getColumnIndex("zhousi"));
                gaixiujian.add(gaixiujian1);
                String guanzhuxinpin1 = c.getString(c.getColumnIndex("guanzhuxinpin"));
                guanzhuxinpin.add(guanzhuxinpin1);

            }                c.close();
            db.close();

        } else if ("5".equals(mWeekday)) {
            sqlchaxun = "select leibie1,leibie2,mingcheng,zhouwu,guanzhuxinpin from gaixiu where zhouwu is not null and guanzhuxinpin is not null  ";
            dbhelper = new MyDatabaseHelper(getActivity(), "GaixiuDB", null, MainActivity.databasevesion);
            SQLiteDatabase db = dbhelper.getReadableDatabase();
            Cursor c = db.rawQuery(sqlchaxun, null);
            while (c.moveToNext()) {
                String leibie1 = c.getString(c.getColumnIndex("leibie1"));
                zhuangbeileibie1.add(leibie1);
                String leibie2 = c.getString(c.getColumnIndex("leibie2"));
                zhuangbeileibie2.add(leibie2);
                String mingcheng = c.getString(c.getColumnIndex("mingcheng"));
                zhuangbeimingcheng.add(mingcheng);
                String gaixiujian1 = c.getString(c.getColumnIndex("zhouwu"));
                gaixiujian.add(gaixiujian1);
                String guanzhuxinpin1 = c.getString(c.getColumnIndex("guanzhuxinpin"));
                guanzhuxinpin.add(guanzhuxinpin1);

            }                c.close();
            db.close();

        } else if ("6".equals(mWeekday)) {
            sqlchaxun = "select leibie1,leibie2,mingcheng,zhouliu,guanzhuxinpin from gaixiu where zhouliu is not null and guanzhuxinpin is not null  ";

            dbhelper = new MyDatabaseHelper(getActivity(), "GaixiuDB", null, MainActivity.databasevesion);
            SQLiteDatabase db = dbhelper.getReadableDatabase();
            Cursor c = db.rawQuery(sqlchaxun, null);
            while (c.moveToNext()) {
                String leibie1 = c.getString(c.getColumnIndex("leibie1"));
                zhuangbeileibie1.add(leibie1);
                String leibie2 = c.getString(c.getColumnIndex("leibie2"));
                zhuangbeileibie2.add(leibie2);
                String mingcheng = c.getString(c.getColumnIndex("mingcheng"));
                zhuangbeimingcheng.add(mingcheng);
                String gaixiujian1 = c.getString(c.getColumnIndex("zhouliu"));
                gaixiujian.add(gaixiujian1);
                String guanzhuxinpin1 = c.getString(c.getColumnIndex("guanzhuxinpin"));
                guanzhuxinpin.add(guanzhuxinpin1);

            }                c.close();
            db.close();

        } else if ("7".equals(mWeekday)) {
            sqlchaxun = "select leibie1,leibie2,mingcheng,zhouri,guanzhuxinpin from gaixiu where zhouri is not null and guanzhuxinpin is not null ";
            dbhelper = new MyDatabaseHelper(getActivity(), "GaixiuDB", null, MainActivity.databasevesion);
            SQLiteDatabase db = dbhelper.getReadableDatabase();
            Cursor c = db.rawQuery(sqlchaxun, null);
            while (c.moveToNext()) {
                String leibie1 = c.getString(c.getColumnIndex("leibie1"));
                zhuangbeileibie1.add(leibie1);
                String leibie2 = c.getString(c.getColumnIndex("leibie2"));
                zhuangbeileibie2.add(leibie2);
                String mingcheng = c.getString(c.getColumnIndex("mingcheng"));
                zhuangbeimingcheng.add(mingcheng);
                String gaixiujian1 = c.getString(c.getColumnIndex("zhouri"));
                gaixiujian.add(gaixiujian1);
                String guanzhuxinpin1 = c.getString(c.getColumnIndex("guanzhuxinpin"));
                guanzhuxinpin.add(guanzhuxinpin1);

            }                c.close();
            db.close();

        }

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        mAdapter = new RecyclerViewAdapter(zhuangbeimingcheng, gaixiujian, zhuangbeileibie1, zhuangbeileibie2, guanzhuxinpin);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String data) {


                Intent intent = new Intent();
                intent.setClass(getActivity(), GaixiuxinxiActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("mdata", data); //要传递的数据
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        mAdapter.setOnItemLongClickListener(new RecyclerViewAdapter.OnRecyclerViewItemLongClickListener() {
            @Override
            public void onItemLongClick(View view, final String data) {

                String guanzhu = null;

                final String sqlguanzhu = "select guanzhuxinpin from gaixiu where mingcheng = ? ";
                final String sqlquxiaoguanzhu = "update gaixiu set guanzhuxinpin = null where mingcheng = ? ";
                final String sqlkaishiguanzhu = "update gaixiu set guanzhuxinpin = '已关注' where mingcheng = ? ";
                dbhelper = new MyDatabaseHelper(getActivity(), "GaixiuDB", null, MainActivity.databasevesion);
                final SQLiteDatabase db = dbhelper.getWritableDatabase();
                Cursor c = db.rawQuery(sqlguanzhu, new String[]{data});
                while (c.moveToNext()) {
                    guanzhu = c.getString(c.getColumnIndex("guanzhuxinpin"));
                }
                c.close();
                db.close();
                if (guanzhu != null) {
                    AlertDialog.Builder dialog  = new AlertDialog.Builder (getActivity());
                    dialog.setTitle("取消关注");
                    dialog.setMessage("取消对<" + data + ">的改修关注？");
                    dialog.setCancelable(true);
                    dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dbhelper = new MyDatabaseHelper(getActivity(), "GaixiuDB", null, MainActivity.databasevesion);
                            final SQLiteDatabase db = dbhelper.getWritableDatabase();
                            db.execSQL(sqlquxiaoguanzhu, new String[]{data});
                            db.close();
                            Toast.makeText(getActivity().getApplicationContext(), "<"+data+ ">取消关注成功", Toast.LENGTH_SHORT).show();

                            MainActivity a = (MainActivity) getActivity();
                            a.getAdapter().reLoad();




                        }
                    });
                    dialog.setNegativeButton("取消", new DialogInterface. OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) { } });

                    dialog.show();


                } else if (guanzhu == null) {

                    AlertDialog.Builder dialog  = new AlertDialog.Builder (getActivity());
                    dialog.setTitle("添加关注");
                    dialog.setMessage("添加对<" + data + ">的改修关注？");
                    dialog.setCancelable(true);
                    dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dbhelper = new MyDatabaseHelper(getActivity(), "GaixiuDB", null, MainActivity.databasevesion);
                            final SQLiteDatabase db = dbhelper.getWritableDatabase();
                            db.execSQL(sqlkaishiguanzhu, new String[]{data});
                            db.close();
                            Toast.makeText(getActivity().getApplicationContext(), "<" + data + ">添加关注成功", Toast.LENGTH_SHORT).show();

                        }
                    });
                    dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) { } });

                    dialog.show();

                }

            }
        });




    }
}




