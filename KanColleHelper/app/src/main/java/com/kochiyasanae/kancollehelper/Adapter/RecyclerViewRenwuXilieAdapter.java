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

public class RecyclerViewRenwuXilieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener,View.OnLongClickListener {

    private Context mContext;

    private String[] datas;

    public RecyclerViewRenwuXilieAdapter(String[] datas) {
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
    public List<String> mdatas3;
    public List<String> mdatas4;
    public List<String> mdatas5;

    public static enum ITEM_TYPE {
        ITEM_TYPE_HEAD, ITEM_TYPE_TEXT
    }

//第二步，传入数值
    public RecyclerViewRenwuXilieAdapter(List<String> renwubianhao, List<String> renwuleibie1,  List<String> renwumingcheng, List<String> renwumiaoshu,List<String> renwufenlei){
        this.mdatas = renwubianhao;
        this.mdatas1 = renwuleibie1;
        this.mdatas3 = renwumingcheng;
        this.mdatas4= renwumiaoshu;
        this.mdatas5 = renwufenlei;
    }

    public RecyclerViewRenwuXilieAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return ITEM_TYPE.ITEM_TYPE_HEAD.ordinal();
        }
        else {
            return ITEM_TYPE.ITEM_TYPE_TEXT.ordinal();
        }
   }



    //第三步，创造viewholder
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == ITEM_TYPE.ITEM_TYPE_HEAD.ordinal())
        {
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_card_renwuxuanxiang,parent,false);
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
            return new ViewHolderHeader(view);
        }
        else {
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_card_renwu,parent,false);
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
            return new ViewHolderNormal(view);
        }


    }




    //第七步，把数据绑定进入viewholder
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderHeader){
            ((ViewHolderHeader)holder).textView.setText(mdatas5.get(position));
            ((ViewHolderHeader)holder).itemView.setTag(mdatas5.get(position));
        }

        else if (holder instanceof ViewHolderNormal)
        {

            ((ViewHolderNormal)holder).textView.setText(mdatas.get(position-1));
            ((ViewHolderNormal)holder).textView1.setText(mdatas1.get(position-1));
            ((ViewHolderNormal)holder).textView3.setText(mdatas3.get(position-1));
            ((ViewHolderNormal)holder).textView4.setText(mdatas4.get(position - 1));
            ((ViewHolderNormal)holder).itemView.setTag(mdatas.get(position - 1));



            if ("出击类".equals(mdatas1.get(position-1))) {
                ((ViewHolderNormal)holder).imageView.setImageResource(R.mipmap.ic_chuji);
            } else if ("编成类".equals(mdatas1.get(position-1))) {
                ((ViewHolderNormal)holder).imageView.setImageResource(R.mipmap.ic_biancheng);
            } else if ("远征类".equals(mdatas1.get(position-1))) {
                ((ViewHolderNormal)holder).imageView.setImageResource(R.mipmap.ic_yuanzheng);
            } else if ("工厂类".equals(mdatas1.get(position-1))) {
                ((ViewHolderNormal)holder).imageView.setImageResource(R.mipmap.ic_gongchang);
            } else if ("演习类".equals(mdatas1.get(position-1))) {
                ((ViewHolderNormal)holder).imageView.setImageResource(R.mipmap.ic_yanxi);
            } else if ("补给/入渠类".equals(mdatas1.get(position-1))) {
                ((ViewHolderNormal)holder).imageView.setImageResource(R.mipmap.ic_buji);
            } else if ("改装类".equals(mdatas1.get(position-1))) {
                ((ViewHolderNormal)holder).imageView.setImageResource(R.mipmap.ic_gaizhuang);
            }


        }

   }

//第四步，viewholder计数器
    @Override
    public int getItemCount() {
        return mdatas.size()+1;
    }


//第五步，绑定viewholder的数值

    public class ViewHolderHeader extends RecyclerView.ViewHolder {
        private TextView textView;
        public ViewHolderHeader(View View) {
            super(View);
            textView= (TextView) View.findViewById(R.id.renwuxilie);
        }
    }

    public class ViewHolderNormal extends RecyclerView.ViewHolder {

        private TextView textView;
        private TextView textView1;
        private TextView textView3;
        private TextView textView4;
        private ImageView imageView;



        //第六步，绑定内容到item中去
        public ViewHolderNormal(View View) {
            super(View);
            textView= (TextView) View.findViewById(R.id.renwubianhao);
            textView1= (TextView) View.findViewById(R.id.renwuleibie1);
            textView3= (TextView) View.findViewById(R.id.renwumingcheng);
            textView4= (TextView) View.findViewById(R.id.renwujianbao);
            imageView=(ImageView) View.findViewById(R.id.renwuleibietubiao);


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
