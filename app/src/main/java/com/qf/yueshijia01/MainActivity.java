package com.qf.yueshijia01;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.qf.yueshijia01.fragment.ColumnFragment;
import com.qf.yueshijia01.fragment.HomepageFragment;
import com.qf.yueshijia01.fragment.InterestFragment;
import com.qf.yueshijia01.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private FrameLayout frameLayout;
    private HomepageFragment homepageFragment;
    private ColumnFragment columnFragment;
    private InterestFragment interestFragment;
    private MineFragment mineFragment;
    private FragmentManager fragmentManager;
    private List<Fragment> fragmentlist;
    private FragmentTransaction ft;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
    }
    private void initFragment(){
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        frameLayout = (FrameLayout) findViewById(R.id.fragment);
        //初始化碎片
        homepageFragment = new HomepageFragment();
        columnFragment = new ColumnFragment();
        interestFragment = new InterestFragment();
        mineFragment = new MineFragment();
        //初始化碎片集合
        fragmentlist = new ArrayList<>();
        fragmentlist.add(homepageFragment);
        fragmentlist.add(columnFragment);
        fragmentlist.add(interestFragment);
        fragmentlist.add(mineFragment);

        fragmentManager = getSupportFragmentManager();
        ft = fragmentManager.beginTransaction();
        ft.add(R.id.fragment,fragmentlist.get(0));
        ft.add(R.id.fragment,fragmentlist.get(1));
        ft.add(R.id.fragment,fragmentlist.get(2));
        ft.add(R.id.fragment,fragmentlist.get(3));
        ft.commit();
        showFragmentAtPosition(0);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_btn_homepage:
                        toolbar.setVisibility(View.VISIBLE);
                        showFragmentAtPosition(0);
                        break;
                    case R.id.radio_btn_column:
                        toolbar.setVisibility(View.VISIBLE);
                        showFragmentAtPosition(1);
                        break;
                    case R.id.radio_btn_topline:
                        toolbar.setVisibility(View.VISIBLE);
                        showFragmentAtPosition(2);
                        break;
                    case R.id.radio_btn_mine:
                        toolbar.setVisibility(View.GONE);
                        showFragmentAtPosition(3);
                        break;
                }
            }
        });
    }

    private void showFragmentAtPosition(int position) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        for (int i = 0; i < fragmentlist.size(); i++) {
            if (i == position) {
                // 显示碎片
                ft.show(fragmentlist.get(i));
            } else {
                // 隐藏碎片
                ft.hide(fragmentlist.get(i));
            }
        }
        ft.commit();
    }
}
