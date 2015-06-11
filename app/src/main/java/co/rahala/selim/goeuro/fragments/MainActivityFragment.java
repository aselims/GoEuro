package co.rahala.selim.goeuro.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import co.rahala.selim.goeuro.MainActivity;
import co.rahala.selim.goeuro.R;
import co.rahala.selim.goeuro.Util;
import co.rahala.selim.goeuro.adapters.PlacesAdapter;
import co.rahala.selim.goeuro.events.Transporter;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static final String TAG = MainActivity.class.getSimpleName();


    Boolean[] checks = new Boolean[3];


    @InjectView(R.id.textViewDate)
    TextView textViewDate;
    @InjectView(R.id.buttonSelectDate)
    Button buttonSelectDate;
    @InjectView(R.id.autoCompleteTextViewFrom)
    AutoCompleteTextView textViewFrom;
    @InjectView(R.id.autoCompleteTextViewTo)
    AutoCompleteTextView textViewTo;
    @InjectView(R.id.buttonFind)
    Button buttonFind;


    public MainActivityFragment() {

        Util.getEventBus().register(this);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //autocompleteView.setAdapter(new PlacesAdapter(getActivity(), R.layout.autocomplete_list_item));

        textViewFrom.setAdapter(new PlacesAdapter(getActivity(), android.R.layout.simple_dropdown_item_1line));
        textViewFrom.setThreshold(2);
        textViewFrom.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                checks[0] = true;
                if (!hasFocus) {
                    if (!isValidForm()) {
                        textViewFrom.setError("Not valid!");
                        checks[0] = false;

                    } else {
                        checks[0] = true;
                    }
                }
            }
        });

        textViewTo.setAdapter(new PlacesAdapter(getActivity(), android.R.layout.simple_dropdown_item_1line));
        textViewTo.setThreshold(2);
        textViewTo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                checks[1] = true;

                if (!hasFocus) {
                    if (!isValidForm()) {
                        textViewTo.setError("Not valid!");
                        checks[1] = false;

                    } else {
                        checks[1] = true;
                    }
                }
            }
        });

        buttonSelectDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getActivity().showDialog(Util.DATE_DIALOG_ID);
            }
        });


    }

    private boolean isValidForm() {
        if (!(PlacesAdapter.placesStringsList.size() > 0) || !PlacesAdapter.placesStringsList.contains(textViewFrom.getText().toString()) || textViewFrom.getText() == null) {
            Toast.makeText(getActivity(), "valid country plz", Toast.LENGTH_SHORT).show();
            return false;

        }
        return true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


        ButterKnife.inject(this, rootView);

        return rootView;
    }


    public void onEvent(Transporter transporter) {
        textViewDate.setText(transporter.getString());
        if (!textViewDate.getText().equals("")) {
            checks[2] = true;

            if (checks[0] && checks[1]) {
                buttonFind.setEnabled(true);

            }

        }

    }

    /*public void onEvent(StringsEvent event){
        placesStringsList = event.getStrings();
        Log.d(TAG, "        placesStringsList = event.getStrings= " + placesStringsList);
        notifyDataSetChanged();
    }*/


}


