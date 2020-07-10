package com.example.checkit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Calendar;

/**
 * App allows users to maintain checklists- a daily, weekly and monthly checklist
 * User can add/edit/remove checklists, and set the status of the checklist using values from {@link ItemStatus}
 * Each checklist will reset at the end of their designated time period e.g. daily resets everyday
 * Old checklists can be accessible from archives
 *
 * @author Nabeeha Khurshid
 */
public class MainActivity extends AppCompatActivity {

    /**
     * String of class name for logging
     */
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views
        TabLayout tabLayout = findViewById(R.id.tablayout_activity_main);
        ViewPager2 viewPager2 = findViewById(R.id.viewpager_activity_main);
        FloatingActionButton floatingActionButton = findViewById(R.id.button_checklist_fragment);

        final ListFragmentStateAdapter listFragmentStateAdapter = new ListFragmentStateAdapter(getSupportFragmentManager(), getLifecycle());

        // Set viewPager and set initial fragment to the second fragment (refer to {@link listFragmentStateAdapter#createFragment}
        viewPager2.setAdapter(listFragmentStateAdapter);
        viewPager2.setCurrentItem(1);

        // Set tabs to each fragment depending on the position value of {@link #viewPager2}
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                Log.i(LOG_TAG, "Running onConfigureTab");
                if(position == 0){
                    tab.setText(getString(R.string.archive));
                }else if(position == 1){
                    tab.setText(getString(R.string.monthly));
                }else if(position == 2){
                    tab.setText(getString(R.string.weekly));
                }else if(position == 3){
                    tab.setText(getString(R.string.daily));
                }
            }
        }).attach();

    }
}