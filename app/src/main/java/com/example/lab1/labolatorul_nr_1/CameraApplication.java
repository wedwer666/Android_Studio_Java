package com.example.lab1.labolatorul_nr_1;

import android.app.Application;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class CameraApplication extends AppCompatActivity {

    private EditText inputGoogle;
    private String googleBaseUrl = "http://www.google.com/search?q=";
    private boolean receiveNotifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_camera_application);



        //code to set multiple buttons on the same page
        defineButtons();
    }

    public void defineButtons() {
        findViewById(R.id.button).setOnClickListener(buttonClickListener);
        findViewById(R.id.button2).setOnClickListener(buttonClickListener);
        findViewById(R.id.radioButton).setOnClickListener(buttonClickListener);
        findViewById(R.id.radioButton2).setOnClickListener(buttonClickListener);
        inputGoogle = (EditText) findViewById(R.id.editText);
    }


    private View.OnClickListener buttonClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button2:
                    NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
                    notificationBuilder.setContentTitle("Notification Laboratory ");
                    notificationBuilder.setContentText("test");
                    notificationBuilder.setAutoCancel(true);
                    notificationBuilder.setSmallIcon(R.mipmap.ic_launcher);
                    Intent intent = new Intent(getBaseContext(), CameraApplication.class);
                    //search ib google Context_andoid_ app in the net
                    PendingIntent pendingIntent = PendingIntent.getActivity(Application., 0, intent, PendingIntent.FLAG_ONE_SHOT);
//                    notificationBuilder.setContentIntent(pendingIntent);
                    NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    notificationManager.notify(0, notificationBuilder.build());
                    break;
                case R.id.button:
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(googleBaseUrl + inputGoogle.getText())));
                    break;
                case R.id.radioButton:
                    //handle radio button for front camera
//                        boolean checked = ((radioButton) v).isChecked();

                    break;
                case R.id.radioButton2:
                    //handle radio button for back camera
                    break;
            }
        }
    };


//        Button settings = (Button)findViewById(R.id.button);
//
//        //code for push notification
//        settings.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//        //code for google search in application
//        Button settings2 = (Button)findViewById(R.id.button2);
//        settings2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            //https://stackoverflow.com/questions/4930228/open-a-url-on-click-of-ok-button-in-android
//            public void onClick(View v) {
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com")));
//            }
//        });
}

