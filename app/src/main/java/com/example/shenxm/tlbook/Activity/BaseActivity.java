package com.example.shenxm.tlbook.Activity;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.shenxm.tlbook.Fragment.MainFragment;
import com.example.shenxm.tlbook.Fragment.SearchFragment;
import com.example.shenxm.tlbook.Fragment.SettingFragment;
import com.example.shenxm.tlbook.R;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    public Fragment mainFragment = new Fragment();
    public Fragment searchFragment = new Fragment();
    public Fragment settingFragment = new Fragment();
    public Fragment fragment;
    //声明ViewPager
    private ViewPager mViewpager;

    private LinearLayout mTabMain;
    private LinearLayout mTabSearch;
    private LinearLayout mTabSetting;

    private LinearLayout mBackgroundMain;
    private LinearLayout mBackgroundSearch;
    private LinearLayout mBackgroundSetting;

    private ImageView mainSideLight;
    private ImageView searchSideLight;
    private ImageView settingSideLight;

    private FragmentManager manager;
    private FragmentTransaction transaction;

    //其他Activity内带的界面元素
    public GridView xt_gview;
    public GridView dw_gview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_base);
        initViews();//初始化控件
        initEvents();//初始化事件
        selectTab(0);//默认选中第一个Tab
    }

    private void initEvents() {
        //初始化四个Tab的点击事件
        mTabMain.setOnClickListener(this);
        mTabSearch.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);
    }

    private void initViews() {
        mTabMain = (LinearLayout) findViewById(R.id.mainTab);
        mTabSearch = (LinearLayout) findViewById(R.id.searchTab);
        mTabSetting = (LinearLayout) findViewById(R.id.settingTab);

        mainSideLight = (ImageView) findViewById(R.id.mainSideLight);
        searchSideLight = (ImageView) findViewById(R.id.searchSideLight);
        settingSideLight = (ImageView) findViewById(R.id.settingSideLight);

        mBackgroundMain = (LinearLayout) findViewById(R.id.menu_content);
        mBackgroundSearch = (LinearLayout) findViewById(R.id.search_content);
        mBackgroundSetting = (LinearLayout) findViewById(R.id.setting_content);

        //获取FragmentManager对象
        manager = getSupportFragmentManager();
        //获取FragmentTransaction对象
        transaction = manager.beginTransaction();
        mainFragment = new MainFragment();
        transaction.add(R.id.id_content, mainFragment);
        searchFragment = new SearchFragment();
        transaction.add(R.id.id_content, searchFragment);
        settingFragment = new SettingFragment();
        transaction.add(R.id.id_content, settingFragment);

    }

    //处理Tab的点击事件
    @Override
    public void onClick(View v) {
        transaction = manager.beginTransaction();
        switch (v.getId()) {
            case R.id.mainTab:
                selectTab(0);
                break;
            case R.id.searchTab:
                selectTab(1);
                break;
            case R.id.settingTab:
                selectTab(2);
                break;
        }

    }

    //进行选中Tab的处理
    private void selectTab(int i) {

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
                mainSideLight.setVisibility(View.VISIBLE);
                mBackgroundMain.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                transaction.show(mainFragment);
                break;
            case 1:
                searchSideLight.setVisibility(View.VISIBLE);
                mBackgroundSearch.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                transaction.show(searchFragment);
                break;
            case 2:
                settingSideLight.setVisibility(View.VISIBLE);
                mBackgroundSetting.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                transaction.show(settingFragment);
                break;
        }
        //不要忘记提交事务
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
    }

}
