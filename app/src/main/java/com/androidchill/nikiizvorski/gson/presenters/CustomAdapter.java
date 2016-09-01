package com.androidchill.nikiizvorski.gson.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidchill.nikiizvorski.gson.R;
import com.androidchill.nikiizvorski.gson.models.Response;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by nikiizvorski on 1/13/2016.
 */
public class CustomAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private List<Response.MountsEntity> mMovieItem;

    public CustomAdapter(Context mContext, List<Response.MountsEntity> movieItem) {
        this.mContext = mContext;
        mMovieItem = movieItem;
    }

    @Override
    public int getCount() {
        return mMovieItem.size();
    }

    @Override
    public Object getItem(int position) {
        return mMovieItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mMovieItem.get(position).getItemId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.each_list_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        Response.MountsEntity item = (Response.MountsEntity) getItem(position);
        if(item.getQualityId() == 3) {
            holder.title.setTextColor(mContext.getResources().getColor(R.color.rare));
            if(item.isIsFlying()){
                holder.rating.setText("Teaches you how to summon this flying, rare mount.");
            } else {
                holder.rating.setText("Teaches you how to summon this ridable, rare mount.");
            }
            holder.title.setText(item.getName());
        } else {
            holder.title.setTextColor(mContext.getResources().getColor(R.color.epic));
            if(item.isIsFlying()){
                holder.rating.setText("Teaches you how to summon this flying, epic mount.");
            } else {
                holder.rating.setText("Teaches you how to summon this ridable, epic mount.");
            }
            holder.title.setText(item.getName());
        }

        Picasso.with(mContext).load(item.getIcon()).into(holder.thumbnail);

        return convertView;
    }

    public void clear() {
        // TODO Auto-generated method stub
        mMovieItem.clear();

    }

    public List<Response.MountsEntity> getmMovieItem() {
        return mMovieItem;
    }

    static class ViewHolder {
        @Bind(R.id.title)
        TextView title;
        @Bind(R.id.rating)
        TextView rating;
        @Bind(R.id.thumbnail)
        ImageView thumbnail;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
