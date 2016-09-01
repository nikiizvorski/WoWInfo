package com.androidchill.nikiizvorski.gson.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidchill.nikiizvorski.gson.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NIKI on 7/18/2016.
 */
public class CustomStartAdapter extends BaseAdapter
{
    private List<Item> items = new ArrayList<Item>();
    private LayoutInflater inflater;

    public CustomStartAdapter(Context context)
    {
        inflater = LayoutInflater.from(context);

        items.add(new Item("Characters", R.drawable.shaman));
        items.add(new Item("Mounts", R.drawable.warrior));
        items.add(new Item("Races", R.drawable.warlock));
        items.add(new Item("Pets", R.drawable.shaman));
        items.add(new Item("Bosses", R.drawable.warrior));
        items.add(new Item("Spell", R.drawable.warlock));
        items.add(new Item("Zone", R.drawable.shaman));
        items.add(new Item("Quest", R.drawable.warlock));
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i)
    {
        return items.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return items.get(i).drawableId;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        View v = view;
        ImageView picture;
        TextView name;

        if(v == null)
        {
            v = inflater.inflate(R.layout.content_items, viewGroup, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));
            v.setTag(R.id.text, v.findViewById(R.id.text));
        }

        picture = (ImageView)v.getTag(R.id.picture);
        name = (TextView)v.getTag(R.id.text);

        Item item = (Item)getItem(i);

        picture.setImageResource(item.drawableId);
        name.setText(item.name);

        return v;
    }

    private class Item
    {
        final String name;
        final int drawableId;

        Item(String name, int drawableId)
        {
            this.name = name;
            this.drawableId = drawableId;
        }
    }
}