package com.androidchill.nikiizvorski.gson.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidchill.nikiizvorski.gson.R;
import com.androidchill.nikiizvorski.gson.models.ResponcePets;
import com.androidchill.nikiizvorski.gson.models.ResponceRaces;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by NIKI on 7/18/2016.
 */
public class PetsAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private List<ResponcePets.PetsBean> mPetsItems;

    public PetsAdapter(Context aContext, List<ResponcePets.PetsBean> PetItems) {
       this.mContext = aContext;
        this.mPetsItems = PetItems;
    }


    @Override
    public int getCount() {
        return mPetsItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mPetsItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mPetsItems.get(position).getCreatureId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.each_list_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        ResponcePets.PetsBean petitem = (ResponcePets.PetsBean) getItem(position);

        holder.title.setText(petitem.getName());
        holder.rating.setText(petitem.getCreatureId());
        Picasso.with(mContext).load(petitem.getIcon()).into(holder.thumbnail);

        return convertView;
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
