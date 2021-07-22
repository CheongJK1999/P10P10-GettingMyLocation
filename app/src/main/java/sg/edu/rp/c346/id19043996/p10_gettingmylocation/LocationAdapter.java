package sg.edu.rp.c346.id19043996.p10_gettingmylocation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Locations> {
    Context context;
    ArrayList<Locations> locations;
    int resource;
    TextView tvUpdates;

    public LocationAdapter( Context context, int resource, ArrayList<Locations> locations) {
        super(context, resource, locations);
        this.context = context;
        this.locations = locations;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        @SuppressLint("ViewHolder") View rowView = inflater.inflate(resource, parent, false);


        tvUpdates = (TextView) rowView.findViewById(R.id.tvUpdate);


        Locations locations = locations.get(position);

        tvUpdates.setText("Option used: " + .getOptions() + "");

        return rowView;
    }

}
