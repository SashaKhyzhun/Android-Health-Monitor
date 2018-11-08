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
package com.sashakhyzhun.healthmonitor;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.DelayedConfirmationView;
import android.view.View;

import com.sashakhyzhun.healthmonitor.util.NoteUtil;

public class DeleteTaskActivity extends WearableActivity implements DelayedConfirmationView.DelayedConfirmationListener {

    private DelayedConfirmationView delayedConfirmationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        delayedConfirmationView = findViewById(R.id.delayed_confirm);

        delayedConfirmationView.setListener(this);
        delayedConfirmationView.setTotalTimeMs(2000);
        delayedConfirmationView.start();

    }

    @Override
    public void onTimerFinished(View view) {
        try {
            NoteUtil.displayConfirmation("Deleted", this);
            String id = getIntent().getStringExtra("id");
            NoteUtil.removeNote(id, this);
            setResult(RESULT_OK);
            finish();
        } catch (Exception e) {
            //FirebaseCrash.report(e);
        }
    }

    @Override
    public void onTimerSelected(View view) {
        try {
            NoteUtil.displayConfirmation("Canceled", this);
            delayedConfirmationView.reset();
            setResult(RESULT_CANCELED);
            finish();
        } catch (Exception e) {
            //FirebaseCrash.report(e);
        }
    }
}
