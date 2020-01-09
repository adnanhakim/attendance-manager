package com.developer.timetable;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    TextView tvHeader, tvDescription;
    EditText etSap, etPassword;
    Button loginbtn, registerbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialize();

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, TabActivity.class));
            }
        });

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    private void initialize(){
        Typeface productsans = Typeface.createFromAsset(getAssets(), "fonts/product_sans.ttf");
        Typeface roboto = Typeface.createFromAsset(getAssets(), "fonts/roboto.ttf");

        tvHeader = findViewById(R.id.tvLoginHeader);
        tvDescription = findViewById(R.id.tvLoginDescription);
        etSap = findViewById(R.id.etLoginSAP);
        etPassword = findViewById(R.id.etLoginPassword);
        loginbtn = findViewById(R.id.btnLogin);
        registerbtn = findViewById(R.id.btnLoginRegister);

        tvHeader.setTypeface(productsans);
        tvDescription.setTypeface(productsans);
        etSap.setTypeface(productsans);
        etPassword.setTypeface(productsans);
        loginbtn.setTypeface(productsans);
        registerbtn.setTypeface(productsans);
    }

}
