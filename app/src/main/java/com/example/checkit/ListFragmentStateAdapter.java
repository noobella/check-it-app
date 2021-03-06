package com.example.checkit;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ListFragmentStateAdapter extends FragmentStateAdapter {

    /**
     * String of class name for logging
     */
    private static final String LOG_TAG = ListFragmentStateAdapter.class.getSimpleName();

    public ListFragmentStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    /**
     * Returns a new fragment depending on the value of position
     * @param position Value depends on viewpager
     * @return A new fragment
     */
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Log.i(LOG_TAG, "Running createFragment");
        if(position == 0) {
            return new ArchiveFragment();
        }else{
            return new CheckListFragment(position);
        }
    }

    /**
     * Returns the number of fragments
     * @return Fragment count
     */
    @Override
    public int getItemCount() {
        return 4;
    }

}
