package com.example.barun.swapscreen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
      this.context = context;
    }
   public int[] slide_imageIcons = {
           R.drawable.firstscreensavingsicon,
           R.drawable.secondscreensavingsicon,
           R.drawable.thirdscreenicon,
           R.drawable.fourthscreenicon
    };
   public int[] slide_imageSlogans = {
           R.drawable.fsdisplaytextone,
           R.drawable.seconsscreenslogan,
           R.drawable.thirdscreenslogan,
           R.drawable.fourthscreenslogan
    };
    public String[] slide_headings ={

            "First",
            "Second",
            "Third",
            "Foorth"
    };
    @Override
    public int getCount() {
        return slide_headings.length;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {

        return view ==(RelativeLayout)o;
    }
    @NonNull
    @Override
    public Object instantiateItem( ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container,false);

        ImageView slideImageIconView = (ImageView)view.findViewById(R.id.ivFirstScreenIcon);
        ImageView slideImageSloganView = (ImageView)view.findViewById(R.id.ivFirstScreenSlogan);
        //TextView textView =(TextView)slideview.findViewById(slide_headings);

        slideImageIconView.setImageResource(slide_imageIcons[position]);
        slideImageSloganView.setImageResource(slide_imageSlogans[position]);
        container.addView(view);
        return  view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
