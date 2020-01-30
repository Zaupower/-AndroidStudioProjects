package com.example.tfinalmenu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter  extends FragmentPagerAdapter {

    private int numOfTabs;

    public PageAdapter( FragmentManager fm, int numOfTabs) {
        super(fm,numOfTabs);

        this.numOfTabs=numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Tab1 tab1= new Tab1();
                return  tab1;
            case 1:
                Tab2 tab2= new Tab2();
                return new Tab2();
            case 2:
                Tab3 tab3 = new Tab3();
                return new Tab3();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

}
