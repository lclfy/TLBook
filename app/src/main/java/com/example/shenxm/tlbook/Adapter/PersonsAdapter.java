package com.example.shenxm.tlbook.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shenxm.tlbook.Comm;
import com.example.shenxm.tlbook.Activity.DetailActivity;
import com.example.shenxm.tlbook.Model.ListModel;
import com.example.shenxm.tlbook.R;
import com.mingle.widget.ShapeLoadingDialog;

import java.io.Serializable;
import java.util.List;

/**
 * Created by SHENXM on 2017/12/28.
 */

public class PersonsAdapter extends BaseAdapter implements Serializable {
    private Context context;
    private List<ListModel> myList;
    private ViewHolder viewHolder;
    private PersonsAdapter personsAdapter;

    public PersonsAdapter(List<ListModel> list,Context context)
    {
        this.context=context;
        this.myList=list;
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
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.personlist, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final ListModel item = myList.get(position);
        viewHolder._id.setText(item.get_id());
        viewHolder.dwmc.setText(item.getDWMC());
        viewHolder.xrzw.setText(item.getZWMCHZ());
        viewHolder.xmhz.setText(item.getXM());
        viewHolder.xbhz.setText(item.getXBHZ());
        viewHolder.csny.setText(item.getCSRQ());
        viewHolder.jbhz.setText(item.getJBHZ());
        viewHolder.xl.setText(item.getWHCDHZ());
        viewHolder.person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Comm.myModel=item;
                Intent intent =new Intent(context,DetailActivity.class);
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    public static class ViewHolder {
        public LinearLayout person;
        public TextView _id;
        public TextView dwmc;
        public TextView xrzw;
        public TextView xmhz;
        public TextView xbhz;
        public TextView jbhz;
        public TextView csny;
        public TextView xl;


        public ViewHolder(View rootView) {
            this.person=(LinearLayout)rootView.findViewById(R.id.person);
            this._id = (TextView) rootView.findViewById(R.id._id);
            this.dwmc = (TextView) rootView.findViewById(R.id.dwmc);
            this.xrzw = (TextView) rootView.findViewById(R.id.xrzw);
            this.xmhz = (TextView) rootView.findViewById(R.id.xmhz);
            this.xbhz = (TextView) rootView.findViewById(R.id.xbhz);
            this.csny = (TextView) rootView.findViewById(R.id.csny);
            this.jbhz = (TextView) rootView.findViewById(R.id.jbhz);
            this.xl = (TextView) rootView.findViewById(R.id.xl);
        }

    }
}
