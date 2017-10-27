package com.example.charles.maketabs;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private final String[] PAGE_TITLES = new String[] {
            "아레나",
            "카드덱",
            "내정보",
            "상자",
            "레벨"
    };

    private final Fragment[] PAGES = new Fragment[] {
            new Fragment1(),
            new Fragment2(),
            new Fragment3(),
            new Fragment4(),
            new Fragment5()
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager mViewPager = findViewById(R.id.viewpager);
        mViewPager.setAdapter(new MyPagerAdapter(getFragmentManager()));

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewPager);
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PAGES[position];
        }

        @Override
        public int getCount() {
            return PAGES.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return PAGE_TITLES[position];
        }
    }
}
