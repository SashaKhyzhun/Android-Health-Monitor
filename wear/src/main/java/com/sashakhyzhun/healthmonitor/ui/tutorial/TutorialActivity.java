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
package com.sashakhyzhun.healthmonitor.ui.tutorial;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.GridViewPager;
import android.view.View;
import android.widget.ImageButton;

import com.sashakhyzhun.healthmonitor.R;
import com.sashakhyzhun.healthmonitor.data.prefs.SessionManager;
import com.sashakhyzhun.healthmonitor.ui.splash.SplashActivity;

/**
 * @author SashaKhyzhun
 * Created on 2/5/17.
 */
public class TutorialActivity extends WearableActivity {

    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        sessionManager = SessionManager.getInstance(getApplicationContext());
        GridViewPager mPager = findViewById(R.id.fragment_container);
        TutorialAdapter mAdapter = new TutorialAdapter(this, getFragmentManager());
        mPager.setAdapter(mAdapter);

        final ImageButton button = findViewById(R.id.buttonStart);
        mPager.setOnPageChangeListener(new GridViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, int i1, float v, float v1, int i2, int i3) {}

            @Override
            public void onPageSelected(int i, int i1) {
                if (i1 == 6) {
                    button.setVisibility(View.VISIBLE);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            sessionManager.createUserLoginSession(Color.BLACK, Color.WHITE);
                            startActivity(new Intent(getApplicationContext(), SplashActivity.class));
                            finish();
                        }
                    });
                } else {
                    button.setVisibility(View.INVISIBLE);
                    button.setOnClickListener(null);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {}
        });

    }


}
