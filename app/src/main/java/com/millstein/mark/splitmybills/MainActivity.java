package com.millstein.mark.splitmybills;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.millstein.mark.splitmybills.math.Algorithms;
import com.millstein.mark.splitmybills.math.Triple;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Triple result = Algorithms.extendedEuclid(5, 1);
        Log.v("blah", result.toString());
        String out = "";
        for(int i = 1; i < 4; i++) {
            out += result.toString() + "\n";
            result = Algorithms.generateNewGCDSolution(1, 5, i, result);
        }

        TextView textView = (TextView) findViewById(R.id.myTextView);
        textView.setText(out);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
