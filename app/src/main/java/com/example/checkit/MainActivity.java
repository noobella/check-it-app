package com.example.checkit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tablayout_activity_main);
        ViewPager2 viewPager2 = findViewById(R.id.viewpager_activity_main);

        final ListFragmentStateAdapter listFragmentStateAdapter = new ListFragmentStateAdapter(getSupportFragmentManager(), getLifecycle());

        viewPager2.setAdapter(listFragmentStateAdapter);
        viewPager2.setCurrentItem(1);

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