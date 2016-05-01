package com.kochiyasanae.kancollehelper.Fragment.RenwuFragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.kochiyasanae.kancollehelper.Adapter.RecyclerViewRenwuAdapter;
import com.kochiyasanae.kancollehelper.Adapter.RecyclerViewRenwuXilieAdapter;
import com.kochiyasanae.kancollehelper.Database.MyDatabaseHelper;
import com.kochiyasanae.kancollehelper.MainActivity;
import com.kochiyasanae.kancollehelper.R;
import com.kochiyasanae.kancollehelper.RenwuActivity;
import com.kochiyasanae.kancollehelper.RenwuxinxiActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KochiyaSanae on 2016/3/26.
 */
public class RenwuDingqiFragment extends Fragment {


    private MyDatabaseHelper dbhelper;

    private RecyclerViewRenwuXilieAdapter mAdapter;

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

        getContext();
        final SharedPreferences sharedPreferences = getActivity().getSharedPreferences("renwudingqi", Context.MODE_PRIVATE);
        String renwuxilie = sharedPreferences.getString("renwudingqi", "周常系列任务");


        List<String> renwubianhao = new ArrayList<>();
        List<String> renwuleibie1 = new ArrayList<>();
        List<String> renwumingcheng = new ArrayList<>();
        List<String> renwumiaoshu = new ArrayList<>();
        List<String> renwufenlei =new ArrayList<>();

        String sqlrenwuchaxun = null;


        sqlrenwuchaxun = "select bianhao,leibie1,leibie2,mingcheng,miaoshu,qitaneirong from renwu where qitaneirong = ? ";
        dbhelper = new MyDatabaseHelper(getActivity(), "GaixiuDB", null, MainActivity.databasevesion);
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        Cursor c = db.rawQuery(sqlrenwuchaxun, new String[]{renwuxilie});
        while (c.moveToNext()) {
            String bianhao = c.getString(c.getColumnIndex("bianhao"));
            renwubianhao.add(bianhao);
            String leibie1 = c.getString(c.getColumnIndex("leibie1"));
            renwuleibie1.add(leibie1);
            String mingcheng = c.getString(c.getColumnIndex("mingcheng"));
            renwumingcheng.add(mingcheng);
            String miaoshu = c.getString(c.getColumnIndex("miaoshu"));
            renwumiaoshu.add(miaoshu);
            String fenlei = c.getString(c.getColumnIndex("qitaneirong"));
            renwufenlei.add(fenlei);


        }
        c.close();
        db.close();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        mAdapter = new RecyclerViewRenwuXilieAdapter(renwubianhao, renwuleibie1,  renwumingcheng, renwumiaoshu,renwufenlei);
        mRecyclerView.setAdapter(mAdapter);


       mAdapter.setOnItemClickListener(new RecyclerViewRenwuXilieAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, final String data) {
                int mint = data.indexOf("系列任务");

                if (mint==-1) {

                    Intent intent = new Intent();
                    intent.setClass(getActivity(), RenwuxinxiActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("mdata", data); //要传递的数据
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else
                {
                    final String[] renwufenlei = {getString(R.string.richang),getString(R.string.zhouchang),getString(R.string.yuechang)};

                    AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                    dialog.setTitle("选择任务分类");
                    dialog.setCancelable(true);
                    dialog.setItems(renwufenlei,  new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("renwudingqi", renwufenlei[which]);
                            editor.commit();
                            RenwuActivity a = (RenwuActivity) getActivity();
                            a.getAdapter().reLoad();
                            dialog.dismiss();


                        }
                    });


                    dialog.show();












                }

            }
        });


    }
}