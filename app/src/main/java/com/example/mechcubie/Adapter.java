package com.example.mechcubie;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Adapter extends FragmentPagerAdapter {

    private Context context;
    int totaltabs;

    public Adapter(Context context, FragmentManager fm,int totaltabs) {
        super(fm);
        this.context=context;
        this.totaltabs=totaltabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FirstFragment firstFragment=new FirstFragment();
                return  firstFragment;
            case 1:
                SecondFragment secondFragment=new SecondFragment();
                return  secondFragment;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return totaltabs;
    }
}
