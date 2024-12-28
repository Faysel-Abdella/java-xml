package com.example.carwash.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.carwash.fragments.FragementFrame234;
import com.example.carwash.fragments.FragmentFrame233;
import com.example.carwash.fragments.FragmentFrame235;
import com.example.carwash.fragments.FragmentFrame242;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private final int NUM_TABS = 5;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FragmentFrame233();
            case 1:
                return new FragmentFrame235();
            case 2:
                return new FragmentFrame242();
            case 3:
                return new FragementFrame234();
//            case 4:
//                return new InfoFragment();
            default:
                return new FragmentFrame233();
        }
    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }
}