package com.aziznajwa.authintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText EXTRA_LOGIN;
    EditText EXTRA_PASSWORD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.connect);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EXTRA_LOGIN=findViewById(R.id.user_email);
                EXTRA_PASSWORD=findViewById(R.id.user_password);
                if((EXTRA_LOGIN.getText().length()==0)||(EXTRA_PASSWORD.getText().length()==0))
                {
                    Toast.makeText(getApplicationContext(),"l'email et le mot de passe sont obligatoires", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Pattern p=Pattern.compile(".+@.+\\.[a-z]+");
                    Matcher m=p.matcher(EXTRA_LOGIN.getText().toString());
                    if(m.matches())
                    {
                        Intent i = new Intent(getApplicationContext(), LoginDisplayActivity.class);
                        i.putExtra("email",EXTRA_LOGIN.getText().toString());
                        i.putExtra("password",EXTRA_PASSWORD.getText().toString());
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"email invalide", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
