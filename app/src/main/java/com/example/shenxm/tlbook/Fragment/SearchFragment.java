package com.example.shenxm.tlbook.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.shenxm.tlbook.Adapter.PersonsAdapter;
import com.example.shenxm.tlbook.Comm;
import com.example.shenxm.tlbook.Dal.PersonsDal;
import com.example.shenxm.tlbook.Model.ListModel;
import com.example.shenxm.tlbook.R;

import java.util.List;


public class SearchFragment extends Fragment {
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

    SearchView mSvText;
    String searchedText;


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
        final ListView personsListView = (ListView)view.findViewById(R.id.ryxx_list_full);
        xingbieBtn = (TextView)view.findViewById(R.id.xbhz);
        danweiBtn = (TextView)view.findViewById(R.id.dwmc);
        xrzwBtn = (TextView)view.findViewById(R.id.xrzw);
        xmBtn = (TextView)view.findViewById(R.id.xmhz);
        csrqBtn = (TextView)view.findViewById(R.id.csny);
        jbBtn = (TextView)view.findViewById(R.id.jbhz);
        xlBtn = (TextView)view.findViewById(R.id.xl);

        mSvText = (SearchView) view.findViewById(R.id.editTextsearch);
        mSvText.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            // 当搜索内容改变时触发该方法
            @Override
            public boolean onQueryTextChange(String newText) {
                //清空adapter
                personsListView.setVisibility(View.INVISIBLE);
                searchedText = newText;
                if (!TextUtils.isEmpty(newText)) {
                    ranage= Comm.range;
                    String searchname = newText;
                    if(!searchname.equals("")){
                        personsListView.setVisibility(View.VISIBLE);
                        mylist = PersonsDal.getZhuYaoCursorRange(searchname, ranage);
                        personsAdapter = new PersonsAdapter(mylist, getActivity());
                        personsListView.setAdapter(personsAdapter);
                    }
                }
                return false;
            }
        });

        //sort functions
        xingbieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (searchedText == null ||
                        searchedText.equals("")){
                    return;
                }
                ranage=Comm.range;
                String searchname = searchedText;
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
                if (searchedText == null ||
                        searchedText.equals("")){
                    return;
                }
                ranage=Comm.range;
                String searchname = searchedText;
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
                if (searchedText == null ||
                        searchedText.equals("")){
                    return;
                }
                ranage=Comm.range;
                String searchname = searchedText;
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
                if (searchedText == null ||
                        searchedText.equals("")){
                    return;
                }
                ranage=Comm.range;
                String searchname = searchedText;
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
                if (searchedText == null ||
                        searchedText.equals("")){
                    return;
                }
                ranage=Comm.range;
                String searchname = searchedText;
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
                if (searchedText == null ||
                        searchedText.equals("")){
                    return;
                }
                ranage=Comm.range;
                String searchname = searchedText;
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
            public void onClick(View view) {
                if (searchedText == null ||
                        searchedText.equals("")){
                    return;
                }
                String searchname = searchedText;
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
