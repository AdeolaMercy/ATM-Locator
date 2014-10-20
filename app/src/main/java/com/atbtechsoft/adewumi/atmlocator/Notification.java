package com.atbtechsoft.adewumi.atmlocator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by ADEWUMI on 10/20/2014.
 */
public class Notification extends ActionBarActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_activity);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        //navigate back to homescreen
        Intent notificationIntent = new Intent(getApplicationContext(),HomeScreen.class);
        startActivityForResult(notificationIntent,0);
        return true;
    }
}
