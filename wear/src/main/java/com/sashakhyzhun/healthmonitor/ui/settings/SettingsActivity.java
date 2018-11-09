package com.sashakhyzhun.healthmonitor.ui.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.TextView;

import com.sashakhyzhun.healthmonitor.R;
import com.sashakhyzhun.healthmonitor.data.prefs.SessionManager;
import com.sashakhyzhun.healthmonitor.ui.settings.about.AboutActivity;
import com.sashakhyzhun.healthmonitor.ui.settings.contact.ContactUsActivity;

import org.jraf.android.androidwearcolorpicker.app.ColorPickActivity;

public class SettingsActivity extends WearableActivity implements View.OnClickListener {

    private static final int REQUEST_PICK_TEXT_COLOR = 1111;
    private static final int REQUEST_PICK_BG_COLOR = 2222;
    private TextView tvEmpty, tvAbout, tvContactUs, tvChangeBGColor, tvChangeTextColor;
    private SessionManager ss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ss = SessionManager.getInstance(getApplicationContext());

        tvEmpty = findViewById(R.id.tvEmpty);
        tvAbout = findViewById(R.id.tvAbout);
        tvContactUs = findViewById(R.id.tvContactUs);
        tvChangeBGColor = findViewById(R.id.tvChangeBGColor);
        tvChangeTextColor = findViewById(R.id.tvChangeTextColor);

        try {
            updateUI();
        } catch (Exception e) {
        }

        tvAbout.setOnClickListener(this);
        tvContactUs.setOnClickListener(this);
        tvChangeBGColor.setOnClickListener(this);
        tvChangeTextColor.setOnClickListener(this);


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_PICK_TEXT_COLOR:
                if (resultCode == RESULT_CANCELED) { break; }

                int pickedTextColor = ColorPickActivity.getPickedColor(data);
                ss.setUserTextColor(pickedTextColor);

                System.out.println("pickedTextColor: " + pickedTextColor);
                System.out.println("ss.getTextColor: " + ss.getUserTextColor());

                updateUI();
                break;
            case REQUEST_PICK_BG_COLOR:
                if (resultCode == RESULT_CANCELED) { break; }

                int pickedBGColor = ColorPickActivity.getPickedColor(data);
                ss.setUserBackgroundColor(pickedBGColor);

                System.out.println("pickedBGColor: " + pickedBGColor);
                System.out.println("ss.getBGColor: " + ss.getUserBackgroundColor());

                updateUI();
                break;
        }
    }

    private void updateUI() {

        tvEmpty.setBackgroundColor(ss.getUserBackgroundColor());
        tvAbout.setBackgroundColor(ss.getUserBackgroundColor());
        tvContactUs.setBackgroundColor(ss.getUserBackgroundColor());
        tvChangeBGColor.setBackgroundColor(ss.getUserBackgroundColor());
        tvChangeTextColor.setBackgroundColor(ss.getUserBackgroundColor());

        tvEmpty.setTextColor(ss.getUserTextColor());
        tvAbout.setTextColor(ss.getUserTextColor());
        tvContactUs.setTextColor(ss.getUserTextColor());
        tvChangeBGColor.setTextColor(ss.getUserTextColor());
        tvChangeTextColor.setTextColor(ss.getUserTextColor());
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvAbout:
                startActivity(new Intent(this, AboutActivity.class));
                break;
            case R.id.tvContactUs:
                startActivity(new Intent(this, ContactUsActivity.class));
                break;
            case R.id.tvChangeTextColor:
                Intent intentTextColor = new ColorPickActivity.IntentBuilder().oldColor(ss.getUserTextColor()).build(this);
                startActivityForResult(intentTextColor, REQUEST_PICK_TEXT_COLOR);
                break;
            case R.id.tvChangeBGColor:
                Intent intentBGColor = new ColorPickActivity.IntentBuilder().oldColor(ss.getUserBackgroundColor()).build(this);
                startActivityForResult(intentBGColor, REQUEST_PICK_BG_COLOR);
                break;
        }
    }
}