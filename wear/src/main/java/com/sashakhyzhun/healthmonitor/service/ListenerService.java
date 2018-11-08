package com.sashakhyzhun.healthmonitor.service;

import android.content.Intent;
import android.util.Log;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

public class ListenerService extends WearableListenerService {

    private static final String TAG = ListenerService.class.getSimpleName();

    private static final String WEAR_START_ACTIVITY = "/start";



    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        try {
            Log.e(TAG, "onMessageReceived: LISTENER SERVICE, HELLO!");
            if (messageEvent.getPath().equals(WEAR_START_ACTIVITY)) {
                final String message = new String(messageEvent.getData());
                Intent intent = new Intent(this, SplashActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } else {
                super.onMessageReceived(messageEvent);
            }
        } catch (Exception e) {
            FirebaseCrash.report(e);
        }
    }


}