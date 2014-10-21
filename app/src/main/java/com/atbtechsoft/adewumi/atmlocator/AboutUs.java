package com.atbtechsoft.adewumi.atmlocator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

/**
 * Created by ADEWUMI on 10/15/2014.
 */
public class AboutUs extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //navigate back to the homescreen
        Intent aboutIntent = new Intent(getApplicationContext(), HomeScreen.class);
        startActivityForResult(aboutIntent,0);
        return true;
    }
}
