package com.example.mateen.messenger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class sendSmsAct extends AppCompatActivity {

    TextView  message, number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
    }

    public void sendMessage(View view) {

        message = findViewById(R.id.editMessage);
        number = findViewById(R.id.editNumber);
        Intent i = new Intent(this, SmsManager.class);
        i.putExtra("message", message.getText().toString());
        i.putExtra("phone", number.getText().toString());
        startService(i);


//        message = findViewById(R.id.editMessage);
//        number = findViewById(R.id.editNumber);
//        String msg = message.getText().toString();
//        String phoneNumber = number.getText().toString();
//        String number = phoneNumber;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//
//            if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
//                try {
//                    android.telephony.SmsManager smsManager = android.telephony.SmsManager.getDefault();
//                    smsManager.sendTextMessage(number, "null", msg, null, null);
//                    Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show();
//                }
//            }
//            else {
//
//                requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 1);
//            }
//        }





//        Intent i = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "03034824980", null));
//        i.putExtra("sms_body", "Hello Mateen");
//        startActivity(i);

//        Intent intentt = new Intent(Intent.ACTION_VIEW);
//        intentt.setData(Uri.parse("sms:"));
//        intentt.setType("text/plain");
//        intentt.setType("vnd.android-dir/mms-sms");
//        intentt.putExtra(Intent.EXTRA_TEXT, "hhhhhhh");
//        intentt.putExtra("address", "0080808080");
//        startActivityForResult(Intent.createChooser(intentt, ""), 0);



//        String defaultSmsPackageName = Telephony.Sms.getDefaultSmsPackage(this); // Need to change the build to API 19
//
//        Intent sendIntent = new Intent(Intent.ACTION_SEND);
//        sendIntent.setType("text/plain");
//        sendIntent.putExtra(Intent.EXTRA_TEXT, "text");
//
//        if (defaultSmsPackageName != null)// Can be null in case that there is no default, then the user would be able to choose
//        // any app that support this intent.
//        {
//            sendIntent.setPackage(defaultSmsPackageName);
//        }
//        startActivity(sendIntent);
    }
}
