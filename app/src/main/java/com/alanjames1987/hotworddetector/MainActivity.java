package com.alanjames1987.hotworddetector;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    Context ctx;
    TextToSpeech speechOutput;
    EditText input;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ctx = getApplicationContext();

        speechOutput = new TextToSpeech(getApplicationContext(), null);
        speechOutput.setSpeechRate((float) 1.2);

        input = (EditText) findViewById(R.id.editText);

        button = (Button) findViewById(R.id.start);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
//                Toast.makeText(ctx, "TOAST", Toast.LENGTH_LONG).show();
                startService(new Intent(MainActivity.this, HotwordService.class));

                CharSequence notification = (CharSequence) input.getText().toString();
                speechOutput.speak(notification, TextToSpeech.QUEUE_ADD, null, "poop");

            }

        });

    }

}
