package com.example.ashish.railtellapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Tushar on 10/05/16.
 */
public class CustomSwipeAdapter1 extends PagerAdapter {
    private int[] image_resource={R.drawable.pic1a,R.drawable.pic1b,R.drawable.pic1c,R.drawable.pic1d,R.drawable.pic1e,R.drawable.pic1f,
            R.drawable.pic1g,R.drawable.pic1h,R.drawable.pic1i,R.drawable.pic1j,R.drawable.pic1k,R.drawable.pic1l,R.drawable.pic1m,R.drawable.pic1n,
            R.drawable.pic1o,R.drawable.pic1p,R.drawable.pic1q,R.drawable.pic1r,R.drawable.pic1s,R.drawable.pic1t,R.drawable.pic1u,R.drawable.pic1v,
            R.drawable.pic1w};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public CustomSwipeAdapter1(Context ctx)
    {
        this.ctx=ctx;
    }
    @Override
    public int getCount() {
        return image_resource.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {

        return (view==(LinearLayout)o);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater =(LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view=layoutInflater.inflate(R.layout.swipe_layout1,container,false);
        ImageView imageView=(ImageView)item_view.findViewById(R.id.image_view1);
        imageView.setImageResource(image_resource[position]);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
