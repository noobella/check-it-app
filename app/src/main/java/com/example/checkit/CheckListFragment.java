package com.example.checkit;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class CheckListFragment extends Fragment {

    private int position;

    public CheckListFragment() {
        // Required empty public constructor
    }

    public CheckListFragment(int position){
        this.position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentLayout = inflater.inflate(R.layout.fragment_check_list, container, false);
        ListView fragmentListView = fragmentLayout.findViewById(R.id.listview_checklist_fragment);
        TextView title = fragmentLayout.findViewById(R.id.title_checklist_fragment);
        //FloatingActionButton button = fragmentLayout.findViewById(R.id.button_checklist_fragment);

        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        String week = calendar.getDisplayName(Calendar.WEEK_OF_MONTH, Calendar.LONG_FORMAT, Locale.ENGLISH);


        // TODO Resolve null issue with Calendar.WEEK_OF_MONTH
        switch(position){
            case 1:
                title.setText(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG_FORMAT, Locale.ENGLISH));
                break;
            case 2:
                title.setText(getString(R.string.current_week, calendar.getDisplayName(Calendar.WEEK_OF_MONTH, Calendar.LONG_FORMAT, Locale.ENGLISH)));
                break;
            case 3:
                title.setText(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG_FORMAT, Locale.ENGLISH));
                break;
        }

        ArrayList<CheckItem> checkItemArrayList = new ArrayList<>();
        checkItemArrayList.add(new CheckItem(ItemStatus.NOT_STARTED, "Do homework"));
        checkItemArrayList.add(new CheckItem(ItemStatus.NOT_STARTED, "Go to store"));
        checkItemArrayList.add(new CheckItem(ItemStatus.STARTED, "Train for marathon"));
        checkItemArrayList.add(new CheckItem(ItemStatus.STARTED, "Go to cinema"));
        checkItemArrayList.add(new CheckItem(ItemStatus.IMPORTANT, "Sleep"));

        Collections.sort(checkItemArrayList, new CheckItemComparator());

        CheckListArrayAdapter checkListArrayAdapter = new CheckListArrayAdapter(getContext(), checkItemArrayList);
        fragmentListView.setAdapter(checkListArrayAdapter);

        return fragmentLayout;
    }
}