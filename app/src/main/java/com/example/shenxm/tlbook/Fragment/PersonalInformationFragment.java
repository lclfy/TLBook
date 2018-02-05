package com.example.shenxm.tlbook.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.shenxm.tlbook.Adapter.PersonsAdapter;
import com.example.shenxm.tlbook.Comm;
import com.example.shenxm.tlbook.Dal.PersonsDal;
import com.example.shenxm.tlbook.Model.ListModel;
import com.example.shenxm.tlbook.R;

import java.util.List;


public class PersonalInformationFragment extends Fragment {

    private View view;
    private String ranage = "领导人员";
    private String code = "";
    private String deptname = "";
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
    TextView mTvToolbar;

    private int sort=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.view = inflater.inflate(R.layout.activity_ryxx_list_temp_fullscreen, container, false);
        return view;
    }

    public void initView(Bundle selectedItem){
        final ListView personsListView = (ListView)view.findViewById(R.id.ryxx_list_full);
//        final Intent intent = getActivity().getIntent();
        xingbieBtn = (TextView)view.findViewById(R.id.xbhz);
        danweiBtn = (TextView)view.findViewById(R.id.dwmc);
        xrzwBtn = (TextView)view.findViewById(R.id.xrzw);
        xmBtn = (TextView)view.findViewById(R.id.xmhz);
        csrqBtn = (TextView)view.findViewById(R.id.csny);
        jbBtn = (TextView)view.findViewById(R.id.jbhz);
        xlBtn = (TextView)view.findViewById(R.id.xl);
        mTvToolbar = (TextView)view.findViewById(R.id.tv_toolbar);

        mTvToolbar.setText(selectedItem.getString("title"));
        code = selectedItem.getString("code");
        deptname = selectedItem.getString("deptname");
        ranage= Comm.range;
        mylist = PersonsDal.getPersons(code, deptname, ranage);
        personsAdapter = new PersonsAdapter(mylist, getActivity());
        personsListView.setAdapter(personsAdapter);
//        drawerLayout = (DrawerLayout) findViewById(R.id.v4_drawerlayout);
        myContent = getActivity();

        //sort functions
        xingbieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mylist = PersonsDal.getSortedCursor(code, deptname,"","XBHZ",sort,ranage);
                personsAdapter = new PersonsAdapter(mylist, myContent);
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
                personsAdapter = new PersonsAdapter(mylist, myContent);
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
                personsAdapter = new PersonsAdapter(mylist, myContent);
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
                personsAdapter = new PersonsAdapter(mylist, myContent);
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
                personsAdapter = new PersonsAdapter(mylist, myContent);
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
                personsAdapter = new PersonsAdapter(mylist, myContent);
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
                personsAdapter = new PersonsAdapter(mylist, myContent);
                personsListView.setAdapter(personsAdapter);
                if(sort==0){
                    sort=1;
                }else if(sort==1){
                    sort=0;
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        if (isAdded()) {//判断Fragment已经依附Activity
            initView(getArguments());
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
