package com.atbtechsoft.adewumi.atmlocator;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by ADEWUMI on 10/10/2014.
 */
public class NavigationDrawer extends Activity {
    private String[] listMenu;
    private DrawerLayout mDrawerLayout;
    private ListView drawerList;
    private CharSequence mTitle;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigationdrawer);
       /* getActionBar().setDisplayHomeAsUpEnabled(true);*/

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
             R.drawable.ic_navdrawer,
             R.string.drawer_open,
             R.string.drawer_close);
        //set actionBarToggle as the drawer listener
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
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        /*Fragment fragment;
        fragment = new HomeScreen.PlanetFragment();
        Bundle args = new Bundle();
        args.putInt(HomeScreen.PlanetFragment.ARG_PLANET_NUMBER, position);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}