package com.example.mynews;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mynews.Fragment.BussinessFragment;
import com.example.mynews.Fragment.EntertainmentFragment;
import com.example.mynews.Fragment.HealthFragment;
import com.example.mynews.Fragment.HomeFragment;
import com.example.mynews.Fragment.ScienceFragment;
import com.example.mynews.Fragment.SportsFragment;
import com.example.mynews.Fragment.TechnologyFragment;

public class PageAdapter extends FragmentPagerAdapter {
    int tabCount;

    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
                case 1:
                return new HealthFragment();
                case 2:
                return new ScienceFragment();
                case 3:
                return new TechnologyFragment();
                case 4:
                return new BussinessFragment();
                case 5:
                return new EntertainmentFragment();
                case 6:
                return new SportsFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
