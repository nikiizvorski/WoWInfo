package com.androidchill.nikiizvorski.gson.views;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidchill.nikiizvorski.gson.R;
import com.androidchill.nikiizvorski.gson.models.ResponseClass;
import com.androidchill.nikiizvorski.gson.presenters.CustomAdapter;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;

public class Character extends AppCompatActivity {
    @Bind(R.id.editText)
    EditText realm;
    @Bind(R.id.editText2)
    EditText charactername;
    @Bind(R.id.textView)
    TextView realmchar;
    @Bind(R.id.textView2)
    TextView charnamerealm;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    ResponseClass responseObj;
    CustomAdapter adapter;
    AsyncHttpClient client;
    Gson gson;
    String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String realmname = realm.getText().toString().trim();
                final String characteraname = charactername.getText().toString().trim();

                url = "https://eu.api.battle.net/wow/character/" + realmname + "/" + characteraname + "?locale=en_GB&apikey=amd7ujwtgawpy97kswhhk38xsxtbdn2m";
                Toast.makeText(Character.this, url, Toast.LENGTH_SHORT).show();
                Sample();
            }
        });

    }

    public void Sample() {
        client = new AsyncHttpClient();
        client.get(Character.this, url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String responsestr = new String(responseBody);
                gson = new Gson();
                responseObj = gson.fromJson(responsestr, ResponseClass.class);
                final String realmcharge = responseObj.getRealm();
                final String charactercharge = responseObj.getName();
                goPro(responseObj.getCharacterImage());
                realmchar.setText(realmcharge);
                charnamerealm.setText(charactercharge);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(Character.this, "Server Connection Failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void goPro (String ur) {
        Dialog dialog = new Dialog(Character.this);
        //dialog.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(R.layout.go_pro_dialog_layout);

        ImageView image = (ImageView) dialog.findViewById(R.id.goProDialogImage);
        Picasso.with(Character.this).load(ur).into(image);
        dialog.show();
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
    /*
    public void Sample2 () {
        CharacterAPI.Factory.getIstance().getName().enqueue(new Callback<ResponseClass>() {
            @Override
            public void onResponse(final retrofit2.Response<ResponseClass> response) {
                String realmcharge = response.body().setName(realmname);
                realmchar.setText(realmcharge);

                String charactercharge = response.body().setName(characteraname);
                charnamerealm.setText(charactercharge);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("FAILED", t.getMessage());
            }
        });
    }
*/