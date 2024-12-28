package com.example.carwash;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.carwash.Adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeFragment extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private ViewPagerAdapter adapter;
    private  String[] tabTitles = new String[]{"시스템", "화면", "세차기", "매출", "정보"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_fragment);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        // Link TabLayout and ViewPager2
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            tab.setText(tabTitles[position]);
        }).attach();

        // Set tab spacing
        ViewGroup slidingTabStrip = (ViewGroup) tabLayout.getChildAt(0);
        for (int i = 0; i < slidingTabStrip.getChildCount() - 1; i++) {
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

        // Center the tab indicator
        tabLayout.post(() -> {
            try {
                ViewGroup slidingTabStrip2 = (ViewGroup) tabLayout.getChildAt(0);
                int tabWidth = slidingTabStrip2.getChildAt(0).getWidth();
                View tabIndicator = ((ViewGroup) slidingTabStrip2.getChildAt(0)).getChildAt(1);
                ViewGroup.LayoutParams layoutParams = tabIndicator.getLayoutParams();
                layoutParams.width = tabWidth / 3;
                tabIndicator.setLayoutParams(layoutParams);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}