package com.millstein.mark.splitmybills;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleExpandableListAdapter;

import com.millstein.mark.splitmybills.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends ActionBarActivity {

    ExpandableListAdaptor listAdapter;
    ExpandableListView expListView;
    List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.personExpandableList);

        // preparing list data
        personList = new ArrayList<>();
        listAdapter = new ExpandableListAdaptor(this, personList);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        //
        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        setupKeyboardHiding(mainLayout);

    }

    private void setupKeyboardHiding(View pView) {
        if(!(pView instanceof EditText)) {
            pView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    in.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    return false;
                }
            });
        }

        if(pView instanceof ViewGroup) {
            for(int i = 0; i < ((ViewGroup) pView).getChildCount(); i++) {
                View child = ((ViewGroup) pView).getChildAt(i);
                setupKeyboardHiding(child);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_person:
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Person Name");

                final EditText input = new EditText(this);
                alert.setView(input);

                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String value = input.getText().toString();
                        listAdapter.addPerson(new Person(value, 0, 0, 0, 0, 0, 0));
                    }
                });

//                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int whichButton) {
//                        // Canceled.
//                    }
//                });

                alert.show();

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
