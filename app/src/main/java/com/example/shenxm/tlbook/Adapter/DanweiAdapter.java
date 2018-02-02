package com.example.shenxm.tlbook.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shenxm.tlbook.Fragment.MainFragment;
import com.example.shenxm.tlbook.Model.DanweiModel;

import com.example.shenxm.tlbook.R;
import com.example.shenxm.tlbook.Activity.ryxx_list_temp_fullscreen;

import java.util.List;

/**
 * Created by SHENXM on 2017/12/28.
 */

public class DanweiAdapter extends BaseAdapter {
    private Context context;
    private List<DanweiModel> myList;
    private ViewHolder viewHolder;
    private MainFragment mainFragment;
//    private DanweiModel danweiItem;

    private DanweiClickListener mListener;

    //接口-用于使原Activity获取数据
    public interface DanweiClickListener{
        public void danweiClickListener(View v,Bundle bundle);
    }

    public DanweiAdapter (List<DanweiModel> list,Context context, MainFragment mainFragment, DanweiClickListener Listener)
    {
        this.mListener = Listener;
        this.context=context;
        this.myList=list;
        this.mainFragment = mainFragment;
    }
    @Override
    public int getCount() {
        if (myList!=null)
        {
            return myList.size();
        }
        return 0;
    }


    @Override
    public Object getItem(int i) {
        return myList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final DanweiModel item = myList.get(position);
        viewHolder.name.setText(item.getDanweiname().replace("郑州铁路局","").replace("领导","集团公司领导班子").replace("其他集团公司领导班子","集团公司其他领导").replace("郑州铁路安全监督管理办公室机车车辆验收室","机辆验收室").replace("中国铁路郑州局集团有限公司","").replace("政法委员会办公室","政法办"));
        viewHolder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("code",item.danweiCode);
                bundle.putString("deptname",item.danweiname+":"+item.danweiid);
                mListener.danweiClickListener(view,bundle);
            }
        });
        viewHolder.name.setTag(position);
        return convertView;
    }


    public static class ViewHolder {
        public TextView name;
        public ImageView iv;
        public ViewHolder(View rootView) {
            //this.iv=(ImageView)rootView.findViewById(R.id.iv_image) ;
            this.name = (TextView) rootView.findViewById(R.id.textName);
        }

    }
}
