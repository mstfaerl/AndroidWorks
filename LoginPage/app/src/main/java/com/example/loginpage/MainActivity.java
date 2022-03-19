package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.loginpage.ui.dashboard.DashboardFragment;
import com.example.loginpage.ui.dashboard.DashboardViewModel;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rellay1, rellay2;
    EditText txtUsername,txtPassword;
    Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                rellay1.setVisibility(View.VISIBLE);
                rellay2.setVisibility(View.VISIBLE);
            }
        };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        rellay2 = (RelativeLayout) findViewById(R.id.rellay2);

        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);

        handler.postDelayed(runnable, 2000);
    }

    public void loginAct(View view) {

        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();

        if(username.equals("Mustafa") && password.equals("Asd123")){
            startActivity(new Intent(getApplicationContext(), BottomActivity.class));
        }else if(username.equals("") && password.equals("")){
            System.out.println("Lütfen boş alanları giriniz!");
        }else{
            System.out.println("Username veya Password yanlış girdiniz. Lütfen tekrar deneyiniz.");
        }
    }
}
