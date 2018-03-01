package com.schulz.erica.dogbreeds;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by ericaschulz on 2/28/18.
 */

public class BreedImageListAdapter extends ArrayAdapter   {

        public BreedImageListAdapter(@NonNull Context context, int resource, @NonNull List objects) {
            super(context, resource, objects);
        }
    }

