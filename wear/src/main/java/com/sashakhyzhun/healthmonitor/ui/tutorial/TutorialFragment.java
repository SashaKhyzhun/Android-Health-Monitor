package com.sashakhyzhun.healthmonitor.ui.tutorial;

import android.os.Bundle;
import android.support.wearable.view.CardFragment;

/**
 * @author SashaKhyzhun
 *         Created on 9/9/17.
 */

public class TutorialFragment extends CardFragment {

    public static TutorialFragment newInstance(int rowNum, int colNum) {
        Bundle args = new Bundle();
        switch (colNum) {
            case 0:
                args.putString(CardFragment.KEY_TITLE, "Keep your tasks");
                args.putString(CardFragment.KEY_TEXT, "with Wear Todo");
                break;
            case 1:
                args.putString(CardFragment.KEY_TITLE, "One tap will");
                args.putString(CardFragment.KEY_TEXT, "record a new local note");
                break;
            case 2:
                args.putString(CardFragment.KEY_TITLE, "One long-tap will");
                args.putString(CardFragment.KEY_TEXT, "open the menu");
                break;
            case 3:
                args.putString(CardFragment.KEY_TITLE, "You can swipe");
                args.putString(CardFragment.KEY_TEXT, "between local and mobile todo lists");
                break;
            case 4:
                args.putString(CardFragment.KEY_TITLE, "One tap on the");
                args.putString(CardFragment.KEY_TEXT, "local list will delete an local item");
                break;
            case 5:
                args.putString(CardFragment.KEY_TITLE, "One tap on the");
                args.putString(CardFragment.KEY_TEXT, "shared list will delete an item on both devices");
                break;
            case 6:
                args.putString(CardFragment.KEY_TITLE, "Great job!");
                args.putString(CardFragment.KEY_TEXT, "You have finished tutorial");
                break;
        }

        TutorialFragment f = new TutorialFragment();
        f.setArguments(args);
        return f;
    }
}