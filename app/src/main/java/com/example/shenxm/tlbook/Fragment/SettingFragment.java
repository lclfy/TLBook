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
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.shenxm.tlbook.Adapter.XitongAdapter;
import com.example.shenxm.tlbook.Comm;
import com.example.shenxm.tlbook.Dal.ComDal;
import com.example.shenxm.tlbook.Model.XitongModel;
import com.example.shenxm.tlbook.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class SettingFragment extends Fragment {
    String ranage;
    ProgressBar progressBar;
    View view;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.activity_edit_user, container, false);
        initView();
        return view;
    }

    private void initView(){

//        drawerLayout=(DrawerLayout)findViewById(R.id.v4_drawerlayout);

        Button updateBtn = (Button)view.findViewById(R.id.button2);
        //progressBar= (ProgressBar) findViewById(R.id.progress                Bar);
        final TextView textView = (TextView)view.findViewById(R.id.textView25);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dialog();
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = sdf.format(date);
                textView.setText("更新功能正在优化中......");
            }
        });

        RadioGroup radioGroup = (RadioGroup)view.findViewById(R.id.radioGroup);
        final RadioButton radioButton1 = (RadioButton)view.findViewById(R.id.radioButton1);
        final RadioButton radioButton2 = (RadioButton)view.findViewById(R.id.radioButton2);
        final RadioButton radioButton3 = (RadioButton)view.findViewById(R.id.radioButton3);
        final RadioButton radioButton4 = (RadioButton)view.findViewById(R.id.radioButton4);
        final RadioButton radioButton5 = (RadioButton)view.findViewById(R.id.radioButton5);
        ranage= Comm.range;

        RadioGroup.OnCheckedChangeListener radiogpchange = new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == radioButton1.getId()){
                    ranage = radioButton1.getText().toString();
                }else if(i == radioButton2.getId()){
                    ranage = radioButton2.getText().toString();
                }else if(i == radioButton3.getId()){
                    ranage = radioButton3.getText().toString();
                }else if(i == radioButton4.getId()){
                    ranage = radioButton4.getText().toString();
                }else if(i == radioButton5.getId()){
                    ranage = radioButton5.getText().toString();
                }
                SaveUser(ranage);

            }};
        radioGroup.setOnCheckedChangeListener(radiogpchange);

        if(ranage.equals("全部")){
            radioButton1.setChecked(true);
        }else if(ranage.equals("领导人员")){
            radioButton2.setChecked(true);
        }else if(ranage.equals("其他干部")){
            radioButton3.setChecked(true);
        }else if(ranage.equals("减少人员")){
            radioButton4.setChecked(true);
        }else if(ranage.equals("二线人员")){
            radioButton5.setChecked(true);
        }else{
            radioButton2.setChecked(true);
        }
    }

    public void SaveUser(String range) {
        // 获取SharedPreferences对象

        SharedPreferences sp = getActivity().getSharedPreferences("SP", MODE_PRIVATE);
        // 存入数据
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("range", range);
        Comm.range=range;
        editor.commit();
    }

}
