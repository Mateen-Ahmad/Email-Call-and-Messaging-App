package com.example.mateen.messenger;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MailActivity extends AppCompatActivity {

    private EditText email, subject, message;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);

        email = findViewById(R.id.email);
        subject = findViewById(R.id.subject);
        message = findViewById(R.id.message);
        button = findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senEmail();
            }
        });
    }


    private void senEmail() {
        String mEmail = email.getText().toString();
        String mSubject = subject.getText().toString();
        String mMessage = message.getText().toString();
        try {
            if(mEmail.isEmpty()) {
                Toast.makeText(this, "Please provide a valid Email Address", Toast.LENGTH_SHORT).show();
            }
            else {
                EmailSender emailSender = new EmailSender(this, mEmail, mSubject, mMessage);
                emailSender.execute();
                Toast.makeText(this, "Mail Sent", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Email Sending Failed", Toast.LENGTH_SHORT).show();
        }

    }

}



