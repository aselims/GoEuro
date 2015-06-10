package co.rahala.selim.goeuro;

import android.test.InstrumentationTestCase;
import android.util.Log;

import java.util.ArrayList;

import co.rahala.selim.goeuro.models.PlaceDistance;

/**
 * Created by aselims on 10/06/15.
 */
public class PlaceSortingTest extends InstrumentationTestCase {
    public static final String TAG = PlaceSortingTest.class.getSimpleName();

    private final PlaceDistance p1 = new PlaceDistance("berlin", 10005);
    private final PlaceDistance p2 = new PlaceDistance("ams", 200);
    private final PlaceDistance p3 = new PlaceDistance("c3", 7000);
    private final PlaceDistance p4 = new PlaceDistance("hh", 50);

    private ArrayList<PlaceDistance> mPlaceDistances;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mPlaceDistances = new ArrayList<>();
        mPlaceDistances.add(p1);
        mPlaceDistances.add(p2);
        mPlaceDistances.add(p3);
        mPlaceDistances.add(p4);
       // mPlaceDistances.add(p1);

    }

    private void printPlaceDistances() {
        for(PlaceDistance placeDistance : mPlaceDistances) {

            Log.d(TAG, placeDistance.getName() + "  " + placeDistance.getDistance());
        }
    }

    public void testSortByDistance() {

        printPlaceDistances();
        mPlaceDistances = Util.sortByDistance(mPlaceDistances);
        assertEquals(mPlaceDistances.get(0), p4);
        assertEquals(mPlaceDistances.get(1), p2);
        assertEquals(mPlaceDistances.get(2), p3);
        printPlaceDistances();

    }


}

