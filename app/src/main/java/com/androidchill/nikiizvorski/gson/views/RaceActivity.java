package com.androidchill.nikiizvorski.gson.views;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidchill.nikiizvorski.gson.R;
import com.androidchill.nikiizvorski.gson.models.MountAPI;
import com.androidchill.nikiizvorski.gson.models.RacesAPI;
import com.androidchill.nikiizvorski.gson.models.ResponceRaces;
import com.androidchill.nikiizvorski.gson.models.Response;
import com.androidchill.nikiizvorski.gson.presenters.CustomAdapter;
import com.androidchill.nikiizvorski.gson.presenters.RacesAdapter;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;
import retrofit2.Callback;

public class RaceActivity extends AppCompatActivity implements OnRefreshListener{

    @Bind(R.id.movielist) ListView listview;
    @Bind(R.id.root) CoordinatorLayout root;
    @Bind(R.id.swipe_refresh_layout) SwipeRefreshLayout swip;
    protected List<ResponceRaces.RacesEntity> mRaces;
    Snackbar snackbar;
    Response responseObj;
    RacesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_races);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        ButterKnife.bind(this);
        swip.setColorSchemeResources(R.color.colorPrimary);
        swip.setOnRefreshListener(this);
        Sample2();


    }

    @Override public void onRefresh() {
        swip.setRefreshing(false);
        if(adapter != null){
            adapter.clear();
            if(!isNetworkAvailable()){
                snackbar = Snackbar
                        .make(root, "No internet connection!", Snackbar.LENGTH_INDEFINITE)
                        .setAction("RETRY", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                onRefresh();
                            }
                        });

                snackbar.setActionTextColor(Color.RED);

                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            } else {
                Sample2();
                if(snackbar != null){
                    snackbar.dismiss();
                }
            }
            adapter.notifyDataSetChanged();
        }
    }


    public void goPro (String ur) {
        Dialog dialog = new Dialog(RaceActivity.this);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        //dialog.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        dialog.setContentView(R.layout.go_pro_dialog_layout);

        ImageView image = (ImageView) dialog.findViewById(R.id.goProDialogImage);
        Picasso.with(RaceActivity.this).load(ur).into(image);
        dialog.show();
    }

    public void Sample2 () {
        RacesAPI.Factory.getIstance().getRaces().enqueue(new Callback<ResponceRaces>() {
            @Override
            public void onResponse(final retrofit2.Response<ResponceRaces> response) {
                adapter = new RacesAdapter(RaceActivity.this, response.body().getRaces());
                listview.setAdapter(adapter);

                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        //Get Id of object
                        //String objectid = response.body().getRaces().get(position).getName();

                        //String mounticon = response.body().getRaces().get(position).getSide();

                        //goPro(mountpic);

                        //Toast.makeText(MainActivity.this, objectid.toString(), Toast.LENGTH_SHORT).show();
                        //Toast.makeText(MainActivity.this, mounticon.toString(), Toast.LENGTH_SHORT).show();

                        //Intent goToMounts = new Intent(MainActivity.this, MountActivity.class);
                        // goToMounts.putExtra("icon", mounticon);
                        // goToMounts.putExtra("id", objectid);
                        //  startActivity(goToMounts);

                    }
                });
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("FAILED", t.getMessage());
            }
        });
    }

    private Boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
