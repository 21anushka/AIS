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
public class CustomSwipeAdapter2 extends PagerAdapter {
    private int[] image_resource={R.drawable.pic2a,R.drawable.pic2b,R.drawable.pic2c,R.drawable.pic2d,R.drawable.pic2e,R.drawable.pic2f,
            R.drawable.pic2g,R.drawable.pic2h,R.drawable.pic2i,R.drawable.pic2j,R.drawable.pic2k,R.drawable.pic2l,R.drawable.pic2m,
            R.drawable.pic2n,R.drawable.pic2o,R.drawable.pic2p,R.drawable.pic2r,R.drawable.pic2s,R.drawable.pic2t,R.drawable.pic2u,
            R.drawable.pic2v,R.drawable.pic2w,R.drawable.pic2x};
    private Context ctx;
    private LayoutInflater layoutInflater;
    public CustomSwipeAdapter2(Context ctx){this.ctx=ctx;}

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
        layoutInflater=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view=layoutInflater.inflate(R.layout.swipe_layout2,container,false);
        ImageView preview2=(ImageView)item_view.findViewById(R.id.image_view2);
        preview2.setImageResource(image_resource[position]);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
