package com.example.shenxm.tlbook.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.example.shenxm.tlbook.Adapter.XitongAdapter;
import com.example.shenxm.tlbook.Comm;
import com.example.shenxm.tlbook.Dal.ComDal;
import com.example.shenxm.tlbook.Dal.XitongDal;
import com.example.shenxm.tlbook.Model.XitongModel;
import com.example.shenxm.tlbook.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public GridView xt_gview;
    public GridView dw_gview;
    private DrawerLayout drawerLayout;

    List<XitongModel> xitongArrayList;

    XitongAdapter xitongAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
//        this.setTitle(R.string.app_name);
        getSave();
        ComDal.InitDb();
//        ComDal.CreateDb(this);
        xt_gview = (GridView)findViewById(R.id.xt_gridView);
        dw_gview=(GridView)findViewById(R.id.dw_gridView);
//        drawerLayout=(DrawerLayout)findViewById(R.id.v4_drawerlayout);
//        System.out.println("dwgview "+dw_gview.getVisibility());
//        initData(dw_gview.getVisibility());
//        xitongAdapter=new XitongAdapter(xitongArrayList,this);
        xt_gview.setAdapter(xitongAdapter);

    }
    public String getSave() {

        SharedPreferences sp = getSharedPreferences("SP",
                android.content.Context.MODE_PRIVATE);

        String name = sp.getString("range", "领导人员");
        Comm.range=name;
        return name;
    }

    private void showDrawerLayout() {
        if (!drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.openDrawer(Gravity.LEFT);
        } else {
            drawerLayout.closeDrawer(Gravity.LEFT);
        }
    }

}
