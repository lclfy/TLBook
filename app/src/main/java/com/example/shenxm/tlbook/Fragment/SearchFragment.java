package com.example.shenxm.tlbook.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.shenxm.tlbook.Activity.SearchActivity;
import com.example.shenxm.tlbook.Adapter.PersonsAdapter;
import com.example.shenxm.tlbook.Adapter.XitongAdapter;
import com.example.shenxm.tlbook.Comm;
import com.example.shenxm.tlbook.Dal.ComDal;
import com.example.shenxm.tlbook.Dal.PersonsDal;
import com.example.shenxm.tlbook.Model.ListModel;
import com.example.shenxm.tlbook.Model.XitongModel;
import com.example.shenxm.tlbook.R;

import java.util.List;


public class SearchFragment extends Fragment {
    private ListView listView;
    private DrawerLayout drawerLayout;
    private View view;

    private String ranage = "领导人员";

    private String deptPlusname = "";
    List<ListModel> mylist;
    PersonsAdapter personsAdapter;
    TextView xingbieBtn;
    TextView danweiBtn;
    TextView xrzwBtn;
    TextView xmBtn;
    TextView csrqBtn;
    TextView jbBtn;
    TextView xlBtn;
    private int sort=0;//desc


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.activity_search, container, false);
        initView();
        return view;
    }

    private void initView(){

        listView=(ListView)view.findViewById(R.id.v4_listview);
//        drawerLayout=(DrawerLayout)findViewById(R.id.v4_drawerlayout);
        final ListView personsListView = (ListView)view.findViewById(R.id.ryxx_list_full);
        xingbieBtn = (TextView)view.findViewById(R.id.xbhz);
        danweiBtn = (TextView)view.findViewById(R.id.dwmc);
        xrzwBtn = (TextView)view.findViewById(R.id.xrzw);
        xmBtn = (TextView)view.findViewById(R.id.xmhz);
        csrqBtn = (TextView)view.findViewById(R.id.csny);
        jbBtn = (TextView)view.findViewById(R.id.jbhz);
        xlBtn = (TextView)view.findViewById(R.id.xl);
        Button searchbutton = (Button)view.findViewById(R.id.buttonSearch);

        final EditText searchEditText = (EditText)view.findViewById(R.id.editTextsearch);
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
                    personsAdapter = new PersonsAdapter(mylist, getActivity());
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
                personsAdapter = new PersonsAdapter(mylist, getActivity());
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
                personsAdapter = new PersonsAdapter(mylist, getActivity());
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
                personsAdapter = new PersonsAdapter(mylist, getActivity());
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
                personsAdapter = new PersonsAdapter(mylist, getActivity());
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
                personsAdapter = new PersonsAdapter(mylist, getActivity());
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
                personsAdapter = new PersonsAdapter(mylist, getActivity());
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
                personsAdapter = new PersonsAdapter(mylist, getActivity());
                personsListView.setAdapter(personsAdapter);
                if(sort==0){
                    sort=1;
                }else if(sort==1){
                    sort=0;
                }
            }
        });
    }


}
