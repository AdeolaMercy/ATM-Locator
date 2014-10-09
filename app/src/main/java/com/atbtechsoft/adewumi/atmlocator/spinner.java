/*
package com.atbtechsoft.adewumi.atmlocator;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;


*/
/**
 * Created by ADEWUMI on 10/8/2014.
 *//*

public class spinner extends Activity {
    private static Object setAdapter;
    private ArrayAdapter<CharSequence> adapter;
    private ArrayAdapter<CharSequence> adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_search);
       */
/* TextView textView = new TextView(this);
        textView.setText("some help text");
        this.setContentView(textView);
       SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
       SharedPreferences.Editor editor = preferences.edit();
        editor.putString("test","test value");
        editor.commit();*//*

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this,R.array.banks_array,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource
                (this,R.array.location_array,android.R.layout.simple_spinner_item);}



    public void setAdapter(ArrayAdapter<CharSequence> adapter) {
        this.adapter = adapter;
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    public void setAdapter2(ArrayAdapter<CharSequence> adapter2) {
        this.adapter2 = adapter2;
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter2);
    }
    }

*/
