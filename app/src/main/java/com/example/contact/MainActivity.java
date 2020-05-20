package com.example.contact;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView contactList;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<String> phoneNumber = new ArrayList<>();
    ArrayList<String> email = new ArrayList<>();
    ArrayList<String> title = new ArrayList<>();

    ArrayAdapter<String> arrayAdapter;
    TextView contact;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactList = findViewById(R.id.list_item);
        contact = findViewById(R.id.contact);
        viewData();
    }

    private void viewData() {
        DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
        Cursor cursor = databaseHelper.onView();
        if (cursor.getCount() == 0) {
            Toast.makeText(MainActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                arrayList.add(cursor.getString(0));
                phoneNumber.add(cursor.getString(1));
                email.add(cursor.getString(2));
                title.add(cursor.getString(3));

            }
        }
        arrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, arrayList);
        contactList.setAdapter(arrayAdapter);
        contactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String values = (String) contactList.getItemAtPosition(position);
                String number = (String) phoneNumber.get(position);
                String mail = email.get(position);
                String titleUser = title.get(position);
                Intent intent = new Intent(MainActivity.this, ItemActivity.class);
                intent.putExtra("Name", values);
                intent.putExtra("Number", number);
                intent.putExtra("Title", titleUser);
                intent.putExtra("Email", mail);
                startActivity(intent);
            }
        });
    }
}
