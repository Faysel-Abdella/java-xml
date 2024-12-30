package com.example.carwash;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;
import com.example.carwash.Adapter.ViewPagerAdapter;
import com.example.carwash.fragments.FragmentFrame235;
import com.example.carwash.fragments.FragmentFrame236;
import com.example.carwash.fragments.FragmentFrame237;
import com.example.carwash.fragments.FragmentFrame242;
import com.example.carwash.fragments.FragmentFrame243;
import com.example.carwash.fragments.FragmentFrame244;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeFragment extends AppCompatActivity
        implements FragmentFrame235.OnFragmentInteractionListener,
        FragmentFrame236.OnFragmentInteractionListener,
        FragmentFrame242.OnFragmentInteractionListener,
        FragmentFrame243.OnFragmentInteractionListener,
        FragmentFrame237.OnFragmentInteractionListener,
        FragmentFrame244.OnFragmentInteractionListener
         {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private ViewPagerAdapter adapter;
    private String[] tabTitles = new String[]{"시스템", "화면", "세차기", "매출", "정보"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_fragment);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        // Link TabLayout and ViewPager2
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(tabTitles[position])).attach();

        // Set tab spacing
        ViewGroup slidingTabStrip = (ViewGroup) tabLayout.getChildAt(0);
        for (int i = 0; i < slidingTabStrip.getChildCount(); i++) {
            View tab = slidingTabStrip.getChildAt(i);
            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) tab.getLayoutParams();
            int marginEnd = (int) (60 * getResources().getDisplayMetrics().density);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR1) {
                layoutParams.setMarginEnd(marginEnd);
            } else {
                layoutParams.rightMargin = marginEnd;
            }
            tab.setLayoutParams(layoutParams);
        }

        // Add tab selected listener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getCustomView() == null) {
                    TextView textView = new TextView(HomeFragment.this);
                    textView.setTextAppearance(HomeFragment.this, R.style.CustomTabTextSelected);
                    textView.setText(tab.getText());
                    tab.setCustomView(textView);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab.getCustomView() != null) {
                    tab.setCustomView(null);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        // Select first tab initially
        TabLayout.Tab firstTab = tabLayout.getTabAt(0);
        if (firstTab != null) {
            firstTab.select();
        }

        // Handle back stack changes to manage visibility of ViewPager2 and fragment container
        getSupportFragmentManager().addOnBackStackChangedListener(() -> {
            if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                viewPager.setVisibility(View.VISIBLE);
                findViewById(R.id.fragment_container).setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onFragmentChange(Fragment fragment) {
        // Hide the ViewPager2 and show the fragment container
        viewPager.setVisibility(View.GONE);
        findViewById(R.id.fragment_container).setVisibility(View.VISIBLE);

        // Replace the fragment within the fragment_container
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}