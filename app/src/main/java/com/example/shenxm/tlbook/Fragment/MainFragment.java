package com.example.shenxm.tlbook.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.shenxm.tlbook.Adapter.XitongAdapter;
import com.example.shenxm.tlbook.Comm;
import com.example.shenxm.tlbook.Dal.ComDal;
import com.example.shenxm.tlbook.Dal.XitongDal;
import com.example.shenxm.tlbook.Model.XitongModel;
import com.example.shenxm.tlbook.R;

import java.util.List;

public class MainFragment extends Fragment {

    private View view;
    public GridView xt_gview;
    public GridView dw_gview;
    private ListView listView;


    List<XitongModel> xitongArrayList;

    XitongAdapter xitongAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.activity_main, container, false);
        initView();
        return view;
    }

    private void initView(){

        getSave();
        ComDal.InitDb();
//      ComDal.CreateDb(this);
        xt_gview = (GridView)view.findViewById(R.id.xt_gridView);
        dw_gview=(GridView)view.findViewById(R.id.dw_gridView);
        listView=(ListView)view.findViewById(R.id.v4_listview);
//        drawerLayout=(DrawerLayout)findViewById(R.id.v4_drawerlayout);
//        System.out.println("dwgview "+dw_gview.getVisibility());
        xitongArrayList= XitongDal.getXitong();
        xitongAdapter=new XitongAdapter(xitongArrayList,getActivity(),this);
        xt_gview.setAdapter(xitongAdapter);
    }

    public String getSave() {

        SharedPreferences sp = getActivity().getSharedPreferences("SP",
                android.content.Context.MODE_PRIVATE);
        String name = sp.getString("range", "领导人员");
        Comm.range=name;
        return name;
    }



}
