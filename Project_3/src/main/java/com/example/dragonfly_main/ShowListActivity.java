package com.example.dragonfly_main;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dragonfly_main.R;
import com.example.dragonfly_main.Species;
import com.example.dragonfly_main.SpeciesListAdapter;

import java.util.ArrayList;

public class ShowListActivity extends AppCompatActivity {

    private static final String TAG = "ShowListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);
        Log.d(TAG, "onCreate: Started.");
        ListView mListView = (ListView) findViewById(R.id.listView);

        //Create the Species objects
        Species john = new Species("Brachythemis contaminata","Ditch Jewel","Dragonfly");
        Species steve = new Species("Pantala flavescens","Wandering Glider","Dragonfly");
        Species stacy = new Species("Trithemis aurora","Crimson Marsh Glider ","Dragonfly");
        Species ashley = new Species("Crocothemis servilia","Ruddy Marsh Skimmer ","Dragonfly");
        Species matt = new Species("Orthetrum sabina","Green Marsh Hawk","Dragonfly");
        Species matt1 = new Species("Orthetrum pruinosum","Crimson-tailed Marsh Hawk","Dragonfly");
        Species matt2 = new Species("Ictinogomphus rapax","Common Clubtail","Dragonfly");
        Species matt3 = new Species("Anax immaculifrons","Blue Darner","Dragonfly");
        Species matt4 = new Species("Neurothemis tullia","Pied Paddy Skimmer ","Dragonfly");
        Species matt5 = new Species("Neurothemis fulvia","Fulvous Forest Skimmer","Dragonfly");
        Species matt6 = new Species("Tholymis tillarga","Coral-tailed Cloud WIng","Dragonfly");
        Species matt7 = new Species("Trithemis pallidinervis","Long-legged Marsh Glider","Dragonfly");
        Species matt8 = new Species("Trithemis festiva","Black Stream Glider ","Dragonfly");
        Species matt9 = new Species("Diplacodes trivialis","Ground Skimmer","Dragonfly");
        Species matt10 = new Species("Rhyothemis variegata","Common Picturewing","Dragonfly");
        Species matt11 = new Species("Acisoma panorpoides","Trumpet Tail","Dragonfly");

        //Add the Species objects to an ArrayList
        ArrayList<Species> speciesList = new ArrayList<>();
        speciesList.add(john);
        speciesList.add(steve);
        speciesList.add(stacy);
        speciesList.add(ashley);
        speciesList.add(matt);
        speciesList.add(matt1);
        speciesList.add(matt2);
        speciesList.add(matt3);
        speciesList.add(matt4);
        speciesList.add(matt5);
        speciesList.add(matt6);
        speciesList.add(matt7);
        speciesList.add(matt8);
        speciesList.add(matt9);
        speciesList.add(matt10);
        speciesList.add(matt11);

        SpeciesListAdapter adapter = new SpeciesListAdapter(this, R.layout.adapter_view_layout, speciesList);
        mListView.setAdapter(adapter);
    }
}
