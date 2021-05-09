package com.example.barun.swapscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {


    private TextView alreadyAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        alreadyAccount = (TextView)findViewById(R.id.alreadyAcount);

        alreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAlreadySignInScreenActivity();
            }
        });

    };
    private void openAlreadySignInScreenActivity() {
        Intent intent = new Intent(this, LogIn_Activity.class);
        startActivity(intent);

    }
}

// ###########################



