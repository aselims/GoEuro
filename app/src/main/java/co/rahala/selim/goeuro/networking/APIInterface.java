package co.rahala.selim.goeuro.networking;


import java.util.List;

import co.rahala.selim.goeuro.models.Place;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by ssalman on 12/7/2014.
 */
public interface APIInterface {


    @GET("/{locale}/{term}")
    void getPlaces(@Path("locale") String locale, @Path("term") String term, Callback<List<Place>> cb);



}
