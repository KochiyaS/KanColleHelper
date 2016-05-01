package com.kochiyasanae.kancollehelper.Fragment.RenwuFragment;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kochiyasanae.kancollehelper.Adapter.RecyclerViewRenwuAdapter;
import com.kochiyasanae.kancollehelper.Database.MyDatabaseHelper;
import com.kochiyasanae.kancollehelper.MainActivity;
import com.kochiyasanae.kancollehelper.R;
import com.kochiyasanae.kancollehelper.RenwuxinxiActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KochiyaSanae on 2016/3/26.
 */
public class RenwuBujiruquFragment extends Fragment {


    private MyDatabaseHelper dbhelper;

    private RecyclerViewRenwuAdapter mAdapter;

    private RecyclerView mRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mRecyclerView =
                (RecyclerView) inflater.inflate(R.layout.fragment_renwu, container, false);

        return mRecyclerView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<String> renwubianhao = new ArrayList<>();
        List<String> renwuleibie1 = new ArrayList<>();

        List<String> renwumingcheng = new ArrayList<>();
        List<String> renwumiaoshu = new ArrayList<>();
        List<String> renwufenlei = new ArrayList<>();
        String sqlrenwuchaxun = null;


        sqlrenwuchaxun = "select bianhao,leibie1,mingcheng,miaoshu,qitaneirong from renwu where leibie1 = '补给/入渠类' ";
        dbhelper = new MyDatabaseHelper(getActivity(), "GaixiuDB", null, MainActivity.databasevesion);
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        Cursor c = db.rawQuery(sqlrenwuchaxun, null);
        while (c.moveToNext()) {
            String bianhao = c.getString(c.getColumnIndex("bianhao"));
            renwubianhao.add(bianhao);
            String leibie1 = c.getString(c.getColumnIndex("leibie1"));
            renwuleibie1.add(leibie1);
            String mingcheng = c.getString(c.getColumnIndex("mingcheng"));
            renwumingcheng.add(mingcheng);
            String miaoshu = c.getString(c.getColumnIndex("miaoshu"));
            renwumiaoshu.add(miaoshu);
            String fenlei =c.getString(c.getColumnIndex("qitaneirong"));
            renwufenlei.add(fenlei);

        }
        c.close();
        db.close();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        mAdapter = new RecyclerViewRenwuAdapter(renwubianhao, renwuleibie1, renwumingcheng, renwumiaoshu,renwufenlei);
        mRecyclerView.setAdapter(mAdapter);


       mAdapter.setOnItemClickListener(new RecyclerViewRenwuAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String data) {


                Intent intent = new Intent();
                intent.setClass(getActivity(), RenwuxinxiActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("mdata", data); //要传递的数据
                intent.putExtras(bundle);
                startActivity(intent);


            }
        });


    }
}