package com.sashakhyzhun.healthmonitor.data.model;

import java.util.ArrayList;

/**
 * @author SashaKhyzhun
 * Created on 6/20/17.
 */

public class SimpleRow {

    private final ArrayList<SimplePage> mPagesRow = new ArrayList<>();

    public void addPages(SimplePage page) {
        mPagesRow.add(page);
    }

    public SimplePage getPages(int index) {
        return mPagesRow.get(index);
    }

    public int size(){
        return mPagesRow.size();
    }

}