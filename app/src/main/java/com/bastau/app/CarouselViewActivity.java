package com.bastau.app;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.bastau.app.ui.adapters.FragmentPager;
import com.bastau.app.ui.fragments.ImageFragmentFifth;
import com.bastau.app.ui.fragments.ImageFragmentFirst;
import com.bastau.app.ui.fragments.ImageFragmentFourth;
import com.bastau.app.ui.fragments.ImageFragmentSecond;
import com.bastau.app.ui.fragments.ImageFragmentSeventh;
import com.bastau.app.ui.fragments.ImageFragmentSixth;
import com.bastau.app.ui.fragments.ImageFragmentThird;

public class CarouselViewActivity extends MvpAppCompatActivity {

    int[] sampleImages = {R.drawable.image_one, R.drawable.image_two, R.drawable.image_one,
            R.drawable.image_two, R.drawable.image_one, R.drawable.image_two, R.drawable.image_one};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carousel);

        ViewPager viewPager = findViewById(R.id.photos_viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);
    }

    private void setupViewPager(ViewPager viewPager) {
        FragmentPager adapter = new FragmentPager(getSupportFragmentManager());
        adapter.addFragment(new ImageFragmentFirst());
        adapter.addFragment(new ImageFragmentSecond());
        adapter.addFragment(new ImageFragmentThird());
        adapter.addFragment(new ImageFragmentFourth());
        adapter.addFragment(new ImageFragmentFifth());
        adapter.addFragment(new ImageFragmentSixth());
        adapter.addFragment(new ImageFragmentSeventh());
        viewPager.setAdapter(adapter);
    }

}
