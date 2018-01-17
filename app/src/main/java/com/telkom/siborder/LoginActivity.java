package com.telkom.siborder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.telkom.siborder.MainActivity;

public class LoginActivity extends AppCompatActivity {

    String user;
    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login = findViewById(R.id.btn_login);

        final EditText password = findViewById(R.id.password);

        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView text, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    sendLogin();
                    handled = true;
                }
                return handled;
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendLogin();
            }
        });
    }

    private void sendLogin() {
        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);

        user = username.getText().toString();
        pass = password.getText().toString();

        if (user.equals("guest") && pass.equals("guest")) {
            Intent next = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(next);
            finish();
        } else if (user.matches("") || pass.matches("")){
            Toast.makeText(getApplication(), R.string.login_error_empty, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplication(), R.string.login_error_invalid, Toast.LENGTH_LONG).show();
        }
    }
}
