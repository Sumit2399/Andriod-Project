package com.masterandroid.glbapplication;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

     private int numOfTabs;
     private Context myContext;

    public PagerAdapter(Context context, FragmentManager fm, int numOfTabs) {
        super(fm);
        myContext=context;
        this.numOfTabs = numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                NoteFragment noteFragment=new NoteFragment();
                return noteFragment;
            case 1:
                CircularFragment circularFragment=new CircularFragment();
                return circularFragment;
            case 2:
                CalendarFragment calendarFragment=new CalendarFragment();
                return calendarFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
