package com.example.shenxm.tlbook.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.shenxm.tlbook.Adapter.XitongAdapter;
import com.example.shenxm.tlbook.Adapter.DanweiAdapter;
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
    //动画容器
    public ViewGroup sceneRoot;


    List<XitongModel> xitongArrayList;

    XitongAdapter xitongAdapter;
    DanweiAdapter.DanweiClickListener mDanweiClickListener;


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
        sceneRoot = (ViewGroup)view.findViewById(R.id.scene_root);
        xt_gview = (GridView)sceneRoot.findViewById(R.id.xt_gridView);
        dw_gview=(GridView)sceneRoot.findViewById(R.id.dw_gridView);

        xt_gview.setVisibility(View.VISIBLE);
        xitongArrayList= XitongDal.getXitong();
        xitongAdapter=new XitongAdapter(xitongArrayList,getActivity(),this,mDanweiClickListener);
        xt_gview.setAdapter(xitongAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DanweiAdapter.DanweiClickListener) {
            mDanweiClickListener = (DanweiAdapter.DanweiClickListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public String getSave() {

        SharedPreferences sp = getActivity().getSharedPreferences("SP",
                android.content.Context.MODE_PRIVATE);
        String name = sp.getString("range", "领导人员");
        Comm.range=name;
        return name;
    }



}
