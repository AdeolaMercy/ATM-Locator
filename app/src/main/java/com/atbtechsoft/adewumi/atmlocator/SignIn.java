package com.atbtechsoft.adewumi.atmlocator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by ADEWUMI on 10/20/2014.
 */
public class SignIn extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        getActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return true;
    }
}
