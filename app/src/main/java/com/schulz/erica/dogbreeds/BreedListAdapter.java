package com.schulz.erica.dogbreeds;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by ericaschulz on 2/26/18.
 */

public class BreedListAdapter extends ArrayAdapter {
    public BreedListAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }
}




