package com.example.barun.swapscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotsLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;
    private TextView[] mGuide;
    private TextView mNext, mEnd, mSkip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Map the Butttons now...

        mNext = (TextView) findViewById(R.id.next);
        mEnd = (TextView) findViewById(R.id.end);
        mSkip = (TextView) findViewById(R.id.skip);

        mSlideViewPager = (ViewPager)findViewById(R.id.id_viewpager);
        mDotsLayout = (LinearLayout)findViewById(R.id.mDotsLayout);
        sliderAdapter = new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        //addButtonIndicator(0);
        buttonVisibilityManager(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mSlideViewPager.getCurrentItem()+1, true);
            }
            });

        mSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogInScreenActivity();
            }
        });

        mEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogInScreenActivity();
            }
        });

        }

    private void openLogInScreenActivity() {
        Intent intent = new Intent(this, LogIn_Activity.class);
        startActivity(intent);
    }


    public void buttonVisibilityManager(int position){
            switch (position)
            {
                case 0:
                     mEnd.setVisibility(View.GONE);
                    mSkip.setVisibility(View.VISIBLE);
                    mNext.setVisibility(View.VISIBLE);
                    break;
               case 3:
                    mEnd.setVisibility(View.VISIBLE);
                    mSkip.setVisibility(View.VISIBLE);
                    mNext.setVisibility(View.GONE);
                    break;
                default:
                    mEnd.setVisibility(View.GONE);
                    mSkip.setVisibility(View.VISIBLE);
                    mNext.setVisibility(View.VISIBLE);
                    break;
              }

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
    public void addButtonIndicator(int position) {

        mGuide = new TextView[2];
        mDotsLayout.removeAllViews();
        for (int i = 0; i < 2; i++) {

            mGuide[i] = new TextView(this);
            mGuide[i].setText("Back");
            mGuide[i].setTextSize(35);
            mGuide[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            mDotsLayout.addView(mGuide[i]);
        }
        if(mGuide.length >0)
        {
            mGuide[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }

    }

ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener(){

    @Override
    public void onPageScrolled(int i, float v, int i1) {

        buttonVisibilityManager(i);
    }

    @Override
    public void onPageSelected(int i) {

        addDotsIndicator(i);

    }

    @Override
    public void onPageScrollStateChanged(int i) {
        //buttonVisibilityManager(i);

    }
};


}
