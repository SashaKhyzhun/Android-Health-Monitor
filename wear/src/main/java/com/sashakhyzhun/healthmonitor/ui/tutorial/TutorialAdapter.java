package com.sashakhyzhun.healthmonitor.ui.tutorial;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.support.wearable.view.FragmentGridPagerAdapter;


import com.sashakhyzhun.healthmonitor.R;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SashaKhyzhun
 *         Created on 9/9/17.
 */

class TutorialAdapter extends FragmentGridPagerAdapter {

    private static final int NUM_ROWS = 1;
    private static final int NUM_COLS = 7;
    private Map<Point, Drawable> mBackgrounds = new HashMap<>();

    private Context mContext;


    TutorialAdapter(Context ctx, FragmentManager fm) {
        super(fm);
        mContext = ctx;
    }

    @Override
    public int getRowCount() {
        return NUM_ROWS;
    }

    @Override
    public int getColumnCount(int rowNum) {
        return NUM_COLS;
    }


    @Override
    public Fragment getFragment(int rowNum, int colNum) {
        return TutorialFragment.newInstance(rowNum, colNum);
    }

    @Override
    public Drawable getBackgroundForPage(int row, int column) {
        Point pt = new Point(column, row);
        Drawable drawable = mBackgrounds.get(pt);

        switch (column) {
            case 0:
                drawable = mContext.getResources().getDrawable(R.drawable.tutorial0);
                break;
            case 1:
                drawable = mContext.getResources().getDrawable(R.drawable.tutorial1);
                break;
            case 2:
                drawable = mContext.getResources().getDrawable(R.drawable.tutorial1);
                break;
            case 3:
                // swipe
                drawable = mContext.getResources().getDrawable(R.drawable.tutorial4);
                break;
            case 4:
                drawable = mContext.getResources().getDrawable(R.drawable.tutorial3);
                break;
            case 5:
                // shared list
                drawable = mContext.getResources().getDrawable(R.drawable.tutorial3);
                break;
            case 6:
                drawable = mContext.getResources().getDrawable(R.drawable.tutorial0);
                break;
        }
        return drawable;
    }

}