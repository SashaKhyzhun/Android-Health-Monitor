package com.sashakhyzhun.healthmonitor.data.model;

/**
 * @author SashaKhyzhun
 * Created on 6/20/17.
 */

public class SimplePage {

    private String mTitle;
    private String mText;
    private int mIconId;
    private int mBackgroundId;

    public SimplePage(String title, String text, int iconId, int backgroundId) {
        this.mTitle = title;
        this.mText = text;
        this.mIconId = iconId;
        this.mBackgroundId = backgroundId;
    }

}