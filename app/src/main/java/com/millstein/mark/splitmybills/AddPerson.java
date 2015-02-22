package com.millstein.mark.splitmybills;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.EditText;


public class AddPerson extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_person, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void submitPerson(View view) {
        final String name = ((EditText) findViewById(R.id.addPersonName)).getText().toString();

        final int singles = Integer.valueOf(((EditText) findViewById(R.id.addPersonSingles)).getText().toString());
        final int fives = Integer.valueOf(((EditText) findViewById(R.id.addPersonFives)).getText().toString());
        final int tens = Integer.valueOf(((EditText) findViewById(R.id.addPersonTens)).getText().toString());
        final int twenties = Integer.valueOf(((EditText) findViewById(R.id.addPersonTwenties)).getText().toString());
        final int fifties = Integer.valueOf(((EditText) findViewById(R.id.addPersonFifties)).getText().toString());
        final int hundreds = Integer.valueOf(((EditText) findViewById(R.id.addPersonHundreds)).getText().toString());

        Person person = new Person(name, singles, fives, tens, twenties, fifties, hundreds);
        this.finish();
    }
}
