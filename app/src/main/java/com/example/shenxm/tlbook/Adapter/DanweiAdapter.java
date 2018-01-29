package com.example.shenxm.tlbook.Adapter;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shenxm.tlbook.Fragment.MainFragment;
import com.example.shenxm.tlbook.Model.DanweiModel;

import com.example.shenxm.tlbook.Model.XitongModel;
import com.example.shenxm.tlbook.R;
import com.example.shenxm.tlbook.ryxx_list_temp_fullscreen;

import java.util.List;

/**
 * Created by SHENXM on 2017/12/28.
 */

public class DanweiAdapter extends BaseAdapter {
    private Context context;
    private List<DanweiModel> myList;
    private ViewHolder viewHolder;
    private DanweiAdapter danweiAdapter;
    private MainFragment mainFragment;

    public DanweiAdapter (List<DanweiModel> list,Context context, MainFragment mainFragment)
    {
        this.context=context;
        this.myList=list;
        this.mainFragment = mainFragment;
        danweiAdapter=this;
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
                Intent intent =new Intent(context,ryxx_list_temp_fullscreen.class);
                intent.putExtra("code",item.danweiCode);
                intent.putExtra("deptname",item.danweiname+":"+item.danweiid);
                context.startActivity(intent);
            }
        });

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
