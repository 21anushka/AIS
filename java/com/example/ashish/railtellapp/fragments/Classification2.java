package com.example.ashish.railtellapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ashish.railtellapp.R;
import com.example.ashish.railtellapp.fragments.tabs.District;
import com.example.ashish.railtellapp.fragments.tabs.Tehsil;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Ashish
 * @since 10/14/2016
 */
public class Classification2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.classification2_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText("Campusplan"));
        tabLayout.addTab(tabLayout.newTab().setText("Raumplan"));
        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        tabLayout.setupWithViewPager(viewPager);
        FragmentManager m = new FragmentManager() {
            @Override
            public FragmentTransaction beginTransaction() {
                return null;
            }

            @Override
            public boolean executePendingTransactions() {
                return false;
            }

            @Override
            public android.support.v4.app.Fragment findFragmentById(@IdRes int id) {
                return null;
            }

            @Override
            public android.support.v4.app.Fragment findFragmentByTag(String tag) {
                return null;
            }

            @Override
            public void popBackStack() {

            }

            @Override
            public boolean popBackStackImmediate() {
                return false;
            }

            @Override
            public void popBackStack(String name, int flags) {

            }

            @Override
            public boolean popBackStackImmediate(String name, int flags) {
                return false;
            }

            @Override
            public void popBackStack(int id, int flags) {

            }

            @Override
            public boolean popBackStackImmediate(int id, int flags) {
                return false;
            }

            @Override
            public int getBackStackEntryCount() {
                return 0;
            }

            @Override
            public BackStackEntry getBackStackEntryAt(int index) {
                return null;
            }

            @Override
            public void addOnBackStackChangedListener(OnBackStackChangedListener listener) {

            }

            @Override
            public void removeOnBackStackChangedListener(OnBackStackChangedListener listener) {

            }

            @Override
            public void putFragment(Bundle bundle, String key, android.support.v4.app.Fragment fragment) {

            }

            @Override
            public android.support.v4.app.Fragment getFragment(Bundle bundle, String key) {
                return null;
            }

            @Override
            public List<android.support.v4.app.Fragment> getFragments() {
                return null;
            }

            @Override
            public android.support.v4.app.Fragment.SavedState saveFragmentInstanceState(android.support.v4.app.Fragment f) {
                return null;
            }

            @Override
            public boolean isDestroyed() {
                return false;
            }

            @Override
            public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {

            }
        };
        viewPager.setAdapter(new PagerAdapter
                (m, tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public class PagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

      //  public PagerAdapter(FragmentManager fm, int NumOfTabs) {

      //  }

        public PagerAdapter(FragmentManager fm, int tabCount) {
            super(fm);
            this.mNumOfTabs = tabCount;
        }


        @Override
        public android.support.v4.app.Fragment getItem(int position) {

            switch (position) {
                case 0:
                    District tab1 = new District();
                    return tab1;
                case 1:
                    Tehsil tab2 = new Tehsil();
                    return tab2;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }
}
