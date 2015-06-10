package co.rahala.selim.goeuro.events;

import java.util.ArrayList;

/**
 * Created by aselims on 09/06/15.
 */
public class StringsEvent {
    private ArrayList<String> strings;

    public StringsEvent(ArrayList<String> strings) {
        this.strings = strings;
    }

    public ArrayList<String> getStrings() {
        return strings;
    }

    public void setStrings(ArrayList<String> strings) {
        this.strings = strings;
    }
}
