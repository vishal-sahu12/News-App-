package com.example.mynews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    String api = "9e28fceeb1f945e89d4d1cc68ab6c905";

    Toolbar mainToolbar;
    TabItem home,health,science,entertainment,bussiness,sports,technology;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainToolbar = findViewById(R.id.toolbar_main);
        home = findViewById(R.id.home_tab);
        health = findViewById(R.id.health_tab);
        science = findViewById(R.id.science_tab);
        entertainment = findViewById(R.id.entertainment_tab);
        bussiness = findViewById(R.id.bussiness_tab);
        sports = findViewById(R.id.sportd_tab);
        technology = findViewById(R.id.technology_tab);
        tabLayout = findViewById(R.id.tablayout_main);
        viewPager = findViewById(R.id.viewPager_container);

        PagerAdapter pagerAdapter = new PageAdapter(getSupportFragmentManager(),7);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());{
                    if (tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5||tab.getPosition()==6);
                    {
                        pagerAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


    }
}