/*
* Copyright (C) 2017 Black Orchid Studio. All Rights Reserved.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.sashakhyzhun.healthmonitor.ui.profile.settings.contact;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sashakhyzhun.healthmonitor.R;
import com.sashakhyzhun.healthmonitor.data.prefs.WearSessionManager;

import java.util.List;

/**
 * @author SashaKhyzhun
 * Created on 1/14/17.
 */
public class ContactUsActivity extends WearableActivity implements View.OnClickListener {

    private static final String recipient = "sasha.khyzhun@gmail.com";
    private TextView tvTapToRecord, tvYouCanWriteToUs, tvOR;
    private WearSessionManager ss;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        ss = WearSessionManager.getInstance(getApplicationContext());


        tvOR = findViewById(R.id.textViewOR);
        tvTapToRecord = findViewById(R.id.tv_tap_to_record);
        tvYouCanWriteToUs = findViewById(R.id.textViewYouCanWriteToUs);

        try {
            updateUI();
        } catch (Exception e) {
            //FirebaseCrash.report(e);
        }

        tvTapToRecord.setOnClickListener(this);
    }


    private void updateUI() {
//        tvOR.setTextColor(ss.getUserBackgroundColor());
//        tvGoBack.setTextColor(ss.getUserBackgroundColor());
//        tvTapToRecord.setTextColor(ss.getUserBackgroundColor());
//        tvYouCanWriteToUs.setTextColor(ss.getUserBackgroundColor());
        tvOR.setTextColor(ss.getUserTextColor());
        tvTapToRecord.setTextColor(ss.getUserTextColor());
        tvYouCanWriteToUs.setTextColor(ss.getUserTextColor());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_tap_to_record:
                displaySpeechScreen();
                break;
        }

    }

    private void displaySpeechScreen() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        startActivityForResult(intent, 228);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == 228) {
                List<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                String message = results.get(0);
                try {
                    sendEmail(message);
                } catch (Exception e) {
                    //FirebaseCrash.report(e);
                }
            }
        }

    }

    private void sendEmail(String message) {
        Intent email = new Intent(Intent.ACTION_SEND_MULTIPLE, Uri.parse("mailto:"));
        email.setType("message/rfc822");
        email.putExtra(Intent.EXTRA_EMAIL,   recipient);
        email.putExtra(Intent.EXTRA_SUBJECT, message);
        email.putExtra(Intent.EXTRA_TEXT,    message);

        try {
            startActivity(Intent.createChooser(email, "Choose an email client from..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(ContactUsActivity.this, "No email client installed.", Toast.LENGTH_SHORT).show();
        } finally {
            finish();
        }
    }

}
