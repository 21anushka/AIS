package com.example.ashish.railtellapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Tushar on 11/05/16.
 */
public class CustomSwipeAdapter3 extends PagerAdapter {
    private int[] image_resource={R.drawable.pic3a,R.drawable.pic3b,R.drawable.pic3c,R.drawable.pic3d,R.drawable.pic3e,R.drawable.pic3f,
            R.drawable.pic3g,R.drawable.pic3h,R.drawable.pic3i,R.drawable.pic3j};
    private Context ctx;
    private LayoutInflater layoutInflater;
    public CustomSwipeAdapter3(Context ctx){this.ctx=ctx;}

    @Override
    public int getCount() {
        return image_resource.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater =(LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view=layoutInflater.inflate(R.layout.swipe_layout3,container,false);
        ImageView imageview3=(ImageView)item_view.findViewById(R.id.image_view3);
        imageview3.setImageResource(image_resource[position]);
        container.addView(item_view);
        return item_view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
