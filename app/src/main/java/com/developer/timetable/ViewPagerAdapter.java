package com.developer.timetable;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        DayFragment dayFragment = new DayFragment();
        Bundle bundle = new Bundle();
        bundle.putString("message", "Fragment: " + i);
        dayFragment.setArguments(bundle);
        return dayFragment;
    }

    @Override
    public int getCount() {
        return 6;
    }
}
