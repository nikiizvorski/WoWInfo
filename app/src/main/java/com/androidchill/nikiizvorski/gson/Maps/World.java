package com.androidchill.nikiizvorski.gson.Maps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.androidchill.nikiizvorski.gson.Maps.Draenor;
import com.androidchill.nikiizvorski.gson.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class World extends AppCompatActivity {

    @Bind(R.id.button)
    Button draenor;
    @Bind(R.id.button2)
    Button azeroth;
    @Bind(R.id.button3)
    Button kalimdor;

    @OnClick(R.id.button)
    public void submit() {
        Intent d = new Intent(this, Draenor.class);
        startActivity(d);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world);
        ButterKnife.bind(this);

    }

}
