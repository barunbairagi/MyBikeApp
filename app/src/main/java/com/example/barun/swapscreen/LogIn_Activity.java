package com.example.barun.swapscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class LogIn_Activity extends AppCompatActivity {

    private EditText etUserId;
    private EditText etPassword;
    private Button btnLogIn;
    private String TAG ="MyActivity";
    private TextView SignUp;

    private UserLoginDBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        db = new UserLoginDBHandler(this);
        SignUp = (TextView)findViewById(R.id.tvSignUp);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSignUpScreenActivity();
            }


        });

        //Log.i(TAG, "In line 29 in File LogIn Activity.java");
        //btnLogIn = (Button)findViewById(R.id.btnLogIn);
        };
    private void openSignUpScreenActivity() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);

    }
        // Display all Users in LOG

       /* List<User> users = db.getAllContacts();
        for (User ur : users) {
            String log = "Id: " + ur.getUserId() + " ,User ID: " + ur.getPassword() + " ,Pasword: ";
            // Writing Contacts to log
            Log.d("User Id and Password: ", log);
        }
        */


/*

    private void inputValidator() {

        etUserId = (EditText) findViewById(R.id.editTextName);
        etPassword = (EditText)findViewById(R.id.editTextPassword);

        if(etUserId.getText().toString().length() == 0 || etPassword.getText().toString().length() == 0){

            Toast.makeText(getApplicationContext(),"Error in Input, Please re-enter..",Toast.LENGTH_SHORT).show();
            Log.i(TAG, "Error in Input..");
        }
        else {


            // Else allow in system
            User user = new User(etUserId.getText().toString(), etPassword.getText().toString());
            //db.addContact(user);
            Toast.makeText(getApplicationContext(),"Thanks User Functionality yet to Implement..",Toast.LENGTH_SHORT).show();
        }

    }

    private void validate(String strUserId, String strPassword ){

        if((strUserId == "Admin") || strPassword == "1234"){

            Intent intent = new Intent(LogIn_Activity.this, DashBoard.class);

        }
    }
*/
}
