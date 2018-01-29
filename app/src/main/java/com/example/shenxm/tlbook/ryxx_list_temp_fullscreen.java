package com.example.shenxm.tlbook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.shenxm.tlbook.Activity.EditUserActivity;
import com.example.shenxm.tlbook.Activity.MainActivity;
import com.example.shenxm.tlbook.Activity.SearchActivity;
import com.example.shenxm.tlbook.Adapter.PersonsAdapter;
import com.example.shenxm.tlbook.Dal.PersonsDal;
import com.example.shenxm.tlbook.Model.ListModel;

import java.util.ArrayList;
import java.util.List;

public class ryxx_list_temp_fullscreen extends AppCompatActivity {
    private String ranage = "领导人员";
    private String code = "";
    private String deptname = "";
    List<ListModel> mylist;
    PersonsAdapter personsAdapter;
    private ListView leftListView;
    private DrawerLayout drawerLayout;
    private Context myContent;
    TextView xingbieBtn;
    TextView danweiBtn;
    TextView xrzwBtn;
    TextView xmBtn;
    TextView csrqBtn;
    TextView jbBtn;
    TextView xlBtn;

    private int sort=0;//desc
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ryxx_list_temp_fullscreen);
        final ListView personsListView = (ListView) findViewById(R.id.ryxx_list_full);
        final Intent intent = this.getIntent();
        xingbieBtn = (TextView)findViewById(R.id.xbhz);
        danweiBtn = (TextView)findViewById(R.id.dwmc);
        xrzwBtn = (TextView)findViewById(R.id.xrzw);
        xmBtn = (TextView)findViewById(R.id.xmhz);
        csrqBtn = (TextView)findViewById(R.id.csny);
        jbBtn = (TextView)findViewById(R.id.jbhz);
        xlBtn = (TextView)findViewById(R.id.xl);

        code = intent.getStringExtra("code");
        deptname = intent.getStringExtra("deptname");
        ranage=Comm.range;
        mylist = PersonsDal.getPersons(code, deptname, ranage);
        personsAdapter = new PersonsAdapter(mylist, this);
        personsListView.setAdapter(personsAdapter);

        leftListView = (ListView) findViewById(R.id.v4_listview);
//        drawerLayout = (DrawerLayout) findViewById(R.id.v4_drawerlayout);
        initData();
        myContent = this;

        Button returnBtn = (Button) findViewById(R.id.listReturnButton);
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent in = new Intent();
                in.setClass(DetailActivity.this,Main2Activity.class);
                startActivity(in);*/
                finish();
                /*//jump to Login page
                DetailActivity.this.startActivity(new Intent(DetailActivity.this,Main2Activity.class));
                //finish this page
                DetailActivity.this.finish();*/
            }
        });

        //sort functions
        xingbieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mylist = PersonsDal.getSortedCursor(code, deptname,"","XBHZ",sort,ranage);
                personsAdapter = new PersonsAdapter(mylist, ryxx_list_temp_fullscreen.this);
                personsListView.setAdapter(personsAdapter);
                if(sort==0){
                    sort=1;
                }else if(sort==1){
                    sort=0;
                }
            }
        });danweiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mylist = PersonsDal.getSortedCursor(code, deptname,"","DWMC",sort,ranage);
                personsAdapter = new PersonsAdapter(mylist, ryxx_list_temp_fullscreen.this);
                personsListView.setAdapter(personsAdapter);
                if(sort==0){
                    sort=1;
                }else if(sort==1){
                    sort=0;
                }
            }
        });xrzwBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mylist = PersonsDal.getSortedCursor(code, deptname,"","ZWMCHZ",sort,ranage);
                personsAdapter = new PersonsAdapter(mylist, ryxx_list_temp_fullscreen.this);
                personsListView.setAdapter(personsAdapter);
                if(sort==0){
                    sort=1;
                }else if(sort==1){
                    sort=0;
                }
            }
        });xmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mylist = PersonsDal.getSortedCursor(code, deptname,"","XM",sort,ranage);
                personsAdapter = new PersonsAdapter(mylist, ryxx_list_temp_fullscreen.this);
                personsListView.setAdapter(personsAdapter);
                if(sort==0){
                    sort=1;
                }else if(sort==1){
                    sort=0;
                }
            }
        });csrqBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mylist = PersonsDal.getSortedCursor(code, deptname,"","CSRQ",sort,ranage);
                personsAdapter = new PersonsAdapter(mylist, ryxx_list_temp_fullscreen.this);
                personsListView.setAdapter(personsAdapter);
                if(sort==0){
                    sort=1;
                }else if(sort==1){
                    sort=0;
                }
            }
        });jbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mylist = PersonsDal.getSortedCursor(code, deptname,"","JBHZ",sort,ranage);
                personsAdapter = new PersonsAdapter(mylist, ryxx_list_temp_fullscreen.this);
                personsListView.setAdapter(personsAdapter);
                if(sort==0){
                    sort=1;
                }else if(sort==1){
                    sort=0;
                }
            }
        });xlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mylist = PersonsDal.getSortedCursor(code, deptname,"","WHCDHZ",sort,ranage);
                personsAdapter = new PersonsAdapter(mylist, ryxx_list_temp_fullscreen.this);
                personsListView.setAdapter(personsAdapter);
                if(sort==0){
                    sort=1;
                }else if(sort==1){
                    sort=0;
                }
            }
        });

    }

    private void initData() {
        final List<String> list = new ArrayList<String>();
        list.add("");
        list.add("按照系统单位查询");
        list.add("");
        list.add("按照姓名查询");
        list.add("");
        list.add("系统设置");
        list.add("");
        list.add("返回");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        leftListView.setAdapter(arrayAdapter);
        leftListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 1) {
                    Intent intent = new Intent(ryxx_list_temp_fullscreen.this, MainActivity.class);
                    myContent.startActivity(intent);
                } else if (position == 3) {
                    Intent intent=new Intent(ryxx_list_temp_fullscreen.this,SearchActivity.class);
                    startActivity(intent);
                } else if (position == 5) {
                    Intent intent=new Intent(ryxx_list_temp_fullscreen.this,EditUserActivity.class);
                    startActivity(intent);
                }else if (position == 7) {
                    finish();
                }
                //showDrawerLayout();
            }
        });
//        drawerLayout.openDrawer(Gravity.LEFT);//侧滑打开  不设置则不会默认打开
    }

    private void showDrawerLayout() {
        if (!drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.openDrawer(Gravity.LEFT);
        } else {
            drawerLayout.closeDrawer(Gravity.LEFT);
        }
    }


}
