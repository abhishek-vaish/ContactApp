package com.example.contact;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemActivity extends AppCompatActivity {

    TextView name;
    TextView phoneNumber;
    TextView mail;
    TextView titleUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        name = findViewById(R.id.name);
        phoneNumber = findViewById(R.id.phone_number);
        mail = findViewById(R.id.email);
        titleUser = findViewById(R.id.title);
        getData();
    }

    private void getData() {
        Intent intent = getIntent();
        name.setText(intent.getStringExtra("Name"));
        phoneNumber.setText(intent.getStringExtra("Number"));
        mail.setText(intent.getStringExtra("Email"));
        titleUser.setText(intent.getStringExtra("Title"));
    }
}
