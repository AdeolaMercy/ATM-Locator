package com.atbtechsoft.adewumi.atmlocator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

/**
 * Created by ADEWUMI on 10/20/2014.
 */
public class Help extends ActionBarActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //navigate back to the homescreen
        Intent helpIntent = new Intent(getApplicationContext(), HomeScreen.class);
        startActivityForResult(helpIntent,0);
        return true;
    }
}
