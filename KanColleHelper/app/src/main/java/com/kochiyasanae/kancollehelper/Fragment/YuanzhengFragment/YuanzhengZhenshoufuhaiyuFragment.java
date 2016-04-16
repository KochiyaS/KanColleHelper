package com.kochiyasanae.kancollehelper.Fragment.YuanzhengFragment;

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

import com.kochiyasanae.kancollehelper.Database.MyDatabaseHelper;
import com.kochiyasanae.kancollehelper.MainActivity;
import com.kochiyasanae.kancollehelper.R;
import com.kochiyasanae.kancollehelper.Adapter.RecyclerViewYuanzhengAdapter;
import com.kochiyasanae.kancollehelper.YuanzhengxinxiActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KochiyaSanae on 2016/3/26.
 */
public class YuanzhengZhenshoufuhaiyuFragment extends Fragment {


    private MyDatabaseHelper dbhelper;

    private RecyclerViewYuanzhengAdapter mAdapter;

    private RecyclerView mRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mRecyclerView =
                (RecyclerView) inflater.inflate(R.layout.fragment_yuanzheng, container, false);

        return mRecyclerView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<String> yuanzhengbianhao = new ArrayList<>();
        List<String> yuanzhengmingcheng = new ArrayList<>();
        List<String> yuanzhengshijian = new ArrayList<>();
        List<String> yuanzhenghaiyu = new ArrayList<>();
        List<String> yuanzhengnandu = new ArrayList<>();

        String sqlyuanzhengchaxun = null;


        sqlyuanzhengchaxun = "select bianhao,haiyu,mingcheng,haoshi1,nandu from yuanzheng where haiyu = '镇守府海域'  ";
        dbhelper = new MyDatabaseHelper(getActivity(), "GaixiuDB", null, MainActivity.databasevesion);
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        Cursor c = db.rawQuery(sqlyuanzhengchaxun, null);
        while (c.moveToNext()) {
            String bianhao = c.getString(c.getColumnIndex("bianhao"));
            yuanzhengbianhao.add(bianhao);
            String mingcheng = c.getString(c.getColumnIndex("mingcheng"));
            yuanzhengmingcheng.add(mingcheng);
            String shijian = c.getString(c.getColumnIndex("haoshi1"));
            yuanzhengshijian.add(shijian);
            String haiyu = c.getString(c.getColumnIndex("haiyu"));
            yuanzhenghaiyu.add(haiyu);
            String nandu = c.getString(c.getColumnIndex("nandu"));
            yuanzhengnandu.add(nandu);


        }
        c.close();
        db.close();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        mAdapter = new RecyclerViewYuanzhengAdapter(yuanzhengbianhao, yuanzhengmingcheng, yuanzhengshijian, yuanzhenghaiyu, yuanzhengnandu);
        mRecyclerView.setAdapter(mAdapter);





        mAdapter.setOnItemClickListener(new RecyclerViewYuanzhengAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String data) {


                Intent intent = new Intent();
                intent.setClass(getActivity(), YuanzhengxinxiActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("mdata", data); //要传递的数据
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

  /*      mAdapter.setOnItemLongClickListener(new RecyclerViewYuanzhengAdapter.OnRecyclerViewItemLongClickListener() {
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
                    AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
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
                            Toast.makeText(getActivity().getApplicationContext(), "<" + data + ">取消关注成功！", Toast.LENGTH_SHORT).show();

                            MainActivity a = (MainActivity) getActivity();
                            a.getAdapter().reLoad();


                        }
                    });
                    dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });

                    dialog.show();


                } else if (guanzhu == null) {

                    AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
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
                            Toast.makeText(getActivity().getApplicationContext(), "<" + data + ">添加关注成功，请多多关照！", Toast.LENGTH_SHORT).show();

                        }
                    });
                    dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });

                    dialog.show();

                }


            }
        });*/







    }
}