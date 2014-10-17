package com.atbtechsoft.adewumi.atmlocator;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by ADEWUMI on 10/10/2014.
 */
public class HomeScreen extends Activity {
    private String[] listMenu;
    private DrawerLayout mDrawerLayout;
    private ListView drawerList;
    private CharSequence mTitle;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private GoogleMap mMap;
    static final LatLng testing = new LatLng(6.62 , 3.47);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        //to get list items
        listMenu = getResources().getStringArray(R.array.items);
        //to get list items
        drawerList = (ListView) findViewById(R.id.left_drawer);
        //set adapter for listview
        drawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, listMenu));
        //set list's click listener
        drawerList.setOnItemClickListener(new DrawerItemClickListener());
        //app icon
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.drawable.ic_drawer,
                R.string.drawer_open,
                R.string.drawer_close);
        //set actionBarToggle as the drawer listener
        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        mDrawerLayout.setDrawerShadow(R.drawable.abc_item_background_holo_dark, GravityCompat.START);
        try{
            if(mMap == null){
                mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
            }
            mMap.getMyLocation();
        }
        catch (Exception e) {
        e.printStackTrace();
        }
        /*MapFragment mMapFragment = MapFragment.newInstance();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.my_container, mMapFragment);
        fragmentTransaction.commit();
        mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();*/


    }
       /* private void setUpMapIfNeeded() {
        if (mMap==null) {
            mMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
            if (mMap!=null) {

            }
        }
    }
*/
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
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        /*Fragment fragment;
        fragment = new OldHomeScreen.PlanetFragment();
        Bundle args = new Bundle();
        args.putInt(OldHomeScreen.PlanetFragment.ARG_PLANET_NUMBER, position);
        fragment.setArguments(args);*/
        //insert fragment by replacing any exisiting fragment
        /*android.app.FragmentManager fragmentManager;
        fragmentManager = getFragmentManager();
        int commit = fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();*/

    }
    /*@Override
   *//* public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.homemenu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id;
        id = item.getItemId();
        if (id== R.id.action_search) {
            Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_LONG).show();
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
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}