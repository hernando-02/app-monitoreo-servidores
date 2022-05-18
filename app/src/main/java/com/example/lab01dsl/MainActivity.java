package com.example.lab01dsl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    // public static final String EXTRA_MESSAGE = "com.example.lab01dsl.MESSAGE";

    private EditText userName, password;
    private Button btnLogin;
    private ProgressBar progressBar;
    private String name, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.editTextUserName);
        password = (EditText) findViewById(R.id.editTextPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        progressBar = (ProgressBar) findViewById(R.id.progress_Bar);

        userName.setText("user");
        password.setText("user");

    }


    /** Called when the user taps the Login button */
    public void doLogin(View view){

        new LoginTask().execute(userName.getText().toString());

        name = userName.getText().toString();
        pass = password.getText().toString();


    }

    public void acceso(){

        if(name.equals("user") && pass.equals("user")){

            Toast.makeText(this, "Login successful", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Failed access", Toast.LENGTH_LONG).show();
        }
    }

    class LoginTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            btnLogin.setEnabled(false);
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return strings[0];
        }

        @Override
        protected void onPostExecute(String s) {
            progressBar.setVisibility(View.INVISIBLE);
            btnLogin.setEnabled(true);
            acceso();
        }
    }
}