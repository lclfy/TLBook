package com.example.shenxm.tlbook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shenxm.tlbook.Activity.BaseActivity;
import com.example.shenxm.tlbook.Dal.DanweiDal;
import com.example.shenxm.tlbook.Activity.MainActivity;
import com.example.shenxm.tlbook.Fragment.MainFragment;
import com.example.shenxm.tlbook.Model.DanweiModel;
import com.example.shenxm.tlbook.Model.XitongModel;
import com.example.shenxm.tlbook.R;

import java.util.List;

/**
 * Created by SHENXM on 2017/12/28.
 */

public class XitongAdapter extends BaseAdapter {

    private Context context;
    private List<XitongModel> myList;
    private ViewHolder viewHolder;
    private XitongAdapter xitongAdapter;

    public List<DanweiModel> danweiModelList;
    DanweiAdapter danweiAdapter;
    DanweiAdapter.DanweiClickListener mDanweiListener;

    private MainFragment mainFragment;

    public XitongAdapter(List<XitongModel> list, Context context, MainFragment mainFragment, DanweiAdapter.DanweiClickListener danweiListener)
    {
        this.context=context;
        this.myList=list;
        this.mainFragment = mainFragment;
        this.mDanweiListener = danweiListener;
        xitongAdapter=this;
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

        final XitongModel xn = myList.get(position);
        viewHolder.name.setText(xn.getDeptname().replace("郑州铁路局",""));

        viewHolder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                danweiModelList= DanweiDal.getDanwei(xn.getDept_id());
                mainFragment.xt_gview.setVisibility(View.GONE);
                mainFragment.dw_gview.setVisibility(View.VISIBLE);

                danweiAdapter=new DanweiAdapter(danweiModelList,context,mainFragment,mDanweiListener);
                mainFragment.dw_gview.setAdapter(danweiAdapter);
//                Toast.makeText(context,xn.getDeptname(),Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    public static class ViewHolder {
        public TextView name;
        public ImageView iv;
        public ViewHolder(View rootView) {
           // this.iv=(ImageView)rootView.findViewById(R.id.iv_image) ;
            this.name = (TextView) rootView.findViewById(R.id.textName);
        }

    }
}
