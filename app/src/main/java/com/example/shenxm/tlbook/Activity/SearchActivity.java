package com.example.shenxm.tlbook.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.shenxm.tlbook.Adapter.PersonsAdapter;
import com.example.shenxm.tlbook.Comm;
import com.example.shenxm.tlbook.Dal.PersonsDal;
import com.example.shenxm.tlbook.Model.ListModel;
import com.example.shenxm.tlbook.R;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    private String ranage = "领导人员";

    private String deptPlusname = "";
    List<ListModel> mylist;
    PersonsAdapter personsAdapter;
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
        setContentView(R.layout.activity_search);
        myContent = this;
//        drawerLayout=(DrawerLayout)findViewById(R.id.v4_drawerlayout);
        final ListView personsListView = (ListView)findViewById(R.id.ryxx_list_full);
        xingbieBtn = (TextView)findViewById(R.id.xbhz);
        danweiBtn = (TextView)findViewById(R.id.dwmc);
        xrzwBtn = (TextView)findViewById(R.id.xrzw);
        xmBtn = (TextView)findViewById(R.id.xmhz);
        csrqBtn = (TextView)findViewById(R.id.csny);
        jbBtn = (TextView)findViewById(R.id.jbhz);
        xlBtn = (TextView)findViewById(R.id.xl);
        Button searchbutton = (Button)findViewById(R.id.buttonSearch);

        final EditText searchEditText = (EditText)findViewById(R.id.editTextsearch);
        //编辑search
        searchEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(searchEditText.getText().length()!=0){
                    searchEditText.setText("");
                }
                return false;
            }
        });

        searchEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchEditText.setText("");
            }
        });
        searchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ranage= Comm.range;
                String searchname = searchEditText.getText().toString();
                if(!searchname.equals("")){
                    mylist = PersonsDal.getZhuYaoCursorRange(searchname, ranage);
                    personsAdapter = new PersonsAdapter(mylist, myContent);
                    personsListView.setAdapter(personsAdapter);
                }else{
                    System.out.println("请输入要查询的内容");
                }
            }
        });

        //sort functions
        xingbieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ranage=Comm.range;
                String searchname = searchEditText.getText().toString();
                mylist = PersonsDal.getSortedCursorSearch(searchname,"XBHZ",sort,ranage);
                personsAdapter = new PersonsAdapter(mylist, SearchActivity.this);
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
                ranage=Comm.range;
                String searchname = searchEditText.getText().toString();
                mylist = PersonsDal.getSortedCursorSearch(searchname,"DWMC",sort,ranage);
                personsAdapter = new PersonsAdapter(mylist, SearchActivity.this);
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
                ranage=Comm.range;
                String searchname = searchEditText.getText().toString();
                mylist = PersonsDal.getSortedCursorSearch(searchname,"ZWMCHZ",sort,ranage);
                personsAdapter = new PersonsAdapter(mylist, SearchActivity.this);
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
                ranage=Comm.range;
                String searchname = searchEditText.getText().toString();
                mylist = PersonsDal.getSortedCursorSearch(searchname,"XM",sort,ranage);
                personsAdapter = new PersonsAdapter(mylist, SearchActivity.this);
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
                ranage=Comm.range;
                String searchname = searchEditText.getText().toString();
                mylist = PersonsDal.getSortedCursorSearch(searchname,"CSRQ",sort,ranage);
                personsAdapter = new PersonsAdapter(mylist, SearchActivity.this);
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
                ranage=Comm.range;
                String searchname = searchEditText.getText().toString();
                mylist = PersonsDal.getSortedCursorSearch(searchname,"JBHZ",sort,ranage);
                personsAdapter = new PersonsAdapter(mylist, SearchActivity.this);
                personsListView.setAdapter(personsAdapter);
                if(sort==0){
                    sort=1;
                }else if(sort==1){
                    sort=0;
                }
            }
        });xlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { String searchname = searchEditText.getText().toString();
                mylist = PersonsDal.getSortedCursorSearch(searchname,"WHCDHZ",sort,ranage);
                personsAdapter = new PersonsAdapter(mylist, SearchActivity.this);
                personsListView.setAdapter(personsAdapter);
                if(sort==0){
                    sort=1;
                }else if(sort==1){
                    sort=0;
                }
            }
        });
    }

    private void showDrawerLayout() {
        if (!drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.openDrawer(Gravity.LEFT);
        } else {
            drawerLayout.closeDrawer(Gravity.LEFT);
        }
    }
}
