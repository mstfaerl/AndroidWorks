package com.example.simplefirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText name,surname;
    Button saveButton;
    DatabaseReference databaseReference;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.userName);
        surname = findViewById(R.id.userSurname);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = new User();
                user.setName(name.getText().toString());
                user.setSurname(surname.getText().toString());

                databaseReference = FirebaseDatabase.getInstance().getReference();
                String key = databaseReference.child("users").push().getKey();
                databaseReference.child("users/" + key).setValue(user);

                Toast.makeText(MainActivity.this,"Name : " + user.getName() + " Surname : " + user.getSurname() +
                        " is added",Toast.LENGTH_LONG).show();
            }
        });




    }

}
