package com.example.inclassfeb12;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PlanetAdapter extends ArrayAdapter<Planet> {
    private List<Planet> planetList;
    private Context context;

    public PlanetAdapter(Context context, int resource, int tvID, List<Planet> objects) {
        //super(context, R.layout.country_list_item, R.id.txtViewCountryName, objects);
        super(context, resource, tvID, objects);
        this.context = context;
        this.planetList = objects;
    }

    @Override
    public View getView(int position, View convertView,
                        ViewGroup parent) {
        //get the planet we are displaying
        Planet planet = planetList.get(position);
        View view;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.planet_row, null);

        TextView tvName = view.findViewById(R.id.textViewPlanetName);
        TextView tvDistance = view.findViewById(R.id.textViewPlanetDistance);
        TextView tvDiameter = view.findViewById(R.id.textViewPlanetDiameter);
        tvName.setText(planet.getName());
        tvDistance.setText(planet.getDistanceFromSol().toString());
        tvDiameter.setText(planet.getDiameter().toString());

        return(view);
    }
}
