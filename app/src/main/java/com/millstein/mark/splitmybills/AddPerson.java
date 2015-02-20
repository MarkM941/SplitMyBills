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

    private final String LOG_TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_add_person, container, false);
            return rootView;
        }
    }
}
