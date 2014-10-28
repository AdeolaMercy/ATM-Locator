package com.atbtechsoft.adewumi.atmlocator;

import android.content.Context;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationRequest;

import java.util.ArrayList;

/**
 * Created by ADEWUMI on 10/28/2014.
 */
public class Locationg extends FragmentActivity implements
        GooglePlayServicesClient.ConnectionCallbacks,
        GooglePlayServicesClient.OnConnectionFailedListener {
    private final static int
            CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
    private LocationClient mLocationClient;
    Location mCurrentLocation;
    LocationRequest mLocationRequest;
    // Milliseconds per second
    private static final int MILLISECONDS_PER_SECOND = 1000;
    // Update frequency in seconds
    public static final int UPDATE_INTERVAL_IN_SECONDS = 5;
    // Update frequency in milliseconds
    private static final long UPDATE_INTERVAL =
            MILLISECONDS_PER_SECOND * UPDATE_INTERVAL_IN_SECONDS;
    // The fastest update frequency, in seconds
    private static final int FASTEST_INTERVAL_IN_SECONDS = 1;
    // A fast frequency ceiling in milliseconds
    private static final long FASTEST_INTERVAL =
            MILLISECONDS_PER_SECOND * FASTEST_INTERVAL_IN_SECONDS;
    Boolean mUpdatesRequested;
    ArrayList<Location> list = new ArrayList<Location>();
    private LocationListener locationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reversegeo);
        mLocationClient = new LocationClient(this, this, this);
        /*mLocationRequest = LocationRequest.create();
        // Use high accuracy
        mLocationRequest.setPriority(
                LocationRequest.PRIORITY_HIGH_ACCURACY);
        // Set the update interval to 5 seconds
        mLocationRequest.setInterval(UPDATE_INTERVAL);
        // Set the fastest update interval to 1 second
        mLocationRequest.setFastestInterval(FASTEST_INTERVAL);*/



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
        Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
        mCurrentLocation = mLocationClient.getLastLocation();

        TextView textView = (TextView) findViewById(R.id.tv_location);
        textView.setText("Current Location: " + String.valueOf(mCurrentLocation));
       /* mLocationClient.requestLocationUpdates(mLocationRequest, (com.google.android.gms.location.LocationListener) locationListener);*/
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

   /* private final class MyLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {
            // Report to the UI that the location was updated
            mCurrentLocation = location;
            Context context = getApplicationContext();

           String msg = Double.toString(location.getLatitude()) + "," + Double.toString(location.getLongitude());
            list.add(mCurrentLocation);

            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();

        }
        @Override
        public void onStatusChanged(String locationProvider,int status,Bundle extras){

        }
        @Override
        public void onProviderEnabled(String locationProvider){

        }
        @Override
        public void onProviderDisabled(String locationProvider){

        }
    }*/

}


