package com.example.contact;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText mobileNumber;
    EditText title;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        hook();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveContact();
            }
        });
    }

    private void hook() {
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        mobileNumber = findViewById(R.id.mobile_number);
        title = findViewById(R.id.title);
        save = findViewById(R.id.save);
    }


    private void saveContact() {
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        String fullName = name.getText().toString().trim();
        String mail = email.getText().toString().trim();
        String phoneNumber = mobileNumber.getText().toString().trim();
        String personTitle = title.getText().toString().trim();
        Contact contact = new Contact();
        contact.setName(fullName);
        contact.setEmail(mail);
        contact.setNumber(phoneNumber);
        contact.setTitle(personTitle);
        if (databaseHelper.onInsertion(contact)) {
            Toast.makeText(AddActivity.this, "Save", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(AddActivity.this, "Fail", Toast.LENGTH_SHORT).show();
        }
    }
}
