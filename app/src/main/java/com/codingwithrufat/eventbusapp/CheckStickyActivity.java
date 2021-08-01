package com.codingwithrufat.eventbusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.codingwithrufat.eventbusapp.model.NotificationEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class CheckStickyActivity extends AppCompatActivity {

    private static final String TAG = "CheckStickyActivity";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_sticky);

        textView = findViewById(R.id.value);


    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

     /**
     * MAIN thread is for UI updates
     * sticky saves last event in memory
     * @param event
     */
    @Subscribe(sticky = true, threadMode = ThreadMode.POSTING)
    public void onStickyEvent(NotificationEvent event){
        textView.setText(event.getNotification_message());
        Log.d(TAG, "onStickyEvent: Event saved in memory and value is -> " + event.getNotification_message());
    }

}