package com.androidchill.nikiizvorski.gson.models;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.GET;

/**
 * Created by nikiizvorski on 1/31/2016.
 */
public interface MountAPI {
    String BASE_URL = "https://eu.api.battle.net/wow/mount/";

    @GET("?locale=en_GB&apikey=amd7ujwtgawpy97kswhhk38xsxtbdn2m")
    Call<Response> getMounts();

    class Factory {
        private static MountAPI service;

        public static MountAPI getIstance() {
            if (service == null) {
                Retrofit retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(BASE_URL).build();
                service = retrofit.create(MountAPI.class);
                return service;
            } else {
                return service;
            }
        }
    }
}
