/**
 * Created by ADEWUMI on 9/30/2014.
 */

package com.atbtechsoft.adewumi.atmlocator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignUp extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oldhome);
        /*Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText)findViewById(R.id.text_id);
                editText.getText();
            }
        });*/
        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // --- find the text view --
                TextView textView = (TextView) findViewById(R.id.text_id);
                // -- change text size --
                textView.setText(getString(R.string.test_updating_a_view));
               /* textView.setTextSize(14);*/
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
