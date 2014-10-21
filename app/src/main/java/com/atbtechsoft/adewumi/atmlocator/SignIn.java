package com.atbtechsoft.adewumi.atmlocator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ADEWUMI on 10/20/2014.
 */
public class SignIn extends ActionBarActivity {
    private EditText emailaddress;
    private EditText passwword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        EditText emailaddress = (EditText) findViewById(R.id.username);
        EditText passwword = (EditText) findViewById(R.id.password);
    }
       /* public void login(View view){
        if (emailaddress.getText().toString().equals("admin")&& passwword.getText().toString().equals("admin")){
            Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Wrong Credentials",Toast.LENGTH_SHORT).show();
        }
    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return true;
    }
}
