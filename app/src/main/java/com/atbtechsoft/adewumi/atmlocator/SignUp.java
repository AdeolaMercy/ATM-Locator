/**
 * Created by ADEWUMI on 9/30/2014.
 */

package com.atbtechsoft.adewumi.atmlocator;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileOutputStream;

public class SignUp extends ActionBarActivity {
    EditText name;
    EditText emailaddy;
    EditText phoneno;
    EditText password1;
    public static  final String MyPreferences = "MyPrefs";
    public static  final String Name = "Adeola";
    public static  final String Email = "mercycharis@gmail.com";
    public static  final String Phone = "08168460033";
    public static  final String Password = "password";

    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        name = (EditText)findViewById(R.id.name);
        emailaddy = (EditText)findViewById(R.id.emailaddy);
        phoneno = (EditText)findViewById(R.id.phoneno);
        password1 = (EditText)findViewById(R.id.password1);
        sharedpreferences = getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Name))
        {
            name.setText(sharedpreferences.getString(Name, ""));

        }
        if (sharedpreferences.contains(Email))
        {
            emailaddy.setText(sharedpreferences.getString(Email, ""));

        }
        if (sharedpreferences.contains(Phone))
        {
            phoneno.setText(sharedpreferences.getString(Phone, ""));

        }
        if (sharedpreferences.contains(Password))
        {
            password1.setText(sharedpreferences.getString(Email, ""));

        }
    }

    public void SignUp(View view){
        String n  = name.getText().toString();
        String e  = emailaddy.getText().toString();
        String ph  = phoneno.getText().toString();
        String p  = password1.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Name, n);
        editor.putString(Email, e);
        editor.putString(Phone, ph);
        editor.putString(Password, p);

        editor.commit();
        HomeScreen home = new HomeScreen();
        home.setStatus(true);
        Intent intent = new Intent(this,SuggestAtm.class);
        startActivity(intent);
//        name = (EditText)findViewById(R.id.name);
//        emailaddy = (EditText)findViewById(R.id.emailaddy);
//        phoneno = (EditText)findViewById(R.id.phoneno);
//        password1 = (EditText)findViewById(R.id.password1);

//        if (name.getText().toString().equals("Adeola")&& emailaddy.getText()
//                .toString().equals("mercycharis44@gmail.com")&& phoneno.getText().toString()
//                .equals("08168460033")&& password1.getText().toString().equals("password")){
//
//            AlertDialog.Builder message = new AlertDialog.Builder(this);
//            message.setMessage("Your data has been saved");
//            message.setTitle("");
//            message.setPositiveButton("ok", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    Intent suggestIntent = new Intent(getApplicationContext(),SuggestAtm.class);
//                    startActivityForResult(suggestIntent,0);
//                    return;
//                }
//            });
//            message.setCancelable(true);
//            message.create().show();
//        }
//        else{
//            TextView textView = (TextView)findViewById(R.id.displaytext);
//            textView.setText("Incorrect credentials");
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.signup,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //navigate back to homescreen
        Intent signupIntent = new Intent(getApplicationContext(),HomeScreen.class);
        startActivityForResult(signupIntent,0);
        return true;
    }

}
