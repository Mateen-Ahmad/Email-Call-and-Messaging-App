package com.example.mateen.messenger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this,"Permission Granted", Toast.LENGTH_SHORT);
        }
        else {
            Toast.makeText(this,"Please allow permission to Send SMS", Toast.LENGTH_SHORT).show();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[] {Manifest.permission.SEND_SMS},1);
            }
        }
    }
    public void call(View view) {
        Intent i = new Intent(this, CallActivity.class);
        startActivity(i);
    }
    public void email(View view) {
        Intent i = new Intent(this, MailActivity.class);
        startActivity(i);
    }
    public void sms(View view) {
//        Intent i = new Intent(this, sendSmsAct.class);
//        startActivity(i);
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setType("vnd.android-dir/mms-sms");
        startActivity(intent);
    }
}