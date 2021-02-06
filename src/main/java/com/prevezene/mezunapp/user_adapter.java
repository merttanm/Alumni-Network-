package com.prevezene.mezunapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.List;

public class user_adapter extends PagerAdapter {
    private List<user_model> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public user_adapter(List<user_model> models, LayoutInflater layoutInflater, Context context) {
        this.models = models;
        this.layoutInflater = layoutInflater;
        this.context = context;
    }

    public user_adapter(Context context) {
        this.context = context;
    }

    public user_adapter(List<user_model> models, Context  context) {
        this.models = models;
        this.context = context;

    }


    @Override
    public int getCount() {

        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from( context );
        View view = layoutInflater.inflate(R.layout.item, container, false);

        ImageView imageView;
        TextView title, desc , toolbar_title3,toolbar_title1;

        imageView = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);
        desc = view.findViewById(R.id.desc);
        toolbar_title3= view.findViewById(R.id.toolbar_title3);
        toolbar_title1= view.findViewById(R.id.toolbar_title1);

        imageView.setImageResource(models.get(position).getImage());
        title.setText(models.get(position).getTitle());
        desc.setText(models.get(position).getDesc());
        toolbar_title3.setText(models.get(position).getToolbar_title3());
        toolbar_title1.setText(models.get(position).getToolbar_title1());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("param", models.get(position).getTitle());
                context.startActivity(intent);
                // finish();
            }
        });

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
