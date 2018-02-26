package com.telkom.siborder;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private SectionPagerAdapter mSectionpageAdap;
    private Fragment fragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionPagerAdapter mSectionpageAdapter = new SectionPagerAdapter(getSupportFragmentManager());

        final ViewPager mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        final TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.getTabAt(0).setText(R.string.tab_node);
        tabLayout.getTabAt(1).setText(R.string.tab_map);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.home:

                        break;
                    case R.id.ongoing:
                        Intent intent1 = new Intent(MainActivity.this, OngoingActivity.class);
                        startActivity(intent1);
                        overridePendingTransition(0, 0);
                        break;

                    case R.id.inventory:
                        Intent intent3 = new Intent(MainActivity.this, InvActivity.class);
                        startActivity(intent3);
                        overridePendingTransition(0, 0);
                        break;

                    case R.id.mail:
                        Intent intent4 = new Intent(MainActivity.this, MailActivity.class);
                        startActivity(intent4);
                        overridePendingTransition(0, 0);
                        break;
                }
                return false;
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment());
        adapter.addFragment(new MapFragment());
        viewPager.setAdapter(adapter);
    }
}