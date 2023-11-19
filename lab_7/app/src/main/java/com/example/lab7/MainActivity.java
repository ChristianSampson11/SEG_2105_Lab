package com.example.lab7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText editTextFirstName;
    EditText editTextLastName;
    EditText editTextEmail;
    EditText editTextPassword;
    Button btnSubmit;
    TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        btnSubmit = findViewById(R.id.btnSubmit);
        textViewMessage = findViewById(R.id.textViewMessage);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmitClick(v);
            }
        });
    }

    public static boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public static boolean isValidLastName(String lastName) {
        return lastName.matches("[a-zA-Z]+");
    }

    public static boolean isValidPassword(String password) {
        return password.length() >= 6;
    }

    public static boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void onSubmitClick(View view) {
        String firstName = editTextFirstName.getText().toString();
        String lastName = editTextLastName.getText().toString();
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        if (isValidName(firstName) && isValidLastName(lastName) && isValidPassword(password) && isValidEmail(email)) {
            String message = String.format("Welcome, %s %s!\nEmail: %s\nPassword: %s", firstName,
                    lastName, email, password);
            textViewMessage.setText(message);
        } else if (!isValidName(firstName)){
            textViewMessage.setText("Invalid First Name");
        } else if (!isValidLastName(lastName)){
            textViewMessage.setText("Invalid Last Name");
        } else if (!isValidPassword(password)){
            textViewMessage.setText("Invalid Password");
        } else if (!isValidEmail(email)){
            textViewMessage.setText("Invalid Email");
        }
    }
}
