package com.codingwithrufat.eventbusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.codingwithrufat.eventbusapp.model.NotificationEvent;

import org.greenrobot.eventbus.EventBus;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Button eventButton = findViewById(R.id.eventButton);
        EditText editText = findViewById(R.id.etext_value);

        eventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationEvent notificationEvent = new NotificationEvent();
                notificationEvent.setNotification_message(editText.getText().toString().trim());
                EventBus.getDefault().post(notificationEvent);
                finish();
            }
        });

    }
}