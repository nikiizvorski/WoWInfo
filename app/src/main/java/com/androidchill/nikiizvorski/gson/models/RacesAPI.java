package com.androidchill.nikiizvorski.gson.models;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.GET;

/**
 * Created by nikiizvorski on 1/31/2016.
 */
public interface RacesAPI {
    String BASE_URL = "https://eu.api.battle.net/wow/data/character/";

    @GET("races?locale=en_GB&apikey=amd7ujwtgawpy97kswhhk38xsxtbdn2m")
    Call<ResponceRaces> getRaces();

    class Factory {
        private static RacesAPI service;

        public static RacesAPI getIstance() {
            if (service == null) {
                Retrofit retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(BASE_URL).build();
                service = retrofit.create(RacesAPI.class);
                return service;
            } else {
                return service;
            }
        }
    }
}
