package com.example.barun.swapscreen;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotsLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mSlideViewPager = (ViewPager)findViewById(R.id.id_viewpager);
        mDotsLayout = (LinearLayout)findViewById(R.id.mDotsLayout);
        sliderAdapter = new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);
        }

    public void addDotsIndicator(int position) {

        mDots = new TextView[4];
        mDotsLayout.removeAllViews();
        for (int i = 0; i < 4; i++) {

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            mDotsLayout.addView(mDots[i]);
        }
        if(mDots.length >0)
        {
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }

    }

ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener(){


    @Override
    public void onPageScrolled(int i, float v, int i1) {


    }

    @Override
    public void onPageSelected(int i) {

        addDotsIndicator(i);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
};


}
