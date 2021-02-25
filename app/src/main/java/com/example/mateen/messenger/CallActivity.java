package com.example.mateen.messenger;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
    }
    public void makeCall(View view) {
        TextView phoneNumber = (TextView) findViewById(R.id.editTextPhone);
        String num = phoneNumber.getText().toString();
        String normalizedPhoneNumber = PhoneNumberUtils.normalizeNumber(phoneNumber.getText().toString());
        Intent intent = new Intent(Intent.ACTION_CALL);
        if(normalizedPhoneNumber.isEmpty()) {
            Toast.makeText(this,"Please Enter Number", Toast.LENGTH_SHORT).show();
        }
        else {
            String uri = "tel:" + normalizedPhoneNumber.trim() ;
            intent.setData(Uri.parse(uri));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                startActivity(intent);
            }
            else {
                Toast.makeText(this,"Please allow permission to call", Toast.LENGTH_SHORT).show();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[] {Manifest.permission.CALL_PHONE},1);
                }
            }
        }
    }
}
