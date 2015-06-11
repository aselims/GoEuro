package co.rahala.selim.goeuro.adapters;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.List;

import co.rahala.selim.goeuro.Util;
import co.rahala.selim.goeuro.events.StringsEvent;

/**
 * Created by aselims on 09/06/15.
 */
public class PlacesAdapter extends ArrayAdapter<String>{

    private static final String TAG = PlacesAdapter.class.getSimpleName();
    public static List<String> placesStringsList;
    private Context mContext;
    int res;

    public PlacesAdapter(Context context, int resource) {
        super(context, resource);

        mContext = context;
        res = resource;

        Util.getEventBus().register(this);

    }

    @Override
    public int getCount() {
        return placesStringsList.size();
    }

    @Override
    public String getItem(int position) {
        return placesStringsList.get(position);
    }


    @Override
    public Filter getFilter() {

        Filter myFilter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {


                FilterResults filterResults = new FilterResults();
                if (constraint != null) {

                    Util.getPlaces(constraint.toString());



                    filterResults.values = placesStringsList;
                    filterResults.count = placesStringsList.size();
                }

                return filterResults;


            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                Log.d(TAG, "results=" + results.toString());

                if (results != null && results.count > 0) {

                    notifyDataSetChanged();
                }
                else {
                    notifyDataSetInvalidated();
                }
            }
        };

        return myFilter;
    }

    public void onEvent(StringsEvent event){
        placesStringsList = event.getStrings();
        Log.d(TAG, "        placesStringsList = event.getStrings= " + placesStringsList);
        notifyDataSetChanged();
    }
}
