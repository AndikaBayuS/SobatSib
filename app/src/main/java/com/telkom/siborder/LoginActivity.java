package com.telkom.siborder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.telkom.siborder.MainActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login = findViewById(R.id.btn_login);
        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String User = username.getText().toString();
                String Pass = password.getText().toString();
                if(User.equals("guest") && Pass.equals("guest")){
                    Intent next = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(next);
                    finish();

                } else if(User.matches("")|| Pass.matches("")){
                    Toast.makeText(getApplication(),"Username atau password tidak boleh kosong", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplication(), "Gagal Login, Username atau password Salah", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
