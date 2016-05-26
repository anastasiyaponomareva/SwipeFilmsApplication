package com.example.anastasiya.swipefilmsapplication;

import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import controller.UserFilmsController;
import entities.Film;
import entities.User;

public class MainActivity extends Activity {
    public EditText textBoxLogin;
    public EditText textBoxPassword;
    public Button buttonLogin;
    public Button buttonSignup;
    String username;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textBoxLogin =(EditText) findViewById(R.id.loginTextBox);
        textBoxPassword= (EditText) findViewById(R.id.passwordTextBox);
        buttonLogin=(Button)  findViewById(R.id.loginButton);
        buttonSignup=(Button) findViewById(R.id.signUpButton);

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username=textBoxLogin.getText().toString();
                password=textBoxPassword.getText().toString();

                // Force user to fill up the form
                if (username.equals("") && password.equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "Please complete the sign up form",
                            Toast.LENGTH_LONG).show();

                } else {
                   //TODO: dummy variable - replace it with registration in DB
                    boolean successfullySignedUp=true;

                    if (successfullySignedUp) {
                        // Show a simple Toast message upon successful registration
                        Toast.makeText(getApplicationContext(),
                                "Successfully Signed up, please log in.",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Sign up Error", Toast.LENGTH_LONG)
                                .show();
                    }

                }
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Retrieve the text entered from the EditText
                username=textBoxLogin.getText().toString();
                password=textBoxPassword.getText().toString();

                //TODO: check login, pw - interaction with DB
                //TODO: use controller to work with activities (now dummy)
                UserFilmsController userFilmsController  =
                        new UserFilmsController(new User("MyDummyUser", "FilmFan"));

                List<Film> films = new ArrayList<>();
                films.add(new Film("Hachiko",
                        "A college professor's bond with the abandoned dog he takes into his home.",
                        R.drawable.hachiko));
                userFilmsController.setFilmsList(films);
                //end of dummy

                if ( userFilmsController!= null) {
                   //open new activity
                    Intent intent = new Intent(
                            MainActivity.this,
                            CardViewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("userFilmsController", userFilmsController);
                    bundle.putString("activityTitle", "Randomly chosen films");
                    intent.putExtras(bundle);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),
                            "Successfully Logged in",
                            Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(
                            getApplicationContext(),
                            "No such user exist, please signup",
                            Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
