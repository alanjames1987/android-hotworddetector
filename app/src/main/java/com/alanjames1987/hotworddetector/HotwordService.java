package com.alanjames1987.hotworddetector;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.voice.AlwaysOnHotwordDetector;
import android.service.voice.AlwaysOnHotwordDetector.Callback;
import android.service.voice.VoiceInteractionService;
import android.util.Log;
import android.widget.Toast;

import java.util.Locale;

public class HotwordService extends VoiceInteractionService {

    @Override
    public void onCreate() {

        super.onCreate();

        ctx = getApplicationContext();

        Log.i("AlanJamesVoice", "onCreate");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle args = new Bundle();
        startSession(args);
        stopSelf(startId);
        return START_NOT_STICKY;
    }

    @Override
    public void onReady() {

        super.onReady();

        Log.i("AlanJamesVoice", "onReady");

        Toast.makeText(ctx, "onReady", Toast.LENGTH_LONG).show();

        hotwordDetector = createAlwaysOnHotwordDetector("google", locale, callback);

    }

    Context ctx;

    Locale locale = new Locale("nl-el");

    AlwaysOnHotwordDetector hotwordDetector;

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
            Log.d("error", "error");
        }

        @Override
        public void onDetected(AlwaysOnHotwordDetector.EventPayload eventPayload) {
            // TODO Auto-generated method stub
            // Display Toast message when Hotword is detected
            Toast.makeText(ctx, "Google", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onAvailabilityChanged(int status) {
            // TODO Auto-generated method stub
        }

    };

}
