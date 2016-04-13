package com.kochiyasanae.kancollehelper.Adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kochiyasanae.kancollehelper.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements View.OnClickListener,View.OnLongClickListener {

    private Context mContext;

    private String[] datas;


    public RecyclerViewAdapter(String[] datas) {
        this.datas = datas;
    }

    //1、声名点击接口
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;



    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , String data);
    }

    //声名长点击接口
    private OnRecyclerViewItemLongClickListener mOnItemLongClickListener = null;
    public static interface OnRecyclerViewItemLongClickListener {
            void onItemLongClick(View view , String data);
    }

//第一步，声名数值
    public List<String> mdatas;
    public List<String> mdatas1;
    public List<String> mdatas2;
    public List<String> mdatas3;



//第二步，传入数值
    public RecyclerViewAdapter(List<String> zhuangbeimingcheng,List<String> gaixiujian,List<String>zhuangbeileibie1,List<String>zhuangbeileibie2,List<String>guanzhuxinpin){
        this.mdatas = zhuangbeileibie1;
        this.mdatas1 = zhuangbeileibie2;
        this.mdatas2 = zhuangbeimingcheng;
        this.mdatas3 = gaixiujian;


    }

    public RecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

//第三步，创造viewholder
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_card_gaixiu, parent, false);
        //将创建的View注册点击事件
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);

        return new ViewHolder(view);

    }


//第七步，把数据绑定进入viewholder
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.textView.setText(mdatas.get(position));
        holder.textView1.setText(mdatas1.get(position));
        holder.textView2.setText(mdatas2.get(position));
        holder.textView3.setText(mdatas3.get(position));
        holder.itemView.setTag(mdatas2.get(position));

        if ("小口径高角主炮+高射装置".equals(mdatas1.get(position))){holder.imageView.setImageResource(R.mipmap.ic_gaojiaopaojiqiang);}
        else if ("主炮".equals(mdatas.get(position))){holder.imageView.setImageResource(R.mipmap.ic_zhupao);}
        else if ("高角副炮+高射装置".equals(mdatas1.get(position))){holder.imageView.setImageResource(R.mipmap.ic_gaojiaopaojiqiang);}
        else if ("副炮".equals(mdatas.get(position))){holder.imageView.setImageResource(R.mipmap.ic_putongfupao);}
        else if ("鱼雷".equals(mdatas.get(position))){holder.imageView.setImageResource(R.mipmap.ic_yulei);}
        else if ("水上飞机".equals(mdatas.get(position))){holder.imageView.setImageResource(R.mipmap.ic_shuishangfeiji);}
        else if ("电探/雷达".equals(mdatas.get(position))){holder.imageView.setImageResource(R.mipmap.ic_diantanleida);}
        else if ("对潜装备".equals(mdatas.get(position))){holder.imageView.setImageResource(R.mipmap.ic_duiqianzhuangbei);}
        else if ("对空机枪".equals(mdatas1.get(position))){holder.imageView.setImageResource(R.mipmap.ic_gaojiaopaojiqiang);}
        else if ("高射装置".equals(mdatas1.get(position))){holder.imageView.setImageResource(R.mipmap.ic_gaoshezhuangzhi);}
        else if ("对舰强化弹".equals(mdatas1.get(position))){holder.imageView.setImageResource(R.mipmap.ic_zhupao);}
        else if ("登陆艇".equals(mdatas1.get(position))){holder.imageView.setImageResource(R.mipmap.ic_gaoshezhuangzhi);}
        else if ("特型内火艇".equals(mdatas1.get(position))){holder.imageView.setImageResource(R.mipmap.ic_gaoshezhuangzhi);}
        else if ("探照灯".equals(mdatas1.get(position))){holder.imageView.setImageResource(R.mipmap.ic_tanzhaodeng);}
        else if ("大型探照灯".equals(mdatas1.get(position))){holder.imageView.setImageResource(R.mipmap.ic_tanzhaodeng);}









    }

//第四步，viewholder计数器
    @Override
    public int getItemCount() {
        return mdatas2.size();
    }


//第五步，绑定viewholder的数值

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
        private ImageView imageView;



        //第六步，绑定内容到item中去
        public ViewHolder(View View) {
            super(View);
            textView= (TextView) View.findViewById(R.id.zhuangbeileibie1);
            textView1= (TextView) View.findViewById(R.id.zhuangbeileibie2);
            textView2= (TextView) View.findViewById(R.id.zhuangbeimingcheng);
            textView3= (TextView) View.findViewById(R.id.gaixiuzhushou);
            imageView=(ImageView) View.findViewById(R.id.guanzhuxinpin);


        }
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v,(String)v.getTag());

        }
    }
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = (OnRecyclerViewItemClickListener)listener;
    }

    @Override
    public boolean onLongClick(View v) {
        if (mOnItemLongClickListener != null) {
            //注意这里使用getTag方法获取数据
                mOnItemLongClickListener.onItemLongClick(v, (String) v.getTag());


        }
        return false;
    }
    public void setOnItemLongClickListener(OnRecyclerViewItemLongClickListener listener) {
        this.mOnItemLongClickListener = (OnRecyclerViewItemLongClickListener) listener;
    }







}
