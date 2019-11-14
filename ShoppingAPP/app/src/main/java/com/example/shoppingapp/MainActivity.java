package com.example.shoppingapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.shoppingapp.fragment.CartFragment;
import com.example.shoppingapp.fragment.CategoryFragment;
import com.example.shoppingapp.fragment.FindFragment;
import com.example.shoppingapp.fragment.HomeFragment;
import com.example.shoppingapp.fragment.MineFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.nav_view)
    BottomNavigationView navigationView;

    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new CategoryFragment());
        fragments.add(new FindFragment());
        fragments.add(new CartFragment());
        fragments.add(new MineFragment());

        MainFragmentAdapter adapter = new MainFragmentAdapter(getSupportFragmentManager(),0,fragments);
        mViewPager.setAdapter(adapter);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        mViewPager.setCurrentItem(0,false);
                        break;
                    case R.id.navigation_category:
                        mViewPager.setCurrentItem(1,false);
                        break;
                    case R.id.navigation_find:
                        mViewPager.setCurrentItem(2,false);
                        break;
                    case R.id.navigation_shopping_cart:
                        mViewPager.setCurrentItem(3,false);
                        break;
                    case R.id.navigation_me:
                        mViewPager.setCurrentItem(4,false);
                        break;
                }
                return false;
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                navigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
