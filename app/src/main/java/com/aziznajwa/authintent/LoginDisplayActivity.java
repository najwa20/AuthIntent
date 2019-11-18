package com.aziznajwa.authintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginDisplayActivity extends AppCompatActivity {
    Intent i;
    TextView t1;
    TextView t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_display);
        i = getIntent();
        t1=findViewById(R.id.email_display);
        t2=findViewById(R.id.password_display);
        if(i !=null)
        {
            String email=i.getStringExtra("email");
            String password=i.getStringExtra("password");
            t1.setText(email);
            t2.setText(password);
        }
    }
}
