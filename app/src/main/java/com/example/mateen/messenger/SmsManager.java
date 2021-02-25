package com.example.mateen.messenger;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SmsManager extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String number = intent.getStringExtra("phone");
        String msg = intent.getStringExtra("message");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                try {
                    if (number.isEmpty()) {
                        Toast.makeText(this, "Please Enter a Number", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        android.telephony.SmsManager smsManager = android.telephony.SmsManager.getDefault();
                        smsManager.sendTextMessage(number, "null", msg, null, null);
                        Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Failed to send message", Toast.LENGTH_SHORT).show();
                }
            }
//            else {
//                Toast.makeText(this,"Please allow permission to send message", Toast.LENGTH_SHORT).show();
//                requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 1);
//            }
        }
        return START_STICKY;
    }
}
