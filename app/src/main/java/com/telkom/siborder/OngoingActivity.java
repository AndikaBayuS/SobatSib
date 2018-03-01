package com.telkom.siborder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class OngoingActivity extends AppCompatActivity {

    private SectionPagerAdapter mSectionpageAdap;
    private Fragment fragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ongoing);

        final ViewPager mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        final TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.getTabAt(0).setText(R.string.tab_newlink);
        tabLayout.getTabAt(1).setText(R.string.tab_up);
        tabLayout.getTabAt(2).setText(R.string.tab_collo);
        tabLayout.getTabAt(3).setText(R.string.tab_fiber);
        tabLayout.getTabAt(4).setText(R.string.tab_swap);
        tabLayout.getTabAt(5).setText(R.string.tab_sr);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.home:
                        Intent intent0 = new Intent(OngoingActivity.this, MainActivity.class);
                        startActivity(intent0);
                        overridePendingTransition(0, 0);
                        break;

                    case R.id.inventory:
                        Intent intent3 = new Intent(OngoingActivity.this, InvActivity.class);
                        startActivity(intent3);
                        overridePendingTransition(0, 0);
                        break;

                    case R.id.mail:
                        Intent intent4 = new Intent(OngoingActivity.this, MailActivity.class);
                        startActivity(intent4);
                        overridePendingTransition(0, 0);
                        break;
                }
                return false;
            }
        });
    }

    private void setupViewPager(ViewPager mViewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new NewLFragment());
        adapter.addFragment(new UpFragment());
        adapter.addFragment(new ColloFragment());
        adapter.addFragment(new FiberizationFragment());
        adapter.addFragment(new Tab1Fragment());
        adapter.addFragment(new Tab1Fragment());
        mViewPager.setAdapter(adapter);
    }
}
