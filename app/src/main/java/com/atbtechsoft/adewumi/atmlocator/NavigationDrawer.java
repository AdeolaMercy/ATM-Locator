package com.atbtechsoft.adewumi.atmlocator;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigationdrawer);
    /*    getSupportActionBar().setHomeButtonEnabled(true);*/

        //to get list items
        listMenu = getResources().getStringArray(R.array.items);
        //to get list items
        drawerList = (ListView) findViewById(R.id.left_drawer);
        //set adapter for listview
        drawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, listMenu));
        //set list's click listener
        drawerList.setOnItemClickListener(new DrawerItemClickListener());
    }



    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        /*Fragment fragment;
        fragment = new MyActivity.PlanetFragment();
        Bundle args = new Bundle();
        args.putInt(MyActivity.PlanetFragment.ARG_PLANET_NUMBER, position);
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
}