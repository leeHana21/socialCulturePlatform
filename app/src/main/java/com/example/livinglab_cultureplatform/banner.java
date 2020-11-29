//package com.example.livinglab_cultureplatform;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//
//import androidx.annotation.NonNull;
//import androidx.viewpager.widget.PagerAdapter;
//
//public class banner extends PagerAdapter {
//    private int[] images = {R.mipmap.banner_main, R.mipmap.banner2, R.mipmap.banner3};
//    private LayoutInflater inflater;
//    private Context context;
//
//    public banner (Context context) {
//        this.context = context;
//    }
//
//
//    @Override
//    public int getCount() {
//        return images.length;
//    }
//
//    @Override
//    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//        return view == (object);
//    }
//
//    @Override
//    public Object instantiateItem (ViewGroup container, int position) {
//        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = inflater.inflate(R.layout.activity_menu1_home, container, false);
//        ImageView imageView = view.findViewById(R.id.image);
//        imageView.setImageResource(images[position]);
//        container.addView(view);
//        return view;
//
//    }
//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.invalidate();
//    }
//
//
//}