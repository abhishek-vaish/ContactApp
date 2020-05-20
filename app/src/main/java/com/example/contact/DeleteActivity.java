package com.example.contact;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DeleteActivity extends AppCompatActivity {

    ArrayList<String> arrayList = new ArrayList<>(); //To store the data from the database
    AutoCompleteTextView delete;
    Button deleteBtn;

    /**
     * To create the database
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        ViewData();

        delete = findViewById(R.id.delete_auto);
        deleteBtn = findViewById(R.id.delete_contact);

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameToBeDelete = delete.getText().toString().trim();
                DatabaseHelper databaseHelper = new DatabaseHelper(DeleteActivity.this);
                if (databaseHelper.onDelete(nameToBeDelete)) {
                    Toast.makeText(DeleteActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DeleteActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    /***
     * To traverse the data from the database
     */

    private void ViewData() {
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        Cursor cursor = databaseHelper.onView();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                arrayList.add(cursor.getString(0));
            }
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, arrayList);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.delete_auto);
        autoCompleteTextView.setThreshold(4);
        autoCompleteTextView.setAdapter(arrayAdapter);
    }
}
