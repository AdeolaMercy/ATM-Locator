package com.atbtechsoft.adewumi.atmlocator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.zip.Inflater;

/**
 * Created by ADEWUMI on 10/20/2014.
 */
public class SuggestAtm extends ActionBarActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.suggestatm);
       getActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater Inflater = getMenuInflater();
        Inflater.inflate(R.menu.suggestatm,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        //navigate back to homescreen
        Intent suggestIntent = new Intent(getApplicationContext(),HomeScreen.class);
        startActivityForResult(suggestIntent,0);
        return true;
    }
}
