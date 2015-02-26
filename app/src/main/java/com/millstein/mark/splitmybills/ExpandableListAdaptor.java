package com.millstein.mark.splitmybills;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Mark
 * on 2/19/15.
 */
public class ExpandableListAdaptor extends AnimatedExpandableListView.AnimatedExpandableListAdapter {

    private Context context;
    private List<Person> personList;

    private String[] bills;


    public ExpandableListAdaptor(Context context, List<Person> personList) {
        this.context = context;

        this.bills = new String[]{context.getString(R.string.first_bill),
                context.getString(R.string.second_bill),
                context.getString(R.string.third_bill),
                context.getString(R.string.fourth_bill),
                context.getString(R.string.fifth_bill),
                context.getString(R.string.sixth_bill)};

        this.personList = personList;
    }

    public void addPerson(Person pPerson) {
        personList.add(pPerson);
        notifyDataSetChanged();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.personList.get(groupPosition).getBillCount(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getRealChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_child, null);
        }


        // TextView Setup
        TextView textView = (TextView) convertView.findViewById(R.id.listChildName);
        textView.setText(bills[childPosition]);

        // EditText Setup
        EditText editText = (EditText) convertView.findViewById(R.id.listChildEditText);
        editText.setText(String.valueOf(this.personList.get(groupPosition).getBillCount(childPosition)));
        editText.setSelectAllOnFocus(true);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                String val = s.toString();
                setChildText(groupPosition, childPosition, val);
            }
        });

        // Arrow buttons setup
        final Button minusButton = (Button) convertView.findViewById(R.id.child_button_minus);
        final Button plusButton = (Button) convertView.findViewById(R.id.child_button_plus);
        plusButton.setBackground(plusButton.getContext().getResources().getDrawable(R.drawable.ic_action_next_item));
        minusButton.setBackground(plusButton.getContext().getResources().getDrawable(R.drawable.ic_action_previous_item));


        minusButton.setOnTouchListener(new View.OnTouchListener() {
            
            Drawable defaultDrawable = minusButton.getBackground();
            
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getActionMasked()){
                    case MotionEvent.ACTION_UP:
                        minusButton.setBackground(defaultDrawable);
                        notifyDataSetChanged();
                        break;
                    case MotionEvent.ACTION_DOWN:
                        adjustChildText(groupPosition, childPosition, -1);
                        minusButton.setBackgroundColor(Color.GRAY);
                        break;
                }
                return true;
            }
        });

        plusButton.setOnTouchListener(new View.OnTouchListener() {

            Drawable defaultDrawable = plusButton.getBackground();

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getActionMasked()){
                    case MotionEvent.ACTION_UP:
                        plusButton.setBackground(defaultDrawable);
                        notifyDataSetChanged();
                        break;
                    case MotionEvent.ACTION_DOWN:
                        adjustChildText(groupPosition, childPosition, 1);
                        plusButton.setBackgroundColor(Color.GRAY);
                        break;
                }
                return true;
            }
        });

        return convertView;
    }
    
    private void adjustChildText(int groupPosition, int childPosition, int pVal) {
        Person person = (Person) getGroup(groupPosition);
        person.setBillValue(childPosition, person.getBillCount(childPosition) + pVal);
    }

    private void setChildText(int groupPosition, int childPosition, String pNewText) {
        Person person = (Person) getGroup(groupPosition);
        int val = (pNewText.equals("")) ? 0 : Integer.valueOf(pNewText);
        person.setBillValue(childPosition, val);
    }

    @Override
    public int getRealChildrenCount(int groupPosition) {
        return this.bills.length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.personList.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.personList.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition,
                             boolean isExpanded,
                             View convertView,
                             ViewGroup parent) {


        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_group, null);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.listGroupTitle);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(personList.get(groupPosition).getName());

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
