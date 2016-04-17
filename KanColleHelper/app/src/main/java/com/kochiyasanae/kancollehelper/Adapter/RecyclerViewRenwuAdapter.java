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

public class RecyclerViewRenwuAdapter extends RecyclerView.Adapter<RecyclerViewRenwuAdapter.ViewHolder> implements View.OnClickListener,View.OnLongClickListener {

    private Context mContext;

    private String[] datas;


    public RecyclerViewRenwuAdapter(String[] datas) {
        this.datas = datas;
    }

    //1、声名点击接口
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;



    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, String data);
    }

    //声名长点击接口
    private OnRecyclerViewItemLongClickListener mOnItemLongClickListener = null;
    public static interface OnRecyclerViewItemLongClickListener {
            void onItemLongClick(View view, String data);
    }

//第一步，声名数值
public List<String> mdatas;
    public List<String> mdatas1;
    public List<String> mdatas2;
    public List<String> mdatas3;
    public List<String> mdatas4;



//第二步，传入数值
    public RecyclerViewRenwuAdapter(List<String> yuanzhengbianhao, List<String> yuanzhengmingcheng, List<String> yuanzhengshijian, List<String> yuanzhenghaiyu, List<String> yuanzhengnandu){
        this.mdatas = yuanzhengbianhao;
        this.mdatas1 = yuanzhengmingcheng;
        this.mdatas2 = yuanzhengshijian;
        this.mdatas3 = yuanzhenghaiyu;
        this.mdatas4= yuanzhengnandu;
    }

    public RecyclerViewRenwuAdapter(Context mContext) {
        this.mContext = mContext;
    }

//第三步，创造viewholder
    @Override
    public RecyclerViewRenwuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_card_yuanzheng, parent, false);
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
        holder.itemView.setTag(mdatas1.get(position));

        if ("S".equals(mdatas4.get(position))){holder.imageView.setImageResource(R.mipmap.ic_yuanzheng_s);}
        else if ("C".equals(mdatas4.get(position))){holder.imageView.setImageResource(R.mipmap.ic_yuanzheng_c);}
        else if ("E".equals(mdatas4.get(position))){holder.imageView.setImageResource(R.mipmap.ic_yuanzheng_e);}
        else if ("B".equals(mdatas4.get(position))){holder.imageView.setImageResource(R.mipmap.ic_yuanzheng_b);}
        else if ("D".equals(mdatas4.get(position))){holder.imageView.setImageResource(R.mipmap.ic_yuanzheng_d);}
        else if ("A".equals(mdatas4.get(position))){holder.imageView.setImageResource(R.mipmap.ic_yuanzheng_a);}






    }

//第四步，viewholder计数器
    @Override
    public int getItemCount() {
        return mdatas.size();
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
            textView= (TextView) View.findViewById(R.id.yuanzhengbianhao);
            textView1= (TextView) View.findViewById(R.id.yuanzhengmingcheng);
            textView2= (TextView) View.findViewById(R.id.yuanzhengshijian);
            textView3= (TextView) View.findViewById(R.id.yuanzhenghaiyu);
            imageView=(ImageView) View.findViewById(R.id.yuanzhengnandu);


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
