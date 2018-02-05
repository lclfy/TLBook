package com.example.shenxm.tlbook.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.shenxm.tlbook.Comm;
import com.example.shenxm.tlbook.Dal.PersonsDal;
import com.example.shenxm.tlbook.Model.JianliModel;
import com.example.shenxm.tlbook.Model.XlxxModel;
import com.example.shenxm.tlbook.R;
import com.mingle.widget.ShapeLoadingDialog;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private String[] rybmlist;
    private ArrayList<String> jlArraylist = new ArrayList<String>();
    private int i;
    private static Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_detail);
        final LinearLayout returnBtn = (LinearLayout) findViewById(R.id.back_button);
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent in = new Intent();
                in.setClass(DetailActivity.this,Main2Activity.class);
                startActivity(in);*/
                returnBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                finish();
                /*//jump to Login page
                DetailActivity.this.startActivity(new Intent(DetailActivity.this,Main2Activity.class));
                //finish this page
                DetailActivity.this.finish();*/
            }
        });

        final TextView name = (TextView) findViewById(R.id.NametextView2);
        final TextView gender = (TextView) findViewById(R.id.GendertextView4);
        final TextView dob = (TextView) findViewById(R.id.dobtextView6);
        final TextView mingzu = (TextView) findViewById(R.id.MinZutextView4);
        final TextView jiguan = (TextView) findViewById(R.id.JiguantextView7);
        final TextView rdzj = (TextView) findViewById(R.id.rdsjtextView9);
        final TextView cjgzsj = (TextView) findViewById(R.id.cjgzsjtextView7);
        final TextView zyjszw = (TextView) findViewById(R.id.zyjszwtextView10);
        final TextView jzsj = (TextView) findViewById(R.id.jzsjtextView12);
        final TextView xrzw = (TextView) findViewById(R.id.xrzwtextView10);

        final TextView qrzjy = (TextView) findViewById(R.id.qrzjytextView14);
        final TextView zzjy = (TextView) findViewById(R.id.zzjytextView15);
        final TextView qrzyx = (TextView) findViewById(R.id.qrzyxtextView18);
        final TextView zzjyx = (TextView) findViewById(R.id.zzyxtextView19);

        final TextView jtTextview = (TextView)findViewById(R.id.textView15);

        final ScrollView scrollView = (ScrollView)findViewById(R.id.scrollView);
        scrollView.fullScroll(ScrollView.FOCUS_UP);

        final TextView jl = (TextView) findViewById(R.id.jltextView15);

        ListView jtcyList = (ListView)findViewById(R.id.jtcyListView1);

        final ImageView iv = (ImageView)findViewById(R.id.imageView);
        final TextView khqkTextView = (TextView)findViewById(R.id.khtextView15);
        final TextView khsjTextView = (TextView)findViewById(R.id.khsjtextView22);
        final TextView ryxxTextView = (TextView)findViewById(R.id.ryxxtextView22);
//
//        final ZhuyaoXXModel detailZhuyaoXX = PersonsDal.getDetailXX(Comm.myModel._id);
        String xrzwstr = PersonsDal.getXrzwDetail(Comm.myModel.get_id());
        XlxxModel xlxxModel = PersonsDal.getXlxx(Comm.myModel.get_id());
        ArrayList<JianliModel> jianliModelArrayList = PersonsDal.getJianli(Comm.myModel.get_id());
        Cursor cur = PersonsDal.getJtcyCursor(Comm.myModel.get_id());
        Cursor khcur = PersonsDal.getKaoheCursor(Comm.myModel.get_id());
        if (Comm.myModel != null) {
            name.setText(Comm.myModel.getXM());
            gender.setText(Comm.myModel.getXBHZ());
            dob.setText(Comm.myModel.getCSRQ());
            mingzu.setText(Comm.myModel.getMZHZ());
            jiguan.setText(Comm.myModel.getJG());
            rdzj.setText(Comm.myModel.getJRDPRQ());
            cjgzsj.setText(Comm.myModel.getCJGZRQ());
            zyjszw.setText(Comm.myModel.getZCMCHZ());
            String jzsjStr = "";
            if(Comm.myModel.getXJSZWRQ() != null || Comm.myModel.getRXZRQ() != null){
            if (Comm.myModel.getXJSZWRQ() != null) {
                jzsjStr += Comm.myModel.getXJSZWRQ().replace("0:00:00", "");
            }
            if (Comm.myModel.getRXZRQ() != null) {
                jzsjStr += "\n" + Comm.myModel.getRXZRQ();
            }
            jzsj.setText(jzsjStr);
            }else if(Comm.myModel.getXJSZWRQ()==null || Comm.myModel.getRXZRQ()==null){
                jzsj.setText("");
            }
            ryxxTextView.setText(Comm.myModel.getXM() + "    " + Comm.myModel.getXBHZ() + "    " + Comm.myModel.getCSRQ() + "    ");
            xrzw.setText(xrzwstr);
            ryxxTextView.setText(ryxxTextView.getText() + xrzwstr);
            qrzjy.setText(xlxxModel.getQrzjy() + "\n" + xlxxModel.getQrzwhcd());
            zzjy.setText(xlxxModel.getZzjy() + "\n" + xlxxModel.getZzwhcd());
            qrzyx.setText(xlxxModel.getQrzyx() + "\n" + xlxxModel.getQrzzy());
            zzjyx.setText(xlxxModel.getZzyx() + "\n" + xlxxModel.getZzzy());

            if (jianliModelArrayList.size() != 0) {
                String jlContent = "";
                for (int i = 0; i < jianliModelArrayList.size(); i++) {
                    jlContent = jianliModelArrayList.get(i).getQsrq();
                    if (jianliModelArrayList.get(i).getZzrq() == null) {
                        jlContent = jlContent + " -   今       ";
                    } else {
                        jlContent = jlContent + " - " + jianliModelArrayList.get(i).getZzrq();
                    }
                    jlContent = jlContent + "    " + jianliModelArrayList.get(i).getBDMS() + "\n";
                    //System.out.println(jlContent);
                    jlArraylist.add(jlContent);
                }
                for (int i = 0; i < jlArraylist.size(); i++) {
                    jl.append(jlArraylist.get(i));
                }
            }//jianli over

            //jtcy
            //创建SimpleCursorAdapter适配器将数据绑定到item显示控件上
            //1dp *1.5 为layoutparams 的单位
            jtTextview.setLayoutParams(new LinearLayout.LayoutParams(170, (cur.getCount() + 2) * 120));
            if (cur != null) {
                if (cur.moveToFirst()) {
                    System.out.println("Jtcy cur"+ cur.getCount());
                    SimpleCursorAdapter adapter = new SimpleCursorAdapter(DetailActivity.this, R.layout.jtcylistview, cur, new String[]{"_id", "HZMC", "CYXM", "CYRQ", "ZZMM", "CYGZDW"}, new int[]{R.id._id, R.id.hzmc, R.id.cyxm, R.id.nl, R.id.zzmm, R.id.cygzdw});
                    jtcyList = setListViewHeightBasedOnChildren(jtcyList,adapter);
                    jtcyList.setAdapter(adapter);
                }
            }

            //zhao pian
            iv.setImageBitmap(PersonsDal.getBmp(Comm.myModel.get_id()));


            //kao he
            if (khcur != null) {
        if (khcur.moveToFirst()) {
            //System.out.println("khcur " + khcur.getCount());
            String kcsj = khcur.getString(khcur.getColumnIndex("KCSJ"));
            String mzcp = khcur.getString(khcur.getColumnIndex("KCQK"));
            String kccl = khcur.getString(khcur.getColumnIndex("KCCL"));
            String kclb = khcur.getString(khcur.getColumnIndex("KCLB"));
            if(mzcp==null){
                mzcp="";
            }if(kccl==null){
                kccl="";
            }if(kclb==null){
                kclb="";
            }if(kcsj==null){
                kcsj="暂无考核";
            }
            if(kcsj==null && kclb == null && kccl == null && mzcp == null){
                kcsj = "暂无考核";
                kccl = "暂无考核";
            }

            kclb = PersonsDal.convertLB(kclb);
            khsjTextView.setText(kcsj.replace("null","") + "\n" + kclb.replace("null",""));
            khqkTextView.setText(kccl.replace("null","") + "\n" + mzcp.replace("null",""));
        }
    }

}
}

    @Override
    protected void onResume() {
        /**
         * 设置为横屏
         */
        if(getRequestedOrientation()!=ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        super.onResume();
    }

    public static ListView setListViewHeightBasedOnChildren(ListView listView, ListAdapter listAdapter) {
        //设置list高度
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();

        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        return listView;
    }


}
