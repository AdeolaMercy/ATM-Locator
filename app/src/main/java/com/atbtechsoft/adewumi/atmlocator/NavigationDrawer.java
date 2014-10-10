package com.atbtechsoft.adewumi.atmlocator;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by ADEWUMI on 10/10/2014.
 */
public class NavigationDrawer extends Activity {
    private String[] listMenu;
    private DrawerLayout mDrawerLayout;
    private ListView drawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigationdrawer);
    /*    getSupportActionBar().setHomeButtonEnabled(true);*/
        getActionBar().setDisplayHomeAsUpEnabled(true);
    //to get list items
        listMenu = getResources().getStringArray(R.array.items);
        //to get list items
        drawerList =(ListView)findViewById(R.id.left_drawer);
        //set adapter for listview
        drawerList.setAdapter(new ArrayAdapter<String>(this,R.layout.drawer_list_item, listMenu));
        //set list's click listener
        drawerList.setOnItemClickListener(new DrawerItemClickListener());
    }

    private ActionBar getSupportActionBar() {
        return null;
    }
}