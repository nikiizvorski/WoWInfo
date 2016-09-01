package com.androidchill.nikiizvorski.gson.views;

import android.app.Dialog;
import android.app.ProgressDialog;
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
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.androidchill.nikiizvorski.gson.models.MountAPI;
import com.androidchill.nikiizvorski.gson.R;
import com.androidchill.nikiizvorski.gson.models.Response;
import com.androidchill.nikiizvorski.gson.presenters.CustomAdapter;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity implements OnRefreshListener{

    @Bind(R.id.movielist) ListView listview;
    @Bind(R.id.root) CoordinatorLayout root;
    @Bind(R.id.swipe_refresh_layout) SwipeRefreshLayout swip;
    protected List<Response.MountsEntity> mDams;
    Snackbar snackbar;
    Response responseObj;
    CustomAdapter adapter;
    AsyncHttpClient client;
    Gson gson;
    String url = "https://eu.api.battle.net/wow/mount/?locale=en_GB&apikey=amd7ujwtgawpy97kswhhk38xsxtbdn2m";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        ButterKnife.bind(this);
        swip.setColorSchemeResources(R.color.colorPrimary);
        swip.setOnRefreshListener(this);
        Sample();


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
                Sample();
                if(snackbar != null){
                    snackbar.dismiss();
                }
            }
            adapter.notifyDataSetChanged();
        }
    }


    public void goPro (String ur) {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.getWindow().getAttributes().windowAnimations = R.style.TransparentProgressDialog;
        //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(R.layout.go_pro_dialog_layout);

        ImageView image = (ImageView) dialog.findViewById(R.id.goProDialogImage);
        Picasso.with(MainActivity.this).load(ur).into(image);
        dialog.show();
    }

    public void Sample2 () {
        final ProgressDialog mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.addContentView(new ProgressBar(this), new CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.WRAP_CONTENT, CoordinatorLayout.LayoutParams.WRAP_CONTENT));
        mProgressDialog.show();
        MountAPI.Factory.getIstance().getMounts().enqueue(new Callback<Response>() {
            @Override
            public void onResponse(final retrofit2.Response<Response> response) {

                if (mProgressDialog.isShowing())
                    mProgressDialog.dismiss();

                adapter = new CustomAdapter(MainActivity.this, response.body().getMounts());
                if(adapter.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "NQMA BACE", Toast.LENGTH_LONG).show();
                }
                listview.setAdapter(adapter);

                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        //Get Id of object
                        String objectid = response.body().getMounts().get(position).getName();

                        String mounticon = response.body().getMounts().get(position).getIcon();

                        String mountpic = response.body().getMounts().get(position).getMountPic();

                        goPro(mountpic);

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

                if (mProgressDialog.isShowing())
                    mProgressDialog.dismiss();

                Log.e("FAILED", t.getMessage());
            }
        });
    }


    public void Sample (){
        client = new AsyncHttpClient();
        client.get(MainActivity.this, url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String responsestr = new String(responseBody);
                gson = new Gson();
                responseObj = gson.fromJson(responsestr, Response.class);
                adapter = new CustomAdapter(MainActivity.this, responseObj.getMounts());
                listview.setAdapter(adapter);

                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        //Get Id of object
                        String objectid = responseObj.getMounts().get(position).getName();

                        String mounticon = responseObj.getMounts().get(position).getIcon();

                        //Toast.makeText(MainActivity.this, objectid.toString(), Toast.LENGTH_SHORT).show();
                        //Toast.makeText(MainActivity.this, mounticon.toString(), Toast.LENGTH_SHORT).show();

                        Intent goToMounts = new Intent(MainActivity.this, MountActivity.class);
                        goToMounts.putExtra("icon", mounticon);
                        goToMounts.putExtra("id", objectid);
                        startActivity(goToMounts);

                        //Create Intent to go to detailsView
                        //Intent goToDetails = new Intent(MainActivity.this, MountActivity.class);

                        //Add Extra for objectID and pass it to the activity
                        //goToDetails.putExtra("icon", mounticon);
                        //goToDetails.putExtra("objectid", objectid);

                        //Start the activity
                        //startActivity(goToDetails);

                    }
                });
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(MainActivity.this, "Server Connection Failed!", Toast.LENGTH_SHORT).show();
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
