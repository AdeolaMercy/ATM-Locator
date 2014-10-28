package com.atbtechsoft.adewumi.atmlocator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by ADEWUMI on 10/10/2014.
 */
public class HomeScreen extends FragmentActivity implements
        GooglePlayServicesClient.ConnectionCallbacks,
        GooglePlayServicesClient.OnConnectionFailedListener{
    private String[] listMenu;
    private DrawerLayout mDrawerLayout;
    private ListView drawerList;
    private CharSequence mTitle;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private GoogleMap mMap;
    private boolean authenticate = false;
    Location location; // location
    double latitude; // latitude
    double longitude;
    private LocationClient mLocationClient;
    Location mCurrentLocation;
    LocationRequest mLocationRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        mLocationClient = new LocationClient(this, this, this);
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
        mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

           mMap.setMyLocationEnabled(true);
           mMap.getMyLocation();

    }
    @Override
    protected void onStart() {
        super.onStart();
        // Connect the client.
        mLocationClient.connect();
    }

    @Override
    protected void onStop() {
        // Disconnecting the client invalidates it.
        mLocationClient.disconnect();
        super.onStop();
    }

    @Override
    public void onConnected(Bundle dataBundle) {
        // Display the connection status
      /*  Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();*/
        mCurrentLocation = mLocationClient.getLastLocation();

        TextView textView = (TextView) findViewById(R.id.tv_location);
        textView.setText(" " + String.valueOf(mCurrentLocation.getLongitude()
                + ", " + mCurrentLocation.getLatitude()));
       /* mLocationClient.requestLocationUpdates(mLocationRequest, (com.google.android.gms.location.LocationListener) locationListener);*/
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));

    }

    @Override
    public void onDisconnected() {
        // Display the connection status
        Toast.makeText(this, "Disconnected. Please re-connect.",
                Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    public void onLocationChanged(Location location) {
        TextView tvLocation = (TextView) findViewById(R.id.tv_location);
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        LatLng latLng = new LatLng(latitude, longitude);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
        tvLocation.setText("Latitude:" +  latitude  + ", Longitude:"+ longitude );
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
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
            mDrawerLayout.closeDrawer(drawerList);
        }
        /*public void onItemClick(AdapterView parent, View view, int position, long id) {
            Toast.makeText(HomeScreen.this,((TextView)view).getText(),Toast.LENGTH_LONG).show();
            mDrawerLayout.closeDrawer(drawerList);
        }*/
    }

    public void setStatus(Boolean value){
        this.authenticate = value;
    }

    public Boolean getStatus(){
        return this.authenticate;
    }

    private void selectItem(int position) {
        switch(position) {
            case 0:
                Intent intent = new Intent(this, SignUp.class);
                startActivity(intent);
                finish();
                return;
            case 1:
                Intent notifyIntent = new Intent(this, Notification.class);
                startActivity(notifyIntent);
                finish();
                return;
            case 2:
                if (getStatus()){
                    Intent suggestIntent = new Intent(this, SuggestAtm.class);
                    startActivity(suggestIntent);
                    finish();
                }
                else{
                    Intent signIntent = new Intent(this,SignUp.class);
                    startActivity(signIntent);
                    finish();
                }
                return;
            case 3:
                Intent viewIntent = new Intent(this,ViewAtmDetails.class);
                startActivity(viewIntent);
                finish();
                return;
            case 4:
                Intent aboutIntent = new Intent(this,AboutUs.class);
                startActivity(aboutIntent);
                finish();
                return;
        }
     }


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
        /*else if(id==R.id.action_aboutUs){
            Intent aboutIntent = new Intent(this,AboutUs.class);
            startActivity(aboutIntent);
        }*/
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}