package com.example.shenxm.tlbook.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.shenxm.tlbook.Fragment.MainFragment;
import com.example.shenxm.tlbook.Fragment.PersonalInformationFragment;
import com.example.shenxm.tlbook.Fragment.SearchFragment;
import com.example.shenxm.tlbook.Fragment.SettingFragment;
import com.example.shenxm.tlbook.R;
import com.example.shenxm.tlbook.Adapter.DanweiAdapter.DanweiClickListener;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener , DanweiClickListener {

    public Fragment mainFragment;
    public Fragment searchFragment;
    public Fragment settingFragment;
    public Fragment currentFragment;
    public Fragment personalInformationFragment;

    private LinearLayout mTabMain;
    private LinearLayout mTabSearch;
    private LinearLayout mTabSetting;
    private LinearLayout mTabBackButton;

    private LinearLayout mBackgroundMain;
    private LinearLayout mBackgroundSearch;
    private LinearLayout mBackgroundSetting;
    private FrameLayout mContentView;

    private ImageView mainSideLight;
    private ImageView searchSideLight;
    private ImageView settingSideLight;

    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_base);
        initViews();//初始化控件
        initEvents();//初始化事件
        selectTab(0);//默认选中第一个Tab
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

    private void initEvents() {
        //初始化四个Tab的点击事件
        mTabMain.setOnClickListener(this);
        mTabSearch.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);
        mTabBackButton.setOnClickListener(this);
    }

    private void initViews() {
        mTabMain = (LinearLayout) findViewById(R.id.mainTab);
        mTabSearch = (LinearLayout) findViewById(R.id.searchTab);
        mTabSetting = (LinearLayout) findViewById(R.id.settingTab);
        mTabBackButton = (LinearLayout) findViewById(R.id.back_button);

        mTabMain.setVisibility(View.VISIBLE);
        mTabSearch.setVisibility(View.VISIBLE);
        mTabSetting.setVisibility(View.VISIBLE);

        mainSideLight = (ImageView) findViewById(R.id.mainSideLight);
        searchSideLight = (ImageView) findViewById(R.id.searchSideLight);
        settingSideLight = (ImageView) findViewById(R.id.settingSideLight);

        mBackgroundMain = (LinearLayout) findViewById(R.id.menu_content);
        mBackgroundSearch = (LinearLayout) findViewById(R.id.search_content);
        mBackgroundSetting = (LinearLayout) findViewById(R.id.setting_content);
        mContentView = (FrameLayout)findViewById(R.id.id_content);

        //获取FragmentManager对象
        manager = getSupportFragmentManager();
        //获取FragmentTransaction对象
        transaction = manager.beginTransaction();
        mainFragment = new MainFragment();
        transaction.add(R.id.id_content, mainFragment,"mainFragment");
        searchFragment = new SearchFragment();
        transaction.add(R.id.id_content, searchFragment,"searchFragment");
        settingFragment = new SettingFragment();
        transaction.add(R.id.id_content, settingFragment,"settingFragment");
        transaction.commit();
    }

    //处理Tab的点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mainTab:
                if (currentFragment instanceof MainFragment){
                    //主界面下返回
                    returnButtonEvents(0);
                }else {
                    selectTab(0);
                }
                break;
            case R.id.searchTab:
                selectTab(1);
                break;
            case R.id.settingTab:
                selectTab(2);
                break;
            case R.id.back_button:
                //返回按钮
                if (currentFragment instanceof MainFragment){
                    //主界面下返回
                    returnButtonEvents(0);
                }else if (currentFragment instanceof PersonalInformationFragment){
                    returnButtonEvents(1);
                }
                break;
        }

    }

    private void returnButtonEvents(int eventNumber){
        switch (eventNumber){
            case 0:
            {
                Fragment tempFragment;
                GridView mGvDanwei;
                GridView mGvXitong;
                tempFragment = manager.findFragmentByTag("mainFragment");
                ViewGroup sceneRoot = (ViewGroup)findViewById(R.id.scene_root);
                if (tempFragment != null){
                    TransitionManager.beginDelayedTransition(sceneRoot, new Fade());
                    mGvXitong = (GridView) sceneRoot.findViewById(R.id.xt_gridView);
                    mGvDanwei = (GridView)sceneRoot.findViewById(R.id.dw_gridView);

                    mGvDanwei.setVisibility(View.GONE);
                    mGvXitong.setVisibility(View.VISIBLE);

                }else {
                    MainFragment temp_mainFragment = new MainFragment();
                    manager.beginTransaction().add(R.id.id_content,temp_mainFragment).commit();
                }
                break;
            }
            case 1:
            {
                selectTab(0);
                break;
            }
        }

    }

    //进行选中Tab的处理
    private void selectTab(int i) {
        if ((i == 0 && currentFragment == mainFragment) ||
                (i == 1 && currentFragment == searchFragment) ||
                (i == 2 && currentFragment == settingFragment)){
            return;
        }
        transaction = manager.beginTransaction();
        //先隐藏所有的Fragment
        hideFragments(transaction);
        mainSideLight.setVisibility(View.INVISIBLE);
        searchSideLight.setVisibility(View.INVISIBLE);
        settingSideLight.setVisibility(View.INVISIBLE);
        mBackgroundMain.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mBackgroundSearch.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mBackgroundSetting.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        switch (i) {
            case 0:
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
                mainSideLight.setVisibility(View.VISIBLE);
                mBackgroundMain.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                currentFragment = mainFragment;
                transaction.show(mainFragment);
                break;
            case 1:
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                searchSideLight.setVisibility(View.VISIBLE);
                mBackgroundSearch.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                currentFragment = searchFragment;
                transaction.show(searchFragment);
                break;
            case 2:
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                settingSideLight.setVisibility(View.VISIBLE);
                mBackgroundSetting.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                currentFragment = settingFragment;
                transaction.show(settingFragment);
                break;
        }
        transaction.commit();
    }

    //人员信息
    private void selectTab(Bundle selectedItem) {
        transaction = manager.beginTransaction();
        Fragment tempFragment = manager.findFragmentByTag("personalInformationFragment");
        //清除数据
        if (tempFragment != null){
            transaction.remove(tempFragment);
            transaction.commit();
        }
        //先隐藏所有的Fragment
        transaction = manager.beginTransaction();
        hideFragments(transaction);
        personalInformationFragment = new PersonalInformationFragment();
        personalInformationFragment.setArguments(selectedItem);
        transaction.add(R.id.id_content,personalInformationFragment,"personalInformationFragment");
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.show(personalInformationFragment);
        currentFragment = personalInformationFragment;
        transaction.commit();
    }

    //将Fragment隐藏
    private void hideFragments(FragmentTransaction transaction) {
        if (mainFragment != null) {
            transaction.hide(mainFragment);
        }
        if (searchFragment != null) {
            transaction.hide(searchFragment);
        }
        if (settingFragment != null) {
            transaction.hide(settingFragment);
        }
        if (personalInformationFragment != null){
            transaction.hide(personalInformationFragment);
        }

    }

    /*  实现人员信息条目点击方法  */

    @Override
    public void danweiClickListener(View v, Bundle selectedItem) {
        //进入人员信息条目
        selectTab(selectedItem);
    }



}
