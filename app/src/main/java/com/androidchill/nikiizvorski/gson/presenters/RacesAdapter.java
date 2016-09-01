package com.androidchill.nikiizvorski.gson.presenters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidchill.nikiizvorski.gson.R;
import com.androidchill.nikiizvorski.gson.models.ResponceRaces;
import com.androidchill.nikiizvorski.gson.models.Response;
import com.bumptech.glide.Glide;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by nikiizvorski on 1/13/2016.
 */
public class RacesAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private List<ResponceRaces.RacesEntity> mRaceItems;

    public RacesAdapter(Context mContext, List<ResponceRaces.RacesEntity> movieItem) {
        this.mContext = mContext;
        mRaceItems = movieItem;
    }

    @Override
    public int getCount() {
        return mRaceItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mRaceItems.get(position);
    }

    @Override
    public long getItemId(int position) {

        return mRaceItems.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.each_list_item_race, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        ResponceRaces.RacesEntity item = (ResponceRaces.RacesEntity) getItem(position);

        holder.name.setText(item.getName());
        holder.side.setText(item.getSide());
        holder.thumbnail.setScaleType(ImageView.ScaleType.MATRIX);
        Glide.with(mContext).load(item.getImage()).into(holder.thumbnail);
        //Picasso.with(mContext).load(item.getImage()).networkPolicy(NetworkPolicy.OFFLINE).into(holder.thumbnail);
        if (item.getSide().toString().equals("alliance")){
            Glide.with(mContext).load(R.drawable.aliance).into(holder.raceimg);
        } else {
            Glide.with(mContext).load(R.drawable.horde).into(holder.raceimg);
        }


        return convertView;
    }

    public void clear() {
        // TODO Auto-generated method stub
        mRaceItems.clear();

    }


    static class ViewHolder {
        @Bind(R.id.name)
        TextView name;
        @Bind(R.id.side)
        TextView side;
        @Bind(R.id.thumbnail)
        ImageView thumbnail;
        @Bind(R.id.raceimg)
        ImageView raceimg;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
