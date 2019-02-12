package com.example.inclassfeb12;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txtStatus;
    Button btnFirst;
    Button btnSecond;
    Button btnThird;
    Spinner spnPlantes;
    Spinner spnColor;
    Spinner customSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        txtStatus = findViewById(R.id.txtStatus);
        btnFirst = findViewById(R.id.btnFirst);
        btnSecond = findViewById(R.id.btnSecond);
        btnThird = findViewById(R.id.btnThird);

        btnSecond.setOnClickListener(buttonClick2);

        btnThird.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                txtStatus.setText("Friday button was clicked.");
            }
        });

        spnPlantes = findViewById(R.id.spnPlanets);

        spnPlantes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txtStatus.setText("Planet Spinner Selected: " + parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayList<String> list = new ArrayList<String>();
        list.add("Red");
        list.add("Blue");
        list.add("Yellow");
        list.add("Black");
        list.add("Green");

        spnColor = findViewById(R.id.spnColor);

        ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnColor.setAdapter(colorAdapter);

        spnColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txtStatus.setText("Color Spinner Selected: " + parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        customSpinner = findViewById(R.id.spinner3);

        final ArrayList<Planet> planetList = new ArrayList<Planet>();
        // planet data from http://www.enchantedlearning.com/subjects/astronomy/planets/
        planetList.add(new Planet("Mercury", 57.9, 4800.0));
        planetList.add(new Planet("Venus", 108.2, 12104.0));
        planetList.add(new Planet("Mars", 227.9, 6787.0));
        // create the custom array adapter. The 3rd parameter is just a placeholder for the parent class pointing to any textview in the new layout.
        ArrayAdapter<Planet> planetAdapter = new PlanetAdapter(this, R.layout.planet_row, R.id.textViewPlanetName, planetList);
        planetAdapter.setDropDownViewResource(R.layout.planet_row);
        customSpinner.setAdapter(planetAdapter);
        customSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Planet planet = planetList.get(position);
                txtStatus.setText("Custom Spinner selected : "+ planet.getName());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
    }

    //first way to use buttons
    public void buttonClick1(View view) {
        // Do something in response to button click
        txtStatus.setText("Monday button was clicked.");
    }

    private View.OnClickListener buttonClick2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            txtStatus.setText("Wednesday button was clicked.");
        }
    };























    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
