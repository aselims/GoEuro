package co.rahala.selim.goeuro.networking;

import retrofit.RestAdapter;

/**
 * Created by ssalman on 12/7/2014.
 */
public class APIClient {


    private static APIInterface sApiInterface;

    private static final String endPoint = "http://api.goeuro.com/api/v2/position/suggest";

    public static APIInterface getsApiInterface() {
        if (sApiInterface == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(endPoint)
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build();

            sApiInterface = restAdapter.create(APIInterface.class);
        }
        return sApiInterface;
    }
}
