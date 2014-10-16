package com.atbtechsoft.adewumi.atmlocator;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class HomeScreen extends ActionBarActivity {

    private String[] listMenu;
    private DrawerLayout mDrawerLayout;
    private ListView drawerList;
    private CharSequence mTitle;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Switch button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        /*button = (Switch) findViewById(R.id.switch1);
        button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                } else {

                }
            }
        });*/
        listMenu = getResources().getStringArray(R.array.items);
        drawerList = (ListView) findViewById(R.id.left_drawer);
        drawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, R.id.text1,
                listMenu));
        drawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.drawable.ic_navdrawer,
                R.string.drawer_open,
                R.string.drawer_close);
        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view,int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        Fragment fragment;
        fragment = new PlanetFragment();
        Bundle args = new Bundle();
       /* args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);*//**/
        fragment.setArguments(args);
        //insert fragment by replacing any exisiting fragment
        android.app.FragmentManager fragmentManager = getFragmentManager();
        int commit;
        commit = fragmentManager.beginTransaction()

                .commit();
    }
        @Override
                public void setTitle(CharSequence title) {
            mTitle = title;
            getActionBar().setTitle(mTitle);
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        /*super.onCreateOptionsMenu(menu);*/
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.homemenu,menu);
        return true;
    }

        //called when the search icon is clicked

    //using OnCheckedChangeListener
   /* ToggleButton toggle = (ToggleButton) findViewById(R.id.togglebutton);
    toggle.setOnCheckedChangeListener(new CompoundButton,OnCheckedChangeListener(){
        public void onCheckedChanged(CompoundButton buttonView boolean isChecked) {
            if (isChecked) {
                // The toggle is enabled
            } else {
                // The toggle is disabled
            }
        }
        }
    });*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //if this activity will be invoked in another project
        /*startActivity(new Intent(this,"com.atbtechsoft.adewumi.atmlocator.NavigationDrawer"));*/

        int id;
        id = item.getItemId();
        if (id== R.id.action_search) {
            Toast.makeText(getApplicationContext(),"Search", Toast.LENGTH_LONG).show();
            return true;
        }
        else if (id==R.id.action_settings) {
            Intent settingsIntent = new Intent(this,Setting.class);
            startActivity(settingsIntent);
        }
        else if(id==R.id.action_aboutUs){
            Intent aboutIntent = new Intent(this,AboutUs.class);
            startActivity(aboutIntent);
        }
        else if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
      /*  int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;*/

        /*switch(item.getItemId()) {
            case R.id.homemenu:
                Intent intent = new Intent(this, HomeScreen.class);
                startActivity(intent);
                finish();
                return true;
        }
        switch(item.getItemId()) {
            case R.id.action_search:
                openSearch();
                return true;
            case R.id.action_settings:
                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }}*/



    private void openSearch() {

    }
   private void openSettings(){

   }

    /*Spinner spinner = (Spinner)findViewById(R.id.spinner);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
            (this,R.array.banks_array,android.R.layout.simple_spinner_item);
    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource
            (this,R.array.location_array,android.R.layout.simple_spinner_item);

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

   */
    public static class PlanetFragment extends Fragment {
        public static String ARG_PLANET_NUMBER;
    }
}

