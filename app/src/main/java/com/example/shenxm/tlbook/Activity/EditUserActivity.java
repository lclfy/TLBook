package com.example.shenxm.tlbook.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.shenxm.tlbook.Comm;
import com.example.shenxm.tlbook.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EditUserActivity extends AppCompatActivity {

    String ranage;
    private DrawerLayout drawerLayout;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_edit_user);
//        drawerLayout=(DrawerLayout)findViewById(R.id.v4_drawerlayout);

        Button updateBtn = (Button)findViewById(R.id.button2);
        //progressBar= (ProgressBar) findViewById(R.id.progress                Bar);
        final TextView textView = (TextView)findViewById(R.id.textView25);

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

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        final RadioButton radioButton1 = (RadioButton)findViewById(R.id.radioButton1);
        final RadioButton radioButton2 = (RadioButton)findViewById(R.id.radioButton2);
        final RadioButton radioButton3 = (RadioButton)findViewById(R.id.radioButton3);
        final RadioButton radioButton4 = (RadioButton)findViewById(R.id.radioButton4);
        final RadioButton radioButton5 = (RadioButton)findViewById(R.id.radioButton5);
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

 /*   protected void dialog(){
        AlertDialog.Builder builder  = new AlertDialog.Builder(EditUserActivity.this);
        builder.setMessage("确认升级？升级过程中，不要进行其他操作，直到弹出提示信息");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                try{
                    SoftUpdate manager = new SoftUpdate(EditUserActivity.this);
                    manager.updateDB();

                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String dateString = sdf.format(date);
                    //textView.setText("上次更新时间："+dateString);

                    //System.out.println("Success " +success);

                }
                catch (Exception e){
                    System.out.println("shi bai ");
                }
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();
    }*/
    public String getSave() {

        SharedPreferences sp = getSharedPreferences("SP",
                android.content.Context.MODE_PRIVATE);

        String name = sp.getString("range", "领导人员");
        Comm.range=name;
        return name;
    }

    public void SaveUser(String range) {
        // 获取SharedPreferences对象

        SharedPreferences sp = getSharedPreferences("SP", MODE_PRIVATE);
        // 存入数据
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("range", range);
        Comm.range=range;
        editor.commit();
    }


    private void showDrawerLayout() {
        if (!drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.openDrawer(Gravity.LEFT);
        } else {
            drawerLayout.closeDrawer(Gravity.LEFT);
        }
    }

}
