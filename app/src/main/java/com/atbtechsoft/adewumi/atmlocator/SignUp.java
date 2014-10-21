/**
 * Created by ADEWUMI on 9/30/2014.
 */

package com.atbtechsoft.adewumi.atmlocator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUp extends ActionBarActivity {
    private EditText name;
    private EditText emailaddy;
    private EditText phoneno;
    private EditText password1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void SignUp(View view){
        EditText name = (EditText)findViewById(R.id.name);
        EditText emailaddy = (EditText)findViewById(R.id.emailaddy);
        EditText phoneno = (EditText)findViewById(R.id.phoneno);
        EditText password1 = (EditText)findViewById(R.id.password1);
        if (name.getText().toString().equals("Adeola")&& emailaddy.getText()
                .toString().equals("mercycharis44@gmail.com")&& phoneno.getText().toString()
                .equals("08168460033")&& password1.getText().toString().equals("password")){

            AlertDialog.Builder message = new AlertDialog.Builder(this);
            message.setMessage("Your data has been saved");
            message.setTitle("");
            message.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent suggestIntent = new Intent(getApplicationContext(),SuggestAtm.class);
                    startActivityForResult(suggestIntent,0);
                    return;
                }
            });
            message.setCancelable(true);
            message.create().show();
        }
        else{
            TextView textView = (TextView)findViewById(R.id.displaytext);
            textView.setText("Incorrect credentials");
        }
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
