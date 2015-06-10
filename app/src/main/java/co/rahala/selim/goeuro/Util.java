package co.rahala.selim.goeuro;

import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import co.rahala.selim.goeuro.events.StringsEvent;
import co.rahala.selim.goeuro.models.Place;
import co.rahala.selim.goeuro.networking.APIClient;
import de.greenrobot.event.EventBus;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by aselims on 08/06/15.
 */
public class Util extends Application{

    private static LatLng mylocation;
    private static final String TAG = Util.class.getSimpleName();
    public static ArrayList<Place> suggestedPlaces = new ArrayList<>();
    public static ArrayList<String> strings = new ArrayList<>();




    @Override
    public void onCreate() {
        super.onCreate();
        mylocation = Util.getLocation(this);
        Log.d(TAG, "loccc"+mylocation.toString());


    }




    private static EventBus eventBus;
    public static EventBus getEventBus(){
        if(eventBus == null){
            eventBus = new EventBus();
        }
        return eventBus;
    }


    public static ArrayList<String> getPlaces(final String place) {
        suggestedPlaces.clear();
        strings.clear();


        APIClient.getsApiInterface().getPlaces("de", place, new Callback<List<Place>>() {
            @Override
            public void success(List<Place> places, Response response) {
                suggestedPlaces.addAll(places);

                LatLng nearestPlace;
                float distance = 0;

                for(Place place1 : places){
                    nearestPlace = new LatLng(place1.getGeo_position().getLatitude(), place1.getGeo_position().getLongitude());

                    distance = getDistanceInMetres(mylocation, nearestPlace);

                    Log.d(TAG, "distances= " + place1.getName() + " " + distance);



                }


                for(Place place : places){
                    strings.add(place.getName());
                }

                Log.d(TAG, "getPlacesStrings =" + strings);
                Util.getEventBus().post(new StringsEvent(strings));


            }

            @Override
            public void failure(RetrofitError error) {

                Log.d(TAG, "fail " + error);
            }
        });
        //return getPlacesStrings(suggestedPlaces);
        Log.d(TAG, "getPlacesStrings =" + strings );

        return strings;

    }




/*

    public static ArrayList<CareGiver> sortByDistance(ArrayList<CareGiver> careGivers) {

        Collections.sort(careGivers, new travelDistanceComparator());

        return careGivers;
    }

    private static class travelDistanceComparator implements Comparator<CareGiver> {
        @Override
        public int compare(CareGiver o1, CareGiver o2) {
            return (int) Math.signum(o1.getTravelDistance() - o2.getTravelDistance());
        }
    }
*/

    public static LatLng getLocation(Context context) {

        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        if (location != null) {
            return new LatLng(location.getLatitude(), location.getLongitude());
        } else {
            return null;
        }
    }

    public static float getDistanceInMetres(LatLng origin, LatLng destination) {
        float[] results = new float[1]; // results[0] contains distance in metres
        Location.distanceBetween(origin.latitude, origin.longitude, destination.latitude, destination.longitude, results);

        return results[0];
    }


}
