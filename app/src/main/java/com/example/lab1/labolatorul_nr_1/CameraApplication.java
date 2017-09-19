package com.example.lab1.labolatorul_nr_1;

import android.app.Activity;
import android.app.Application;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Timestamp;



public class CameraApplication extends AppCompatActivity  {

    private EditText inputGoogle;
    private String googleBaseUrl = "http://www.google.com/search?q=";
    private boolean receiveNotifications;
    Intent intent;

//    @Override
//    public void onClick(View v) {
//        Intent nextPage = new Intent(CameraApplication.this, SecondPage.class);
//        startActivity(nextPage);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_camera_application);

        //code to set multiple buttons on the same page
        defineButtons();
    }

//    Using the onClick attribute of the Button
//    public void goToAnActivity(View view) {
//        startActivity(new Intent(CameraApplication.this, CameraApplication.class));
////        Intent Intent = new Intent(this, FrontBackCamera.class);
////        startActivity(Intent);
//    }
//
//    public void goToAnotherActivity(View view) {
//        Intent Intent = new Intent(this, CameraApplication.class);
//        startActivity(Intent);
//    }

    String str;
    public void defineButtons() {
        findViewById(R.id.button).setOnClickListener(buttonClickListener);
        findViewById(R.id.button2).setOnClickListener(buttonClickListener);
        findViewById(R.id.A).setOnClickListener(buttonClickListener);
        findViewById(R.id.B).setOnClickListener(buttonClickListener);
        RadioGroup group = (RadioGroup)findViewById(R.id.group);

//        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
//        {
//            @Override
//            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
//                Log.d("Tag", "Changed");
//                if (checkedId==R.id.A) {
//                    Log.d("Tag", "Front Camera");
////                    str = "button1Text";
//
//                }
//                else if (checkedId==R.id.B) str = "button2Text";
//                    Log.d("Tag", "Back Camera");
//            }
//        });

        inputGoogle = (EditText) findViewById(R.id.editText);


    }







    private View.OnClickListener buttonClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.button2:
//                    NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
//                    notificationBuilder.setContentTitle("Notification Laboratory ");
//                    notificationBuilder.setContentText("test");
//                    notificationBuilder.setAutoCancel(true);
//                    notificationBuilder.setSmallIcon(R.mipmap.ic_launcher);
//                    Intent intent = new Intent(getBaseContext(), CameraApplication.class);
//                    //search ib google Context_andoid_ app in the net
//
//                    PendingIntent pendingIntent = PendingIntent.getActivity(android.content.Context, 0, intent, PendingIntent.FLAG_ONE_SHOT);
//                    notificationBuilder.setContentIntent(pendingIntent);
//                    NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//                    notificationManager.notify(0, notificationBuilder.build());
                    break;
                case R.id.button:
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(googleBaseUrl + inputGoogle.getText())));
                    break;
                case R.id.A:
                    Intent launchIntent2 = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                    launchIntent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    launchIntent2.putExtra("android.intent.extras.CAMERA_FACING", android.hardware.Camera.CameraInfo.CAMERA_FACING_BACK);
                    launchIntent2.putExtra("android.intent.extras.LENS_FACING_BACK", 1);
                    launchIntent2.putExtra("android.intent.extra.USE_BACK_CAMERA", true );
                    startActivity(launchIntent2);
//                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//                    startActivity(intent);
                    break;
                case R.id.B:
                    //will be code for front camera
                    Intent launchIntent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                    launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    launchIntent.putExtra("android.intent.extras.CAMERA_FACING", android.hardware.Camera.CameraInfo.CAMERA_FACING_FRONT);
                    launchIntent.putExtra("android.intent.extras.LENS_FACING_FRONT", 1);
                    launchIntent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
                    startActivity(launchIntent);
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

//    RadioGroup rg;
//    RadioButton rb;
//code to check if radiobutton was pressed
//    private void rbClick(View v)
//    {
//        int radiobuttonid = rg.getCheckedRadioButtonId();
//        rb = (RadioButton) findViewById(radiobuttonid);
//        Toast.makeText(getBaseContext(), rb.getText(), Toast.LENGTH_LONG).show();
//    }


//code for front camera and capturing image
//        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//              Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(intent, 0);
//            }
//        });

