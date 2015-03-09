package com.alanjames1987.hotworddetector;

import android.content.Intent;
import android.os.Bundle;
import android.service.voice.AlwaysOnHotwordDetector;
import android.service.voice.AlwaysOnHotwordDetector.Callback;
import android.service.voice.VoiceInteractionService;
import android.util.Log;

import java.util.Locale;

public class HotwordService extends VoiceInteractionService {

    private final String LOG_TAG = "HotwordService";

    Locale locale = new Locale("nl-el");

    AlwaysOnHotwordDetector hotwordDetector;

    @Override
    public void onCreate() {

        Log.i(LOG_TAG, "onCreate");

        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i(LOG_TAG, "onStartCommand");

        Bundle args = new Bundle();

        startSession(args);
        stopSelf(startId);

        return START_NOT_STICKY;

    }

    @Override
    public void onReady() {

        Log.i(LOG_TAG, "onReady");

        super.onReady();

        hotwordDetector = createAlwaysOnHotwordDetector("google", locale, callback);

    }

    Callback callback = new Callback() {

        @Override
        public void onRecognitionResumed() {
            // TODO Auto-generated method stub
        }

        @Override
        public void onRecognitionPaused() {
            // TODO Auto-generated method stub
        }

        @Override
        public void onError() {
            // TODO Auto-generated method stub
            Log.d(LOG_TAG, "error");
        }

        @Override
        public void onDetected(AlwaysOnHotwordDetector.EventPayload eventPayload) {
            Log.d(LOG_TAG, "onDetected");
        }

        @Override
        public void onAvailabilityChanged(int status) {
            // TODO Auto-generated method stub
        }

    };

}
