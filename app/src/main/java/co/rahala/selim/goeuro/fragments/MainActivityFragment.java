package co.rahala.selim.goeuro.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

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

    private static final String TAG = MainActivity.class.getSimpleName() ;




    @InjectView(R.id.textViewDate) TextView textViewDate;
    @InjectView(R.id.buttonSelectDate) Button buttonSelectDate;
    @InjectView(R.id.autoCompleteTextViewFrom)  AutoCompleteTextView textViewFrom;
    @InjectView(R.id.autoCompleteTextViewTo) AutoCompleteTextView textViewTo;
    @InjectView(R.id.buttonFind) Button buttonFind;


    public MainActivityFragment() {

        Util.getEventBus().register(this);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //autocompleteView.setAdapter(new PlacesAutoCompleteAdapter(getActivity(), R.layout.autocomplete_list_item));

        textViewFrom.setAdapter(new PlacesAdapter(getActivity(), android.R.layout.simple_dropdown_item_1line));
        textViewFrom.setThreshold(2);

        buttonSelectDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getActivity().showDialog(Util.DATE_DIALOG_ID);
            }
        });




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


        ButterKnife.inject(this, rootView);

        return rootView;
    }



    public void onEvent(Transporter transporter){
        textViewDate.setText(transporter.getString());
    }










}


