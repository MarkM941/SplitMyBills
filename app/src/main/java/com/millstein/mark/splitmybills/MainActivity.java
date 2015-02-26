package com.millstein.mark.splitmybills;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    ExpandableListAdaptor listAdapter;
    AnimatedExpandableListView expandableListView;
    List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the listview
        expandableListView = (AnimatedExpandableListView) findViewById(R.id.personExpandableList);

        // preparing list data
        personList = new ArrayList<>();
        personList.add(new Person("Mark", 0, 0, 0, 0, 0, 0));
        listAdapter = new ExpandableListAdaptor(this, personList);

        expandableListView = (AnimatedExpandableListView) findViewById(R.id.personExpandableList);
        expandableListView.setAdapter(listAdapter);
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if (expandableListView.isGroupExpanded(groupPosition)) {
                    expandableListView.collapseGroupWithAnimation(groupPosition);
                } else {
                    expandableListView.expandGroupWithAnimation(groupPosition);
                }
                return true;
            }

        });

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

                alert.setNegativeButton("Cancel", null);

                alert.show();

                break;
        }

        return super.onOptionsItemSelected(item);
    }
    
    public void actionSplitBillButtonPressed(View pView) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("App Output");
        alert.setMessage("This is where the output will be");

        alert.setPositiveButton("Ok", null);

        alert.show();
    }
}
