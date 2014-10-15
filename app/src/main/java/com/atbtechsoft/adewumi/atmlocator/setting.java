package com.atbtechsoft.adewumi.atmlocator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

/**
 * Created by ADEWUMI on 10/14/2014.
 */
public class Setting extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            Intent settingIntent = new Intent(getApplicationContext(), MyActivity.class);
            startActivityForResult(settingIntent,0);
            return true;


    }
}
